package com.ouyeelf.ftz.service.callback;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ouyeelf.ftz.rsdb.imp.callback.ICallback;
import com.ouyeelf.ftz.service.warranty.WarrantyCommonService;
import com.waxberry.spring.util.SpringContextUtil;

public class CallbackImpl implements ICallback {
	
	private List<String> suList;
	private long endTime;
	private long unsuccessLen;
	private long successLen;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	WarrantyCommonService warrantyCommonService = SpringContextUtil.getBean(WarrantyCommonService.class);
	
	public void result(String[] unsuccessful, String[] success,List<String> suList, String batch,long startTime ,long endTime) {
		// TODO Auto-generated method stub
		logger.info("unsuccessful:{}",unsuccessful.length);
		logger.info("successful:{}",success.length);
		logger.info("batch:{}",batch);
		logger.info("startTime:{}",startTime);
		logger.info("endTime:{}",endTime);
		logger.info("totalTime:{}",endTime-startTime);
		this.endTime=endTime;
		this.suList=suList;
		this.unsuccessLen=unsuccessful.length;
		this.successLen=success.length;
		if("warrantyBean".equals(batch)){
			logger.info("反馈仓单同步成功标记开始");
			warrantyCommonService.updateIsSynchronize("1",suList);
			logger.info("反馈仓单同步成功标记结束");
		}else if("ftzWarrantyLogBean".equals(batch)){
			warrantyCommonService.updateIsSynchronizeByFtzWarrantyLog("1", suList);
		}else if("warrantySearchHisBean".endsWith(batch)){
			warrantyCommonService.updateIsSynchronizeByWarrantySearchHis("1", suList);
		}
	}

	

	public List<String> getSuList() {
		return suList;
	}



	public void setSuList(List<String> suList) {
		this.suList = suList;
	}



	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public long getUnsuccessLen() {
		return unsuccessLen;
	}

	public void setUnsuccessLen(long unsuccessLen) {
		this.unsuccessLen = unsuccessLen;
	}

	public long getSuccessLen() {
		return successLen;
	}

	public void setSuccessLen(long successLen) {
		this.successLen = successLen;
	}
	
	

}
