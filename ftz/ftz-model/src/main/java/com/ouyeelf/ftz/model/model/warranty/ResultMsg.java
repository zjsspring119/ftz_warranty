package com.ouyeelf.ftz.model.model.warranty;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ouyeelf.ftz.model.model.BaseModel;


public class ResultMsg extends BaseModel{

	private static final long serialVersionUID = -8847275534703541459L;

	private String retResult;//返回执行状态
	private JSONObject success;//成功数据
	private JSONArray fail;//失败数据
	private String warrantyNo;//仓单号返回

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
 
}
