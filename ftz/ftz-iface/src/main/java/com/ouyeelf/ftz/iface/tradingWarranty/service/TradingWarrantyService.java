package com.ouyeelf.ftz.iface.tradingWarranty.service;

import javax.jws.WebService;

/**
 * @Copyright (c) by baoSight
 * @All right reserved.
 * @Create Date: 2015/01/05
 * @Create Author: zjs
 * @File Name: TradingWarrantyService
 * @Last version: 1.0
 * @Function: 动产权属平台(自贸区)webservice仓单接口设计.<br>
 * @Last Update Date:
 * @Change Log:
 */
@WebService
public interface TradingWarrantyService {
	
	/**
	 * 仓单登记
	 * @param jsonData接口传入仓单登记信息（json格式）
	 * @return 执行接口结果（json格式）
	 */
	String warrantyRegistration(String jsonData);
	
	
	/**
	 * 仓单注销
	 * @param jsonData接口传入仓单注销信息（json格式）
	 * @return 执行接口结果（json格式）
	 */
	String warrantyCancel(String jsonData);
	
	/**
	 * 仓单冻结
	 * @param jsonData接口传入仓单冻结信息（json格式）
	 * @return 执行接口结果（json格式）
	 */
	String warrantyFreeze(String jsonData);
	
	/**
	 * 仓单挂失
	 * @param jsonData 接口传入仓单挂失信息（json格式）
	 * @return 执行接口结果（json格式）
	 */
	String warrantyLoss(String jsonData);
	
	/**
	 * 仓单锁定
	 * @param jsonData 接口传入仓单锁定信息（json格式）
	 * @return 执行接口结果（json 格式）
	 */
	String warrantyLock(String jsonData);
	
	/**
	 * 仓单解锁
	 * @param jsonData 接口传入仓单解锁信息（json格式）
	 * @return 执行接口结果（json 格式）
	 */
	String warrantyUnLock(String jsonData);
	
	/**
	 * 仓单过户
	 * @param jsonData 接口传入仓单过户信息（json格式）
	 * @return 执行接口结果（json 格式）
	 */
	String warrantyTransfer(String jsonData);
	
	/**
	 * 仓单查询
	 * @param jsonData 接口传入仓单查询信息（json格式）
	 * @return 执行接口结果（json格式）
	 */
	String warrntyQuery(String jsonData);
	
	/**
	 * 仓单比对
	 * @param jsonData 接口传入仓单比对信息（json格式）
	 * @return 执行接口结果（json格式）
	 */
	String warrantyComparison(String jsonData);

}
