package com.ouyeelf.ftz.web.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ouyeelf.ftz.common.constant.CodesetConstants;
import com.ouyeelf.ftz.common.constant.UrlMappings;
import com.ouyeelf.ftz.common.exception.UserNoLoginException;
import com.ouyeelf.ftz.common.utils.RestLinkUtil;
import com.ouyeelf.ftz.common.web.BsPlatModelAndView;
import com.ouyeelf.ftz.web.base.BaseController;



@Controller
@RequestMapping(value="/warranty", produces="application/json;text/plain;charset=UTF-8",consumes = "application/json")
public class WarrantyController extends BaseController{
	
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 仓单查询头页面
	 * 
	 * @param searchVo
	 * @return
	 * @throws UserNoLoginException
	 */
	@RequestMapping(value = UrlMappings.FTZ_WARRANTY_MANAGE_QUERY)
	public ModelAndView queryWarrantyTop(
			HttpServletRequest request) throws UserNoLoginException {
		String flag = request.getParameter("flag");
		String result;
		JSONArray sysArray = null;
		try {
			result = RestLinkUtil.getInstance().bigDataPost("shdc_service",
					"woeReceipt", "/selectInfo", "");
			JSONObject json_Massage = JSONObject.fromObject(JSONObject
					.fromObject(result).get("message"));
			sysArray = json_Massage.getJSONArray("sysArray");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BsPlatModelAndView modelandview = null;
		if (flag != null && "1".equals(flag)) {
			modelandview = newBsPlatModelAndView(UrlMappings.FTZ_VIOLATE_WARRANTY_MANAGE_QUERY);
		} else {
			modelandview = newBsPlatModelAndView(UrlMappings.FTZ_WARRANTY_MANAGE_QUERY);
		}
		//String role = (String) getUseInfo().get(LSConstants.CURR_ROLE_TYPE);// 获取角色
		modelandview.addObject("sysArray", sysArray);
		//modelandview.addObject("menu", getMenuData(role));
		modelandview.addObject(CodesetConstants.S029, getCodeset(CodesetConstants.S029));
		return modelandview;
	}

}
