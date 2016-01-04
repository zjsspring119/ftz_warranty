package com.ouyeelf.ftz.model.domain.warranty;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 接口表-仓单明细表: INTER_WARRANTY_GOODS
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="INTER_WARRANTY_GOODS")
public class InterWarrantyGoods  extends BSBaseDomain{
	// : ID 		
				@Id
				@Column(name="ID")
	private String id; 
	
	//货物唯一标识 : GOOD_ID 		
					@Column(name="GOOD_ID")
	private String goodId; 
	
	//品种名称 : PRD_VARIETY_NAME 		
					@Column(name="PRD_VARIETY_NAME")
	private String prdVarietyName; 
	
	//品种代码 : PRD_VARIETY_CODE 		
					@Column(name="PRD_VARIETY_CODE")
	private String prdVarietyCode; 
	
	//品名描述 : TYPE_NAME 		
					@Column(name="TYPE_NAME")
	private String typeName; 
	
	//规格描述 : SPEC_DESC 		
					@Column(name="SPEC_DESC")
	private String specDesc; 
	
	//捆包号(钢材保留) : PACK_NUM 		
					@Column(name="PACK_NUM")
	private String packNum; 
	
	//资源号(钢材保留) : RESOURCE_NUM 		
					@Column(name="RESOURCE_NUM")
	private String resourceNum; 
	
	//仓库库区描述 : AREA 		
					@Column(name="AREA")
	private String area; 
	
	//仓库库位描述 : LOCATION 		
					@Column(name="LOCATION")
	private String location; 
	
	//产地 : AREA_P 		
					@Column(name="AREA_P")
	private String areaP; 
	
	//材质 : GRADE 		
					@Column(name="GRADE")
	private String grade; 
	
	//重量 : WEIGHT 		
					@Column(name="WEIGHT")
	private java.math.BigDecimal weight; 
	
	//重量单位 : WEIGHT_UNIT 		
					@Column(name="WEIGHT_UNIT")
	private String weightUnit; 
	
	//数量 : SHEET_NUM 		
					@Column(name="SHEET_NUM")
	private Integer sheetNum; 
	
	//数量单位 : UNIT 		
					@Column(name="UNIT")
	private String unit; 
	
	//品质描述 : QUALITY_DESC 		
					@Column(name="QUALITY_DESC")
	private String qualityDesc; 
	
	//外观描述 : SHOW_DESC 		
					@Column(name="SHOW_DESC")
	private String showDesc; 
	
	//产品等级 : PRODUCT_GRADE 		
					@Column(name="PRODUCT_GRADE")
	private String productGrade; 
	
	//进仓日期(YYYYMMDD) : STORE_DATE 		
					@Column(name="STORE_DATE")
	private String storeDate; 
	
	//计量方式 : CHECK_TYPE 		
					@Column(name="CHECK_TYPE")
	private String checkType; 
	
	//包装方式 : PACK_TYPE_NAME 		
					@Column(name="PACK_TYPE_NAME")
	private String packTypeName; 
	
	//危险品等级 : DANGEROUS_LEVEL 		
					@Column(name="DANGEROUS_LEVEL")
	private String dangerousLevel; 
	
	//公示平台仓单号 : WARRANTY_NO 		
					@Column(name="WARRANTY_NO")
	private String warrantyNo; 
	
    //:扩展描述
	@Column(name="EXPAND_DESC")
	private String expandDesc;
	
    //:质检编号
	@Column(name="QC_SHEET_NO")
	private String qcSheetNo;
	
	
	@Column(name="UNIT_PRICE")
	private BigDecimal unitPrice;//单价
	
	@Column(name="TOTAL_PRICE")
	private BigDecimal totalPrice;//总价
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
	 * 货物唯一标识 : GOOD_ID
	 * 
	 * @return 
	 */
	public String getGoodId () {
		return goodId;
	}
	
	/**
	 * 货物唯一标识 : GOOD_ID
	 * 
	 * @return 
	 */
	public void setGoodId (String goodId) {
		this.goodId = goodId;
	}
	/**
	 * 品种名称 : PRD_VARIETY_NAME
	 * 
	 * @return 
	 */
	public String getPrdVarietyName () {
		return prdVarietyName;
	}
	
