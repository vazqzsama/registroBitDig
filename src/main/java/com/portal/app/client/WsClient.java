package com.portal.app.client;

import org.springframework.http.ResponseEntity;

import com.portal.app.dto.BitacoraDigital;
import com.portal.app.request.AfiliaEcommerceRequest;
import com.portal.app.request.BitRegRequest;
import com.portal.app.request.CrearPedidoRequest;
import com.portal.app.request.Request;

public interface WsClient<R extends Request> {
	
	String getAuthorization();
	
	String getEndPoint();
	
	ResponseEntity<Object> send(BitacoraDigital request);
	
	ResponseEntity<Object> send(BitRegRequest request);

	ResponseEntity<Object> send(String idSocio);
	
	ResponseEntity<Object> send(CrearPedidoRequest request);
	
	ResponseEntity<Object> send(AfiliaEcommerceRequest request);
	
}
