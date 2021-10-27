package com.portal.app.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.portal.app.client.AfiliaServicesClient;
import com.portal.app.dto.AfiliaBitacoraEcommerce;
import com.portal.app.dto.CoberturaPaqueteria;
import com.portal.app.dto.DatosAfiliacion;
import com.portal.app.request.AfiliaEcommerceRequest;
import com.portal.app.request.AfiliacionRequest;
import com.portal.app.request.CrearPedidoRequest;
import com.portal.app.request.PaquetesRequest;
import com.portal.app.response.AfiliaEcommerceResponse;
import com.portal.app.response.AfiliacionResponse;
import com.portal.app.response.PaquetesResponse;
import com.portal.app.service.InfoService;
import com.portal.app.service.impl.AppServiceImpl;
import com.portal.app.util.Constants;

@RestController
@RequestMapping(value = "/service", produces = "application/json; charset=utf-8")
public class InfoController {
	
	private static final Logger log = LoggerFactory.getLogger(InfoController.class);
	
	@Autowired
	private InfoService service;
	@Autowired
	private AppServiceImpl appServ;
	@Autowired
	private AfiliaServicesClient client;
	
	@RequestMapping(path = "/getPaquetesLanding", method = RequestMethod.POST)
	public PaquetesResponse getPaquetesLanding(@Valid @RequestBody PaquetesRequest request) {
		PaquetesResponse response = new PaquetesResponse();
		log.info("getPaquetesLanding:"+new Gson().toJson(request));
		try {
			response.setPaquetes(service.getPaquetesLanding(request));
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			log.error(e.getMessage(),e);
		}
		return response;
	}

	@RequestMapping(path = "/getCatalogosActivosLanding", method = RequestMethod.POST)
	public PaquetesResponse getCatalogosActivosLanding(@Valid @RequestBody PaquetesRequest request) {
		PaquetesResponse response = new PaquetesResponse();
		log.info("getCatalogosActivosLanding:"+new Gson().toJson(request));
		try {
			response.setCatalogos(service.getCatalogosActivosLanding(request));
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			log.error(e.getMessage(),e);
		}
		return response;
	}
	
	@RequestMapping(path = "/getColoniaCP", method = RequestMethod.POST)
	public AfiliacionResponse getColoniaCP(@Valid @RequestBody AfiliacionRequest request) {
		log.info("AfiliacionWSImpl.getColoniaCP:" + new Gson().toJson(request));

		AfiliacionResponse response = new AfiliacionResponse();
		try {
			response.setRsGetColoniaCP(service.getColoniaCP(request));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(path = "/verificaCorreo", method = RequestMethod.POST)
	public AfiliaEcommerceResponse verificaCorreo(@Valid @RequestBody AfiliaEcommerceRequest request) {
		log.debug("verificaCorreo (Impl): " + new Gson().toJson(request));
		AfiliaEcommerceResponse response = new AfiliaEcommerceResponse();
		
		try {
			 if(request.getCorreoVal()==null ) {
				 response.setStatus(Constants.ERROR);
				 response.setMessage(Constants.FALTAN_PARAMETROS);
				 return response;
			 }
			 Boolean correoYaRegistrado = service.verificaCorreo( request );
			 
			 if ( correoYaRegistrado ) {
				 response.setStatus(Constants.ERROR);
				 response.setMessage("La cuenta de correo <span class='ps-color-pink'>"
						 				+request.getCorreoVal()+"</span> ya se encuentra registrada. Por favor ingrese otra cuenta.");
				 return response;
			 }
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			log.error(e.getMessage(), e);
		}
		return response;
	}
	
	@RequestMapping(path = "/getReferencia", method = RequestMethod.POST)
	public AfiliaEcommerceResponse getReferencia(@Valid @RequestBody AfiliaEcommerceRequest request) {
		log.info("getReferencia: " + new Gson().toJson(request));
		AfiliaEcommerceResponse response = new AfiliaEcommerceResponse();
		response.setReferencia(appServ.getReferenciaPedido(request.getOrigen()));
		return response;
	}
	
	@RequestMapping(path = "/saveOrUpdateAfiliaBitacoraEcommerce", method = RequestMethod.POST)
	public AfiliaEcommerceResponse saveOrUpdateAfiliaBitacoraEcommerce(@Valid @RequestBody AfiliaEcommerceRequest request) {
		log.debug("saveOrUpdateAfiliaBitacoraEcommerce (Impl): " + new Gson().toJson(request));
		AfiliaEcommerceResponse response = new AfiliaEcommerceResponse();

		try {
			if (request.getAfiliaBitacoraEcommerce() == null) {
				response.setStatus(-1);
				response.setMessage(Constants.FALTAN_PARAMETROS);
				return response;
			}
			final AfiliaBitacoraEcommerce registro = service.getByPhone(request.getAfiliaBitacoraEcommerce().getAbeTelefonoN());
			if(Objects.nonNull(registro)) {
				request.getAfiliaBitacoraEcommerce().setAbeCveN(registro.getAbeCveN());
			}
			service.saveOrUpdateAfiliaBitacoraEcommerce(request);
		} catch (Exception e) {
			response.setStatus(-1);
			response.setMessage(e.getMessage());
			log.error(e.getMessage());
		}

		return response;
	}
	
	@RequestMapping(path = "/crearPedido", method = RequestMethod.POST)
	public DatosAfiliacion crearPedido(@Valid @RequestBody CrearPedidoRequest request) {
		log.info("crearPedido (Impl): " + new Gson().toJson(request));
		return (DatosAfiliacion) client.send(request).getBody();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/getCobertura", method = RequestMethod.POST)
	public AfiliaEcommerceResponse getCobertura(@Valid @RequestBody AfiliaEcommerceRequest request) {
		log.info("getCobertura (Impl): " + new Gson().toJson(request));
		AfiliaEcommerceResponse response = new AfiliaEcommerceResponse();
		ResponseEntity<Object> result = client.send(request);
		if (result.getStatusCode().equals(HttpStatus.OK)) {
			response.setCobertura((List<CoberturaPaqueteria>) result.getBody());
		} else {
			response.setStatus(Constants.ERROR);
			response.setMessage("Error al obtener la cobertura");
		}log.info(new Gson().toJson(response));
		return response;
	}
	
} 

   