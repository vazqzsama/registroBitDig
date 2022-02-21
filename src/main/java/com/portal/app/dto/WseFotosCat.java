package com.portal.app.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "WSE_FOTOS_CAT")
@Data
public class WseFotosCat implements Serializable {

	private static final long serialVersionUID = -6629743394583006205L;

	@Id
	@Column(name = "WUF_ID_N")
	private Long id;

	/*@Lob
	@Column(name="FOTO_BL")
	private byte[] foto;*/

	public WseFotosCat() {
		super();
	}
	
	public WseFotosCat(Long id/*, byte[] foto*/) {
		super();
		this.id = id;
		//this.foto = foto;
	}

	
	

}
