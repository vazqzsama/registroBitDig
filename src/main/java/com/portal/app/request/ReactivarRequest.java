package com.portal.app.request;

import com.portal.app.dto.AfiliaBitacora;
import com.portal.app.dto.Socio;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Parametros para reactivación de socios", 
description = "Datos necesarios para reactivación de socios, todos los campos son obligatorios")
public class ReactivarRequest extends Request {

	private static final long serialVersionUID = -7005221209958797303L;
	
	@ApiModelProperty(notes = "Id de socio", value = "Id de socio", dataType = "String",
			example = "111600047812", required = false, position = 1)
	private String idSocio;
	@ApiModelProperty(notes = "RFC Price", value = "RFC Price", dataType = "String",
			example = "RVSRAAM080799", required = false, position = 2)
	private String rfcPrice;
	@ApiModelProperty(notes = "Datos socio", value = "Datos socio", dataType = "Socio",
			required = false, position = 3)
	private Socio socio;
	@ApiModelProperty(notes = "Datos para bitacora", value = "Datos para bitacora", dataType = "AfiliaBitacora",
			required = false, position = 4)
	private AfiliaBitacora afiliaBitacora;
		
	public String getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}
	public String getRfcPrice() {
		return rfcPrice;
	}
	public void setRfcPrice(String rfcPrice) {
		this.rfcPrice = rfcPrice;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	public AfiliaBitacora getAfiliaBitacora() {
		return afiliaBitacora;
	}
	public void setAfiliaBitacora(AfiliaBitacora afiliaBitacora) {
		this.afiliaBitacora = afiliaBitacora;
	}

}
