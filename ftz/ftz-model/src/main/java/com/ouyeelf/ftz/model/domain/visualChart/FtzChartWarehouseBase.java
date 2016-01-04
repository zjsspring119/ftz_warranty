package com.ouyeelf.ftz.model.domain.visualChart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 仓单每日仓库登记总量: FTZ_CHART_WAREHOUSE_BASE
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="FTZ_CHART_WAREHOUSE_BASE")
public class FtzChartWarehouseBase  extends BSBaseDomain{
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
	
	//仓库代码 : WAREHOUSE_NUM 		
		@Column(name="WAREHOUSE_NUM")
	private String warehouseNum; 
	
	//仓库名称 : WAREHOUSE_NAME 		
		@Column(name="WAREHOUSE_NAME")
	private String warehouseName; 
	
	//仓单笔数 : WARRANTY_COUNT 		
		@Column(name="WARRANTY_COUNT")
	private java.math.BigDecimal warrantyCount; 
	
	//创建时间 : CREATE_TIME 		
		@Column(name="CREATE_TIME")
	private java.util.Date createTime; 
	

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
	 * 仓库代码 : WAREHOUSE_NUM
	 * 
	 * @return 
	 */
	public String getWarehouseNum () {
		return warehouseNum;
	}
	
	/**
	 * 仓库代码 : WAREHOUSE_NUM
	 * 
	 * @return 
	 */
	public void setWarehouseNum (String warehouseNum) {
		this.warehouseNum = warehouseNum;
	}
	/**
	 * 仓库名称 : WAREHOUSE_NAME
	 * 
	 * @return 
	 */
	public String getWarehouseName () {
		return warehouseName;
	}
	
	/**
	 * 仓库名称 : WAREHOUSE_NAME
	 * 
	 * @return 
	 */
	public void setWarehouseName (String warehouseName) {
		this.warehouseName = warehouseName;
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

}
