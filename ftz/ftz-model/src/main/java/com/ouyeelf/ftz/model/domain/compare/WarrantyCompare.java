package com.ouyeelf.ftz.model.domain.compare;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 仓单比对统计信息: RZ_WARRANTY_COMPARE
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name = "RZ_WARRANTY_COMPARE")
public class WarrantyCompare extends BSBaseDomain {
	// : ID
	@Id
	@Column(name = "ID")
	private String id;

	// 比对结果单据号 : COMPARE_NO
	@Column(name = "COMPARE_NO")
	private String compareNo;

	// 业务系统别 : ORG_SYS_NO
	@Column(name = "ORG_SYS_NO")
	private String orgSysNo;

	// 交易平台名称 : ORG_SYS_NAME
	@Column(name = "ORG_SYS_NAME")
	private String orgSysName;

	// 仓库代码 : WAREHOUSE_NUM
	@Column(name = "WAREHOUSE_NUM")
	private String warehouseNum;

	// 仓库名称 : WAREHOUSE_NAME
	@Column(name = "WAREHOUSE_NAME")
	private String warehouseName;

	// 是否公开（0-否，1-是） : IS_PUBLIC
	@Column(name = "IS_PUBLIC")
	private String isPublic;

	// 品种名称 : PRD_CATA_NAME
	@Column(name = "PRD_CATA_NAME")
	private String prdCataName;

	// 品种代码 : PRD_CATA_CODE
	@Column(name = "PRD_CATA_CODE")
	private String prdCataCode;

	// 比对结果（0-异常，1-正常） : RESULT_FLAG
	@Column(name = "RESULT_FLAG")
	private String resultFlag;

	// 比对类型（1-按量按货主，2-按实物，3-按量不按货主，见小代码X012） : COMPARE_TYPE
	@Column(name = "COMPARE_TYPE")
	private String compareType;

	// 比对时间 : COMPARE_TIME
	@Column(name = "COMPARE_TIME")
	private java.util.Date compareTime;

	// 仓库是否过户（0-不过户，1-过户） : TRANSFER_TYPE
	@Column(name = "TRANSFER_TYPE")
	private String transferType;

	// 公示平台总数量 : FTZ_TOTAL_NUM
	@Column(name = "FTZ_TOTAL_NUM")
	private Integer ftzTotalNum;

	// 公示平台总重量 : FTZ_TOTAL_WEIGHT
	@Column(name = "FTZ_TOTAL_WEIGHT")
	private java.math.BigDecimal ftzTotalWeight;

	// 其他平台总数量 : OTHER_TOTAL_NUM
	@Column(name = "OTHER_TOTAL_NUM")
	private Integer otherTotalNum;

	// 其他平台总重量 : OTHER_TOTAL_WEIGHT
	@Column(name = "OTHER_TOTAL_WEIGHT")
	private java.math.BigDecimal otherTotalWeight;

	// 数量单位 : NUM_UNIT
	@Column(name = "NUM_UNIT")
	private String numUnit;

	// 重量单位 : WEIGHT_UNIT
	@Column(name = "WEIGHT_UNIT")
	private String weightUnit;

	// 比对来源（见小代码X011） : FROM_FLAG
	@Column(name = "FROM_FLAG")
	private String fromFlag;
	
	// 完税标志(1-完税; 0-未税)
	@Column(name = "TAXED_FLAG")
	private String taxedFlag;

	//市场区分标识（参见X001小代码）
	@Column(name="MARKET_FLAG")
	private String marketFlag;
	
	//比对异常记录数
	@Column(name="ABNORMAL_NUM")
	private Integer abnormalNum;
	
	//保存路径
	@Column(name="SAVE_PATH")
	private String savePath;
	
	//清算平台代码
	@Column(name="CLEAR_SYS_NO")
	private String clearSysNo;
	
	//清算平台名称
	@Column(name="CLEAR_SYS_NAME")
	private String clearSysName;
	
