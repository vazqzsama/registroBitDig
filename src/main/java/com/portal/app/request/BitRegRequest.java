package com.portal.app.request;

import com.portal.app.dto.Direccion;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(value = "Datos de socio para registro de bitacora digital",
description = "Datos de socio para registro de bitacora digital")
public class BitRegRequest extends Request {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Id de socio", value = "Id de socio",example = "092100291652", required = true, position = 1)
	private String idSocio;
	
	@ApiModelProperty(notes = "Nombre del socio", value = "Nombre del socio",example = "Jose", required = true, position = 2)
	private String soNombre;
	
	@ApiModelProperty(notes = "Apellido paterno", value = "Apellido paterno",example = "Martinez", required = true, position = 3)
	private String apellidoPaterno;
	
	@ApiModelProperty(notes = "Apellido materno", value = "Apellido materno",example = "Vargas", required = true, position = 4)
	private String apellidoMaterno;
	
	@ApiModelProperty(notes = "Dirección de correo", value = "Dirección de correo",example = "correo@correo.com", required = true, position = 5)
	private String email;
	
	@ApiModelProperty(notes = "Número de telefono", value = "Número de telefono",example = "5566556655", required = true, position = 6)
	private String telefono;
	
	@ApiModelProperty(notes = "Id de tienda", value = "Id de tienda", example = "29", required = true, position = 7)
	private Long cveTienda;

	@ApiModelProperty(notes = "Estatus de socio", value = "Estatus de socio",example = "N", allowableValues = "N(Cliente),R(Socio)", required = true, position = 8)
	private String statusSocio;
	
	@ApiModelProperty(notes = "Dirección de envío", value = "Dirección de envío",required = false, position = 9)
	private Direccion direccionEnvio;
	
	
	
}
