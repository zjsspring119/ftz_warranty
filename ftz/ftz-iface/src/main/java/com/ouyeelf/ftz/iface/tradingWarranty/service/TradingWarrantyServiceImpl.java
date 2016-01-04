package com.ouyeelf.ftz.iface.tradingWarranty.service;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ouyeelf.ftz.common.constant.LSConstants;
import com.ouyeelf.ftz.common.constant.Operation;
import com.ouyeelf.ftz.common.utils.GuidUtil;
import com.ouyeelf.ftz.common.utils.IfaceLogUtil;
import com.ouyeelf.ftz.common.utils.StringUtil;
import com.ouyeelf.ftz.model.domain.warranty.FtzWarrantyLog;
import com.ouyeelf.ftz.model.mdbean.WarrantyBean;
import com.ouyeelf.ftz.model.model.warranty.ResultMsg;
import com.ouyeelf.ftz.model.model.warranty.ResultMsgB;
import com.ouyeelf.ftz.model.model.warranty.WarrantyGood;
import com.ouyeelf.ftz.model.model.warranty.WarrantyMain;
import com.ouyeelf.ftz.model.model.warranty.WarrantyOthers;
import com.ouyeelf.ftz.service.common.util.CommonIs;
import com.ouyeelf.ftz.service.mongdb.MongoSynDataService;
import com.ouyeelf.ftz.service.warrantyRegister.RegisterService;
import com.waxberry.exception.BusinessException;
import com.waxberry.spring.util.SpringContextUtil;

/**
 * @Copyright (c) by baoSight
 * @All right reserved.
 * @Create Date: 2015/01/05
 * @Create Author: zjs
 * @File Name: TradingWarrantyService
 * @Last version: 1.0
 * @Function: 动产权属平台(自贸区)webservice仓单接口实现.<br>
 * @Last Update Date:
 * @Change Log:
 */
//@Service("tradingWarrantyService")
public class TradingWarrantyServiceImpl implements TradingWarrantyService {

