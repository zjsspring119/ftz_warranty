package com.ouyeelf.ftz.model.domain.visualChart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 日报表: FTZ_DAILY_SHEET
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="FTZ_DAILY_SHEET")
public class FtzDailySheet  extends BSBaseDomain{
	//主键id : ID 		
				@Id
				@Column(name="ID")
	private String id; 
	
	//仓库代码 : WAREHOUSE_NUM 		
					@Column(name="WAREHOUSE_NUM")
	private String warehouseNum; 
	
	//仓库名称 : WAREHOUSE_NAME 		
					@Column(name="WAREHOUSE_NAME")
	private String warehouseName; 
	
	//品种代码 : PRD_CATA_CODE 		
					@Column(name="PRD_CATA_CODE")
	private String prdCataCode; 
	
	//品种名称 : PRD_CATA_NAME 		
					@Column(name="PRD_CATA_NAME")
	private String prdCataName; 
	
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
	
	//创建时间 : CREATE_TIME 		
					@Column(name="CREATE_TIME")
	private String createTime; 
	
	//是否汇总（0：是，1 否） : IS_SUM 		
					@Column(name="IS_SUM")
	private String isSum; 
	

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
	 * 是否汇总（0：是，1 否） : IS_SUM
	 * 
	 * @return 
	 */
	public String getIsSum () {
		return isSum;
	}
	
	/**
	 * 是否汇总（0：是，1 否） : IS_SUM
	 * 
	 * @return 
	 */
	public void setIsSum (String isSum) {
		this.isSum = isSum;
	}

}
