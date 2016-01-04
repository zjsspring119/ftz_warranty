package com.ouyeelf.ftz.persist.repository.warranty;

import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.warranty.CreditIcon;

public interface CreditIconRepository extends Repository<CreditIcon, String> {

	public CreditIcon findByPlatTypeAndCompareType(String platType,String compareType);
	
}
