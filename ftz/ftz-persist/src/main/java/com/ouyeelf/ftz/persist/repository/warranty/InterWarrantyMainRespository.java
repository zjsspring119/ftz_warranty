package com.ouyeelf.ftz.persist.repository.warranty;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.warranty.InterWarrantyMain;

public interface InterWarrantyMainRespository extends Repository<InterWarrantyMain, String>,JpaSpecificationExecutor<InterWarrantyMain>{

	public void save(InterWarrantyMain main);
	public InterWarrantyMain findByOrgBillNo(String orgBillNo);
}
