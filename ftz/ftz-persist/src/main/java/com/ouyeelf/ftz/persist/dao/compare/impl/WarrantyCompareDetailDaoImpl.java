package com.ouyeelf.ftz.persist.dao.compare.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.compare.WarrantyCompareDetail;
import com.ouyeelf.ftz.persist.dao.compare.WarrantyCompareDetailDao;
import com.ouyeelf.ftz.persist.repository.compare.WarrantyCompareDetailRepository;

@Service("warrantyCompareDetailDao")
public class WarrantyCompareDetailDaoImpl implements WarrantyCompareDetailDao{

	@Autowired
	private WarrantyCompareDetailRepository warrantyCompareDetailRepository;

	public long findcount(String mainId,String resultFlag) {
		return warrantyCompareDetailRepository.findcount(mainId,resultFlag);
	}

	public Page<WarrantyCompareDetail> findByMainIdAndResultFlag(String id,String resultFlag,Pageable pageable) {
		return warrantyCompareDetailRepository.findByMainIdAndResultFlag(id, resultFlag, pageable);
	}

	public List<WarrantyCompareDetail> findByMainId(String mainId) {
		return warrantyCompareDetailRepository.findByMainId(mainId);
	}

	public WarrantyCompareDetail save(
			WarrantyCompareDetail warrantyCompareDetail) {
		return warrantyCompareDetailRepository.save(warrantyCompareDetail);
	}

	public List<WarrantyCompareDetail> findByMainIdAndResultFlag(String mainId,
			String resultFlag) {
		return warrantyCompareDetailRepository.findByMainIdAndResultFlag(mainId, resultFlag);
	}
}