	private static Log log=LogFactory.getLog(TradingWarrantyServiceImpl.class);
	private RegisterService registerService = SpringContextUtil.getBean(RegisterService.class);
	private MongoSynDataService  mongoSynDataService  = SpringContextUtil.getBean(MongoSynDataService.class);
	/*@Autowired
	private RegisterService registerService;
	@Autowired
	private MongoSynDataService  mongoSynDataService;*/
	/**
	 *仓单登记 
	 *
	 */
	public String warrantyRegistration(String jsonData) {
		log.info("执行仓登记....");
		log.info("输入参数###"+jsonData);
		StringBuffer batchNo = new StringBuffer(GuidUtil.newGuid());
		IfaceLogUtil.getInstance().saveIfaceLog("TradingWarrantyService","warrantyRegistration",batchNo.toString(), jsonData);
		ResultMsg msg = new ResultMsg();//返回执行结果对象
		ResultMsgB msgB = new ResultMsgB();//返回执行结果对象
		JSONObject mainJson = JSONObject.fromObject(jsonData);
		JSONObject successObj=new JSONObject();
		JSONArray failArry=new JSONArray();
		List<WarrantyBean> beans=new ArrayList<WarrantyBean>();
		List<FtzWarrantyLog> ftzWarrantyLogs=new ArrayList<FtzWarrantyLog>();
		int num=0;
		//判断传过来的数组数据不能为空
		String failmsg="";
			if(!mainJson.isEmpty()){
				JSONArray jsonArray=mainJson.getJSONArray("register");
				if(jsonArray!=null){
				for(int j=0;j<jsonArray.size();j++){
					JSONObject warrantyMain = jsonArray.getJSONObject(j).getJSONObject("warrantyMain");
					JSONArray warrantyGood = jsonArray.getJSONObject(j).getJSONArray("warrantyGood");
					WarrantyMain wm = (WarrantyMain)JSONObject.toBean(warrantyMain,WarrantyMain.class);
					convertWarrantyType(wm);//转换仓单类型
					List<WarrantyGood> wglist=new ArrayList<WarrantyGood>();
					List<WarrantyGood> wglistB=new ArrayList<WarrantyGood>();
					for(int i=0;i<warrantyGood.size();i++){
						WarrantyGood ws = (WarrantyGood)JSONObject.toBean(warrantyGood.getJSONObject(i),WarrantyGood.class);
						JSONObject jsonObject=initExpandDesc(warrantyGood.getJSONObject(i).get("expandDesc").toString());
						ws.setExpandDesc(jsonObject+"");
						ws.setId(GuidUtil.newGuid());
						wglist.add(ws);
						//判断子项数据不能为空
						if(CommonIs.registerGoods(ws)){
							wglistB.add(ws);
						}
					}
					//首先保存 临时表
					msg=registerService.saveAll(wm, wglist);
					//当临时表 保存成功之后保存正式表
					if("1".equals(msg.getRetResult())){
						//判断主项数据不能为空且子项不能为空
						if(CommonIs.registerMain(wm, wglistB)){
							//保存正事表
							wm.setWarrantyNo(msg.getWarrantyNo());
							msgB=registerService.saveAllB(wm, wglistB);
							if("1".equals(msgB.getRetResult())){
								//如果返回成功，业务单据号为键，仓单号为值
								successObj.put(wm.getTrdWarrantyNo(), msgB.getWarrantyNo());
								beans.add(msgB.getMain());
								ftzWarrantyLogs.add(msgB.getLog());
							}else{
								num++;
								//如果返回失败，返回仓单号集合
								failmsg+=msgB.getMsg();
								failArry.add(wm.getTrdWarrantyNo());
							}
						}else{
							num++;
							failmsg+="保存仓单表时,关键字段为空!";
							failArry.add(wm.getTrdWarrantyNo());
						}
					}else{
						num++;
						failmsg+="临时表保存异常";
						failArry.add(wm.getTrdWarrantyNo());
					}
				}
			}
		}else{
			failmsg+="数据不能为空";
			msgB.setRetResult("0");
		}
			msgB.setMsg(failmsg);
			msgB.setSuccess(successObj);
			msgB.setFail(failArry);
			//如果存在一次失败，返回为0
		if(num>0){
			msgB.setRetResult("0");
		}
		JSONObject ret = JSONObject.fromObject(msgB);
		ret.remove("warrantyNo");
		ret.remove("main");
		ret.remove("log");
		log.info("返回结果标记："+ret.getString("retResult")+"成功数据返回"+ret.getString("success")+"失败数据返回："+ret.getString("fail")+"失败信息返回："+ret.getString("msg"));
	    //当数据保存成功之后 调用同步数据
		if("1".equals(ret.getString("retResult"))){
			//同步 仓单数据
			WarrantyBean [] bean=new WarrantyBean[beans.size()];
			log.info("仓单登记同步数据start:");
			mongoSynDataService.synWarranty(Operation.INSERT, beans.toArray(bean));
			log.info("仓单登记同步数据end:");
			//同步  履历信息
			FtzWarrantyLog [] beanLog=new FtzWarrantyLog[ftzWarrantyLogs.size()];
			log.info("履历同步数据start:");
			mongoSynDataService.synFtzWarrantyLogBean(Operation.INSERT, ftzWarrantyLogs.toArray(beanLog));
			log.info("履历同步数据end:");
		}
		IfaceLogUtil.getInstance().saveIfaceLog("TradingWarrantyService","warrantyRegistration",batchNo.toString(), ret.toString());
		log.info("ret.toString():--"+ret.toString());
		return ret.toString();
	}
	
