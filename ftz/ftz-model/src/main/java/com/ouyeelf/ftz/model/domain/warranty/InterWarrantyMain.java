package com.ouyeelf.ftz.model.domain.warranty;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 接口表-仓单主表: INTER_WARRANTY_MAIN
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="INTER_WARRANTY_MAIN")
public class InterWarrantyMain  extends BSBaseDomain{
	// : ID 		
				@Id
				@Column(name="ID")
	private String id; 
	
	//业务系统别（交易平台代码） : ORG_SYS_NO 		
					@Column(name="ORG_SYS_NO")
	private String orgSysNo; 
	
	//业务单据号 : ORG_BILL_NO 		
					@Column(name="ORG_BILL_NO")
	private String orgBillNo; 
	
	//仓单类型(实物/保证金/保函/提单/海运提单) : WARRANTY_TYPE 		
					@Column(name="WARRANTY_TYPE")
	private String warrantyType; 
	
	//货主代码 : CUST_CODE 		
					@Column(name="CUST_CODE")
	private String custCode; 
	
	//货主名称 : CUST_NAME 		
					@Column(name="CUST_NAME")
	private String custName; 
	
	//货主税号 : CUST_TAX_NUM 		
					@Column(name="CUST_TAX_NUM")
	private String custTaxNum; 
	
	//货主地址 : CUST_ADD 		
					@Column(name="CUST_ADD")
	private String custAdd; 
	
	//仓库代码 : WAREHOUSE_NUM 		
					@Column(name="WAREHOUSE_NUM")
	private String warehouseNum; 
	
	//仓库名称 : WAREHOUSE_NAME 		
					@Column(name="WAREHOUSE_NAME")
	private String warehouseName; 
	
	//仓库地址 : WAREHOUSE_ADD 		
					@Column(name="WAREHOUSE_ADD")
	private String warehouseAdd; 
	
	//总数量 : NUM 		
					@Column(name="NUM")
	private Integer num; 
	
	//数量单位 : UNIT 		
					@Column(name="UNIT")
	private String unit; 
	
	//总重量 : WEIGHT 		
					@Column(name="WEIGHT")
	private java.math.BigDecimal weight; 
	
	//单据创建时间(YYYY-MM-DD) : BILL_CREATE_TIME 		
					@Column(name="BILL_CREATE_TIME")
	private String billCreateTime; 
	
	//完税标志(1-完税; 0-未税) : TAXED_FLAG 		
					@Column(name="TAXED_FLAG")
	private String taxedFlag; 
	
	//保证金比例(仓单类型为保证金时) : DEPOSIT_RATIO 		
					@Column(name="DEPOSIT_RATIO")
	private Integer depositRatio; 
	
	//保证金存管方(仓单类型为保证金时) : DEPOSIT_MANAGER 		
					@Column(name="DEPOSIT_MANAGER")
	private String depositManager; 
	//重量单位
	@Column(name="WEIGHT_UNIT")
	public String weightUnit;
	//TOTAL_PRICE
					@Column(name="TOTAL_PRICE")
    private BigDecimal totalPrice;//总价					
					
					
	
	//预留字段名1 : EXT_KEY_1 		
					@Column(name="EXT_KEY_1")
	private String extKey1; 
	
	//预留字段值1 : EXT_VAL_1 		
					@Column(name="EXT_VAL_1")
	private String extVal1; 
	
	//预留字段名2 : EXT_KEY_2 		
					@Column(name="EXT_KEY_2")
	private String extKey2; 
	
	//预留字段值2 : EXT_VAL_2 		
					@Column(name="EXT_VAL_2")
	private String extVal2; 
	
	//预留字段名3 : EXT_KEY_3 		
					@Column(name="EXT_KEY_3")
	private String extKey3; 
	
	//预留字段值3 : EXT_VAL_3 		
					@Column(name="EXT_VAL_3")
	private String extVal3; 
	
	//预留字段名4 : EXT_KEY_4 		
					@Column(name="EXT_KEY_4")
	private String extKey4; 
	
	//预留字段值4 : EXT_VAL_4 		
					@Column(name="EXT_VAL_4")
	private String extVal4; 
	
	//预留字段名5 : EXT_KEY_5 		
					@Column(name="EXT_KEY_5")
	private String extKey5; 
	
