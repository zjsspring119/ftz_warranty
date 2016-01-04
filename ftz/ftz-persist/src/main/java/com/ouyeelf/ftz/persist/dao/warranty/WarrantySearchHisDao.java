package com.ouyeelf.ftz.persist.dao.warranty;

import java.util.List;

import com.ouyeelf.ftz.model.domain.warranty.WarrantySearchHis;

public interface WarrantySearchHisDao {

	public List<WarrantySearchHis> findBySearcher(String searcher);
	public List<WarrantySearchHis> findByIsSynchronize(String isSynchronize); 
	
	public int updateIsSynchronize(String isSynchronize,List<String> idList);
}
