package com.portal.app.response;

import java.util.List;

import com.portal.app.dto.CoberturaPaqueteria;

public class AfiliaEcommerceResponse extends Response {

	private static final long serialVersionUID = 1L;

	private String						referencia;
	private Boolean 					verificaCorreo;
	private List<CoberturaPaqueteria> 	cobertura;

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Boolean getVerificaCorreo() {
		return verificaCorreo;
	}

	public void setVerificaCorreo(Boolean verificaCorreo) {
		this.verificaCorreo = verificaCorreo;
	}

	public List<CoberturaPaqueteria> getCobertura() {
		return cobertura;
	}

	public void setCobertura(List<CoberturaPaqueteria> cobertura) {
		this.cobertura = cobertura;
	}
	
}
