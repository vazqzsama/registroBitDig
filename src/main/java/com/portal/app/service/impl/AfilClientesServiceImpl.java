package com.portal.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.portal.app.dao.AfilClientesDao;
import com.portal.app.request.BusquedaRequest;
import com.portal.app.response.ClientesResponse;
import com.portal.app.service.AfilClientesService;

@Service
public class AfilClientesServiceImpl implements AfilClientesService {

	private static final Logger log = LoggerFactory.getLogger(AfilClientesServiceImpl.class);
	
	@Autowired 
	private AfilClientesDao dao;
	
	@Override
	public ClientesResponse getClientesRegistrados(BusquedaRequest request) {
		log.info(new Gson().toJson(request));
		return new ClientesResponse(dao.getClienteRegistrados(request),dao.getCountBusqueda(request));
	}
	
}

