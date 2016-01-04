package com.ouyeelf.ftz.web.base;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ouyeelf.ftz.common.constant.LSConstants;
import com.ouyeelf.ftz.common.constant.base.GlobalConstants;
import com.ouyeelf.ftz.common.exception.UserNoLoginException;
import com.ouyeelf.ftz.common.web.BsPlatModelAndView;
import com.ouyeelf.ftz.common.web.Pagination;
import com.ouyeelf.ftz.model.domain.codeset.CodeItem;
import com.ouyeelf.ftz.model.domain.codeset.Codeset;
import com.ouyeelf.ftz.model.vo.codeset.CodeItemVo;
import com.ouyeelf.ftz.model.vo.codeset.CodesetVo;
import com.ouyeelf.ftz.service.basicManage.codeset.CodeItemService;
import com.ouyeelf.ftz.service.basicManage.codeset.CodesetService;
import com.waxberry.WaxberryContext;
import com.waxberry.app.IAppContext;
//import com.bsteel.antelope.common.constant.base.LGWR;
/**
 * controller base class is the father of business controllers
 * @author xudm
 *
 */
public class BaseController { // extends LGWR{
	
	
	@Autowired
	private WaxberryContext waxberryContext;
	
	@Autowired
	private CodesetService codesetService;
	
	@Autowired
	private CodeItemService codeItemService;
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
	
	/**
	 * 根据代码集编码获取代码信息
	 * 
	 * @param codesetCode
	 * @return
	 */
	protected CodesetVo getCodeset(String codesetCode) {
		IAppContext appContext = waxberryContext.getAppContext();
		CodesetVo returnCode = null;
		CodesetVo codeset = (CodesetVo) appContext.getAttribute("BS.CODE."
				+ codesetCode);
		if (null == codeset) {
			codeset = getCodeFromDb(codesetCode);
			appContext.setAttribute("BS.CODE." + codesetCode, codeset);
		}
		if (codeset.getCodeItemSize() > 20 ) {
			returnCode = new CodesetVo();
			String[] ignoreProperties = {"codeItems"};
			BeanUtils.copyProperties(codeset, returnCode, ignoreProperties);
		}else{
			returnCode = codeset;
		}
		return returnCode;
	}
	
	/**
	 * 根据代码集编码从 db中获取代码信息
	 * 
	 * @param codesetCode
	 * @return
	 */
	private CodesetVo getCodeFromDb(String codesetCode) {
		Codeset codeset = codesetService.findOne(codesetCode);
		List<CodeItem> codeItems = codeItemService
				.findByCodesetCodeAndItemStatus(codesetCode,LSConstants.BOOLEAN_TRUE);
		// copy main bean's properities
		CodesetVo codesetVo = new CodesetVo();
		if (codeset != null) {
			BeanUtils.copyProperties(codeset, codesetVo);
		}
		// copy sub bean's properities
		List<CodeItemVo> codeItemVos = new ArrayList<CodeItemVo>();
		for (CodeItem codeItem : codeItems) {
			CodeItemVo codeItemVo = new CodeItemVo();
			BeanUtils.copyProperties(codeItem, codeItemVo);
			codeItemVos.add(codeItemVo);
		}
		codesetVo.setCodeItems(codeItemVos);
		codesetVo.setCodeItemSize(codeItemVos.size());
		return codesetVo;
	}
	
	@ExceptionHandler
	public @ResponseBody
	BsPlatModelAndView userNoLogin(UserNoLoginException e,HttpServletRequest request) {
		//BsPlatModelAndView modelandview = newBsPlatModelAndView("redirect:"+UrlMappings.MAIN_HOME_PAGE);
		BsPlatModelAndView modelandview = newBsPlatModelAndView("redirect:/loginOut");
		String query=request.getQueryString();
		if (query==null || query.trim().length()<=0){
			modelandview.addObject("param1",request.getServletPath());
		}else{
			modelandview.addObject("param1",request.getServletPath()+"?"+query);
		}
		return modelandview;
	}
}
