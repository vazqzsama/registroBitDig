package com.portal.app.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="AFILIA_BITACORA_ECOMMERCE")
public class AfiliaBitacoraEcommerce implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="SEQ_AFILIA_BIT_E_GEN", sequenceName="SEQ_AFILIA_BITACORA_ECCOMMERCE")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_AFILIA_BIT_E_GEN")
	@Column(name="ABE_CVE_N")
	private Long abeCveN;
	
	@Column(name="ABE_ORIGEN_N")
	private Long abeOrigenN;
	
	@Column(name="ABD_CVE_N")
	private Long abdCveN;
	
	@Column(name="ID_USR_N")
	private Long idUsrN;
	
	@Column(name="ID_PERF_N")
	private Long idPerfN;

	@Column(name="ABE_NOMBRE_STR")
	private String abeNombreStr;
	
	@Column(name="ABE_EMAIL_STR")
	private String abeMailStr;
	
	@Column(name="ABE_TELEFONO_N")
	private String abeTelefonoN;
	
	@Column(name="ABE_TOTAL_A_PAGAR_N")
	private Long abeTotalaPagarN;
	
	@Column(name="ABE_ARTICULOS_STR")
	private String abeArticulosStr;
	
	@Column(name="ABE_TIPO_VTA_N")
	private Long abeTipoVtaN;
	
	@Column(name="ABE_REFERENCIA_STR")
	private String abeReferenciaStr;
	
	@Column(name="ABE_SO_ID_STR")
	private String abeSoIdStr;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ABE_FALTA_DT")
	private Date abeFaltaDt;
	
	@Column(name="ABE_FORM_PAGO_STR")
	private String abeFormPagoStr;
	
	@Column(name="TI_CVE_N")
	private Long tiCveN;
	
	@Column(name="ABE_DIR_ENVIO_STR")
	private String abeDirEnvioStr;	
	
	@Column(name="ABE_PEDIDO_N")
	private Long abePedidoN;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ABE_FMOD_DT")
	private Date abeFmodDt;
	
	@Column(name="ABE_ESTATUS_STR")
	private String abeEstatusStr;
	
	@Column(name="ABE_GUIA_N")
	private String abeGuiaN;
	
	@Column(name="BCS_CVE_N")
	private Long bcsCveN;
	
	@Column(name="ABE_CANDESC_STR")
	private String abeCandescStr;
	
	@Column(name="ABE_PAQUETERIA_STR")
	private String abePaqueteriaStr;
	
	@Column(name="ABE_GENVIO_N")
	private Long abeGenvioN;
	
	@Column(name="ABE_SEGURO_N")
	private Long abeSeguroN;
	
	@Column(name="ABE_ENTRECALLES_STR")
	private String abeEntrecallesStr;
	
	@Column(name="ABE_DEP_BAN_STR")
	private String abeDepBanStr;
	
	@Column(name="ABE_ESTATUS_REG_STR")
	private String abeEstatusRegStr;
	
	@Column(name="ABE_ESTATUS_PAGO_STR")
	private String abeEstatusPagoStr;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ABE_FMOD_PAGO_DT")
	private Date abeFmodPagoDt;	

	public Long getAbeCveN() {
		return abeCveN;
	}

	public void setAbeCveN(Long abeCveN) {
		this.abeCveN = abeCveN;
	}	

	public Long getAbeOrigenN() {
		return abeOrigenN;
	}

	public void setAbeOrigenN(Long abeOrigenN) {
		this.abeOrigenN = abeOrigenN;
	}

	public Long getAbdCveN() {
		return abdCveN;
	}

	public void setAbdCveN(Long abdCveN) {
		this.abdCveN = abdCveN;
	}

	public Long getIdUsrN() {
		return idUsrN;
	}

	public void setIdUsrN(Long idUsrN) {
		this.idUsrN = idUsrN;
	}

	public Long getIdPerfN() {
		return idPerfN;
	}

	public void setIdPerfN(Long idPerfN) {
		this.idPerfN = idPerfN;
	}

	public String getAbeNombreStr() {
		return abeNombreStr;
	}

	public void setAbeNombreStr(String abeNombreStr) {
		this.abeNombreStr = abeNombreStr;
	}

	public String getAbeMailStr() {
		return abeMailStr;
	}

	public void setAbeMailStr(String abeMailStr) {
		this.abeMailStr = abeMailStr;
	}

	public String getAbeTelefonoN() {
		return abeTelefonoN;
	}

	public void setAbeTelefonoN(String abeTelefonoN) {
		this.abeTelefonoN = abeTelefonoN;
	}

	public Long getAbeTotalaPagarN() {
		return abeTotalaPagarN;
	}

	public void setAbeTotalaPagarN(Long abeTotalaPagarN) {
		this.abeTotalaPagarN = abeTotalaPagarN;
	}

	public String getAbeArticulosStr() {
		return abeArticulosStr;
	}

	public void setAbeArticulosStr(String abeArticulosStr) {
		this.abeArticulosStr = abeArticulosStr;
	}

	public Long getAbeTipoVtaN() {
		return abeTipoVtaN;
	}

	public void setAbeTipoVtaN(Long abeTipoVtaN) {
		this.abeTipoVtaN = abeTipoVtaN;
	}

	public String getAbeReferenciaStr() {
		return abeReferenciaStr;
	}

	public void setAbeReferenciaStr(String abeReferenciaStr) {
		this.abeReferenciaStr = abeReferenciaStr;
	}

	public String getAbeSoIdStr() {
		return abeSoIdStr;
	}

	public void setAbeSoIdStr(String abeSoIdStr) {
		this.abeSoIdStr = abeSoIdStr;
	}

	public Date getAbeFaltaDt() {
		return abeFaltaDt;
	}

	public void setAbeFaltaDt(Date abeFaltaDt) {
		this.abeFaltaDt = abeFaltaDt;
	}

	public String getAbeFormPagoStr() {
		return abeFormPagoStr;
	}

	public void setAbeFormPagoStr(String abeFormPagoStr) {
		this.abeFormPagoStr = abeFormPagoStr;
	}

	public Long getTiCveN() {
		return tiCveN;
	}

	public void setTiCveN(Long tiCveN) {
		this.tiCveN = tiCveN;
	}

	public String getAbeDirEnvioStr() {
		return abeDirEnvioStr;
	}

	public void setAbeDirEnvioStr(String abeDirEnvioStr) {
		this.abeDirEnvioStr = abeDirEnvioStr;
	}

	public Long getAbePedidoN() {
		return abePedidoN;
	}

	public void setAbePedidoN(Long abePedidoN) {
		this.abePedidoN = abePedidoN;
	}

	public Date getAbeFmodDt() {
		return abeFmodDt;
	}

	public void setAbeFmodDt(Date abeFmodDt) {
		this.abeFmodDt = abeFmodDt;
	}

	public String getAbeEstatusStr() {
		return abeEstatusStr;
	}

	public void setAbeEstatusStr(String abeEstatusStr) {
		this.abeEstatusStr = abeEstatusStr;
	}

	public String getAbeGuiaN() {
		return abeGuiaN;
	}

	public void setAbeGuiaN(String abeGuiaN) {
		this.abeGuiaN = abeGuiaN;
	}

	public Long getBcsCveN() {
		return bcsCveN;
	}

	public void setBcsCveN(Long bcsCveN) {
		this.bcsCveN = bcsCveN;
	}

	public String getAbeCandescStr() {
		return abeCandescStr;
	}

	public void setAbeCandescStr(String abeCandescStr) {
		this.abeCandescStr = abeCandescStr;
	}

	public String getAbePaqueteriaStr() {
		return abePaqueteriaStr;
	}

	public void setAbePaqueteriaStr(String abePaqueteriaStr) {
		this.abePaqueteriaStr = abePaqueteriaStr;
	}

	public Long getAbeGenvioN() {
		return abeGenvioN;
	}

	public void setAbeGenvioN(Long abeGenvioN) {
		this.abeGenvioN = abeGenvioN;
	}

	public Long getAbeSeguroN() {
		return abeSeguroN;
	}

	public void setAbeSeguroN(Long abeSeguroN) {
		this.abeSeguroN = abeSeguroN;
	}

	public String getAbeEntrecallesStr() {
		return abeEntrecallesStr;
	}

	public void setAbeEntrecallesStr(String abeEntrecallesStr) {
		this.abeEntrecallesStr = abeEntrecallesStr;
	}

	public String getAbeDepBanStr() {
		return abeDepBanStr;
	}

	public void setAbeDepBanStr(String abeDepBanStr) {
		this.abeDepBanStr = abeDepBanStr;
	}

	public String getAbeEstatusRegStr() {
		return abeEstatusRegStr;
	}

	public void setAbeEstatusRegStr(String abeEstatusRegStr) {
		this.abeEstatusRegStr = abeEstatusRegStr;
	}

	public String getAbeEstatusPagoStr() {
		return abeEstatusPagoStr;
	}

	public void setAbeEstatusPagoStr(String abeEstatusPagoStr) {
		this.abeEstatusPagoStr = abeEstatusPagoStr;
	}

	public Date getAbeFmodPagoDt() {
		return abeFmodPagoDt;
	}

	public void setAbeFmodPagoDt(Date abeFmodPagoDt) {
		this.abeFmodPagoDt = abeFmodPagoDt;
	}
	
	
	
	
	
	
	
	
	
}
