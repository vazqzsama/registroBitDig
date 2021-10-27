package com.portal.app.dao;

import java.util.List;

import com.portal.app.dto.ClientesPagina;
import com.portal.app.request.BusquedaRequest;

public interface AfilClientesDao {

	public List<ClientesPagina> getClienteRegistrados(BusquedaRequest request);
	public Integer getCountBusqueda(BusquedaRequest param);
	
}
