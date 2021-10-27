package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name="P_GET_ESTADO",
		query="{call PKG_CATALOGOS.P_GET_ESTADO(?,:paCveN)}",
		callable=true,
		resultClass=RsGetEstado.class)
public class RsGetEstado 
{
//	
//	@Column(name = "ID")
//	private Long id;

//	@Column(name = "PA_CVE_N")
//	private Integer paCveN;

	@Id
	@Column(name = "ED_CVE_N")
	private Integer edCveN;

	@Column(name = "EDO_DESC_STR")
	private String edoDescStr;

//	@Column(name = "EDO_AB_STR")
//	private String edoAbStr;

//	public Long getId() {
//		return id;
//	}

//	public void setId(Long id) {
//		this.id = id;
//	}

//	public Integer getPaCveN() {
//		return paCveN;
//	}
//
//	public void setPaCveN(Integer paCveN) {
//		this.paCveN = paCveN;
//	}

	public Integer getEdCveN() {
		return edCveN;
	}

	public void setEdCveN(Integer edCveN) {
		this.edCveN = edCveN;
	}

	public String getEdoDescStr() {
		return edoDescStr;
	}

	public void setEdoDescStr(String edoDescStr) {
		this.edoDescStr = edoDescStr;
	}

//	public String getEdoAbStr() {
//		return edoAbStr;
//	}
//
//	public void setEdoAbStr(String edoAbStr) {
//		this.edoAbStr = edoAbStr;
//	}
	
	
}
