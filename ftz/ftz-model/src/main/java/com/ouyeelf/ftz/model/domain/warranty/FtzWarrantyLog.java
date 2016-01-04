package com.ouyeelf.ftz.model.domain.warranty;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 公示平台仓单履历: FTZ_WARRANTY_LOG
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="FTZ_WARRANTY_LOG")
public class FtzWarrantyLog  extends BSBaseDomain{

	private static final long serialVersionUID = -8457196878293577148L;

		//序号 : ID 		
		@Id
		@Column(name="ID")
	private String id; 
	
	//仓单登记号 : WARRANTY_NO 		
		@Column(name="WARRANTY_NO")
	private String warrantyNo; 
	
	//交易平台单据号 : ORG_BILL_NO 		
		@Column(name="ORG_BILL_NO")
	private String orgBillNo; 
	
	//新仓单状态 : NEW_STATUS 		
		@Column(name="NEW_STATUS")
	private String newStatus; 
	
	//老仓单状态 : OLD_STATUS 		
		@Column(name="OLD_STATUS")
	private String oldStatus; 
	
	//品种名称 : PRD_CATA_NAME 		
		@Column(name="PRD_CATA_NAME")
	private String prdCataName; 
	
	//品种代码 : PRD_CATA_CODE 		
		@Column(name="PRD_CATA_CODE")
	private String prdCataCode; 
	
	//总数量 : NUM 		
		@Column(name="NUM")
	private Integer num; 
	
	//数量单位 : UNIT 		
		@Column(name="UNIT")
	private String unit; 
	
	//总重量 : WEIGHT 		
		@Column(name="WEIGHT")
	private java.math.BigDecimal weight; 
	
	//重量单位 : WEIGHT_UNIT 		
		@Column(name="WEIGHT_UNIT")
	private String weightUnit; 
	
	//原货主代码 : ORG_CUST_CODE 		
		@Column(name="ORG_CUST_CODE")
	private String orgCustCode; 
	
	//原货主名称 : ORG_CUST_NAME 		
		@Column(name="ORG_CUST_NAME")
	private String orgCustName; 
	
	//新货主代码 : NEW_CUST_CODE 		
		@Column(name="NEW_CUST_CODE")
	private String newCustCode; 
	
	//新货主名称 : NEW_CUST_NAME 		
		@Column(name="NEW_CUST_NAME")
	private String newCustName; 
	
	//成交时间(YYYY-MM-DD HH:MI:SS) : BUSSINESS_TIME 		
		@Column(name="BUSSINESS_TIME")
	private String bussinessTime; 
	
	//新建时间 : CREATE_TIME 		
		@Column(name="CREATE_TIME")
	private java.util.Date createTime; 
	
	//比对标记0：初始化 1：已比对 COMPARE_FLAG
	@Column(name="COMPARE_FLAG")	
	private String compareFlag;	
	
	//比对标记0：初始化 1：已比对 COMPARE_FLAG
	@Column(name="REMARK")	
	private String remark;	
		
	// 是否被同步mongodb（1-已同步）：IS_SYNCHRONIZE
	@Column(name = "IS_SYNCHRONIZE")
	private String isSynchronize;
	
	//交易价格（锁定时填写）
	@Column(name = "BUSSINESS_PRICE")
	private BigDecimal bussinessPrice;
	/**
	 * 序号 : ID
	 * 
	 * @return 
	 */
	public String getId () {
		return id;
	}
	
	/**
	 * 序号 : ID
	 * 
	 * @return 
	 */
	public void setId (String id) {
		this.id = id;
	}
	/**
	 * 仓单登记号 : WARRANTY_NO
	 * 
	 * @return 
	 */
	public String getWarrantyNo () {
		return warrantyNo;
	}
	
	/**
	 * 仓单登记号 : WARRANTY_NO
	 * 
	 * @return 
	 */
	public void setWarrantyNo (String warrantyNo) {
		this.warrantyNo = warrantyNo;
	}
	/**
	 * 交易平台单据号 : ORG_BILL_NO
	 * 
	 * @return 
	 */
	public String getOrgBillNo () {
		return orgBillNo;
	}
	
	/**
	 * 交易平台单据号 : ORG_BILL_NO
	 * 
	 * @return 
	 */
	public void setOrgBillNo (String orgBillNo) {
		this.orgBillNo = orgBillNo;
	}
	/**
	 * 新仓单状态 : NEW_STATUS
	 * 
	 * @return 
	 */
	public String getNewStatus () {
		return newStatus;
	}
	
	/**
	 * 新仓单状态 : NEW_STATUS
	 * 
	 * @return 
	 */
	public void setNewStatus (String newStatus) {
		this.newStatus = newStatus;
	}
	/**
	 * 老仓单状态 : OLD_STATUS
	 * 
	 * @return 
	 */
	public String getOldStatus () {
		return oldStatus;
	}
	
