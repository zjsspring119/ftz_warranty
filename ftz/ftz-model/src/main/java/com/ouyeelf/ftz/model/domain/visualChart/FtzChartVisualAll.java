package com.ouyeelf.ftz.model.domain.visualChart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 可视化图表JSON数据表: FTZ_CHART_VISUAL_ALL
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="FTZ_CHART_VISUAL_ALL")
public class FtzChartVisualAll  extends BSBaseDomain{
	//主键ID : ID 	
	    @Id
		@Column(name="ID")
	private String id; 
	
	//图表类型 参见小代码X013 : CHART_TYPE 		
		@Column(name="CHART_TYPE")
	private String chartType; 
	
	//图表JSON数据 : CHART_JSON 		
		@Column(name="CHART_JSON")
	private String chartJson; 
	
	//备注 : REMARK 		
		@Column(name="REMARK")
	private String remark; 
	
	//品名类代码　类型03时使用的 : PM_CLASS_CODE 		
		@Column(name="PM_CLASS_CODE")
	private String pmClassCode; 
	
	//品种代码　类型03时使用的 : BREED_CODE 		
		@Column(name="BREED_CODE")
	private String breedCode; 
	
	//品种名称　类型03时使用的 : BREED_NAME 		
		@Column(name="BREED_NAME")
	private String breedName; 
	
	// 保管人名称（仓库名称） : WAREHOUSE_NAME
	@Column(name = "WAREHOUSE_NAME")
	private String warehouseName;	

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
	 * 图表类型 参见小代码X013 : CHART_TYPE
	 * 
	 * @return 
	 */
	public String getChartType () {
		return chartType;
	}
	
	/**
	 * 图表类型 参见小代码X013 : CHART_TYPE
	 * 
	 * @return 
	 */
	public void setChartType (String chartType) {
		this.chartType = chartType;
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
	 * 备注 : REMARK
	 * 
	 * @return 
	 */
	public String getRemark () {
		return remark;
	}
	
	/**
	 * 备注 : REMARK
	 * 
	 * @return 
	 */
	public void setRemark (String remark) {
		this.remark = remark;
	}
	/**
	 * 品名类代码　类型03时使用的 : PM_CLASS_CODE
	 * 
	 * @return 
	 */
	public String getPmClassCode () {
		return pmClassCode;
	}
	
	/**
	 * 品名类代码　类型03时使用的 : PM_CLASS_CODE
	 * 
	 * @return 
	 */
	public void setPmClassCode (String pmClassCode) {
		this.pmClassCode = pmClassCode;
	}
	/**
	 * 品种代码　类型03时使用的 : BREED_CODE
	 * 
	 * @return 
	 */
	public String getBreedCode () {
		return breedCode;
	}
	
	/**
	 * 品种代码　类型03时使用的 : BREED_CODE
	 * 
	 * @return 
	 */
	public void setBreedCode (String breedCode) {
		this.breedCode = breedCode;
	}
	/**
	 * 品种名称　类型03时使用的 : BREED_NAME
	 * 
	 * @return 
	 */
	public String getBreedName () {
		return breedName;
	}
	
	/**
	 * 品种名称　类型03时使用的 : BREED_NAME
	 * 
	 * @return 
	 */
	public void setBreedName (String breedName) {
		this.breedName = breedName;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

}
