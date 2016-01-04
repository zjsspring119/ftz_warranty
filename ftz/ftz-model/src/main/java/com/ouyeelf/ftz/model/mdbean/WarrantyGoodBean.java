package com.ouyeelf.ftz.model.mdbean;

import com.ouyeelf.ftz.model.BaseEntity;




/**
 * 仓单明细表
 * 
 * 
 * @author Gen
 */
public class WarrantyGoodBean extends BaseEntity {
	// 序号 : ID
	private String id;

	// 仓单号 : WARRANTY_NO
	private String warrantyNo;

	// 货物ID : GOOD_ID
	private String goodId;

	// 仓库代码（融资平台定义） : RZ_WAREHOUSE_CODE
	private String rzWarehouseCode;

	// 捆包号 : PACK_NUM
	private String packNum;

	// 钢厂资源号 : RESOURCE_NUM
	private String resourceNum;

	// 仓库库区描述 : AREA
	private String area;

	// 仓库库位描述 : LOCATION
	private String location;

	// 产地 : AREA_P
	private String areaP;

	// 品名 : TYPE_NAME
	private String typeName;

	// 规格 : SPEC
	private String spec;

	// 材质 : GRADE
	private String grade;

	// 过磅净重 : WEIGHT_B
	private java.math.BigDecimal weightB;

	// 抄码净重 : WEIGHT_C
	private java.math.BigDecimal weightC;

	// 数量 : SHEET_NUM
	private Integer sheetNum;

	// 数量单位 : UNIT
	private String unit;

	// 品质描述 : QUALITY_DESC
	private String qualityDesc;

	// 外观描述 : SHOW_DESC
	private String showDesc;

	// 产品等级 : PRODUCT_GRADE
	private String productGrade;

	// 进仓日期 : STORE_DATE
	private java.util.Date storeDate;

	// 合同号 : CONTRACT_NO
	private String contractNo;

	// 赎货标识 20:解押 05:生成赎单 08:已提交 : REDEEM_FLAG
	private String redeemFlag;

	// 存储卡号 : SAVE_NO
	private String saveNo;

	// 手号 : HAND_NO
	private String handNo;

	// 车船号 : SIDE_MARK
	private String sideMark;

	// 型号 : GRADE_NUM_XH
	private String gradeNumXh;

	// 单包件、块、支等 : SINGLE_SHEET_NUM
	private Integer singleSheetNum;

	// 单包量单位 : SINGLE_SHEET_UNIT
	private String singleSheetUnit;

	// 炉号 : HEAT_NUM
	private String heatNum;

	// 计量方式 : CHECK_TYPE
	private String checkType;

	// 包装方式 : PACK_TYPE_NAME
	private String packTypeName;

	// 危险品等级 : DANGEROUS_LEVEL
	private String dangerousLevel;

	// 产品技术验收标准 : ACCEPTANCE_CRITERIA
	private String acceptanceCriteria;

	// 唛头 : SHIPPING_MARK
	private String shippingMark;

	// 到货方式 : TRANS_TYPE
	private String transType;

	// 备注 : MEMO
	private String memo;

	// 验收编号(存货人捆包号) : ACCEPT_NO
	private String acceptNo;

	// 银行确认单价 : BANK_PRICE
	private java.math.BigDecimal bankPrice;

	// 银行确认价值 : BANK_AMT
	private java.math.BigDecimal bankAmt;

	// 最后盘点日期 : LAST_CHECK_DATE
	private java.util.Date lastCheckDate;

	// 库位标签 : LABEL_LOCATION_NO
	private String labelLocationNo;

	// 明细标签 : LABEL_NO
	private String labelNo;

	// 状态 : CHECK_STATUS
	private String checkStatus;

	// 纬度 : LATITUDE
	private String latitude;

	// 经度 : LONGITUDE
	private String longitude;

	// 最后盘点人代码 : LAST_CHECK_USER_NUM
	private String lastCheckUserNum;

	// 最后盘点人名称 : LAST_CHECK_USER_NAME
	private String lastCheckUserName;

	// 最后盘点组织代码 : LAST_CHECK_ORG_NUM
	private String lastCheckOrgNum;

	// 最后盘点组织名称 : LAST_CHECK_ORG_NAME
	private String lastCheckOrgName;

	// 最后盘库指令号 : LAST_CHECK_NUM
	private String lastCheckNum;

	// 打印次数 : PRINT_TIMES
	private Integer printTimes;

	// 条形码 : BARCODE
	private String barcode;

	// 原品名大类 : OLD_PM_CALSS
	private String oldPmClass;

