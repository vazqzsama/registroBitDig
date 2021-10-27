package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name="P_ESTADISTICO_AFILIADOR",
		query="{call PKG_AFILIACION.P_ESTADISTICO_AFILIADOR(?,:seNomEmpN)}",
		callable=true,
		resultClass=RsGetEstadisticoAfi.class)
public class RsGetEstadisticoAfi 
{
	@Id
	@Column(name = "SE_NOMEMP_N")
	private Long seNomEmpN;

	@Column(name = "AFI_DIA_N")
	private Long afiDiaN;

	@Column(name = "AFI_SEM_N")
	private Long afiSemN;
	
	@Column(name = "AFI_MES_N")
	private Long afiMesN;
	
	@Column(name = "AFI_TOT_N")
	private Long afiTotN;

	public Long getSeNomEmpN() {
		return seNomEmpN;
	}

	public void setSeNomEmpN(Long seNomEmpN) {
		this.seNomEmpN = seNomEmpN;
	}

	public Long getAfiDiaN() {
		return afiDiaN;
	}

	public void setAfiDiaN(Long afiDiaN) {
		this.afiDiaN = afiDiaN;
	}

	public Long getAfiSemN() {
		return afiSemN;
	}

	public void setAfiSemN(Long afiSemN) {
		this.afiSemN = afiSemN;
	}

	public Long getAfiMesN() {
		return afiMesN;
	}

	public void setAfiMesN(Long afiMesN) {
		this.afiMesN = afiMesN;
	}

	public Long getAfiTotN() {
		return afiTotN;
	}

	public void setAfiTotN(Long afiTotN) {
		this.afiTotN = afiTotN;
	}

	
}
