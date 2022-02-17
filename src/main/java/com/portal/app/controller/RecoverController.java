package com.portal.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.portal.app.dao.AppDao;
import com.portal.app.request.ParametrosPendientes;
import com.portal.app.response.Response;
import com.portal.app.service.AppService;

@RestController
@RequestMapping(value="/bitacora",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RecoverController {

	@Autowired
	private AppService service;
	@Autowired
	private AppDao dao;
	private static final Logger log = LoggerFactory.getLogger(RecoverController.class);
	
	@RequestMapping(path = "/recover/socio", method = RequestMethod.POST)
	public ResponseEntity<Object> recoverSocio(@Valid @RequestBody 
			final ParametrosPendientes params) throws Exception {
		log.info("Se ejecuta bitacora/recover: "+new Gson().toJson(params));
		return new ResponseEntity<Object>(service.registrarPendientes(params), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/recover/cliente", method = RequestMethod.POST)
	public ResponseEntity<Object> recoverCliente(@Valid @RequestBody
			final ParametrosPendientes params) throws Exception {
		log.info("Se ejecuta bitacora/recover: "+new Gson().toJson(params));
		return new ResponseEntity<Object>(service.registrarPendientes(params), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/test/fotos", method = RequestMethod.POST)
	public ResponseEntity<Object> testFotos() {
		log.info("Se ejecuta test/fotos");
		dao.testFotos();
		return new ResponseEntity<Object>(new Response(),HttpStatus.OK);
	}
	
} 