	// 新品名大类 : NEW_PM_CALSS
	private String newPmClass;

	// 最终品类（由平台最终确认） : PM_CALSS
	private String pmClass;

	// 参保标记(0-无保险，1-参保) : INSURED_FLAG
	private String insuredFlag;

	// 创建时间 : CREATE_TIME
	private java.util.Date createTime;

	// 最后更新时间 : UPDATE_TIME
	private java.util.Date updateTime;

	// 扩展描述 : EXPAND_DESC
	private String expandDesc;


	//质检编号
	private String  qcSheetNo;
	
	//品种代码
	private String pmCode;
	
	private String ctmDeclarationNo;//海关报关编号
	
	public String weightUnit;
	
	/**
	 * 序号 : ID
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 序号 : ID
	 * 
	 * @return
	 */
	public void setId(String id) {
		this.id = id;
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
	 * 货物ID : GOOD_ID
	 * 
	 * @return
	 */
	public String getGoodId() {
		return goodId;
	}

	/**
	 * 货物ID : GOOD_ID
	 * 
	 * @return
	 */
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	/**
	 * 仓库代码（融资平台定义） : RZ_WAREHOUSE_CODE
	 * 
	 * @return
	 */
	public String getRzWarehouseCode() {
		return rzWarehouseCode;
	}

	/**
	 * 仓库代码（融资平台定义） : RZ_WAREHOUSE_CODE
	 * 
	 * @return
	 */
	public void setRzWarehouseCode(String rzWarehouseCode) {
		this.rzWarehouseCode = rzWarehouseCode;
	}

	/**
	 * 捆包号 : PACK_NUM
	 * 
	 * @return
	 */
	public String getPackNum() {
		return packNum;
	}

	/**
	 * 捆包号 : PACK_NUM
	 * 
	 * @return
	 */
	public void setPackNum(String packNum) {
		this.packNum = packNum;
	}

	/**
	 * 钢厂资源号 : RESOURCE_NUM
	 * 
	 * @return
	 */
	public String getResourceNum() {
		return resourceNum;
	}

	/**
	 * 钢厂资源号 : RESOURCE_NUM
	 * 
	 * @return
	 */
	public void setResourceNum(String resourceNum) {
		this.resourceNum = resourceNum;
	}

	/**
	 * 仓库库区描述 : AREA
	 * 
	 * @return
	 */
	public String getArea() {
		return area;
	}

	/**
	 * 仓库库区描述 : AREA
	 * 
	 * @return
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * 仓库库位描述 : LOCATION
	 * 
	 * @return
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 仓库库位描述 : LOCATION
	 * 
	 * @return
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 产地 : AREA_P
	 * 
	 * @return
	 */
	public String getAreaP() {
		return areaP;
	}

	/**
	 * 产地 : AREA_P
	 * 
	 * @return
	 */
	public void setAreaP(String areaP) {
		this.areaP = areaP;
	}

	/**
	 * 品名 : TYPE_NAME
	 * 
	 * @return
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * 品名 : TYPE_NAME
	 * 
	 * @return
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * 规格 : SPEC
	 * 
	 * @return
	 */
	public String getSpec() {
		return spec;
	}

	/**
	 * 规格 : SPEC
	 * 
	 * @return
	 */
	public void setSpec(String spec) {
		this.spec = spec;
	}

	/**
	 * 材质 : GRADE
	 * 
	 * @return
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * 材质 : GRADE
	 * 
	 * @return
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * 过磅净重 : WEIGHT_B
	 * 
	 * @return
	 */
	public java.math.BigDecimal getWeightB() {
		return weightB;
	}

	/**
	 * 过磅净重 : WEIGHT_B
	 * 
	 * @return
	 */
	public void setWeightB(java.math.BigDecimal weightB) {
		this.weightB = weightB;
	}

	/**
	 * 抄码净重 : WEIGHT_C
	 * 
	 * @return
	 */
	public java.math.BigDecimal getWeightC() {
		return weightC;
	}

	/**
	 * 抄码净重 : WEIGHT_C
	 * 
	 * @return
	 */
	public void setWeightC(java.math.BigDecimal weightC) {
		this.weightC = weightC;
	}

	/**
	 * 数量 : SHEET_NUM
	 * 
	 * @return
	 */
	public Integer getSheetNum() {
		return sheetNum;
	}

	/**
	 * 数量 : SHEET_NUM
	 * 
	 * @return
	 */
	public void setSheetNum(Integer sheetNum) {
		this.sheetNum = sheetNum;
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
	 * 品质描述 : QUALITY_DESC
	 * 
	 * @return
	 */
	public String getQualityDesc() {
		return qualityDesc;
	}

	/**
	 * 品质描述 : QUALITY_DESC
	 * 
	 * @return
	 */
	public void setQualityDesc(String qualityDesc) {
		this.qualityDesc = qualityDesc;
	}

	/**
	 * 外观描述 : SHOW_DESC
	 * 
	 * @return
	 */
	public String getShowDesc() {
		return showDesc;
	}

	/**
	 * 外观描述 : SHOW_DESC
	 * 
	 * @return
	 */
	public void setShowDesc(String showDesc) {
		this.showDesc = showDesc;
	}

	/**
	 * 产品等级 : PRODUCT_GRADE
	 * 
	 * @return
	 */
	public String getProductGrade() {
		return productGrade;
	}

	/**
	 * 产品等级 : PRODUCT_GRADE
	 * 
	 * @return
	 */
	public void setProductGrade(String productGrade) {
		this.productGrade = productGrade;
	}

	/**
	 * 进仓日期 : STORE_DATE
	 * 
	 * @return
	 */
	public java.util.Date getStoreDate() {
		return storeDate;
	}

	/**
	 * 进仓日期 : STORE_DATE
	 * 
	 * @return
	 */
	public void setStoreDate(java.util.Date storeDate) {
		this.storeDate = storeDate;
	}

	/**
	 * 合同号 : CONTRACT_NO
	 * 
	 * @return
	 */
	public String getContractNo() {
		return contractNo;
	}

	/**
	 * 合同号 : CONTRACT_NO
	 * 
	 * @return
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	/**
	 * 赎货标识 20:解押 05:生成赎单 08:已提交 : REDEEM_FLAG
	 * 
	 * @return
	 */
	public String getRedeemFlag() {
		return redeemFlag;
	}

	/**
	 * 赎货标识 20:解押 05:生成赎单 08:已提交 : REDEEM_FLAG
	 * 
	 * @return
	 */
	public void setRedeemFlag(String redeemFlag) {
		this.redeemFlag = redeemFlag;
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
	 * 车船号 : SIDE_MARK
	 * 
	 * @return
	 */
	public String getSideMark() {
		return sideMark;
	}

	/**
	 * 车船号 : SIDE_MARK
	 * 
	 * @return
	 */
	public void setSideMark(String sideMark) {
		this.sideMark = sideMark;
	}

	/**
	 * 型号 : GRADE_NUM_XH
	 * 
	 * @return
	 */
	public String getGradeNumXh() {
		return gradeNumXh;
	}

	/**
	 * 型号 : GRADE_NUM_XH
	 * 
	 * @return
	 */
	public void setGradeNumXh(String gradeNumXh) {
		this.gradeNumXh = gradeNumXh;
	}

	/**
	 * 单包件、块、支等 : SINGLE_SHEET_NUM
	 * 
	 * @return
	 */
	public Integer getSingleSheetNum() {
		return singleSheetNum;
	}

	/**
	 * 单包件、块、支等 : SINGLE_SHEET_NUM
	 * 
	 * @return
	 */
	public void setSingleSheetNum(Integer singleSheetNum) {
		this.singleSheetNum = singleSheetNum;
	}

	/**
	 * 单包量单位 : SINGLE_SHEET_UNIT
	 * 
	 * @return
	 */
	public String getSingleSheetUnit() {
		return singleSheetUnit;
	}

	/**
	 * 单包量单位 : SINGLE_SHEET_UNIT
	 * 
	 * @return
	 */
	public void setSingleSheetUnit(String singleSheetUnit) {
		this.singleSheetUnit = singleSheetUnit;
	}

	/**
	 * 炉号 : HEAT_NUM
	 * 
	 * @return
	 */
	public String getHeatNum() {
		return heatNum;
	}

	/**
	 * 炉号 : HEAT_NUM
	 * 
	 * @return
	 */
	public void setHeatNum(String heatNum) {
		this.heatNum = heatNum;
	}

	/**
	 * 计量方式 : CHECK_TYPE
	 * 
	 * @return
	 */
	public String getCheckType() {
		return checkType;
	}

	/**
	 * 计量方式 : CHECK_TYPE
	 * 
	 * @return
	 */
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	/**
	 * 包装方式 : PACK_TYPE_NAME
	 * 
	 * @return
	 */
	public String getPackTypeName() {
		return packTypeName;
	}

	/**
	 * 包装方式 : PACK_TYPE_NAME
	 * 
	 * @return
	 */
	public void setPackTypeName(String packTypeName) {
		this.packTypeName = packTypeName;
	}

	/**
	 * 危险品等级 : DANGEROUS_LEVEL
	 * 
	 * @return
	 */
	public String getDangerousLevel() {
		return dangerousLevel;
	}

	/**
	 * 危险品等级 : DANGEROUS_LEVEL
	 * 
	 * @return
	 */
	public void setDangerousLevel(String dangerousLevel) {
		this.dangerousLevel = dangerousLevel;
	}

	/**
	 * 产品技术验收标准 : ACCEPTANCE_CRITERIA
	 * 
	 * @return
	 */
	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}

	/**
	 * 产品技术验收标准 : ACCEPTANCE_CRITERIA
	 * 
	 * @return
	 */
	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}

	/**
	 * 唛头 : SHIPPING_MARK
	 * 
	 * @return
	 */
	public String getShippingMark() {
		return shippingMark;
	}

	/**
	 * 唛头 : SHIPPING_MARK
	 * 
	 * @return
	 */
	public void setShippingMark(String shippingMark) {
		this.shippingMark = shippingMark;
	}

	/**
	 * 到货方式 : TRANS_TYPE
	 * 
	 * @return
	 */
	public String getTransType() {
		return transType;
	}

	/**
	 * 到货方式 : TRANS_TYPE
	 * 
	 * @return
	 */
	public void setTransType(String transType) {
		this.transType = transType;
	}

	/**
	 * 备注 : MEMO
	 * 
	 * @return
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * 备注 : MEMO
	 * 
	 * @return
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * 验收编号(存货人捆包号) : ACCEPT_NO
	 * 
	 * @return
	 */
	public String getAcceptNo() {
		return acceptNo;
	}

	/**
	 * 验收编号(存货人捆包号) : ACCEPT_NO
	 * 
	 * @return
	 */
	public void setAcceptNo(String acceptNo) {
		this.acceptNo = acceptNo;
	}

	/**
	 * 银行确认单价 : BANK_PRICE
	 * 
	 * @return
	 */
	public java.math.BigDecimal getBankPrice() {
		return bankPrice;
	}

	/**
	 * 银行确认单价 : BANK_PRICE
	 * 
	 * @return
	 */
	public void setBankPrice(java.math.BigDecimal bankPrice) {
		this.bankPrice = bankPrice;
	}

	/**
	 * 银行确认价值 : BANK_AMT
	 * 
	 * @return
	 */
	public java.math.BigDecimal getBankAmt() {
		return bankAmt;
	}

	/**
	 * 银行确认价值 : BANK_AMT
	 * 
	 * @return
	 */
	public void setBankAmt(java.math.BigDecimal bankAmt) {
		this.bankAmt = bankAmt;
	}

	/**
	 * 最后盘点日期 : LAST_CHECK_DATE
	 * 
	 * @return
	 */
	public java.util.Date getLastCheckDate() {
		return lastCheckDate;
	}

	/**
	 * 最后盘点日期 : LAST_CHECK_DATE
	 * 
	 * @return
	 */
	public void setLastCheckDate(java.util.Date lastCheckDate) {
		this.lastCheckDate = lastCheckDate;
	}

	/**
	 * 库位标签 : LABEL_LOCATION_NO
	 * 
	 * @return
	 */
	public String getLabelLocationNo() {
		return labelLocationNo;
	}

	/**
	 * 库位标签 : LABEL_LOCATION_NO
	 * 
	 * @return
	 */
	public void setLabelLocationNo(String labelLocationNo) {
		this.labelLocationNo = labelLocationNo;
	}

	/**
	 * 明细标签 : LABEL_NO
	 * 
	 * @return
	 */
	public String getLabelNo() {
		return labelNo;
	}

	/**
	 * 明细标签 : LABEL_NO
	 * 
	 * @return
	 */
	public void setLabelNo(String labelNo) {
		this.labelNo = labelNo;
	}

	/**
	 * 状态 : CHECK_STATUS
	 * 
	 * @return
	 */
	public String getCheckStatus() {
		return checkStatus;
	}

	/**
	 * 状态 : CHECK_STATUS
	 * 
	 * @return
	 */
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	/**
	 * 纬度 : LATITUDE
	 * 
	 * @return
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * 纬度 : LATITUDE
	 * 
	 * @return
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * 经度 : LONGITUDE
	 * 
	 * @return
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * 经度 : LONGITUDE
	 * 
	 * @return
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * 最后盘点人代码 : LAST_CHECK_USER_NUM
	 * 
	 * @return
	 */
	public String getLastCheckUserNum() {
		return lastCheckUserNum;
	}

	/**
	 * 最后盘点人代码 : LAST_CHECK_USER_NUM
	 * 
	 * @return
	 */
	public void setLastCheckUserNum(String lastCheckUserNum) {
		this.lastCheckUserNum = lastCheckUserNum;
	}

	/**
	 * 最后盘点人名称 : LAST_CHECK_USER_NAME
	 * 
	 * @return
	 */
	public String getLastCheckUserName() {
		return lastCheckUserName;
	}

	/**
	 * 最后盘点人名称 : LAST_CHECK_USER_NAME
	 * 
	 * @return
	 */
	public void setLastCheckUserName(String lastCheckUserName) {
		this.lastCheckUserName = lastCheckUserName;
	}

	/**
	 * 最后盘点组织代码 : LAST_CHECK_ORG_NUM
	 * 
	 * @return
	 */
	public String getLastCheckOrgNum() {
		return lastCheckOrgNum;
	}

	/**
	 * 最后盘点组织代码 : LAST_CHECK_ORG_NUM
	 * 
	 * @return
	 */
	public void setLastCheckOrgNum(String lastCheckOrgNum) {
		this.lastCheckOrgNum = lastCheckOrgNum;
	}

	/**
	 * 最后盘点组织名称 : LAST_CHECK_ORG_NAME
	 * 
	 * @return
	 */
	public String getLastCheckOrgName() {
		return lastCheckOrgName;
	}

	/**
	 * 最后盘点组织名称 : LAST_CHECK_ORG_NAME
	 * 
	 * @return
	 */
	public void setLastCheckOrgName(String lastCheckOrgName) {
		this.lastCheckOrgName = lastCheckOrgName;
	}

	/**
	 * 最后盘库指令号 : LAST_CHECK_NUM
	 * 
	 * @return
	 */
	public String getLastCheckNum() {
		return lastCheckNum;
	}

	/**
	 * 最后盘库指令号 : LAST_CHECK_NUM
	 * 
	 * @return
	 */
	public void setLastCheckNum(String lastCheckNum) {
		this.lastCheckNum = lastCheckNum;
	}

	/**
	 * 打印次数 : PRINT_TIMES
	 * 
	 * @return
	 */
	public Integer getPrintTimes() {
		return printTimes;
	}

	/**
	 * 打印次数 : PRINT_TIMES
	 * 
	 * @return
	 */
	public void setPrintTimes(Integer printTimes) {
		this.printTimes = printTimes;
	}

	/**
	 * 条形码 : BARCODE
	 * 
	 * @return
	 */
	public String getBarcode() {
		return barcode;
	}

	/**
	 * 条形码 : BARCODE
	 * 
	 * @return
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	
	

	public String getOldPmClass() {
		return oldPmClass;
	}

	public void setOldPmClass(String oldPmClass) {
		this.oldPmClass = oldPmClass;
	}

	public String getNewPmClass() {
		return newPmClass;
	}

	public void setNewPmClass(String newPmClass) {
		this.newPmClass = newPmClass;
	}

	public String getPmClass() {
		return pmClass;
	}

	public void setPmClass(String pmClass) {
		this.pmClass = pmClass;
	}

	/**
	 * 参保标记(0-无保险，1-参保) : INSURED_FLAG
	 * 
	 * @return
	 */
	public String getInsuredFlag() {
		return insuredFlag;
	}

	/**
	 * 参保标记(0-无保险，1-参保) : INSURED_FLAG
	 * 
	 * @return
	 */
	public void setInsuredFlag(String insuredFlag) {
		this.insuredFlag = insuredFlag;
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
	 * 最后更新时间 : UPDATE_TIME
	 * 
	 * @return
	 */
	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 最后更新时间 : UPDATE_TIME
	 * 
	 * @return
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 扩展描述 : EXPAND_DESC
	 * 
	 * @return
	 */
	public String getExpandDesc() {
		return expandDesc;
	}

	/**
	 * 扩展描述 : EXPAND_DESC
	 * 
	 * @return
	 */
	public void setExpandDesc(String expandDesc) {
		this.expandDesc = expandDesc;
	}

	public String getQcSheetNo() {
		return qcSheetNo;
	}

	public void setQcSheetNo(String qcSheetNo) {
		this.qcSheetNo = qcSheetNo;
	}

	public String getPmCode() {
		return pmCode;
	}

	public void setPmCode(String pmCode) {
		this.pmCode = pmCode;
	}

	public String getCtmDeclarationNo() {
		return ctmDeclarationNo;
	}

	public void setCtmDeclarationNo(String ctmDeclarationNo) {
		this.ctmDeclarationNo = ctmDeclarationNo;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	

}
