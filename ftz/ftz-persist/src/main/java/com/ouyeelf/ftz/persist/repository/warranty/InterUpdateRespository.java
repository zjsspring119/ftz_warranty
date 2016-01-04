package com.ouyeelf.ftz.persist.repository.warranty;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.warranty.InterWarrantysUpdate;

public interface InterUpdateRespository extends Repository<InterWarrantysUpdate, String>,JpaSpecificationExecutor<InterWarrantysUpdate>{
	
	public void save(InterWarrantysUpdate interWarrantysUpdate);
	
	public InterWarrantysUpdate findByWarrantyNoAndOrgSysNoAndNewStatus(String warrantyNo,String orgSysNo,String newStatus);
}
