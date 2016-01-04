package com.ouyeelf.ftz.model.domain.visualChart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 每日品种新增登记量: FTZ_CHART_ADDCLASS_BASE
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="FTZ_CHART_ADDCLASS_BASE")
public class FtzChartAddclassBase  extends BSBaseDomain{
	//主键id : ID 	
		@Id
		@Column(name="ID")
	private String id; 
	
	//交易平台代码 : ORG_SYS_NO 		
		@Column(name="ORG_SYS_NO")
	private String orgSysNo; 
	
	//交易平台名称 : ORG_SYS_NAME 		
		@Column(name="ORG_SYS_NAME")
	private String orgSysName; 
	
	//贸易商代码 : CUSTOMER_CODE 		
		@Column(name="CUSTOMER_CODE")
	private String customerCode; 
	
	//贸易商名称 : CUSTOMER_NAME 		
		@Column(name="CUSTOMER_NAME")
	private String customerName; 
	
	//品种大类代码 : PM_CLASS_CODE 		
		@Column(name="PM_CLASS_CODE")
	private String pmClassCode; 
	
	//仓单笔数 : WARRANTY_COUNT 		
		@Column(name="WARRANTY_COUNT")
	private java.math.BigDecimal warrantyCount; 
	
	//创建时间 : CREATE_TIME 		
		@Column(name="CREATE_TIME")
	private java.util.Date createTime; 
	
	//品种大类代码 : PM_CLASS_NAME 		
		@Column(name="PM_CLASS_NAME")
	private String pmClassName; 
	

	/**
	 * 主键id : ID
	 * 
	 * @return 
	 */
	public String getId () {
		return id;
	}
	
	/**
	 * 主键id : ID
	 * 
	 * @return 
	 */
	public void setId (String id) {
		this.id = id;
	}
	/**
	 * 交易平台代码 : ORG_SYS_NO
	 * 
	 * @return 
	 */
	public String getOrgSysNo () {
		return orgSysNo;
	}
	
	/**
	 * 交易平台代码 : ORG_SYS_NO
	 * 
	 * @return 
	 */
	public void setOrgSysNo (String orgSysNo) {
		this.orgSysNo = orgSysNo;
	}
	/**
	 * 交易平台名称 : ORG_SYS_NAME
	 * 
	 * @return 
	 */
	public String getOrgSysName () {
		return orgSysName;
	}
	
	/**
	 * 交易平台名称 : ORG_SYS_NAME
	 * 
	 * @return 
	 */
	public void setOrgSysName (String orgSysName) {
		this.orgSysName = orgSysName;
	}
	/**
	 * 贸易商代码 : CUSTOMER_CODE
	 * 
	 * @return 
	 */
	public String getCustomerCode () {
		return customerCode;
	}
	
	/**
	 * 贸易商代码 : CUSTOMER_CODE
	 * 
	 * @return 
	 */
	public void setCustomerCode (String customerCode) {
		this.customerCode = customerCode;
	}
	/**
	 * 贸易商名称 : CUSTOMER_NAME
	 * 
	 * @return 
	 */
	public String getCustomerName () {
		return customerName;
	}
	
	/**
	 * 贸易商名称 : CUSTOMER_NAME
	 * 
	 * @return 
	 */
	public void setCustomerName (String customerName) {
		this.customerName = customerName;
	}
	/**
	 * 品种大类代码 : PM_CLASS_CODE
	 * 
	 * @return 
	 */
	public String getPmClassCode () {
		return pmClassCode;
	}
	
	/**
	 * 品种大类代码 : PM_CLASS_CODE
	 * 
	 * @return 
	 */
	public void setPmClassCode (String pmClassCode) {
		this.pmClassCode = pmClassCode;
	}
	/**
	 * 仓单笔数 : WARRANTY_COUNT
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getWarrantyCount () {
		return warrantyCount;
	}
	
	/**
	 * 仓单笔数 : WARRANTY_COUNT
	 * 
	 * @return 
	 */
	public void setWarrantyCount (java.math.BigDecimal warrantyCount) {
		this.warrantyCount = warrantyCount;
	}
	/**
	 * 创建时间 : CREATE_TIME
	 * 
	 * @return 
	 */
	public java.util.Date getCreateTime () {
		return createTime;
	}
	
	/**
	 * 创建时间 : CREATE_TIME
	 * 
	 * @return 
	 */
	public void setCreateTime (java.util.Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 品种大类代码 : PM_CLASS_NAME
	 * 
	 * @return 
	 */
	public String getPmClassName () {
		return pmClassName;
	}
	
	/**
	 * 品种大类代码 : PM_CLASS_NAME
	 * 
	 * @return 
	 */
	public void setPmClassName (String pmClassName) {
		this.pmClassName = pmClassName;
	}

}
