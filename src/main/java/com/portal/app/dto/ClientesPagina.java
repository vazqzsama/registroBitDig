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
	@NamedNativeQuery
	(	name = "P_GET_AFIL_PEND",
		query = "{ call PKG_REC_AFL_SIT.P_GET_AFIL_RECUPERAR (?,:correos,:idsocios,:finicio,:fin) }",
		callable=true,
		resultClass=ClientesPagina.class
	)
})
public class ClientesPagina implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IDSOCIO")
	private Long idSocio;
	
	@Column(name = "CVETIENDA")
	private Long tiCve;
	
	@Column(name = "SO_TIPO_STR")
	private String soTipo;
	
	@Column(name = "SONOMBRE")
	private String soNom;
	
	@Column(name = "APELLIDOPATERNO")
	private String soApaterno;
	
	@Column(name = "APELLIDOMATERNO")
	private String soAmaterno;
	
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
	private String munDesc;
	
	@Column(name = "ESTADO")
	private Long estado;
	
	@Column(name = "ESTADO")
	private String edoDesc;
	
	@Column(name = "CIUDAD")
	private String ciudad;
	
	@Column(name = "CP")
	private Long cp;
	
	@Column(name = "REFERENCIA")
	private String referencia;
	
	@Column(name = "ENTRECALLES")
	private String entreCalles;
	
	@Column(name = "FALTA")
	private Date fechaAlta;
	
	@Column(name = "PEDIDO")
	private Long ptNum;
	
	@Column(name = "PT_EST_STR")
	private String statPedido;
	
	@Column(name = "IMPORTETOTAL")
	private Double importeTotal;
	
	@Column(name = "IMPORTEPEDIDO")
	private Double importePed;
	
	@Column(name = "IMPORTEENVIO")
	private Double importeEnvio;
	
	@Column(name = "DESCUENTO")
	private Double descuento;
	
	
}
