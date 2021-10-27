package com.portal.app.request;

import com.portal.app.dto.AfiliaBitacoraEcommerce;

public class AfiliaEcommerceRequest extends Request  {

	private static final long serialVersionUID = 1L;
	
	private AfiliaBitacoraEcommerce 	afiliaBitacoraEcommerce;
	private String 						nombreL;
	private String 						celularL;
	private String 						medioL;
	private String 						inicio;
	private String 						fin;
	private String						folio;
	private String						socio;
	private Long						pedido;
	private String 						guia;
	private String						origen;
	private String						estatus;
	private String						correoVal;
	private Long						tiCveN;
	private String 						codigoPostal;

	public AfiliaBitacoraEcommerce getAfiliaBitacoraEcommerce() {
		return afiliaBitacoraEcommerce;
	}

	public void setAfiliaBitacoraEcommerce(AfiliaBitacoraEcommerce afiliaBitacoraEcommerce) {
		this.afiliaBitacoraEcommerce = afiliaBitacoraEcommerce;
	}

	public String getNombreL() {
		return nombreL;
	}

	public void setNombreL(String nombreL) {
		this.nombreL = nombreL;
	}

	public String getCelularL() {
		return celularL;
	}

	public void setCelularL(String celularL) {
		this.celularL = celularL;
	}

	public String getMedioL() {
		return medioL;
	}

	public void setMedioL(String medioL) {
		this.medioL = medioL;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getGuia() {
		return guia;
	}

	public void setGuia(String guia) {
		this.guia = guia;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getSocio() {
		return socio;
	}

	public void setSocio(String socio) {
		this.socio = socio;
	}

	public Long getPedido() {
		return pedido;
	}

	public void setPedido(Long pedido) {
		this.pedido = pedido;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getCorreoVal() {
		return correoVal;
	}

	public void setCorreoVal(String correoVal) {
		this.correoVal = correoVal;
	}

	public Long getTiCveN() {
		return tiCveN;
	}

	public void setTiCveN(Long tiCveN) {
		this.tiCveN = tiCveN;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

}
