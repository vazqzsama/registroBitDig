package com.portal.app.request;

import com.portal.app.util.Filtro;
import com.portal.app.util.Pager;

public class BusquedaRequest extends Request {

	private static final long serialVersionUID = 1L;
	
	private Pager pager;
	private Filtro filtro;
	private Integer total;
	
	public BusquedaRequest() {
		super();
		this.total = 0;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public Filtro getFiltro() {
		return filtro;
	}
	public void setFiltro(Filtro filtro) {
		this.filtro = filtro;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
}
