package com.portal.app.dto;

//import java.awt.image.BufferedImage;
import java.util.Date;

public class Socio implements Cloneable
{
	
	private Integer tiCveN;
	private String  soIdStr;  //Debe asignarse por Base de Datos
	private String  soNomStr;
	private String  soApatStr;
	private String  soAmatStr;
	private Date    soFnacDt;
	private String  soFnacStr;
	private String  soSexoStr;
	private String  soEmailStr;
	private Integer paCveN;
	private Integer edCveN;
	private Integer muCveN;
	
	private Long    tsCveN;
	private Date    soFaltaDt; // Debe asignarse por Base de Datos
	private Date    soFregDt;  // Debe asignarse por Base de Datos 
	
	private String  soCve1Str;  // Checar si se solicita
	private String  soLada1Str; // Checar si se solicita
	private String  soTel1Str;
	private String  soLada2Str;
	private String  soTel2Str;
	private String  soCelStr;
	
	private String  soCalleStr;
	private String  soNumStr;
	private String  soInteriorStr; // Nuevo cambio
	private String  soColStr;
	private String  soCdStr;
	private String  soCpStr;
	
	private String  seTvivStr;
	private String  seAtmodStr; // Checar si se solicita
	private Long    seNomempN;  // Checar si se solicita
	private Long    ecCveN;
	private Long    ocCveN;
	private Integer graCveN;
	private Long    mdCveN;
	private Long    smdCveN;
	
	private byte[]  soFotoB;   // Campo para la Foto
	private String  soFotoStr; // Campo para la Foto en base64
	private Long    nvoMuCveMun;

	private byte[]  soCompDomB;   // Campo para el comprobante de domicilio 
	private String  soCompDomStr; // Campo para la Foto en base64
	private Integer medatenCveN; // Nuevo campo para el Medio de Atenion del Tipo de Socio
	private Long    duafCveN;  // Nuevo parametro
	private Integer seAutoN;  // Nuevo parametro - 13-11-2017
	
	private Boolean useImgDefault; //Indica si usar imagen default;
	//************ GETTERS AND SETTERS
	
	public Integer getTiCveN() {
		return tiCveN;
	}
	public void setTiCveN(Integer tiCveN) {
		this.tiCveN = tiCveN;
	}
	public String getSoIdStr() {
		return soIdStr;
	}
	public void setSoIdStr(String soIdStr) {
		this.soIdStr = soIdStr;
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
	public Long getTsCveN() {
		return tsCveN;
	}
	public void setTsCveN(Long tsCveN) {
		this.tsCveN = tsCveN;
	}
	public String getSoNomStr() {
		return soNomStr;
	}
	public void setSoNomStr(String soNomStr) {
		this.soNomStr = soNomStr;	
	}
	public String getSoApatStr() {
		return soApatStr;
	}
	public void setSoApatStr(String soApatStr) {
		this.soApatStr = soApatStr;
	}
	public String getSoAmatStr() {
		return soAmatStr;
	}
	public void setSoAmatStr(String soAmatStr) {
		this.soAmatStr = soAmatStr;
	}
	public Date getSoFnacDt() {
		return soFnacDt;
	}
	public void setSoFnacDt(Date soFnacDt) {
		this.soFnacDt = soFnacDt;
	}
	public Date getSoFaltaDt() {
		return soFaltaDt;
	}
	public void setSoFaltaDt(Date soFaltaDt) {
		this.soFaltaDt = soFaltaDt;
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
	public Long getEcCveN() {
		return ecCveN;
	}
	public void setEcCveN(Long ecCveN) {
		this.ecCveN = ecCveN;
	}
	public Long getOcCveN() {
		return ocCveN;
	}
	public void setOcCveN(Long ocCveN) {
		this.ocCveN = ocCveN;
	}
	public Long getMdCveN() {
		return mdCveN;
	}
	public void setMdCveN(Long mdCveN) {
		this.mdCveN = mdCveN;
	}
	public Integer getGraCveN() {
		return graCveN;
	}
	public void setGraCveN(Integer graCveN) {
		this.graCveN = graCveN;
	}
	public Long getSmdCveN() {
		return smdCveN;
	}
	public void setSmdCveN(Long smdCveN) {
		this.smdCveN = smdCveN;
	}
	public String getSeTvivStr() {
		return seTvivStr;
	}
	public void setSeTvivStr(String seTvivStr) {
		this.seTvivStr = seTvivStr;
	}
	public String getSeAtmodStr() {
		return seAtmodStr;
	}
	public void setSeAtmodStr(String seAtmodStr) {
		this.seAtmodStr = seAtmodStr;
	}
	public Long getSeNomempN() {
		return seNomempN;
	}
	public void setSeNomempN(Long seNomempN) {
		this.seNomempN = seNomempN;
	}
	public String getSoFnacStr() {
		return soFnacStr;
	}
	public void setSoFnacStr(String soFnacStr) {
		this.soFnacStr = soFnacStr;
	}
	public String getSoFotoStr() {
		return soFotoStr;
	}
	public void setSoFotoStr(String soFotoStr) {
		this.soFotoStr = soFotoStr;
	}
	public byte[] getSoFotoB() {
		return soFotoB;
	}
	public void setSoFotoB(byte[] soFotoB) {
		this.soFotoB = soFotoB;
	}
	
	public Long getNvoMuCveMun() {
		return nvoMuCveMun;
	}
	public void setNvoMuCveMun(Long nvoMuCveMun) {
		this.nvoMuCveMun = nvoMuCveMun;
	}
	
	public String getSoCelStr() {
		return soCelStr;
	}
	
	public void setSoCelStr(String soCelStr) {
		this.soCelStr = soCelStr;
	}
	
	public String getSoInteriorStr() {
		return soInteriorStr;
	}
	public void setSoInteriorStr(String soInteriorStr) {
		this.soInteriorStr = soInteriorStr;
	}
	
	public byte[] getSoCompDomB() {
		return soCompDomB;
	}
	public void setSoCompDomB(byte[] soCompDomB) {
		this.soCompDomB = soCompDomB;
	}
	public String getSoCompDomStr() {
		return soCompDomStr;
	}
	public void setSoCompDomStr(String soCompDomStr) {
		this.soCompDomStr = soCompDomStr;
	}
	public Integer getMedatenCveN() {
		return medatenCveN;
	}
	public void setMedatenCveN(Integer medatenCveN) {
		this.medatenCveN = medatenCveN;
	}
	public Long getDuafCveN() {
		return duafCveN;
	}
	public void setDuafCveN(Long duafCveN) {
		this.duafCveN = duafCveN;
	}
	public Integer getSeAutoN() {
		return seAutoN;
	}
	public void setSeAutoN(Integer seAutoN) {
		this.seAutoN = seAutoN;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException 
	{
		return super.clone();
	}
	public String getSoLada2Str() {
		return soLada2Str;
	}
	public void setSoLada2Str(String soLada2Str) {
		this.soLada2Str = soLada2Str;
	}
	public Boolean getUseImgDefault() {
		return useImgDefault;
	}
	public void setUseImgDefault(Boolean useImgDefault) {
		this.useImgDefault = useImgDefault;
	}
	
	
	
}
