package com.portal.app.dao.impl;

import java.io.UnsupportedEncodingException;
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
import com.portal.app.dto.Store;
import com.portal.app.dto.WseFotosCat;
import com.portal.app.dto.WseUpdateFotos;
import com.portal.app.request.AfiliacionRequest;
import com.portal.app.request.AppRequest;
import com.portal.app.request.ParametrosPendientes;
import com.portal.app.request.ReactivarRequest;
import com.portal.app.request.UpdateSocioRequest;
import com.portal.app.response.AppResponse;
import com.portal.app.service.impl.SmsProcessor;
import com.portal.app.util.Constants;
import com.portal.app.util.SshConexion;
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
	@Value("${ftp.url}")
	private String ftpUrl;
	@Value("${ftp.user}")
	private String ftpUser;
	@Value("${ftp.pass}")
	private String ftpPass;
	@Value("${ftp.basepath}")
	private String ftpBasepath;
	
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

	@SuppressWarnings("unchecked")
	@Override
	public List<PsSocios> searchSocioByRfc(String rfc) {
		return (List<PsSocios>) session.getCurrentSession().createCriteria(PsSocios.class)
		.add(Restrictions.eq("soSoRfcStr", rfc.trim())).list();
	}
	
	@Override
	@Transactional(readOnly = false)
	public AfiliaBitacora reactivarSocio(ReactivarRequest request) {
		log.debug("AppDao.reactivarSocio: "+new Gson().toJson(request));
		PsSocios socio = (PsSocios) session.getCurrentSession().createCriteria(PsSocios.class)
			//.add(Restrictions.eq("soSoRfcStr", request.getRfcPrice()))
			.add(Restrictions.eq("soIdStr", request.getIdSocio())).uniqueResult();
		log.debug(new Gson().toJson(socio));
		/* Datos personales Socio */
		try {
			if (this.testExist(socio.getSoNombreStr().toLowerCase(), request.getSocio().getSoNomStr().toLowerCase()))
				socio.setSoNombreStr(request.getSocio().getSoNomStr());
		} catch (Exception e) {
			if(Objects.nonNull(request.getSocio().getSoNomStr())) 
				socio.setSoNombreStr(request.getSocio().getSoNomStr());
		}
		try {
			if (this.testExist(socio.getSoPaternoStr().toLowerCase(), request.getSocio().getSoApatStr().toLowerCase()))
				socio.setSoPaternoStr(request.getSocio().getSoApatStr());
		} catch (Exception e) {
			if(Objects.nonNull(request.getSocio().getSoApatStr())) 
				socio.setSoPaternoStr(request.getSocio().getSoApatStr());
		}
		try {
			if (this.testExist(socio.getSoMaternoStr().toLowerCase(), request.getSocio().getSoAmatStr().toLowerCase()))
			socio.setSoMaternoStr(request.getSocio().getSoAmatStr());
		} catch (Exception e) {
			if(Objects.nonNull(request.getSocio().getSoAmatStr())) 
				socio.setSoMaternoStr(request.getSocio().getSoAmatStr());
		}
		try {
			if (this.testExist(socio.getSoEmailStr().toLowerCase(), request.getSocio().getSoEmailStr().toLowerCase()))
				socio.setSoEmailStr(request.getSocio().getSoEmailStr());
		} catch (Exception e) {
			if(Objects.nonNull(request.getSocio().getSoEmailStr())) 
				socio.setSoEmailStr(request.getSocio().getSoEmailStr());
		}
		try {
			if (this.testExist(socio.getSoTel4Str().toLowerCase(), request.getSocio().getSoCelStr().toLowerCase()))
				socio.setSoTel4Str(request.getSocio().getSoCelStr());
		/* Datos personales Socio */
		/* Direccion Socio */
		} catch (Exception e) {
			if(Objects.nonNull(request.getSocio().getSoCelStr())) 
				socio.setSoTel4Str(request.getSocio().getSoCelStr());
		}
		try {
			if (this.testExist(socio.getSoCalleStr().toLowerCase(), request.getSocio().getSoCalleStr().toLowerCase()))
				socio.setSoCalleStr(request.getSocio().getSoCalleStr());
		} catch (Exception e) {
			if(Objects.nonNull(request.getSocio().getSoCalleStr())) 
				socio.setSoCalleStr(request.getSocio().getSoCalleStr());
		}
		try {
			if (this.testExist(socio.getSoColStr().toLowerCase(), request.getSocio().getSoColStr().toLowerCase()))
				socio.setSoColStr(request.getSocio().getSoColStr());
		} catch (Exception e) {
			if(Objects.nonNull(request.getSocio().getSoColStr())) 
				socio.setSoColStr(request.getSocio().getSoColStr());
		}
		try {
			if (this.testExist(socio.getSoNumStr().toLowerCase(), request.getSocio().getSoNumStr().toLowerCase()))
				socio.setSoNumStr(request.getSocio().getSoNumStr());
		} catch (Exception e) {
			if(Objects.nonNull(request.getSocio().getSoNumStr())) 
				socio.setSoNumStr(request.getSocio().getSoNumStr());
		}
		try {
			if (this.testExist(socio.getSoNumintStr().toLowerCase(), request.getSocio().getSoInteriorStr().toLowerCase()))
				socio.setSoNumintStr(request.getSocio().getSoInteriorStr());
		} catch (Exception e) {
			if(Objects.nonNull(request.getSocio().getSoInteriorStr())) 
				socio.setSoNumintStr(request.getSocio().getSoInteriorStr());
		}
		try {
			if (this.testExist(socio.getSoCpStr().toLowerCase(), request.getSocio().getSoCpStr().toLowerCase()))
				socio.setSoCpStr(request.getSocio().getSoCpStr());
		} catch (Exception e) {
			if(Objects.nonNull(request.getSocio().getSoCpStr())) 
				socio.setSoCpStr(request.getSocio().getSoCpStr());
		}
		try {
			if (this.testExist(socio.getSoCdStr().toLowerCase(), request.getSocio().getSoCdStr().toLowerCase()))
				socio.setSoCdStr(request.getSocio().getSoCdStr());
		} catch (Exception e) {
			if(Objects.nonNull(request.getSocio().getSoCdStr())) 
				socio.setSoCdStr(request.getSocio().getSoCdStr());
		}
		try {
			if (this.testExist(socio.getMuCveN(), request.getSocio().getMuCveN().longValue()))
				socio.setMuCveN(request.getSocio().getMuCveN().longValue());
		} catch (Exception e) {
			if(Objects.nonNull(request.getSocio().getMuCveN())) 
				socio.setMuCveN(request.getSocio().getMuCveN().longValue());
		}
		try {
			if (this.testExist(socio.getEstado(), request.getSocio().getEdCveN().longValue()))
				socio.setEstado(request.getSocio().getEdCveN().longValue());
		} catch (Exception e) {
			if(Objects.nonNull(request.getSocio().getEdCveN())) 
				socio.setEstado(request.getSocio().getEdCveN().longValue());
		}
		try {
			if (this.testExist(socio.getPais(),request.getSocio().getPaCveN().longValue()))
				socio.setPais(request.getSocio().getPaCveN().longValue());
		/* Direccion Socio */
		} catch (Exception e) {
			if(Objects.nonNull(request.getSocio().getPaCveN())) 
				socio.setPais(request.getSocio().getPaCveN().longValue());
		}
		try {
			if (this.testExist(socio.getSoSoRfcStr(), request.getRfcPrice()))
				socio.setSoSoRfcStr(request.getRfcPrice());
		} catch (Exception e) {
			if(Objects.nonNull(request.getRfcPrice())) 
				socio.setSoSoRfcStr(request.getRfcPrice());
		}
		socio.setSoTipoStr("N");
		socio.setSoFregDt(new Date());
		log.debug("SocioUPDATE: "+new Gson().toJson(socio));
		session.getCurrentSession().update(socio);
		
		request.getAfiliaBitacora().setSoIdStr(request.getIdSocio());
		request.getAfiliaBitacora().setFechaRegistro(new Date());
		request.getAfiliaBitacora().setEstatus("R");
		request.getAfiliaBitacora().setCodigoVerificacion(new Random().nextInt(100000)+"");
		request.getAfiliaBitacora().setSoNombreStr( request.getSocio().getSoNomStr()+" "
				+ request.getSocio().getSoApatStr()+" "+request.getSocio().getSoAmatStr());
		request.getAfiliaBitacora().setSmsEnvN(0);
		request.getAfiliaBitacora().setIdRenglon(0L);
		
	    try { // Convertir Imagen del Socio
	    	if (!request.getSocio().getSoFotoStr().isEmpty())
	    		this.updateFotosSocio(request,2L);
	    } catch (Exception e) {
	    	log.info(e.getMessage());
			log.info("Error al Decodificar Imagen del socio");
	    }
	    try { // Convertir Imagen de Comprobante de Domicilio
	    	if (!request.getSocio().getSoCompDomStr().isEmpty())
	    		this.updateFotosSocio(request,1L);
	    } catch (Exception e) {
			log.error("Error al Decodificar Comprobante de domicilio:"+e.getLocalizedMessage());
	    }
		try {
			if(jobSms.enviarMensajeConfirmacion(request.getAfiliaBitacora()))//if(jobSms.enviarMensaje(request.getAfiliaBitacora()))
				request.getAfiliaBitacora().setSmsEnvN(1);
		} catch (Exception e) {
			log.error("Error envio SMS: "+e.getLocalizedMessage());
		}
		try {
			sendCorreoReactivacion(request);
		} catch (Exception e) {
			log.error("Error envio correo: "+e.getLocalizedMessage());
		}
		session.getCurrentSession().save(request.getAfiliaBitacora());
		return request.getAfiliaBitacora();
	}
	
	private boolean testExist(Object p1, Object p2) {
		if (Objects.nonNull(p1) && Objects.nonNull(p2)) {
			if (p1 instanceof String && p2 instanceof String)
		        return !p1.equals(p2);
			else if (p1 instanceof Integer && p2 instanceof Integer)
				return p1 != p2;
			else if (p1 instanceof Long && p2 instanceof Long)
				return p1 != p2;
			else if (p1 instanceof Date && p2 instanceof Date)
				return p1 != p2;
			else if (p1 instanceof Double && p2 instanceof Double)
				return p1 != p2;
			else {
				log.info("Existen parametros pero no estan mapeado el tipo de dato: (p1:"
							+p1.getClass()+") | (p2:"+p2.getClass()+")");
				return false;
			}
		} else
			return false;
	}
	
	@Override
	@Transactional(readOnly = false)
	public void updateSocio(UpdateSocioRequest rq) {
		Objects.requireNonNull(rq.getSoIdStr(), "El número de socio es un dato requerido");
		Objects.requireNonNull(rq.getTiCveN(), "El número de tienda es un dato requerido");
		
		Store dbLink = (Store) session.getCurrentSession().getNamedQuery("GET_DBLINK").setParameter("tienda", rq.getTiCveN()).uniqueResult();
		log.info(new Gson().toJson(dbLink));
		StringBuilder updStr = new StringBuilder("UPDATE PS_SOCIOS@").append(dbLink.getValue())
				.append(" SET SO_VALIDADO_STR = ")
				.append(Objects.nonNull(rq.getIsCelVerif())?(rq.getIsCelVerif()?"'Y' ":"'N' "):"'N' ");
		log.info(new Gson().toJson(rq));
		if (Objects.nonNull(rq.getSoNomStr()))
			updStr.append(",SO_NOM_STR = '").append(rq.getSoNomStr()).append("' ");
		if (Objects.nonNull(rq.getSoApatStr()))
			updStr.append(",SO_APAT_STR = '").append(rq.getSoApatStr()).append("' ");
		if (Objects.nonNull(rq.getSoAmatStr()))
			updStr.append(",SO_AMAT_STR = '").append(rq.getSoAmatStr()).append("' ");
		if (Objects.nonNull(rq.getSoCalle()))
			updStr.append(",SO_CALLE_STR = '").append(rq.getSoCalle()).append("' ");
		if (Objects.nonNull(rq.getSoNumExt()))
			updStr.append(",SO_NUM_STR = '").append(rq.getSoNumExt()).append("' ");
		if (Objects.nonNull(rq.getSoColStr()))
			updStr.append(",SO_COL_STR = '").append(rq.getSoColStr()).append("' ");
		if (Objects.nonNull(rq.getSoMunN()))
			updStr.append(",MU_CVE_N = '").append(rq.getSoMunN()).append("' ");
		if (Objects.nonNull(rq.getSoCdStr()))
			updStr.append(",SO_CD_STR = '").append(rq.getSoCdStr()).append("' ");
		if (Objects.nonNull(rq.getSoCpStr()))
			updStr.append(",SO_CP_STR = '").append(rq.getSoCpStr()).append("' ");
		if (Objects.nonNull(rq.getSoEmailStr()))
			updStr.append(",SO_EMAIL_STR = '").append(rq.getSoEmailStr()).append("' ");
		if (Objects.nonNull(rq.getReferencias()))
			updStr.append(",SO_REF_STR = '").append(rq.getReferencias()).append("' ");
		if (Objects.nonNull(rq.getSoRfcStr()))
			updStr.append(",SO_SORFC_STR = '").append(rq.getSoRfcStr()).append("' ");
		if (Objects.nonNull(rq.getFecNacDt()))
			updStr.append(",SO_FNAC_DT = TO_DATE('").append(rq.getFecNacDt()).append("','DD/MM/RRRR') ");
		if (Objects.nonNull(rq.getSoSexoStr()))
			updStr.append(",SO_SEXO_STR = '").append(rq.getSoSexoStr()).append("' ");	
		
		updStr.append("WHERE SO_ID_STR = '").append(rq.getSoIdStr()).append("' ");
		log.info(updStr.toString());
		session.getCurrentSession().createSQLQuery(updStr.toString()).executeUpdate();
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

	@Transactional(readOnly = false)
	public void updateFotosSocio(ReactivarRequest request,Long tipo) {
		try {
			String fotoByTipo = (tipo == 1 ? request.getSocio().getSoCompDomStr() : request.getSocio().getSoFotoStr()); 
			WseUpdateFotos reg = new WseUpdateFotos(request.getIdSocio(), request.getSocio().getTiCveN().longValue(), tipo,
					java.util.Base64.getDecoder().decode(new String(fotoByTipo.substring(fotoByTipo.indexOf(",") + 1)).getBytes("UTF-8")));
			session.getCurrentSession().save(reg);
			
			WseFotosCat fotoReg = new WseFotosCat(reg.getId());
			session.getCurrentSession().save(fotoReg);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void updateComprobante(String socio,Long tipo,Long tienda,String foto) {
		try {
			WseUpdateFotos reg = new WseUpdateFotos(socio, tienda, tipo,
					java.util.Base64.getDecoder().decode(new String(foto.substring(foto.indexOf(",") + 1)).getBytes("UTF-8")));
			session.getCurrentSession().save(reg);
			
			WseFotosCat fotoReg = new WseFotosCat(reg.getId());
			session.getCurrentSession().save(fotoReg);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteSocioFoto(String idSocio) {
		try {
			SshConexion.listFolderStructure(ftpUser, ftpPass, ftpUrl, 22, "rm ".concat(ftpBasepath).concat(idSocio).concat(".jpg"));
			log.info("Foto eliminada exitosamente del socio con id: "+idSocio);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void testFotos(ParametrosPendientes rq) {
		
	}

	@Override
	public void nominasMerida(Long nomina) {
		session.getCurrentSession().createSQLQuery("INSERT INTO PS_EJECUTIVO_SOC@LRCORPPRICE(TI_CVE_N, MEDATEN_CVE_N, NO_NOMINA,"
				+ " EJ_EST_STR) VALUES (101, 6, "+nomina+", 'A')").executeUpdate();
	}
	
}


 


