package com.ouyeelf.ftz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.resource.WarrantyBean;
import com.ouyeelf.ftz.model.resource.query.WarrantyQueryBean;
import com.ouyeelf.ftz.persist.dao.WarrantyBeanDao;
import com.ouyeelf.ftz.service.WarrantyBeanService;

public class WarrantyBeanServiceImpl implements WarrantyBeanService {

	
	@Autowired
	private  WarrantyBeanDao warrantyBeanDao;
	public Page<WarrantyBean> findAll(WarrantyQueryBean warrantyQueryBean,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return warrantyBeanDao.findAll(warrantyQueryBean, pageable);
	}

}
