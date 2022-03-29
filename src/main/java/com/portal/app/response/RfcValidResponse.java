package com.portal.app.response;

import java.util.List;

import com.portal.app.dto.PsSocios;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Objeto de respuesta creación y validacion de rfc", description = "Objeto de respuesta creación y validacion de rfc")
public class RfcValidResponse extends Response {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "RfcPrice", value = "RfcPrice",example = "JCSUEAM280728", required = false, position = 1)
	private String rfcPrice;
	
	@ApiModelProperty(notes = "Dato de existencia", value = "Dato de existencia",example = "true", required = false, position = 1)
	private Boolean existe;
	
	@ApiModelProperty(notes = "Registro previo", value = "Registro previo", required = false, position = 3)
	private List<PsSocios> registro;

	public RfcValidResponse() {
		super();
	}
	
	public RfcValidResponse(String rfcPrice,List<PsSocios> registro) {
		super();
		this.rfcPrice = rfcPrice;
		this.existe = !registro.isEmpty();
		this.registro = registro;
	}

	public String getRfcPrice() {
		return rfcPrice;
	}

	public void setRfcPrice(String rfcPrice) {
		this.rfcPrice = rfcPrice;
	}

	public Boolean getExiste() {
		return existe;
	}

	public void setExiste(Boolean existe) {
		this.existe = existe;
	}

	public List<PsSocios> getRegistro() {
		return registro;
	}

	public void setRegistro(List<PsSocios> registro) {
		this.registro = registro;
	}

}
