package com.portal.app.dto;

import com.portal.app.request.BitRegRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Datos de dirección de envío",
description = "Datos de dirección de envío",parent = BitRegRequest.class )
public class Direccion {

	@ApiModelProperty(notes = "Calle", value = "Calle",example = "Andador", required = true, position = 1)
	private String calle;
	
	@ApiModelProperty(notes = "Número Exterior", value = "Número Exterior",example = "12", required = true, position = 2)
	private String noExterior;
	
	@ApiModelProperty(notes = "Número Interior", value = "Número Interior",example = "2", required = true, position = 3)
	private String noInterior;
	
	@ApiModelProperty(notes = "Colonia", value = "Colonia",example = "San Luis De La Paz Centro", required = true, position = 4)
	private String colonia;
	
	@ApiModelProperty(notes = "Código Postal", value = "Código Postal",example = "37900", required = true, position = 5)
	private String cp;
	
	@ApiModelProperty(notes = "Id de municipio", value = "Id de municipio",example = "12", required = true, position = 6)
	private Long municipio;
	
	@ApiModelProperty(notes = "Nombre del municipio", value = "Nombre del municipio",example = "San Luis De La Paz", required = true, position = 7)
	private String municipioDesc;
	
	@ApiModelProperty(notes = "Id de estado", value = "Id de estado",example = "33", required = true, position = 8)
	private Long estado;
	
	@ApiModelProperty(notes = "Nombre de estado", value = "Nombre de estado",example = "Guanajuato", required = true, position = 9)
	private String estadoDesc;
	
	@ApiModelProperty(notes = "Ciudad", value = "Ciudad",example = "San Luis De La Paz", required = true, position = 10)
	private String ciudad;
	
	@ApiModelProperty(notes = "Referencia", value = "Referencia",example = "Puerta blanca con dos ventanas grandes blancas", required = false, position = 11)
	private String referencia;
	
	@ApiModelProperty(notes = "Entre calles", value = "Entre calles",example = "Amaranto, trigo y avena", required = false, position = 12)
	private String entreCalles;
	
}
