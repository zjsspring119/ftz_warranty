package com.ouyeelf.ftz.persist.dao.message;

import java.util.List;

import com.ouyeelf.ftz.model.domain.message.OrcTMassageDetails;

public interface OrcTMassageDetailsDao {
	
	public void save(OrcTMassageDetails details);
	
	public List<OrcTMassageDetails> findByFlag(String flag);
	
	public OrcTMassageDetails findById(String id);
}
