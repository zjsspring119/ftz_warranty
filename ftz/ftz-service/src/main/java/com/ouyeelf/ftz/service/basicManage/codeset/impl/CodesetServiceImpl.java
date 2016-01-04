package com.ouyeelf.ftz.service.basicManage.codeset.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ouyeelf.ftz.common.constant.LSConstants;
import com.ouyeelf.ftz.model.domain.codeset.CodeItem;
import com.ouyeelf.ftz.model.domain.codeset.Codeset;
import com.ouyeelf.ftz.model.vo.codeset.CodeItemVo;
import com.ouyeelf.ftz.model.vo.codeset.CodesetVo;
import com.ouyeelf.ftz.persist.dao.codeset.CodeItemDao;
import com.ouyeelf.ftz.persist.dao.codeset.CodesetDao;
import com.ouyeelf.ftz.service.basicManage.codeset.CodeItemService;
import com.ouyeelf.ftz.service.basicManage.codeset.CodesetService;
import com.waxberry.WaxberryContext;
import com.waxberry.app.IAppContext;

/**
 * 小代码维护
 * @author     xia.zhilong
 * @version    2012-7-15 上午11:43:59 
 * @revision
 */
@Service("codesetService")
public class CodesetServiceImpl implements CodesetService {

	@Autowired
	private CodesetDao codesetDao;
	
	@Autowired
	private CodeItemDao codeItemDao;
	
	@Autowired
	private WaxberryContext waxberryContext;
	
	@Autowired
	private CodeItemService codeItemService;

	public Page<Codeset> findAll(Pageable pageable) {
		return (Page<Codeset>) codesetDao.findAll(pageable);
	}

	@Transactional
	public int deleteByCodeset(String codesetCode) {
		
		return codesetDao.deleteByCodeset(codesetCode);
	}
	
	@Transactional
	public Codeset save(Codeset codeset){
		return codesetDao.save(codeset);
	}
	public Codeset findOne(String codesetCode){
		return codesetDao.findOne(codesetCode);
	}

	public void delete(Iterable<Codeset> codesetCode) {
		codesetDao.delete(codesetCode);
	}
	
	public Page<Codeset> equalCodesetCodeAndlikeCodesetName(Codeset codeSet, Pageable pageable){
		return codesetDao.equalCodesetCodeAndlikeCodesetName(codeSet, pageable);
		
	}
	
	
	/**
	 * 删除记录
	 * @param String[] deleteId
	 */
	@Transactional
	public void deleteRecord(String[] deleteId){
		
		List<Codeset> codesetList = new ArrayList<Codeset>();
		
		if (deleteId.length == 1){
			List<CodeItem> listCodeItem = codeItemDao.findByCodesetCode(deleteId[0]);
			codesetDao.deleteByCodeset(deleteId[0]);
			
			if(listCodeItem.size() > 0){
				for (CodeItem codeItem : listCodeItem) {
					String itemId = codeItem.getItemId();
					codeItemDao.deleteByItemId(itemId);
				}
			}
		}else{
			for (String codesetCode : deleteId) {
				Codeset codesetTemp = new Codeset();
				codesetTemp.setCodesetCode(codesetCode);
				codesetList.add(codesetTemp);
				
				// 根据codesetCode 找到子表所有的记录
				List<CodeItem> listCodeItem = codeItemDao.findByCodesetCode(codesetCode);
				codeItemDao.delete(listCodeItem);
			}
			codesetDao.delete(codesetList);
			
		}
	}
	
	/*******************************************************************************************
	 * 根据代码集编码从 db中获取代码信息
	 * 
	 * @param codesetCode
	 * @return
	 */
	private CodesetVo getCodeFromDb(String codesetCode) {
		Codeset codeset = findOne(codesetCode);
		List<CodeItem> codeItems = codeItemService
				.findByCodesetCodeAndItemStatus(codesetCode,LSConstants.BOOLEAN_TRUE);
		// copy main bean's properities
		CodesetVo codesetVo = new CodesetVo();
		if (codeset != null) {
			BeanUtils.copyProperties(codeset, codesetVo);
		}
		// copy sub bean's properities
		List<CodeItemVo> codeItemVos = new ArrayList<CodeItemVo>();
		for (CodeItem codeItem : codeItems) {
			CodeItemVo codeItemVo = new CodeItemVo();
			BeanUtils.copyProperties(codeItem, codeItemVo);
			codeItemVos.add(codeItemVo);
		}
		codesetVo.setCodeItems(codeItemVos);
		codesetVo.setCodeItemSize(codeItemVos.size());
		return codesetVo;
	}

