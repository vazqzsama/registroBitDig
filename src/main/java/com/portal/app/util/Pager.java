package com.portal.app.util;

import com.portal.app.dto.Data;

public class Pager {

	private boolean cache;
	private String  contentType;
	private Data data;
	
	public boolean isCache() {
		return cache;
	}
	public void setCache(boolean cache) {
		this.cache = cache;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
		
}