	//异议工单标记：0:未生成，1:已生成
	@Column(name="OBJECTION_ORDER")
    private String objectionOrder;
	/**
	 * : ID
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * : ID
	 * 
	 * @return
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 比对结果单据号 : COMPARE_NO
	 * 
	 * @return
	 */
	public String getCompareNo() {
		return compareNo;
	}

	/**
	 * 比对结果单据号 : COMPARE_NO
	 * 
	 * @return
	 */
	public void setCompareNo(String compareNo) {
		this.compareNo = compareNo;
	}

	/**
	 * 业务系统别 : ORG_SYS_NO
	 * 
	 * @return
	 */
	public String getOrgSysNo() {
		return orgSysNo;
	}

	/**
	 * 业务系统别 : ORG_SYS_NO
	 * 
	 * @return
	 */
	public void setOrgSysNo(String orgSysNo) {
		this.orgSysNo = orgSysNo;
	}

	/**
	 * 交易平台名称 : ORG_SYS_NAME
	 * 
	 * @return
	 */
	public String getOrgSysName() {
		return orgSysName;
	}

	/**
	 * 交易平台名称 : ORG_SYS_NAME
	 * 
	 * @return
	 */
	public void setOrgSysName(String orgSysName) {
		this.orgSysName = orgSysName;
	}

	/**
	 * 仓库代码 : WAREHOUSE_NUM
	 * 
	 * @return
	 */
	public String getWarehouseNum() {
		return warehouseNum;
	}

	/**
	 * 仓库代码 : WAREHOUSE_NUM
	 * 
	 * @return
	 */
	public void setWarehouseNum(String warehouseNum) {
		this.warehouseNum = warehouseNum;
	}

	/**
	 * 仓库名称 : WAREHOUSE_NAME
	 * 
	 * @return
	 */
	public String getWarehouseName() {
		return warehouseName;
	}

	/**
	 * 仓库名称 : WAREHOUSE_NAME
	 * 
	 * @return
	 */
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	/**
	 * 是否公开（0-否，1-是） : IS_PUBLIC
	 * 
	 * @return
	 */
	public String getIsPublic() {
		return isPublic;
	}

	/**
	 * 是否公开（0-否，1-是） : IS_PUBLIC
	 * 
	 * @return
	 */
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	/**
	 * 品种名称 : PRD_CATA_NAME
	 * 
	 * @return
	 */
	public String getPrdCataName() {
		return prdCataName;
	}

	/**
	 * 品种名称 : PRD_CATA_NAME
	 * 
	 * @return
	 */
	public void setPrdCataName(String prdCataName) {
		this.prdCataName = prdCataName;
	}

	/**
	 * 品种代码 : PRD_CATA_CODE
	 * 
	 * @return
	 */
	public String getPrdCataCode() {
		return prdCataCode;
	}

	/**
	 * 品种代码 : PRD_CATA_CODE
	 * 
	 * @return
	 */
	public void setPrdCataCode(String prdCataCode) {
		this.prdCataCode = prdCataCode;
	}

	/**
	 * 比对结果（0-异常，1-正常） : RESULT_FLAG
	 * 
	 * @return
	 */
	public String getResultFlag() {
		return resultFlag;
	}

	/**
	 * 比对结果（0-异常，1-正常） : RESULT_FLAG
	 * 
	 * @return
	 */
	public void setResultFlag(String resultFlag) {
		this.resultFlag = resultFlag;
	}

	/**
	 * 比对类型（0-实物比对，1-按量比对） : COMPARE_TYPE
	 * 
	 * @return
	 */
	public String getCompareType() {
		return compareType;
	}

	/**
	 * 比对类型（0-实物比对，1-按量比对） : COMPARE_TYPE
	 * 
	 * @return
	 */
	public void setCompareType(String compareType) {
		this.compareType = compareType;
	}

	/**
	 * 比对时间 : COMPARE_TIME
	 * 
	 * @return
	 */
	public java.util.Date getCompareTime() {
		return compareTime;
	}

	/**
	 * 比对时间 : COMPARE_TIME
	 * 
	 * @return
	 */
	public void setCompareTime(java.util.Date compareTime) {
		this.compareTime = compareTime;
	}

