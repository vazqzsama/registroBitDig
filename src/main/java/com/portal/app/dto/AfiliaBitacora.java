package com.portal.app.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "AFILIA_BITACORA")
public class AfiliaBitacora {
	@Id
	@Column(name = "BIT_ID_N")
	@SequenceGenerator(name = "SEQ_AFILIA_BITACORA_GENERATOR", sequenceName = "SEQ_AFILIA_BITACORA")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_AFILIA_BITACORA_GENERATOR")
	private Long id;

	@Column(name = "ID_RENGLON_N")
	private Long idRenglon;

	@Column(name = "PLATAFORMA_N")
	private Integer plataforma;

	@Column(name = "ID_USR_N")
	private Long idUsrN;

	@Column(name = "ID_PERF_N")
	private Long idPerfN;

	@Column(name = "NO_NOMINA")
	private String usrCveStr;

	@Column(name = "FECHA_DT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;

	@Column(name = "TI_CVE_N")
	private Long tiCveN;

	@Column(name = "SO_ID_STR")
	private String soIdStr;

	@Column(name = "SO_CEL_STR")
	private String soCelStr;

	@Column(name = "CODIGO_STR")
	private String codigoVerificacion;

	@Column(name = "TIPO_VTA_N")
	private Integer tipoVenta; // 1 paquete, 2 catálogos

	@Column(name = "TOTAL_ART_N")
	private Integer totalArticulos;

	@Column(name = "TOTAL_A_PAGAR_N")
	private BigDecimal pagado;

	@Column(name = "ESTATUS_STR")
	private String estatus;

	@Column(name = "ARTICULOS_STR")
	private String articulos;

	@Column(name = "OBSERVACIONES_STR")
	private String observaciones;

	@Column(name = "SMS_ENV_N")
	private Integer smsEnvN;

	@Column(name = "SO_NOMBRE_STR")
	private String soNombreStr;

	@Column(name = "NO_NOMINA_CAPTURA")
	private String nominaCaptura;

	@Column(name = "FOLIO_PAPELETA")
	private String folioPepeleta;

	@Column(name = "GPS_UBIC_STR")
	private String gpsUbicStr;

	@Column(name = "TIPO_CAPTURA", nullable = true)
	private String tipoCaptura;

	@Column(name = "OCR_RESPONSE", nullable = true)
	private String ocrResponse;

	@Column(name = "FIRMA_SOCIO", nullable = true)
	private String firmaSocio;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Integer plataforma) {
		this.plataforma = plataforma;
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

	public String getUsrCveStr() {
		return usrCveStr;
	}

	public void setUsrCveStr(String usrCveStr) {
		this.usrCveStr = usrCveStr;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Long getTiCveN() {
		return tiCveN;
	}

	public void setTiCveN(Long tiCveN) {
		this.tiCveN = tiCveN;
	}

	public String getSoIdStr() {
		return soIdStr;
	}

	public void setSoIdStr(String soIdStr) {
		this.soIdStr = soIdStr;
	}

	public String getSoCelStr() {
		return soCelStr;
	}

	public void setSoCelStr(String soCelStr) {
		this.soCelStr = soCelStr;
	}

	public String getCodigoVerificacion() {
		return codigoVerificacion;
	}

	public void setCodigoVerificacion(String codigoVerificacion) {
		this.codigoVerificacion = codigoVerificacion;
	}

	public Integer getTipoVenta() {
		return tipoVenta;
	}

	public void setTipoVenta(Integer tipoVenta) {
		this.tipoVenta = tipoVenta;
	}

	public Integer getTotalArticulos() {
		return totalArticulos;
	}

	public void setTotalArticulos(Integer totalArticulos) {
		this.totalArticulos = totalArticulos;
	}

	public BigDecimal getPagado() {
		return pagado;
	}

	public void setPagado(BigDecimal pagado) {
		this.pagado = pagado;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getArticulos() {
		return articulos;
	}

	public void setArticulos(String articulos) {
		this.articulos = articulos;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Long getIdRenglon() {
		return idRenglon;
	}

	public void setIdRenglon(Long idRenglon) {
		this.idRenglon = idRenglon;
	}

	public Integer getSmsEnvN() {
		return smsEnvN;
	}

	public void setSmsEnvN(Integer smsEnvN) {
		this.smsEnvN = smsEnvN;
	}

	public String getSoNombreStr() {
		return soNombreStr;
	}

	public void setSoNombreStr(String soNombreStr) {
		this.soNombreStr = soNombreStr;
	}

	public String getFolioPepeleta() {
		return folioPepeleta;
	}

	public void setFolioPepeleta(String folioPepeleta) {
		this.folioPepeleta = folioPepeleta;
	}

	public String getGpsUbicStr() {
		return gpsUbicStr;
	}

	public void setGpsUbicStr(String gpsUbicStr) {
		this.gpsUbicStr = gpsUbicStr;
	}

	public String getNominaCaptura() {
		return nominaCaptura;
	}

	public void setNominaCaptura(String nominaCaptura) {
		this.nominaCaptura = nominaCaptura;
	}

	public String getTipoCaptura() {
		return tipoCaptura;
	}

	public void setTipoCaptura(String tipoCaptura) {
		this.tipoCaptura = tipoCaptura;
	}

	public String getOcrResponse() {
		return ocrResponse;
	}

	public void setOcrResponse(String ocrResponse) {
		this.ocrResponse = ocrResponse;
	}

	public String getFirmaSocio() {
		return firmaSocio;
	}

	public void setFirmaSocio(String firmaSocio) {
		this.firmaSocio = firmaSocio;
	}

	@Override
	public String toString() {
		return "AfiliaBitacora [id=" + id + ", idRenglon=" + idRenglon + ", plataforma=" + plataforma + ", idUsrN="
				+ idUsrN + ", idPerfN=" + idPerfN + ", usrCveStr=" + usrCveStr + ", fechaRegistro=" + fechaRegistro
				+ ", tiCveN=" + tiCveN + ", soIdStr=" + soIdStr + ", soCelStr=" + soCelStr + ", codigoVerificacion="
				+ codigoVerificacion + ", tipoVenta=" + tipoVenta + ", totalArticulos=" + totalArticulos + ", pagado="
				+ pagado + ", estatus=" + estatus + ", articulos=" + articulos + ", observaciones=" + observaciones
				+ ", smsEnvN=" + smsEnvN + ", soNombreStr=" + soNombreStr + ", nominaCaptura=" + nominaCaptura
				+ ", folioPepeleta=" + folioPepeleta + ", gpsUbicStr=" + gpsUbicStr + ", tipoCaptura=" + tipoCaptura
				+ ", ocrResponse=" + ocrResponse + ", firmaSocio=" + firmaSocio + "]";
	}
	
}
