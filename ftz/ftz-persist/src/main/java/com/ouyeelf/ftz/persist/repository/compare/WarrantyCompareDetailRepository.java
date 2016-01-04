package com.ouyeelf.ftz.persist.repository.compare;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.compare.WarrantyCompareDetail;

public interface WarrantyCompareDetailRepository extends Repository<WarrantyCompareDetail, String>,JpaSpecificationExecutor<WarrantyCompareDetail>{
	
	@Query("select count(*) from WarrantyCompareDetail t where t.mainId=?1 and t.resultFlag=?2")
	public long findcount(String mainId,String resultFlag);
	
	@Query(" from WarrantyCompareDetail t where t.mainId=?1 and t.resultFlag=?2 order by t.warrantyNo")
	public Page<WarrantyCompareDetail> findByMainIdAndResultFlag(String id,String resultFlag,Pageable pageable);
	
	public List<WarrantyCompareDetail> findByMainId(String mainId);
	
	public List<WarrantyCompareDetail> findByMainIdAndResultFlag(String mainId,String resultFlag);
	
	public WarrantyCompareDetail save(WarrantyCompareDetail warrantyCompareDetail);
}
