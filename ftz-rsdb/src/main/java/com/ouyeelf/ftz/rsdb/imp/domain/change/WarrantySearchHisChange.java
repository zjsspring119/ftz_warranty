package com.ouyeelf.ftz.rsdb.imp.domain.change;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.ouyeelf.ftz.model.mdbean.WarrantySearchHisBean;


/**
 * **************************************************
 *@Copyrigth(c) by baosight Co., Ltd
 *@Create Date 2015-2-3 
 *@author zjs
 *@File Name：
 *@Last version：1.0
 *@Function: WarrantySearchHisBean 转化成mongodb存储warrantySearchHisBean
 *@Change Log:
 **************************************************
 */
public class WarrantySearchHisChange extends BaseChange {
	public static DBObject change(WarrantySearchHisBean warrantySearchHisBean){
		DBObject obj = new BasicDBObject();
		obj.put("id",warrantySearchHisBean.getId());//id
		obj.put("area",warrantySearchHisBean.getArea());//查询来源地区
		obj.put("ipAddr",warrantySearchHisBean.getIpAddr());//查询来源IP
		obj.put("keyWord",warrantySearchHisBean.getKeyWord());//查询关键字
		obj.put("orgSysNo",warrantySearchHisBean.getOrgSysNo());//交易平台代码
		obj.put("orgSysName",warrantySearchHisBean.getOrgSysName());//交易平台名称
		obj.put("prdCataCode",warrantySearchHisBean.getPrdCataCode());//品种代码
		obj.put("prdCataName",warrantySearchHisBean.getPrdCataName());//品种名称
		obj.put("searcher",warrantySearchHisBean.getSearcher());//查询人代码
		obj.put("searchTime",dateToStr(warrantySearchHisBean.getSearchTime()));//查询人代码
		obj.put("num",integerToStr(warrantySearchHisBean.getNum()));//数量
		obj.put("unit",warrantySearchHisBean.getUnit());//数量单位
		obj.put("warrantyNo",warrantySearchHisBean.getWarrantyNo());//仓单号
		obj.put("warrantyStatus",warrantySearchHisBean.getWarrantyStatus());//仓单状态
		obj.put("weight",bigDecimalToStr(warrantySearchHisBean.getWeight()));//总重量
		obj.put("weightUnit",warrantySearchHisBean.getWeightUnit());//重量单位
		obj.put("warehouseNum",warrantySearchHisBean.getWarehouseNum());//仓库代码
		obj.put("warehouseName",warrantySearchHisBean.getWarehouseName());//仓库名称
		obj.put("warrantyType",warrantySearchHisBean.getWarrantyType());//仓库类型
		obj.put("taxedFlag",warrantySearchHisBean.getTaxedFlag());//完税标记
		if(null!=warrantySearchHisBean.getFavorites() && warrantySearchHisBean.getFavorites().length>0){
			obj.put("favorites", warrantySearchHisBean.getFavorites());
		}
		
		return obj;
	}
	
	
	
}
