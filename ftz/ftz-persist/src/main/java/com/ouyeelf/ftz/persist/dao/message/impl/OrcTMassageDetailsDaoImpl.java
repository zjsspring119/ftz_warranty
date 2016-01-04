package com.ouyeelf.ftz.persist.dao.message.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.message.OrcTMassageDetails;
import com.ouyeelf.ftz.persist.dao.message.OrcTMassageDetailsDao;
import com.ouyeelf.ftz.persist.repository.message.OrcTMassageDetailsRepository;

@Service("orcTMassageDetailsDao")
public class OrcTMassageDetailsDaoImpl implements OrcTMassageDetailsDao {
	
	@Autowired
	private OrcTMassageDetailsRepository tMassageDetailsRepository;

	public void save(OrcTMassageDetails details) {
		tMassageDetailsRepository.save(details);
	}

	public List<OrcTMassageDetails> findByFlag(String flag) {
		return tMassageDetailsRepository.findByFlag(flag);
	}

	public OrcTMassageDetails findById(String id) {
		return tMassageDetailsRepository.findById(id);
	}
}
