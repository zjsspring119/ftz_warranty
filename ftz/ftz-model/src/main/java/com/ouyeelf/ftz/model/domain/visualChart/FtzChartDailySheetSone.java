package com.ouyeelf.ftz.model.domain.visualChart;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 日报表第三页第一张图（平台==>仓库==>交易重量）: FTZ_CHART_DAILY_SHEET_SONE
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="FTZ_CHART_DAILY_SHEET_SONE")
public class FtzChartDailySheetSone  extends BSBaseDomain{
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
	
	//仓库代码 : WAREHOUSE_NUM 		
		@Column(name="WAREHOUSE_NUM")
	private String warehouseNum; 
	
	//仓库名称 : WAREHOUSE_NAME 		
		@Column(name="WAREHOUSE_NAME")
	private String warehouseName; 
	
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
