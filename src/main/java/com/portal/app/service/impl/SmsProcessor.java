package com.portal.app.service.impl;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.Normalizer;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.portal.app.dto.AfiliaBitacora;
import com.portal.app.request.SmsRequest;
import com.portal.app.request.UpdateSocioRequest;
import com.portal.app.response.Response;
import com.portal.app.util.Constants;

@Service
public class SmsProcessor {
	
	private static final Logger log = LoggerFactory.getLogger(SmsProcessor.class);
	@Value("${sms.url.service}")
	private String smsService;
	@Value("${sms.url.cred}")
	private String urlCredencial;
	@Value("${sms.key}")
	private String smsKey;
	@Value("${sms.user}")
	private String smsUser;
	@Value("${sms.template.confirm}")
	private String smsConfirmTemplate;
	
	public boolean enviarMensaje(AfiliaBitacora afiliaBitacora) {
		String data = "{id:"+afiliaBitacora.getId()+"}";
		String encodedData = new String(Base64.encodeBase64(data.getBytes()));
		StringBuilder mensaje = new StringBuilder();
		mensaje.append("Codigo:"+ afiliaBitacora.getCodigoVerificacion());
		//mensaje.append(" Socio:"+afiliaBitacora.getSoIdStr()); **** CAMBIO PROVISIONAL AFILIACION
		if(afiliaBitacora.getTipoVenta()==1)
			mensaje.append(" Paquete:"+afiliaBitacora.getArticulos());
		
		mensaje.append(" Total:$"+ afiliaBitacora.getPagado().setScale(2));
		mensaje.append(" Aviso privacidad:http://www.priceshoes.com/politicas/aviso-de-privacidad");
		//mensaje.append(" Credencial:"+sms.getUrlCredencial()+encodedData); **** CAMBIO PROVISIONAL AFILIACION 
		log.info("CREDENCIAL VIRTUAL " + urlCredencial+encodedData);
		log.info("SMS length:"+mensaje.toString().length());
		SmsRequest request = new SmsRequest();
		request.setAplicativo("AFILIA");
		request.setPlataforma(smsUser);
		request.setPassword(smsKey);
		request.setUsuario("PortalWeb");
		
		request.setTelefono(afiliaBitacora.getSoCelStr());
		request.setMensaje(mensaje.toString());
		log.info(new Gson().toJson(request));
		return wsSendSms(request);
	}

	public boolean enviarMensajeConfirmacion(AfiliaBitacora afiliaBitacora) { // **** CAMBIO PROVISIONAL AFILIACION
		StringBuilder mensaje = new StringBuilder();
		mensaje.append("Bienvenido a PriceShoes, este es tu número de socio: "+afiliaBitacora.getSoIdStr());
		mensaje.append(". Aviso privacidad:http://www.priceshoes.com/politicas/aviso-de-privacidad");
		
		SmsRequest request = new SmsRequest();
		request.setAplicativo("AFILIA");
		request.setPlataforma(smsUser);
		request.setPassword(smsKey);
		request.setUsuario("PortalWeb");
		request.setTelefono(afiliaBitacora.getSoCelStr());
		request.setMensaje(Normalizer.normalize(mensaje.toString(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
		log.info(new Gson().toJson(request));
			
		return wsSendSms(request);
	}
	
	public boolean enviarCodigoValidacion(UpdateSocioRequest datos, Integer codigo) {
		SmsRequest request = new SmsRequest();
		request.setAplicativo("AFILIA");
		request.setPlataforma(smsUser);
		request.setPassword(smsKey);
		request.setUsuario("PortalWeb");
		request.setTelefono(datos.getSoCelStr());
		request.setMensaje( String.format(smsConfirmTemplate, codigo) );
		
		return wsSendSms(request);		
	}
	
	public boolean wsSendSms(SmsRequest request) {
		boolean enviado = false;
		CloseableHttpClient clientPost = null;

		try {
			clientPost = HttpClientBuilder.create().build();
			String url = smsService;
			String endPoint ="enviarSMS";
			
			HttpPost postRequest = new HttpPost(url+endPoint);
			postRequest.addHeader("accept", "application/json");
			postRequest.addHeader("Content-type", "application/json");
			postRequest.setEntity(new StringEntity(new Gson().toJson(request)));
			
			CloseableHttpResponse response = clientPost.execute(postRequest);
			log.debug("-----------------------------------------------------");
			log.info(endPoint);
			log.info("Status: "+response.getStatusLine().getStatusCode());
			log.debug("StatusLine: "+(response.getStatusLine()));
			log.debug("----------------------------------------");
			
			byte[] buffer = new byte[1024];
			String chunk = null;
			if (response.getEntity() != null) {
				InputStream inputStream = response.getEntity().getContent();
			
				int bytesRead = 0;
				BufferedInputStream bis = new BufferedInputStream(inputStream);
				while ((bytesRead = bis.read(buffer)) != -1){
					chunk = new String(buffer, 0, bytesRead);
					log.debug(chunk);
				}
			}
			
			Response smsResponse = new Gson().fromJson(chunk, Response.class);
			log.info(new Gson().toJson(smsResponse));
			
			if( response.getStatusLine().getStatusCode()==200 && smsResponse.getStatus() == Constants.PROCESO_CORRECTO )
				enviado = true;
		} catch (ClientProtocolException e) {
			log.error(e.getMessage(),e);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		} finally {
			if (clientPost!=null)
			try {
				clientPost.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return enviado;
	}
	
}
