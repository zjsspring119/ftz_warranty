package com.ouyeelf.ftz.persist.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.resource.WarrantyBean;
import com.ouyeelf.ftz.model.resource.query.WarrantyQueryBean;

public interface WarrantyBeanDao {
	
	public Page<WarrantyBean> findAll(WarrantyQueryBean warrantyQueryBean,
			Pageable pageable);
	
	
	

}
