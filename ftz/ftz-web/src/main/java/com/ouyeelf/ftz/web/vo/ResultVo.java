package com.ouyeelf.ftz.web.vo;

import java.util.List;

import com.ouyeelf.ftz.common.web.Pagination;



public class ResultVo {

	private List<?> resourceList;
	private Pagination pagination;
	private long times;
	public ResultVo(){
		
	}
	
	public ResultVo(List<?> resourceList,Pagination pagination){
		this.resourceList = resourceList;
		this.pagination = pagination;
	}
	
	public long getTimes() {
		return times;
	}

	public void setTimes(long times) {
		this.times = times;
	}

	public List<?> getResourceList() {
		return resourceList;
	}
	public void setResourceList(List<?> resourceList) {
		this.resourceList = resourceList;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
}
