package com.ouyeelf.ftz.model.model.warranty;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;

public class WarrantyGood {
	private String id;
	private String goodId;//货物唯一标识
	private String prdVarietyName;//品种名称
	private String prdVarietyCode;//品种代码
	private String typeName;//品名描述
	private String specDesc;//规格描述
	private String packNum;//捆包号
	private String resurceNum;//资源号
	private String area;//仓库库区描述
	private String location;//仓库库位描述
	private String areaP;//产地
	private String grade;//材质
	private BigDecimal weight;//重量
	private String weightUnit; //重量单位
	private int sheetNum;//数量
	private String unit;//数量单位
	private String qualityDesc;//品质描述
	private String showDesc;//外观描述
	private String productGrade;//产品等级
	private String storeDate;//进仓日期
	private String checkType;//计量方式
	private String packTypeName;//包装方式
	private String dangerousLevel;//危险品等级
    //:扩展描述
	private String expandDesc;
	
    //:质检编号
	private String qcSheetNo;
	
	private String prdCataName;
	private String prdCataCode;
	private int seq;
	private BigDecimal unitPrice;//单价
	private BigDecimal totalPrice;//总价
//	private String ctmDeclarationNo;//海关报关编号
	private List<WarrantyGoodsExtSpec> warrantyGoodsExtSpec;
	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getSpecDesc() {
		return specDesc;
	}
	public void setSpecDesc(String specDesc) {
		this.specDesc = specDesc;
	}
	public String getPackNum() {
		return packNum;
	}
	public void setPackNum(String packNum) {
		this.packNum = packNum;
	}
	public String getResurceNum() {
		return resurceNum;
	}
	public void setResurceNum(String resurceNum) {
		this.resurceNum = resurceNum;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAreaP() {
		return areaP;
	}
	public void setAreaP(String areaP) {
		this.areaP = areaP;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getQualityDesc() {
		return qualityDesc;
	}
	public void setQualityDesc(String qualityDesc) {
		this.qualityDesc = qualityDesc;
	}
	public String getShowDesc() {
		return showDesc;
	}
	public void setShowDesc(String showDesc) {
		this.showDesc = showDesc;
	}
	public String getProductGrade() {
		return productGrade;
	}
	public void setProductGrade(String productGrade) {
		this.productGrade = productGrade;
	}
	public String getStoreDate() {
		return storeDate;
	}
	public void setStoreDate(String storeDate) {
		this.storeDate = storeDate;
	}
	public String getCheckType() {
		return checkType;
	}
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
	public String getPackTypeName() {
		return packTypeName;
	}
	public void setPackTypeName(String packTypeName) {
		this.packTypeName = packTypeName;
	}
	public String getDangerousLevel() {
		return dangerousLevel;
	}
	public void setDangerousLevel(String dangerousLevel) {
		this.dangerousLevel = dangerousLevel;
	}
	public String getPrdCataName() {
		return prdCataName;
	}
	public void setPrdCataName(String prdCataName) {
		this.prdCataName = prdCataName;
		setPrdVarietyName(prdCataName);
	}
	public String getPrdCataCode() {
		return prdCataCode;
	}
	public void setPrdCataCode(String prdCataCode) {
		this.prdCataCode = prdCataCode;
		setPrdVarietyCode(prdCataCode);
	}
	public String getPrdVarietyName() {
		return prdVarietyName;
	}
	public void setPrdVarietyName(String prdVarietyName) {
		this.prdVarietyName = prdVarietyName;
	}
	public String getPrdVarietyCode() {
		return prdVarietyCode;
	}
	public void setPrdVarietyCode(String prdVarietyCode) {
		this.prdVarietyCode = prdVarietyCode;
	}
	public String getWeightUnit() {
		return weightUnit;
	}
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<WarrantyGoodsExtSpec> getWarrantyGoodsExtSpec() {
		return warrantyGoodsExtSpec;
	}
	public void setWarrantyGoodsExtSpec(
			List<WarrantyGoodsExtSpec> warrantyGoodsExtSpec) {
		this.warrantyGoodsExtSpec = warrantyGoodsExtSpec;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public int getSheetNum() {
		return sheetNum;
	}
	public void setSheetNum(int sheetNum) {
		this.sheetNum = sheetNum;
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
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
		this.sheetNum = seq;
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
/*	public String getCtmDeclarationNo() {
		return ctmDeclarationNo;
	}
	public void setCtmDeclarationNo(String ctmDeclarationNo) {
		this.ctmDeclarationNo = ctmDeclarationNo;
	}*/
	
}
