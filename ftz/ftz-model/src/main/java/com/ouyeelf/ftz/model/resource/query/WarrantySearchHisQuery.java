package com.ouyeelf.ftz.model.resource.query;

import java.util.Map;

/**
 * 仓单查询历史
 * 
 * 
 * @author Gen
 */
public class WarrantySearchHisQuery extends BeseQueryVo {
	// 主键 : ID
	private String id;

	// 仓单号 : WARRANTY_NO
	private String warrantyNo;

	// 查询人代码 : SEARCHER
	private String searcher;

	// 查询时间 : SEARCH_TIME
	private String searchTime;

	// 交易平台代码 : ORG_SYS_NO
	private String orgSysNo;

	// 交易平台名称 : ORG_SYS_NAME
	private String orgSysName;

	// 品种名称 : PRD_CATA_NAME
	private String prdCataName;

	// 品种代码 : PRD_CATA_CODE
	private String prdCataCode;

	// 数量 : NUM
	private String num;

	// 数量单位 : UNIT
	private String unit;

	// 总重量 : WEIGHT
	private String weight;

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
	
	private Map<String,String> sortMap;
	
	private String favoritesFlag;//关注标记 1：关注  0:不关注
	private String favoritesCode;//关注代码(操作代码)
	
	/*private String sortName;//
	
	private String sortValue;
*/
	private String warehouseName; //仓库名称
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWarrantyNo() {
		return warrantyNo;
	}

	public void setWarrantyNo(String warrantyNo) {
		this.warrantyNo = warrantyNo;
	}

	public String getSearcher() {
		return searcher;
	}

	public void setSearcher(String searcher) {
		this.searcher = searcher;
	}

	public String getSearchTime() {
		return searchTime;
	}

	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}

	public String getOrgSysNo() {
		return orgSysNo;
	}

	public void setOrgSysNo(String orgSysNo) {
		this.orgSysNo = orgSysNo;
	}

	public String getOrgSysName() {
		return orgSysName;
	}

	public void setOrgSysName(String orgSysName) {
		this.orgSysName = orgSysName;
	}

	public String getPrdCataName() {
		return prdCataName;
	}

	public void setPrdCataName(String prdCataName) {
		this.prdCataName = prdCataName;
	}

	public String getPrdCataCode() {
		return prdCataCode;
	}

	public void setPrdCataCode(String prdCataCode) {
		this.prdCataCode = prdCataCode;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public String getWarrantyStatus() {
		return warrantyStatus;
	}

	public void setWarrantyStatus(String warrantyStatus) {
		this.warrantyStatus = warrantyStatus;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public Map<String, String> getSortMap() {
		return sortMap;
	}

	public void setSortMap(Map<String, String> sortMap) {
		this.sortMap = sortMap;
	}

	public String getFavoritesFlag() {
		return favoritesFlag;
	}

	public void setFavoritesFlag(String favoritesFlag) {
		this.favoritesFlag = favoritesFlag;
	}

	public String getFavoritesCode() {
		return favoritesCode;
	}

	public void setFavoritesCode(String favoritesCode) {
		this.favoritesCode = favoritesCode;
	}

}
