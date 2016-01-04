package com.ouyeelf.ftz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.resource.WarrantySearchHisBean;
import com.ouyeelf.ftz.model.resource.query.WarrantySearchHisQuery;
import com.ouyeelf.ftz.persist.dao.WarrantySearchHisBeanDao;
import com.ouyeelf.ftz.service.WarrantySearchHisBeanService;

public class WarrantySearchHisBeanServiceImpl implements
		WarrantySearchHisBeanService {

	@Autowired
	private WarrantySearchHisBeanDao warrantySearchHisBeanDao;
	
	public Page<WarrantySearchHisBean> findAll(WarrantySearchHisQuery hisQuery,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return warrantySearchHisBeanDao.findAll(hisQuery, pageable);
	}

}
