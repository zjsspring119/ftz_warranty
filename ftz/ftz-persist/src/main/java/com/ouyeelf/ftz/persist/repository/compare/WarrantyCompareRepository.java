package com.ouyeelf.ftz.persist.repository.compare;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.compare.WarrantyCompare;

public interface WarrantyCompareRepository extends Repository<WarrantyCompare, String>,JpaSpecificationExecutor<WarrantyCompare>{

	public Page<WarrantyCompare> findAll(Pageable pageable);
	public WarrantyCompare findOne(String id);
	public WarrantyCompare save(WarrantyCompare warrantyCompare);
	public WarrantyCompare findByCompareNo(String compareNo);
}
