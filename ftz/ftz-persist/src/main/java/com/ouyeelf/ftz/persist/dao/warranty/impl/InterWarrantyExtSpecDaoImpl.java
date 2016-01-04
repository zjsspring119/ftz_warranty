package com.ouyeelf.ftz.persist.dao.warranty.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.warranty.InterWarrantyGoodsExtSpec;
import com.ouyeelf.ftz.persist.dao.warranty.InterWarrantyExtSpecDao;
import com.ouyeelf.ftz.persist.repository.warranty.InterWarrantyExtSpecRespository;

@Service("interWarrantyExtSpecDao")
public class InterWarrantyExtSpecDaoImpl implements InterWarrantyExtSpecDao{
	@Autowired
	private InterWarrantyExtSpecRespository interWarrantyExtSpecRespository;
	public void save(InterWarrantyGoodsExtSpec goodsExtSpec) {
		interWarrantyExtSpecRespository.save(goodsExtSpec);
	}

}
