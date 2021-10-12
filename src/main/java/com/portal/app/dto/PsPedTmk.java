package com.portal.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "UDONLINE.PS_PEDTMK@lrcorpprice")
@Data
public class PsPedTmk {
	
	@Id
	@Column(name = "PT_NUM_N")
	private Long numPedid;
	
	@Column(name = "SO_ID_STR")
	private String numSocio;

	@Column(name = "TI_CVE_N")
	private Long tiCveN;

	@Column(name = "PT_EST_STR")
	private String status;

	@Column(name = "PT_FEC_DT")
	private Date fecha;

}
