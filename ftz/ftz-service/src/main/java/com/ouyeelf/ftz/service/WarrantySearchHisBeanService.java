package com.ouyeelf.ftz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.resource.WarrantySearchHisBean;
import com.ouyeelf.ftz.model.resource.query.WarrantySearchHisQuery;

public interface WarrantySearchHisBeanService {

	
	public Page<WarrantySearchHisBean> findAll(WarrantySearchHisQuery hisQuery,Pageable pageable);
	
	
}
