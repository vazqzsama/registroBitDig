package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name="P_GET_TIPOSOC",
				 query="{call PKG_CATALOGOS.P_GET_TIPOSOC(?)}",
				 callable=true,
				 resultClass=RsGetTipoSocio.class)
public class RsGetTipoSocio 
{
	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "TS_CVE_N")
	private Long tsCveN;

	@Column(name = "TS_DESC_STR")
	private String tsDescStr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTsCveN() {
		return tsCveN;
	}

	public void setTsCveN(Long tsCveN) {
		this.tsCveN = tsCveN;
	}

	public String getTsDescStr() {
		return tsDescStr;
	}

	public void setTsDescStr(String tsDescStr) {
		this.tsDescStr = tsDescStr;
	}

	
}
