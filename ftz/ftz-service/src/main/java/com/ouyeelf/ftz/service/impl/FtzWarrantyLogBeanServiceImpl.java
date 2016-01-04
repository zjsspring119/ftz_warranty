package com.ouyeelf.ftz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.resource.FtzWarrantyLogBean;
import com.ouyeelf.ftz.model.resource.query.FtzWarrantyLogQueryBean;
import com.ouyeelf.ftz.persist.dao.FtzWarrantyLogBeanDao;
import com.ouyeelf.ftz.service.FtzWarrantyLogBeanService;

public class FtzWarrantyLogBeanServiceImpl implements FtzWarrantyLogBeanService {

	@Autowired
	private FtzWarrantyLogBeanDao ftzWarrantyLogBeanDao;
	
	public Page<FtzWarrantyLogBean> findAll(
			FtzWarrantyLogQueryBean ftzWarrantyLogQueryBean, Pageable pageable) {
		// TODO Auto-generated method stub
		return ftzWarrantyLogBeanDao.findAll(ftzWarrantyLogQueryBean, pageable);
	}

}
