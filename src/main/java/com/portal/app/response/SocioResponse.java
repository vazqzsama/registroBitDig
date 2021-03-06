package com.portal.app.response;

import com.portal.app.request.ReactivarRequest;

public class SocioResponse extends Response {
	
	private static final long serialVersionUID = 1L;
	
	private Long idRenglon;
	private String NumeroDeSocio;
	private String Nombre;
	private String Paterno;
	private String Materno;
	private String Estatus;
	
	private Long 	registro;
	private String 	celular;
	private Boolean smsEnviado;

	public void setBitacora(ReactivarRequest req) {
		this.idRenglon = req.getId();
		this.NumeroDeSocio = req.getIdSocio();
		this.Nombre = req.getSocio().getSoNomStr();
		this.Paterno = req.getSocio().getSoApatStr();
		this.Materno = req.getSocio().getSoAmatStr();
		this.registro = req.getAfiliaBitacora().getId();
		this.celular = req.getSocio().getSoCelStr();
		this.smsEnviado = false;
	}
	public String getNumeroDeSocio() {
		return NumeroDeSocio;
	}
	public void setNumeroDeSocio(String numeroDeSocio) {
		NumeroDeSocio = numeroDeSocio;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getPaterno() {
		return Paterno;
	}
	public void setPaterno(String paterno) {
		Paterno = paterno;
	}
	public String getMaterno() {
		return Materno;
	}
	public void setMaterno(String materno) {
		Materno = materno;
	}
	public Long getIdRenglon() {
		return idRenglon;
	}
	public void setIdRenglon(Long idRenglon) {
		this.idRenglon = idRenglon;
	}
	public String getEstatus() {
		return Estatus;
	}
	public void setEstatus(String estatus) {
		Estatus = estatus;
	}
	public Long getRegistro() {
		return registro;
	}
	public void setRegistro(Long registro) {
		this.registro = registro;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Boolean getSmsEnviado() {
		return smsEnviado;
	}
	public void setSmsEnviado(Boolean smsEnviado) {
		this.smsEnviado = smsEnviado;
	}
	

}
