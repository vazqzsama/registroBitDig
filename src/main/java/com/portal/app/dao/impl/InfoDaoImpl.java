package com.portal.app.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.portal.app.dao.InfoDao;
import com.portal.app.dto.AfiliaBitacoraEcommerce;
import com.portal.app.dto.ResultsetCatalogosVigentes;
import com.portal.app.dto.ResultsetPaquetesVig;
import com.portal.app.dto.RsGetColoniaCP;
import com.portal.app.request.AfiliaEcommerceRequest;
import com.portal.app.request.AfiliacionRequest;
import com.portal.app.request.PaquetesRequest;

@Repository
@Transactional(value = "transactionManager", readOnly=true,rollbackFor = Exception.class)
public class InfoDaoImpl implements InfoDao {

	private static final Logger log = LoggerFactory.getLogger(InfoDaoImpl.class);
	
	@Autowired
	private SessionFactory session;
	
	@SuppressWarnings("unchecked")
	public List<ResultsetPaquetesVig> getPaquetesLanding(PaquetesRequest request) {
		return session.getCurrentSession().getNamedQuery("P_GET_PAQUETES_LANDING").list();
	}

	@SuppressWarnings("unchecked")
	public List<ResultsetCatalogosVigentes> getCatalogosActivosLanding(PaquetesRequest request) {
		return session.getCurrentSession().getNamedQuery("P_GET_CATALOGOS_LANDING").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RsGetColoniaCP> getColoniaCP(AfiliacionRequest request) {
		log.debug("Metodo getColoniaCP : " + new Gson().toJson(request));
		List<RsGetColoniaCP> resultset = new ArrayList<RsGetColoniaCP>();		
		resultset = session.getCurrentSession().getNamedQuery("P_GET_COLONIA_CP")
		.setParameter("codPostStr", request.getAfiliacion().getCodPostStr()).list();

		return resultset;
	}
	
	@Override
	public Boolean verificaCorreo(AfiliaEcommerceRequest request) {
		String query = " SELECT PKG_REC_AFL_SIT.F_VALIDACORREO('"+request.getCorreoVal()+"') FROM DUAL ";
		BigDecimal result = (BigDecimal) session.getCurrentSession().createSQLQuery(query).uniqueResult();
		
		log.info("Verificar correo duplicado******* " + new Gson().toJson(result));
		if(result!=null && result.intValue()>0 ) return true;
		else return false;
	}
	
	@Override
	public AfiliaBitacoraEcommerce getByPhone(final String numeroTel) {
		AfiliaBitacoraEcommerce registro = null;
		if (Objects.nonNull(numeroTel)) {
			final Query query = session.getCurrentSession()
					.createQuery("from AfiliaBitacoraEcommerce where abeTelefonoN = :numeroTel");
			query.setParameter("numeroTel", numeroTel);
			registro = (AfiliaBitacoraEcommerce) query.uniqueResult();
		}
		return registro;
	}
	
	@Override
	@Transactional(readOnly = false)
	public void saveOrUpdateAfiliaBitacoraEcommerce(AfiliaEcommerceRequest request) {
		log.debug("request: " + new Gson().toJson(request));
		AfiliaBitacoraEcommerce saveBitacoraEcommerce = request.getAfiliaBitacoraEcommerce();
		saveBitacoraEcommerce.setAbeFaltaDt(new Date());
		saveBitacoraEcommerce.setAbeFmodDt(new Date());
		saveBitacoraEcommerce.setAbeEstatusStr("A");
		saveBitacoraEcommerce.setAbeEstatusRegStr("AFI");
		
		session.getCurrentSession().saveOrUpdate(saveBitacoraEcommerce);
		log.debug(" Guardar bitacora" + new Gson().toJson(saveBitacoraEcommerce));
	}
	
} 

 