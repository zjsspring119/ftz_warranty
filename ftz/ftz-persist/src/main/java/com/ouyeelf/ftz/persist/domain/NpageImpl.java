package com.ouyeelf.ftz.persist.domain;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class NpageImpl<T> extends PageImpl<T> {
	
	private static final long serialVersionUID = 1L;
	
	private long times;
	
	public NpageImpl(List<T> content) {
		super(content);
	}
	
	public NpageImpl(List<T> content, Pageable pageable, long total) {
		super(content, pageable, total);
	}
	
	public NpageImpl(List<T> content, Pageable pageable, long total,long times) {
		super(content, pageable, total);
		this.times = times;
	}

	public long getTimes() {
		return times;
	}

	public void setTimes(long times) {
		this.times = times;
	}
	

}
