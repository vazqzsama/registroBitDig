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
import com.portal.app.api.ApiController;
import com.portal.app.dto.AfiliaBitacora;
import com.portal.app.request.AfiliacionRequest;
import com.portal.app.request.AppRequest;
import com.portal.app.request.BusquedaRequest;
import com.portal.app.request.ReactivarRequest;
import com.portal.app.request.RfcRequest;
import com.portal.app.request.UpdateSocioRequest;
import com.portal.app.response.AfiliacionResponse;
import com.portal.app.response.AppResponse;
import com.portal.app.response.ClientesResponse;
import com.portal.app.service.AfilClientesService;
import com.portal.app.service.AppService;
import com.portal.app.service.impl.SmsProcessor;
import com.portal.app.util.Constants;
import com.portal.app.util.Parser;

@RestController
@RequestMapping(value="/service",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AppController {
	
	@Autowired	private AppService service;
	private static final Logger log = LoggerFactory.getLogger(AppController.class);
	@Autowired	private AfilClientesService afClServ;
	@Autowired private ApiController api;
	@Autowired private SmsProcessor sms;
	
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
	
	@PostMapping(value = "/getPaqueteAmer")
	public AfiliacionResponse getPaqueteAmer(@RequestBody AfiliacionRequest request) {
		log.info("Se ejecuta metodo getPaqueteAmer:" + new Gson().toJson(request));

		AfiliacionResponse response = new AfiliacionResponse();
		try {
			response.setRsGetPaqueteAmer(service.getPaqueteAmer(request));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(path = "/rfc/create", method = RequestMethod.POST)
	public ResponseEntity<Object> recoverAfiliacion (@Valid @RequestBody RfcRequest params) {
		log.info("Se ejecuta service/rfc/create");
		return api.createValidateRfc(params);
	}
	
	@RequestMapping(path = "/socio/reactivacion", method = RequestMethod.POST)
	public ResponseEntity<Object> socioReactivacion (@Valid @RequestBody ReactivarRequest params) throws Exception {
		log.info("Se ejecuta service/socio/reactivacion");
		return api.socioReactivacion(params);
	}
	
	@RequestMapping(path = "/socioUpdate", method = RequestMethod.POST)
	public ResponseEntity<Object> socioUpdate (@Valid @RequestBody final UpdateSocioRequest params) throws Exception {
		log.info("Se ejecuta service/socio/update");
		return api.socioUpdate(params);
	}
	
	@RequestMapping(path = "/sms/confirmacion", method = RequestMethod.POST)
	public ResponseEntity<Object> smsConfirmacion (@Valid @RequestBody final AfiliaBitacora params) throws Exception {
		log.info("Se ejecuta service/sms/confirmacion: "+new Gson().toJson(params));
		return new ResponseEntity<Object>(sms.enviarMensajeConfirmacion(params), HttpStatus.OK);
	}
	
	
	
}  