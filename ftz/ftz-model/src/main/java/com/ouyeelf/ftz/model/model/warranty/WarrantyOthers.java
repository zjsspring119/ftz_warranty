package com.ouyeelf.ftz.model.model.warranty;

public class WarrantyOthers {

	private String trdSysNo ;//交易平台代码
	private String warrantyNo;//仓单登记号
	private String bussinessNo;//交易单号
	private String lockType;	//1:挂牌锁定   2:交易锁定  3其他锁定
	private String bussinessPrice;//交易价格
	private String bussinessNumber;//交易数量
	private String newCustCode;//成交对象代码
	private String newCustName;//成交对象名称
	private String newCustEName;//成交对象英文简称
	private String orgCustCode;//原货主代码
	private String orgCustName;//原货主名称
	private String bussinessTime;//成交时间
	private String remark;//备注
	public String getTrdSysNo() {
		return trdSysNo;
	}
	public void setTrdSysNo(String trdSysNo) {
		this.trdSysNo = trdSysNo;
	}
	public String getWarrantyNo() {
		return warrantyNo;
	}
	public void setWarrantyNo(String warrantyNo) {
		this.warrantyNo = warrantyNo;
	}
	public String getBussinessNo() {
		return bussinessNo;
	}
	public void setBussinessNo(String bussinessNo) {
		this.bussinessNo = bussinessNo;
	}
	public String getBussinessPrice() {
		return bussinessPrice;
	}
	public void setBussinessPrice(String bussinessPrice) {
		this.bussinessPrice = bussinessPrice;
	}
	public String getBussinessNumber() {
		return bussinessNumber;
	}
	public void setBussinessNumber(String bussinessNumber) {
		this.bussinessNumber = bussinessNumber;
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
	public String getBussinessTime() {
		return bussinessTime;
	}
	public void setBussinessTime(String bussinessTime) {
		this.bussinessTime = bussinessTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLockType() {
		return lockType;
	}
	public void setLockType(String lockType) {
		this.lockType = lockType;
	}
	public String getNewCustEName() {
		return newCustEName;
	}
	public void setNewCustEName(String newCustEName) {
		this.newCustEName = newCustEName;
	}
	
	
}
