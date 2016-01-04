package com.ouyeelf.ftz.persist.dao.codeset.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.codeset.CodeItem;
import com.ouyeelf.ftz.persist.dao.codeset.CodeItemDao;
import com.ouyeelf.ftz.persist.repository.codeset.CodeItemRepository;
import com.ouyeelf.ftz.persist.repository.codeset.spec.CodeItemSpecs;


@Service("codeItemDao")
public class CodeItemDaoImpl implements CodeItemDao {

	@Autowired
	private CodeItemRepository codeItemRepository;

	public Page<CodeItem> findAll(Pageable pageable) {
		return codeItemRepository.findAll(pageable);
	}
	
	public Page<CodeItem> findByCodesetCode(Pageable pageable, String codesetCode){
		return codeItemRepository.findByCodesetCode(pageable, codesetCode);
	}
	public int deleteByItemId(String itemId) {

		return codeItemRepository.deleteByItemId(itemId);
	}
	public int deleteByCodeset(String codesetCode){
		return codeItemRepository.deleteByCodeset(codesetCode);
	}
	
	public CodeItem save(CodeItem codeItem) {
		return codeItemRepository.save(codeItem);
	}

	public CodeItem findOne(String itemId) {
		return codeItemRepository.findOne(itemId);
	}


	public void delete(Iterable<CodeItem> codeItem){
		codeItemRepository.delete(codeItem);
	}
	
	public CodeItem findByItemId(String itemId){
		return codeItemRepository.findByItemId(itemId);
	}
	public CodeItem selectByItemId(String itemId){
		return codeItemRepository.selectByItemId(itemId);
	}
	
	// add by xxh
	public List<CodeItem> findByCodesetCode(String codesetCode) {
		return codeItemRepository.findByCodesetCode(codesetCode);
	}
	
	public List<CodeItem> findByCodesetCodeAndItemStatus(String codesetCode,String itemStatus){
		return codeItemRepository.findByCodesetCodeAndItemStatus(codesetCode,itemStatus);
	}

	public List<CodeItem> findByCodesetCodeAndItemCode(String codesetCode, String itemCode) {
		return codeItemRepository.findByCodesetCodeAndItemCode(codesetCode, itemCode);
	}
	
	public List<CodeItem> findByParentCode(String itemStatus,String parentItemCode, String codesetCode){
		return codeItemRepository.findByParentCode(itemStatus,parentItemCode,codesetCode);
	}
	
	public List<CodeItem> findByLevel(String itemStatus,Integer codeLevel, String codesetCode){
		return codeItemRepository.findByLevel(itemStatus,codeLevel,codesetCode);
	}
	
	public Page<CodeItem> equalCodeItemAndlikeItemChsCode(CodeItem codeItem, Pageable pageable){
		return codeItemRepository.findAll(CodeItemSpecs.equalCodeItemAndlikeItemChsCode(codeItem), pageable);
	};
	
	public CodeItem findByCodesetCodeAndItemChsCode(String codesetCode,String itemChsCode){
		return codeItemRepository.findByCodesetCodeAndItemChsCode(codesetCode, itemChsCode);
	}
}
