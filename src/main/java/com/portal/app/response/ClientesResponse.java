package com.portal.app.response;

import java.util.ArrayList;
import java.util.List;

import com.portal.app.dto.ClientesPagina;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ClientesResponse extends Response {

	private static final long serialVersionUID = 1L;
	
	private List<ClientesPagina> clientes;
	private Integer total;

	public ClientesResponse() {
		super();
		clientes = new ArrayList<ClientesPagina>();
		total = 0;
	}
	
	public ClientesResponse(String message,int status) {
		this.setStatus(status);
		this.setMessage(message);
	}
	public ClientesResponse(String encodedData){super(encodedData);}

	public ClientesResponse(List<ClientesPagina> clientes, Integer total) {
		super();
		this.clientes = clientes;
		this.total = total;
	}
	
}