	private void convertWarrantyType(WarrantyMain wm){
		if("0".equals(wm.getWarrantyType())){
			wm.setWarrantyType("10");
		} else if("1".equals(wm.getWarrantyType())){
			wm.setWarrantyType("20");
		}
	}
	//{"qcDesc":{"key1":"value1","key2":"value2"},"qtcDesc":{"key1":"value1","key2":"value2"}}
	private JSONObject initExpandDesc(String expandDescStr) {
		String[] strAry = expandDescStr.split("},");
		JSONObject jSONObject = new JSONObject();
		if(strAry==null || strAry.length==0) 
			return jSONObject;
		for(String str : strAry) {
			if(!str.endsWith("}")){
				str += "}";
			}
			int subNum = str.indexOf(":");
			if(subNum>-1)
				jSONObject.element(str.substring(0,subNum), str.substring(subNum+1));
		}
		return jSONObject;
	}
	
	
	/**
	 * 仓单注销
	 */
	public String warrantyCancel(String jsonData) {
		String batchNo = GuidUtil.newGuid();
		IfaceLogUtil.getInstance().saveIfaceLog("TradingWarrantyService","warrantyCancel",batchNo, jsonData);
		
		String resultFlag = "1";//返回执行结果对象
		JSONArray jsonArray = null;
		JSONArray failArray=new JSONArray();		//失败对象
		JSONObject successObj=new JSONObject();		//成功对象
		
		List<WarrantyBean> sysWarrantyBeanList=new ArrayList<WarrantyBean>();		//同步MongoDb 对象
		List<FtzWarrantyLog> ftzWarrantyLogs=new ArrayList<FtzWarrantyLog>();
		StringBuffer failmsg= new StringBuffer();
		try {
			jsonArray = getJSONArrayFromJsonData(jsonData);
		} catch (BusinessException e) {
			return  getReturnJsonFromResultB(null,null,e.getMessage(),"0");
		}
		
		for(int i=0;i<jsonArray.size();i++){
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String trdSysNo=jsonObject.getString("trdSysNo");//交易平台代码
			String warrantyNo=jsonObject.getString("warrantyNo");//仓单登记号
			String remark=jsonObject.getString("remark");//备注
			if(StringUtil.isEmpty(trdSysNo) || StringUtil.isEmpty(warrantyNo)) {
				resultFlag = "0";
				failmsg.append("交易平台代码或仓单号不能为空，");
				failArray.add(warrantyNo);
				continue;
			}
			//保存临时表
			boolean tmpFlag = saveWarrantyCancel(trdSysNo, warrantyNo, LSConstants.WARRANTY_PRELOGINOUT, remark, failArray, failmsg);
			if(tmpFlag) {
				resultFlag = "0";
				continue;
			}
			
			ResultMsgB resultMsgB = saveWarrantyCancelB(trdSysNo, warrantyNo, LSConstants.WARRANTY_PRELOGINOUT, remark, failArray, failmsg);
			if(resultMsgB==null) {
				resultFlag = "0";
				continue;
			}
			
			sysWarrantyBeanList.add(resultMsgB.getMain());
			ftzWarrantyLogs.add(resultMsgB.getLog());
			successObj.put(warrantyNo, warrantyNo);
		}
		
		String result = getReturnJsonFromResultB(failArray, successObj, failmsg.toString(), resultFlag);
		//记录返回结果日志
		IfaceLogUtil.getInstance().saveIfaceLog("TradingWarrantyService","warrantyCancel",batchNo, result);
		//当数据保存成功之后 调用同步数据
		if(sysWarrantyBeanList!=null && !sysWarrantyBeanList.isEmpty()){
			sysWarrantyAndLogs(sysWarrantyBeanList, ftzWarrantyLogs);
		}
		return result;
	}
	
	/**
	 * 仓单冻结
	 */
	public String warrantyFreeze(String jsonData) {
		String batchNo = GuidUtil.newGuid();
		IfaceLogUtil.getInstance().saveIfaceLog("TradingWarrantyService","warrantyFreeze",batchNo, jsonData);
		
		String resultFlag = "1";//返回执行结果对象
		JSONArray jsonArray = null;
		JSONArray failArray=new JSONArray();		//失败对象
		JSONObject successObj=new JSONObject();		//成功对象
		
		List<WarrantyBean> sysWarrantyBeanList=new ArrayList<WarrantyBean>();		//同步MongoDb 对象
		List<FtzWarrantyLog> ftzWarrantyLogs=new ArrayList<FtzWarrantyLog>();
		StringBuffer failmsg= new StringBuffer();
		try {
			jsonArray = getJSONArrayFromJsonData(jsonData);
		} catch (BusinessException e) {
			return  getReturnJsonFromResultB(null,null,e.getMessage(),"0");
		}
		
		for(int i=0;i<jsonArray.size();i++){
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String trdSysNo=jsonObject.getString("trdSysNo");//交易平台代码
			String warrantyNo=jsonObject.getString("warrantyNo");//仓单登记号
			if(StringUtil.isEmpty(trdSysNo) || StringUtil.isEmpty(warrantyNo)) {
				resultFlag = "0";
				failmsg.append("交易平台代码或仓单号不能为空，");
				failArray.add(warrantyNo);
				continue;
			}
			//保存临时表
			boolean tmpFlag = saveWarrantyCancel(trdSysNo, warrantyNo, LSConstants.WARRANTY_FREE_ZE, "", failArray, failmsg);
			if(tmpFlag) {
				resultFlag = "0";
				continue;
			}
			
			ResultMsgB resultMsgB = saveWarrantyCancelB(trdSysNo, warrantyNo, LSConstants.WARRANTY_FREE_ZE, "", failArray, failmsg);
			if(resultMsgB==null) {
				resultFlag = "0";
				continue;
			}
			
			sysWarrantyBeanList.add(resultMsgB.getMain());
			ftzWarrantyLogs.add(resultMsgB.getLog());
			successObj.put(warrantyNo, warrantyNo);
		}
		
		String result = getReturnJsonFromResultB(failArray, successObj, failmsg.toString(), resultFlag);
		//记录返回结果日志
		IfaceLogUtil.getInstance().saveIfaceLog("TradingWarrantyService","warrantyFreeze",batchNo, result);
		//当数据保存成功之后 调用同步数据
		if(sysWarrantyBeanList!=null && !sysWarrantyBeanList.isEmpty()){
			sysWarrantyAndLogs(sysWarrantyBeanList, ftzWarrantyLogs);
		}
		return result;
	}
	
