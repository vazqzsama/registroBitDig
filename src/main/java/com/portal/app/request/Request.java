package com.portal.app.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class Request implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(hidden = true)
	private Long    id;
	@ApiModelProperty(hidden = true)
	private Long 	idUsrN;
	@ApiModelProperty(hidden = true)
	private Long	idAppN;
	@ApiModelProperty(hidden = true)
	private Long 	idPerfN;
	@ApiModelProperty(hidden = true)
	private String 	encodedData;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdUsrN() {
		return idUsrN;
	}
	public void setIdUsrN(Long idUsrN) {
		this.idUsrN = idUsrN;
	}
	public Long getIdAppN() {
		return idAppN;
	}
	public void setIdAppN(Long idAppN) {
		this.idAppN = idAppN;
	}
	public Long getIdPerfN() {
		return idPerfN;
	}
	public void setIdPerfN(Long idPerfN) {
		this.idPerfN = idPerfN;
	}
	public String getEncodedData() {
		return encodedData;
	}
	public void setEncodedData(String encodedData) {
		this.encodedData = encodedData;
	}
	
}
