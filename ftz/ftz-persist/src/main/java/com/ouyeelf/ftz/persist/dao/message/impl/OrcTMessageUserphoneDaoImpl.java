package com.ouyeelf.ftz.persist.dao.message.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.message.OrcTMessageUserphone;
import com.ouyeelf.ftz.persist.dao.message.OrcTMessageUserphoneDao;
import com.ouyeelf.ftz.persist.repository.message.UserPhoneRepository;

@Service(" orcTMessageUserphone")
public class OrcTMessageUserphoneDaoImpl implements OrcTMessageUserphoneDao{

	@Autowired
	private UserPhoneRepository userPhoneRepository;

	public void save(OrcTMessageUserphone orcTMessageUserphone) {
		userPhoneRepository.save(orcTMessageUserphone);
	}

	public List<OrcTMessageUserphone> findByUserCodeAndMarketFlag(String userCode,String marketFlag) {
		return userPhoneRepository.findByUserCodeAndMarketFlag(userCode,marketFlag);
	}

	public List<OrcTMessageUserphone> findByCustomerCodeAndMarketFlag(
			String customerCode, String marketFlag) {
		return userPhoneRepository.findByCustomerCodeAndMarketFlag(customerCode, marketFlag);
	}

	public List<OrcTMessageUserphone> findByCustomerCodeAndMarketFlagAndPhoneNum(
			String customerCode, String marketFlag, String phoneNum) {
		return userPhoneRepository.findByCustomerCodeAndMarketFlagAndPhoneNum(customerCode, marketFlag, phoneNum);
	}

	public void delete(OrcTMessageUserphone orcTMessageUserphone) {
		userPhoneRepository.delete(orcTMessageUserphone);
	}

	public long findcont(String fccode, String customerCode,
			String markertFlag, String phoneNum) {
		return userPhoneRepository.findcont(fccode, customerCode, markertFlag, phoneNum);
	}

	public List<OrcTMessageUserphone> findByFccodeAndMarketFlag(String fccode,
			String marketFlag) {
		// TODO Auto-generated method stub
		return userPhoneRepository.findByFccodeAndMarketFlag(fccode, marketFlag);
	}
}
