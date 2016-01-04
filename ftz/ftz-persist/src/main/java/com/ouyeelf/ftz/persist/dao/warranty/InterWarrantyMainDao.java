package com.ouyeelf.ftz.persist.dao.warranty;

import com.ouyeelf.ftz.model.domain.warranty.InterWarrantyMain;

public interface InterWarrantyMainDao {
	public void save(InterWarrantyMain main);
	public InterWarrantyMain findByOrgBillNo(String orgBillNo);
}
