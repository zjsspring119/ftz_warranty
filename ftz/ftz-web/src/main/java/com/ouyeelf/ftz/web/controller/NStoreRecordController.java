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
import com.ouyeelf.ftz.model.resource.NStoreRecordBean;
import com.ouyeelf.ftz.model.resource.query.NStoreRecordQueryBean;
import com.ouyeelf.ftz.persist.domain.NpageImpl;
import com.ouyeelf.ftz.service.NStoreRecordBeanService;
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
@RequestMapping(value="/nStoreRecord", produces="application/json;text/plain;charset=UTF-8",consumes = "application/json")
public class NStoreRecordController extends BaseController{
	
	
	protected final ILogger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private NStoreRecordBeanService nStoreRecordBeanService;
    
    /**
     * 仓单履历查询
     * @param jsonData
     * @return WarrantyVo
     * @throws Exception
     */
    @RequestMapping(value = UrlMappings.NSTORERECORD_LIST,method=RequestMethod.POST )
    @ResponseBody
   	public  ResultVo queryNStoreRecordList(@RequestBody String jsonData) throws Exception{
    	NStoreRecordQueryBean nStoreRecordQueryBean=(NStoreRecordQueryBean) JSONObject.toBean(JSONObject.fromObject(jsonData), NStoreRecordQueryBean.class);
    	Pagination pagination= new Pagination();
    	pagination.setLimit(nStoreRecordQueryBean.getLimit());
    	pagination.setPage(nStoreRecordQueryBean.getPage());
		PageRequest pageRequest = newPageRequest(pagination);	
       	//调用service
        Page<NStoreRecordBean> nStoreRecordPage=nStoreRecordBeanService.findAll(nStoreRecordQueryBean, pageRequest);
        	
       	//创建服务返回对象
        ResultVo resultVo = new ResultVo();
       	pagination.setCount(new Long(nStoreRecordPage.getTotalElements()));
   		pagination.setAllPage(nStoreRecordPage.getTotalPages());
   		resultVo.setResourceList(nStoreRecordPage.getContent());
   		resultVo.setPagination(pagination);
   		resultVo.setTimes(((NpageImpl<NStoreRecordBean>)nStoreRecordPage).getTimes());
   		return resultVo;
   	}
   
}