	/**
	 * 仓单挂失
	 */
	public String warrantyLoss(String jsonData) {
		String batchNo = GuidUtil.newGuid();
		IfaceLogUtil.getInstance().saveIfaceLog("TradingWarrantyService","warrantyLoss",batchNo, jsonData);
		
		String resultFlag = "1";//返回执行结果对象
		JSONArray jsonArray = null;
		JSONArray failArray=new JSONArray();		//失败对象
		JSONObject successObj=new JSONObject();		//成功对象
		
		List<WarrantyBean> sysWarrantyBeanList=new ArrayList<WarrantyBean>();		//同步MongoDb 对象
		List<FtzWarrantyLog> ftzWarrantyLogs=new ArrayList<FtzWarrantyLog>();
		StringBuffer failmsg= new StringBuffer();
		try {
			jsonArray = getJSONArrayFromJsonData(jsonData);
		} catch (BusinessException e) {
			return  getReturnJsonFromResultB(null,null,e.getMessage(),"0");
		}
		
		for(int i=0;i<jsonArray.size();i++){
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String trdSysNo=jsonObject.getString("trdSysNo");//交易平台代码
			String warrantyNo=jsonObject.getString("warrantyNo");//仓单登记号
			if(StringUtil.isEmpty(trdSysNo) || StringUtil.isEmpty(warrantyNo)) {
				resultFlag = "0";
				failmsg.append("交易平台代码或仓单号不能为空，");
				failArray.add(warrantyNo);
				continue;
			}
			//保存临时表
			boolean tmpFlag = saveWarrantyCancel(trdSysNo, warrantyNo, LSConstants.WARRANTY_LOSS, "", failArray, failmsg);
			if(tmpFlag) {
				resultFlag = "0";
				continue;
			}
			
			ResultMsgB resultMsgB = saveWarrantyCancelB(trdSysNo, warrantyNo, LSConstants.WARRANTY_LOSS, "", failArray, failmsg);
			if(resultMsgB==null) {
				resultFlag = "0";
				continue;
			}
			
			sysWarrantyBeanList.add(resultMsgB.getMain());
			ftzWarrantyLogs.add(resultMsgB.getLog());
			successObj.put(warrantyNo, warrantyNo);
		}
		
		String result = getReturnJsonFromResultB(failArray, successObj, failmsg.toString(), resultFlag);
		//记录返回结果日志
		IfaceLogUtil.getInstance().saveIfaceLog("TradingWarrantyService","warrantyLoss",batchNo, result);
		//当数据保存成功之后 调用同步数据
		if(sysWarrantyBeanList!=null && !sysWarrantyBeanList.isEmpty()){
			sysWarrantyAndLogs(sysWarrantyBeanList, ftzWarrantyLogs);
		}
		return result;
	}
	
	
	/**
	 * 仓单交易锁定、挂牌冻结
	 */
	public String warrantyLock(String jsonData) {
		String batchNo = GuidUtil.newGuid();
		IfaceLogUtil.getInstance().saveIfaceLog("TradingWarrantyService","warrantyLock",batchNo, jsonData);
		
		String resultFlag = "1";//返回执行结果对象
		JSONArray jsonArray = null;
		JSONArray failArray=new JSONArray();		//失败对象
		JSONObject successObj=new JSONObject();		//成功对象
		
		List<WarrantyBean> sysWarrantyBeanList=new ArrayList<WarrantyBean>();		//同步MongoDb 对象
		List<FtzWarrantyLog> ftzWarrantyLogs=new ArrayList<FtzWarrantyLog>();
		StringBuffer failmsg= new StringBuffer();
		try {
			jsonArray = getJSONArrayFromJsonData(jsonData);
		} catch (BusinessException e) {
			return  getReturnJsonFromResultB(null,null,e.getMessage(),"0");
		}
		
		for(int i=0;i<jsonArray.size();i++){
			JSONObject warrantyMain = jsonArray.getJSONObject(i);
			WarrantyOthers ws= (WarrantyOthers)JSONObject.toBean(warrantyMain,WarrantyOthers.class);
			if(ws == null) {
				resultFlag = "0";
				failmsg.append("数据中实体对象不能为空！");
				failArray.add("");
				continue;
			}
			String trdSysNo = ws.getTrdSysNo();
			String warrantyNo = ws.getWarrantyNo();
			ResultMsgB resultMsgB = null;
			boolean tmpFlag = true;
			//保存临时表
			if("1".equals(ws.getLockType())) {	//挂牌冻结
				tmpFlag = saveWarrantyCancel(trdSysNo, warrantyNo, LSConstants.WARRANTY_FREEZE, "", failArray, failmsg);
			} else {	//交易锁定
				tmpFlag = saveWarrantyOthers(ws, LSConstants.WARRANTY_LOCK, failArray, failmsg);
			}
			if(tmpFlag) {
				resultFlag = "0";
				continue;
			}
			
			//保存正式表
			if("1".equals(ws.getLockType())) {	//挂牌冻结
				resultMsgB = saveWarrantyCancelB(trdSysNo, warrantyNo, LSConstants.WARRANTY_FREEZE, "", failArray, failmsg);
			} else {	//交易锁定
				resultMsgB=saveWarrantyOthersB(ws, LSConstants.WARRANTY_LOCK, failArray, failmsg);
			}
			if(resultMsgB==null) {
				resultFlag = "0";
				continue;
			}
			
			sysWarrantyBeanList.add(resultMsgB.getMain());
			ftzWarrantyLogs.add(resultMsgB.getLog());
			successObj.put(warrantyNo, warrantyNo);
		}
		
		String result = getReturnJsonFromResultB(failArray, successObj, failmsg.toString(), resultFlag);
		//记录返回结果日志
		IfaceLogUtil.getInstance().saveIfaceLog("TradingWarrantyService","warrantyLock",batchNo, result);
		//当数据保存成功之后 调用同步数据
		if(sysWarrantyBeanList!=null && !sysWarrantyBeanList.isEmpty()){
			sysWarrantyAndLogs(sysWarrantyBeanList, ftzWarrantyLogs);
		}
		return result;
	}
	
