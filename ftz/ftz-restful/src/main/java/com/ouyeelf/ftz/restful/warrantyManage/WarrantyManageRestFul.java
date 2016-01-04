package com.ouyeelf.ftz.restful.warrantyManage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ouyeelf.ftz.common.constant.UrlMappings;
import com.ouyeelf.ftz.common.web.Pagination;
import com.ouyeelf.ftz.model.base.ResultVo;
import com.ouyeelf.ftz.model.base.WarrantyVo;
import com.ouyeelf.ftz.model.resource.WarrantyBean;
import com.ouyeelf.ftz.model.resource.query.WarrantyQueryBean;
import com.ouyeelf.ftz.persist.domain.NpageImpl;
import com.ouyeelf.ftz.restful.base.BaseController;
import com.ouyeelf.ftz.service.ResourceService;
import com.ouyeelf.ftz.service.WarrantyBeanService;



@Controller
@RequestMapping(value="/warranty", produces="application/json;text/plain;charset=UTF-8",consumes = "application/json")
public class WarrantyManageRestFul extends BaseController{
	
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private WarrantyBeanService warrantyBeanService;

	/**
	 * 资源查询
	 * @param resourceQueryVo
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception 
	 */
    @RequestMapping(value = UrlMappings.QUERY_WARRANTY )
	public @ResponseBody WarrantyVo queryResource(@ModelAttribute WarrantyQueryBean warrantyQueryBean, HttpServletRequest request,HttpServletResponse response) throws Exception{
    	//创建分页对象
    	Pagination pagination= new Pagination();
    	pagination.setLimit(warrantyQueryBean.getLimit());
    	pagination.setPage(pagination.getPage());
		PageRequest pageRequest = newPageRequest(pagination);		
    	//调用service
     	Page<WarrantyBean> resources= resourceService.queryResource(warrantyQueryBean, pageRequest);
    	//创建服务返回对象
    	WarrantyVo resourceVo = new WarrantyVo();
    	pagination.setCount(new Long(resources.getTotalElements()));
		pagination.setAllPage(resources.getTotalPages());
		resourceVo.setResourceList(resources.getContent());
		resourceVo.setPagination(pagination);
		resourceVo.setTimes(((NpageImpl<WarrantyBean>)resources).getTimes());
		return write(resourceVo,request,response);
	}
    
  /*  *//**
     * 查询条件处理
     * @param resourceQueryVo
     * @param resourceQueryBean
     * @param pagination
     * @throws Exception 
     *//*
    public void queryConditionConvert(WarrantyQueryVo warrantyQueryVo,
    		WarrantyQueryBean WarrantyQueryBean,Pagination pagination) throws Exception{ 	
    	
    	try {
    		//
    		if (StringUtils.isBlank(warrantyQueryVo.getSortName()) 
    				|| StringUtils.isBlank(warrantyQueryVo.getSortValue())){
    			WarrantyQueryBean.setSortName("");  //入库日期和资源号
    			WarrantyQueryBean.setSortValue("");  //倒序
    		}
		} catch (Exception e) {
			logger.info("QueryRescore conditions for processing error");
			throw e;
		}
    }
    */
    
