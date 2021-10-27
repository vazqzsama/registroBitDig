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
  name="P_GET_PAQUETES_CAMB",
  query=" { call PKG_AFILIACION_CORE.P_GET_PAQUETES_CAMB(?) } ",
  callable=true,
  resultClass=ResultsetPaquetesVig.class
),
@NamedNativeQuery
(
  name="P_GET_PAQUETES_LANDING",
  query=" { call PKG_AFILIACION_CORE.P_GET_PAQUETES_LANDING(?) } ",
  callable=true,
  resultClass=ResultsetPaquetesVig.class
)
})

public class ResultsetPaquetesVig 
{
	@Id
	@Column(name="ID_ART")
	private Long 		idArt;
	
	@Column(name="AR_DESC_STR")
	private String		arDescStr;
	
	@Column(name="PRE_MAY_N")
	private BigDecimal	preMayN;
	
	@Column(name="AR_FALTA_DT")
	private String		arFaltaDt;
	
	public Long getIdArt() {
		return idArt;
	}
	public void setIdArt(Long idArt) {
		this.idArt = idArt;
	}
	public String getArDescStr() {
		return arDescStr;
	}
	public void setArDescStr(String arDescStr) {
		this.arDescStr = arDescStr;
	}
	public BigDecimal getPreMayN() {
		return preMayN;
	}
	public void setPreMayN(BigDecimal preMayN) {
		this.preMayN = preMayN;
	}
	public String getArFaltaDt() {
		return arFaltaDt;
	}
	public void setArFaltaDt(String arFaltaDt) {
		this.arFaltaDt = arFaltaDt;
	}
	
}
