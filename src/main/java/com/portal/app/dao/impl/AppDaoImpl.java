package com.portal.app.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.portal.app.client.LiberacionClient;
import com.portal.app.dao.AppDao;
import com.portal.app.dto.AfilRegistrar;
import com.portal.app.dto.BitacoraDigital;
import com.portal.app.dto.PsPedTmk;
import com.portal.app.dto.PsSocios;
import com.portal.app.request.AppRequest;
import com.portal.app.request.ParametrosPendientes;
import com.portal.app.request.ReactivarRequest;
import com.portal.app.response.AppResponse;

@Repository
@Transactional(readOnly=true,rollbackFor = Exception.class)
public class AppDaoImpl implements AppDao {
	
	private static final Logger log = LoggerFactory.getLogger(AppDaoImpl.class);
	
	@Autowired
	private SessionFactory session;
	@Autowired
	private LiberacionClient libClient;
	
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
	public void reactivarSocio(ReactivarRequest request) {
		PsSocios socio = (PsSocios) session.getCurrentSession().createCriteria(PsSocios.class)
		.add(Restrictions.eq("soSoRfcStr", request.getRfcPrice()))
		.add(Restrictions.eq("soIdStr", request.getIdSocio())).uniqueResult();
		
		socio.setSoTipoStr("R");
		socio.setSoFregDt(new Date());
		socio.setSoSoRfcStr(request.getRfcPrice());
		session.getCurrentSession().update(socio);
	}
	
}
