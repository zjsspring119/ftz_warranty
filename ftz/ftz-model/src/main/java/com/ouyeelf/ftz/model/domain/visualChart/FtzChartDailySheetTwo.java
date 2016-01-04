package com.ouyeelf.ftz.model.domain.visualChart;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 日报表第二页（平台==>交易重量）: FTZ_CHART_DAILY_SHEET_TWO
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="FTZ_CHART_DAILY_SHEET_TWO")
public class FtzChartDailySheetTwo  extends BSBaseDomain{
	//主键id : ID 	
		@Id
		@Column(name="ID")
	private String id; 
	
	//交易平台代码(自贸区用) : ORG_SYS_NO 		
		@Column(name="ORG_SYS_NO")
	private String orgSysNo; 
	
	//交易平台名称(自贸区用) : ORG_SYS_NAME 		
		@Column(name="ORG_SYS_NAME")
	private String orgSysName; 
	
	//交易重量 : SUM_WEIGHT 		
		@Column(name="SUM_WEIGHT")
	private java.math.BigDecimal sumWeight; 
	
	//创建时间 : CREATE_TIME 		
		@Column(name="CREATE_TIME")
	private String createTime; 
	

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
	 * 交易平台代码(自贸区用) : ORG_SYS_NO
	 * 
	 * @return 
	 */
	public String getOrgSysNo () {
		return orgSysNo;
	}
	
	/**
	 * 交易平台代码(自贸区用) : ORG_SYS_NO
	 * 
	 * @return 
	 */
	public void setOrgSysNo (String orgSysNo) {
		this.orgSysNo = orgSysNo;
	}
	/**
	 * 交易平台名称(自贸区用) : ORG_SYS_NAME
	 * 
	 * @return 
	 */
	public String getOrgSysName () {
		return orgSysName;
	}
	
	/**
	 * 交易平台名称(自贸区用) : ORG_SYS_NAME
	 * 
	 * @return 
	 */
	public void setOrgSysName (String orgSysName) {
		this.orgSysName = orgSysName;
	}
	/**
	 * 交易重量 : SUM_WEIGHT
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getSumWeight () {
		return sumWeight;
	}
	
	/**
	 * 交易重量 : SUM_WEIGHT
	 * 
	 * @return 
	 */
	public void setSumWeight (java.math.BigDecimal sumWeight) {
		this.sumWeight = sumWeight;
	}
	/**
	 * 创建时间 : CREATE_TIME
	 * 
	 * @return 
	 */
	public String getCreateTime () {
		return createTime;
	}
	
	/**
	 * 创建时间 : CREATE_TIME
	 * 
	 * @return 
	 */
	public void setCreateTime (String createTime) {
		this.createTime = createTime;
	}

}
