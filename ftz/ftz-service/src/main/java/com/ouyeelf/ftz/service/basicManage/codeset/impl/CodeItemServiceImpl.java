package com.ouyeelf.ftz.service.basicManage.codeset.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ouyeelf.ftz.model.domain.codeset.CodeItem;
import com.ouyeelf.ftz.persist.dao.codeset.CodeItemDao;
import com.ouyeelf.ftz.service.basicManage.codeset.CodeItemService;


@Service("codeItemService")
public class CodeItemServiceImpl implements CodeItemService {

	private CodeItemDao codeItemDao;

	public Page<CodeItem> findAll(Pageable pageable) {
		return (Page<CodeItem>) codeItemDao.findAll(pageable);
	}

	@Transactional
	public int deleteByItemId(String itemId) {

		return codeItemDao.deleteByItemId(itemId);
	}

	@Transactional
	public CodeItem save(CodeItem codeItem) {
		return codeItemDao.save(codeItem);
	}

	public CodeItem findOne(String itemId) {
		return codeItemDao.findOne(itemId);
	}
	
	public CodeItem selectByItemId(String itemId){
		return codeItemDao.selectByItemId(itemId);
	}
	public int deleteByCodeset(String codesetCode){
		return codeItemDao.deleteByCodeset(codesetCode);
	}
	
	public CodeItem findByItemId(String itemId){
		return codeItemDao.findByItemId(itemId);
	}
	@Transactional
	public void delete(Iterable<CodeItem> codesetCode) {
		codeItemDao.delete(codesetCode);
	}

	
	// add by xxh
	public List<CodeItem> findByCodesetCode(String codesetCode) {
		List<CodeItem> codeItems = codeItemDao.findByCodesetCode(codesetCode);
		/*Map<String, String> maps = new LinkedHashMap<String, String>();
		for (CodeItem item : codeItems) {
			maps.put(item.getItemCode(), item.getItemChsCode());
		}*/
		return codeItems;
	}
	public List<CodeItem> findByCodesetCodeAndItemStatus(String codesetCode,String itemStatus){
		return codeItemDao.findByCodesetCodeAndItemStatus(codesetCode,itemStatus);
	}
	
	public Page<CodeItem> findByCodesetCode(Pageable pageable, String codesetCode){
		return codeItemDao.findByCodesetCode(pageable, codesetCode);
	}

	public List<CodeItem> findByCodesetCodeAndItemCode(String codesetCode, String itemCode) {
		return codeItemDao.findByCodesetCodeAndItemCode(codesetCode, itemCode);
	}
	
	public List<CodeItem> findByParentCode(String itemStatus,String parentItemCode, String codesetCode){
		return codeItemDao.findByParentCode(itemStatus,parentItemCode,codesetCode);
	}
	
	public List<CodeItem> findByLevel(String itemStatus,Integer codeLevel, String codesetCode){
		return codeItemDao.findByLevel(itemStatus,codeLevel,codesetCode);
	}
	
	public Page<CodeItem> equalCodeItemAndlikeItemChsCode(CodeItem codeItem, Pageable pageable){
		return codeItemDao.equalCodeItemAndlikeItemChsCode(codeItem, pageable);
	}
	
	public CodeItem findByCodesetCodeAndItemChsCode(String codesetCode,String itemChsCode){
		return codeItemDao.findByCodesetCodeAndItemChsCode(codesetCode, itemChsCode);
	}
}
