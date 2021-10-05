package com.portal.app.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "AFILIA_BITACORA_DIGITAL")
@Data
public class BitacoraDigital implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_AFILIA_BIT_DIGITAL", sequenceName = "SEQ_AFILIA_BIT_DIGITAL")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_AFILIA_BIT_DIGITAL")
	@Column(name = "ABD_CVE_N")
	private Long id;

	@Column(name = "ABD_ORIGEN")
	private String origen;

	@Column(name = "SO_ID_STR")
	private String numSocio;

	@Column(name = "SO_NOMBRE_STR")
	private String nombre;

	@Column(name = "SO_EMAIL_STR")
	private String email;

	@Column(name = "ABD_SO_TELEFONO_N")
	private String telefono;

	@Column(name = "ABD_SO_DIR_ENVIO_STR")
	private String dirEnvio;

	@Column(name = "PT_NUM_N")
	private Long numPedido;

	@Column(name = "ABD_PT_NUM_REFERENCIA_STR")
	private String referenciaPedido;

	@Column(name = "PT_IMPORTE_N")
	private Double importePedido;

	@Column(name = "ABD_IMPORTE_TOTAL_N")
	private Double importeTotal;

	@Column(name = "SO_SALD_N")
	private Double saldo;

	@Column(name = "PT_COSENV_N")
	private Double gastoEnvio;

	@Column(name = "PT_SEGMENS_N")
	private Double seguroEnvio;

	@Column(name = "PT_DESC_N")
	private Double descuento;

	@Column(name = "FP_CVE_N")
	private Integer formaPago;

	@Column(name = "ABD_ARTICULOS_STR")
	private String articulos;

	@Column(name = "TIPO_VTA_N")
	private Integer tipoVenta;

	@Column(name = "TI_CVE_N")
	private Integer cveTienda;

	@Column(name = "ABD_DEP_BAN_STR")
	private String referenciaBancaria;

	@Column(name = "ABD_ESTATUS_STR")
	private String estatus;

	@Column(name = "ABD_ESTATUS_PAGO_STR")
	private String estatusPago;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ABD_FMOD_EST_PAGO_DT")
	private Date fchModEstatusPago;

	@Column(name = "PQ_ID_N")
	private Integer idPaqueteria;

	@Column(name = "ABD_METODO_PAGO_N")
	private Integer metodoPago;

	@Column(name = "PTP_GUIA_STR")
	private String guiaEnvio;

	@Column(name = "ABD_FOLIO_ERROR_STR")
	private String folioError;

	@Column(name = "ABD_PETICION_AFILIACION", columnDefinition = "CLOB")
	@Lob
	private String peticionAfiliacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ABD_FALTA_DT")
	private Date fchAlta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ABD_FMOD_DT")
	private Date fchActualizacion;
	
}