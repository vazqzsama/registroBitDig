package com.portal.app.response;

import com.portal.app.request.ReactivarRequest;

public class SocioResponse extends Response {

	private static final long serialVersionUID = 1L;
	
	private Long idRenglon;
	private String numeroDeSocio;
	private String nombre;
	private String paterno;
	private String materno;
	private String estatus;
	
	//------ Informacion complementaria
	private Long 	registro;
	private String 	celular;
	private Boolean smsEnviado;
	
	public SocioResponse() {}
	
	public SocioResponse(String encodedData) {
		super(encodedData);
	}
	
	public void setBitacora(ReactivarRequest req) {
		this.idRenglon = req.getId();
		this.numeroDeSocio = req.getIdSocio();
		this.nombre = req.getSocio().getSoNomStr();
		this.paterno = req.getSocio().getSoApatStr();
		this.materno = req.getSocio().getSoAmatStr();
		this.registro = req.getAfiliaBitacora().getId();
		this.celular = req.getSocio().getSoCelStr();
		this.smsEnviado = false;
	}
	
	// ********** GETTERS AND SETTERS
	
	public String getnumeroDeSocio() {
		return numeroDeSocio;
	}
	public void setNumeroDeSocio(String numeroDeSocio) {
		this.numeroDeSocio = numeroDeSocio;
	}
	public String getnombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public Long getIdRenglon() {
		return idRenglon;
	}
	public void setIdRenglon(Long idRenglon) {
		this.idRenglon = idRenglon;
	}
	public String getestatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
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
