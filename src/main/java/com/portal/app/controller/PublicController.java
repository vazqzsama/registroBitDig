package com.portal.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.app.response.AppResponse;
import com.portal.app.service.AppService;

@RestController
@RequestMapping(value = "/", produces = "application/json; charset=utf-8")
public class PublicController {

	private static final Logger log = LoggerFactory.getLogger(PublicController.class);
	@Autowired	private AppService service;
	
	
	@GetMapping(value = "nominas/merida")
	public AppResponse nominasMerida () {
		return service.nominaMerida();
	}
	
}
