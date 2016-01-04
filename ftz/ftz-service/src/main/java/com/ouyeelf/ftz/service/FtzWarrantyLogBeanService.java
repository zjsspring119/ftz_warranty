package com.ouyeelf.ftz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.resource.FtzWarrantyLogBean;
import com.ouyeelf.ftz.model.resource.query.FtzWarrantyLogQueryBean;

public interface FtzWarrantyLogBeanService {

	public Page<FtzWarrantyLogBean> findAll(FtzWarrantyLogQueryBean ftzWarrantyLogQueryBean,
			Pageable pageable);
}
