package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name="P_GET_PAIS",
		query="{call PKG_CATALOGOS.P_GET_PAIS(?)}",
		callable=true,
		resultClass=RsGetPais.class)
public class RsGetPais 
{
	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "PA_CVE_N")
	private Integer paCveN;

	@Column(name = "PA_DESC_STR")
	private String paDescstr;

	@Column(name = "PA_AB_STR")
	private String paAbcstr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPaCveN() {
		return paCveN;
	}

	public void setPaCveN(Integer paCveN) {
		this.paCveN = paCveN;
	}

	public String getPaDescstr() {
		return paDescstr;
	}

	public void setPaDescstr(String paDescstr) {
		this.paDescstr = paDescstr;
	}

	public String getPaAbcstr() {
		return paAbcstr;
	}

	public void setPaAbcstr(String paAbcstr) {
		this.paAbcstr = paAbcstr;
	}
	
}
