package com.portal.app.dto;

public class Afiliacion 
{
	private Integer tsCveN;   // Tipo de Socio
	private Integer paCveN;   // Pais
	private Integer edCveN;   // Estado
	private Integer muCveN;   // Municipio
	private String  colDescStr; // Colonia
	private String  codPostStr;  // Codigo Postal
	private Integer mdCveN;   // Medio
	private Integer uafCveN;  // Ubicacion de la Afiliacion
	private Integer suafCveN; // Sub Ubicacion de la Afiliacion
	private Integer tiCveN; // Tienda
	
	public Integer getTsCveN() {
		return tsCveN;
	}
	public void setTsCveN(Integer tsCveN) {
		this.tsCveN = tsCveN;
	}
	public Integer getPaCveN() {
		return paCveN;
	}
	public void setPaCveN(Integer paCveN) {
		this.paCveN = paCveN;
	}
	public Integer getEdCveN() {
		return edCveN;
	}
	public void setEdCveN(Integer edCveN) {
		this.edCveN = edCveN;
	}
	public Integer getMuCveN() {
		return muCveN;
	}
	public void setMuCveN(Integer muCveN) {
		this.muCveN = muCveN;
	}
	public Integer getMdCveN() {
		return mdCveN;
	}
	public void setMdCveN(Integer mdCveN) {
		this.mdCveN = mdCveN;
	}
	public Integer getUafCveN() {
		return uafCveN;
	}
	public void setUafCveN(Integer uafCveN) {
		this.uafCveN = uafCveN;
	}
	public Integer getSuafCveN() {
		return suafCveN;
	}
	public void setSuafCveN(Integer suafCveN) {
		this.suafCveN = suafCveN;
	}
	public String getColDescStr() {
		return colDescStr;
	}
	public void setColDescStr(String colDescStr) {
		this.colDescStr = colDescStr;
	}
	public String getCodPostStr() {
		return codPostStr;
	}
	public void setCodPostStr(String codPostStr) {
		this.codPostStr = codPostStr;
	}
	public Integer getTiCveN() {
		return tiCveN;
	}
	public void setTiCveN(Integer tiCveN) {
		this.tiCveN = tiCveN;
	}

	

}
