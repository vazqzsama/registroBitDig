package com.portal.app.request;

public class ReactivarRequest extends Request {

	private static final long serialVersionUID = -7005221209958797303L;
	
	private String idSocio;
	private String rfcPrice;
	
	public String getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}
	public String getRfcPrice() {
		return rfcPrice;
	}
	public void setRfcPrice(String rfcPrice) {
		this.rfcPrice = rfcPrice;
	}
		
}
