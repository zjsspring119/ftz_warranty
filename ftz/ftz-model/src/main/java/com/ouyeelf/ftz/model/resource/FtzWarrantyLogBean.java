package com.ouyeelf.ftz.model.resource;

import com.ouyeelf.ftz.model.BaseEntity;



/**
 * 公示平台仓单履历: FTZ_WARRANTY_LOG
 * 
 * 
 * @author zjs
 */
public class FtzWarrantyLogBean  extends BaseEntity{
	//序号 : ID 		
	private String id; 
	
	private String warrantyNo; 
	
	//交易平台单据号 : ORG_BILL_NO 		
	private String orgBillNo; 
	
	//新仓单状态 : NEW_STATUS 		
	private String newStatus; 
	
	//老仓单状态 : OLD_STATUS 		
	private String oldStatus; 
	
	//品种名称 : PRD_CATA_NAME 		
	private String prdCataName; 
	
	
	//品种代码 : PRD_CATA_CODE 		
	private String prdCataCode; 
	
	//总数量 : NUM 		
	private String num; 
	
	//数量单位 : UNIT 		
	private String unit; 
	
	//总重量 : WEIGHT 		
	private String weight; 
	
	//重量单位 : WEIGHT_UNIT 		
	private String weightUnit; 
	
	//原货主代码 : ORG_CUST_CODE 		
	private String orgCustCode; 
	
	//原货主名称 : ORG_CUST_NAME 		
	private String orgCustName; 
	
	//新货主代码 : NEW_CUST_CODE 		
	private String newCustCode; 
	
	//新货主名称 : NEW_CUST_NAME 		
	private String newCustName; 
	
	//成交时间(YYYY-MM-DD HH:MI:SS) : BUSSINESS_TIME 		
	private String bussinessTime; 
	
	//新建时间 : CREATE_TIME 		
	private String createTime; 
	
	//比对标记0：初始化 1：已比对 COMPARE_FLAG
	private String compareFlag;	
		
	// 是否被同步mongodb（1-已同步）：IS_SYNCHRONIZE
	private String isSynchronize;
	
	// 比对标记0：初始化 1：已比对 COMPARE_FLAG
	private String remark;
	
	public String getIsSynchronize() {
		return isSynchronize;
	}

	public void setIsSynchronize(String isSynchronize) {
		this.isSynchronize = isSynchronize;
	}

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

	public String getOrgBillNo() {
		return orgBillNo;
	}

	public void setOrgBillNo(String orgBillNo) {
		this.orgBillNo = orgBillNo;
	}

	public String getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}

	public String getOldStatus() {
		return oldStatus;
	}

	public void setOldStatus(String oldStatus) {
		this.oldStatus = oldStatus;
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

	public String getOrgCustCode() {
		return orgCustCode;
	}

	public void setOrgCustCode(String orgCustCode) {
		this.orgCustCode = orgCustCode;
	}

	public String getOrgCustName() {
		return orgCustName;
	}

	public void setOrgCustName(String orgCustName) {
		this.orgCustName = orgCustName;
	}

	public String getNewCustCode() {
		return newCustCode;
	}

	public void setNewCustCode(String newCustCode) {
		this.newCustCode = newCustCode;
	}

	public String getNewCustName() {
		return newCustName;
	}

	public void setNewCustName(String newCustName) {
		this.newCustName = newCustName;
	}

	public String getBussinessTime() {
		return bussinessTime;
	}

	public void setBussinessTime(String bussinessTime) {
		this.bussinessTime = bussinessTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCompareFlag() {
		return compareFlag;
	}

	public void setCompareFlag(String compareFlag) {
		this.compareFlag = compareFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	

}
