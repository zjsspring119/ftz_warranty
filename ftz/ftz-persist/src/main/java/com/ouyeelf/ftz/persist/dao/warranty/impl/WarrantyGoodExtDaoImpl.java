package com.ouyeelf.ftz.persist.dao.warranty.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.warranty.WarrantyGoodExt;
import com.ouyeelf.ftz.persist.dao.warranty.WarrantyGoodExtDao;
import com.ouyeelf.ftz.persist.repository.warranty.WarrantyGoodExtRepository;

@Service("warrantyGoodExtDao")
public class WarrantyGoodExtDaoImpl implements WarrantyGoodExtDao{
	
	@Autowired
	private WarrantyGoodExtRepository goodExtRepository;
	public void save(WarrantyGoodExt ext) {
		goodExtRepository.save(ext);
	}
	public List<WarrantyGoodExt> findByWagId(String wagId) {
		return goodExtRepository.findByWagId(wagId);
	}

}
