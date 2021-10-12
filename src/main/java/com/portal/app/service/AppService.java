package com.portal.app.service;

import com.portal.app.dto.BitacoraDigital;
import com.portal.app.request.AppRequest;
import com.portal.app.request.BitRegRequest;
import com.portal.app.request.ParametrosPendientes;
import com.portal.app.response.AppResponse;

public interface AppService {
	
	AppResponse testConexion(AppRequest request);
	BitacoraDigital searchBitacora(String idSocio) throws Exception;
	BitacoraDigital createBitacora(BitRegRequest request) throws Exception;
	BitacoraDigital updateBitacora(BitacoraDigital request) throws Exception;
	AppResponse registrarPendientes(ParametrosPendientes params) throws Exception;
	
}
