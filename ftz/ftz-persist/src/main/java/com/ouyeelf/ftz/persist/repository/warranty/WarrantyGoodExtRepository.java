package com.ouyeelf.ftz.persist.repository.warranty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.warranty.WarrantyGoodExt;

public interface WarrantyGoodExtRepository extends Repository<WarrantyGoodExt, String>,JpaSpecificationExecutor<WarrantyGoodExt>{
	
	public void save(WarrantyGoodExt ext);
	
	public List<WarrantyGoodExt> findByWagId(String wagId);
}
