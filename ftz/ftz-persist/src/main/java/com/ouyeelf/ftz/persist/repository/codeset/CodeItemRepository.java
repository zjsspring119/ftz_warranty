package com.ouyeelf.ftz.persist.repository.codeset;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.codeset.CodeItem;




public interface CodeItemRepository extends Repository<CodeItem, String>, JpaSpecificationExecutor<CodeItem>{
	public Page<CodeItem> findAll(Pageable pageable);
	
	
	@Query("from CodeItem as u where u.codesetCode =?1 order by u.displayOrder asc, u.itemCode asc")
	public Page<CodeItem> findByCodesetCode(Pageable pageable, String codesetCode);
	

	@Modifying
	@Query("delete from CodeItem a where a.itemId =?1")
	public int deleteByItemId(String itemId);
	
	@Modifying
	@Query("delete from CodeItem a where a.codesetCode =?1")
	public int deleteByCodeset(String codesetCode);

	public CodeItem save(CodeItem codeItem);

	public CodeItem findOne(String itemId);
	
	public CodeItem findByItemId(String itemId);

	@Query("select a from CodeItem a where a.itemId = ?1") 
	public CodeItem selectByItemId(String itemId);
	
	// add by xxh
	// find by codesetCode
	public List<CodeItem> findByCodesetCode(String codesetCode);
	
	public List<CodeItem> findByCodesetCodeAndItemStatus(String codesetCode,String itemStatus);
	
	public CodeItem findByCodesetCodeAndItemChsCode(String codesetCode,String itemChsCode);


	// delete more than one records
	public void delete(Iterable<CodeItem> codeItem);
	
	// must make codeset_code and item_code unique
	public List<CodeItem> findByCodesetCodeAndItemCode(String codesetCode, String itemCode);
	
	@Query("select a from CodeItem a where a.itemStatus=?1 and a.parentItemCode=?2 and a.codesetCode = ?3") 
	public List<CodeItem> findByParentCode(String itemStatus,String parentItemCode, String codesetCode);
	
	@Query("select a from CodeItem a where a.itemStatus=?1 and a.codeLevel=?2 and a.codesetCode = ?3 order by NLSSORT(a.itemChsCode, 'NLS_SORT=SCHINESE_PINYIN_M')") 
	public List<CodeItem> findByLevel(String itemStatus,Integer codeLevel, String codesetCode);

}
