package com.portal.app.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name="P_GET_PAQUETE_AMER",
		query="{call PKG_AMERS.P_GET_PAQUETE_AMER(?,:listaCatalogos)}",
		callable=true,
		resultClass=RsGetPaqueteAmer.class)
public class RsGetPaqueteAmer 
{
	@Id
	@Column(name = "AMER_ESTATUS_N")
	private Long amerEstatusN;

	@Column(name = "AMER_CANTIDAD_N")
	private Integer amerCantidadN;

	@Column(name = "AMER_PAQUETE_STR")
	private String amerPaqueteStr;

	@Column(name = "AMER_TOTAL_N")
	private BigDecimal amerTotalN;

	@Column(name = "AMER_TOTAL_DESC_N")
	private BigDecimal amerTotalDescN;
	
	@Column(name = "AMER_PORC_DESC")
	private String amerPorcDesc;

	@Column(name = "AMER_DESC_STR")
	private String amerDescStr;

	public Long getAmerEstatusN() {
		return amerEstatusN;
	}

	public void setAmerEstatusN(Long amerEstatusN) {
		this.amerEstatusN = amerEstatusN;
	}

	public Integer getAmerCantidadN() {
		return amerCantidadN;
	}

	public void setAmerCantidadN(Integer amerCantidadN) {
		this.amerCantidadN = amerCantidadN;
	}

	public String getAmerPaqueteStr() {
		return amerPaqueteStr;
	}

	public void setAmerPaqueteStr(String amerPaqueteStr) {
		this.amerPaqueteStr = amerPaqueteStr;
	}

	public String getAmerDescStr() {
		return amerDescStr;
	}

	public void setAmerDescStr(String amerDescStr) {
		this.amerDescStr = amerDescStr;
	}

	public BigDecimal getAmerTotalN() {
		return amerTotalN;
	}

	public void setAmerTotalN(BigDecimal amerTotalN) {
		this.amerTotalN = amerTotalN;
	}

	public BigDecimal getAmerTotalDescN() {
		return amerTotalDescN;
	}

	public void setAmerTotalDescN(BigDecimal amerTotalDescN) {
		this.amerTotalDescN = amerTotalDescN;
	}

	public String getAmerPorcDesc() {
		return amerPorcDesc;
	}

	public void setAmerPorcDesc(String amerPorcDesc) {
		this.amerPorcDesc = amerPorcDesc;
	}
	
	
	
	
}
