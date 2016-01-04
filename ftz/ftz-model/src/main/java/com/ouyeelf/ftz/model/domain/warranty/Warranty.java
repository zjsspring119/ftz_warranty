package com.ouyeelf.ftz.model.domain.warranty;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 仓单信息表: RZ_WARRANTY
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name = "RZ_WARRANTY")
public class Warranty extends BSBaseDomain {
	// 仓单号 : WARRANTY_NO
	@Id
	@Column(name = "WARRANTY_NO")
	private String warrantyNo;

	// 客户代码 : CUSTOMER_CODE
	@Column(name = "CUSTOMER_CODE")
	private String customerCode;

	// 客户名称 : CUSTOMER_NAME
	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	// 保管人代码（仓库代码） : WAREHOUSE_NUM
	@Column(name = "WAREHOUSE_NUM")
	private String warehouseNum;

	// 保管人名称（仓库名称） : WAREHOUSE_NAME
	@Column(name = "WAREHOUSE_NAME")
	private String warehouseName;

	// 质权人代码（银行代码） : PLEDGEE_CODE
	@Column(name = "PLEDGEE_CODE")
	private String pledgeeCode;

	// 质权人名称（银行名称） : PLEDGEE_NAME
	@Column(name = "PLEDGEE_NAME")
	private String pledgeeName;

	// 仓单状态 : WARRANTY_STATUS
	@Column(name = "WARRANTY_STATUS")
	private String warrantyStatus;

	// 总数量 : NUM
	@Column(name = "NUM")
	private Integer num;

	// 数量单位 : UNIT
	@Column(name = "UNIT")
	private String unit;

	// 总重量 : WEIGHT
	@Column(name = "WEIGHT")
	private java.math.BigDecimal weight;

	// 总价值 : PRICE
	@Column(name = "PRICE")
	private java.math.BigDecimal price;

	// 创建时间 : CREATE_TIME
	@Column(name = "CREATE_TIME")
	private java.util.Date createTime;

	// 创建人代码 : CREATE_CODE
	@Column(name = "CREATE_CODE")
	private String createCode;

	// 创建人姓名 : CREATE_NAME
	@Column(name = "CREATE_NAME")
	private String createName;

	// 注销时间 : CANCEL_TIME
	@Column(name = "CANCEL_TIME")
	private java.util.Date cancelTime;

	// 注销人代码 : CANCEL_CODE
	@Column(name = "CANCEL_CODE")
	private String cancelCode;

	// 注销人姓名 : CANCEL_NAME
	@Column(name = "CANCEL_NAME")
	private String cancelName;

	// 融资申请号 : APPLICATION_ID
	@Column(name = "APPLICATION_ID")
	private String applicationId;

	// 物权人代码（存货人） : GOODS_OWNER_NUM
	@Column(name = "GOODS_OWNER_NUM")
	private String goodsOwnerNum;

	// 物权人名称（存货人） : GOODS_OWNER_NAME
	@Column(name = "GOODS_OWNER_NAME")
	private String goodsOwnerName;

	// 保管人地址（仓库地址） : WAREHOUSE_ADDRESS
	@Column(name = "WAREHOUSE_ADDRESS")
	private String warehouseAddress;

	// 物权人地址（存货人） : GOODS_OWNER_ADDRESS
	@Column(name = "GOODS_OWNER_ADDRESS")
	private String goodsOwnerAddress;

	// 联系人名称 : LINK_MAN_NAME
	@Column(name = "LINK_MAN_NAME")
	private String linkManName;

	// 联系人电话 : LINK_MAN_TEL
	@Column(name = "LINK_MAN_TEL")
	private String linkManTel;

	// 联系人传真 : LINK_MAN_FAX
	@Column(name = "LINK_MAN_FAX")
	private String linkManFax;

	// 有效期 : VALIDITY_TIME
	@Column(name = "VALIDITY_TIME")
	private java.util.Date validityTime;

	// 存货地址 : STOCK_ADDRESS
	@Column(name = "STOCK_ADDRESS")
	private String stockAddress;

	// 特殊养护要求 : MAINTENANCE_STAND
	@Column(name = "MAINTENANCE_STAND")
	private String maintenanceStand;

	// 损耗标准 : LOSS_STAND
	@Column(name = "LOSS_STAND")
	private String lossStand;

	// 收费标准 : CHARGE_STAND
	@Column(name = "CHARGE_STAND")
	private String chargeStand;