	/**
	 * 仓单解锁/解冻
	 */
	public String warrantyUnLock(String jsonData) {
		String batchNo = GuidUtil.newGuid();
		IfaceLogUtil.getInstance().saveIfaceLog("TradingWarrantyService","warrantyUnLock",batchNo, jsonData);
		
		String resultFlag = "1";//返回执行结果对象
		JSONArray jsonArray = null;
		JSONArray failArray=new JSONArray();		//失败对象
		JSONObject successObj=new JSONObject();		//成功对象
		
		List<WarrantyBean> sysWarrantyBeanList=new ArrayList<WarrantyBean>();		//同步MongoDb 对象
		List<FtzWarrantyLog> ftzWarrantyLogs=new ArrayList<FtzWarrantyLog>();
		StringBuffer failmsg= new StringBuffer();
		try {
			jsonArray = getJSONArrayFromJsonData(jsonData);
		} catch (BusinessException e) {
			return  getReturnJsonFromResultB(null,null,e.getMessage(),"0");
		}
		
		for(int i=0;i<jsonArray.size();i++){
			JSONObject warrantyMain = jsonArray.getJSONObject(i);
			WarrantyOthers ws= (WarrantyOthers)JSONObject.toBean(warrantyMain,WarrantyOthers.class);
			if(ws == null) {
				resultFlag = "0";
				failmsg.append("数据中实体对象不能为空！");
				failArray.add("");
				continue;
			}
			String trdSysNo = ws.getTrdSysNo();
			String warrantyNo = ws.getWarrantyNo();
			ResultMsgB resultMsgB = null;
			boolean tmpFlag = true;
			//保存临时表
			if("1".equals(ws.getLockType()) || "3".equals(ws.getLockType())) {	//挂牌解冻(1:挂牌解锁　3:仓单解冻)
				tmpFlag = saveWarrantyCancel(trdSysNo, warrantyNo, LSConstants.WARRANTY_UNFREEZE, "", failArray, failmsg);
			} else {	//交易解锁
				tmpFlag = saveWarrantyOthers(ws, LSConstants.WARRANTY_UNLOCK, failArray, failmsg);
			}
			if(tmpFlag) {
				resultFlag = "0";
				continue;
			}
			//保存正式表
			if("1".equals(ws.getLockType()) || "3".equals(ws.getLockType())) {	//挂牌解冻(1:挂牌解锁　3:仓单解冻)
				resultMsgB = saveWarrantyCancelB(trdSysNo, warrantyNo, LSConstants.WARRANTY_UNFREEZE, "", failArray, failmsg);
			} else {	//交易解锁
				resultMsgB=saveWarrantyOthersB(ws, LSConstants.WARRANTY_UNLOCK, failArray, failmsg);
			}
			if(resultMsgB==null) {
				resultFlag = "0";
				continue;
			}
			
			sysWarrantyBeanList.add(resultMsgB.getMain());
			ftzWarrantyLogs.add(resultMsgB.getLog());
			successObj.put(warrantyNo, warrantyNo);
		}
		
		String result = getReturnJsonFromResultB(failArray, successObj, failmsg.toString(), resultFlag);
		//记录返回结果日志
		IfaceLogUtil.getInstance().saveIfaceLog("TradingWarrantyService","warrantyUnLock",batchNo, result);
		//当数据保存成功之后 调用同步数据
		if(sysWarrantyBeanList!=null && !sysWarrantyBeanList.isEmpty()){
			sysWarrantyAndLogs(sysWarrantyBeanList, ftzWarrantyLogs);
		}
		return result;
		
	}
	
