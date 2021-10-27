package com.portal.app.request;

import java.io.Serializable;

import com.portal.app.dto.Cliente;
import com.portal.app.dto.PedidoCliente;

public class AfiliacionDigitalRequest extends Request implements Serializable {
	private static final long serialVersionUID = 1L;

	private String origen;
	private Cliente cliente;
	private PedidoCliente pedido;

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the pedido
	 */
	public PedidoCliente getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(PedidoCliente pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

}
