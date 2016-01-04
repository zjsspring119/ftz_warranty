package com.ouyeelf.ftz.model.model.warranty;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ouyeelf.ftz.model.domain.warranty.FtzWarrantyLog;
import com.ouyeelf.ftz.model.mdbean.WarrantyBean;


public class ResultMsgB implements java.io.Serializable {

	private static final long serialVersionUID = 5748286172704177152L;
	
	private String retResult;//返回执行状态
	private JSONObject success;//成功数据
	private JSONArray fail;//失败数据
	private String warrantyNo;//仓单号返回
	private WarrantyBean main;
	private FtzWarrantyLog log;//履历信息集合
	private String msg;//错误备注信息
	public String getRetResult() {
		return retResult;
	}
	public void setRetResult(String retResult) {
		this.retResult = retResult;
	}
	public JSONObject getSuccess() {
		return success;
	}
	public void setSuccess(JSONObject success) {
		this.success = success;
	}
	public JSONArray getFail() {
		return fail;
	}
	public void setFail(JSONArray fail) {
		this.fail = fail;
	}
	public String getWarrantyNo() {
		return warrantyNo;
	}
	public void setWarrantyNo(String warrantyNo) {
		this.warrantyNo = warrantyNo;
	}
	public WarrantyBean getMain() {
		return main;
	}
	public void setMain(WarrantyBean main) {
		this.main = main;
	}
	public FtzWarrantyLog getLog() {
		return log;
	}
	public void setLog(FtzWarrantyLog log) {
		this.log = log;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}


	
}
