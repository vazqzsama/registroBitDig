package com.portal.app.request;

import com.portal.app.dto.Direccion;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(value = "Datos de socio para registro de bitacora digital",
description = "Datos de socio para registro de bitacora digital")
public class BitRegRequest extends Request {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Id de socio", value = "Id de socio",example = "092100291652", required = true, position = 1)
	private String idSocio;
	
	@ApiModelProperty(notes = "Nombre del socio", value = "Nombre del socio",example = "Jose", required = true, position = 2)
	private String soNombre;
	
	@ApiModelProperty(notes = "Apellido paterno", value = "Apellido paterno",example = "Martinez", required = true, position = 3)
	private String apellidoPaterno;
	
	@ApiModelProperty(notes = "Apellido materno", value = "Apellido materno",example = "Vargas", required = true, position = 4)
	private String apellidoMaterno;
	
	@ApiModelProperty(notes = "Dirección de correo", value = "Dirección de correo",example = "correo@correo.com", required = true, position = 5)
	private String email;
	
	@ApiModelProperty(notes = "Número de telefono", value = "Número de telefono",example = "5566556655", required = true, position = 5)
	private String telefono;
	
	@ApiModelProperty(notes = "Id de pedido", value = "Id de pedido",example = "46582", required = true, position = 6)
	private Long pedido;
	
	@ApiModelProperty(notes = "Importe total", value = "Importe total",example = "148", required = true, position = 7)
	private Double importeTotal;
	
	@ApiModelProperty(notes = "Importe pedido", value = "Importe pedido",example = "79", required = true, position = 8)
	private Double importePedido;
	
	@ApiModelProperty(notes = "Importe envio", value = "Importe envio",example = "69", required = true, position = 9)
	private Double importeEnvio;
	
	@ApiModelProperty(notes = "Importe seguro", value = "Importe seguro",example = "0", required = true, position = 10)
	private Double seguroEnvio;
	
	@ApiModelProperty(notes = "Descuento", value = "Descuento",example = "0", required = true, position = 10)
	private Double descuento;
	
	@ApiModelProperty(notes = "Forma de pago", value = "Forma de pago",example = "1",allowableValues = "1(Efectivo),5(Tarjeta),19(Deposito)", required = true, position = 11)
	private Long formaPago;

	@ApiModelProperty(notes = "Lista de Id de articulos", value = "Lista de Id de articulos",example = "1007111,1019538,1016731", required = true, position = 12)
	private String articulos;

	@ApiModelProperty(notes = "Tipo de venta", value = "Tipo de venta",example = "2", allowableValues = "1(paquete),2(catalogos)", required = true, position = 13)
	private Long tipoVenta;

	@ApiModelProperty(notes = "Id de tienda", value = "Id de tienda", example = "29", required = true, position = 14)
	private Long cveTienda;

	@ApiModelProperty(notes = "Metodo de pago", value = "Metodo de pago",example = "1", allowableValues = "1(MercadoPago),2(Deposito BBVA)", required = true, position = 15)
	private Long metodoPago;
	
	@ApiModelProperty(notes = "Dirección de envío", value = "Dirección de envío",required = true, position = 16)
	private Direccion direccionEnvio;
	
	@ApiModelProperty(notes = "Estatus de socio", value = "Estatus de socio",example = "N", allowableValues = "N(Cliente),R(Socio)", required = true, position = 17)
	private String statusSocio;
	
}
