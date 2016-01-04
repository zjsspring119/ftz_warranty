package com.ouyeelf.ftz.model.domain.visualChart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 日报表可视化试图（交易平台==>交易重量）: FTZ_CHART_DAILYSHEET_VISUAL
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name = "FTZ_CHART_DAILYSHEET_VISUAL")
public class FtzChartDailysheetVisual extends BSBaseDomain {
	// 主键ID : ID
	@Id
	@Column(name = "ID")
	private String id;

	// 图表JSON数据 : CHART_JSON
	@Column(name = "CHART_JSON")
	private String chartJson;

	// 创建时间 : CREATE_TIME
	@Column(name = "CREATE_TIME")
	private String createTime;

	/**
	 * 主键ID : ID
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 主键ID : ID
	 * 
	 * @return
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 图表JSON数据 : CHART_JSON
	 * 
	 * @return
	 */
	public String getChartJson() {
		return chartJson;
	}

	/**
	 * 图表JSON数据 : CHART_JSON
	 * 
	 * @return
	 */
	public void setChartJson(String chartJson) {
		this.chartJson = chartJson;
	}

	/**
	 * 创建时间 : CREATE_TIME
	 * 
	 * @return
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间 : CREATE_TIME
	 * 
	 * @return
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
