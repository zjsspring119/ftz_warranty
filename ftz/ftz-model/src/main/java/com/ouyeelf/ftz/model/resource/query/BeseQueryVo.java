package com.ouyeelf.ftz.model.resource.query;

import java.io.Serializable;

public abstract class BeseQueryVo  implements Serializable {

	//分页
	private Integer offset;  //起始条数
	private Integer limit;  //显示行数
	private Integer count;  //总数
	private Integer page;//当前页数
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	
}
