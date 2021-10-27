package com.portal.app.service;

import com.portal.app.request.BusquedaRequest;
import com.portal.app.response.ClientesResponse;

public interface AfilClientesService {

	public ClientesResponse getClientesRegistrados(BusquedaRequest request);
	
}
