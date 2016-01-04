package com.ouyeelf.ftz.persist.repository.warranty;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.warranty.WarrantySearchHis;

public interface WarrantySearchHisRepository extends Repository<WarrantySearchHis, String> {

	public List<WarrantySearchHis> findBySearcher(String searcher);
	
	public List<WarrantySearchHis> findByIsSynchronize(String isSynchronize); 
	
	@Modifying
	@Query("update WarrantySearchHis f set f.isSynchronize =?1  where f.id in(?2)")
	public int updateIsSynchronize(String isSynchronize,List<String> idList);
	
}
