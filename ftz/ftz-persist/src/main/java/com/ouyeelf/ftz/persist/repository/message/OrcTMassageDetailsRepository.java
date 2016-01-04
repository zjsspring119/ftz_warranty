package com.ouyeelf.ftz.persist.repository.message;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.message.OrcTMassageDetails;

public interface OrcTMassageDetailsRepository extends Repository<OrcTMassageDetails,String>, JpaSpecificationExecutor<OrcTMassageDetails> {
	
	public void save(OrcTMassageDetails details);
	
	@Query(" from OrcTMassageDetails t where t.flag=?1")
	public List<OrcTMassageDetails> findByFlag(String flag);
	
	@Query(" from OrcTMassageDetails t where t.id=?1")
	public OrcTMassageDetails findById(String id);
}
