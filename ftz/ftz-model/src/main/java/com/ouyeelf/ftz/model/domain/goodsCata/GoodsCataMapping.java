package com.ouyeelf.ftz.model.domain.goodsCata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 基础配置_公示平台商品品种对照表: FDS_GOODS_CATA_MAPPING
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="FDS_GOODS_CATA_MAPPING")
public class GoodsCataMapping  extends BSBaseDomain{
	//ID : ID 		
	@Id
		@Column(name="ID")
	private String id; 
	
	//分市场品种代码 : FTZ_CATAGORY_CODE 		
		@Column(name="FTZ_CATAGORY_CODE")
	private String ftzCatagoryCode; 
	
	//分市场品种名称 : FTZ_CATAGORY_NAME 		
		@Column(name="FTZ_CATAGORY_NAME")
	private String ftzCatagoryName; 
	
	//基础品种代码(参见FDS_T_GOODS_CATALOG.CODE) : BASE_CATAGORY_CODE 		
		@Column(name="BASE_CATAGORY_CODE")
	private String baseCatagoryCode; 
	
	//基础品种名称(参见FDS_T_GOODS_CATALOG.FULLNAME_ZH) : BASE_CATAGORY_NAME 		
		@Column(name="BASE_CATAGORY_NAME")
	private String baseCatagoryName; 
	
	//市场区分标识（参见X001小代码） : MARKET_FLAG 		
		@Column(name="MARKET_FLAG")
	private String marketFlag; 
	
	//基础品类代码 : BASE_P_CODE 		
		@Column(name="BASE_P_CODE")
	private String basePCode; 
	
	//基础品类名称 : BASE_P_NAME 		
		@Column(name="BASE_P_NAME")
	private String basePName; 
	

	/**
	 * ID : ID
	 * 
	 * @return 
	 */
	public String getId () {
		return id;
	}
	
	/**
	 * ID : ID
	 * 
	 * @return 
	 */
	public void setId (String id) {
		this.id = id;
	}
	/**
	 * 分市场品种代码 : FTZ_CATAGORY_CODE
	 * 
	 * @return 
	 */
	public String getFtzCatagoryCode () {
		return ftzCatagoryCode;
	}
	
	/**
	 * 分市场品种代码 : FTZ_CATAGORY_CODE
	 * 
	 * @return 
	 */
	public void setFtzCatagoryCode (String ftzCatagoryCode) {
		this.ftzCatagoryCode = ftzCatagoryCode;
	}
	/**
	 * 分市场品种名称 : FTZ_CATAGORY_NAME
	 * 
	 * @return 
	 */
	public String getFtzCatagoryName () {
		return ftzCatagoryName;
	}
	
	/**
	 * 分市场品种名称 : FTZ_CATAGORY_NAME
	 * 
	 * @return 
	 */
	public void setFtzCatagoryName (String ftzCatagoryName) {
		this.ftzCatagoryName = ftzCatagoryName;
	}
	/**
	 * 基础品种代码(参见FDS_T_GOODS_CATALOG.CODE) : BASE_CATAGORY_CODE
	 * 
	 * @return 
	 */
	public String getBaseCatagoryCode () {
		return baseCatagoryCode;
	}
	
	/**
	 * 基础品种代码(参见FDS_T_GOODS_CATALOG.CODE) : BASE_CATAGORY_CODE
	 * 
	 * @return 
	 */
	public void setBaseCatagoryCode (String baseCatagoryCode) {
		this.baseCatagoryCode = baseCatagoryCode;
	}
	/**
	 * 基础品种名称(参见FDS_T_GOODS_CATALOG.FULLNAME_ZH) : BASE_CATAGORY_NAME
	 * 
	 * @return 
	 */
	public String getBaseCatagoryName () {
		return baseCatagoryName;
	}
	
	/**
	 * 基础品种名称(参见FDS_T_GOODS_CATALOG.FULLNAME_ZH) : BASE_CATAGORY_NAME
	 * 
	 * @return 
	 */
	public void setBaseCatagoryName (String baseCatagoryName) {
		this.baseCatagoryName = baseCatagoryName;
	}
	/**
	 * 市场区分标识（参见X001小代码） : MARKET_FLAG
	 * 
	 * @return 
	 */
	public String getMarketFlag () {
		return marketFlag;
	}
	
	/**
	 * 市场区分标识（参见X001小代码） : MARKET_FLAG
	 * 
	 * @return 
	 */
	public void setMarketFlag (String marketFlag) {
		this.marketFlag = marketFlag;
	}
	/**
	 * 基础品类代码 : BASE_P_CODE
	 * 
	 * @return 
	 */
	public String getBasePCode () {
		return basePCode;
	}
	
	/**
	 * 基础品类代码 : BASE_P_CODE
	 * 
	 * @return 
	 */
	public void setBasePCode (String basePCode) {
		this.basePCode = basePCode;
	}
	/**
	 * 基础品类名称 : BASE_P_NAME
	 * 
	 * @return 
	 */
	public String getBasePName () {
		return basePName;
	}
	
	/**
	 * 基础品类名称 : BASE_P_NAME
	 * 
	 * @return 
	 */
	public void setBasePName (String basePName) {
		this.basePName = basePName;
	}

}
