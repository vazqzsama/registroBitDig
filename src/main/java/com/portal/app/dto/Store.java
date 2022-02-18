package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery (
		name="F_UPDATE_FOTOS",
		query="{ call PKG_REC_AFL_SIT.F_UPDATE_FOTOS (:id,:tipo) }",
		callable = true,
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
