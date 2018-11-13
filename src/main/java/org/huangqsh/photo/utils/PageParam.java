package org.huangqsh.photo.utils;

import java.util.List;

public class PageParam{
	// 当前页
	private Integer pageNum = 0;
	// 页面大小
	private Integer pageSize = 10;
	
	
	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
