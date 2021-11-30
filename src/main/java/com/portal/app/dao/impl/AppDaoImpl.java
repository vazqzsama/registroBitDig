package com.portal.app.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.portal.app.api.ApiController;
import com.portal.app.client.LiberacionClient;
import com.portal.app.dao.AppDao;
import com.portal.app.dto.AfilRegistrar;
import com.portal.app.dto.AfiliaBitacora;
import com.portal.app.dto.BitacoraDigital;
import com.portal.app.dto.PsPedTmk;
import com.portal.app.dto.PsSocios;
import com.portal.app.dto.RsGetPaqueteAmer;
import com.portal.app.request.AfiliacionRequest;
import com.portal.app.request.AppRequest;
import com.portal.app.request.ParametrosPendientes;
import com.portal.app.request.ReactivarRequest;
import com.portal.app.request.UpdateSocioRequest;
import com.portal.app.response.AppResponse;
import com.portal.app.service.impl.SmsProcessor;
import com.portal.app.util.Constants;
import com.priceshoes.email.MailSender;

@Repository
@Transactional(readOnly=true,rollbackFor = Exception.class)
public class AppDaoImpl implements AppDao {
	
	private static final Logger log = LoggerFactory.getLogger(ApiController.class);
	
	@Autowired
	private SessionFactory session;
	@Autowired
	private LiberacionClient libClient;
	@Autowired
	private SmsProcessor jobSms;
	@Value("${sms.url.cred}")
	private String urlCredencial;
	
	private List<String> correosLiberados;
	
	@Override
	public AppResponse test(AppRequest request) {
		AppResponse response = new AppResponse();
		
		log.debug("test dao " + new Gson().toJson(request));
		session.getCurrentSession().createSQLQuery(" SELECT 1 FROM DUAL").uniqueResult();
		response.setMessage("Conexión con BD correcta");
		return response;
	}

	@Override
	public BitacoraDigital searchBitacora(String idSocio) {
		return (BitacoraDigital) session.getCurrentSession()
			.createCriteria(BitacoraDigital.class)
			.add(Restrictions.eq("numSocio", idSocio))
			.uniqueResult();
	}
	
	@Override
	@Transactional(readOnly = false)
	public BitacoraDigital createBitacora(BitacoraDigital bit) {
		session.getCurrentSession().save(bit);
		return bit;
	}
	
	@Override
	@Transactional(readOnly = false)
	public BitacoraDigital updateBitacora(BitacoraDigital bit) {		
		session.getCurrentSession().update(bit);
		return bit;
	}
	
	@Override
	public String getReferenciaPedido(String tipo) {
		return (String) session.getCurrentSession()
		.createSQLQuery(" SELECT PKG_AFILIACION_CORE.F_GET_REFERENCIA('"+tipo+"') FROM DUAL ")
		.uniqueResult();
	}