	/**
	 * 根据代码集编码获取代码信息
	 * 
	 * @param codesetCode
	 * @return
	 */
	public CodesetVo getCodeset(String codesetCode) {
		IAppContext appContext = waxberryContext.getAppContext();
		// CodesetVo codeset = getCodeFromDb(codesetCode);
		CodesetVo returnCode = null;
		CodesetVo codeset = (CodesetVo) appContext.getAttribute("BS.CODE."
				+ codesetCode);
		if (null == codeset) {
			codeset = getCodeFromDb(codesetCode);
			appContext.setAttribute("BS.CODE." + codesetCode, codeset);
		}
		if (codeset.getCodeItemSize() > 20 ) {
			returnCode = new CodesetVo();
			String[] ignoreProperties = {"codeItems"};
			BeanUtils.copyProperties(codeset, returnCode, ignoreProperties);
		}else{
			returnCode = codeset;
		}
		return returnCode;
	}

	/**
	 * 根据代码集编码获取代码信息
	 * 
	 * @param codesetCode
	 * @return
	 */
	public CodesetVo getCodeset(String codesetCode, boolean isLazyLoad) {
		IAppContext appContext = waxberryContext.getAppContext();
//		CodesetVo codeset = getCodeFromDb(codesetCode);
		CodesetVo returnCode = null;
		CodesetVo codeset = (CodesetVo) appContext.getAttribute("BS.CODE."
				+ codesetCode);
		if (null == codeset) {
			codeset = getCodeFromDb(codesetCode);
			appContext.setAttribute("BS.CODE." + codesetCode, codeset);
		}
		if (isLazyLoad) {
			returnCode = new CodesetVo();
			String[] ignoreProperties = {"codeItems"};
			BeanUtils.copyProperties(codeset, returnCode, ignoreProperties);
		}else{
			returnCode = codeset;
		}
		return returnCode;
	}

	/**
	 * 根据代码集编码和代码项编码返回代码项显示名称
	 * 
	 * @param codesetCode
	 * @param itemCode
	 * @return
	 */
	public String getItemCodeName(String codesetCode, String itemCode) {
		String itemCodeName = "";
		CodeItemVo codeItemVo = getCodeItem(codesetCode, itemCode);
		itemCodeName = codeItemVo.getItemChsCode();
		return itemCodeName;
	}

	/**
	 * 根据代码集编码和代码项编码返回代码项对象
	 * 
	 * @param codesetCode
	 * @param itemCode
	 * @return
	 */
	private CodeItemVo getCodeItem(String codesetCode, String itemCode) {
		IAppContext appContext = waxberryContext.getAppContext();
		CodeItemVo codeItemVo = (CodeItemVo) appContext.getAttribute("BS.CODE."
				+ codesetCode + "." + itemCode);
		if (codeItemVo == null) {
			codeItemVo = new CodeItemVo();
			List<CodeItem> codeItems = codeItemService
					.findByCodesetCodeAndItemCode(codesetCode, itemCode);
			if (codeItems != null && codeItems.size() > 0) {
				CodeItem codeItem = codeItems.get(0);
				BeanUtils.copyProperties(codeItem, codeItemVo);
				appContext.setAttribute("BS.CODE." + codesetCode + "."
						+ itemCode, codeItemVo);
			}
		}
		return codeItemVo;
	}
	
	public Codeset findByCodesetCode(String codesetCode){
		return codesetDao.findByCodesetCode(codesetCode);
	}
	
	public Codeset findByCodesetName(String codeSetName){
		return codesetDao.findByCodesetName(codeSetName);
	}
}
