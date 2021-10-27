package com.portal.app.dto;

import java.io.Serializable;

public class ArticuloPedidoCliente implements Serializable {

	private static final long serialVersionUID = 1L;
	private int cantidad;
	private String idArt;
	private double precio;
	private String talla;

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
	 * @return the idArt
	 */
	public String getIdArt() {
		return idArt;
	}

	/**
	 * @param idArt the idArt to set
	 */
	public void setIdArt(String idArt) {
		this.idArt = idArt;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the talla
	 */
	public String getTalla() {
		return talla;
	}

	/**
	 * @param talla the talla to set
	 */
	public void setTalla(String talla) {
		this.talla = talla;
	}

}
