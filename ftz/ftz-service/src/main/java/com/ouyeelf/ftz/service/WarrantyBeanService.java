package com.ouyeelf.ftz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.resource.WarrantyBean;
import com.ouyeelf.ftz.model.resource.query.WarrantyQueryBean;

public interface WarrantyBeanService {

	
	public Page<WarrantyBean> findAll(WarrantyQueryBean warrantyQueryBean,
			Pageable pageable);
}
