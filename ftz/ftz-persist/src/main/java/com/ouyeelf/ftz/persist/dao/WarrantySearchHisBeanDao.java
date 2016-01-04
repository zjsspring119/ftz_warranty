package com.ouyeelf.ftz.persist.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.resource.WarrantySearchHisBean;
import com.ouyeelf.ftz.model.resource.query.WarrantySearchHisQuery;

public interface WarrantySearchHisBeanDao {

	
	public Page<WarrantySearchHisBean> findAll(WarrantySearchHisQuery query,Pageable pageable);
}
