package com.portal.app.dao;

import java.util.List;

import com.portal.app.dto.AfilRegistrar;
import com.portal.app.dto.BitacoraDigital;
import com.portal.app.dto.PsPedTmk;
import com.portal.app.request.AppRequest;
import com.portal.app.request.ParametrosPendientes;
import com.portal.app.response.AppResponse;

public interface AppDao {
	
	public AppResponse test (AppRequest request);
	public BitacoraDigital createBitacora(BitacoraDigital bit);
	public BitacoraDigital updateBitacora(BitacoraDigital bit);
	public String getReferenciaPedido();
	public PsPedTmk getInfoPedido(Long tiCveN, Long ptNumN, String soId);
	public boolean searchRegistro(String email, String idSocio,String nombre);
	public boolean liberarCorreo(BitacoraDigital bit);
	public List<AfilRegistrar> getPendientes(ParametrosPendientes params);
	
}
