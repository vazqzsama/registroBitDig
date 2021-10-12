package com.portal.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@NamedNativeQueries({
	@NamedNativeQuery
	(	name = "P_GET_AFIL_PEND",
		query = "{ call PKG_REC_AFL_SIT.P_GET_AFIL_RECUPERAR (?,:correos,:idsocios,:finicio,:fin) }",
		callable=true,
		resultClass=AfilRegistrar.class
	)
})
@ApiModel(value = "Datos de recuperados del socio para registro de bitacora digital",
description = "Datos de recuperados del socio para registro de bitacora digital")
public class AfilRegistrar {

	@Id
	@Column(name = "IDSOCIO", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Id de socio", value = "Id de socio",example = "092100291652", required = true, position = 1)
	private String idSocio;
	
	@Column(name = "SONOMBRE", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Nombre del socio", value = "Nombre del socio",example = "Jose", required = true, position = 2)
	private String soNombre;
	
	@Column(name = "APELLIDOPATERNO", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Apellido paterno", value = "Apellido paterno",example = "Martinez", required = true, position = 3)
	private String apellidoPaterno;
	
	@Column(name = "APELLIDOMATERNO", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Apellido materno", value = "Apellido materno",example = "Vargas", required = true, position = 4)
	private String apellidoMaterno;
	
	@Column(name = "EMAIL", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Dirección de correo", value = "Dirección de correo",example = "correo@correo.com", required = true, position = 5)
	private String email;
	
	@Column(name = "TELEFONO", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Número de telefono", value = "Número de telefono",example = "5566556655", required = true, position = 6)
	private String telefono;
	
	@Column(name = "PEDIDO", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Id de pedido", value = "Id de pedido",example = "46582", required = true, position = 7)
	private Long pedido;
	
	@Column(name = "IMPORTETOTAL", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Importe total", value = "Importe total",example = "148", required = true, position = 8)
	private Double importeTotal;
	
	@Column(name = "IMPORTEPEDIDO", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Importe pedido", value = "Importe pedido",example = "79", required = true, position = 9)
	private Double importePedido;
	
	@Column(name = "IMPORTEENVIO", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Importe envio", value = "Importe envio",example = "69", required = true, position = 10)
	private Double importeEnvio;
	
	@Column(name = "SEGUROENVIO", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Importe seguro", value = "Importe seguro",example = "0", required = true, position = 11)
	private Double seguroEnvio;
	
	@Column(name = "DESCUENTO", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Descuento", value = "Descuento",example = "0", required = true, position = 12)
	private Double descuento;
	
	@Column(name = "FORMADEPAGO", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Forma de pago", value = "Forma de pago",example = "1",allowableValues = "1(Efectivo),5(Tarjeta),19(Deposito)", required = true, position = 13)
	private Long formaPago;

	@Column(name = "ARTICULOS", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Lista de Id de articulos", value = "Lista de Id de articulos",example = "1007111,1019538,1016731", required = true, position = 14)
	private String articulos;

	@Column(name = "TIPOVENTA", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Tipo de venta", value = "Tipo de venta",example = "2", allowableValues = "1(paquete),2(catalogos)", required = true, position = 15)
	private Long tipoVenta;

	@Column(name = "CVETIENDA", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Id de tienda", value = "Id de tienda", example = "29", required = true, position = 16)
	private Long cveTienda;

	@Column(name = "METODOPAGO", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Metodo de pago", value = "Metodo de pago",example = "1", allowableValues = "1(MercadoPago),2(Deposito BBVA)", required = true, position = 17)
	private Long metodoPago;
	
	@Column(name = "CALLE", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Calle", value = "Calle",example = "Andador", required = true, position = 18)
	private String calle;
	
	@Column(name = "NOEXTERIOR", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Número Exterior", value = "Número Exterior",example = "12", required = true, position = 19)
	private String noExterior;
	
	@Column(name = "NOINTERIOR", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Número Interior", value = "Número Interior",example = "2", required = true, position = 20)
	private String noInterior;
	
	@Column(name = "COLONIA", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Colonia", value = "Colonia",example = "San Luis De La Paz Centro", required = true, position = 21)
	private String colonia;
	
	@Column(name = "CP", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Código Postal", value = "Código Postal",example = "37900", required = true, position = 22)
	private String cp;
	
	@Column(name = "METODOPAGO", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Id de municipio", value = "Id de municipio",example = "12", required = true, position = 23)
	private Long municipio;
	
	@Column(name = "MUNICIPIODESC", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Nombre del municipio", value = "Nombre del municipio",example = "San Luis De La Paz", required = true, position = 24)
	private String municipioDesc;
	
	@Column(name = "ESTADO", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Id de estado", value = "Id de estado",example = "33", required = true, position = 25)
	private Long estado;
	
	@Column(name = "ESTADODESC", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Nombre de estado", value = "Nombre de estado",example = "Guanajuato", required = true, position = 26)
	private String estadoDesc;
	
	@Column(name = "CIUDAD", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Ciudad", value = "Ciudad",example = "San Luis De La Paz", required = true, position = 27)
	private String ciudad;
	
	@Column(name = "REFERENCIA", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Referencia", value = "Referencia",example = "Puerta blanca con dos ventanas grandes blancas", required = true, position = 28)
	private String referencia;
	
	@Column(name = "ENTRECALLES", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Entre calles", value = "Entre calles",example = "Amaranto, trigo y avena", required = true, position = 29)
	private String entreCalles;
	
	@Column(name = "FALTA", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Fecha de alta", value = "Fecha de alta",example = "2021-10-07 09:25:27", required = true, position = 30)
	private Date falta;
	
	@Column(name = "PT_EST_STR", insertable=false, updatable=false)
	@ApiModelProperty(notes = "Estatus de socio", value = "Estatus de socio",example = "N", required = true, position = 31)
	private String statusSocio;
	
}