	//预留字段值5 : EXT_VAL_5 		
					@Column(name="EXT_VAL_5")
	private String extVal5; 
	
	//预留字段名6 : EXT_KEY_6 		
					@Column(name="EXT_KEY_6")
	private String extKey6; 
	
	//预留字段值6 : EXT_VAL_6 		
					@Column(name="EXT_VAL_6")
	private String extVal6; 
	
	//预留字段名7 : EXT_KEY_7 		
					@Column(name="EXT_KEY_7")
	private String extKey7; 
	
	//预留字段值7 : EXT_VAL_7 		
					@Column(name="EXT_VAL_7")
	private String extVal7; 
	
	//预留字段名8 : EXT_KEY_8 		
					@Column(name="EXT_KEY_8")
	private String extKey8; 
	
	//预留字段值8 : EXT_VAL_8 		
					@Column(name="EXT_VAL_8")
	private String extVal8; 
	
	//预留字段名9 : EXT_KEY_9 		
					@Column(name="EXT_KEY_9")
	private String extKey9; 
	
	//预留字段值9 : EXT_VAL_9 		
					@Column(name="EXT_VAL_9")
	private String extVal9; 
	
	//预留字段名10 : EXT_KEY_10 		
					@Column(name="EXT_KEY_10")
	private String extKey10; 
	
	//预留字段值10 : EXT_VAL_10 		
					@Column(name="EXT_VAL_10")
	private String extVal10; 
	
	//登记时间 : REGISTER_TIME 		
					@Column(name="REGISTER_TIME")
	private java.util.Date registerTime; 
	
	//仓库系统仓单号 : WHS_WARRANTY_NO 		
					@Column(name="WHS_WARRANTY_NO")
	private String whsWarrantyNo; 
	
	//海关商品编号 : CTM_PRD_CODE 		
					@Column(name="CTM_PRD_CODE")
	private String ctmPrdCode; 
	
	//公示平台仓单号 : WARRANTY_NO 		
					@Column(name="WARRANTY_NO")
	private String warrantyNo; 
	
	//品类名称 : PRD_CATA_NAME 		
					@Column(name="PRD_CATA_NAME")
	private String prdCataName; 
	
	//品类代码 : PRD_CATA_CODE 		
					@Column(name="PRD_CATA_CODE")
	private String prdCataCode; 
	

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
	 * 业务系统别（交易平台代码） : ORG_SYS_NO
	 * 
	 * @return 
	 */
	public String getOrgSysNo () {
		return orgSysNo;
	}
	
	/**
	 * 业务系统别（交易平台代码） : ORG_SYS_NO
	 * 
	 * @return 
	 */
	public void setOrgSysNo (String orgSysNo) {
		this.orgSysNo = orgSysNo;
	}
	/**
	 * 业务单据号 : ORG_BILL_NO
	 * 
	 * @return 
	 */
	public String getOrgBillNo () {
		return orgBillNo;
	}
	
	/**
	 * 业务单据号 : ORG_BILL_NO
	 * 
	 * @return 
	 */
	public void setOrgBillNo (String orgBillNo) {
		this.orgBillNo = orgBillNo;
	}
	/**
	 * 仓单类型(实物/保证金/保函/提单/海运提单) : WARRANTY_TYPE
	 * 
	 * @return 
	 */
	public String getWarrantyType () {
		return warrantyType;
	}
	
	/**
	 * 仓单类型(实物/保证金/保函/提单/海运提单) : WARRANTY_TYPE
	 * 
	 * @return 
	 */
	public void setWarrantyType (String warrantyType) {
		this.warrantyType = warrantyType;
	}
	/**
	 * 货主代码 : CUST_CODE
	 * 
	 * @return 
	 */
	public String getCustCode () {
		return custCode;
	}
	
	/**
	 * 货主代码 : CUST_CODE
	 * 
	 * @return 
	 */
	public void setCustCode (String custCode) {
		this.custCode = custCode;
	}
	/**
	 * 货主名称 : CUST_NAME
	 * 
	 * @return 
	 */
	public String getCustName () {
		return custName;
	}
	
	/**
	 * 货主名称 : CUST_NAME
	 * 
	 * @return 
	 */
	public void setCustName (String custName) {
		this.custName = custName;
	}
	/**
	 * 货主税号 : CUST_TAX_NUM
	 * 
	 * @return 
	 */
	public String getCustTaxNum () {
		return custTaxNum;
	}
	
