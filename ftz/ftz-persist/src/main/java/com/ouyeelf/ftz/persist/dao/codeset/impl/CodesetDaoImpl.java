package com.ouyeelf.ftz.persist.dao.codeset.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.codeset.Codeset;
import com.ouyeelf.ftz.persist.dao.codeset.CodesetDao;
import com.ouyeelf.ftz.persist.repository.codeset.CodesetRepository;
import com.ouyeelf.ftz.persist.repository.codeset.spec.CodeSetSpecs;



/**
 * 小代码维护
 * @author     xia.zhilong
 * @version    2012-7-15 上午11:42:26 
 * @revision
 */


@Service("codesetDao")
public class CodesetDaoImpl implements CodesetDao {

	@Autowired
	private CodesetRepository codesetRepository;
	
	public Page<Codeset> findAll(Pageable pageable) {
		Page<Codeset> text = codesetRepository.findAll(pageable);
		return codesetRepository.findAll(pageable);
	}

	public int deleteByCodeset(String deleteByCodeset) {
		return codesetRepository.deleteByCodeset(deleteByCodeset);
	}
	
	public Codeset save(Codeset codesetCode) {
		return codesetRepository.save(codesetCode);
	}
	
	public Codeset findOne(String codesetCode){
		return codesetRepository.findOne(codesetCode);
	}


	public void delete(Iterable<Codeset> codeSet) {
		codesetRepository.delete(codeSet);
	}
	

	public Codeset findByCodesetCode(String codesetCode){
		return codesetRepository.findByCodesetCode(codesetCode);
	}
	
	
	//for  query  condition
	public Page<Codeset> equalCodesetCodeAndlikeCodesetName(Codeset codeSet, Pageable pageable) {
		return codesetRepository.findAll(CodeSetSpecs.equalCodesetCodeAndlikeCodesetName(codeSet), pageable);
	}
	
	public Codeset findByCodesetName(String codeSetName){
		return codesetRepository.findByCodesetName(codeSetName);
	}

}
