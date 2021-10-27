package com.portal.app.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQueries({
@NamedNativeQuery
(
  name="P_GET_CATALOGOS_CAMB",
  query="{ call PKG_AFILIACION_CORE.P_GET_CATALOGOS_CAMB(?) }", 
  callable=true,
  resultClass=ResultsetCatalogosVigentes.class
),
@NamedNativeQuery
(
  name="P_GET_CATALOGOS_LANDING",
  query="{ call PKG_AFILIACION_CORE.P_GET_CATALOGOS_LANDING(?) }",
  callable=true,
  resultClass=ResultsetCatalogosVigentes.class
)
})
public class ResultsetCatalogosVigentes 
{
	@Id
	@Column(name="CA_CVE_N")
	private Long 	caCveN;
	
	@Column(name="CA_DESC_STR")
	private String	caDescStr;
	
	@Column(name="ID_ART")
	private Long	idArt;

	@Column(name="PRE_MAY_N")
	private BigDecimal preMayN;
	
	@Column(name="DOS_X_UNO_PRE_MAY_N")
	private BigDecimal dosXUnoPreMayN;
		
	@Column(name="ES_LANZAMIENTO_N")
	private Integer esLanzamientoN;
	
	public Long getCaCveN() {
		return caCveN;
	}

	public void setCaCveN(Long caCveN) {
		this.caCveN = caCveN;
	}

	public String getCaDescStr() {
		return caDescStr;
	}

	public void setCaDescStr(String caDescStr) {
		this.caDescStr = caDescStr;
	}

	public Long getIdArt() {
		return idArt;
	}

	public void setIdArt(Long idArt) {
		this.idArt = idArt;
	}

	public BigDecimal getPreMayN() {
		return preMayN;
	}

	public void setPreMayN(BigDecimal preMayN) {
		this.preMayN = preMayN;
	}

	public BigDecimal getDosXUnoPreMayN() {
		return dosXUnoPreMayN;
	}

	public void setDosXUnoPreMayN(BigDecimal dosXUnoPreMayN) {
		this.dosXUnoPreMayN = dosXUnoPreMayN;
	}

	public Integer getEsLanzamientoN() {
		return esLanzamientoN;
	}

	public void setEsLanzamientoN(Integer esLanzamientoN) {
		this.esLanzamientoN = esLanzamientoN;
	}
	
	
}
