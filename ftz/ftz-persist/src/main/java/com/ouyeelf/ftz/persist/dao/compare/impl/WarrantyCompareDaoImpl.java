package com.ouyeelf.ftz.persist.dao.compare.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.compare.WarrantyCompare;
import com.ouyeelf.ftz.persist.dao.compare.WarrantyCompareDao;
import com.ouyeelf.ftz.persist.repository.compare.WarrantyCompareRepository;

@Service("warrantyCompareDao")
public class WarrantyCompareDaoImpl implements WarrantyCompareDao{

	@Autowired
	private WarrantyCompareRepository warrantyCompareRepository;


	public WarrantyCompare findOne(String id) {
		return warrantyCompareRepository.findOne(id);
	}

	public WarrantyCompare save(WarrantyCompare warrantyCompare) {
		// TODO Auto-generated method stub
		return warrantyCompareRepository.save(warrantyCompare);
	}

	public WarrantyCompare findByCompareNo(String compareNo) {
		// TODO Auto-generated method stub
		return warrantyCompareRepository.findByCompareNo(compareNo);
	}
	
}
