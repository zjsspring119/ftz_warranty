package com.ouyeelf.ftz.persist.dao.warranty;

import java.util.List;

import com.ouyeelf.ftz.model.domain.warranty.WarrantyGoodExt;

public interface WarrantyGoodExtDao {
	
	public void save (WarrantyGoodExt ext);
	
	public List<WarrantyGoodExt> findByWagId(String wagId);
}