	@Override
	public PsPedTmk getInfoPedido(Long tiCveN, Long ptNumN, String soId) {
		return (PsPedTmk) session.getCurrentSession().createCriteria(PsPedTmk.class)
				.add(Restrictions.eq("numPedid", ptNumN))
				.add(Restrictions.eq("tiCveN", tiCveN))
				.add(Restrictions.eq("numSocio", soId))
				.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean searchRegistro(String email, String idSocio,String nombre) {
		correosLiberados = new ArrayList<String>();
		Disjunction ors = Restrictions.disjunction();
		if (!email.isEmpty())
			ors.add(Restrictions.eq("email", email));
		if (!idSocio.isEmpty())
			ors.add(Restrictions.eq("numSocio", idSocio));
		ors.add(Restrictions.eq("nombre", nombre).ignoreCase());
		
		for (BitacoraDigital b : (List<BitacoraDigital>) session.getCurrentSession()
				.createCriteria(BitacoraDigital.class).add(Restrictions.or(ors)).list()) {
			PsPedTmk pedido = getInfoPedido(b.getCveTienda(),b.getNumPedido(),b.getNumSocio());
			if (Objects.nonNull(pedido)) {
				if (pedido.getStatus().equals("C")) {
					if (liberarCorreo(b))
						log.info(String.format("El correo %s ha sido liberado", email));
				} else
					return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean liberarCorreo(BitacoraDigital bit) {
		if(!correosLiberados.contains(bit.getEmail().toLowerCase())) {
			try {
				if (!libClient.send(bit).getStatusCode().equals(HttpStatus.OK))
            		log.error(String.format("El correo %s no se ha podido liberar", bit.getEmail()));
				correosLiberados.add(bit.getEmail().toLowerCase());
				return true;
			} catch (Exception e) {
				log.error(String.format("El correo %s no se ha podido liberar", e.getLocalizedMessage()));
				return false;
			}
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AfilRegistrar> getPendientes(ParametrosPendientes params) {
		return session.getCurrentSession().getNamedQuery("P_GET_AFIL_PEND")
				.setParameter("correos", concatLista(params.getCorreos()) )
				.setParameter("idsocios", concatLista(params.getIdSocio()) )
				.setParameter("finicio", params.getFechaInicio())
				.setParameter("fin", params.getFechaFin())
				.list();
	}
	
	private String concatLista(List<String> lista) {
		if (lista.isEmpty())
			return null;
		StringBuilder r = new StringBuilder("'");
		for (int i = 0; i < lista.size(); i++) {
			r.append(lista.get(i));
			if (i == lista.size()-1)
				r.append("'");
			else
				r.append("','");
		}
		return r.toString();
	}	

	@Override
	public PsSocios searchSocioByRfc(String rfc) {
		return (PsSocios) session.getCurrentSession().createCriteria(PsSocios.class)
		.add(Restrictions.eq("soSoRfcStr", rfc.trim())).uniqueResult();
	}
	
	@Override
	@Transactional(readOnly = false)
	public AfiliaBitacora reactivarSocio(ReactivarRequest request) {
		PsSocios socio = (PsSocios) session.getCurrentSession().createCriteria(PsSocios.class)
		.add(Restrictions.eq("soSoRfcStr", request.getRfcPrice()))
		.add(Restrictions.eq("soIdStr", request.getIdSocio())).uniqueResult();
		
		socio.setSoTipoStr("R");
		socio.setSoFregDt(new Date());
		socio.setSoSoRfcStr(request.getRfcPrice());
		session.getCurrentSession().update(socio);
		
		request.getAfiliaBitacora().setSoIdStr(request.getIdSocio());
		request.getAfiliaBitacora().setCodigoVerificacion(new Random().nextInt(100000)+"");
		request.getAfiliaBitacora().setSoNombreStr( request.getSocio().getSoNomStr()+" "
				+ request.getSocio().getSoApatStr()+" "+request.getSocio().getSoAmatStr());
		session.getCurrentSession().save(request.getAfiliaBitacora());
		try {
			jobSms.enviarMensaje(request.getAfiliaBitacora());
		} catch (Exception e) {
			log.error("Error envio SMS: "+e.getLocalizedMessage());
		}
		try {
			sendCorreoReactivacion(request);
		} catch (Exception e) {
			log.error("Error envio correo: "+e.getLocalizedMessage());
		}
		return request.getAfiliaBitacora();
	}
	
	@Override
	@Transactional(readOnly = false)
	public void updateSocio(UpdateSocioRequest rq) {
		PsSocios socio = (PsSocios) session.getCurrentSession().createCriteria(PsSocios.class)
		.add(Restrictions.eq("soIdStr", rq.getSoIdStr())).uniqueResult();
		Date fecha = null;
		try {
			fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rq.getFecNacDt());
		} catch (Exception e) {}
		
		socio.setSoNombreStr(rq.getSoNomStr());
		socio.setSoPaternoStr(rq.getSoApatStr());
		socio.setSoMaternoStr(rq.getSoAmatStr());
		socio.setSoEmailStr(rq.getSoEmailStr());
		if (Objects.nonNull(fecha))
			socio.setSoFnacDt(fecha);
		if (Objects.nonNull(rq.getSoCalle()))
			socio.setSoCalleStr(rq.getSoCalle());
		if (Objects.nonNull(rq.getSoNumExt()))
			socio.setSoNumStr(rq.getSoNumExt());
		if (Objects.nonNull(rq.getSoNumInt()))
			socio.setSoInteriorStr(rq.getSoNumInt());
		socio.setSoCdStr(rq.getSoCdStr());
		socio.setMuCveN(rq.getSoMunN());
		socio.setEstado(rq.getSoEdoN());
		socio.setSoTel4Str(rq.getSoCelStr());
		socio.setSoSoRfcStr(rq.getSoRfc());
		
		session.getCurrentSession().update(socio);
	}
	
	@Override
	public RsGetPaqueteAmer getPaqueteAmer(AfiliacionRequest request) {
		log.debug("Metodo getPaqueteAmer : " + new Gson().toJson(request));		
		return  (RsGetPaqueteAmer) session.getCurrentSession().getNamedQuery("P_GET_PAQUETE_AMER")
		.setParameter("listaCatalogos", request.getListaCatalogos()).uniqueResult();

	}

	@Override
	@Transactional(readOnly=false)
	public void actualizarEnviado(Long id) {
		Criteria crit = session.getCurrentSession().createCriteria(AfiliaBitacora.class);
		crit.add(Restrictions.eq("id", id));
		AfiliaBitacora bit = (AfiliaBitacora) crit.uniqueResult();
		
		if( bit != null )
			bit.setSmsEnvN(1);
	}
	
	public boolean enviarSMS(AfiliaBitacora afiliaBitacora) {
		log.info("Enviando SMS " + new Gson().toJson(afiliaBitacora));
		boolean enviado = jobSms.enviarMensaje(afiliaBitacora);
		if(  enviado ) {
			log.info(" SMS enviado ");
			actualizarEnviado(afiliaBitacora.getId());
		} else
			log.error(" SMS NO enviado ");
		
		return enviado;
	}
	
	public void sendCorreoReactivacion(ReactivarRequest request) {
		try {
			if(request.getSocio().getSoEmailStr()!=null &&
					!request.getSocio().getSoEmailStr().equalsIgnoreCase(Constants.CORREO_DEFAULT)) {
				log.info("Enviar correo a " + request.getSocio().getSoEmailStr());
				
				List<String> destinatarios= new ArrayList<String>();
				destinatarios.add(request.getSocio().getSoEmailStr());
				String mailBody = getMailBody(request.getAfiliaBitacora());
				
				MailSender mailSender = new MailSender(MailSender.ENVIRONMENT_PRODUCCION, null);
				mailSender.sendMail(destinatarios,"Registro Nuevo Socio",MailSender.HEADER_STYLE_2,
									mailBody,MailSender.NO_FOOTER,"");
			}	
		} catch (Exception e) {}
	}
	
	private String getMailBody(AfiliaBitacora afiliaBitacora) {
		StringBuilder text = new StringBuilder();
		
		String data = "{id:"+afiliaBitacora.getId()+"}";
		String encodedData = new String(Base64.encodeBase64(data.getBytes()));
		
		text.append(" <p style='text-indent: 15px; text-align: justify;'><strong>¡Bienvenido! </strong> Ya eres un socio Price Shoes."); 
		text.append(" A continuación se anexa la información de registro:</p> ");
		
		text.append(" <table style='border-collapse: collapse;'> ");
		text.append(" <tr> ");
		text.append(" <td style='border: solid 1px black; font-weight: bold;'>Nombre:</td> ");
		text.append(" <td style='border: solid 1px black;'>"+afiliaBitacora.getSoNombreStr()+"</td> ");
		text.append(" </tr> ");
		
		text.append(" <tr> ");
		text.append(" <td style='border: solid 1px black; font-weight: bold;'>No. de socio:</td> ");
		text.append(" <td style='border: solid 1px black;'>"+afiliaBitacora.getSoIdStr()+"</td> ");
		text.append(" </tr> ");
		
		text.append(" </table> ");
		text.append(" <p>Puede consultar su credencial virtual en el siguiente enlace: ");
		text.append(" <a href='"+urlCredencial+encodedData+"' target='_blank'>Credencial Virtual</a>");
		text.append(" </p> ");
		text.append(" <p>Si tiene alguna duda acerca de su registro, por favor consúltelo en su tienda Price Shoes más cercana.");
		text.append(" En su primera visita, no olvide presentar identificación oficial y comprobante de domicilio (no mayor a 3 meses). ");
		text.append(" </p>");
		text.append(" <ul>");
		text.append(" <li>La credencial virtual es provisional, deberá acudir a la tienda más cercana para finalizar el trámite,");
		text.append(" presentando identificación oficial (INE, licencia, pasaporte vigente) y comprobante de domicilio");
		text.append(" (no mayor a tres meses). Una vez realizada la entrega, le personalizarán su membresía, misma que le ");
		text.append(" darán impresa en formato plástico.</li>");
		text.append(" <li>La vigencía de la credencial virtual será de 30 días.</li>");
		text.append(" <li>Una vez que haya finalizado el trámite usted recibirá vía correo electrónico su membresía digitalizada, ");
		text.append(" que podrá utilizar en cualquier compra en tiendas y bodegas Price Shoes. </li>");
		text.append(" </ul>");
		text.append(" <p style='font-size: 0.95em;' >Por favor no responda a este correo ya que es una cuenta <strong>NO MONITOREADA.</strong>"); 
		text.append(" </p> ");
		text.append(" </div> ");
		
		return text.toString();
	}
	
}


 