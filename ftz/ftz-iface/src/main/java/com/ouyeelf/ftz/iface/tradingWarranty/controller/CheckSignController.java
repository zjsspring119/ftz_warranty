package com.ouyeelf.ftz.iface.tradingWarranty.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ouyeelf.ftz.iface.tradingWarranty.service.TradingWarrantyServiceImpl;
import com.ouyeelf.ftz.iface.tradingWarranty.util.HttpUt;




@Controller
public class CheckSignController{

	
	
	//@Autowired
	//private TradingWarrantyService tradingWarrantyService;
	
	/**
	 * 仓单登记
	 * @param jsonData接口传入仓单登记信息（json格式）
	 * @return 执行接口结果（json格式）
	 */
	@RequestMapping(value="/checkSignController/warrantyRegistration", method=RequestMethod.POST)
	public void warrantyRegistration(@RequestBody String jsonData, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		boolean result = HttpUt.checkSign(jsonData);
		JSONObject json=new JSONObject();
		if(result){//验签成功
			TradingWarrantyServiceImpl  tradingWarrantyService=new TradingWarrantyServiceImpl();
			String responseResult=tradingWarrantyService.warrantyRegistration(jsonData);
			JSONObject jsonObject=JSONObject.fromObject(responseResult);
			String retResult=jsonObject.getString("retResult");
			String fail=jsonObject.getString("fail");
			String success=jsonObject.getString("success");
			json.accumulate("retResult", retResult);//返回状态
			json.accumulate("fail",fail);//注册失败仓单
			json.accumulate("success",success);//成功注册仓单
			json.accumulate("result", "1");//验签结果
			json.accumulate("msg",jsonObject.getString("msg"));//验签结果
		}else{
			json.accumulate("retResult", "0");//返回状态
			json.accumulate("fail", "[]");//注册失败仓单
			json.accumulate("success", "{}");//成功注册仓单
			json.accumulate("result", "0");//验签结果
			json.accumulate("msg", "验签失败");//验签结果
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json.toString());
		out.close();
	}
	/**
	 * 仓单注销
	 * @param jsonData接口传入仓单注销信息（json格式）
	 * @return 执行接口结果（json格式）
	 * @throws Exception 
	 */
	@RequestMapping(value="/checkSignController/warrantyCancel",method=RequestMethod.POST)
	public void warrantyCancel(@RequestBody String jsonData,HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		JSONObject json=new JSONObject();
		boolean result = HttpUt.checkSign(jsonData);
		if(result){
			TradingWarrantyServiceImpl  tradingWarrantyService=new TradingWarrantyServiceImpl();
			String responseResult=tradingWarrantyService.warrantyCancel(jsonData);
			JSONObject jsonObject=JSONObject.fromObject(responseResult);
			String retResult=jsonObject.getString("retResult");
			String fail=jsonObject.getString("fail");
			String success=jsonObject.getString("success");
			json.accumulate("retResult", retResult);//返回状态
			json.accumulate("fail",fail);//注册失败仓单
			json.accumulate("success",success);//成功注册仓单
			json.accumulate("result", "1");//验签结果
			json.accumulate("msg",jsonObject.getString("msg"));//验签结果
		}else{
			json.accumulate("retResult", "0");//返回状态
			json.accumulate("fail", "[]");//注册失败仓单
			json.accumulate("success", "{}");//成功注册仓单
			json.accumulate("result", "0");//验签结果
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json.toString());
		out.close();
	}