	/**
	 * 老仓单状态 : OLD_STATUS
	 * 
	 * @return 
	 */
	public void setOldStatus (String oldStatus) {
		this.oldStatus = oldStatus;
	}
	/**
	 * 品种名称 : PRD_CATA_NAME
	 * 
	 * @return 
	 */
	public String getPrdCataName () {
		return prdCataName;
	}
	
	/**
	 * 品种名称 : PRD_CATA_NAME
	 * 
	 * @return 
	 */
	public void setPrdCataName (String prdCataName) {
		this.prdCataName = prdCataName;
	}
	/**
	 * 品种代码 : PRD_CATA_CODE
	 * 
	 * @return 
	 */
	public String getPrdCataCode () {
		return prdCataCode;
	}
	
	/**
	 * 品种代码 : PRD_CATA_CODE
	 * 
	 * @return 
	 */
	public void setPrdCataCode (String prdCataCode) {
		this.prdCataCode = prdCataCode;
	}
	/**
	 * 总数量 : NUM
	 * 
	 * @return 
	 */
	public Integer getNum () {
		return num;
	}
	
	/**
	 * 总数量 : NUM
	 * 
	 * @return 
	 */
	public void setNum (Integer num) {
		this.num = num;
	}
	/**
	 * 数量单位 : UNIT
	 * 
	 * @return 
	 */
	public String getUnit () {
		return unit;
	}
	
	/**
	 * 数量单位 : UNIT
	 * 
	 * @return 
	 */
	public void setUnit (String unit) {
		this.unit = unit;
	}
	/**
	 * 总重量 : WEIGHT
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getWeight () {
		return weight;
	}
	
	/**
	 * 总重量 : WEIGHT
	 * 
	 * @return 
	 */
	public void setWeight (java.math.BigDecimal weight) {
		this.weight = weight;
	}
	/**
	 * 重量单位 : WEIGHT_UNIT
	 * 
	 * @return 
	 */
	public String getWeightUnit () {
		return weightUnit;
	}
	
	/**
	 * 重量单位 : WEIGHT_UNIT
	 * 
	 * @return 
	 */
	public void setWeightUnit (String weightUnit) {
		this.weightUnit = weightUnit;
	}
	/**
	 * 原货主代码 : ORG_CUST_CODE
	 * 
	 * @return 
	 */
	public String getOrgCustCode () {
		return orgCustCode;
	}
	
	/**
	 * 原货主代码 : ORG_CUST_CODE
	 * 
	 * @return 
	 */
	public void setOrgCustCode (String orgCustCode) {
		this.orgCustCode = orgCustCode;
	}
	/**
	 * 原货主名称 : ORG_CUST_NAME
	 * 
	 * @return 
	 */
	public String getOrgCustName () {
		return orgCustName;
	}
	
	/**
	 * 原货主名称 : ORG_CUST_NAME
	 * 
	 * @return 
	 */
	public void setOrgCustName (String orgCustName) {
		this.orgCustName = orgCustName;
	}
	/**
	 * 新货主代码 : NEW_CUST_CODE
	 * 
	 * @return 
	 */
	public String getNewCustCode () {
		return newCustCode;
	}
	
	/**
	 * 新货主代码 : NEW_CUST_CODE
	 * 
	 * @return 
	 */
	public void setNewCustCode (String newCustCode) {
		this.newCustCode = newCustCode;
	}
	/**
	 * 新货主名称 : NEW_CUST_NAME
	 * 
	 * @return 
	 */
	public String getNewCustName () {
		return newCustName;
	}
	
	/**
	 * 新货主名称 : NEW_CUST_NAME
	 * 
	 * @return 
	 */
	public void setNewCustName (String newCustName) {
		this.newCustName = newCustName;
	}
	/**
	 * 成交时间(YYYY-MM-DD HH:MI:SS) : BUSSINESS_TIME
	 * 
	 * @return 
	 */
	public String getBussinessTime () {
		return bussinessTime;
	}
	
	/**
	 * 成交时间(YYYY-MM-DD HH:MI:SS) : BUSSINESS_TIME
	 * 
	 * @return 
	 */
	public void setBussinessTime (String bussinessTime) {
		this.bussinessTime = bussinessTime;
	}
	/**
	 * 新建时间 : CREATE_TIME
	 * 
	 * @return 
	 */
	public java.util.Date getCreateTime () {
		return createTime;
	}
	
	/**
	 * 新建时间 : CREATE_TIME
	 * 
	 * @return 
	 */
	public void setCreateTime (java.util.Date createTime) {
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

	public String getIsSynchronize() {
		return isSynchronize;
	}

	public void setIsSynchronize(String isSynchronize) {
		this.isSynchronize = isSynchronize;
	}

	public BigDecimal getBussinessPrice() {
		return bussinessPrice;
	}

	public void setBussinessPrice(BigDecimal bussinessPrice) {
		this.bussinessPrice = bussinessPrice;
	}
	
	

}
