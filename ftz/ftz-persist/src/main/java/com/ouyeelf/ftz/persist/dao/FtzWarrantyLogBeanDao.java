package com.ouyeelf.ftz.persist.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.resource.FtzWarrantyLogBean;
import com.ouyeelf.ftz.model.resource.query.FtzWarrantyLogQueryBean;

public interface FtzWarrantyLogBeanDao {
	
	public Page<FtzWarrantyLogBean> findAll(FtzWarrantyLogQueryBean ftzWarrantyLogQueryBean,
			Pageable pageable);
	
	
	

}