    /**
     * 仓单查询
     * @param jsonData
     * *jsonData:{warrantyNo:"仓单号"} ，仓单号可以是单个仓单号，或者是多个仓单号以逗号分隔
     * @return WarrantyVo
     * @throws Exception
     */
    @RequestMapping(value = UrlMappings.WARRANTY_LIST,method=RequestMethod.POST )
    @ResponseBody
   	public  ResultVo queryWarrantyList(@RequestBody String jsonData) throws Exception{
    	WarrantyQueryBean warrantyQueryBean=(WarrantyQueryBean) JSONObject.toBean(JSONObject.fromObject(jsonData), WarrantyQueryBean.class);
    	Pagination pagination= new Pagination();
    	pagination.setLimit(warrantyQueryBean.getLimit());
    	pagination.setPage(warrantyQueryBean.getPage());
		PageRequest pageRequest = newPageRequest(pagination);	
		long startTime = System.currentTimeMillis();
       	//调用service
        Page<WarrantyBean> warrantyPage= warrantyBeanService.findAll(warrantyQueryBean, pageRequest);
        	
       	//创建服务返回对象
        ResultVo resultVo = new ResultVo();
       	pagination.setCount(new Long(warrantyPage.getTotalElements()));
   		pagination.setAllPage(warrantyPage.getTotalPages());
   		resultVo.setResourceList(warrantyPage.getContent());
   		resultVo.setPagination(pagination);
   		resultVo.setTimes(((NpageImpl<WarrantyBean>)warrantyPage).getTimes());
   		long endTime = System.currentTimeMillis();
   		logger.info("查询时间："+(endTime-startTime));
   		return resultVo;
   	}
    
   
    
    
    
      
    
    
    
//    /**
//     * 资源明细
//     * @param resDetailQueryVo
//     * @return
//     * @throws Exception 
//     */
//    @RequestMapping(value = UrlMappings.DETAIL_RESOURCE,produces="application/json;text/plain;charset=UTF-8")
//   	public @ResponseBody  ResDetailVo detailResource(@ModelAttribute ResDetailQueryVo resDetailQueryVo,HttpServletRequest request,HttpServletResponse response) throws Exception{
//    	ResDetailQueryBean reDetail = new ResDetailQueryBean();
//    	if(null != resDetailQueryVo && StringUtils.isNotBlank(resDetailQueryVo.getHtfphm())){
//    		reDetail.setId(resDetailQueryVo.getHtfphm());
//    	}
//    	Resource resource = resourceService.resDetail(reDetail);
//    	ResDetailVo resDetailVo = new ResDetailVo();
//    	resDetailVo.setResource(resource);
//
//    	return write(resDetailVo,request,response);
//    }
//    
//    /**
//     * 资源推荐
//     * @param resRecomQueryVo
//     * @return
//     * @throws Exception 
//     */
//    @RequestMapping(value = UrlMappings.RECOMMEND_RESOURCE,produces="application/json;text/plain;charset=UTF-8")
//   	public @ResponseBody  ResRecomVo ResRecommend(@ModelAttribute ResRecomQueryVo resRecomQueryVo,HttpServletRequest request,HttpServletResponse response) throws Exception{
//    	ResRecomQueryBean resRecomQueryBean = new ResRecomQueryBean();
//    	PageRequest pageRequest = null;
//    	//创建分页对象
//    	Pagination pagination= new Pagination();
//    	try{
//    		if(resRecomQueryVo != null){
//	    		if(resRecomQueryVo.getLimit() == null || resRecomQueryVo.getLimit() == 0){
//	    			resRecomQueryVo.setLimit(ResRecommendcount);
//	    		}
//	    		if(resRecomQueryVo.getPage() == null || resRecomQueryVo.getPage() == 0){
//	    			resRecomQueryVo.setPage(1);
//	    		}
//	    		//处理分页
//	    		if(resRecomQueryVo.getPage() != null && resRecomQueryVo.getPage() != 0){
//	    			resRecomQueryVo.setPage(resRecomQueryVo.getPage()-1);
//	    		}
//	    		
//	    		resRecomQueryVo.setSortName("rkrq,zyh");  //入库日期和资源号
//	    		resRecomQueryVo.setSortValue("desc");  //倒序
//    		}
//    		
//			//处理分页数据
//			BeanUtils.copyProperties(pagination, resRecomQueryVo);
//			pageRequest = newPageRequest(pagination);		
//    		BeanUtils.copyProperties(resRecomQueryBean, resRecomQueryVo);
//    		
//    	}catch(Exception e){
//    		logger.info("Query resourceRecommend conditions for processing error");
//    	}
//    	Page<Resource> resources = resourceService.queryResRecom(resRecomQueryBean,pageRequest);
//    	
//    	//构建返回对象
//    	ResRecomVo resRecomVo = new ResRecomVo();
//    	resRecomVo.setResourceList(resources.getContent());
//    	pagination.setCount(new Long(resources.getTotalElements()));
//    	pagination.setAllPage(resources.getTotalPages());
//    	resRecomVo.setResourceList(resources.getContent());
//    	resRecomVo.setPagination(pagination);
//    	return write(resRecomVo, request, response);
//    }
//    
//    /**
//     * 根据种类分组
//     * @throws Exception 
//     */
//    @RequestMapping(value = UrlMappings.RESGROUPBYDL,produces="application/json;text/plain;charset=UTF-8")
//    public @ResponseBody GroupDlVo resGroupByDl(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
//    	List<DlGroup> groupDlList = resourceService.queryGroupDl();
//    	GroupDlVo gdv = new GroupDlVo(groupDlList);
//    	return write(gdv, request, response);
//    }
//    
//    /**
//     * 不分页的查询
//     * @throws Exception 
//     */
//    @SuppressWarnings({ "unchecked", "finally" })
//	@RequestMapping(value = UrlMappings.QUERYALLRES ,produces="application/json;text/plain;charset=UTF-8")
//  	public @ResponseBody ResourceVo2 queryAllRes(@ModelAttribute ResourceQueryVo resourceQueryVo, HttpServletRequest request,HttpServletResponse response) throws Exception{
//    	//创建服务返回对象
//    	ResourceVo2 resourceVo2 = new ResourceVo2();
//    	try{
//	    	ResourceQueryBean resourceQueryBean = new ResourceQueryBean();
//	    	//处理查询条件
//			if(resourceQueryVo != null){
//				queryConditionConvert(resourceQueryVo, resourceQueryBean,null);			
//			}
//	    	//调用service
//			Map<String, Object> map = resourceService.queryAllRes(resourceQueryBean);
//			List<Resource> list = (List<Resource>)map.get("result");
//			this.changeList(list);
//			long times = ((Long)map.get("times")).longValue();;
//			resourceVo2.setResourceList(list);
//			resourceVo2.setTimes(times);
//    	}catch(Exception e){
//			e.printStackTrace();
//			resourceVo2 = null;
//		}finally{
//			return write(resourceVo2,request,response);
//		}
//    }
//    @SuppressWarnings("unchecked")
//    public static void changeList(List<Resource> resources){
//    	for(Resource rs : resources){
//			List<LinkedHashMap<String,Double>> zys=(List<LinkedHashMap<String,Double>>) rs.getZyhResource();
//			  Collections.sort(zys, new Comparator<LinkedHashMap<String, Double>>(){
//			   public int compare(LinkedHashMap<String, Double> zyhResource1,LinkedHashMap<String, Double> zyhResource2){
//			    return zyhResource1.get("sl2").compareTo(zyhResource2.get("sl2"));
//			   }
//			  });
//		}
//    }
//    
//    
//    /**
//     * 查询数量
//     * @throws Exception 
//     */
//    @RequestMapping(value = UrlMappings.QUERTRESCOUNT ,produces="application/json;text/plain;charset=UTF-8")
//  	public @ResponseBody Integer queryResCount(@ModelAttribute ResourceQueryVo resourceQueryVo, HttpServletRequest request,HttpServletResponse response) throws Exception{
//    	ResourceQueryBean resourceQueryBean = new ResourceQueryBean();
//    	
//    	//处理查询条件
//		if(resourceQueryVo != null){
//			queryConditionConvert(resourceQueryVo, resourceQueryBean,null);			
//		}
//		
//    	//调用service
//     	Integer count= resourceService.queryResCount(resourceQueryBean);
//		return write(count,request,response);
//    }
//    
//    /**
//     * 统计min(a.dj3)和sum(a.sl2)
//     * @param resourceQueryVo
//     * @param request
//     * @param response
//     * @throws Exception
//     */
//    @SuppressWarnings("finally")
//	@RequestMapping(value = UrlMappings.STATRESOURCE ,produces="application/json;text/plain;charset=UTF-8")
//  	public @ResponseBody StatVo statResource(@ModelAttribute ResourceQueryVo resourceQueryVo, HttpServletRequest 
//  			request,HttpServletResponse response) throws Exception{
//    	//创建返回对象
//    	StatVo sv = new StatVo();
//    	try{
//	    	ResourceQueryBean resourceQueryBean = new ResourceQueryBean();
//	    	//处理查询条件
//			if(resourceQueryVo != null){
//				queryConditionConvert(resourceQueryVo, resourceQueryBean,null);			
//			}
//	    	//调用service
//			Map<String, Double> result = resourceService.statResource(resourceQueryBean);
//			Double d = result.get("sumSl2");
//			sv.setMinDj3(result.get("minDj3"));
//			sv.setSumSl2(Math.round(d*1000)/1000.0);
//    	}catch(Exception e){
//			e.printStackTrace();
//			sv = null;
//		}finally{
//			return write(sv,request,response);
//		}
//    }
}
