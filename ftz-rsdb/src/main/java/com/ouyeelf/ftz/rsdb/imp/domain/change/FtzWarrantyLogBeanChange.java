package com.ouyeelf.ftz.rsdb.imp.domain.change;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.ouyeelf.ftz.model.mdbean.FtzWarrantyLogBean;

public class FtzWarrantyLogBeanChange extends BaseChange {
	public static DBObject change(FtzWarrantyLogBean ftzWarrantyLogBean){
		DBObject obj = new BasicDBObject();
	

		
		obj.put("id", ftzWarrantyLogBean.getId());
		obj.put("warrantyNo", ftzWarrantyLogBean.getWarrantyNo());//仓单号
		obj.put("orgBillNo", ftzWarrantyLogBean.getOrgBillNo());//交易平台单据号
		obj.put("newStatus", ftzWarrantyLogBean.getNewStatus());//新仓单状态
		obj.put("oldStatus", ftzWarrantyLogBean.getOldStatus());//老仓单状态
		obj.put("prdCataName", ftzWarrantyLogBean.getPrdCataName());//品种名称
		obj.put("prdCataCode", ftzWarrantyLogBean.getPrdCataCode());//品种代码
		obj.put("num", integerToStr(ftzWarrantyLogBean.getNum()));//总数量
		obj.put("unit", ftzWarrantyLogBean.getUnit());//数量单位
		obj.put("weight", bigDecimalToStr(ftzWarrantyLogBean.getWeight()));//总重量
		obj.put("weightUnit", ftzWarrantyLogBean.getWeightUnit());//重量单位
		obj.put("orgCustCode", ftzWarrantyLogBean.getOrgCustCode());//原货主代码
		obj.put("orgCustName", ftzWarrantyLogBean.getOrgCustName());//原货主名称
		obj.put("newCustCode", ftzWarrantyLogBean.getNewCustCode());//新货主代码
		obj.put("newCustName", ftzWarrantyLogBean.getNewCustName());//新货主名称
		obj.put("bussinessTime", ftzWarrantyLogBean.getBussinessTime());//成交时间(YYYY-MM-DD HH:MI:SS)
		obj.put("createTime", dateToStr(ftzWarrantyLogBean.getCreateTime()));//新建时间
		obj.put("compareFlag", ftzWarrantyLogBean.getCompareFlag());//比对标记
		obj.put("isSynchronize", ftzWarrantyLogBean.getIsSynchronize());// 是否被同步mongodb（1-已同步）
		obj.put("remark", ftzWarrantyLogBean.getRemark());// 备注
		
		
		return obj;
	}
	
	
	

}