	// 结算方式 : SETTLE_TYPE
	@Column(name = "SETTLE_TYPE")
	private String settleType;

	// 存储卡号 : SAVE_NO
	@Column(name = "SAVE_NO")
	private String saveNo;

	// 手号 : HAND_NO
	@Column(name = "HAND_NO")
	private String handNo;

	// 预申请号 : WARRANTY_APP_NO
	@Column(name = "WARRANTY_APP_NO")
	private String warrantyAppNo;

	// 最后打印人 : PRINT_PERSON
	@Column(name = "PRINT_PERSON")
	private String printPerson;

	// 最后打印时间 : PRINT_DATE
	@Column(name = "PRINT_DATE")
	private java.util.Date printDate;

	// 打印次数 : PRINT_COUNT
	@Column(name = "PRINT_COUNT")
	private Integer printCount;

	// 仓单密码（用于验单） : VERIFY_ID
	@Column(name = "VERIFY_ID")
	private String verifyId;

	// 质量证明文件 : QUALITY_DOC
	@Column(name = "QUALITY_DOC")
	private String qualityDoc;

	// 保管合同号
	@Column(name = "WAREHOUSE_CONTRACT_NO")
	private String warehouseContractNo;

	// 负责人电话
	@Column(name = "PRINCIPAL_MAN_TEL")
	private String principalManTel;

	// 三级审批时间 : THIRD_APPROVAL_DATE
	@Column(name = "PE_APPROVAL_DATE")
	private java.util.Date peApprovalDate;

	// 解压金额
	@Column(name = "UNPACK_PRICE")
	private java.math.BigDecimal unpackPrice;

	// 市场区分标识（参见X001小代码）
	@Column(name = "MARKET_FLAG")
	private String marketFlag;

	// 仓单类型（参见X002小代码）
	@Column(name = "WARRANTY_TYPE")
	private String warrantyType;

	// 完税标志（0--未税; 1--完税）
	@Column(name = "TAXED_FLAG")
	private String taxedFlag;

	// 保证金比例
	@Column(name = "DEPOSIT_RATIO")
	private java.math.BigDecimal depositRatio;

	// 保证金存管方名称
	@Column(name = "DEPOSIT_MANAGER")
	private String depositManager;

	// 仓单注册来源（参见X003小代码）
	@Column(name = "WARRANTY_DATA_SOURCES")
	private String warrantyDataSources;
	
	// 外系统业务单据号
	@Column(name = "ORG_BILL_NO")
	private String orgBillNo;
	
	// 交易平台代码(自贸区用) : ORG_SYS_NO
	@Column(name = "ORG_SYS_NO")
	private String orgSysNo;

	// 交易平台名称(自贸区用) : ORG_SYS_NAME
	@Column(name = "ORG_SYS_NAME")
	private String orgSysName;

	// 仓库诚信标记(自贸区用，1-按量按货主，2-按实物，3-按量不按货主，见小代码X012) : WAREHOUSE_CREDIT
	@Column(name = "WAREHOUSE_CREDIT")
	private String warehouseCredit;

	// 清算诚信标记(自贸区用，1-按量按货主，2-按实物，3-按量不按货主，见小代码X012) : CLEAR_CREDIT
	@Column(name = "CLEAR_CREDIT")
	private String clearCredit;

	// 海关诚信标记(自贸区用，1-按量按货主，2-按实物，3-按量不按货主，见小代码X012) : CUSTOMS_CREDIT
	@Column(name = "CUSTOMS_CREDIT")
	private String customsCredit;

	// 是否违禁仓单（1-是、0-否） : ILLICIT_FLAG
	@Column(name = "ILLICIT_FLAG")
	private String illicitFlag;

	// 仓库系统仓单号 : WH_WARRANTY_NO
	@Column(name = "WH_WARRANTY_NO")
	private String whWarrantyNo;

	// 海关商品编号 : CTM_PRD_CODE
	@Column(name = "CTM_PRD_CODE")
	private String ctmPrdCode;

	// 交易平台英文简称 : TRD_SYS_EN
	@Column(name = "TRD_SYS_EN")
	private String trdSysEn;

	// 仓库英文简称 : WAREHOUSE_NAME_EN
	@Column(name = "WAREHOUSE_NAME_EN")
	private String warehouseNameEn;

