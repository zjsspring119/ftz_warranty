package com.ouyeelf.ftz.service.common;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * **************************************************
 *@Copyrigth(c) by ftzWarranty Co., Ltd
 *@Create Date 2015-9-1 
 *@author zjs
 *@File Name：
 *@Last version：1.0
 *@Function:公共信息查询service
 *@Change Log:
 **************************************************
 */
@Service("commonInfoService")
public class CommonInfoService {
	
	@Autowired
	private BusinessCommon businessCommon;
	
	
	public String queryCompayByRole(String role){
		List<Object[]> compayList = businessCommon.selectCodeAndName(role);//会员信息
		JSONArray compayArray = JSONArray.fromObject(compayList);
		JSONObject object = new JSONObject();
		object.element("compayArray", compayArray);
		return object.toString();
	}
	
	
	

}
