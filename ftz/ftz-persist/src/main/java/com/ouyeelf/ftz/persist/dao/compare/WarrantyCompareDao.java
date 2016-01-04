package com.ouyeelf.ftz.persist.dao.compare;

import com.ouyeelf.ftz.model.domain.compare.WarrantyCompare;

public interface WarrantyCompareDao {
	public WarrantyCompare findOne(String id);
	public WarrantyCompare save(WarrantyCompare warrantyCompare);
	public WarrantyCompare findByCompareNo(String compareNo);
}