	// 货主英文简称 : CUST_NAME_EN
	@Column(name = "CUST_NAME_EN")
	private String custNameEn;

	// 仓储诚信标记所对应的图片名 : WAREHOUSE_ICON_NAME
	@Column(name = "WAREHOUSE_ICON_NAME")
	private String warehouseIconName;

	// 清算诚信标记所对应的图片名 : CLEAR_ICON_NAME
	@Column(name = "CLEAR_ICON_NAME")
	private String clearIconName;

	// 海关诚信标记所对应的图片名 : CUSTOMS_ICON_NAME
	@Column(name = "CUSTOMS_ICON_NAME")
	private String customsIconName;

	// 是否被同步mongodb（1-已同步）：IS_SYNCHRONIZE
	@Column(name = "IS_SYNCHRONIZE")
	private String isSynchronize;

	// 单据创建时间(YYYY-MM-DD) : BILL_CREATE_TIME
	@Column(name = "BILL_CREATE_TIME")
	private String billCreateTime;

	// 异议诚信标记所对应的图片名 : DOUBT_ICON_NAME
	@Column(name = "DOUBT_ICON_NAME")
	private String doubtIconName;
	
	// 货主税号(提供给交易平台使用)
	@Column(name = "CSUT_TAX_NUM")
	private String custTaxNum;
	
	// 交易品类代码(提供给交易平台使用)
	@Column(name = "PRD_CATA_CODE")
	private String prdCataCode;
	
	// 交易品类名称(提供给交易平台使用)
	@Column(name = "PRD_CATA_NAME")
	private String prdCataName;
	
	// 交易单号（锁定时填写）
	@Column(name = "BUSSINESS_NO")
	private String bussinessNo;
	
	//交易价格（锁定时填写）
	@Column(name = "BUSSINESS_PRICE")
	private BigDecimal bussinessPrice;
	
	//成交时间(YYYY-MM-DD HH:MI:SS)
	@Column(name = "BUSSINESS_TIME")
	private String bussinessTime;
	
	//最后修改时间
	@Column(name = "UPDATE_TIME")
	private Date updateTime;

	@Column(name="TOTAL_PRICE")
    private BigDecimal totalPrice;//总价	
	
	//重量单位
	@Column(name="WEIGHT_UNIT")
	public String weightUnit;
	
	
	
	public String getWarehouseContractNo() {
		return warehouseContractNo;
	}

	public void setWarehouseContractNo(String warehouseContractNo) {
		this.warehouseContractNo = warehouseContractNo;
	}

	public String getPrincipalManTel() {
		return principalManTel;
	}

	public void setPrincipalManTel(String principalManTel) {
		this.principalManTel = principalManTel;
	}

	/**
	 * 仓单号 : WARRANTY_NO
	 * 
	 * @return
	 */
	public String getWarrantyNo() {
		return warrantyNo;
	}

	/**
	 * 仓单号 : WARRANTY_NO
	 * 
	 * @return
	 */
	public void setWarrantyNo(String warrantyNo) {
		this.warrantyNo = warrantyNo;
	}

	/**
	 * 客户代码 : CUSTOMER_CODE
	 * 
	 * @return
	 */
	public String getCustomerCode() {
		return customerCode;
	}

	/**
	 * 客户代码 : CUSTOMER_CODE
	 * 
	 * @return
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	/**
	 * 客户名称 : CUSTOMER_NAME
	 * 
	 * @return
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * 客户名称 : CUSTOMER_NAME
	 * 
	 * @return
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * 保管人代码（仓库代码） : WAREHOUSE_NUM
	 * 
	 * @return
	 */
	public String getWarehouseNum() {
		return warehouseNum;
	}

	/**
	 * 保管人代码（仓库代码） : WAREHOUSE_NUM
	 * 
	 * @return
	 */
	public void setWarehouseNum(String warehouseNum) {
		this.warehouseNum = warehouseNum;
	}

	/**
	 * 保管人名称（仓库名称） : WAREHOUSE_NAME
	 * 
	 * @return
	 */
	public String getWarehouseName() {
		return warehouseName;
	}

	/**
	 * 保管人名称（仓库名称） : WAREHOUSE_NAME
	 * 
	 * @return
	 */
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	/**
	 * 质权人代码（银行代码） : PLEDGEE_CODE
	 * 
	 * @return
	 */
	public String getPledgeeCode() {
		return pledgeeCode;
	}

