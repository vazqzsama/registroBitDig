package com.portal.app.dto;

import java.io.Serializable;

/**
 * @author jchr
 *
 */
public class FormaPagoArticulo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int formaPago;
	private int cantidad;
	private int metodoPago;
	private String referencia;

	/**
	 * @return the formapago
	 */
	public int getFormaPago() {
		return formaPago;
	}

	/**
	 * @param formapago the formapago to set
	 */
	public void setFormaPago(int formapago) {
		this.formaPago = formapago;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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
	 * @return the metodoPago
	 */
	public int getMetodoPago() {
		return metodoPago;
	}

	/**
	 * @param metodoPago the metodoPago to set
	 */
	public void setMetodoPago(int metodoPago) {
		this.metodoPago = metodoPago;
	}

}
