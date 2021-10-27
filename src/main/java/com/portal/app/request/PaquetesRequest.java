package com.portal.app.request;

public class PaquetesRequest extends  Request  
{
	private static final long serialVersionUID = 1L;
	private Long	nomina;
	private String  password;
	private String	soIdStr;
	private Long    tiCveN;
	private String nombreL;
	private Long celularL;
	
	public Long getNomina() {
		return nomina;
	}
	public void setNomina(Long nomina) {
		this.nomina = nomina;
	}
	public String getPassword() {
		return password;
	} 
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSoIdStr() {
		return soIdStr;
	}
	public void setSoIdStr(String soIdStr) {
		this.soIdStr = soIdStr;
	}
	public Long getTiCveN() {
		return tiCveN;
	}
	public void setTiCveN(Long tiCveN) {
		this.tiCveN = tiCveN;
	}
	public String getNombreL() {
		return nombreL;
	}
	public void setNombreL(String nombreL) {
		this.nombreL = nombreL;
	}
	public Long getCelularL() {
		return celularL;
	}
	public void setCelularL(Long celularL) {
		this.celularL = celularL;
	}
	
	
	
		
}
