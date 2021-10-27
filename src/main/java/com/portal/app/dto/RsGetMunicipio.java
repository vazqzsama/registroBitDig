package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name="P_GET_MUNIC",
		query="{call PKG_CATALOGOS.P_GET_MUNIC(?,:paCveN,:edCveN)}",
		callable=true,
		resultClass=RsGetMunicipio.class)
public class RsGetMunicipio 
{
	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "PA_CVE_N")
	private Integer paCveN;

	@Column(name = "ED_CVE_N")
	private Integer edCveN;

	@Column(name = "MU_CVE_N")
	private Integer muCveN;

	@Column(name = "MU_DESC_STR")
	private String muDescStr;

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

	public String getMuDescStr() {
		return muDescStr;
	}

	public void setMuDescStr(String muDescStr) {
		this.muDescStr = muDescStr;
	}

	
}
