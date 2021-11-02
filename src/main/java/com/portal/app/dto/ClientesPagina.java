package com.portal.app.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

import lombok.Data;

@Data
@Entity
@NamedNativeQueries({
	@NamedNativeQuery (
		name = "P_GET_CLIENTES_PEND",
		query = "{ call PKG_REC_AFL_SIT.P_GET_CLIENTES_VIEW(?,:correo,:nombre "
			 + ",:apaterno,:amaterno,:idsocio,:estatus,:sortby,:orderby,:limit,:offset) }",
		callable=true,
		resultClass=ClientesPagina.class
	)
})
public class ClientesPagina implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IDSOCIO")
	private String idSocio;
	
	@Column(name = "CVETIENDA")
	private Long cvetienda;
	
	@Column(name = "ESTATUSSOCIO")
	private String soTipoStr;
	
	@Column(name = "SONOMBRE")
	private String soNombre;
	
	@Column(name = "APELLIDOPATERNO")
	private String apellidoPaterno;
	
	@Column(name = "APELLIDOMATERNO")
	private String apellidoMaterno;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "TELEFONO")
	private String telefono;
	
	@Column(name = "CALLE")
	private String calle;
	
	@Column(name = "NOEXTERIOR")
	private String noExterior;
	
	@Column(name = "NOINTERIOR")
	private String noInterior;
	
	@Column(name = "COLONIA")
	private String colonia;
	
	@Column(name = "MUNICIPIO")
	private Long municipio;
	
	@Column(name = "MUNICIPIODESC")
	private String municipioDesc;
	
	@Column(name = "ESTADO")
	private Long estado;
	
	@Column(name = "ESTADODESC")
	private String estadoDesc;
	
	@Column(name = "CIUDAD")
	private String ciudad;
	
	@Column(name = "CP")
	private Long cp;
	
	@Column(name = "REFERENCIA")
	private String referencia;
	
	@Column(name = "ENTRECALLES")
	private String entreCalles;
	
	@Column(name = "FALTA")
	private Date falta;
	
	@Column(name = "FNAC")
	private Date fnac;
	
	@Column(name = "PEDIDO")
	private Long pedido;
	
	@Column(name = "REF")
	private String ref;
	
	@Column(name = "ESTATUSPEDIDO")
	private String estatusPedido;
	
	@Column(name = "IMPORTETOTAL")
	private Double importeTotal;
	
	@Column(name = "IMPORTEPEDIDO")
	private Double importePedido;
	
	@Column(name = "IMPORTEENVIO")
	private Double importeEnvio;
	
	@Column(name = "DESCUENTO")
	private Double descuento;
	
}