	/**
	 * 仓库是否过户（0-不过户，1-过户） : TRANSFER_TYPE
	 * 
	 * @return
	 */
	public String getTransferType() {
		return transferType;
	}

	/**
	 * 仓库是否过户（0-不过户，1-过户） : TRANSFER_TYPE
	 * 
	 * @return
	 */
	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	/**
	 * 公示平台总数量 : FTZ_TOTAL_NUM
	 * 
	 * @return
	 */
	public Integer getFtzTotalNum() {
		return ftzTotalNum;
	}

	/**
	 * 公示平台总数量 : FTZ_TOTAL_NUM
	 * 
	 * @return
	 */
	public void setFtzTotalNum(Integer ftzTotalNum) {
		this.ftzTotalNum = ftzTotalNum;
	}

	/**
	 * 公示平台总重量 : FTZ_TOTAL_WEIGHT
	 * 
	 * @return
	 */
	public java.math.BigDecimal getFtzTotalWeight() {
		return ftzTotalWeight;
	}

	/**
	 * 公示平台总重量 : FTZ_TOTAL_WEIGHT
	 * 
	 * @return
	 */
	public void setFtzTotalWeight(java.math.BigDecimal ftzTotalWeight) {
		this.ftzTotalWeight = ftzTotalWeight;
	}

	/**
	 * 其他平台总数量 : OTHER_TOTAL_NUM
	 * 
	 * @return
	 */
	public Integer getOtherTotalNum() {
		return otherTotalNum;
	}

	/**
	 * 其他平台总数量 : OTHER_TOTAL_NUM
	 * 
	 * @return
	 */
	public void setOtherTotalNum(Integer otherTotalNum) {
		this.otherTotalNum = otherTotalNum;
	}

	/**
	 * 其他平台总重量 : OTHER_TOTAL_WEIGHT
	 * 
	 * @return
	 */
	public java.math.BigDecimal getOtherTotalWeight() {
		return otherTotalWeight;
	}

	/**
	 * 其他平台总重量 : OTHER_TOTAL_WEIGHT
	 * 
	 * @return
	 */
	public void setOtherTotalWeight(java.math.BigDecimal otherTotalWeight) {
		this.otherTotalWeight = otherTotalWeight;
	}

	/**
	 * 数量单位 : NUM_UNIT
	 * 
	 * @return
	 */
	public String getNumUnit() {
		return numUnit;
	}

	/**
	 * 数量单位 : NUM_UNIT
	 * 
	 * @return
	 */
	public void setNumUnit(String numUnit) {
		this.numUnit = numUnit;
	}

	/**
	 * 重量单位 : WEIGHT_UNIT
	 * 
	 * @return
	 */
	public String getWeightUnit() {
		return weightUnit;
	}

	/**
	 * 重量单位 : WEIGHT_UNIT
	 * 
	 * @return
	 */
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public String getFromFlag() {
		return fromFlag;
	}

	public void setFromFlag(String fromFlag) {
		this.fromFlag = fromFlag;
	}

	public String getTaxedFlag() {
		return taxedFlag;
	}

	public void setTaxedFlag(String taxedFlag) {
		this.taxedFlag = taxedFlag;
	}

	public String getMarketFlag() {
		return marketFlag;
	}

	public void setMarketFlag(String marketFlag) {
		this.marketFlag = marketFlag;
	}

	public Integer getAbnormalNum() {
		return abnormalNum;
	}

	public void setAbnormalNum(Integer abnormalNum) {
		this.abnormalNum = abnormalNum;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getClearSysNo() {
		return clearSysNo;
	}

	public void setClearSysNo(String clearSysNo) {
		this.clearSysNo = clearSysNo;
	}

	public String getClearSysName() {
		return clearSysName;
	}

	public void setClearSysName(String clearSysName) {
		this.clearSysName = clearSysName;
	}

	public String getObjectionOrder() {
		return objectionOrder;
	}

	public void setObjectionOrder(String objectionOrder) {
		this.objectionOrder = objectionOrder;
	}
	
	
	
}
