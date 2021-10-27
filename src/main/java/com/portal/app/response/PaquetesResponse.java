package com.portal.app.response;

import java.util.List;

import com.portal.app.dto.ResultsetCatalogosVigentes;
import com.portal.app.dto.ResultsetPaquetesVig;

public class PaquetesResponse extends Response
{
	private static final long serialVersionUID = 1L;
	private List<ResultsetCatalogosVigentes>	catalogos;
	private String								urlFotoSocio;
	private List<ResultsetPaquetesVig>			paquetes;
	
	public List<ResultsetCatalogosVigentes> getCatalogos() {
		return catalogos;
	}
	public void setCatalogos(List<ResultsetCatalogosVigentes> catalogos) {
		this.catalogos = catalogos;
	}
	public String getUrlFotoSocio() {
		return urlFotoSocio;
	}
	public void setUrlFotoSocio(String urlFotoSocio) {
		this.urlFotoSocio = urlFotoSocio;
	}
	public List<ResultsetPaquetesVig> getPaquetes() {
		return paquetes;
	}
	public void setPaquetes(List<ResultsetPaquetesVig> paquetes) {
		this.paquetes = paquetes;
	}
	
}
