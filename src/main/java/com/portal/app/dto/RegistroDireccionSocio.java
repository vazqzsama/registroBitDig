package com.portal.app.dto;

import java.io.Serializable;

/**
 * @author jchr
 *
 */
public class RegistroDireccionSocio implements Serializable {
	private static final long serialVersionUID = 1L;

	private String calle;
	private String numero;
	private String colonia;
	private String municipioId;
	private String ciudad;
	private String codigoPostal;
	private String telefono1;
	private String telefono2;
	private String paisId;
	private Integer estadoId;
	private Integer idDireccionPs;

	/**
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the colonia
	 */
	public String getColonia() {
		return colonia;
	}

	/**
	 * @param colonia the colonia to set
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	/**
	 * @return the municipioId
	 */
	public String getMunicipioId() {
		return municipioId;
	}

	/**
	 * @param municipioId the municipioId to set
	 */
	public void setMunicipioId(String municipioId) {
		this.municipioId = municipioId;
	}

	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return the telefono1
	 */
	public String getTelefono1() {
		return telefono1;
	}

	/**
	 * @param telefono1 the telefono1 to set
	 */
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	/**
	 * @return the telefono2
	 */
	public String getTelefono2() {
		return telefono2;
	}

	/**
	 * @param telefono2 the telefono2 to set
	 */
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	/**
	 * @return the paisId
	 */
	public String getPaisId() {
		return paisId;
	}

	/**
	 * @param paisId the paisId to set
	 */
	public void setPaisId(String paisId) {
		this.paisId = paisId;
	}

	/**
	 * @return the estadoId
	 */
	public Integer getEstadoId() {
		return estadoId;
	}

	/**
	 * @param estadoId the estadoId to set
	 */
	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

	/**
	 * @return the idDireccionPs
	 */
	public Integer getIdDireccionPs() {
		return idDireccionPs;
	}

	/**
	 * @param idDireccionPs the idDireccionPs to set
	 */
	public void setIdDireccionPs(Integer idDireccionPs) {
		this.idDireccionPs = idDireccionPs;
	}

}