	/**
	 * 仓单过户
	 */
	public String warrantyTransfer(String jsonData) {
		String batchNo = GuidUtil.newGuid();
		IfaceLogUtil.getInstance().saveIfaceLog("TradingWarrantyService","warrantyTransfer",batchNo, jsonData);
		
		String resultFlag = "1";//返回执行结果对象
		JSONArray jsonArray = null;
		JSONArray failArray=new JSONArray();		//失败对象
		JSONObject successObj=new JSONObject();		//成功对象
		
		List<WarrantyBean> sysWarrantyBeanList=new ArrayList<WarrantyBean>();		//同步MongoDb 对象
		List<FtzWarrantyLog> ftzWarrantyLogs=new ArrayList<FtzWarrantyLog>();
		StringBuffer failmsg= new StringBuffer();
		try {
			jsonArray = getJSONArrayFromJsonData(jsonData);
		} catch (BusinessException e) {
			return  getReturnJsonFromResultB(null,null,e.getMessage(),"0");
		}
		
		for(int i=0;i<jsonArray.size();i++){
			JSONObject warrantyMain = jsonArray.getJSONObject(i);
			WarrantyOthers ws= (WarrantyOthers)JSONObject.toBean(warrantyMain,WarrantyOthers.class);
			if(ws == null) {
				resultFlag = "0";
				failmsg.append("数据中实体对象不能为空！");
				failArray.add("");
				continue;
			}
			String warrantyNo = ws.getWarrantyNo();
			//保存临时表
			boolean tmpFlag = saveWarrantyOthers(ws, LSConstants.WARRANTY_CHANGE, failArray, failmsg);
			if(tmpFlag) {
				resultFlag = "0";
				continue;
			}
			
			//保存正式表
			ResultMsgB resultMsgB =saveWarrantyOthersB(ws, LSConstants.WARRANTY_CHANGE, failArray, failmsg);
			if(resultMsgB==null) {
				resultFlag = "0";
				continue;
			}
			
			sysWarrantyBeanList.add(resultMsgB.getMain());
			ftzWarrantyLogs.add(resultMsgB.getLog());
			successObj.put(warrantyNo, warrantyNo);
		}
		
		String result = getReturnJsonFromResultB(failArray, successObj, failmsg.toString(), resultFlag);
		//记录返回结果日志
		IfaceLogUtil.getInstance().saveIfaceLog("TradingWarrantyService","warrantyTransfer",batchNo, result);
		//当数据保存成功之后 调用同步数据
		if(sysWarrantyBeanList!=null && !sysWarrantyBeanList.isEmpty()){
			sysWarrantyAndLogs(sysWarrantyBeanList, ftzWarrantyLogs);
		}
		return result;
		
	}
	
