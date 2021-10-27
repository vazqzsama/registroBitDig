package com.portal.app.dao;

import java.util.List;

import com.portal.app.dto.AfiliaBitacoraEcommerce;
import com.portal.app.dto.ResultsetCatalogosVigentes;
import com.portal.app.dto.ResultsetPaquetesVig;
import com.portal.app.dto.RsGetColoniaCP;
import com.portal.app.request.AfiliaEcommerceRequest;
import com.portal.app.request.AfiliacionRequest;
import com.portal.app.request.PaquetesRequest;

public interface InfoDao {

	public List<ResultsetPaquetesVig> getPaquetesLanding(PaquetesRequest request);
	public List<ResultsetCatalogosVigentes> getCatalogosActivosLanding(PaquetesRequest request);
	public List<RsGetColoniaCP> getColoniaCP(AfiliacionRequest request);
	public Boolean verificaCorreo(AfiliaEcommerceRequest request);
	public AfiliaBitacoraEcommerce getByPhone(final String numeroTel);
	public void saveOrUpdateAfiliaBitacoraEcommerce(AfiliaEcommerceRequest request);
	
}
