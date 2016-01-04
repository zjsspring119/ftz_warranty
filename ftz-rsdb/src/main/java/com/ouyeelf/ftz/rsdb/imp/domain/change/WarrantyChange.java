package com.ouyeelf.ftz.rsdb.imp.domain.change;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.ouyeelf.ftz.model.mdbean.WarrantyBean;
import com.ouyeelf.ftz.model.mdbean.WarrantyGoodBean;


/**
 * **************************************************
 *@Copyrigth(c) by baosight Co., Ltd
 *@Create Date 2015-2-2 
 *@author zjs
 *@File Name：
 *@Last version：1.0
 *@Function: warrantyBean 转化成mongodb存储warrantyBean
 *@Change Log:
 **************************************************
 */
public class WarrantyChange extends BaseChange{
	public static DBObject change(WarrantyBean warranty){
		DBObject obj = new BasicDBObject();
		//主项信息
		obj.put("warrantyNo", warranty.getWarrantyNo());//仓单号
		obj.put("customerCode", warranty.getCustomerCode());//客户代码
		obj.put("customerName", warranty.getCustomerName());//客户名称
		obj.put("warehouseNum", warranty.getWarehouseNum());//仓库代码
		obj.put("warehouseName", warranty.getWarehouseName());//仓库名称	
		obj.put("pledgeeCode", warranty.getPledgeeCode());//质权人代码
		obj.put("pledgeeName", warranty.getPledgeeName());//质权人名称
		obj.put("warrantyStatus", warranty.getWarrantyStatus());//仓单状态
		obj.put("num", warranty.getNum());//数量
		obj.put("unit", warranty.getUnit());//数量单位
		obj.put("weight", bigDecimalToStr(warranty.getWeight()));//重量
		obj.put("price", bigDecimalToStr(warranty.getPrice()));//总价值
		obj.put("createTime", dateToStr(warranty.getCreateTime()));//创建时间
		obj.put("createCode", warranty.getCreateCode());//创建人代码
		obj.put("createName", warranty.getCreateName());//创建人名称
		obj.put("cancelTime", dateToStr(warranty.getCancelTime()));//注销时间
		obj.put("cancelCode", warranty.getCancelCode());//注销人代码		
		obj.put("cancelName", warranty.getCancelName());//注销人名称
		obj.put("applicationId", warranty.getApplicationId());//融资申请号
		obj.put("goodsOwnerNum", warranty.getGoodsOwnerNum());//存货人代码
		obj.put("goodsOwnerName", warranty.getGoodsOwnerName());//存货人名称
		obj.put("warehouseAddress", warranty.getWarehouseAddress());//仓库地址
		obj.put("goodsOwnerAddress", warranty.getGoodsOwnerAddress());//存货人地址
		obj.put("linkManName", warranty.getLinkManName());//联系人名称
		obj.put("linkManTel", warranty.getLinkManTel());//联系人电话
		obj.put("linkManFax", warranty.getLinkManFax());//联系人传真
		obj.put("validityTime", dateToStr(warranty.getValidityTime()));//有效期
		obj.put("stockAddress", warranty.getStockAddress());//存货地址
		obj.put("maintenanceStand", warranty.getMaintenanceStand());//特殊养护要求
		obj.put("lossStand", warranty.getLossStand());//损耗标准
		obj.put("chargeStand", warranty.getChargeStand());//收费标准
		obj.put("settleType", warranty.getSettleType());//结算方式
		obj.put("saveNo", warranty.getSaveNo());//原为“存储卡号”，现用作“注销单据号”
		obj.put("handNo", warranty.getHandNo());//手号
		obj.put("warrantyAppNo", warranty.getWarrantyAppNo());//制单申请号
		obj.put("printPerson", warranty.getPrintPerson());//最后打印人
		obj.put("printDate", dateToStr(warranty.getPrintDate()));//最后打印时间
		obj.put("printCount", integerToStr(warranty.getPrintCount()));//打印次数
		obj.put("verifyId", warranty.getVerifyId());//仓单密码
		obj.put("qualityDoc", warranty.getQualityDoc());//质量证明文件
		obj.put("warehouseContractNo", warranty.getWarehouseContractNo());//保管合同号
		obj.put("principalManTel", warranty.getPrincipalManTel());//负责人电话
		obj.put("peApprovalDate", dateToStr(warranty.getPeApprovalDate()));//职权审核时间
		obj.put("unpackPrice", bigDecimalToStr(warranty.getUnpackPrice()));//解压金额
		obj.put("marketFlag", warranty.getMarketFlag());//市场区分标记
		obj.put("warrantyType", warranty.getWarrantyType());//仓单类型
		obj.put("taxedFlag", warranty.getTaxedFlag());//完税标记
		obj.put("depositRatio", bigDecimalToStr(warranty.getDepositRatio()));//保证金比例
		obj.put("depositManager", warranty.getDepositManager());//保证金存管方名称
		obj.put("warrantyDataSources", warranty.getWarrantyDataSources());//仓单注册来源
		obj.put("orgBillNo", warranty.getOrgBillNo());//外部系统业务单据
		obj.put("orgSysNo", warranty.getOrgSysNo());//交易平台代码
		obj.put("orgSysName", warranty.getOrgSysName());//仓单注册来源
		obj.put("warehouseCredit", warranty.getWarehouseCredit());//仓库诚信标记
		obj.put("clearCredit", warranty.getClearCredit());//清算诚信标记
		obj.put("customsCredit", warranty.getCustomsCredit());//海关诚信标记
		obj.put("illicitFlag", warranty.getIllicitFlag()==null?"0":warranty.getIllicitFlag());//是否违禁仓单（1-是、0-否）
		obj.put("whWarrantyNo", warranty.getWhWarrantyNo());//仓库系统仓单号
		obj.put("ctmPrdCode", warranty.getCtmPrdCode());//海关商品编号
		obj.put("trdSysEn", warranty.getTrdSysEn());//交易平台英文简称
		obj.put("warehouseNameEn", warranty.getWarehouseNameEn());//仓库英文简称
		obj.put("custNameEn", warranty.getCustNameEn());//货主英文简称
		obj.put("warehouseIconName", warranty.getWarehouseIconName());//仓储诚信标记所对应的图片名
		obj.put("clearIconName", warranty.getClearIconName());//清算诚信标记所对应的图片名
		obj.put("customsIconName", warranty.getCustomsIconName());//海关诚信标记所对应的图片名 
		obj.put("isSynchronize", warranty.getIsSynchronize());//是否被同步mongodb（1-已同步）
		obj.put("billCreateTime", warranty.getBillCreateTime());//单据创建时间(YYYY-MM-DD)
		obj.put("doubtIconName", warranty.getDoubtIconName());//异议诚信标记所对应的图片名
		obj.put("csutTaxNum", warranty.getCsutTaxNum());// 货主税号(提供给交易平台使用)
		obj.put("prdCataCode", warranty.getPrdCataCode());//交易品类代码(提供给交易平台使用)
		obj.put("prdCataName", warranty.getPrdCataName());//交易品类名称(提供给交易平台使用)
		obj.put("bussinessNo", warranty.getBussinessNo());// 交易单号（锁定时填写）
		obj.put("bussinessPrice", bigDecimalToStr(warranty.getBussinessPrice()));//交易价格（锁定时填写）
		obj.put("bussinessTime", warranty.getBussinessTime());//成交时间(YYYY-MM-DD HH:MI:SS)
		obj.put("updateTime", dateToStr(warranty.getUpdateTime()));//成交时间(YYYY-MM-DD HH:MI:SS)
		
		
		//子项信息
		List<DBObject> dbList=new ArrayList<DBObject>();
		List<WarrantyGoodBean> warrantyGoodBeanList=warranty.getWarrantyGoodBean();
		if(null!=warrantyGoodBeanList&&warrantyGoodBeanList.size()>0){
		for (WarrantyGoodBean warrantyGoodBean : warrantyGoodBeanList) {
			DBObject goodBean = new BasicDBObject();
			goodBean.put("warrantyNo",warrantyGoodBean.getWarrantyNo());
			goodBean.put("goodId",warrantyGoodBean.getGoodId());
			goodBean.put("rzWarehouseCode",warrantyGoodBean.getRzWarehouseCode());
			goodBean.put("packNum",warrantyGoodBean.getPackNum());
			goodBean.put("resourceNum",warrantyGoodBean.getResourceNum());
			goodBean.put("area",warrantyGoodBean.getArea());
			goodBean.put("location",warrantyGoodBean.getLocation());
			goodBean.put("areaP",warrantyGoodBean.getAreaP());
			goodBean.put("typeName",warrantyGoodBean.getTypeName());
			goodBean.put("spec",warrantyGoodBean.getSpec());
			goodBean.put("grade",warrantyGoodBean.getGrade());
			goodBean.put("weightB",bigDecimalToStr(warrantyGoodBean.getWeightB()));
			goodBean.put("weightC",bigDecimalToStr(warrantyGoodBean.getWeightC()));
			goodBean.put("sheetNum",integerToStr(warrantyGoodBean.getSheetNum()));
			goodBean.put("unit",warrantyGoodBean.getUnit());
			goodBean.put("qualityDesc",warrantyGoodBean.getQualityDesc());
			goodBean.put("showDesc",warrantyGoodBean.getShowDesc());
			goodBean.put("productGrade",warrantyGoodBean.getProductGrade());
			goodBean.put("contractNo",warrantyGoodBean.getContractNo());
			goodBean.put("redeemFlag",warrantyGoodBean.getRedeemFlag());
			goodBean.put("saveNo",warrantyGoodBean.getSaveNo());
			goodBean.put("handNo",warrantyGoodBean.getHandNo());
			goodBean.put("sideMark",warrantyGoodBean.getSideMark());
			goodBean.put("gradeNumXh",warrantyGoodBean.getGradeNumXh());
			goodBean.put("singleSheetNum",warrantyGoodBean.getSingleSheetNum());
			goodBean.put("singleSheetUnit",warrantyGoodBean.getSingleSheetUnit());
			goodBean.put("heatNum",warrantyGoodBean.getHeatNum());
			goodBean.put("checkType",warrantyGoodBean.getCheckType());
			goodBean.put("packTypeName",warrantyGoodBean.getPackTypeName());
			goodBean.put("dangerousLevel",warrantyGoodBean.getDangerousLevel());
			goodBean.put("acceptanceCriteria",warrantyGoodBean.getAcceptanceCriteria());
			goodBean.put("shippingMark",warrantyGoodBean.getShippingMark());
			goodBean.put("transType",warrantyGoodBean.getTransType());
			goodBean.put("memo",warrantyGoodBean.getMemo());
			goodBean.put("acceptNo",warrantyGoodBean.getAcceptNo());
			goodBean.put("bankPrice",bigDecimalToStr(warrantyGoodBean.getBankPrice()));
			goodBean.put("bankAmt",bigDecimalToStr(warrantyGoodBean.getBankAmt()));
			goodBean.put("lastCheckDate",dateToStr(warrantyGoodBean.getLastCheckDate()));
			goodBean.put("labelLocationNo",warrantyGoodBean.getLabelLocationNo());
			goodBean.put("labelNo",warrantyGoodBean.getLabelNo());
			goodBean.put("checkStatus",warrantyGoodBean.getCheckStatus());
			goodBean.put("latitude",warrantyGoodBean.getLatitude());
			goodBean.put("longitude",warrantyGoodBean.getLongitude());
			goodBean.put("lastCheckUserNum",warrantyGoodBean.getLastCheckNum());
			goodBean.put("lastCheckUserName",warrantyGoodBean.getLastCheckOrgName());
			goodBean.put("lastCheckOrgNum",warrantyGoodBean.getLastCheckOrgNum());
			goodBean.put("lastCheckOrgName",warrantyGoodBean.getLastCheckOrgName());
			goodBean.put("lastCheckNum",warrantyGoodBean.getLastCheckNum());
			goodBean.put("printTimes",integerToStr(warrantyGoodBean.getPrintTimes()));
			goodBean.put("barcode",warrantyGoodBean.getBarcode());
			goodBean.put("oldPmCalss",warrantyGoodBean.getOldPmClass());
			goodBean.put("newPmCalss",warrantyGoodBean.getNewPmClass());
			goodBean.put("pmClass",warrantyGoodBean.getPmClass());
			goodBean.put("insuredFlag",warrantyGoodBean.getInsuredFlag());
			goodBean.put("createTime",dateToStr(warrantyGoodBean.getCreateTime()));
			goodBean.put("updateTime",dateToStr(warrantyGoodBean.getUpdateTime()));
			goodBean.put("expandDesc",warrantyGoodBean.getExpandDesc());
			goodBean.put("qcSheetNo",warrantyGoodBean.getQcSheetNo());
			goodBean.put("pmCode",warrantyGoodBean.getPmCode());
			goodBean.put("ctmDeclarationNo",warrantyGoodBean.getCtmDeclarationNo());
			dbList.add(goodBean);
		}}
		obj.put("warrantyGoodBean", dbList);//子项信息
		return obj;
	}
	
}