	/**
	 * 质权人代码（银行代码） : PLEDGEE_CODE
	 * 
	 * @return
	 */
	public void setPledgeeCode(String pledgeeCode) {
		this.pledgeeCode = pledgeeCode;
	}

	/**
	 * 质权人名称（银行名称） : PLEDGEE_NAME
	 * 
	 * @return
	 */
	public String getPledgeeName() {
		return pledgeeName;
	}

	/**
	 * 质权人名称（银行名称） : PLEDGEE_NAME
	 * 
	 * @return
	 */
	public void setPledgeeName(String pledgeeName) {
		this.pledgeeName = pledgeeName;
	}

	/**
	 * 仓单状态 : WARRANTY_STATUS
	 * 
	 * @return
	 */
	public String getWarrantyStatus() {
		return warrantyStatus;
	}

	/**
	 * 仓单状态 : WARRANTY_STATUS
	 * 
	 * @return
	 */
	public void setWarrantyStatus(String warrantyStatus) {
		this.warrantyStatus = warrantyStatus;
	}

	/**
	 * 总数量 : NUM
	 * 
	 * @return
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * 总数量 : NUM
	 * 
	 * @return
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * 数量单位 : UNIT
	 * 
	 * @return
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * 数量单位 : UNIT
	 * 
	 * @return
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * 总重量 : WEIGHT
	 * 
	 * @return
	 */
	public java.math.BigDecimal getWeight() {
		return weight;
	}

	/**
	 * 总重量 : WEIGHT
	 * 
	 * @return
	 */
	public void setWeight(java.math.BigDecimal weight) {
		this.weight = weight;
	}

	/**
	 * 总价值 : PRICE
	 * 
	 * @return
	 */
	public java.math.BigDecimal getPrice() {
		return price;
	}

