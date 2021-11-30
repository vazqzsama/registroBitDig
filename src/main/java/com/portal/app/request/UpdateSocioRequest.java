package com.portal.app.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Parametros para reactivación de socios", 
description = "Datos necesarios para reactivación de socios, todos los campos son obligatorios")
public class UpdateSocioRequest extends Request {

	private static final long serialVersionUID = -1295093479746950481L;
	
	@ApiModelProperty(notes = "Id socio", dataType = "String", required = false, position = 1)
	private String soIdStr;
	
	@ApiModelProperty(notes = "Nombre socio", dataType = "String", required = false, position = 2)
	private String soNomStr;
	
	@ApiModelProperty(notes = "Apellido Paterno", dataType = "String", required = false, position = 3)
	private String soApatStr;
	
	@ApiModelProperty(notes = "Apellido Materno", dataType = "String", required = false, position = 4)
	private String soAmatStr;
	
	@ApiModelProperty(notes = "Fecha Nacimiento", dataType = "String", required = false, position = 5)
	private String fecNacDt;
	
	@ApiModelProperty(notes = "Calle", dataType = "String", required = false, position = 6)
	private String soCalle;
	
	@ApiModelProperty(notes = "Num. Exterior", dataType = "String", required = false, position = 7)
	private String soNumExt;
	
	@ApiModelProperty(notes = "Num. Interior", dataType = "String", required = false, position = 8)
	private String soNumInt;
	
	@ApiModelProperty(notes = "Colonia", dataType = "String", required = false, position = 9)
	private String soColStr;
	
	@ApiModelProperty(notes = "Ciudad", dataType = "String", required = false, position = 10)
	private String soCdStr;
	
	@ApiModelProperty(notes = "Clave Municipio", dataType = "Long", required = false, position = 11)
	private Long soMunN;
	
	@ApiModelProperty(notes = "Id socio", dataType = "Long", required = false, position = 12)
	private Long soEdoN;
	
	@ApiModelProperty(notes = "Clave Estado", dataType = "String", required = false, position = 13)
	private String soCpStr;
	
	@ApiModelProperty(notes = "Email", dataType = "String", required = false, position = 14)
	private String soEmailStr;
	
	@ApiModelProperty(notes = "Sexo", dataType = "String", required = false, position = 15)
	private String soSexoStr;
	
	@ApiModelProperty(notes = "Celular", dataType = "String", required = false, position = 16)
	private String soCelStr;
	
	@ApiModelProperty(notes = "Celular verificado", dataType = "Boolean", required = false, position = 17)
	private Boolean isCelVerif;
	
	@ApiModelProperty(notes = "Rfc Price", dataType = "String", required = false, position = 18)
	private String soRfc;
	
	public String getSoIdStr() {
		return soIdStr;
	}
	public void setSoIdStr(String soIdStr) {
		this.soIdStr = soIdStr;
	}
	public String getSoNomStr() {
		return soNomStr;
	}
	public void setSoNomStr(String soNomStr) {
		this.soNomStr = soNomStr;
	}
	public String getSoApatStr() {
		return soApatStr;
	}
	public void setSoApatStr(String soApatStr) {
		this.soApatStr = soApatStr;
	}
	public String getSoAmatStr() {
		return soAmatStr;
	}
	public void setSoAmatStr(String soAmatStr) {
		this.soAmatStr = soAmatStr;
	}
	public String getFecNacDt() {
		return fecNacDt;
	}
	public void setFecNacDt(String fecNacDt) {
		this.fecNacDt = fecNacDt;
	}
	public String getSoCalle() {
		return soCalle;
	}
	public void setSoCalle(String soCalle) {
		this.soCalle = soCalle;
	}
	public String getSoNumExt() {
		return soNumExt;
	}
	public void setSoNumExt(String soNumExt) {
		this.soNumExt = soNumExt;
	}
	public String getSoColStr() {
		return soColStr;
	}
	public void setSoColStr(String soColStr) {
		this.soColStr = soColStr;
	}
	public String getSoCdStr() {
		return soCdStr;
	}
	public void setSoCdStr(String soCdStr) {
		this.soCdStr = soCdStr;
	}
	public Long getSoMunN() {
		return soMunN;
	}
	public void setSoMunN(Long soMunN) {
		this.soMunN = soMunN;
	}
	public Long getSoEdoN() {
		return soEdoN;
	}
	public void setSoEdoN(Long soEdoN) {
		this.soEdoN = soEdoN;
	}
	public String getSoCpStr() {
		return soCpStr;
	}
	public void setSoCpStr(String soCpStr) {
		this.soCpStr = soCpStr;
	}
	public String getSoEmailStr() {
		return soEmailStr;
	}
	public void setSoEmailStr(String soEmailStr) {
		this.soEmailStr = soEmailStr;
	}
	public String getSoSexoStr() {
		return soSexoStr;
	}
	public void setSoSexoStr(String soSexoStr) {
		this.soSexoStr = soSexoStr;
	}
	public String getSoCelStr() {
		return soCelStr;
	}
	public void setSoCelStr(String soCelStr) {
		this.soCelStr = soCelStr;
	}
	public Boolean getIsCelVerif() {
		return isCelVerif;
	}
	public void setIsCelVerif(Boolean isCelVerif) {
		this.isCelVerif = isCelVerif;
	}
	public String getSoNumInt() {
		return soNumInt;
	}
	public void setSoNumInt(String soNumInt) {
		this.soNumInt = soNumInt;
	}
	public String getSoRfc() {
		return soRfc;
	}
	public void setSoRfc(String soRfc) {
		this.soRfc = soRfc;
	}
	
}
