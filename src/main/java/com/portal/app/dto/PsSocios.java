package com.portal.app.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PS_SOCIOS@LRCORPPRICE")
public class PsSocios implements Serializable{

	private static final long serialVersionUID = 6034332264945825477L;

	@Id
	@Column(name="SO_ID_STR")
	private String soIdStr;
	
	@Column(name="TI_CVE_N")
	private Long tiCveN;
	
	@Column(name="PA_CVE_N")
	private Long pais;
	
	@Column(name="ED_CVE_N")
	private Long estado;
	
	@Column(name="TS_CVE_N")
	private Long tsCveN;
	
	@Column(name="SO_NOM_STR")
	private String soNombreStr;
	
	@Column(name="SO_APAT_STR")
	private String soPaternoStr;
	
	@Column(name="SO_AMAT_STR")
	private String soMaternoStr;
	
	@Column(name="SO_FNAC_DT")
	private Date soFnacDt;
	
	@Column(name="SO_FALTA_DT")
	private Date soFaltaDt;
	
	@Column(name="SO_FREG_DT")
	private Date soFregDt;
	
	@Column(name="SO_CALLE_STR")
	private String soCalleStr;
	
	@Column(name="SO_NUM_STR")
	private String soNumStr;
	
	@Column(name="SO_COL_STR")
	private String soColStr;
	
	@Column(name="SO_NCRED_N")
	private Long soNcredN;
	
	@Column(name="MU_CVE_N")
	private Long muCveN;
	
	@Column(name="SO_CD_STR")
	private String soCdStr;
	
	@Column(name="SO_CP_STR")
	private String soCpStr;
	
	@Column(name="SO_TEL1_STR")
	private String soTel1Str;
	
	@Column(name="SO_TEL2_STR")
	private String soTel2Str;
	
	@Column(name="SO_EMAIL_STR")
	private String soEmailStr;
	
	@Column(name="SO_SEXO_STR")
	private String soSexoStr;
	
	@Column(name="SO_EST_STR")
	private String soEstStr;
	
	@Column(name="SO_TIPO_STR")
	private String soTipoStr;
	
	@Column(name="SO_SALD_N")
	private Double soSaldN;
	
	@Column(name="SO_DG_STR")
	private String soDgStr;
	
	@Column(name="SO_NUMINT_STR")
	private String soNumintStr;
	
	@Column(name="CLL_NUMLLAM_N")
	private Double cllNumllam;
	
	@Column(name="PS_SO_ID_STR")
	private String psSoIdStr;
	
	@Column(name="SO_REF_STR")
	private String soRefStr;
	
	@Column(name="SO_CVE1_STR")
	private String soCve1Str;
	
	@Column(name="SO_LADA1_STR")
	private String soLada1Str;

	@Column(name="SO_HOR1_N")
	private Long soHor1Str;
	
	@Column(name="SO_CVE2_STR")
	private String soCve2Str;
	
	@Column(name="SO_LADA2_STR")
	private String soLada2Str;
	
	@Column(name="SO_HOR2_N")
	private Long soHor2Str;
	
	@Column(name="SO_CVE3_STR")
	private String soCve3Str;
	
	@Column(name="SO_LADA3_STR")
	private String soLada3Str;
	
	@Column(name="SO_TEL3_STR")
	private String soTel3Str;
	
	@Column(name="SO_HOR3_N")
	private Long soHor3Str;
	
	@Column(name="SO_CVE4_STR")
	private String soCve4Str;
	
	@Column(name="SO_LADA4_STR")
	private String soLada4Str;
	
	@Column(name="SO_TEL4_STR")
	private String soTel4Str;
	
	@Column(name="SO_EXT4_STR")
	private String soExt4Str;
	
	@Column(name="SO_HOR4_N")
	private Long soHor4Str;
	
	@Column(name="SO_CVE5_STR")
	private String soCve5Str;
	
	@Column(name="SO_LADA5_STR")
	private String soLada5Str;
	
	@Column(name="SO_TEL5_STR")
	private String soTel5Str;
	
	@Column(name="SO_HOR5_N")
	private Long soHor5Str;
	
