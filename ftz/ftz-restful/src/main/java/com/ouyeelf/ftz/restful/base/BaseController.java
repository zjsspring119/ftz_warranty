package com.ouyeelf.ftz.restful.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;

import com.ouyeelf.ftz.common.constant.base.GlobalConstants;
import com.ouyeelf.ftz.common.web.BsPlatModelAndView;
import com.ouyeelf.ftz.common.web.Pagination;
//import com.bsteel.antelope.common.constant.base.LGWR;
/**
 * controller base class is the father of business controllers
 * @author xudm
 *
 */
public class BaseController { // extends LGWR{
	
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * create BsPlatModelAndView object and set view url
	 * @param viewName
	 * @return
	 */
	public BsPlatModelAndView newBsPlatModelAndView(String viewName) {
		BsPlatModelAndView mav = new BsPlatModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	/**
	 * create PageRequest object and initialize the object properties
	 * @return pageRequest
	 */
	public PageRequest newPageRequest(Pagination pagination){
		
		if(pagination.getPage() == null ){
			pagination.setPage(new Integer(GlobalConstants.DEFAULT_PAGE));
		}	
		if(pagination.getLimit() == null){
			pagination.setLimit(new Integer(GlobalConstants.DEFAULT_PAGE_SIZE));
		}	
		PageRequest pageRequest =new PageRequest(pagination.getPage(), pagination.getLimit());
		return pageRequest;
	}
	
	
	protected <T> T write(T t,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String callback = request.getParameter("callback");
		if (callback!=null){
	        //处理替换  
			String json = new ObjectMapper().writeValueAsString(t);
			response.setContentType("text/javascript;charset=UTF-8");
			response.getWriter().write(callback+"("+json+")");
			return null;
		}else{
			return t;
		}
	} 
	
}
