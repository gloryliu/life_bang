package com.glory.shenghuo.util;

import java.io.Serializable;
import java.util.List;

public class PageInfos implements Serializable{

	private static final long serialVersionUID = -5216327794871359275L;

	/**
	 * 当前页
	 */
	private int pageNo = 1;

	/**
	 * 总条数
	 */
	private long totalCount;

	/**
	 * 总页数
	 */
	private int pageCount;

	/**
	 * 每页条数
	 */
	private int pageSize = 10;

	/**
	 * 数据
	 */
	private List<?> data;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
	
	/**
	 * 计算一共多少页
	 */
	public void setTotalPage() {
		if(this.totalCount==0){
			this.pageCount = 0;
		}else{
			this.pageCount = (int) ((this.totalCount % this.pageSize > 0) ? (this.totalCount / this.pageSize + 1)
				: this.totalCount / this.pageSize);
		}
	}
}