	@Column(name="SO_CVE6_STR")
	private String soCve6Str;
	
	@Column(name="SO_LADA6_STR")
	private String soLada6Str;
	
	@Column(name="SO_TEL6_STR")
	private String soTel6Str;
	
	@Column(name="SO_DV_STR")
	private String soDvStr;
	
	@Column(name="USR_CVE_PSTR")
	private String usrCveStr;
	
	@Column(name="SO_EXT5_STR")
	private String soExt5Str;
	
	@Column(name="SO_CONTMK_STR")
	private String soConttmkStr;
	
	@Column(name="PRT_ID_N")
	private Long prtIdN;
	
	@Column(name="SO_SALDANT_N")
	private Double soSaldantN;
	
	@Column(name="SO_IDPADRE_STR")
	private String soIdPadreStr;
	
	@Column(name="SO_NIVEL_STR")
	private String soNivelStr;
	
	@Column(name="SO_CCOMP_N")
	private Long soCcompN;
	
	@Column(name="SO_IDRECOM_STR")
	private String soIdrecomStr;
	
	@Column(name="SO_CVEELECTOR_STR")
	private String soCveElectorStr;
	
	@Column(name="SO_NVOSOC_DT")
	private Date soNvoSocDt;
	
	@Column(name="SO_MUNIC_STR")
	private String soMunicStr;
	
	@Column(name="SO_DIRGR_STR")
	private String soDirgrStr;
	
	@Column(name="SO_MANZANA_STR")
	private String soManzanaStr;
	
	@Column(name="SO_LOTE_STR")
	private String soLoteStr;
	
	@Column(name="SO_INTERIOR_STR")
	private String soInteriorStr;
	
	@Column(name="SE_COM_STR")
	private String seComStr;
	
	@Column(name="SO_VIG_DT")
	private Date soVigDt;
	
	@Column(name="SO_NOMINA_N")
	private Long soNominaN;
	
	@Column(name="SAPS_CVE_STR")
	private String sapsCveStr;
	
	@Column(name="SO_LEALT_N")
	private Long soLealtN;
	
	@Column(name="NVO_MU_CVE_N")
	private Long nvoMuCveN;

	@Column(name="SO_FULTCOMP_DT")
	private Date soFultCompDt;
	
	@Column(name="SO_FVIGMDG_DT")
	private Date soVigMdgDt;
	
	@Column(name="SO_SORFC_STR")
	private String soSoRfcStr;

	@Column(name="SO_VALIDADO_STR")
	private String soValidadoStr;
	
	public String getSoIdStr() {
		return soIdStr;
	}

	public void setSoIdStr(String soIdStr) {
		this.soIdStr = soIdStr;
	}

	public Long getTiCveN() {
		return tiCveN;
	}

	public void setTiCveN(Long tiCveN) {
		this.tiCveN = tiCveN;
	}

	public Long getPais() {
		return pais;
	}

