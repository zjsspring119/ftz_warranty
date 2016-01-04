package com.ouyeelf.ftz.persist.dao.warranty;

import com.ouyeelf.ftz.model.domain.warranty.CreditIcon;

public interface CreditIconDao {
	
	public CreditIcon findByPlatTypeAndCompareType(String platType,String compareType);
}
