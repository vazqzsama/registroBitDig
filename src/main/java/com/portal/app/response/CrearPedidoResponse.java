package com.portal.app.response;

import java.io.Serializable;

import com.portal.app.dto.BitacoraDigital;

public class CrearPedidoResponse extends Response implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idSocio;
	private String idPedido;
	private BitacoraDigital bitacora;

	public CrearPedidoResponse() {
		super();
	}

	public CrearPedidoResponse(Integer error, String mensaje) {
		super();
		setStatus(getStatus());
		setMessage(mensaje);
	}

	public CrearPedidoResponse(String idSocio, String idPedido) {
		super();
		this.idSocio = idSocio;
		this.idPedido = idPedido;
	}

	public String getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}

	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public BitacoraDigital getBitacora() {
		return bitacora;
	}

	public void setBitacora(BitacoraDigital bitacora) {
		this.bitacora = bitacora;
	}

}
