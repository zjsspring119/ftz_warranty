package com.ouyeelf.ftz.persist.dao.warranty;

import com.ouyeelf.ftz.model.domain.warranty.InterWarrantysUpdate;

public interface InterUpdateDao {

	public void save(InterWarrantysUpdate interWarrantysUpdate);
	public InterWarrantysUpdate findByWarrantyNoAndOrgSysNoAndNewStatus(String warrantyNo,String orgSysNo,String newStatus);
}
