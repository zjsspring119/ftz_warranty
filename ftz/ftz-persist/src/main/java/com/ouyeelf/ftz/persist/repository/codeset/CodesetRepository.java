package com.ouyeelf.ftz.persist.repository.codeset;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.codeset.Codeset;


/**
 * 小代码维护
 * @author     xia.zhilong
 * @version    2012-7-15 上午11:43:27 
 * @revision
 */

public interface CodesetRepository extends Repository<Codeset, String>, JpaSpecificationExecutor<Codeset> {
	
	public Page<Codeset> findAll(Pageable pageable);
	
	@Modifying
	@Query("delete from Codeset a where a.codesetCode =?1") 
	public int deleteByCodeset(String deleteByCodeset);
	
	// find one record for update
	public Codeset findOne(String codeSetCode);
	
	public Codeset findByCodesetCode(String codeSetCode);
	
	public Codeset save(Codeset codeItem);
	
	// delete more than one records
	public void delete(Iterable<Codeset> codeset);
	
	public Codeset findByCodesetName(String codeSetName);
}
