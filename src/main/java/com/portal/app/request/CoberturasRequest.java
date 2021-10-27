package com.portal.app.request;

import java.io.Serializable;

/**
 * Request para consulta de coberturas de Paqueteria
 *
 */
public class CoberturasRequest extends Request implements Serializable {
	private static final long serialVersionUID = -101486275349512417L;

	private String codigoPostal;
	private int[] paqueterias;

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
	 * @return the paqueterias
	 */
	public int[] getPaqueterias() {
		return paqueterias;
	}

	/**
	 * @param paqueterias the paqueterias to set
	 */
	public void setPaqueterias(int[] paqueterias) {
		this.paqueterias = paqueterias;
	}

}
