package com.ouyeelf.ftz.persist.dao.warranty.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.warranty.WarrantySearchHis;
import com.ouyeelf.ftz.persist.dao.warranty.WarrantySearchHisDao;
import com.ouyeelf.ftz.persist.repository.warranty.WarrantySearchHisRepository;

@Service("warrantySearchHisDao")
public class WarrantySearchHisDaoImpl implements WarrantySearchHisDao {

	@Autowired
	private WarrantySearchHisRepository warrantySearchHisRepository;
	
	public List<WarrantySearchHis> findBySearcher(String searcher) {
		// TODO Auto-generated method stub
		return warrantySearchHisRepository.findBySearcher(searcher);
	}

	public List<WarrantySearchHis> findByIsSynchronize(String isSynchronize) {
		// TODO Auto-generated method stub
		return warrantySearchHisRepository.findByIsSynchronize(isSynchronize);
	}

	public int updateIsSynchronize(String isSynchronize, List<String> idList) {
		// TODO Auto-generated method stub
		return warrantySearchHisRepository.updateIsSynchronize(isSynchronize, idList);
	}

}
