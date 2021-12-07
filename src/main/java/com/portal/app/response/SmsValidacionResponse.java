package com.portal.app.response;

public class SmsValidacionResponse extends Response {

	private static final long serialVersionUID = 4781994610183012814L;

	public String numeroCelular;
	public Integer codigo;
	public Boolean enviado;
	
	public SmsValidacionResponse() {
		super();
	}
	
	public SmsValidacionResponse(String numeroCelular, Integer codigo, Boolean enviado) {
		super();
		this.numeroCelular = numeroCelular;
		this.codigo = codigo;
		this.enviado = enviado;
	}
	
	public String getNumeroCelular() {
		return numeroCelular;
	}
	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Boolean getEnviado() {
		return enviado;
	}
	public void setEnviado(Boolean enviado) {
		this.enviado = enviado;
	}
		
}
