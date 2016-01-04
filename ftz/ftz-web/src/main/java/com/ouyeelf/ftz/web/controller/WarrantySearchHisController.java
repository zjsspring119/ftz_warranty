package com.ouyeelf.ftz.web.controller;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ouyeelf.ftz.common.constant.UrlMappings;
import com.ouyeelf.ftz.common.web.Pagination;
import com.ouyeelf.ftz.model.resource.WarrantySearchHisBean;
import com.ouyeelf.ftz.model.resource.query.WarrantySearchHisQuery;
import com.ouyeelf.ftz.persist.domain.NpageImpl;
import com.ouyeelf.ftz.service.WarrantySearchHisBeanService;
import com.ouyeelf.ftz.web.base.BaseController;
import com.ouyeelf.ftz.web.vo.ResultVo;

/**
 * **************************************************
 *@Copyrigth(c) by baosight Co., Ltd
 *@Create Date 2015-2-10 
 *@author zjs
 *@File Name：
 *@Last version：1.0
 *@Function:仓单查询历史
 *@Change Log:
 **************************************************
 *@Controller
@RequestMapping(value="/warranty", produces="application/json;text/plain;charset=UTF-8",consumes = "application/json")
 */
@Controller
@RequestMapping(value="/warrantySearchHis",produces="application/json;text/plain;charset=UTF-8",consumes="application/json")
public class WarrantySearchHisController extends BaseController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WarrantySearchHisBeanService warrantySearchHisBeanService;
	
	/**
	 * 查询仓单查询历史
	 * @param jsonData
	 * @return
	 */
	@RequestMapping(value=UrlMappings.WARRANTYSEARCHHIS_LIST, method=RequestMethod.POST)
	@ResponseBody
	public ResultVo warrantySearchHisList(@RequestBody String jsonData){

		WarrantySearchHisQuery warrantySearchHisQuery=(WarrantySearchHisQuery) JSONObject.toBean(JSONObject.fromObject(jsonData), WarrantySearchHisQuery.class);
		Pagination pagination= new Pagination();
    	pagination.setLimit(warrantySearchHisQuery.getLimit());
    	pagination.setPage(warrantySearchHisQuery.getPage());
		PageRequest pageRequest = newPageRequest(pagination);	
       	//调用service
        Page<WarrantySearchHisBean> warrantySearchHisPage= warrantySearchHisBeanService.findAll(warrantySearchHisQuery, pageRequest);
        	
       	//创建服务返回对象
        ResultVo resultVo = new ResultVo();
       	pagination.setCount(new Long(warrantySearchHisPage.getTotalElements()));
   		pagination.setAllPage(warrantySearchHisPage.getTotalPages());
   		resultVo.setResourceList(warrantySearchHisPage.getContent());
   		resultVo.setPagination(pagination);
   		resultVo.setTimes(((NpageImpl<WarrantySearchHisBean>)warrantySearchHisPage).getTimes());
   		return resultVo;
	}
	
	
	
	
}
