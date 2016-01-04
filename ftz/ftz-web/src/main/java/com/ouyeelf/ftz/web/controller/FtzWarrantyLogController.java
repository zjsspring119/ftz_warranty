package com.ouyeelf.ftz.web.controller;

import net.sf.json.JSONObject;

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
import com.ouyeelf.ftz.model.resource.FtzWarrantyLogBean;
import com.ouyeelf.ftz.model.resource.query.FtzWarrantyLogQueryBean;
import com.ouyeelf.ftz.persist.domain.NpageImpl;
import com.ouyeelf.ftz.service.FtzWarrantyLogBeanService;
import com.ouyeelf.ftz.web.base.BaseController;
import com.ouyeelf.ftz.web.vo.ResultVo;
import com.waxberry.log.ILogger;
import com.waxberry.log.LoggerFactory;
/**
 * 
 * **************************************************
 *@Copyrigth(c) by baosight Co., Ltd
 *@Create Date 2015-2-10 
 *@author zjs
 *@File Name：
 *@Last version：1.0
 *@Function: 仓单履历
 *@Change Log:
 **************************************************
 */
@Controller
@RequestMapping(value="/ftzWarrantyLog", produces="application/json;text/plain;charset=UTF-8",consumes = "application/json")
public class FtzWarrantyLogController extends BaseController{
	
	
	protected final ILogger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FtzWarrantyLogBeanService ftzWarrantyLogBeanService;
    
    /**
     * 仓单履历查询
     * @param jsonData
     * @return WarrantyVo
     * @throws Exception
     */
    @RequestMapping(value = UrlMappings.FTZ_WARRANTY_LOG_LIST,method=RequestMethod.POST )
    @ResponseBody
   	public  ResultVo queryNStoreRecordList(@RequestBody String jsonData) throws Exception{
    	FtzWarrantyLogQueryBean ftzWarrantyLogQueryBean=(FtzWarrantyLogQueryBean) JSONObject.toBean(JSONObject.fromObject(jsonData), FtzWarrantyLogQueryBean.class);
    	Pagination pagination= new Pagination();
    	pagination.setLimit(ftzWarrantyLogQueryBean.getLimit());
    	pagination.setPage(ftzWarrantyLogQueryBean.getPage());
		PageRequest pageRequest = newPageRequest(pagination);	
       	//调用service
        Page<FtzWarrantyLogBean> ftzWarrantyLogPage=ftzWarrantyLogBeanService.findAll(ftzWarrantyLogQueryBean, pageRequest);
        	
       	//创建服务返回对象
        ResultVo resultVo = new ResultVo();
       	pagination.setCount(new Long(ftzWarrantyLogPage.getTotalElements()));
   		pagination.setAllPage(ftzWarrantyLogPage.getTotalPages());
   		resultVo.setResourceList(ftzWarrantyLogPage.getContent());
   		resultVo.setPagination(pagination);
   		resultVo.setTimes(((NpageImpl<FtzWarrantyLogBean>)ftzWarrantyLogPage).getTimes());
   		return resultVo;
   	}
   
}
