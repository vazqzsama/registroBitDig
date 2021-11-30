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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.portal.app.dto.BitacoraDigital;
import com.portal.app.dto.PsSocios;
import com.portal.app.request.BitRegRequest;
import com.portal.app.request.ReactivarRequest;
import com.portal.app.request.RfcRequest;
import com.portal.app.request.UpdateSocioRequest;
import com.portal.app.response.Response;
import com.portal.app.response.RfcValidResponse;
/*import com.portal.app.request.ParametrosPendientes;
import com.portal.app.response.AppResponse;*/
import com.portal.app.service.AppService;
import com.portal.app.util.Constants;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value = "/")
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
	@RequestMapping(path = "bitacora/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createBitacora (
			@ApiParam(value = "Datos para registro bitacora", required = true) 
			@RequestBody final BitRegRequest params) throws Exception {
		log.info("Request bitacora/create: "+new Gson().toJson(params));
		ResponseEntity<Object> response = new ResponseEntity<Object>(service.createBitacora(params), HttpStatus.OK);
		log.info("response bitacora/create: "+new Gson().toJson(response));
		return response;
	}
	
	@ApiOperation(value = "Actualización de bitácora", response = BitacoraDigital.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso Exitoso", response = BitacoraDigital.class),
			@ApiResponse(code = 400, message = "Operación inválida", response = ApiError.class)
	})
	@RequestMapping(path = "bitacora/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateBitacora (
			@ApiParam(value = "Bitácora para actualizar", required = true)
			@Valid @RequestBody final BitacoraDigital params) throws Exception {
		log.info("Se ejecuta bitacora/update: "+new Gson().toJson(params));
		ResponseEntity<Object> response = new ResponseEntity<Object>(service.updateBitacora(params), HttpStatus.OK);
		log.info("Response bitacora/update: "+new Gson().toJson(response));
		return response;
	}
	
	@ApiOperation(value = "Obtener bitácora", response = BitacoraDigital.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso Exitoso", response = BitacoraDigital.class),
			@ApiResponse(code = 400, message = "Operación inválida", response = ApiError.class)
	})
	@RequestMapping(method = RequestMethod.GET,path = "bitacora")
	public ResponseEntity<Object> getBitacora (
			@ApiParam(value = "Bitácora para actualizar", required = true)
			@Valid @RequestParam final String idSocio) throws Exception {
		log.info("Se ejecuta bitacora/get/"+idSocio);
		ResponseEntity<Object> response = new ResponseEntity<Object>(service.searchBitacora(idSocio), HttpStatus.OK);
		log.info("Response bitacora?idSocio="+idSocio+": "+new Gson().toJson(response));
		return response;
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
	

	@ApiOperation(value = "Generación de RFC Price", response = RfcValidResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso Exitoso", response = RfcValidResponse.class),
			@ApiResponse(code = 400, message = "Operación inválida", response = ApiError.class)
	})
	@RequestMapping(path = "rfc/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createValidateRfc (
			@ApiParam(value = "Parámetros de búsqueda", required = true,allowEmptyValue = false)
			@Valid @RequestBody final RfcRequest params) {
		log.info("Se ejecuta rfc/create: "+new Gson().toJson(params));
		try {
			return new ResponseEntity<Object>(service.createValidateRfc(params), HttpStatus.OK);
		} catch (Exception e) {
			Response r = new Response();
			r.setMessage(e.getLocalizedMessage());
			r.setStatus(Constants.ERROR);
			return new ResponseEntity<Object>(r, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "Reactivación de Socio Afiliación Tradicional", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso Exitoso", response = Response.class),
			@ApiResponse(code = 400, message = "Operación inválida", response = ApiError.class)
	})
	@RequestMapping(path = "socio/reactivacion", method = RequestMethod.POST)
	public ResponseEntity<Object> socioReactivacion (
			@ApiParam(value = "Datos para reactivación", required = true,allowEmptyValue = false)
			@Valid @RequestBody final ReactivarRequest params) throws Exception {
		log.info("Se ejecuta socio/reactivacion: "+new Gson().toJson(params));
		return new ResponseEntity<Object>(service.reactivarSocio(params), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Actualización Socio", response = PsSocios.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso Exitoso", response = PsSocios.class),
			@ApiResponse(code = 400, message = "Operación inválida", response = ApiError.class)
	})
	@RequestMapping(path = "socio/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> socioUpdate (
			@ApiParam(value = "Parámetros de búsqueda", required = true,allowEmptyValue = false)
			@Valid @RequestBody final UpdateSocioRequest params) throws Exception {
		log.info("Se ejecuta socio/update: "+new Gson().toJson(params));
		return new ResponseEntity<Object>(service.updateSocio(params), HttpStatus.OK);
	}
	
}
