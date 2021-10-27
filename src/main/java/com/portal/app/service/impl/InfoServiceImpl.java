package com.portal.app.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.portal.app.dao.InfoDao;
import com.portal.app.dto.AfiliaBitacoraEcommerce;
import com.portal.app.dto.ResultsetCatalogosVigentes;
import com.portal.app.dto.ResultsetPaquetesVig;
import com.portal.app.dto.RsGetColoniaCP;
import com.portal.app.request.AfiliaEcommerceRequest;
import com.portal.app.request.AfiliacionRequest;
import com.portal.app.request.PaquetesRequest;
import com.portal.app.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(InfoServiceImpl.class);
	
	@Autowired
	private InfoDao dao;
	
	@Override
	public List<ResultsetPaquetesVig> getPaquetesLanding(PaquetesRequest request) {
		return dao.getPaquetesLanding(request);
	}

	@Override
	public List<ResultsetCatalogosVigentes> getCatalogosActivosLanding(PaquetesRequest request) {
		return dao.getCatalogosActivosLanding(request);
	}
	
	@Override
	public List<RsGetColoniaCP> getColoniaCP(AfiliacionRequest request) {
		return dao.getColoniaCP(request);
	}
	
	@Override
	public Boolean verificaCorreo(AfiliaEcommerceRequest request) {
		return dao.verificaCorreo(request);
	}

	@Override
	public AfiliaBitacoraEcommerce getByPhone(String numeroTel) {
		return dao.getByPhone(numeroTel);
	}
	
	@Override
	public void saveOrUpdateAfiliaBitacoraEcommerce(AfiliaEcommerceRequest request) {
		log.info("saveOrUpdateAfiliaBitacoraEcommerce: "+new Gson().toJson(request));
		dao.saveOrUpdateAfiliaBitacoraEcommerce(request);
	}

}
 