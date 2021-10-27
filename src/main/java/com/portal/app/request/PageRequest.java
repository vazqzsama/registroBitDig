package com.portal.app.request;

import com.portal.app.response.SocioResponse;

public class PageRequest {

	private Integer loadBase;
	private Long 	idPerfN;
	private Long 	idMenuN;
	private SocioResponse response;
	private String 	celular;
	private Long 	registro;
	private Long    idRow;
	private String  nombre; 
	private String	fileName;
	private String  dato;
	
	private String   preregistro;
	
	public Integer getLoadBase() {
		return loadBase;
	}

	public void setLoadBase(Integer loadBase) {
		this.loadBase = loadBase;
	}

	public Long getIdPerfN() {
		return idPerfN;
	}

	public void setIdPerfN(Long idPerfN) {
		this.idPerfN = idPerfN;
	}

	public Long getIdMenuN() {
		return idMenuN;
	}

	public void setIdMenuN(Long idMenuN) {
		this.idMenuN = idMenuN;
	}

	public SocioResponse getResponse() {
		return response;
	}

	public void setResponse(SocioResponse response) {
		this.response = response;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Long getRegistro() {
		return registro;
	}

	public void setRegistro(Long registro) {
		this.registro = registro;
	}

	public Long getIdRow() {
		return idRow;
	}

	public void setIdRow(Long idRow) {
		this.idRow = idRow;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPreregistro() {
		return preregistro;
	}

	public void setPreregistro(String preregistro) {
		this.preregistro = preregistro;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}
	
}
