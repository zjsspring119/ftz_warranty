package com.ouyeelf.ftz.persist.dao.message;

import java.util.List;

import com.ouyeelf.ftz.model.domain.message.OrcTMessageUserphone;

public interface OrcTMessageUserphoneDao {

	public void save(OrcTMessageUserphone orcTMessageUserphone);
	
	public List<OrcTMessageUserphone> findByUserCodeAndMarketFlag(String userCode,String marketFlag);
	
	public List<OrcTMessageUserphone> findByCustomerCodeAndMarketFlag(String customerCode,String marketFlag);
	
	public List<OrcTMessageUserphone> findByCustomerCodeAndMarketFlagAndPhoneNum(String customerCode,String marketFlag,String phoneNum);
	
	public void delete(OrcTMessageUserphone orcTMessageUserphone); 
	public long findcont(String fccode,String customerCode,String markertFlag,String phoneNum);
	
	public List<OrcTMessageUserphone> findByFccodeAndMarketFlag(String fccode,String marketFlag);
}
