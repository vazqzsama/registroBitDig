package com.portal.app.request;

import com.portal.app.dto.Afiliacion;

public class AfiliacionRequest extends Request  {
	
	private static final long serialVersionUID = 1L;
	
	private Afiliacion afiliacion;
	
	private Integer tsCveN;
	
	private String listaCatalogos;
	
	private Long seNomEmpN;

	public Afiliacion getAfiliacion() {
		return afiliacion;
	}

	public void setAfiliacion(Afiliacion afiliacion) {
		this.afiliacion = afiliacion;
	}

	public Integer getTsCveN() {
		return tsCveN;
	}

	public void setTsCveN(Integer tsCveN) {
		this.tsCveN = tsCveN;
	}

	public String getListaCatalogos() {
		return listaCatalogos;
	}

	public void setListaCatalogos(String listaCatalogos) {
		this.listaCatalogos = listaCatalogos;
	}

	public Long getSeNomEmpN() {
		return seNomEmpN;
	}

	public void setSeNomEmpN(Long seNomEmpN) {
		this.seNomEmpN = seNomEmpN;
	}

	
}
