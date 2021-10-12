package com.portal.app.response;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Objeto de respuesta", description = "Objeto de respuesta")
public class Response implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Status", value = "Status",example = "0",allowableValues = "0(Correcto),-1(Error)", required = false, position = 1)
	private int 	status;
	
	@ApiModelProperty(notes = "Mensaje de respuesta", value = "Mensaje de respuesta",example = "El objeto no contiene infomación", required = false, position = 2)
	private String 	message;
	
	@ApiModelProperty(notes = "Respuesta codificada", value = "Respuesta codificada", required = false, position = 3)
	private String 	encodedData;
	
	public Response(){}
	
	public Response(String message,int status) {
		this.status = status;
		this.message = message;
	}
	
	public Response(String encodedData)
	{
		this.encodedData = encodedData;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEncodedData() {
		return encodedData;
	}
	public void setEncodedData(String encodedData) {
		this.encodedData = encodedData;
	}
}
