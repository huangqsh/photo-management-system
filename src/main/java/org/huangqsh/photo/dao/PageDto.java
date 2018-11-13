package org.huangqsh.photo.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

public class PageDto<T> {
	private Pageable pageable;
	private Integer pageTotal;
	private List<T> data;
	
	public Pageable getPageable() {
		return pageable;
	}
	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
}
