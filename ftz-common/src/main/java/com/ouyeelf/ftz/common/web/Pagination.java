package com.ouyeelf.ftz.common.web;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.domain.PageRequest;
/**
 * 翻页类
 * @author xudm
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Pagination {

	private Integer offset;
	private Integer page;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	private Integer allPage;
	
	private Integer limit;
	private Long count;

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
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Integer getAllPage() {
		return allPage;
	}
	public void setAllPage(Integer allPage) {
		this.allPage = allPage;
	}
	
}
