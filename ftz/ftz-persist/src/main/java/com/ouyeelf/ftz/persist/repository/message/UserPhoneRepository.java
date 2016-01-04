package com.ouyeelf.ftz.persist.repository.message;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.message.OrcTMessageUserphone;

public interface UserPhoneRepository extends Repository<OrcTMessageUserphone,String>, JpaSpecificationExecutor<OrcTMessageUserphone>{

	public void save(OrcTMessageUserphone orcTMessageUserphone);
	
	public List<OrcTMessageUserphone> findByUserCodeAndMarketFlag(String userCode,String marketFlag);
	
	public List<OrcTMessageUserphone> findByCustomerCodeAndMarketFlag(String customerCode,String marketFlag);
	
	@Query(" from OrcTMessageUserphone u where u.fccode=?1 and u.marketFlag=?2 and exists (select 1 from UserRefRole r where  r.roleId ='16' and r.userId=u.userCode )")
	public List<OrcTMessageUserphone> findByFccodeAndMarketFlag(String fccode,String marketFlag);
	
	public List<OrcTMessageUserphone> findByCustomerCodeAndMarketFlagAndPhoneNum(String customerCode,String marketFlag,String phoneNum);

	@Modifying
	public void delete(OrcTMessageUserphone orcTMessageUserphone); 
	
	@Query(" select count(t) from OrcTMessageUserphone t where t.fccode=?1 and t.customerCode=?2 and t.marketFlag=?3 and t.phoneNum=?4")
	public long findcont(String fccode,String customerCode,String markertFlag,String phoneNum);
	
}