	/**
	 * 仓单冻结
	 * @param jsonData接口传入仓单冻结信息（json格式）
	 * @return 执行接口结果（json格式）
	 * @throws Exception 
	 */
	@RequestMapping(value="/checkSignController/warrantyFreeze",method=RequestMethod.POST)
	public void warrantyFreeze(@RequestBody String jsonData,HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		boolean result = HttpUt.checkSign(jsonData);
		JSONObject json=new JSONObject();
		if(result){
			TradingWarrantyServiceImpl  tradingWarrantyService=new TradingWarrantyServiceImpl();
			String responseResult=tradingWarrantyService.warrantyFreeze(jsonData);
			JSONObject jsonObject=JSONObject.fromObject(responseResult);
			String retResult=jsonObject.getString("retResult");
			String fail=jsonObject.getString("fail");
			String success=jsonObject.getString("success");
			json.accumulate("retResult", retResult);//返回状态
			json.accumulate("fail",fail);//注册失败仓单
			json.accumulate("success",success);//成功注册仓单
			json.accumulate("result", "1");//验签结果
			json.accumulate("msg",jsonObject.getString("msg"));
		}else{
			json.accumulate("retResult", "0");//返回状态
			json.accumulate("fail", "[]");//注册失败仓单
			json.accumulate("success", "{}");//成功注册仓单
			json.accumulate("result", "0");//验签结果
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json.toString());
		out.close();
	}

	/**
	 * 仓单挂失
	 * @param jsonData 接口传入仓单挂失信息（json格式）
	 * @return 执行接口结果（json格式）
	 * @throws Exception 
	 */
	@RequestMapping(value="/checkSignController/warrantyLoss",method=RequestMethod.POST)
	public void warrantyLoss(@RequestBody String jsonData,HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		boolean result = HttpUt.checkSign(jsonData);
		JSONObject json=new JSONObject();
		if(result){
			TradingWarrantyServiceImpl  tradingWarrantyService=new TradingWarrantyServiceImpl();
			String responseResult=tradingWarrantyService.warrantyLoss(jsonData);
			JSONObject jsonObject=JSONObject.fromObject(responseResult);
			String retResult=jsonObject.getString("retResult");
			String fail=jsonObject.getString("fail");
			String success=jsonObject.getString("success");
			json.accumulate("retResult", retResult);//返回状态
			json.accumulate("fail",fail);//注册失败仓单
			json.accumulate("success",success);//成功注册仓单
			json.accumulate("result", "1");//验签结果
			json.accumulate("msg",jsonObject.getString("msg"));
		}else{
			json.accumulate("retResult", "0");//返回状态
			json.accumulate("fail", "[]");//注册失败仓单
			json.accumulate("success", "{}");//成功注册仓单
			json.accumulate("result", "0");//验签结果
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json.toString());
		out.close();
	}

	/**
	 * 仓单锁定
	 * @param jsonData 接口传入仓单锁定信息（json格式）
	 * @return 执行接口结果（json 格式）
	 * @throws Exception 
	 */
	@RequestMapping(value="/checkSignController/warrantyLock",method=RequestMethod.POST)
	public void warrantyLock(@RequestBody String jsonData,HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		boolean result = HttpUt.checkSign(jsonData);
		JSONObject json=new JSONObject();
		if(result){
			TradingWarrantyServiceImpl  tradingWarrantyService=new TradingWarrantyServiceImpl();
			String responseResult=tradingWarrantyService.warrantyLock(jsonData);
			JSONObject jsonObject=JSONObject.fromObject(responseResult);
			String retResult=jsonObject.getString("retResult");
			String fail=jsonObject.getString("fail");
			String success=jsonObject.getString("success");
			json.accumulate("retResult", retResult);//返回状态
			json.accumulate("fail",fail);//注册失败仓单
			json.accumulate("success",success);//成功注册仓单
			json.accumulate("result", "1");//验签结果
			json.accumulate("msg",jsonObject.getString("msg"));
		}else{
			json.accumulate("retResult", "0");//返回状态
			json.accumulate("fail", "[]");//注册失败仓单
			json.accumulate("success", "{}");//成功注册仓单
			json.accumulate("result", "0");//验签结果
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json.toString());
		out.close();
	}

