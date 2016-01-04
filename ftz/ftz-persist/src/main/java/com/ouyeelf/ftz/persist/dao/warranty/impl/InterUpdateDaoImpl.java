package com.ouyeelf.ftz.persist.dao.warranty.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.warranty.InterWarrantysUpdate;
import com.ouyeelf.ftz.persist.dao.warranty.InterUpdateDao;
import com.ouyeelf.ftz.persist.repository.warranty.InterUpdateRespository;

@Service("interUpdateDao")
public class InterUpdateDaoImpl implements InterUpdateDao{

	@Autowired
	private InterUpdateRespository interUpdateRespository;

	public void save(InterWarrantysUpdate interWarrantysUpdate) {
		interUpdateRespository.save(interWarrantysUpdate);		
	}

	public InterWarrantysUpdate findByWarrantyNoAndOrgSysNoAndNewStatus(String warrantyNo,
			String orgSysNo,String newStatus) {
		return interUpdateRespository.findByWarrantyNoAndOrgSysNoAndNewStatus(warrantyNo, orgSysNo,newStatus);
	}
	
}