	/**
	 * 总价值 : PRICE
	 * 
	 * @return
	 */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}

	/**
	 * 创建时间 : CREATE_TIME
	 * 
	 * @return
	 */
	public java.util.Date getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间 : CREATE_TIME
	 * 
	 * @return
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 创建人代码 : CREATE_CODE
	 * 
	 * @return
	 */
	public String getCreateCode() {
		return createCode;
	}

	/**
	 * 创建人代码 : CREATE_CODE
	 * 
	 * @return
	 */
	public void setCreateCode(String createCode) {
		this.createCode = createCode;
	}

	/**
	 * 创建人姓名 : CREATE_NAME
	 * 
	 * @return
	 */
	public String getCreateName() {
		return createName;
	}

	/**
	 * 创建人姓名 : CREATE_NAME
	 * 
	 * @return
	 */
	public void setCreateName(String createName) {
		this.createName = createName;
	}

	/**
	 * 注销时间 : CANCEL_TIME
	 * 
	 * @return
	 */
	public java.util.Date getCancelTime() {
		return cancelTime;
	}

	/**
	 * 注销时间 : CANCEL_TIME
	 * 
	 * @return
	 */
	public void setCancelTime(java.util.Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	/**
	 * 注销人代码 : CANCEL_CODE
	 * 
	 * @return
	 */
	public String getCancelCode() {
		return cancelCode;
	}

	/**
	 * 注销人代码 : CANCEL_CODE
	 * 
	 * @return
	 */
	public void setCancelCode(String cancelCode) {
		this.cancelCode = cancelCode;
	}

	/**
	 * 注销人姓名 : CANCEL_NAME
	 * 
	 * @return
	 */
	public String getCancelName() {
		return cancelName;
	}

	/**
	 * 注销人姓名 : CANCEL_NAME
	 * 
	 * @return
	 */
	public void setCancelName(String cancelName) {
		this.cancelName = cancelName;
	}

	/**
	 * 融资申请号 : APPLICATION_ID
	 * 
	 * @return
	 */
	public String getApplicationId() {
		return applicationId;
	}

	/**
	 * 融资申请号 : APPLICATION_ID
	 * 
	 * @return
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	/**
	 * 物权人代码（存货人） : GOODS_OWNER_NUM
	 * 
	 * @return
	 */
	public String getGoodsOwnerNum() {
		return goodsOwnerNum;
	}

	/**
	 * 物权人代码（存货人） : GOODS_OWNER_NUM
	 * 
	 * @return
	 */
	public void setGoodsOwnerNum(String goodsOwnerNum) {
		this.goodsOwnerNum = goodsOwnerNum;
	}

	/**
	 * 物权人名称（存货人） : GOODS_OWNER_NAME
	 * 
	 * @return
	 */
	public String getGoodsOwnerName() {
		return goodsOwnerName;
	}

	/**
	 * 物权人名称（存货人） : GOODS_OWNER_NAME
	 * 
	 * @return
	 */
	public void setGoodsOwnerName(String goodsOwnerName) {
		this.goodsOwnerName = goodsOwnerName;
	}

	/**
	 * 保管人地址（仓库地址） : WAREHOUSE_ADDRESS
	 * 
	 * @return
	 */
	public String getWarehouseAddress() {
		return warehouseAddress;
	}

	/**
	 * 保管人地址（仓库地址） : WAREHOUSE_ADDRESS
	 * 
	 * @return
	 */
	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	/**
	 * 物权人地址（存货人） : GOODS_OWNER_ADDRESS
	 * 
	 * @return
	 */
	public String getGoodsOwnerAddress() {
		return goodsOwnerAddress;
	}

	/**
	 * 物权人地址（存货人） : GOODS_OWNER_ADDRESS
	 * 
	 * @return
	 */
	public void setGoodsOwnerAddress(String goodsOwnerAddress) {
		this.goodsOwnerAddress = goodsOwnerAddress;
	}

	/**
	 * 联系人名称 : LINK_MAN_NAME
	 * 
	 * @return
	 */
	public String getLinkManName() {
		return linkManName;
	}

	/**
	 * 联系人名称 : LINK_MAN_NAME
	 * 
	 * @return
	 */
	public void setLinkManName(String linkManName) {
		this.linkManName = linkManName;
	}

	/**
	 * 联系人电话 : LINK_MAN_TEL
	 * 
	 * @return
	 */
	public String getLinkManTel() {
		return linkManTel;
	}

	/**
	 * 联系人电话 : LINK_MAN_TEL
	 * 
	 * @return
	 */
	public void setLinkManTel(String linkManTel) {
		this.linkManTel = linkManTel;
	}

	/**
	 * 联系人传真 : LINK_MAN_FAX
	 * 
	 * @return
	 */
	public String getLinkManFax() {
		return linkManFax;
	}

	/**
	 * 联系人传真 : LINK_MAN_FAX
	 * 
	 * @return
	 */
	public void setLinkManFax(String linkManFax) {
		this.linkManFax = linkManFax;
	}

	/**
	 * 有效期 : VALIDITY_TIME
	 * 
	 * @return
	 */
	public java.util.Date getValidityTime() {
		return validityTime;
	}

	/**
	 * 有效期 : VALIDITY_TIME
	 * 
	 * @return
	 */
	public void setValidityTime(java.util.Date validityTime) {
		this.validityTime = validityTime;
	}

	/**
	 * 存货地址 : STOCK_ADDRESS
	 * 
	 * @return
	 */
	public String getStockAddress() {
		return stockAddress;
	}

	/**
	 * 存货地址 : STOCK_ADDRESS
	 * 
	 * @return
	 */
	public void setStockAddress(String stockAddress) {
		this.stockAddress = stockAddress;
	}

	/**
	 * 特殊养护要求 : MAINTENANCE_STAND
	 * 
	 * @return
	 */
	public String getMaintenanceStand() {
		return maintenanceStand;
	}

	/**
	 * 特殊养护要求 : MAINTENANCE_STAND
	 * 
	 * @return
	 */
	public void setMaintenanceStand(String maintenanceStand) {
		this.maintenanceStand = maintenanceStand;
	}

	/**
	 * 损耗标准 : LOSS_STAND
	 * 
	 * @return
	 */
	public String getLossStand() {
		return lossStand;
	}

	/**
	 * 损耗标准 : LOSS_STAND
	 * 
	 * @return
	 */
	public void setLossStand(String lossStand) {
		this.lossStand = lossStand;
	}

	/**
	 * 收费标准 : CHARGE_STAND
	 * 
	 * @return
	 */
	public String getChargeStand() {
		return chargeStand;
	}

	/**
	 * 收费标准 : CHARGE_STAND
	 * 
	 * @return
	 */
	public void setChargeStand(String chargeStand) {
		this.chargeStand = chargeStand;
	}

	/**
	 * 结算方式 : SETTLE_TYPE
	 * 
	 * @return
	 */
	public String getSettleType() {
		return settleType;
	}

	/**
	 * 结算方式 : SETTLE_TYPE
	 * 
	 * @return
	 */
	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}

	/**
	 * 存储卡号 : SAVE_NO
	 * 
	 * @return
	 */
	public String getSaveNo() {
		return saveNo;
	}

	/**
	 * 存储卡号 : SAVE_NO
	 * 
	 * @return
	 */
	public void setSaveNo(String saveNo) {
		this.saveNo = saveNo;
	}

	/**
	 * 手号 : HAND_NO
	 * 
	 * @return
	 */
	public String getHandNo() {
		return handNo;
	}

	/**
	 * 手号 : HAND_NO
	 * 
	 * @return
	 */
	public void setHandNo(String handNo) {
		this.handNo = handNo;
	}

	/**
	 * 预申请号 : WARRANTY_APP_NO
	 * 
	 * @return
	 */
	public String getWarrantyAppNo() {
		return warrantyAppNo;
	}

	/**
	 * 预申请号 : WARRANTY_APP_NO
	 * 
	 * @return
	 */
	public void setWarrantyAppNo(String warrantyAppNo) {
		this.warrantyAppNo = warrantyAppNo;
	}

	/**
	 * 最后打印人 : PRINT_PERSON
	 * 
	 * @return
	 */
	public String getPrintPerson() {
		return printPerson;
	}

	/**
	 * 最后打印人 : PRINT_PERSON
	 * 
	 * @return
	 */
	public void setPrintPerson(String printPerson) {
		this.printPerson = printPerson;
	}

	/**
	 * 最后打印时间 : PRINT_DATE
	 * 
	 * @return
	 */
	public java.util.Date getPrintDate() {
		return printDate;
	}

	/**
	 * 最后打印时间 : PRINT_DATE
	 * 
	 * @return
	 */
	public void setPrintDate(java.util.Date printDate) {
		this.printDate = printDate;
	}

	/**
	 * 打印次数 : PRINT_COUNT
	 * 
	 * @return
	 */
	public Integer getPrintCount() {
		return printCount;
	}

	/**
	 * 打印次数 : PRINT_COUNT
	 * 
	 * @return
	 */
	public void setPrintCount(Integer printCount) {
		this.printCount = printCount;
	}

	/**
	 * 仓单密码（用于验单） : VERIFY_ID
	 * 
	 * @return
	 */
	public String getVerifyId() {
		return verifyId;
	}

	/**
	 * 仓单密码（用于验单） : VERIFY_ID
	 * 
	 * @return
	 */
	public void setVerifyId(String verifyId) {
		this.verifyId = verifyId;
	}

	/**
	 * 质量证明文件 : QUALITY_DOC
	 * 
	 * @return
	 */
	public String getQualityDoc() {
		return qualityDoc;
	}

	/**
	 * 质量证明文件 : QUALITY_DOC
	 * 
	 * @return
	 */
	public void setQualityDoc(String qualityDoc) {
		this.qualityDoc = qualityDoc;
	}

	public java.util.Date getPeApprovalDate() {
		return peApprovalDate;
	}

	public void setPeApprovalDate(java.util.Date peApprovalDate) {
		this.peApprovalDate = peApprovalDate;
	}

	public java.math.BigDecimal getUnpackPrice() {
		return unpackPrice;
	}

	public void setUnpackPrice(java.math.BigDecimal unpackPrice) {
		this.unpackPrice = unpackPrice;
	}

	public String getMarketFlag() {
		return marketFlag;
	}

	public void setMarketFlag(String marketFlag) {
		this.marketFlag = marketFlag;
	}

	public String getWarrantyType() {
		return warrantyType;
	}

	public void setWarrantyType(String warrantyType) {
		this.warrantyType = warrantyType;
	}

	public String getTaxedFlag() {
		return taxedFlag;
	}

	public void setTaxedFlag(String taxedFlag) {
		this.taxedFlag = taxedFlag;
	}

	public java.math.BigDecimal getDepositRatio() {
		return depositRatio;
	}

	public void setDepositRatio(java.math.BigDecimal depositRatio) {
		this.depositRatio = depositRatio;
	}

	public String getDepositManager() {
		return depositManager;
	}

	public void setDepositManager(String depositManager) {
		this.depositManager = depositManager;
	}

	public String getWarrantyDataSources() {
		return warrantyDataSources;
	}

	public void setWarrantyDataSources(String warrantyDataSources) {
		this.warrantyDataSources = warrantyDataSources;
	}

	public String getOrgBillNo() {
		return orgBillNo;
	}

	public void setOrgBillNo(String orgBillNo) {
		this.orgBillNo = orgBillNo;
	}

	public String getOrgSysNo() {
		return orgSysNo;
	}

	public void setOrgSysNo(String orgSysNo) {
		this.orgSysNo = orgSysNo;
	}

	public String getOrgSysName() {
		return orgSysName;
	}

	public void setOrgSysName(String orgSysName) {
		this.orgSysName = orgSysName;
	}

	public String getWarehouseCredit() {
		return warehouseCredit;
	}

	public void setWarehouseCredit(String warehouseCredit) {
		this.warehouseCredit = warehouseCredit;
	}

	public String getClearCredit() {
		return clearCredit;
	}

	public void setClearCredit(String clearCredit) {
		this.clearCredit = clearCredit;
	}

	public String getCustomsCredit() {
		return customsCredit;
	}

	public void setCustomsCredit(String customsCredit) {
		this.customsCredit = customsCredit;
	}

	public String getIllicitFlag() {
		return illicitFlag;
	}

	public void setIllicitFlag(String illicitFlag) {
		this.illicitFlag = illicitFlag;
	}

	public String getWhWarrantyNo() {
		return whWarrantyNo;
	}

	public void setWhWarrantyNo(String whWarrantyNo) {
		this.whWarrantyNo = whWarrantyNo;
	}

	public String getCtmPrdCode() {
		return ctmPrdCode;
	}

	public void setCtmPrdCode(String ctmPrdCode) {
		this.ctmPrdCode = ctmPrdCode;
	}

	public String getTrdSysEn() {
		return trdSysEn;
	}

	public void setTrdSysEn(String trdSysEn) {
		this.trdSysEn = trdSysEn;
	}

	public String getWarehouseNameEn() {
		return warehouseNameEn;
	}

	public void setWarehouseNameEn(String warehouseNameEn) {
		this.warehouseNameEn = warehouseNameEn;
	}

	public String getCustNameEn() {
		return custNameEn;
	}

	public void setCustNameEn(String custNameEn) {
		this.custNameEn = custNameEn;
	}

	public String getWarehouseIconName() {
		return warehouseIconName;
	}

	public void setWarehouseIconName(String warehouseIconName) {
		this.warehouseIconName = warehouseIconName;
	}

	public String getClearIconName() {
		return clearIconName;
	}

	public void setClearIconName(String clearIconName) {
		this.clearIconName = clearIconName;
	}

	public String getCustomsIconName() {
		return customsIconName;
	}

	public void setCustomsIconName(String customsIconName) {
		this.customsIconName = customsIconName;
	}

	public String getIsSynchronize() {
		return isSynchronize;
	}

	public void setIsSynchronize(String isSynchronize) {
		this.isSynchronize = isSynchronize;
	}

	public String getBillCreateTime() {
		return billCreateTime;
	}

	public void setBillCreateTime(String billCreateTime) {
		this.billCreateTime = billCreateTime;
	}

	public String getDoubtIconName() {
		return doubtIconName;
	}

	public void setDoubtIconName(String doubtIconName) {
		this.doubtIconName = doubtIconName;
	}

	public String getCustTaxNum() {
		return custTaxNum;
	}

	public void setCustTaxNum(String custTaxNum) {
		this.custTaxNum = custTaxNum;
	}

	public String getPrdCataCode() {
		return prdCataCode;
	}

	public void setPrdCataCode(String prdCataCode) {
		this.prdCataCode = prdCataCode;
	}

	public String getPrdCataName() {
		return prdCataName;
	}

	public void setPrdCataName(String prdCataName) {
		this.prdCataName = prdCataName;
	}

	public String getBussinessNo() {
		return bussinessNo;
	}

	public void setBussinessNo(String bussinessNo) {
		this.bussinessNo = bussinessNo;
	}

	public BigDecimal getBussinessPrice() {
		return bussinessPrice;
	}

	public void setBussinessPrice(BigDecimal bussinessPrice) {
		this.bussinessPrice = bussinessPrice;
	}

	public String getBussinessTime() {
		return bussinessTime;
	}

	public void setBussinessTime(String bussinessTime) {
		this.bussinessTime = bussinessTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