	/**
	 * 仓单解锁
	 * @param jsonData 接口传入仓单解锁信息（json格式）
	 * @return 执行接口结果（json 格式）
	 * @throws Exception 
	 */
	@RequestMapping(value="/checkSignController/warrantyUnLock",method=RequestMethod.POST)
	public void warrantyUnLock(@RequestBody String jsonData,HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		boolean result = HttpUt.checkSign(jsonData);
		JSONObject json=new JSONObject();
		if(result){
			TradingWarrantyServiceImpl  tradingWarrantyService=new TradingWarrantyServiceImpl();
			String responseResult=tradingWarrantyService.warrantyUnLock(jsonData);
			JSONObject jsonObject=JSONObject.fromObject(responseResult);
			String retResult=jsonObject.getString("retResult");
			String fail=jsonObject.getString("fail");
			String success=jsonObject.getString("success");
			json.accumulate("retResult", retResult);//返回状态
			json.accumulate("fail",fail);//注册失败仓单
			json.accumulate("success",success);//成功注册仓单
			json.accumulate("result", "1");//验签结果
			json.accumulate("msg",jsonObject.getString("msg"));
		}else{
			json.accumulate("retResult", "0");//返回状态
			json.accumulate("fail", "[]");//注册失败仓单
			json.accumulate("success", "{}");//成功注册仓单
			json.accumulate("result", "0");//验签结果
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json.toString());
		out.close();
	}

	/**
	 * 仓单过户
	 * @param jsonData 接口传入仓单过户信息（json格式）
	 * @return 执行接口结果（json 格式）
	 * @throws Exception 
	 */
	@RequestMapping(value="/checkSignController/warrantyTransfer",method=RequestMethod.POST)
	public void warrantyTransfer(@RequestBody String jsonData,HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		boolean result = HttpUt.checkSign(jsonData);
		JSONObject json=new JSONObject();
		if(result){
			TradingWarrantyServiceImpl  tradingWarrantyService=new TradingWarrantyServiceImpl();
			String responseResult=tradingWarrantyService.warrantyTransfer(jsonData);
			JSONObject jsonObject=JSONObject.fromObject(responseResult);
			String retResult=jsonObject.getString("retResult");
			String fail=jsonObject.getString("fail");
			String success=jsonObject.getString("success");
			json.accumulate("retResult", retResult);//返回状态
			json.accumulate("fail",fail);//注册失败仓单
			json.accumulate("success",success);//成功注册仓单
			json.accumulate("result", "1");//验签结果
			json.accumulate("msg",jsonObject.getString("msg"));
		}else{
			json.accumulate("retResult", "0");//返回状态
			json.accumulate("fail", "[]");//注册失败仓单
			json.accumulate("success", "{}");//成功注册仓单
			json.accumulate("result", "0");//验签结果
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json.toString());
		out.close();
	}

	/**
	 * 仓单查询
	 * @param jsonData 接口传入仓单查询信息（json格式）
	 * @return 执行接口结果（json格式）
	 * @throws Exception 
	 */
	@RequestMapping(value="/checkSignController/warrntyQuery",method=RequestMethod.POST)
	public void warrntyQuery(@RequestBody String jsonData,HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String responseResult="";
		boolean result = HttpUt.checkSign(jsonData);
		if(result){
			TradingWarrantyServiceImpl  tradingWarrantyService=new TradingWarrantyServiceImpl();
			responseResult=tradingWarrantyService.warrntyQuery(jsonData);
		}else{
			responseResult="验证签名信息失败";
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(responseResult);
		out.close();
	}
	
	/**
	 * 仓单比对
	 * @param jsonData 接口传入仓单比对信息（json格式）
	 * @return 执行接口结果（json格式）
	 * @throws Exception 
	 */
	@RequestMapping(value="/checkSignController/warrantyComparison",method=RequestMethod.POST)
	public void warrantyComparison(@RequestBody String jsonData,HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String responseResult="";
		boolean result = HttpUt.checkSign(jsonData);
		if(result){
			TradingWarrantyServiceImpl  tradingWarrantyService=new TradingWarrantyServiceImpl();
			responseResult=tradingWarrantyService.warrantyComparison(jsonData);
		}else{
			responseResult="验证签名信息失败";
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(responseResult);
		out.close();
	}
	
	
}
