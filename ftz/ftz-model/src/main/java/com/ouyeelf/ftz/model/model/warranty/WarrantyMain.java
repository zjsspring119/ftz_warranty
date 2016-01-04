package com.ouyeelf.ftz.model.model.warranty;

import java.math.BigDecimal;

public class WarrantyMain {
	
	private String trdSysNo;//交易平台代码
	private String trdWarrantyNo;//交易平台注册仓单号
	private String whsWarrantyNo;//仓库系统仓单号
	private String warrantyType;//仓单类型
	private String custCode;//平台货主代码
	private String custName;//货主名称
	private String custTaxNum;//货主税号
	private String custAdd; //货主地址
	private String custEnName; //货主英文名称
	private String warehouseNum; //仓库代码
	private String warehouseName; //仓库名称
	private String warehouseEName;//仓库英文简称
	private String warehouseAdd; //仓库地址
	private String prdCataName; //品类名称
	private String prdCataCode; //交易品类代码
	private String ctmPrdCode; //海关商品编号
	private String warrantyNo; //公示平台仓单号
	private int num; //总数量
	private String unit; //数量单位
	private BigDecimal weight;//重量
	private String billCreateTime; //单据创建时间
	private String taxedFlag; //完税标志（1-完税; 0-未税）
	private int depositRatio; //保证金比例
	private String depositManager; //保证金存管方
	//重量单位
	public String weightUnit;
	//TOTAL_PRICE
    private BigDecimal totalPrice;//总价					
	
	
	//预留字段名1 : EXT_KEY_1 		
	private String extKey1; 
	//预留字段值1 : EXT_VAL_1 		
	private String extVal1; 
	//预留字段名2 : EXT_KEY_2 		
	private String extKey2; 
	//预留字段值2 : EXT_VAL_2 		
	private String extVal2; 
	//预留字段名3 : EXT_KEY_3 		
	private String extKey3; 
	//预留字段值3 : EXT_VAL_3 		
	private String extVal3; 
	//预留字段名4 : EXT_KEY_4 		
	private String extKey4; 
	//预留字段值4 : EXT_VAL_4 		
	private String extVal4; 
	//预留字段名5 : EXT_KEY_5 		
	private String extKey5; 
	//预留字段值5 : EXT_VAL_5 		
	private String extVal5; 
	//预留字段名6 : EXT_KEY_6 		
	private String extKey6; 
	//预留字段值6 : EXT_VAL_6 		
	private String extVal6; 
	//预留字段名7 : EXT_KEY_7 		
	private String extKey7; 
	//预留字段值7 : EXT_VAL_7 		
	private String extVal7; 
	//预留字段名8 : EXT_KEY_8 		
	private String extKey8; 
	//预留字段值8 : EXT_VAL_8 		
	private String extVal8; 
	//预留字段名9 : EXT_KEY_9 		
	private String extKey9; 
	//预留字段值9 : EXT_VAL_9 		
	private String extVal9; 
	//预留字段名10 : EXT_KEY_10 		
	private String extKey10; 
	//预留字段值10 : EXT_VAL_10 		
	private String extVal10; 

