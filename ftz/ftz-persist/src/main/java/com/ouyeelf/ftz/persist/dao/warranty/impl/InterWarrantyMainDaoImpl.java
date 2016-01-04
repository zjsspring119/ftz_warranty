package com.ouyeelf.ftz.persist.dao.warranty.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.warranty.InterWarrantyMain;
import com.ouyeelf.ftz.persist.dao.warranty.InterWarrantyMainDao;
import com.ouyeelf.ftz.persist.repository.warranty.InterWarrantyMainRespository;

@Service("interWarrantyMainDao")
public class InterWarrantyMainDaoImpl implements InterWarrantyMainDao{
	@Autowired
	private InterWarrantyMainRespository interWarrantyMainRespository;
	public void save(InterWarrantyMain main) {
		interWarrantyMainRespository.save(main);
	}

	public InterWarrantyMain findByOrgBillNo(String orgBillNo) {
		return interWarrantyMainRespository.findByOrgBillNo(orgBillNo);
	}

}
