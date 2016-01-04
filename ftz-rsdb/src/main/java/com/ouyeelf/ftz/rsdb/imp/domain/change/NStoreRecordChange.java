package com.ouyeelf.ftz.rsdb.imp.domain.change;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.ouyeelf.ftz.model.mdbean.NStoreRecordBean;


/**
 * **************************************************
 *@Copyrigth(c) by baosight Co., Ltd
 *@Create Date 2015-2-3 
 *@author zjs
 *@File Name：
 *@Last version：1.0
 *@Function: NStoreRecordBean 转化成mongodb存储nStoreRecordBean
 *@Change Log:
 **************************************************
 */
public class NStoreRecordChange extends BaseChange {
	public static DBObject change(NStoreRecordBean nStoreRecordBean){
		DBObject obj = new BasicDBObject();
		obj.put("id",nStoreRecordBean.getId());//id
		obj.put("storeNo",nStoreRecordBean.getStoreNo());//仓单号
		obj.put("stockPeopleCode",nStoreRecordBean.getStockPeopleCode());//存货人代码
		obj.put("stockPeopleName",nStoreRecordBean.getStockPeopleName());//存货人名称
		obj.put("zqPeopleCode",nStoreRecordBean.getZqPeopleCode());//质权人代码
		obj.put("zqPeopleName",nStoreRecordBean.getZqPeopleName());//质权人名称
		obj.put("storeCode",nStoreRecordBean.getStoreCode());//仓库代码
		obj.put("storeName",nStoreRecordBean.getStoreName());//仓库名称
		obj.put("generateDate",dateToStr(nStoreRecordBean.getGenerateDate()));//生成日期
		obj.put("status",nStoreRecordBean.getStatus());//状态
		obj.put("remark",nStoreRecordBean.getRemark());//描述

		return obj;
	}
	
	
	
}
