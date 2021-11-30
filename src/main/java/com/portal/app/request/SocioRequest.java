package com.portal.app.request;

import com.portal.app.dto.AfiliaBitacora;
import com.portal.app.dto.Socio;

public class SocioRequest extends Request
{
	private static final long serialVersionUID = 1L;
	
	private String rfcPrice;
	private Socio socio;
	private AfiliaBitacora afiliaBitacora;
	
	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public AfiliaBitacora getAfiliaBitacora() {
		return afiliaBitacora;
	}

	public void setAfiliaBitacora(AfiliaBitacora afiliaBitacora) {
		this.afiliaBitacora = afiliaBitacora;
	}

	public String getRfcPrice() {
		return rfcPrice;
	}

	public void setRfcPrice(String rfcPrice) {
		this.rfcPrice = rfcPrice;
	}
	

}
