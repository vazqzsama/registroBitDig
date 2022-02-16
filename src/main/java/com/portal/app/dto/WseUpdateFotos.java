package com.portal.app.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "WSE_UPDATE_FOTOS")
@Data
public class WseUpdateFotos implements Serializable {

	private static final long serialVersionUID = -6629743394583006205L;

	@Id
	@SequenceGenerator(name="WSE_UPD_FOTO_GENERATOR", sequenceName="SEQ_WSE_UPDFOTOS")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="WSE_UPD_FOTO_GENERATOR")
	@Column(name = "ID_N")
	private Long id;
	
	@Column(name = "SO_ID_STR")
	private String soIdStr;
	
	@Column(name = "TI_CVE_N")
	private Long tienda;
	
	@Column(name = "TIPO_N")
	private Long tipo;
	
	@Lob
	@Column(name="FOTO_BL")
	private byte[] foto;
	
	public WseUpdateFotos() { super(); }
	
	public WseUpdateFotos(String soIdStr, Long tienda, Long tipo, byte[] foto) {
		super();
		this.soIdStr = soIdStr;
		this.tienda = tienda;
		this.tipo = tipo;
		this.foto = foto;
	}

	
}
