package com.ouyeelf.ftz.model.resource.query;

import java.util.List;

public class WarrantyQueryBean extends BeseQueryVo {

	private String warrantyNo; //仓单号 多个以逗号分开
	
	private String pmClassList;//品种 多个以逗号分开
	
	private String warrantyStatus;//仓单状态
	
	private String orgSysNo;//交易代码 多个以逗号分开
	
	private String orgSysName;//交易平台名称支持模糊查询
	
	private String customerName;//贸易商名称
	
	private String marketFlag;//市场标记
	
	// 是否违禁仓单（1-是、0-否） : ILLICIT_FLAG
    private String illicitFlag;
	
    private String createTime;//登记时间（创建时间）
	//排序
	private String sortName; 
	private String sortValue;
	
	private String favoritesFlag;//关注标记 1：关注  0:不关注
	private String favoritesCode;//关注代码(操作代码)
	// 外系统业务单据号(自贸区用) 
	private String orgBillNo;
	
	private String publicFlag;//公示标记 1：公示查询  否知列表查询
	
	private String warehouseName;//仓库名称
	
	public String getWarrantyNo() {
		return warrantyNo;
	}

	public void setWarrantyNo(String warrantyNo) {
		this.warrantyNo = warrantyNo;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortValue() {
		return sortValue;
	}

	public void setSortValue(String sortValue) {
		this.sortValue = sortValue;
	}

	public String getPmClassList() {
		return pmClassList;
	}

	public void setPmClassList(String pmClassList) {
		this.pmClassList = pmClassList;
	}

	public String getWarrantyStatus() {
		return warrantyStatus;
	}

	public void setWarrantyStatus(String warrantyStatus) {
		this.warrantyStatus = warrantyStatus;
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMarketFlag() {
		return marketFlag;
	}

	public void setMarketFlag(String marketFlag) {
		this.marketFlag = marketFlag;
	}

	public String getIllicitFlag() {
		return illicitFlag;
	}

	public void setIllicitFlag(String illicitFlag) {
		this.illicitFlag = illicitFlag;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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

	public String getOrgBillNo() {
		return orgBillNo;
	}

	public void setOrgBillNo(String orgBillNo) {
		this.orgBillNo = orgBillNo;
	}

	public String getPublicFlag() {
		return publicFlag;
	}

	public void setPublicFlag(String publicFlag) {
		this.publicFlag = publicFlag;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}


}