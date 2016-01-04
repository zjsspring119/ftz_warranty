package com.ouyeelf.ftz.model.domain.warranty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 *  接口表-仓单被查询记录: INTER_WARRANTY_QUERY
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="INTER_WARRANTY_QUERY")
public class InterWarrantyQuery  extends BSBaseDomain{
	// : ID 	
	    @Id
		@Column(name="ID")
	private String id; 
	
	//仓单登记号 : WARRANTY_NO 		
		@Column(name="WARRANTY_NO")
	private String warrantyNo; 
	
	//查询人或平台代码 : CUST_CODE 		
		@Column(name="CUST_CODE")
	private String custCode; 
	
	//查询人或平台名称 : CUST_NAME 		
		@Column(name="CUST_NAME")
	private String custName; 
	
	//查询时间 : QUERY_TIME 		
		@Column(name="QUERY_TIME")
	private java.util.Date queryTime; 
	
	//该用户等级 : QUERY_LEVEL 		
		@Column(name="QUERY_LEVEL")
	private String queryLevel; 
	

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
	 * 查询人或平台代码 : CUST_CODE
	 * 
	 * @return 
	 */
	public String getCustCode () {
		return custCode;
	}
	
	/**
	 * 查询人或平台代码 : CUST_CODE
	 * 
	 * @return 
	 */
	public void setCustCode (String custCode) {
		this.custCode = custCode;
	}
	/**
	 * 查询人或平台名称 : CUST_NAME
	 * 
	 * @return 
	 */
	public String getCustName () {
		return custName;
	}
	
	/**
	 * 查询人或平台名称 : CUST_NAME
	 * 
	 * @return 
	 */
	public void setCustName (String custName) {
		this.custName = custName;
	}
	/**
	 * 查询时间 : QUERY_TIME
	 * 
	 * @return 
	 */
	public java.util.Date getQueryTime () {
		return queryTime;
	}
	
	/**
	 * 查询时间 : QUERY_TIME
	 * 
	 * @return 
	 */
	public void setQueryTime (java.util.Date queryTime) {
		this.queryTime = queryTime;
	}
	/**
	 * 该用户等级 : QUERY_LEVEL
	 * 
	 * @return 
	 */
	public String getQueryLevel () {
		return queryLevel;
	}
	
	/**
	 * 该用户等级 : QUERY_LEVEL
	 * 
	 * @return 
	 */
	public void setQueryLevel (String queryLevel) {
		this.queryLevel = queryLevel;
	}

}
