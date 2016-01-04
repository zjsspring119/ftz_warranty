package com.ouyeelf.ftz.service.basicManage.codeset;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.domain.codeset.Codeset;
import com.ouyeelf.ftz.model.vo.codeset.CodesetVo;



/**
 * 小代码维护
 * @author     xia.zhilong
 * @version    2012-7-15 上午11:44:48 
 * @revision
 */
public interface CodesetService {
	public Page<Codeset> findAll(Pageable pageable);
	
	public int deleteByCodeset(String codesetCode);
	
	public void delete(Iterable<Codeset> codesetCode);
	
	public Codeset save(Codeset codeItem);
	
	public Codeset findOne(String codesetCode);
	
	public Page<Codeset> equalCodesetCodeAndlikeCodesetName(Codeset codeSet, Pageable pageable);
	
	/**
	 * 根据代码集编码获取代码信息
	 * 
	 * @param codesetCode
	 * @return
	 */
	public CodesetVo getCodeset(String codesetCode);
	/**
	 * 根据代码集编码获取代码信息
	 * 
	 * @param codesetCode
	 * @return
	 */
	public CodesetVo getCodeset(String codesetCode, boolean isLazyLoad) ;
	/**
	 * 根据代码集编码和代码项编码返回代码项显示名称
	 * 
	 * @param codesetCode
	 * @param itemCode
	 * @return
	 */
	public String getItemCodeName(String codesetCode, String itemCode);

	/**
	 * 删除记录
	 * @param deleteId
	 */
	public void deleteRecord(String[] deleteId);
	
	
	public Codeset findByCodesetCode(String codesetCode);
	
	public Codeset findByCodesetName(String codeSetName);
	
}
