package com.ouyeelf.ftz.persist.dao.compare;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.domain.compare.WarrantyCompareDetail;

public interface WarrantyCompareDetailDao {
	/*
	 * 计算异常总数量
	 */
	public long findcount(String mainId,String resultFlag);
	public Page<WarrantyCompareDetail> findByMainIdAndResultFlag(String id,String resultFlag,Pageable pageable);
	public List<WarrantyCompareDetail> findByMainId(String mainId);
	public WarrantyCompareDetail save(WarrantyCompareDetail warrantyCompareDetail);
	public List<WarrantyCompareDetail> findByMainIdAndResultFlag(String mainId,String resultFlag);
}
