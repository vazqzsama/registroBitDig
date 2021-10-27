package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name="P_GET_SUBMEDIOS",
		query="{call PKG_CATALOGOS.P_GET_SUBMEDIOS(?,:mdCveN, :tiCveN)}",
		callable=true,
		resultClass=RsGetSubmedios.class)
public class RsGetSubmedios 
{
	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "MD_CVE_N")
	private Integer mdCveN;

	@Column(name = "SMD_CVE_N")
	private Integer smdCveN;

	@Column(name = "SMD_DESC_STR")
	private String smdDescStr;

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

	public Integer getSmdCveN() {
		return smdCveN;
	}

	public void setSmdCveN(Integer smdCveN) {
		this.smdCveN = smdCveN;
	}

	public String getSmdDescStr() {
		return smdDescStr;
	}

	public void setSmdDescStr(String smdDescStr) {
		this.smdDescStr = smdDescStr;
	}

	
}
