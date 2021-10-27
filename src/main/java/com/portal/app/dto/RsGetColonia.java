package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name="P_GET_COLONIA",
		query="{call PKG_CATALOGOS.P_GET_COLONIA(?,:paCveN,:edCveN,:muCveN,:colDescStr)}",
		callable=true,
		resultClass=RsGetColonia.class)
public class RsGetColonia 
{
	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "COD_POST_STR")
	private String codPostStr;

	@Column(name = "ED_CVE_STR")
	private String edCveStr;

	@Column(name = "MUN_CVE_STR")
	private String munCveStr;

	@Column(name = "PA_CVE_N")
	private Integer paCveN;

	@Column(name = "ED_CVE_N")
	private Integer edCveN;

	@Column(name = "MU_CVE_N")
	private Integer muCveN;

	@Column(name = "COL_DESC_STR")
	private String colDescStr;

	@Column(name = "SOFT_MU_DESC_STR")
	private String softMuDescStr;

	@Column(name = "SEPOMEX_MU_DESC_STR")
	private String sepomexMuDescStr;

	@Column(name = "SEPOMEX_CD_DESC_STR")
	private String sepomexCdDescStr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodPostStr() {
		return codPostStr;
	}

	public void setCodPostStr(String codPostStr) {
		this.codPostStr = codPostStr;
	}

	public String getEdCveStr() {
		return edCveStr;
	}

	public void setEdCveStr(String edCveStr) {
		this.edCveStr = edCveStr;
	}

	public String getMunCveStr() {
		return munCveStr;
	}

	public void setMunCveStr(String munCveStr) {
		this.munCveStr = munCveStr;
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

	public String getColDescStr() {
		return colDescStr;
	}

	public void setColDescStr(String colDescStr) {
		this.colDescStr = colDescStr;
	}

	public String getSoftMuDescStr() {
		return softMuDescStr;
	}

	public void setSoftMuDescStr(String softMuDescStr) {
		this.softMuDescStr = softMuDescStr;
	}

	public String getSepomexMuDescStr() {
		return sepomexMuDescStr;
	}

	public void setSepomexMuDescStr(String sepomexMuDescStr) {
		this.sepomexMuDescStr = sepomexMuDescStr;
	}

	public String getSepomexCdDescStr() {
		return sepomexCdDescStr;
	}

	public void setSepomexCdDescStr(String sepomexCdDescStr) {
		this.sepomexCdDescStr = sepomexCdDescStr;
	}



	
}
