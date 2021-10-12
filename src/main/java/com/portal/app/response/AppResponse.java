package com.portal.app.response;

import java.util.ArrayList;
import java.util.List;

import com.portal.app.dto.BitacoraDigital;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(value = "Objeto de respuesta", description = "Objeto de respuesta")
public class AppResponse extends Response {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Bitácoras registradas exitosamente", value = "Bitácoras registradas exitosamente", required = false, position = 4)
	private List<BitacoraDigital> registrosExistosos;
	
	@ApiModelProperty(notes = "Mensaje de error por registro", value = "Mensaje de error por registro",
			example = "[El socio 072100295059 tiene un registro con pedido vigente,No contiene el nombre del estado]", required = false, position = 5)
	private List<String> registrosError;
	
	public AppResponse() {
		this.registrosExistosos = new ArrayList<BitacoraDigital>(); 
		this.registrosError = new ArrayList<String>();
	}
	
	public AppResponse(String message,int status) {
		this.setStatus(status);
		this.setMessage(message);
	}
	public AppResponse(String encodedData){super(encodedData);}
}
