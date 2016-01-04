package com.ouyeelf.ftz.persist.dao.warranty.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.warranty.InterWarrantyGoods;
import com.ouyeelf.ftz.persist.dao.warranty.InterWarrantyGoodsDao;
import com.ouyeelf.ftz.persist.repository.warranty.InterWarrantyGoodsRespository;

@Service("interWarrantyGoodsDao")
public class InterWarrantyGoodsDaoImpl implements InterWarrantyGoodsDao{
	@Autowired
	private InterWarrantyGoodsRespository interWarrantyGoodsRespository;
	public void save(InterWarrantyGoods goods) {
		interWarrantyGoodsRespository.save(goods);	
	}

}
