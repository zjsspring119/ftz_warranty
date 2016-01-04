package com.ouyeelf.ftz.model.domain.warranty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 接口表-仓单扩展属性表: INTER_WARRANTY_GOODS_EXT_SPEC
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="INTER_WARRANTY_GOODS_EXT_SPEC")
public class InterWarrantyGoodsExtSpec  extends BSBaseDomain{
	// : ID 		
				@Id
				@Column(name="ID")
	private String id; 
	
	//货物唯一标识 : GOOD_ID 		
					@Column(name="GOOD_ID")
	private String goodId; 
	
	//规格属性名称 : SPEC_NAME 		
					@Column(name="SPEC_NAME")
	private String specName; 
	
	//规格属性代码 : SPEC_CODE 		
					@Column(name="SPEC_CODE")
	private String specCode; 
	
	//规格属性描述 : SPEC_DESC 		
					@Column(name="SPEC_DESC")
	private String specDesc; 
	
	//INTER_WARRANTY_GOODS表主键id : IWG_ID 		
					@Column(name="IWG_ID")
	private String iwgId; 
	

	/**
	 *  : ID
	 * 
	 * @return 
	 */
	public String getId () {
		return id;
	}
	
	/**
	 *  : ID
	 * 
	 * @return 
	 */
	public void setId (String id) {
		this.id = id;
	}
	/**
	 * 货物唯一标识 : GOOD_ID
	 * 
	 * @return 
	 */
	public String getGoodId () {
		return goodId;
	}
	
	/**
	 * 货物唯一标识 : GOOD_ID
	 * 
	 * @return 
	 */
	public void setGoodId (String goodId) {
		this.goodId = goodId;
	}
	/**
	 * 规格属性名称 : SPEC_NAME
	 * 
	 * @return 
	 */
	public String getSpecName () {
		return specName;
	}
	
	/**
	 * 规格属性名称 : SPEC_NAME
	 * 
	 * @return 
	 */
	public void setSpecName (String specName) {
		this.specName = specName;
	}
	/**
	 * 规格属性代码 : SPEC_CODE
	 * 
	 * @return 
	 */
	public String getSpecCode () {
		return specCode;
	}
	
	/**
	 * 规格属性代码 : SPEC_CODE
	 * 
	 * @return 
	 */
	public void setSpecCode (String specCode) {
		this.specCode = specCode;
	}
	/**
	 * 规格属性描述 : SPEC_DESC
	 * 
	 * @return 
	 */
	public String getSpecDesc () {
		return specDesc;
	}
	
	/**
	 * 规格属性描述 : SPEC_DESC
	 * 
	 * @return 
	 */
	public void setSpecDesc (String specDesc) {
		this.specDesc = specDesc;
	}
	/**
	 * INTER_WARRANTY_GOODS表主键id : IWG_ID
	 * 
	 * @return 
	 */
	public String getIwgId () {
		return iwgId;
	}
	
	/**
	 * INTER_WARRANTY_GOODS表主键id : IWG_ID
	 * 
	 * @return 
	 */
	public void setIwgId (String iwgId) {
		this.iwgId = iwgId;
	}

}
