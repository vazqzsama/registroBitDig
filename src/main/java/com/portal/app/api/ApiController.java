package com.portal.app.api;

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
import com.portal.app.dto.BitacoraDigital;
import com.portal.app.request.BitRegRequest;
/*import com.portal.app.request.ParametrosPendientes;
import com.portal.app.response.AppResponse;*/
import com.portal.app.service.AppService;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value = "/bitacora")
@Api(value = "Registro Bitácora Digital", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ApiController {

	private static final Logger log = LoggerFactory.getLogger(ApiController.class);
	
	@Autowired
	private AppService service;
	
	@ApiOperation(value = "Registro de bitácora", response = BitacoraDigital.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso Exitoso", response = BitacoraDigital.class),
			@ApiResponse(code = 400, message = "Operación inválida", response = ApiError.class),
			@ApiResponse(code = 412, message = "Socio con registro vigente", response = ApiError.class)
	})
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createBitacora(
			@ApiParam(value = "Datos para registro bitacora", required = true) 
			@Valid @RequestBody final BitRegRequest params) throws Exception {
		log.info("Se ejecuta bitacora/create: "+new Gson().toJson(params));
		return new ResponseEntity<Object>(service.createBitacora(params), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Actualización de bitácora", response = BitacoraDigital.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso Exitoso", response = BitacoraDigital.class),
			@ApiResponse(code = 400, message = "Operación inválida", response = ApiError.class)
	})
	@RequestMapping(path = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateBitacora(
			@ApiParam(value = "Bitácora para actualizar", required = true)
			@Valid @RequestBody final BitacoraDigital params) throws Exception {
		log.info("Se ejecuta bitacora/update: "+new Gson().toJson(params));
		return new ResponseEntity<Object>(service.updateBitacora(params), HttpStatus.OK);
	}
	
	/*@ApiOperation(value = "Recuperación y registro de bitácora de afiliaciones", response = AppResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso Exitoso", response = AppResponse.class),
			@ApiResponse(code = 400, message = "Operación inválida", response = ApiError.class)
	})
	@RequestMapping(path = "/recover", method = RequestMethod.POST)
	public ResponseEntity<Object> recoverAfiliacion(
			@ApiParam(value = "Parámetros de búsqueda", required = true,allowEmptyValue = false)
			@Valid @RequestBody final ParametrosPendientes params) throws Exception {
		log.info("Se ejecuta bitacora/recover: "+new Gson().toJson(params));
		return new ResponseEntity<Object>(service.registrarPendientes(params), HttpStatus.OK);
	}*/
	
}
