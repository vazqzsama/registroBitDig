package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name="P_GET_MEDATEN",
				 query="{call PKG_CATALOGOS.P_GET_MEDATEN(?,:tsCveN)}",
				 callable=true,
				 resultClass=RsGetMedAten.class)
public class RsGetMedAten 
{
	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "TS_CVE_N")
	private Integer tsCveN;
	
	@Column(name = "MEDATEN_CVE_N")
	private Integer medatenCveN;
	
	@Column(name = "MEDATEN_DESC_STR")
	private String medatenDescStr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTsCveN() {
		return tsCveN;
	}

	public void setTsCveN(Integer tsCveN) {
		this.tsCveN = tsCveN;
	}

	public Integer getMedatenCveN() {
		return medatenCveN;
	}

	public void setMedatenCveN(Integer medatenCveN) {
		this.medatenCveN = medatenCveN;
	}

	public String getMedatenDescStr() {
		return medatenDescStr;
	}

	public void setMedatenDescStr(String medatenDescStr) {
		this.medatenDescStr = medatenDescStr;
	}

	

}
