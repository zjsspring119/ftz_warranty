package com.ouyeelf.ftz.persist.dao.codeset;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.domain.codeset.Codeset;


/**
 * 小代码维护
 * @author     xia.zhilong
 * @version    2012-7-15 上午11:42:53 
 * @revision
 */
public interface CodesetDao {
	public Page<Codeset> findAll(Pageable pageable);
	
	public int deleteByCodeset(String deleteByCodeset);
	
	public Codeset save(Codeset codesetCode);
	
	public Codeset findOne(String codesetCode);

	public void delete(Iterable<Codeset> codesetCode);

	public Codeset findByCodesetCode(String codesetCode);
	
	//for  query  condition
	public Page<Codeset> equalCodesetCodeAndlikeCodesetName(Codeset codeSet, Pageable pageable);
	
	public Codeset findByCodesetName(String codeSetName);

}
