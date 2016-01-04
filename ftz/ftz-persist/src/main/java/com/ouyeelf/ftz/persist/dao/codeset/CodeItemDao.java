package com.ouyeelf.ftz.persist.dao.codeset;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.domain.codeset.CodeItem;



public interface CodeItemDao {
	public Page<CodeItem> findAll(Pageable pageable);

	public int deleteByItemId(String itemId);
	
	public int deleteByCodeset(String codesetCode);

	public CodeItem save(CodeItem codeItem);

	public CodeItem findOne(String itemId);
	
	public CodeItem selectByItemId(String itemId);
	
	public CodeItem findByItemId(String itemId);

	// delete more than one records
	public void delete(Iterable<CodeItem> codeItem);

	public Page<CodeItem> findByCodesetCode(Pageable pageable, String codesetCode);

	// add by xxh
	public List<CodeItem> findByCodesetCode(String codesetCode);

	public List<CodeItem> findByCodesetCodeAndItemStatus(String codesetCode,String itemStatus);
	
	public List<CodeItem> findByCodesetCodeAndItemCode(String codesetCode, String itemCode);
	
	public List<CodeItem> findByParentCode(String itemStatus,String parentItemCode, String codesetCode);
	
	public List<CodeItem> findByLevel(String itemStatus,Integer codeLevel, String codesetCode);
	
	public Page<CodeItem> equalCodeItemAndlikeItemChsCode(CodeItem codeItem, Pageable pageable);
	
	public CodeItem findByCodesetCodeAndItemChsCode(String codesetCode,String itemChsCode);
}
