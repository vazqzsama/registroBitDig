package com.portal.app.response;

import java.util.List;

import com.portal.app.dto.RsGetColonia;
import com.portal.app.dto.RsGetColoniaCP;
import com.portal.app.dto.RsGetEstadisticoAfi;
import com.portal.app.dto.RsGetEstado;
import com.portal.app.dto.RsGetMedAten;
import com.portal.app.dto.RsGetMedios;
import com.portal.app.dto.RsGetMunicipio;
import com.portal.app.dto.RsGetPais;
import com.portal.app.dto.RsGetPaqueteAmer;
import com.portal.app.dto.RsGetSubmedios;
import com.portal.app.dto.RsGetTipoSocio;
import com.portal.app.dto.RsGetUbicacion;

public class AfiliacionResponse extends Response {
	
	private static final long serialVersionUID = 1L;

	public AfiliacionResponse() {}
	
	private List<RsGetTipoSocio> rsGetTipoSocio;
	
	private List<RsGetMedAten> rsGetMedAten;
	
	private List<RsGetMedios> rsGetMedios;
	
	private List<RsGetSubmedios> rsGetSubmedios;
	
	private List<RsGetColonia> rsGetColonia;
	
	private List<RsGetColoniaCP> rsGetColoniaCP;
	
	private List<RsGetUbicacion> rsGetUbicacion;
	
	private List<RsGetPais> rsGetPais;
	
	private List<RsGetEstado> rsGetEstado;
	
	private List<RsGetMunicipio> rsGetMunicipio;
	
	private RsGetPaqueteAmer rsGetPaqueteAmer;
	
	private List<RsGetEstadisticoAfi> rsGetEstadisticoAfi;

	public List<RsGetTipoSocio> getRsGetTipoSocio() {
		return rsGetTipoSocio;
	}
	
	public void setRsGetTipoSocio(List<RsGetTipoSocio> rsGetTipoSocio) {
		this.rsGetTipoSocio = rsGetTipoSocio;
	}

	public List<RsGetMedAten> getRsGetMedAten() {
		return rsGetMedAten;
	}

	public void setRsGetMedAten(List<RsGetMedAten> rsGetMedAten) {
		this.rsGetMedAten = rsGetMedAten;
	}

	public List<RsGetMedios> getRsGetMedios() {
		return rsGetMedios;
	}

	public void setRsGetMedios(List<RsGetMedios> rsGetMedios) {
		this.rsGetMedios = rsGetMedios;
	}

	public List<RsGetSubmedios> getRsGetSubmedios() {
		return rsGetSubmedios;
	}

	public void setRsGetSubmedios(List<RsGetSubmedios> rsGetSubmedios) {
		this.rsGetSubmedios = rsGetSubmedios;
	}

	public List<RsGetColonia> getRsGetColonia() {
		return rsGetColonia;
	}

	public void setRsGetColonia(List<RsGetColonia> rsGetColonia) {
		this.rsGetColonia = rsGetColonia;
	}

	public List<RsGetColoniaCP> getRsGetColoniaCP() {
		return rsGetColoniaCP;
	}

	public void setRsGetColoniaCP(List<RsGetColoniaCP> rsGetColoniaCP) {
		this.rsGetColoniaCP = rsGetColoniaCP;
	}

	public List<RsGetUbicacion> getRsGetUbicacion() {
		return rsGetUbicacion;
	}

	public void setRsGetUbicacion(List<RsGetUbicacion> rsGetUbicacion) {
		this.rsGetUbicacion = rsGetUbicacion;
	}

	public List<RsGetPais> getRsGetPais() {
		return rsGetPais;
	}

	public void setRsGetPais(List<RsGetPais> rsGetPais) {
		this.rsGetPais = rsGetPais;
	}

	public List<RsGetEstado> getRsGetEstado() {
		return rsGetEstado;
	}

	public void setRsGetEstado(List<RsGetEstado> rsGetEstado) {
		this.rsGetEstado = rsGetEstado;
	}

	public List<RsGetMunicipio> getRsGetMunicipio() {
		return rsGetMunicipio;
	}

	public void setRsGetMunicipio(List<RsGetMunicipio> rsGetMunicipio) {
		this.rsGetMunicipio = rsGetMunicipio;
	}

	public List<RsGetEstadisticoAfi> getRsGetEstadisticoAfi() {
		return rsGetEstadisticoAfi;
	}

	public void setRsGetEstadisticoAfi(List<RsGetEstadisticoAfi> rsGetEstadisticoAfi) {
		this.rsGetEstadisticoAfi = rsGetEstadisticoAfi;
	}

	public RsGetPaqueteAmer getRsGetPaqueteAmer() {
		return rsGetPaqueteAmer;
	}

	public void setRsGetPaqueteAmer(RsGetPaqueteAmer rsGetPaqueteAmer) {
		this.rsGetPaqueteAmer = rsGetPaqueteAmer;
	}


	

}
