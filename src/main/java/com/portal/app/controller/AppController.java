package com.portal.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.portal.app.request.AppRequest;
import com.portal.app.request.ParametrosPendientes;
import com.portal.app.response.AppResponse;
import com.portal.app.service.AppService;
import com.portal.app.util.Parser;

@RestController
@RequestMapping(value="/service",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AppController {
	
	@Autowired	private AppService service;
	private static final Logger log = LoggerFactory.getLogger(AppController.class);
	
	@PostMapping(value = "/testConexion")
	public AppResponse testConexion(@RequestBody AppRequest request)
	{
		if(request.getEncodedData()!=null)
		{	return new AppResponse(Parser.ENCODE(service.testConexion(Parser.DECODE(request)))); }
		else
		{	return service.testConexion(request); }
	}
	
	@RequestMapping(path = "bitacora/recover", method = RequestMethod.POST)
	public ResponseEntity<Object> recoverAfiliacion(@Valid @RequestBody 
			final ParametrosPendientes params) throws Exception {
		log.info("Se ejecuta bitacora/recover: "+new Gson().toJson(params));
		return new ResponseEntity<Object>(service.registrarPendientes(params), HttpStatus.OK);
	}
}
