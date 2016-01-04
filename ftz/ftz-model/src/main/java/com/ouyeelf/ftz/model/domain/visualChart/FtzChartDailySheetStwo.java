package com.ouyeelf.ftz.model.domain.visualChart;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 日报表第三页第一张图（平台==>品种==>交易数据）: FTZ_CHART_DAILY_SHEET_STWO
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="FTZ_CHART_DAILY_SHEET_STWO")
public class FtzChartDailySheetStwo  extends BSBaseDomain{
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
	
	//品种代码 : PRD_CATA_CODE 		
		@Column(name="PRD_CATA_CODE")
	private String prdCataCode; 
	
	//品种名称 : PRD_CATA_NAME 		
		@Column(name="PRD_CATA_NAME")
	private String prdCataName; 
	
	//创建时间 : CREATE_TIME 		
		@Column(name="CREATE_TIME")
	private String createTime; 
	
	//生成仓单笔数(笔)  : CREATE_COUNT 		
		@Column(name="CREATE_COUNT")
	private Integer createCount; 
	
	//生成仓单重量(吨)   : CREATE_WEIGHT 		
		@Column(name="CREATE_WEIGHT")
	private java.math.BigDecimal createWeight; 
	
	//生成仓单数量(件)   : CREATE_PIECE 		
		@Column(name="CREATE_PIECE")
	private java.math.BigDecimal createPiece; 
	
	//注销仓单笔数 : CANCEL_COUNT 		
		@Column(name="CANCEL_COUNT")
	private Integer cancelCount; 
	
	//注销仓单重量 : CANCEL_WEIGHT 		
		@Column(name="CANCEL_WEIGHT")
	private java.math.BigDecimal cancelWeight; 
	
	//注销仓单数量 : CANCEL_PIECE 		
		@Column(name="CANCEL_PIECE")
	private java.math.BigDecimal cancelPiece; 
	

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
	 * 生成仓单笔数(笔)  : CREATE_COUNT
	 * 
	 * @return 
	 */
	public Integer getCreateCount () {
		return createCount;
	}
	
	/**
	 * 生成仓单笔数(笔)  : CREATE_COUNT
	 * 
	 * @return 
	 */
	public void setCreateCount (Integer createCount) {
		this.createCount = createCount;
	}
	/**
	 * 生成仓单重量(吨)   : CREATE_WEIGHT
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getCreateWeight () {
		return createWeight;
	}
	
	/**
	 * 生成仓单重量(吨)   : CREATE_WEIGHT
	 * 
	 * @return 
	 */
	public void setCreateWeight (java.math.BigDecimal createWeight) {
		this.createWeight = createWeight;
	}
	/**
	 * 生成仓单数量(件)   : CREATE_PIECE
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getCreatePiece () {
		return createPiece;
	}
	
	/**
	 * 生成仓单数量(件)   : CREATE_PIECE
	 * 
	 * @return 
	 */
	public void setCreatePiece (java.math.BigDecimal createPiece) {
		this.createPiece = createPiece;
	}
	/**
	 * 注销仓单笔数 : CANCEL_COUNT
	 * 
	 * @return 
	 */
	public Integer getCancelCount () {
		return cancelCount;
	}
	
	/**
	 * 注销仓单笔数 : CANCEL_COUNT
	 * 
	 * @return 
	 */
	public void setCancelCount (Integer cancelCount) {
		this.cancelCount = cancelCount;
	}
	/**
	 * 注销仓单重量 : CANCEL_WEIGHT
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getCancelWeight () {
		return cancelWeight;
	}
	
	/**
	 * 注销仓单重量 : CANCEL_WEIGHT
	 * 
	 * @return 
	 */
	public void setCancelWeight (java.math.BigDecimal cancelWeight) {
		this.cancelWeight = cancelWeight;
	}
	/**
	 * 注销仓单数量 : CANCEL_PIECE
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getCancelPiece () {
		return cancelPiece;
	}
	
	/**
	 * 注销仓单数量 : CANCEL_PIECE
	 * 
	 * @return 
	 */
	public void setCancelPiece (java.math.BigDecimal cancelPiece) {
		this.cancelPiece = cancelPiece;
	}

}
