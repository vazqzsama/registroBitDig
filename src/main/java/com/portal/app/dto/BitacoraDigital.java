package com.portal.app.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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

import com.portal.app.request.BitRegRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "AFILIA_BITACORA_DIGITAL")
@Data
@ApiModel(value = "Registro bitácora digital", description = "Registro bitácora digital")
public class BitacoraDigital implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_AFILIA_BIT_DIGITAL", sequenceName = "SEQ_AFILIA_BIT_DIGITAL")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_AFILIA_BIT_DIGITAL")
	@Column(name = "ABD_CVE_N")
	@ApiModelProperty(notes = "Id de Bitacora", value = "Id de bitácora",example = "2154", required = false, position = 1)
	private Long id;

	@Column(name = "ABD_ORIGEN")
	@ApiModelProperty(notes = "Origen de afiliación", value = "Origen de afiliación",example = "1", allowableValues = "1(Portal Web),2(Landing)", required = false, position = 2)
	private String origen;

	@Column(name = "SO_ID_STR")
	@ApiModelProperty(notes = "Id de socio", value = "Id de socio",example = "092100291652", required = false, position = 3)
	private String numSocio;

	@Column(name = "SO_NOMBRE_STR")
	@ApiModelProperty(notes = "Nombre del socio", value = "Nombre del socio",example = "Jose Lopez Vargas", required = false, position = 4)
	private String nombre;

	@Column(name = "SO_EMAIL_STR")
	@ApiModelProperty(notes = "Dirección de correo", value = "Dirección de correo",example = "correo@correo.com", required = false, position = 5)
	private String email;

	@Column(name = "ABD_SO_TELEFONO_N")
	@ApiModelProperty(notes = "Teléfono", value = "Teléfono",example = "5566556655", required = false, position = 6)
	private String telefono;

	@Column(name = "ABD_SO_DIR_ENVIO_STR")
	@ApiModelProperty(notes = "Dirección de envío", value = "Dirección de envío", required = false, position = 7,
	example = "Calle privada Morales # 28 noInt -, cp. 47450, Canada De Ricos, Jalisco, 53, Lagos De Moreno. Entre calles: rosas y marino. Refs: casa verde dos plantas ")
	private String dirEnvio;

	@Column(name = "PT_NUM_N")
	@ApiModelProperty(notes = "Id de pedido", value = "Id de pedido",example = "46582", required = false, position = 8)
	private Long numPedido;

	@Column(name = "ABD_PT_NUM_REFERENCIA_STR")
	@ApiModelProperty(notes = "Referencia de pedido", value = "Referencia de pedido",example = "AF904072110051736", required = false, position = 9)
	private String referenciaPedido;

	@Column(name = "PT_IMPORTE_N")
	@ApiModelProperty(notes = "Importe pedido", value = "Importe pedido",example = "79", required = false, position = 10)
	private Double importePedido;

	@Column(name = "ABD_IMPORTE_TOTAL_N")
	@ApiModelProperty(notes = "Importe total", value = "Importe total",example = "148", required = false, position = 11)
	private Double importeTotal;

	@Column(name = "SO_SALD_N")
	@ApiModelProperty(notes = "Saldo", value = "Saldo",example = "0", required = false, position = 12)
	private Double saldo;

	@Column(name = "PT_COSENV_N")
	@ApiModelProperty(notes = "Importe envio", value = "Importe envio",example = "69", required = false, position = 13)
	private Double gastoEnvio;

	@Column(name = "PT_SEGMENS_N")
	@ApiModelProperty(notes = "Importe seguro", value = "Importe seguro",example = "0", required = false, position = 14)
	private Double seguroEnvio;

	@Column(name = "PT_DESC_N")
	@ApiModelProperty(notes = "Descuento", value = "Descuento",example = "0", required = false, position = 15)
	private Double descuento;

	@Column(name = "FP_CVE_N")
	@ApiModelProperty(notes = "Forma de pago", value = "Forma de pago",example = "1->Efectivo | 5->Tarjeta | 19->Deposito", required = false, position = 16)
	private Long formaPago;

	@Column(name = "ABD_ARTICULOS_STR")
	@ApiModelProperty(notes = "Lista de Id de articulos", value = "Lista de Id de articulos",example = "1007111,1019538,1016731", required = false, position = 17)
	private String articulos;

	@Column(name = "TIPO_VTA_N")
	@ApiModelProperty(notes = "Tipo de venta", value = "Tipo de venta",example = "1->Paquete | 2->Catalogos", required = false, position = 18)
	private Long tipoVenta;

	@Column(name = "TI_CVE_N")
	@ApiModelProperty(notes = "Id de tienda", value = "Id de tienda", example = "29", required = false, position = 19)
	private Long cveTienda;

	@Column(name = "ABD_DEP_BAN_STR")
	@ApiModelProperty(notes = "Referencia Bancaria", value = "Referencia Bancaria", example = "10210029369641", required = false, position = 20)
	private String referenciaBancaria;

	@Column(name = "ABD_ESTATUS_STR")
	@ApiModelProperty(notes = "Estatus de afiliación", value = "Estatus de afiliación", example = "A", allowableValues = "A(Socio),R(Cliente)", required = false, position = 21)
	private String estatus;

	@Column(name = "ABD_ESTATUS_PAGO_STR")
	@ApiModelProperty(notes = "Estatus de pago", value = "Estatus de pago", example = "P", allowableValues = "A(Aplicado),P(Pendiente)", required = false, position = 22)
	private String estatusPago;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ABD_FMOD_EST_PAGO_DT")
	@ApiModelProperty(notes = "Fecha de aplicación por pago", value = "Fecha de aplicación por pago", example = "2021-10-05 17:28:35", required = false, position = 23)
	private Date fchModEstatusPago;

	@Column(name = "PQ_ID_N")
	@ApiModelProperty(notes = "Id de paqueteria", value = "Id de paqueteria", example = "1",required = false, position = 24)
	private Long idPaqueteria;

	@Column(name = "ABD_METODO_PAGO_N")
	@ApiModelProperty(notes = "Metodo de pago", value = "Metodo de pago",example = "1->Mercado Pago | 2->Depósito Bancario", required = false, position = 25)
	private Long metodoPago;

	@Column(name = "PTP_GUIA_STR")
	@ApiModelProperty(notes = "Guía de envío", value = "Guía de envío",example = "205501716229B705456962", required = false, position = 26)
	private String guiaEnvio;

	@Column(name = "ABD_FOLIO_ERROR_STR")
	@ApiModelProperty(notes = "Folio de error", value = "Folio de error",example = "ER903272109301854ER903272109301854", required = false, position = 27)
	private String folioError;

	@Column(name = "ABD_PETICION_AFILIACION", columnDefinition = "CLOB")
	@Lob
	@ApiModelProperty(notes = "Petición Afiliación", value = "Petición Afiliación", required = false, position = 28)
	private String peticionAfiliacion;

	@Temporal(TemporalType.TIMESTAMP)
	@ApiModelProperty(notes = "Fecha de alta", value = "Fecha de alta", example = "2021-10-05 17:28:35", required = false, position = 29)
	@Column(name = "ABD_FALTA_DT")
	private Date fchAlta;

	@Temporal(TemporalType.TIMESTAMP)
	@ApiModelProperty(notes = "Fecha de modificación", value = "Fecha de modificación", example = "2021-10-05 17:28:35", required = false, position = 30)
	@Column(name = "ABD_FMOD_DT")
	private Date fchActualizacion;

	public BitacoraDigital() {
		super();
	}
		
	public BitacoraDigital(BitRegRequest req) {
		super();
		Objects.requireNonNull(req.getIdSocio(),"El request no contiene número de socio");
		Objects.requireNonNull(req.getCveTienda(),String.format("El request del socio %s no contiene id de tienda",req.getIdSocio()));
		Objects.requireNonNull(req.getSoNombre(),String.format("El request del socio %s no contiene nombre",req.getIdSocio()));
		Objects.requireNonNull(req.getApellidoPaterno(),String.format("El request del socio %s no contiene apellido paterno",req.getIdSocio()));
		Objects.requireNonNull(req.getApellidoMaterno(),String.format("El request del socio %s no contiene apellido materno",req.getIdSocio()));
		Objects.requireNonNull(req.getEmail(),String.format("El request del socio %s no contiene correo electrónico",req.getIdSocio()));
		Objects.requireNonNull(req.getTelefono(),String.format("El request del socio %s no contiene teléfono",req.getIdSocio()));
		Objects.requireNonNull(req.getStatusSocio(),String.format("El request del socio %s no contiene estatus de socio",req.getIdSocio()));
		// Direccion
		Objects.requireNonNull(req.getDireccionEnvio().getCalle(),String.format("El request del socio %s no contiene información de calle",req.getIdSocio()));
		Objects.requireNonNull(req.getDireccionEnvio().getNoExterior(),String.format("El request del socio %s no contiene información de número exterior",req.getIdSocio()));
		//Objects.requireNonNull(req.getDireccionEnvio().getNoInterior(),String.format("El request del socio %s no contiene información de número interior",req.getIdSocio()));
		Objects.requireNonNull(req.getDireccionEnvio().getCp(),String.format("El request del socio %s no contiene información de código postal",req.getIdSocio()));
		Objects.requireNonNull(req.getDireccionEnvio().getColonia(),String.format("El request del socio %s no contiene información de colonia",req.getIdSocio()));
		Objects.requireNonNull(req.getDireccionEnvio().getMunicipio(),String.format("El request del socio %s no contiene la clave del municipio",req.getIdSocio()));
		Objects.requireNonNull(req.getDireccionEnvio().getMunicipioDesc(),String.format("El request del socio %s no contiene el nombre del municipio",req.getIdSocio()));
		Objects.requireNonNull(req.getDireccionEnvio().getEstado(),String.format("El request del socio %s no contiene la clave del estado",req.getIdSocio()));
		Objects.requireNonNull(req.getDireccionEnvio().getEstadoDesc(),String.format("El request del socio %s no contiene el nombre del estado",req.getIdSocio()));
		Objects.requireNonNull(req.getDireccionEnvio().getCiudad(),String.format("El request del socio %s no contiene el nombre de la ciudad",req.getIdSocio()));
		//Objects.requireNonNull(req.getDireccionEnvio().getEntreCalles(),String.format("El request del socio %s no contiene información de calle",req.getIdSocio()));
		//Objects.requireNonNull(req.getDireccionEnvio().getReferencia(),String.format("El request del socio %s no contiene información de calle",req.getIdSocio()));
		
		this.origen = "2";
		this.numSocio = req.getIdSocio();
		this.nombre = String.format("%s %s %s ", req.getSoNombre(),req.getApellidoPaterno(),req.getApellidoMaterno());
		this.email = req.getEmail();
		this.telefono = req.getTelefono();
		//this.numPedido = null;
		this.importePedido = 0D;
		this.importeTotal = 0D;
		this.saldo = 0D;
		this.gastoEnvio = 0D;
		this.seguroEnvio = 0D;
		this.descuento = 0D;
		this.formaPago = 1L;
		this.articulos = "-";
		this.tipoVenta = 1L;
		this.cveTienda = req.getCveTienda();
		this.estatus = req.getStatusSocio().equals("R") ? "A" : "R";
		this.estatusPago = req.getStatusSocio().equals("R") ? "A" : "P";
		this.metodoPago = 1L;
		this.fchModEstatusPago = new Date();
		this.idPaqueteria = 1L;
		this.fchAlta = new Date();
		this.fchActualizacion = new Date();
		this.dirEnvio = String.format("Calle %s %s noInt %s, cp. %s, %s, %s, %s, %s. Entre calles: %s. Refs: %s ",
				req.getDireccionEnvio().getCalle(), req.getDireccionEnvio().getNoExterior(), Objects.toString(req.getDireccionEnvio().getNoInterior(), "-"),
				req.getDireccionEnvio().getCp(), req.getDireccionEnvio().getColonia(), req.getDireccionEnvio().getEstadoDesc(), req.getDireccionEnvio().getMunicipio(),
				req.getDireccionEnvio().getCiudad(), req.getDireccionEnvio().getEntreCalles(), req.getDireccionEnvio().getReferencia());
	}

	public BitacoraDigital(AfilRegistrar req) {
		super();
		Objects.requireNonNull(req.getIdSocio(),"El request no contiene número de socio");
		Objects.requireNonNull(req.getPedido(),String.format("El request del socio %s no contiene id de pedido",req.getIdSocio()));
		Objects.requireNonNull(req.getCveTienda(),String.format("El request del socio %s no contiene id de tienda",req.getIdSocio()));
		Objects.requireNonNull(req.getSoNombre(),String.format("El request del socio %s no contiene nombre",req.getIdSocio()));
		Objects.requireNonNull(req.getApellidoPaterno(),String.format("El request del socio %s no contiene apellido paterno",req.getIdSocio()));
		Objects.requireNonNull(req.getApellidoMaterno(),String.format("El request del socio %s no contiene apellido materno",req.getIdSocio()));
		Objects.requireNonNull(req.getEmail(),String.format("El request del socio %s no contiene correo electrónico",req.getIdSocio()));
		Objects.requireNonNull(req.getTelefono(),String.format("El request del socio %s no contiene teléfono",req.getIdSocio()));
		Objects.requireNonNull(req.getStatusSocio(),String.format("El request del socio %s no contiene estatus de socio",req.getIdSocio()));
		Objects.requireNonNull(req.getCveTienda(),String.format("El request del socio %s no contiene id de tienda",req.getIdSocio()));
		Objects.requireNonNull(req.getArticulos(),String.format("El request del socio %s no contiene artículos",req.getIdSocio()));
		Objects.requireNonNull(req.getMetodoPago(),String.format("El request del socio %s no contiene método de pago",req.getIdSocio()));
		Objects.requireNonNull(req.getFormaPago(),String.format("El request del socio %s no contiene forma de pago",req.getIdSocio()));
		Objects.requireNonNull(req.getTipoVenta(),String.format("El request del socio %s no contiene tipo de venta",req.getIdSocio()));
		Objects.requireNonNull(req.getImporteTotal(),String.format("El request del socio %s no contiene importe total",req.getIdSocio()));
		Objects.requireNonNull(req.getImportePedido(),String.format("El request del socio %s no contiene importe del pedido",req.getIdSocio()));
		Objects.requireNonNull(req.getImporteEnvio(),String.format("El request del socio %s no contiene importe de envio",req.getIdSocio()));
		Objects.requireNonNull(req.getDescuento(),String.format("El request del socio %s no contiene descuento",req.getIdSocio()));
		// Direccion
		Objects.requireNonNull(req.getCalle(),String.format("El request del socio %s no contiene información de calle",req.getIdSocio()));
		Objects.requireNonNull(req.getNoExterior(),String.format("El request del socio %s no contiene información de número exterior",req.getIdSocio()));
		//Objects.requireNonNull(req.getNoInterior(),String.format("El request del socio %s no contiene información de número interior",req.getIdSocio()));
		Objects.requireNonNull(req.getCp(),String.format("El request del socio %s no contiene información de código postal",req.getIdSocio()));
		Objects.requireNonNull(req.getColonia(),String.format("El request del socio %s no contiene información de colonia",req.getIdSocio()));
		Objects.requireNonNull(req.getMunicipio(),String.format("El request del socio %s no contiene la clave del municipio",req.getIdSocio()));
		Objects.requireNonNull(req.getMunicipioDesc(),String.format("El request del socio %s no contiene el nombre del municipio",req.getIdSocio()));
		Objects.requireNonNull(req.getEstado(),String.format("El request del socio %s no contiene la clave del estado",req.getIdSocio()));
		Objects.requireNonNull(req.getEstadoDesc(),String.format("El request del socio %s no contiene el nombre del estado",req.getIdSocio()));
		Objects.requireNonNull(req.getCiudad(),String.format("El request del socio %s no contiene el nombre de la ciudad",req.getIdSocio()));
		//Objects.requireNonNull(req.getEntreCalles(),String.format("El request del socio %s no contiene información de calle",req.getIdSocio()));
		//Objects.requireNonNull(req.getReferencia(),String.format("El request del socio %s no contiene información de calle",req.getIdSocio()));
		
		this.origen = "2";
		this.numSocio = req.getIdSocio();
		this.nombre = String.format("%s %s %s ", req.getSoNombre(),req.getApellidoPaterno(),req.getApellidoMaterno());
		this.email = req.getEmail();
		this.telefono = req.getTelefono();
		this.numPedido = req.getPedido();
		this.importePedido = req.getImportePedido();
		this.importeTotal = req.getImporteTotal();
		this.saldo = req.getStatusSocio().equals("R") ? 0 : req.getImporteTotal()*-1;
		this.gastoEnvio = req.getImporteEnvio();
		this.seguroEnvio = req.getSeguroEnvio();
		this.descuento = req.getDescuento();
		this.formaPago = req.getFormaPago();
		this.articulos = req.getArticulos();
		this.tipoVenta = req.getTipoVenta();
		this.cveTienda = req.getCveTienda();
		this.estatus = req.getStatusSocio().equals("R") ? "A" : "R";
		this.estatusPago = req.getStatusSocio().equals("R") ? "A" : "P";
		this.metodoPago = req.getMetodoPago();
		this.idPaqueteria = 1L;
		this.fchModEstatusPago = req.getFalta();
		this.fchAlta = req.getFalta();
		this.fchActualizacion = req.getFalta();
		this.dirEnvio = String.format("Calle %s %s noInt %s, cp. %s, %s, %s, %s, %s. Entre calles: %s. Refs: %s ",
				req.getCalle(), req.getNoExterior(), Objects.toString(req.getNoInterior(), "-"),
				req.getCp(), req.getColonia(), req.getEstadoDesc(), req.getMunicipio(),
				req.getCiudad(), req.getEntreCalles(), req.getReferencia());
	}
	
}
