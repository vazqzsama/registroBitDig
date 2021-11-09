package com.portal.app.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Parametros para generación de RFC Price", 
	description = "Datos necesarios para generación y validación del Rfc Price, todos los campos son obligatorios")
public class RfcRequest {

	@ApiModelProperty(notes = "Nombre del socio", value = "Nombre del socio", dataType = "String",
			example = "Julia", required = false, position = 1)
	private String nombre;

	@ApiModelProperty(notes = "Apellido Paterno del socio", value = "Apellido Paterno del socio", dataType = "String",
			example = "Cedillo", required = false, position = 2)
	private String apellidoPaterno;
	
	@ApiModelProperty(notes = "Apellido Materno del socio", value = "Apellido Materno del socio", dataType = "String",
			example = "Santillan", required = false, position = 3)
	private String apellidoMaterno;
	
	@ApiModelProperty(notes = "Nombre del socio", value = "Nombre del socio", dataType = "String",
			example = "28/07/1991", required = false, position = 4)
	private String fechaNacimiento;
	
	@ApiModelProperty(notes = "Sexo", value = "Sexo", dataType = "String",
			example = "M", required = false, position = 5)
	private String sexo;
	
}
