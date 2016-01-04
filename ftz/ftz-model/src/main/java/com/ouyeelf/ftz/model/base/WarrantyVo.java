package com.ouyeelf.ftz.model.base;

import java.util.List;

import com.ouyeelf.ftz.common.web.Pagination;
import com.ouyeelf.ftz.model.resource.WarrantyBean;


public class WarrantyVo {

	private List<WarrantyBean> resourceList;
	private Pagination pagination;
	private long times;
	public WarrantyVo(){
		
	}
	
	public WarrantyVo(List<WarrantyBean> resourceList,Pagination pagination){
		this.resourceList = resourceList;
		this.pagination = pagination;
	}
	
	public long getTimes() {
		return times;
	}

	public void setTimes(long times) {
		this.times = times;
	}

	public List<WarrantyBean> getResourceList() {
		return resourceList;
	}
	public void setResourceList(List<WarrantyBean> resourceList) {
		this.resourceList = resourceList;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
}
