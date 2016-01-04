package com.ouyeelf.ftz.model.domain.visualChart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 自贸区图标颜色: FTZ_CHART_NAMECOLOR
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="FTZ_CHART_NAMECOLOR")
public class FtzChartNamecolor  extends BSBaseDomain{
	//主键id : ID 
		@Id
		@Column(name="ID")
	private String id; 
	
	//代码 : CHAR_CODE 		
		@Column(name="CHAR_CODE")
	private String charCode; 
	
	//名称 : CHAR_NAME 		
		@Column(name="CHAR_NAME")
	private String charName; 
	
	//颜色 : CHAR_COLOR 		
		@Column(name="CHAR_COLOR")
	private String charColor; 
	
	//备注 : REMARK 		
		@Column(name="REMARK")
	private String remark; 
	
	//类型：0:品种大类,1:交易平台　2:仓库 : TYPE 		
		@Column(name="TYPE")
	private String type; 
	
	//状态:0:禁用　1:启用 : STATUS 		
		@Column(name="STATUS")
	private String status; 
	

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
	 * 代码 : CHAR_CODE
	 * 
	 * @return 
	 */
	public String getCharCode () {
		return charCode;
	}
	
	/**
	 * 代码 : CHAR_CODE
	 * 
	 * @return 
	 */
	public void setCharCode (String charCode) {
		this.charCode = charCode;
	}
	/**
	 * 名称 : CHAR_NAME
	 * 
	 * @return 
	 */
	public String getCharName () {
		return charName;
	}
	
	/**
	 * 名称 : CHAR_NAME
	 * 
	 * @return 
	 */
	public void setCharName (String charName) {
		this.charName = charName;
	}
	/**
	 * 颜色 : CHAR_COLOR
	 * 
	 * @return 
	 */
	public String getCharColor () {
		return charColor;
	}
	
	/**
	 * 颜色 : CHAR_COLOR
	 * 
	 * @return 
	 */
	public void setCharColor (String charColor) {
		this.charColor = charColor;
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
	 * 类型：0:品种大类,1:交易平台　2:仓库 : TYPE
	 * 
	 * @return 
	 */
	public String getType () {
		return type;
	}
	
	/**
	 * 类型：0:品种大类,1:交易平台　2:仓库 : TYPE
	 * 
	 * @return 
	 */
	public void setType (String type) {
		this.type = type;
	}
	/**
	 * 状态:0:禁用　1:启用 : STATUS
	 * 
	 * @return 
	 */
	public String getStatus () {
		return status;
	}
	
	/**
	 * 状态:0:禁用　1:启用 : STATUS
	 * 
	 * @return 
	 */
	public void setStatus (String status) {
		this.status = status;
	}

}
