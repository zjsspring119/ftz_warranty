package com.ouyeelf.ftz.service.basicManage.codeset;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.domain.codeset.CodeItem;


public interface CodeItemService {
	
	public Page<CodeItem> findAll(Pageable pageable);

	public int deleteByItemId(String itemId);
	
	public int deleteByCodeset(String codesetCode);

	public void delete(Iterable<CodeItem> codesetCode);
	
	public CodeItem save(CodeItem codeItem);

	public CodeItem findOne(String codeItem);
	
	public CodeItem findByItemId(String itemId);
	
	public CodeItem selectByItemId(String itemId);

	// add by xxh
	public List<CodeItem> findByCodesetCode(String codesetCode);
	
	public List<CodeItem> findByCodesetCodeAndItemStatus(String codesetCode,String itemStatus);

	public List<CodeItem> findByCodesetCodeAndItemCode(String codesetCode, String itemCode);
	
	public Page<CodeItem> findByCodesetCode(Pageable pageable, String codesetCode);
	
	public List<CodeItem> findByParentCode(String itemStatus,String parentItemCode, String codesetCode);
	
	public List<CodeItem> findByLevel(String itemStatus,Integer codeLevel, String codesetCode);
	
	// for the condition
	public Page<CodeItem> equalCodeItemAndlikeItemChsCode(CodeItem codeItem, Pageable pageable);
	
	public CodeItem findByCodesetCodeAndItemChsCode(String codesetCode,String itemChsCode);
}