	/**
	 * 品种名称 : PRD_VARIETY_NAME
	 * 
	 * @return 
	 */
	public void setPrdVarietyName (String prdVarietyName) {
		this.prdVarietyName = prdVarietyName;
	}
	/**
	 * 品种代码 : PRD_VARIETY_CODE
	 * 
	 * @return 
	 */
	public String getPrdVarietyCode () {
		return prdVarietyCode;
	}
	
	/**
	 * 品种代码 : PRD_VARIETY_CODE
	 * 
	 * @return 
	 */
	public void setPrdVarietyCode (String prdVarietyCode) {
		this.prdVarietyCode = prdVarietyCode;
	}
	/**
	 * 品名描述 : TYPE_NAME
	 * 
	 * @return 
	 */
	public String getTypeName () {
		return typeName;
	}
	
	/**
	 * 品名描述 : TYPE_NAME
	 * 
	 * @return 
	 */
	public void setTypeName (String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 规格描述 : SPEC_DESC
	 * 
	 * @return 
	 */
	public String getSpecDesc () {
		return specDesc;
	}
	
	/**
	 * 规格描述 : SPEC_DESC
	 * 
	 * @return 
	 */
	public void setSpecDesc (String specDesc) {
		this.specDesc = specDesc;
	}
	/**
	 * 捆包号(钢材保留) : PACK_NUM
	 * 
	 * @return 
	 */
	public String getPackNum () {
		return packNum;
	}
	
	/**
	 * 捆包号(钢材保留) : PACK_NUM
	 * 
	 * @return 
	 */
	public void setPackNum (String packNum) {
		this.packNum = packNum;
	}
	/**
	 * 资源号(钢材保留) : RESOURCE_NUM
	 * 
	 * @return 
	 */
	public String getResourceNum () {
		return resourceNum;
	}
	
	/**
	 * 资源号(钢材保留) : RESOURCE_NUM
	 * 
	 * @return 
	 */
	public void setResourceNum (String resourceNum) {
		this.resourceNum = resourceNum;
	}
	/**
	 * 仓库库区描述 : AREA
	 * 
	 * @return 
	 */
	public String getArea () {
		return area;
	}
	
	/**
	 * 仓库库区描述 : AREA
	 * 
	 * @return 
	 */
	public void setArea (String area) {
		this.area = area;
	}
	/**
	 * 仓库库位描述 : LOCATION
	 * 
	 * @return 
	 */
	public String getLocation () {
		return location;
	}
	
	/**
	 * 仓库库位描述 : LOCATION
	 * 
	 * @return 
	 */
	public void setLocation (String location) {
		this.location = location;
	}
	/**
	 * 产地 : AREA_P
	 * 
	 * @return 
	 */
	public String getAreaP () {
		return areaP;
	}
	
	/**
	 * 产地 : AREA_P
	 * 
	 * @return 
	 */
	public void setAreaP (String areaP) {
		this.areaP = areaP;
	}
	/**
	 * 材质 : GRADE
	 * 
	 * @return 
	 */
	public String getGrade () {
		return grade;
	}
	
	/**
	 * 材质 : GRADE
	 * 
	 * @return 
	 */
	public void setGrade (String grade) {
		this.grade = grade;
	}
	/**
	 * 重量 : WEIGHT
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getWeight () {
		return weight;
	}
	
	/**
	 * 重量 : WEIGHT
	 * 
	 * @return 
	 */
	public void setWeight (java.math.BigDecimal weight) {
		this.weight = weight;
	}
	/**
	 * 重量单位 : WEIGHT_UNIT
	 * 
	 * @return 
	 */
	public String getWeightUnit () {
		return weightUnit;
	}
	
	/**
	 * 重量单位 : WEIGHT_UNIT
	 * 
	 * @return 
	 */
	public void setWeightUnit (String weightUnit) {
		this.weightUnit = weightUnit;
	}
	/**
	 * 数量 : SHEET_NUM
	 * 
	 * @return 
	 */
	public Integer getSheetNum () {
		return sheetNum;
	}
	
	/**
	 * 数量 : SHEET_NUM
	 * 
	 * @return 
	 */
	public void setSheetNum (Integer sheetNum) {
		this.sheetNum = sheetNum;
	}
	/**
	 * 数量单位 : UNIT
	 * 
	 * @return 
	 */
	public String getUnit () {
		return unit;
	}
	
	/**
	 * 数量单位 : UNIT
	 * 
	 * @return 
	 */
	public void setUnit (String unit) {
		this.unit = unit;
	}
	/**
	 * 品质描述 : QUALITY_DESC
	 * 
	 * @return 
	 */
	public String getQualityDesc () {
		return qualityDesc;
	}
	
	/**
	 * 品质描述 : QUALITY_DESC
	 * 
	 * @return 
	 */
	public void setQualityDesc (String qualityDesc) {
		this.qualityDesc = qualityDesc;
	}
	/**
	 * 外观描述 : SHOW_DESC
	 * 
	 * @return 
	 */
	public String getShowDesc () {
		return showDesc;
	}
	
	/**
	 * 外观描述 : SHOW_DESC
	 * 
	 * @return 
	 */
	public void setShowDesc (String showDesc) {
		this.showDesc = showDesc;
	}
	/**
	 * 产品等级 : PRODUCT_GRADE
	 * 
	 * @return 
	 */
	public String getProductGrade () {
		return productGrade;
	}
	
	/**
	 * 产品等级 : PRODUCT_GRADE
	 * 
	 * @return 
	 */
	public void setProductGrade (String productGrade) {
		this.productGrade = productGrade;
	}
	/**
	 * 进仓日期(YYYYMMDD) : STORE_DATE
	 * 
	 * @return 
	 */
	public String getStoreDate () {
		return storeDate;
	}
	
	/**
	 * 进仓日期(YYYYMMDD) : STORE_DATE
	 * 
	 * @return 
	 */
	public void setStoreDate (String storeDate) {
		this.storeDate = storeDate;
	}

	/**
	 * 计量方式 : CHECK_TYPE
	 * 
	 * @return 
	 */
	public String getCheckType () {
		return checkType;
	}
	
	/**
	 * 计量方式 : CHECK_TYPE
	 * 
	 * @return 
	 */
	public void setCheckType (String checkType) {
		this.checkType = checkType;
	}
	/**
	 * 包装方式 : PACK_TYPE_NAME
	 * 
	 * @return 
	 */
	public String getPackTypeName () {
		return packTypeName;
	}
	
	/**
	 * 包装方式 : PACK_TYPE_NAME
	 * 
	 * @return 
	 */
	public void setPackTypeName (String packTypeName) {
		this.packTypeName = packTypeName;
	}
	/**
	 * 危险品等级 : DANGEROUS_LEVEL
	 * 
	 * @return 
	 */
	public String getDangerousLevel () {
		return dangerousLevel;
	}
	
	/**
	 * 危险品等级 : DANGEROUS_LEVEL
	 * 
	 * @return 
	 */
	public void setDangerousLevel (String dangerousLevel) {
		this.dangerousLevel = dangerousLevel;
	}
	/**
	 * 公示平台仓单号 : WARRANTY_NO
	 * 
	 * @return 
	 */
	public String getWarrantyNo () {
		return warrantyNo;
	}
	
	/**
	 * 公示平台仓单号 : WARRANTY_NO
	 * 
	 * @return 
	 */
	public void setWarrantyNo (String warrantyNo) {
		this.warrantyNo = warrantyNo;
	}

	public String getExpandDesc() {
		return expandDesc;
	}

	public void setExpandDesc(String expandDesc) {
		this.expandDesc = expandDesc;
	}

	public String getQcSheetNo() {
		return qcSheetNo;
	}

	public void setQcSheetNo(String qcSheetNo) {
		this.qcSheetNo = qcSheetNo;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	
}
