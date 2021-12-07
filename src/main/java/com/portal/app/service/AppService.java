package com.portal.app.service;

import com.portal.app.dto.BitacoraDigital;
import com.portal.app.dto.RsGetPaqueteAmer;
import com.portal.app.request.AfiliacionRequest;
import com.portal.app.request.AppRequest;
import com.portal.app.request.BitRegRequest;
import com.portal.app.request.ParametrosPendientes;
import com.portal.app.request.ReactivarRequest;
import com.portal.app.request.RfcRequest;
import com.portal.app.request.UpdateSocioRequest;
import com.portal.app.response.AppResponse;
import com.portal.app.response.Response;
import com.portal.app.response.RfcValidResponse;
import com.portal.app.response.SmsValidacionResponse;

public interface AppService {
	
	AppResponse testConexion(AppRequest request);
	BitacoraDigital searchBitacora(String idSocio) throws Exception;
	BitacoraDigital createBitacora(BitRegRequest request) throws Exception;
	BitacoraDigital updateBitacora(BitacoraDigital request) throws Exception;
	AppResponse registrarPendientes(ParametrosPendientes params) throws Exception;
	String getReferenciaPedido(String tipo);
	RfcValidResponse createValidateRfc(RfcRequest request);
	Response reactivarSocio(ReactivarRequest request);
	RsGetPaqueteAmer getPaqueteAmer(AfiliacionRequest request);
	Response updateSocio(UpdateSocioRequest request);
	SmsValidacionResponse sendMjsConfirmacion(UpdateSocioRequest params);
	
}