	public void setPais(Long pais) {
		this.pais = pais;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Long getTsCveN() {
		return tsCveN;
	}

	public void setTsCveN(Long tsCveN) {
		this.tsCveN = tsCveN;
	}

	public String getSoNombreStr() {
		return soNombreStr;
	}

	public void setSoNombreStr(String soNombreStr) {
		this.soNombreStr = soNombreStr;
	}

	public String getSoPaternoStr() {
		return soPaternoStr;
	}

	public void setSoPaternoStr(String soPaternoStr) {
		this.soPaternoStr = soPaternoStr;
	}

	public String getSoMaternoStr() {
		return soMaternoStr;
	}

	public void setSoMaternoStr(String soMaternoStr) {
		this.soMaternoStr = soMaternoStr;
	}

	public Date getSoFaltaDt() {
		return soFaltaDt;
	}

	public void setSoFaltaDt(Date soFaltaDt) {
		this.soFaltaDt = soFaltaDt;
	}

	public Date getSoFnacDt() {
		return soFnacDt;
	}

	public void setSoFnacDt(Date soFnacDt) {
		this.soFnacDt = soFnacDt;
	}

	public Date getSoFregDt() {
		return soFregDt;
	}

	public void setSoFregDt(Date soFregDt) {
		this.soFregDt = soFregDt;
	}

	public String getSoCalleStr() {
		return soCalleStr;
	}

	public void setSoCalleStr(String soCalleStr) {
		this.soCalleStr = soCalleStr;
	}

	public String getSoNumStr() {
		return soNumStr;
	}

	public void setSoNumStr(String soNumStr) {
		this.soNumStr = soNumStr;
	}

	public String getSoColStr() {
		return soColStr;
	}

	public void setSoColStr(String soColStr) {
		this.soColStr = soColStr;
	}

	public Long getSoNcredN() {
		return soNcredN;
	}

	public void setSoNcredN(Long soNcredN) {
		this.soNcredN = soNcredN;
	}

	public Long getMuCveN() {
		return muCveN;
	}

	public void setMuCveN(Long muCveN) {
		this.muCveN = muCveN;
	}

	public String getSoCdStr() {
		return soCdStr;
	}

	public void setSoCdStr(String soCdStr) {
		this.soCdStr = soCdStr;
	}

	public String getSoCpStr() {
		return soCpStr;
	}

	public void setSoCpStr(String soCpStr) {
		this.soCpStr = soCpStr;
	}

	public String getSoTel1Str() {
		return soTel1Str;
	}

	public void setSoTel1Str(String soTel1Str) {
		this.soTel1Str = soTel1Str;
	}

	public String getSoTel2Str() {
		return soTel2Str;
	}

	public void setSoTel2Str(String soTel2Str) {
		this.soTel2Str = soTel2Str;
	}

	public String getSoEmailStr() {
		return soEmailStr;
	}

	public void setSoEmailStr(String soEmailStr) {
		this.soEmailStr = soEmailStr;
	}

	public String getSoSexoStr() {
		return soSexoStr;
	}

	public void setSoSexoStr(String soSexoStr) {
		this.soSexoStr = soSexoStr;
	}

	public String getSoEstStr() {
		return soEstStr;
	}

	public void setSoEstStr(String soEstStr) {
		this.soEstStr = soEstStr;
	}

	public String getSoTipoStr() {
		return soTipoStr;
	}

	public void setSoTipoStr(String soTipoStr) {
		this.soTipoStr = soTipoStr;
	}

	public Double getSoSaldN() {
		return soSaldN;
	}

	public void setSoSaldN(Double soSaldN) {
		this.soSaldN = soSaldN;
	}

	public String getSoDgStr() {
		return soDgStr;
	}

	public void setSoDgStr(String soDgStr) {
		this.soDgStr = soDgStr;
	}

	public String getSoNumintStr() {
		return soNumintStr;
	}

	public void setSoNumintStr(String soNumintStr) {
		this.soNumintStr = soNumintStr;
	}

	public Double getCllNumllam() {
		return cllNumllam;
	}

	public void setCllNumllam(Double cllNumllam) {
		this.cllNumllam = cllNumllam;
	}

	public String getPsSoIdStr() {
		return psSoIdStr;
	}

	public void setPsSoIdStr(String psSoIdStr) {
		this.psSoIdStr = psSoIdStr;
	}

	public String getSoRefStr() {
		return soRefStr;
	}

	public void setSoRefStr(String soRefStr) {
		this.soRefStr = soRefStr;
	}

	public String getSoCve1Str() {
		return soCve1Str;
	}

	public void setSoCve1Str(String soCve1Str) {
		this.soCve1Str = soCve1Str;
	}

	public String getSoLada1Str() {
		return soLada1Str;
	}

	public void setSoLada1Str(String soLada1Str) {
		this.soLada1Str = soLada1Str;
	}

	public Long getSoHor1Str() {
		return soHor1Str;
	}

	public void setSoHor1Str(Long soHor1Str) {
		this.soHor1Str = soHor1Str;
	}

	public String getSoCve2Str() {
		return soCve2Str;
	}

	public void setSoCve2Str(String soCve2Str) {
		this.soCve2Str = soCve2Str;
	}

	public String getSoLada2Str() {
		return soLada2Str;
	}

	public void setSoLada2Str(String soLada2Str) {
		this.soLada2Str = soLada2Str;
	}

	public Long getSoHor2Str() {
		return soHor2Str;
	}

	public void setSoHor2Str(Long soHor2Str) {
		this.soHor2Str = soHor2Str;
	}

	public String getSoCve3Str() {
		return soCve3Str;
	}

	public void setSoCve3Str(String soCve3Str) {
		this.soCve3Str = soCve3Str;
	}

	public String getSoLada3Str() {
		return soLada3Str;
	}

	public void setSoLada3Str(String soLada3Str) {
		this.soLada3Str = soLada3Str;
	}

	public String getSoTel3Str() {
		return soTel3Str;
	}

	public void setSoTel3Str(String soTel3Str) {
		this.soTel3Str = soTel3Str;
	}

	public Long getSoHor3Str() {
		return soHor3Str;
	}

	public void setSoHor3Str(Long soHor3Str) {
		this.soHor3Str = soHor3Str;
	}

	public String getSoCve4Str() {
		return soCve4Str;
	}

	public void setSoCve4Str(String soCve4Str) {
		this.soCve4Str = soCve4Str;
	}

	public String getSoLada4Str() {
		return soLada4Str;
	}

	public void setSoLada4Str(String soLada4Str) {
		this.soLada4Str = soLada4Str;
	}

	public String getSoTel4Str() {
		return soTel4Str;
	}

	public void setSoTel4Str(String soTel4Str) {
		this.soTel4Str = soTel4Str;
	}

	public String getSoExt4Str() {
		return soExt4Str;
	}

	public void setSoExt4Str(String soExt4Str) {
		this.soExt4Str = soExt4Str;
	}

	public Long getSoHor4Str() {
		return soHor4Str;
	}

	public void setSoHor4Str(Long soHor4Str) {
		this.soHor4Str = soHor4Str;
	}

	public String getSoCve5Str() {
		return soCve5Str;
	}

	public void setSoCve5Str(String soCve5Str) {
		this.soCve5Str = soCve5Str;
	}

	public String getSoLada5Str() {
		return soLada5Str;
	}

	public void setSoLada5Str(String soLada5Str) {
		this.soLada5Str = soLada5Str;
	}

	public String getSoTel5Str() {
		return soTel5Str;
	}

	public void setSoTel5Str(String soTel5Str) {
		this.soTel5Str = soTel5Str;
	}

	public Long getSoHor5Str() {
		return soHor5Str;
	}

	public void setSoHor5Str(Long soHor5Str) {
		this.soHor5Str = soHor5Str;
	}

	public String getSoCve6Str() {
		return soCve6Str;
	}

	public void setSoCve6Str(String soCve6Str) {
		this.soCve6Str = soCve6Str;
	}

	public String getSoLada6Str() {
		return soLada6Str;
	}

	public void setSoLada6Str(String soLada6Str) {
		this.soLada6Str = soLada6Str;
	}

	public String getSoTel6Str() {
		return soTel6Str;
	}

	public void setSoTel6Str(String soTel6Str) {
		this.soTel6Str = soTel6Str;
	}

	public String getSoDvStr() {
		return soDvStr;
	}

	public void setSoDvStr(String soDvStr) {
		this.soDvStr = soDvStr;
	}

	public String getUsrCveStr() {
		return usrCveStr;
	}

	public void setUsrCveStr(String usrCveStr) {
		this.usrCveStr = usrCveStr;
	}

	public String getSoExt5Str() {
		return soExt5Str;
	}

	public void setSoExt5Str(String soExt5Str) {
		this.soExt5Str = soExt5Str;
	}

	public String getSoConttmkStr() {
		return soConttmkStr;
	}

	public void setSoConttmkStr(String soConttmkStr) {
		this.soConttmkStr = soConttmkStr;
	}

	public Long getPrtIdN() {
		return prtIdN;
	}

	public void setPrtIdN(Long prtIdN) {
		this.prtIdN = prtIdN;
	}

	public Double getSoSaldantN() {
		return soSaldantN;
	}

	public void setSoSaldantN(Double soSaldantN) {
		this.soSaldantN = soSaldantN;
	}

	public String getSoIdPadreStr() {
		return soIdPadreStr;
	}

	public void setSoIdPadreStr(String soIdPadreStr) {
		this.soIdPadreStr = soIdPadreStr;
	}

	public String getSoNivelStr() {
		return soNivelStr;
	}

	public void setSoNivelStr(String soNivelStr) {
		this.soNivelStr = soNivelStr;
	}

	public Long getSoCcompN() {
		return soCcompN;
	}

	public void setSoCcompN(Long soCcompN) {
		this.soCcompN = soCcompN;
	}

	public String getSoIdrecomStr() {
		return soIdrecomStr;
	}

	public void setSoIdrecomStr(String soIdrecomStr) {
		this.soIdrecomStr = soIdrecomStr;
	}

	public String getSoCveElectorStr() {
		return soCveElectorStr;
	}

	public void setSoCveElectorStr(String soCveElectorStr) {
		this.soCveElectorStr = soCveElectorStr;
	}

	public Date getSoNvoSocDt() {
		return soNvoSocDt;
	}

	public void setSoNvoSocDt(Date soNvoSocDt) {
		this.soNvoSocDt = soNvoSocDt;
	}

	public String getSoMunicStr() {
		return soMunicStr;
	}

	public void setSoMunicStr(String soMunicStr) {
		this.soMunicStr = soMunicStr;
	}

	public String getSoDirgrStr() {
		return soDirgrStr;
	}

	public void setSoDirgrStr(String soDirgrStr) {
		this.soDirgrStr = soDirgrStr;
	}

	public String getSoManzanaStr() {
		return soManzanaStr;
	}

	public void setSoManzanaStr(String soManzanaStr) {
		this.soManzanaStr = soManzanaStr;
	}

	public String getSoLoteStr() {
		return soLoteStr;
	}

	public void setSoLoteStr(String soLoteStr) {
		this.soLoteStr = soLoteStr;
	}

	public String getSoInteriorStr() {
		return soInteriorStr;
	}

	public void setSoInteriorStr(String soInteriorStr) {
		this.soInteriorStr = soInteriorStr;
	}

	public String getSeComStr() {
		return seComStr;
	}

	public void setSeComStr(String seComStr) {
		this.seComStr = seComStr;
	}

	public Date getSoVigDt() {
		return soVigDt;
	}

	public void setSoVigDt(Date soVigDt) {
		this.soVigDt = soVigDt;
	}

	public Long getSoNominaN() {
		return soNominaN;
	}

	public void setSoNominaN(Long soNominaN) {
		this.soNominaN = soNominaN;
	}

	public String getSapsCveStr() {
		return sapsCveStr;
	}

	public void setSapsCveStr(String sapsCveStr) {
		this.sapsCveStr = sapsCveStr;
	}

	public Long getSoLealtN() {
		return soLealtN;
	}

	public void setSoLealtN(Long soLealtN) {
		this.soLealtN = soLealtN;
	}

	public Long getNvoMuCveN() {
		return nvoMuCveN;
	}

	public void setNvoMuCveN(Long nvoMuCveN) {
		this.nvoMuCveN = nvoMuCveN;
	}

	public Date getSoFultCompDt() {
		return soFultCompDt;
	}

	public void setSoFultCompDt(Date soFultCompDt) {
		this.soFultCompDt = soFultCompDt;
	}

	public Date getSoVigMdgDt() {
		return soVigMdgDt;
	}

	public void setSoVigMdgDt(Date soVigMdgDt) {
		this.soVigMdgDt = soVigMdgDt;
	}

	public String getSoSoRfcStr() {
		return soSoRfcStr;
	}

	public void setSoSoRfcStr(String soSoRfcStr) {
		this.soSoRfcStr = soSoRfcStr;
	}

	public String getSoValidadoStr() {
		return soValidadoStr;
	}

	public void setSoValidadoStr(String soValidadoStr) {
		this.soValidadoStr = soValidadoStr;
	}
	
}