	public String getWarrantyType() {
		return warrantyType;
	}
	public void setWarrantyType(String warrantyType) {
		this.warrantyType = warrantyType;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAdd() {
		return custAdd;
	}
	public void setCustAdd(String custAdd) {
		this.custAdd = custAdd;
	}
	public String getWarehouseNum() {
		return warehouseNum;
	}
	public void setWarehouseNum(String warehouseNum) {
		this.warehouseNum = warehouseNum;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getWarehouseAdd() {
		return warehouseAdd;
	}
	public void setWarehouseAdd(String warehouseAdd) {
		this.warehouseAdd = warehouseAdd;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getBillCreateTime() {
		return billCreateTime;
	}
	public void setBillCreateTime(String billCreateTime) {
		this.billCreateTime = billCreateTime;
	}
	public String getTaxedFlag() {
		return taxedFlag;
	}
	public void setTaxedFlag(String taxedFlag) {
		this.taxedFlag = taxedFlag;
	}
	public String getDepositManager() {
		return depositManager;
	}
	public void setDepositManager(String depositManager) {
		this.depositManager = depositManager;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public String getTrdSysNo() {
		return trdSysNo;
	}
	public void setTrdSysNo(String trdSysNo) {
		this.trdSysNo = trdSysNo;
	}
	public String getTrdWarrantyNo() {
		return trdWarrantyNo;
	}
	public void setTrdWarrantyNo(String trdWarrantyNo) {
		this.trdWarrantyNo = trdWarrantyNo;
	}
	public String getWhsWarrantyNo() {
		return whsWarrantyNo;
	}
	public void setWhsWarrantyNo(String whsWarrantyNo) {
		this.whsWarrantyNo = whsWarrantyNo;
	}
	public String getPrdCataName() {
		return prdCataName;
	}
	public void setPrdCataName(String prdCataName) {
		this.prdCataName = prdCataName;
	}
	public String getPrdCataCode() {
		return prdCataCode;
	}
	public void setPrdCataCode(String prdCataCode) {
		this.prdCataCode = prdCataCode;
	}
	public String getExtKey1() {
		return extKey1;
	}
	public void setExtKey1(String extKey1) {
		this.extKey1 = extKey1;
	}
	public String getExtVal1() {
		return extVal1;
	}
	public void setExtVal1(String extVal1) {
		this.extVal1 = extVal1;
	}
	public String getExtKey2() {
		return extKey2;
	}
	public void setExtKey2(String extKey2) {
		this.extKey2 = extKey2;
	}
	public String getExtVal2() {
		return extVal2;
	}
	public void setExtVal2(String extVal2) {
		this.extVal2 = extVal2;
	}
	public String getExtKey3() {
		return extKey3;
	}
	public void setExtKey3(String extKey3) {
		this.extKey3 = extKey3;
	}
	public String getExtVal3() {
		return extVal3;
	}
	public void setExtVal3(String extVal3) {
		this.extVal3 = extVal3;
	}
	public String getExtKey4() {
		return extKey4;
	}
	public void setExtKey4(String extKey4) {
		this.extKey4 = extKey4;
	}
	public String getExtVal4() {
		return extVal4;
	}
	public void setExtVal4(String extVal4) {
		this.extVal4 = extVal4;
	}
	public String getExtKey5() {
		return extKey5;
	}
	public void setExtKey5(String extKey5) {
		this.extKey5 = extKey5;
	}
	public String getExtVal5() {
		return extVal5;
	}
	public void setExtVal5(String extVal5) {
		this.extVal5 = extVal5;
	}
	public String getExtKey6() {
		return extKey6;
	}
	public void setExtKey6(String extKey6) {
		this.extKey6 = extKey6;
	}
	public String getExtVal6() {
		return extVal6;
	}
	public void setExtVal6(String extVal6) {
		this.extVal6 = extVal6;
	}
	public String getExtKey7() {
		return extKey7;
	}
	public void setExtKey7(String extKey7) {
		this.extKey7 = extKey7;
	}
	public String getExtVal7() {
		return extVal7;
	}
	public void setExtVal7(String extVal7) {
		this.extVal7 = extVal7;
	}
	public String getExtKey8() {
		return extKey8;
	}
	public void setExtKey8(String extKey8) {
		this.extKey8 = extKey8;
	}
	public String getExtVal8() {
		return extVal8;
	}
	public void setExtVal8(String extVal8) {
		this.extVal8 = extVal8;
	}
	public String getExtKey9() {
		return extKey9;
	}
	public void setExtKey9(String extKey9) {
		this.extKey9 = extKey9;
	}
	public String getExtVal9() {
		return extVal9;
	}
	public void setExtVal9(String extVal9) {
		this.extVal9 = extVal9;
	}
	public String getExtKey10() {
		return extKey10;
	}
	public void setExtKey10(String extKey10) {
		this.extKey10 = extKey10;
	}
	public String getExtVal10() {
		return extVal10;
	}
	public void setExtVal10(String extVal10) {
		this.extVal10 = extVal10;
	}
	public String getCtmPrdCode() {
		return ctmPrdCode;
	}
	public void setCtmPrdCode(String ctmPrdCode) {
		this.ctmPrdCode = ctmPrdCode;
	}
	public String getWarrantyNo() {
		return warrantyNo;
	}
	public void setWarrantyNo(String warrantyNo) {
		this.warrantyNo = warrantyNo;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDepositRatio() {
		return depositRatio;
	}
	public void setDepositRatio(int depositRatio) {
		this.depositRatio = depositRatio;
	}
	public String getCustTaxNum() {
		return custTaxNum;
	}
	public void setCustTaxNum(String custTaxNum) {
		this.custTaxNum = custTaxNum;
	}
	public String getCustEnName() {
		return custEnName;
	}
	public void setCustEnName(String custEnName) {
		this.custEnName = custEnName;
	}
	public String getWarehouseEName() {
		return warehouseEName;
	}
	public void setWarehouseEName(String warehouseEName) {
		this.warehouseEName = warehouseEName;
	}
	public String getWeightUnit() {
		return weightUnit;
	}
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	
}
