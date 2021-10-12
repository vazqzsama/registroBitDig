package com.portal.app.request;

import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Parametros para registro de afiliaciones", 
	description = "Representa las posibles opciones para busqueda, ningun campo es obligatorio")
public class ParametrosPendientes {

	@ApiModelProperty(notes = "Lista de id's de socios", value = "Lista de id's de socios", dataType = "String",
			example = "[102100294674,102100294658,102100294652]", required = false, position = 1)
	private List<String> idSocio;
	
	@ApiModelProperty(notes = "Lista de correos", value = "Lista de correos", dataType = "String", required = false,
			position = 2, example = "[amarosergioarmando@gmail.com,cd706253@gmail.com,esva751021@gmail.com]")
	private List<String> correos;
	
	@ApiModelProperty(notes = "Fecha de inicio de busqueda",dataType = "String", value = "Fecha de inicio de busqueda", 
			example = "01/08/2021", required = false, position = 3)
	private String fechaInicio;
	
	@ApiModelProperty(notes = "Fecha de fin de busqueda", value = "Fecha de fin de busqueda", 
			example = "31/08/2021", required = false, position = 4, dataType = "String")
	private String fechaFin;
	
	public ParametrosPendientes() {
		super();
	}	
	
	
	public boolean containParams() {
		boolean valid = false;
		valid = Objects.isNull(this.idSocio) && Objects.isNull(this.correos) && Objects.isNull(this.fechaInicio) && Objects.isNull(this.fechaFin) 
			? true : this.idSocio.isEmpty() && this.correos.isEmpty() && Objects.isNull(this.fechaInicio) && Objects.isNull(this.fechaFin);
		return valid;
	}
}
