package com.ouyeelf.ftz.model.mdbean;

import com.ouyeelf.ftz.model.BaseEntity;



/**
 * 仓单查询历史
 * 
 * 
 * @author Gen
 */
public class WarrantySearchHisBean extends BaseEntity {
	// 主键 : ID
	private String id;

	// 仓单号 : WARRANTY_NO
	private String warrantyNo;

	// 查询人代码 : SEARCHER
	private String searcher;

	// 查询时间 : SEARCH_TIME
	private java.util.Date searchTime;

	// 交易平台代码 : ORG_SYS_NO
	private String orgSysNo;

	// 交易平台名称 : ORG_SYS_NAME
	private String orgSysName;

	// 品种名称 : PRD_CATA_NAME
	private String prdCataName;

	// 品种代码 : PRD_CATA_CODE
	private String prdCataCode;

	// 数量 : NUM
	private Integer num;

	// 数量单位 : UNIT
	private String unit;

	// 总重量 : WEIGHT
	private java.math.BigDecimal weight;

	// 重量单位 : WEIGHT_UNIT
	private String weightUnit;

	// 仓单状态(参见S029小代码) : WARRANTY_STATUS
	private String warrantyStatus;

	// 查询关键字 : KEY_WORD
	private String keyWord;

	// 查询来源ip地址 : IP_ADDR
	private String ipAddr;

	// 查询来源地区 : AREA
	private String area;

	// 保管人代码（仓库代码） : WAREHOUSE_NUM
	private String warehouseNum;

	// 保管人名称（仓库名称） : WAREHOUSE_NAME
	private String warehouseName;
	
	private String warrantyType; //仓单类型（参见X002小代码）
	
	private String taxedFlag; //完税标志（0--未税; 1--完税）
	
	private String[] favorites;
	public String getWarrantyType() {
		return warrantyType;
	}

	public void setWarrantyType(String warrantyType) {
		this.warrantyType = warrantyType;
	}

	public String getTaxedFlag() {
		return taxedFlag;
	}

	public void setTaxedFlag(String taxedFlag) {
		this.taxedFlag = taxedFlag;
	}

	/**
	 * 主键 : ID
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 主键 : ID
	 * 
	 * @return
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 仓单号 : WARRANTY_NO
	 * 
	 * @return
	 */
	public String getWarrantyNo() {
		return warrantyNo;
	}

	/**
	 * 仓单号 : WARRANTY_NO
	 * 
	 * @return
	 */
	public void setWarrantyNo(String warrantyNo) {
		this.warrantyNo = warrantyNo;
	}

	/**
	 * 查询人代码 : SEARCHER
	 * 
	 * @return
	 */
	public String getSearcher() {
		return searcher;
	}

	/**
	 * 查询人代码 : SEARCHER
	 * 
	 * @return
	 */
	public void setSearcher(String searcher) {
		this.searcher = searcher;
	}

	/**
	 * 查询时间 : SEARCH_TIME
	 * 
	 * @return
	 */
	public java.util.Date getSearchTime() {
		return searchTime;
	}

	/**
	 * 查询时间 : SEARCH_TIME
	 * 
	 * @return
	 */
	public void setSearchTime(java.util.Date searchTime) {
		this.searchTime = searchTime;
	}

	/**
	 * 交易平台代码 : ORG_SYS_NO
	 * 
	 * @return
	 */
	public String getOrgSysNo() {
		return orgSysNo;
	}

	/**
	 * 交易平台代码 : ORG_SYS_NO
	 * 
	 * @return
	 */
	public void setOrgSysNo(String orgSysNo) {
		this.orgSysNo = orgSysNo;
	}

	/**
	 * 交易平台名称 : ORG_SYS_NAME
	 * 
	 * @return
	 */
	public String getOrgSysName() {
		return orgSysName;
	}

	/**
	 * 交易平台名称 : ORG_SYS_NAME
	 * 
	 * @return
	 */
	public void setOrgSysName(String orgSysName) {
		this.orgSysName = orgSysName;
	}

	/**
	 * 品种名称 : PRD_CATA_NAME
	 * 
	 * @return
	 */
	public String getPrdCataName() {
		return prdCataName;
	}

	/**
	 * 品种名称 : PRD_CATA_NAME
	 * 
	 * @return
	 */
	public void setPrdCataName(String prdCataName) {
		this.prdCataName = prdCataName;
	}

	/**
	 * 品种代码 : PRD_CATA_CODE
	 * 
	 * @return
	 */
	public String getPrdCataCode() {
		return prdCataCode;
	}

	/**
	 * 品种代码 : PRD_CATA_CODE
	 * 
	 * @return
	 */
	public void setPrdCataCode(String prdCataCode) {
		this.prdCataCode = prdCataCode;
	}

	/**
	 * 数量 : NUM
	 * 
	 * @return
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * 数量 : NUM
	 * 
	 * @return
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * 数量单位 : UNIT
	 * 
	 * @return
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * 数量单位 : UNIT
	 * 
	 * @return
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * 总重量 : WEIGHT
	 * 
	 * @return
	 */
	public java.math.BigDecimal getWeight() {
		return weight;
	}

	/**
	 * 总重量 : WEIGHT
	 * 
	 * @return
	 */
	public void setWeight(java.math.BigDecimal weight) {
		this.weight = weight;
	}

	/**
	 * 重量单位 : WEIGHT_UNIT
	 * 
	 * @return
	 */
	public String getWeightUnit() {
		return weightUnit;
	}

	/**
	 * 重量单位 : WEIGHT_UNIT
	 * 
	 * @return
	 */
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	/**
	 * 仓单状态(参见S029小代码) : WARRANTY_STATUS
	 * 
	 * @return
	 */
	public String getWarrantyStatus() {
		return warrantyStatus;
	}

	/**
	 * 仓单状态(参见S029小代码) : WARRANTY_STATUS
	 * 
	 * @return
	 */
	public void setWarrantyStatus(String warrantyStatus) {
		this.warrantyStatus = warrantyStatus;
	}

	/**
	 * 查询关键字 : KEY_WORD
	 * 
	 * @return
	 */
	public String getKeyWord() {
		return keyWord;
	}

	/**
	 * 查询关键字 : KEY_WORD
	 * 
	 * @return
	 */
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	/**
	 * 查询来源ip地址 : IP_ADDR
	 * 
	 * @return
	 */
	public String getIpAddr() {
		return ipAddr;
	}

	/**
	 * 查询来源ip地址 : IP_ADDR
	 * 
	 * @return
	 */
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	/**
	 * 查询来源地区 : AREA
	 * 
	 * @return
	 */
	public String getArea() {
		return area;
	}

	/**
	 * 查询来源地区 : AREA
	 * 
	 * @return
	 */
	public void setArea(String area) {
		this.area = area;
	}

	public String getWarehouseNum() {
		return warehouseNum;
	}

	public void setWarehouseNum(String warehouseNum) {
		this.warehouseNum = warehouseNum;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String[] getFavorites() {
		return favorites;
	}

	public void setFavorites(String[] favorites) {
		this.favorites = favorites;
	}
	
	

}
