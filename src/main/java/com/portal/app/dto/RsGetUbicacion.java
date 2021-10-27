package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name="P_GET_DETUBIC",
		query="{call PKG_CATALOGOS.P_GET_DETUBIC(?,:tiCveN)}",
		callable=true,
		resultClass=RsGetUbicacion.class)
public class RsGetUbicacion 
{
	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "TI_CVE_N")
	private Integer tiCveN;

	@Column(name = "UAF_CVE_N")
	private Integer uafCveN;
	
	@Column(name = "SUAF_CVE_N")
	private Integer suafCveN;
	
	@Column(name = "DUAF_CVE_N")
	private Integer duafCveN;

	@Column(name = "DUAF_DESC_STR")
	private String suafDescStr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTiCveN() {
		return tiCveN;
	}

	public void setTiCveN(Integer tiCveN) {
		this.tiCveN = tiCveN;
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

	public Integer getDuafCveN() {
		return duafCveN;
	}

	public void setDuafCveN(Integer duafCveN) {
		this.duafCveN = duafCveN;
	}

	public String getSuafDescStr() {
		return suafDescStr;
	}

	public void setSuafDescStr(String suafDescStr) {
		this.suafDescStr = suafDescStr;
	}


	
}