	/**
	 * 货主税号 : CUST_TAX_NUM
	 * 
	 * @return 
	 */
	public void setCustTaxNum (String custTaxNum) {
		this.custTaxNum = custTaxNum;
	}
	/**
	 * 货主地址 : CUST_ADD
	 * 
	 * @return 
	 */
	public String getCustAdd () {
		return custAdd;
	}
	
	/**
	 * 货主地址 : CUST_ADD
	 * 
	 * @return 
	 */
	public void setCustAdd (String custAdd) {
		this.custAdd = custAdd;
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
	 * 仓库地址 : WAREHOUSE_ADD
	 * 
	 * @return 
	 */
	public String getWarehouseAdd () {
		return warehouseAdd;
	}
	
	/**
	 * 仓库地址 : WAREHOUSE_ADD
	 * 
	 * @return 
	 */
	public void setWarehouseAdd (String warehouseAdd) {
		this.warehouseAdd = warehouseAdd;
	}
	/**
	 * 总数量 : NUM
	 * 
	 * @return 
	 */
	public Integer getNum () {
		return num;
	}
	
	/**
	 * 总数量 : NUM
	 * 
	 * @return 
	 */
	public void setNum (Integer num) {
		this.num = num;
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
	 * 总重量 : WEIGHT
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getWeight () {
		return weight;
	}
	
	/**
	 * 总重量 : WEIGHT
	 * 
	 * @return 
	 */
	public void setWeight (java.math.BigDecimal weight) {
		this.weight = weight;
	}
	/**
	 * 单据创建时间(YYYY-MM-DD) : BILL_CREATE_TIME
	 * 
	 * @return 
	 */
	public String getBillCreateTime () {
		return billCreateTime;
	}
	
	/**
	 * 单据创建时间(YYYY-MM-DD) : BILL_CREATE_TIME
	 * 
	 * @return 
	 */
	public void setBillCreateTime (String billCreateTime) {
		this.billCreateTime = billCreateTime;
	}
	/**
	 * 完税标志(1-完税; 0-未税) : TAXED_FLAG
	 * 
	 * @return 
	 */
	public String getTaxedFlag () {
		return taxedFlag;
	}
	
	/**
	 * 完税标志(1-完税; 0-未税) : TAXED_FLAG
	 * 
	 * @return 
	 */
	public void setTaxedFlag (String taxedFlag) {
		this.taxedFlag = taxedFlag;
	}
	/**
	 * 保证金比例(仓单类型为保证金时) : DEPOSIT_RATIO
	 * 
	 * @return 
	 */
	public Integer getDepositRatio () {
		return depositRatio;
	}
	
	/**
	 * 保证金比例(仓单类型为保证金时) : DEPOSIT_RATIO
	 * 
	 * @return 
	 */
	public void setDepositRatio (Integer depositRatio) {
		this.depositRatio = depositRatio;
	}
	/**
	 * 保证金存管方(仓单类型为保证金时) : DEPOSIT_MANAGER
	 * 
	 * @return 
	 */
	public String getDepositManager () {
		return depositManager;
	}
	
	/**
	 * 保证金存管方(仓单类型为保证金时) : DEPOSIT_MANAGER
	 * 
	 * @return 
	 */
	public void setDepositManager (String depositManager) {
		this.depositManager = depositManager;
	}
	/**
	 * 预留字段名1 : EXT_KEY_1
	 * 
	 * @return 
	 */
	public String getExtKey1 () {
		return extKey1;
	}
	
	/**
	 * 预留字段名1 : EXT_KEY_1
	 * 
	 * @return 
	 */
	public void setExtKey1 (String extKey1) {
		this.extKey1 = extKey1;
	}
	/**
	 * 预留字段值1 : EXT_VAL_1
	 * 
	 * @return 
	 */
	public String getExtVal1 () {
		return extVal1;
	}
	
	/**
	 * 预留字段值1 : EXT_VAL_1
	 * 
	 * @return 
	 */
	public void setExtVal1 (String extVal1) {
		this.extVal1 = extVal1;
	}
	/**
	 * 预留字段名2 : EXT_KEY_2
	 * 
	 * @return 
	 */
	public String getExtKey2 () {
		return extKey2;
	}
	
	/**
	 * 预留字段名2 : EXT_KEY_2
	 * 
	 * @return 
	 */
	public void setExtKey2 (String extKey2) {
		this.extKey2 = extKey2;
	}
	/**
	 * 预留字段值2 : EXT_VAL_2
	 * 
	 * @return 
	 */
	public String getExtVal2 () {
		return extVal2;
	}
	
	/**
	 * 预留字段值2 : EXT_VAL_2
	 * 
	 * @return 
	 */
	public void setExtVal2 (String extVal2) {
		this.extVal2 = extVal2;
	}
	/**
	 * 预留字段名3 : EXT_KEY_3
	 * 
	 * @return 
	 */
	public String getExtKey3 () {
		return extKey3;
	}
	
	/**
	 * 预留字段名3 : EXT_KEY_3
	 * 
	 * @return 
	 */
	public void setExtKey3 (String extKey3) {
		this.extKey3 = extKey3;
	}
	/**
	 * 预留字段值3 : EXT_VAL_3
	 * 
	 * @return 
	 */
	public String getExtVal3 () {
		return extVal3;
	}
	
	/**
	 * 预留字段值3 : EXT_VAL_3
	 * 
	 * @return 
	 */
	public void setExtVal3 (String extVal3) {
		this.extVal3 = extVal3;
	}
	/**
	 * 预留字段名4 : EXT_KEY_4
	 * 
	 * @return 
	 */
	public String getExtKey4 () {
		return extKey4;
	}
	
	/**
	 * 预留字段名4 : EXT_KEY_4
	 * 
	 * @return 
	 */
	public void setExtKey4 (String extKey4) {
		this.extKey4 = extKey4;
	}
	/**
	 * 预留字段值4 : EXT_VAL_4
	 * 
	 * @return 
	 */
	public String getExtVal4 () {
		return extVal4;
	}
	
	/**
	 * 预留字段值4 : EXT_VAL_4
	 * 
	 * @return 
	 */
	public void setExtVal4 (String extVal4) {
		this.extVal4 = extVal4;
	}
	/**
	 * 预留字段名5 : EXT_KEY_5
	 * 
	 * @return 
	 */
	public String getExtKey5 () {
		return extKey5;
	}
	
	/**
	 * 预留字段名5 : EXT_KEY_5
	 * 
	 * @return 
	 */
	public void setExtKey5 (String extKey5) {
		this.extKey5 = extKey5;
	}
	/**
	 * 预留字段值5 : EXT_VAL_5
	 * 
	 * @return 
	 */
	public String getExtVal5 () {
		return extVal5;
	}
	
	/**
	 * 预留字段值5 : EXT_VAL_5
	 * 
	 * @return 
	 */
	public void setExtVal5 (String extVal5) {
		this.extVal5 = extVal5;
	}
	/**
	 * 预留字段名6 : EXT_KEY_6
	 * 
	 * @return 
	 */
	public String getExtKey6 () {
		return extKey6;
	}
	
	/**
	 * 预留字段名6 : EXT_KEY_6
	 * 
	 * @return 
	 */
	public void setExtKey6 (String extKey6) {
		this.extKey6 = extKey6;
	}
	/**
	 * 预留字段值6 : EXT_VAL_6
	 * 
	 * @return 
	 */
	public String getExtVal6 () {
		return extVal6;
	}
	
	/**
	 * 预留字段值6 : EXT_VAL_6
	 * 
	 * @return 
	 */
	public void setExtVal6 (String extVal6) {
		this.extVal6 = extVal6;
	}
	/**
	 * 预留字段名7 : EXT_KEY_7
	 * 
	 * @return 
	 */
	public String getExtKey7 () {
		return extKey7;
	}
	
	/**
	 * 预留字段名7 : EXT_KEY_7
	 * 
	 * @return 
	 */
	public void setExtKey7 (String extKey7) {
		this.extKey7 = extKey7;
	}
	/**
	 * 预留字段值7 : EXT_VAL_7
	 * 
	 * @return 
	 */
	public String getExtVal7 () {
		return extVal7;
	}
	
	/**
	 * 预留字段值7 : EXT_VAL_7
	 * 
	 * @return 
	 */
	public void setExtVal7 (String extVal7) {
		this.extVal7 = extVal7;
	}
	/**
	 * 预留字段名8 : EXT_KEY_8
	 * 
	 * @return 
	 */
	public String getExtKey8 () {
		return extKey8;
	}
	
	/**
	 * 预留字段名8 : EXT_KEY_8
	 * 
	 * @return 
	 */
	public void setExtKey8 (String extKey8) {
		this.extKey8 = extKey8;
	}
	/**
	 * 预留字段值8 : EXT_VAL_8
	 * 
	 * @return 
	 */
	public String getExtVal8 () {
		return extVal8;
	}
	
	/**
	 * 预留字段值8 : EXT_VAL_8
	 * 
	 * @return 
	 */
	public void setExtVal8 (String extVal8) {
		this.extVal8 = extVal8;
	}
	/**
	 * 预留字段名9 : EXT_KEY_9
	 * 
	 * @return 
	 */
	public String getExtKey9 () {
		return extKey9;
	}
	
	/**
	 * 预留字段名9 : EXT_KEY_9
	 * 
	 * @return 
	 */
	public void setExtKey9 (String extKey9) {
		this.extKey9 = extKey9;
	}
	/**
	 * 预留字段值9 : EXT_VAL_9
	 * 
	 * @return 
	 */
	public String getExtVal9 () {
		return extVal9;
	}
	
	/**
	 * 预留字段值9 : EXT_VAL_9
	 * 
	 * @return 
	 */
	public void setExtVal9 (String extVal9) {
		this.extVal9 = extVal9;
	}
	/**
	 * 预留字段名10 : EXT_KEY_10
	 * 
	 * @return 
	 */
	public String getExtKey10 () {
		return extKey10;
	}
	
	/**
	 * 预留字段名10 : EXT_KEY_10
	 * 
	 * @return 
	 */
	public void setExtKey10 (String extKey10) {
		this.extKey10 = extKey10;
	}
	/**
	 * 预留字段值10 : EXT_VAL_10
	 * 
	 * @return 
	 */
	public String getExtVal10 () {
		return extVal10;
	}
	
	/**
	 * 预留字段值10 : EXT_VAL_10
	 * 
	 * @return 
	 */
	public void setExtVal10 (String extVal10) {
		this.extVal10 = extVal10;
	}
	/**
	 * 登记时间 : REGISTER_TIME
	 * 
	 * @return 
	 */
	public java.util.Date getRegisterTime () {
		return registerTime;
	}
	
	/**
	 * 登记时间 : REGISTER_TIME
	 * 
	 * @return 
	 */
	public void setRegisterTime (java.util.Date registerTime) {
		this.registerTime = registerTime;
	}
	/**
	 * 仓库系统仓单号 : WHS_WARRANTY_NO
	 * 
	 * @return 
	 */
	public String getWhsWarrantyNo () {
		return whsWarrantyNo;
	}
	
	/**
	 * 仓库系统仓单号 : WHS_WARRANTY_NO
	 * 
	 * @return 
	 */
	public void setWhsWarrantyNo (String whsWarrantyNo) {
		this.whsWarrantyNo = whsWarrantyNo;
	}
	/**
	 * 海关商品编号 : CTM_PRD_CODE
	 * 
	 * @return 
	 */
	public String getCtmPrdCode () {
		return ctmPrdCode;
	}
	
	/**
	 * 海关商品编号 : CTM_PRD_CODE
	 * 
	 * @return 
	 */
	public void setCtmPrdCode (String ctmPrdCode) {
		this.ctmPrdCode = ctmPrdCode;
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
	/**
	 * 品类名称 : PRD_CATA_NAME
	 * 
	 * @return 
	 */
	public String getPrdCataName () {
		return prdCataName;
	}
	
	/**
	 * 品类名称 : PRD_CATA_NAME
	 * 
	 * @return 
	 */
	public void setPrdCataName (String prdCataName) {
		this.prdCataName = prdCataName;
	}
	/**
	 * 品类代码 : PRD_CATA_CODE
	 * 
	 * @return 
	 */
	public String getPrdCataCode () {
		return prdCataCode;
	}
	
	/**
	 * 品类代码 : PRD_CATA_CODE
	 * 
	 * @return 
	 */
	public void setPrdCataCode (String prdCataCode) {
		this.prdCataCode = prdCataCode;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

}
