package com.ouyeelf.ftz.persist.dao.warranty.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.warranty.CreditIcon;
import com.ouyeelf.ftz.persist.dao.warranty.CreditIconDao;
import com.ouyeelf.ftz.persist.repository.warranty.CreditIconRepository;



@Service("creditIconDao")
public class CreditIconDaoImpl implements CreditIconDao {

	@Autowired
	private CreditIconRepository creditIconRepository;

	public CreditIcon findByPlatTypeAndCompareType(String platType,
			String compareType) {
		// TODO Auto-generated method stub
		return creditIconRepository.findByPlatTypeAndCompareType(platType, compareType);
	}
	


}
