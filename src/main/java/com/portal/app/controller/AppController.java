package com.portal.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.app.request.AppRequest;
import com.portal.app.request.BusquedaRequest;
import com.portal.app.response.AppResponse;
import com.portal.app.response.ClientesResponse;
import com.portal.app.service.AfilClientesService;
import com.portal.app.service.AppService;
import com.portal.app.util.Parser;

@RestController
@RequestMapping(value="/service",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AppController {
	
	@Autowired	private AppService service;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(AppController.class);
	@Autowired	private AfilClientesService afClServ;
	
	
	@PostMapping(value = "/testConexion")
	public AppResponse testConexion(@RequestBody AppRequest request)
	{
		if(request.getEncodedData()!=null)
		{	return new AppResponse(Parser.ENCODE(service.testConexion(Parser.DECODE(request)))); }
		else
		{	return service.testConexion(request); }
	}
	
	@PostMapping(value = "/getClientesRegistrados")
	public ClientesResponse getClientesRegistrados(@RequestBody BusquedaRequest request) {
		if(request.getEncodedData()!=null) 
			return new ClientesResponse(Parser.ENCODE(afClServ.getClientesRegistrados(Parser.DECODE(request))));
		else
			return afClServ.getClientesRegistrados(request);
	}
	
}  