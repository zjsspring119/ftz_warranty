package com.ouyeelf.ftz.restful.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ouyeelf.ftz.model.base.Result;
import com.ouyeelf.ftz.restful.base.BaseController;


@Controller
@RequestMapping(value="/common", produces="application/json;text/plain;charset=UTF-8",consumes = "application/json")
public class CommonRestful  extends BaseController {
	
	
	
	/**
	 * 根据角色获取对应的的会员信息
	 * @param jsonData
	 * @return
	 */
	@RequestMapping(value="/companyInfo",method=RequestMethod.POST)
	@ResponseBody
	//接收大数据
	public Result selectInfo(@RequestBody String jsonData){
		logger.info("根据角色获取对应的的会员信息："+jsonData);
		String resultJson="";//ftzWoeObjectionService.selectInfo();
		logger.info("查询结果:"+resultJson);
		return new Result(resultJson);
	}
}
