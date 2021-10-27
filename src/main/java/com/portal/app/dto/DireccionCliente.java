package com.portal.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portal.app.util.Constants;

public class DireccionCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	private boolean envio;
	private String calle;
	private String noExterior;
	private String noInterior;
	private String colonia;
	private String cp;
	private String municipio;
	private String municipioDesc;
	private Integer estado;
	private String estadoDesc;
	private String ciudad;
	private String referencia;
	private String entreCalles;
	@JsonIgnore
	private String idDireccionPs;

	/**
	 * @return
	 */
	public boolean isEnvio() {
		return envio;
	}

	/**
	 * @param envio
	 */
	public void setEnvio(boolean envio) {
		this.envio = envio;
	}

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
	 * @return the noExterior
	 */
	public String getNoExterior() {
		return noExterior;
	}

	/**
	 * @param noExterior the noExterior to set
	 */
	public void setNoExterior(String noExterior) {
		this.noExterior = noExterior;
	}

	/**
	 * @return the noInterior
	 */
	public String getNoInterior() {
		return noInterior;
	}

	/**
	 * @param noInterior the noInterior to set
	 */
	public void setNoInterior(String noInterior) {
		this.noInterior = noInterior;
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
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	/**
	 * @return the estado
	 */
	public Integer getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Integer estado) {
		this.estado = estado;
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
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * @return the idDireccionPs
	 */
	public String getIdDireccionPs() {
		return idDireccionPs;
	}

	/**
	 * @param idDireccionPs the idDireccionPs to set
	 */
	public void setIdDireccionPs(String idDireccionPs) {
		this.idDireccionPs = idDireccionPs;
	}

	/**
	 * @return the municipioDesc
	 */
	public String getMunicipioDesc() {
		return municipioDesc;
	}

	/**
	 * @param municipioDesc the municipioDesc to set
	 */
	public void setMunicipioDesc(String municipioDesc) {
		this.municipioDesc = municipioDesc;
	}

	/**
	 * @return the estadoDesc
	 */
	public String getEstadoDesc() {
		return estadoDesc;
	}

	/**
	 * @param estadoDesc the estadoDesc to set
	 */
	public void setEstadoDesc(String estadoDesc) {
		this.estadoDesc = estadoDesc;
	}

	/**
	 * @return the entreCalles
	 */
	public String getEntreCalles() {
		return entreCalles;
	}

	/**
	 * @param entreCalles the entreCalles to set
	 */
	public void setEntreCalles(String entreCalles) {
		this.entreCalles = entreCalles;
	}

	/**
	 * Debido a que en el esuqema de datos de PS no existen campos particulares para
	 * No externo, Referencia y Entre calles, estos pueden agregarse como
	 * observaciones. Este método devuelde dichos datos concatenados
	 */
	public String getObservacionesPs() {
		final List<String> obs = new ArrayList<>();
		if (Objects.nonNull(this.getNoInterior()) && !this.getNoInterior().isEmpty()) {
			obs.add(String.format("%s %s", Constants.TITULO_NUM_INTERIOR_DOMICILIO, this.getNoInterior()));
		}

		if (Objects.nonNull(this.getReferencia()) && !this.getReferencia().isEmpty()) {
			obs.add(String.format("%s %s", Constants.TITULO_REFERENCIAS_DOMICILIO, this.getReferencia()));
		}

		if (Objects.nonNull(this.getEntreCalles()) && !this.getEntreCalles().isEmpty()) {
			obs.add(String.format("%s %s", Constants.TITULO_ENTRE_CALLES_DOMICILIO, this.getEntreCalles()));
		}
		return String.join(Constants.SEPARADOR_DATOS_DOMICILIO_OBSERVACIONES, obs);
	}

	/**
	 * Compara si la direccion registrada es la misma.
	 * 
	 * @param direccion
	 */
	public boolean match(final RegistroDireccionSocio direccion) {
		boolean match = false;
		if (Objects.nonNull(direccion)) {
			final StringBuffer a = new StringBuffer();
			final StringBuffer b = new StringBuffer();
			a.append(this.calle).append(this.ciudad).append(this.colonia).append(this.cp).append(this.municipio)
					.append(this.noExterior);
			b.append(direccion.getCalle()).append(direccion.getCiudad()).append(direccion.getColonia())
					.append(direccion.getCodigoPostal()).append(direccion.getMunicipioId())
					.append(direccion.getNumero());
			match = a.toString().toUpperCase().equals(b.toString().toUpperCase());
			if (match) {
				this.idDireccionPs = String.valueOf(direccion.getIdDireccionPs());
			}
		}
		return match;
	}
}
