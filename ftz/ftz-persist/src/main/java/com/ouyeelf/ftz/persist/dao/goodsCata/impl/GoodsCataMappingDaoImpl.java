package com.ouyeelf.ftz.persist.dao.goodsCata.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.goodsCata.GoodsCataMapping;
import com.ouyeelf.ftz.persist.dao.goodsCata.GoodsCataMappingDao;
import com.ouyeelf.ftz.persist.repository.goodsCata.GoodsCataMappingRepository;

@Service("goodsCataMappingDao")
public class GoodsCataMappingDaoImpl implements GoodsCataMappingDao{

	@Autowired
	private GoodsCataMappingRepository goodsCataMappingRepository;
	
	public List<GoodsCataMapping> findByBasePCode(String basePCode) {
		return goodsCataMappingRepository.findByBasePCode(basePCode);
	}
	public void save(GoodsCataMapping cataMapping) {
		goodsCataMappingRepository.save(cataMapping);
	}

	public GoodsCataMapping findByFtzCatagoryCode(String ftzCatagoryCode) {
		return goodsCataMappingRepository.findByFtzCatagoryCode(ftzCatagoryCode);
	}

}
