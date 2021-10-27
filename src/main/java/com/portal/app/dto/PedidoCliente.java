package com.portal.app.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class PedidoCliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idPedido;
	private double subTotal;
	private double importeTotal;
	private double descuentoPedido;
	private double gastosEnvio;
	private double seguroMensajeria;
	private int paqueteria;
	private int tipoVenta;
	private List<ArticuloPedidoCliente> articulos;
	private FormaPagoArticulo formaPago;

	/**
	 * @return the articulos
	 */
	public List<ArticuloPedidoCliente> getArticulos() {
		return Collections.unmodifiableList(articulos);
	}

	/**
	 * @param articulos the articulos to set
	 */
	public void setArticulos(List<ArticuloPedidoCliente> articulos) {
		this.articulos = articulos;
	}

	/**
	 * @return the formaPago
	 */
	public FormaPagoArticulo getFormaPago() {
		return formaPago;
	}

	/**
	 * @param formaPago the formaPago to set
	 */
	public void setFormaPago(FormaPagoArticulo formaPago) {
		this.formaPago = formaPago;
	}

	/**
	 * @return the tipoVenta
	 */
	public int getTipoVenta() {
		return tipoVenta;
	}

	/**
	 * @param tipoVenta the tipoVenta to set
	 */
	public void setTipoVenta(int tipoVenta) {
		this.tipoVenta = tipoVenta;
	}

	/**
	 * @return the idPedido
	 */
	public String getIdPedido() {
		return idPedido;
	}

	/**
	 * @param idPedido the idPedido to set
	 */
	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	/**
	 * @return the importeTotal
	 */
	public double getImporteTotal() {
		return importeTotal;
	}

	/**
	 * @param importeTotal the importeTotal to set
	 */
	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	/**
	 * @return the descuentoPedido
	 */
	public double getDescuentoPedido() {
		return descuentoPedido;
	}

	/**
	 * @param descuentoPedido the descuentoPedido to set
	 */
	public void setDescuentoPedido(double descuentoPedido) {
		this.descuentoPedido = descuentoPedido;
	}

	/**
	 * @return the gastosEnvio
	 */
	public double getGastosEnvio() {
		return gastosEnvio;
	}

	/**
	 * @param gastosEnvio the gastosEnvio to set
	 */
	public void setGastosEnvio(double gastosEnvio) {
		this.gastosEnvio = gastosEnvio;
	}

	/**
	 * @return the seguroMensajeria
	 */
	public double getSeguroMensajeria() {
		return seguroMensajeria;
	}

	/**
	 * @param seguroMensajeria the seguroMensajeria to set
	 */
	public void setSeguroMensajeria(double seguroMensajeria) {
		this.seguroMensajeria = seguroMensajeria;
	}

	/**
	 * @return the paqueteria
	 */
	public int getPaqueteria() {
		return paqueteria;
	}

	/**
	 * @param paqueteria the paqueteria to set
	 */
	public void setPaqueteria(int paqueteria) {
		this.paqueteria = paqueteria;
	}

	/**
	 * @return the subTotal
	 */
	public double getSubTotal() {
		return subTotal;
	}

	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

}
