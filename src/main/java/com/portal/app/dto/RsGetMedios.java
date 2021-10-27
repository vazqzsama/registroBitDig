package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name="P_GET_MEDIOS",
		query="{call PKG_CATALOGOS.P_GET_MEDIOS(?, :tiCveN)}",
		callable=true,
		resultClass=RsGetMedios.class)
public class RsGetMedios 
{
	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "MD_CVE_N")
	private Integer mdCveN;
	
	@Column(name = "MD_DESC_STR")
	private String mdDescStr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMdCveN() {
		return mdCveN;
	}

	public void setMdCveN(Integer mdCveN) {
		this.mdCveN = mdCveN;
	}

	public String getMdDescStr() {
		return mdDescStr;
	}

	public void setMdDescStr(String mdDescStr) {
		this.mdDescStr = mdDescStr;
	}

	
}
