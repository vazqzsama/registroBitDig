package com.portal.app.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.portal.app.dto.BitacoraDigital;
import com.portal.app.dto.CoberturaPaqueteria;
import com.portal.app.dto.DatosAfiliacion;
import com.portal.app.request.AfiliaEcommerceRequest;
import com.portal.app.request.BitRegRequest;
import com.portal.app.request.CrearPedidoRequest;
import com.portal.app.response.CrearPedidoResponse;
import com.portal.app.util.Constants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SuppressWarnings("rawtypes")
@Service
public class AfiliaServicesClient implements WsClient {
	
	private static final Logger log = LogManager.getLogger(AfiliaServicesClient.class);
	
		@Value("${afilia.service.base.url}")
		private String url;
        @Value("${afilia.service.refbanc.url}")
        private String urlRefBan;
        @Value("${afilia.service.pedido.url}")
        private String urlPedido;
        @Value("${afilia.service.cobertura.url}")
        private String urlCobertura;
        @Value("${afilia.service.user}")
        private String user;
        @Value("${afilia.service.pass}")
        private String pass;
        
	@Override
	public String getAuthorization() {
            return new StringBuilder("Basic ").append(Base64.getEncoder().encodeToString(
                new StringBuilder(user).append(":").append(pass).toString().getBytes())).toString();
	}

	@Override
	public String getEndPoint() {
		return url;
	}

	@Override
	public ResponseEntity<Object> send(String idSocio) { // Referencia Bancaria
		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		try {
			Builder webResource = client.resource(this.getEndPoint().concat(urlRefBan).concat(idSocio)).header("Authorization",this.getAuthorization());
            ClientResponse r = webResource.type("application/json").get(ClientResponse.class);
            
            return new ResponseEntity<Object>(new Gson().fromJson(r.getEntity(String.class),String.class), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
				Objects.toString(e.getMessage(), e.getLocalizedMessage())
			);
		} finally {
			client.destroy();
		}
	}

	@Override
	public ResponseEntity send(CrearPedidoRequest request) { // crear pedido
		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		try {
			Builder webResource = client.resource(this.getEndPoint().concat(urlPedido)).header("Authorization",this.getAuthorization());
            ClientResponse r = webResource.type("application/json").post(ClientResponse.class,
            		Normalizer.normalize(new Gson().toJson( request ), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
            
            return new ResponseEntity<Object>(new Gson().fromJson(r.getEntity(String.class),DatosAfiliacion.class), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
				new DatosAfiliacion(Objects.toString(e.getMessage(), e.getLocalizedMessage()),Constants.ERROR)
			);
		} finally {
			client.destroy();
		}
	}
	
	@Override
	public ResponseEntity send(AfiliaEcommerceRequest request) { // Consulta de cobertura de paqueteria
		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		try {
			Builder webResource = client.resource(this.getEndPoint().concat(urlCobertura)).header("Authorization",this.getAuthorization());
            ClientResponse r = webResource.type("application/json").post(ClientResponse.class,
            		Normalizer.normalize(new Gson().toJson( request ), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
            
            return new ResponseEntity<Object>( Arrays.asList(new Gson().fromJson(r.getEntity(String.class),
            		CoberturaPaqueteria[].class)) , HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
				new CrearPedidoResponse(Constants.ERROR,Objects.toString(e.getMessage(), e.getLocalizedMessage()))
			);
		} finally {
			client.destroy();
		}
	}
	
	@Override
	public ResponseEntity send(BitRegRequest request) {
		return null;
	}

	@Override
	public ResponseEntity send(BitacoraDigital request) {
		return null;
	}
	
}
