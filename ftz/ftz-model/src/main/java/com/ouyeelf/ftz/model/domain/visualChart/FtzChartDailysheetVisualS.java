package com.ouyeelf.ftz.model.domain.visualChart;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 日报表第三页可视化数据表（平台==>仓库/品种）==>交量: FTZ_CHART_DAILYSHEET_VISUAL_S
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="FTZ_CHART_DAILYSHEET_VISUAL_S")
public class FtzChartDailysheetVisualS  extends BSBaseDomain{
	//主键ID : ID 		
				@Id
				@Column(name="ID")
	private String id; 
	
	//图表JSON数据 : CHART_JSON 		
					@Column(name="CHART_JSON")
	private String chartJson; 
	
	//创建时间 : CREATE_TIME 		
					@Column(name="CREATE_TIME")
	private String createTime; 
	
	//交易平台代码(自贸区用) : ORG_SYS_NO 		
					@Column(name="ORG_SYS_NO")
	private String orgSysNo; 
	
	//交易平台名称(自贸区用) : ORG_SYS_NAME 		
					@Column(name="ORG_SYS_NAME")
	private String orgSysName; 
	

	/**
	 * 主键ID : ID
	 * 
	 * @return 
	 */
	public String getId () {
		return id;
	}
	
	/**
	 * 主键ID : ID
	 * 
	 * @return 
	 */
	public void setId (String id) {
		this.id = id;
	}
	/**
	 * 图表JSON数据 : CHART_JSON
	 * 
	 * @return 
	 */
	public String getChartJson () {
		return chartJson;
	}
	
	/**
	 * 图表JSON数据 : CHART_JSON
	 * 
	 * @return 
	 */
	public void setChartJson (String chartJson) {
		this.chartJson = chartJson;
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

}
