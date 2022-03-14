package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery (
		name="P_FOTOS_UPDATE",
		query="{ call PKG_REC_AFL_SIT.P_UPDATE_FOTOS_1 (?,:id,:tipo) }",
		callable = true,
		resultClass=Store.class
	),
	@NamedNativeQuery (
		name="P_RFC_UPDATE",
		query="{ call PKG_AFILIACION.P_UPDATE_SOCIO (?,:socio,:rfc,:isVal,:tienda) }",
		callable = true,
		resultClass=Store.class
	),
	@NamedNativeQuery (
		name="GET_DBLINK",
		query="select TI_CVE_N ID, LINKREMOTE VALUE from dba_databases@lrcorpprice WHERE TI_CVE_N = :tienda",
		resultClass=Store.class
	)
	
})
@Entity
public class Store 
{
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="VALUE")
	private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