	private ResultMsgB saveWarrantyCancelB(String trdSysNo, String warrantyNo,String flag,String remark,JSONArray failArray,StringBuffer failmsg){
		ResultMsgB resultMsgB=registerService.warrantyCancelB(trdSysNo, warrantyNo,flag,remark);
		if(!"1".equals(resultMsgB.getRetResult())) {
			failArray.add(warrantyNo);
			failmsg.append(resultMsgB.getMsg()+",");
			return null;
		}
		return resultMsgB;
	}
	
	private boolean saveWarrantyCancel(String trdSysNo, String warrantyNo,String flag,String remark,JSONArray failArray,StringBuffer failmsg){
		ResultMsg msg=registerService.warrantyCancel(trdSysNo, warrantyNo,flag,remark);
		if(!"1".equals(msg.getRetResult())) {
			failArray.add(warrantyNo);
			failmsg.append("修改仓单临时表状态异常，");
			return true;
		}
		return false;
	}
	
	private JSONArray getJSONArrayFromJsonData(String jsonData){
		JSONObject mainJson = JSONObject.fromObject(jsonData);
		if(mainJson == null){
			throw new BusinessException("数据不能为空!");
		}
		JSONArray jsonArray=mainJson.getJSONArray("register");
		if(jsonArray == null) {
			throw new BusinessException("数据格式不正确!");
		}
		return jsonArray;
	}
	
	//同步仓单及日志表
	private void sysWarrantyAndLogs(List<WarrantyBean> sysWarrantyBeanList,List<FtzWarrantyLog> ftzWarrantyLogs){
		//同步 仓单数据
		WarrantyBean[] bean=new WarrantyBean[sysWarrantyBeanList.size()];
		log.info("仓单登记同步数据start:");
		mongoSynDataService.synWarranty(Operation.UPDATE, sysWarrantyBeanList.toArray(bean));
		log.info("仓单登记同步数据end:");
		//同步  履历信息
		FtzWarrantyLog [] beanLog=new FtzWarrantyLog[ftzWarrantyLogs.size()];
		log.info("履历同步数据start:");
		mongoSynDataService.synFtzWarrantyLogBean(Operation.INSERT, ftzWarrantyLogs.toArray(beanLog));
		log.info("履历同步数据end:");
	}
	
	private String getReturnJsonFromResultB(JSONArray failArray,JSONObject successObj,String failMsg,String resultFlag){
		ResultMsgB resultMsgB = new ResultMsgB();
		resultMsgB.setRetResult(resultFlag);
		if(failArray!=null) {
			resultMsgB.setFail(failArray);
		}
		if(successObj!=null) {
			resultMsgB.setSuccess(successObj);
		}
		if(StringUtils.isNotBlank(failMsg)) {
			resultMsgB.setMsg(failMsg);
		}
		JSONObject result = JSONObject.fromObject(resultMsgB);
		result.remove("warrantyNo");
		result.remove("main");
		result.remove("log");
		return result.toString();
	}
	
	private ResultMsgB saveWarrantyOthersB(WarrantyOthers ws, String flag, JSONArray failArray,StringBuffer failmsg) {
		ResultMsgB resultMsgB = registerService.warrantyOthersB(ws, flag);
		if(!"1".equals(resultMsgB.getRetResult())) {
			failArray.add(ws.getWarrantyNo());
			failmsg.append(resultMsgB.getMsg()+",");
			return null;
		}
		return resultMsgB;
	}

	private boolean saveWarrantyOthers(WarrantyOthers ws, String flag, JSONArray failArray, StringBuffer failmsg) {
		ResultMsg msg=registerService.warrantyOthers(ws, flag);
		if(!"1".equals(msg.getRetResult())) {
			failArray.add(ws.getWarrantyNo());
			failmsg.append("修改仓单临时表状态异常，");
			return true;
		}
		return false;
	}

	/**
	 * 仓单查询
	 */
	public String warrntyQuery(String jsonData) {
		String result="";
		try {
			result = "";//RestLinkUtil.getInstance("pacific-rc-web").bigDataPost("pacific-rc-web", "warranty", "/warrantyList", jsonData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public String warrantyComparison(String jsonData) {
		return null;
	}

}
