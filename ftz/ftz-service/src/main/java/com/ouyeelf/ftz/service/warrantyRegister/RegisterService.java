package com.ouyeelf.ftz.service.warrantyRegister;

import java.util.List;

import com.ouyeelf.ftz.model.model.warranty.ResultMsg;
import com.ouyeelf.ftz.model.model.warranty.ResultMsgB;
import com.ouyeelf.ftz.model.model.warranty.WarrantyGood;
import com.ouyeelf.ftz.model.model.warranty.WarrantyMain;
import com.ouyeelf.ftz.model.model.warranty.WarrantyOthers;

public interface RegisterService {
	/**
	 * 仓单登记方法 保存到临时表
	 * @param wm仓单临时模板
	 * @param wglist 仓单临时模板
	 * @param wslist仓单临时 规格模板
	 * @return 结果集对象
	 */
	public ResultMsg saveAll(	WarrantyMain wm,List<WarrantyGood> wglist);
	
	/**
	 * 仓单登记方法  保存在正式表
	 * @param wm仓单临时模板
	 * @param wglist 仓单临时模板
	 * @param wslist仓单临时 规格模板
	 * @return 结果集对象
	 */
	public ResultMsgB saveAllB(	WarrantyMain wm,List<WarrantyGood> wglist);
	
	/**
	 * 仓单注销，冻结，挂失方法
	 * @param trdSysNo 交易平台代码
	 * @param warrantyNo 仓单登记号
	 * @param flag 标记01仓单注销，101：仓单冻结，102：仓单挂失  106：仓单解冻
	 * @return 结果集对象
	 */
	public ResultMsg warrantyCancel(String trdSysNo,String warrantyNo,String flag,String remark);
	
	/**
	 * 仓单注销，冻结，挂失方法
	 * @param trdSysNo 交易平台代码
	 * @param warrantyNo 仓单登记号
	 * @param flag 标记01仓单注销，101：仓单冻结，102：仓单挂失   106：仓单解冻
	 * @return 结果集对象
	 */
	public ResultMsgB warrantyCancelB(String trdSysNo,String warrantyNo,String flag,String remark);
	
	/**
	 * 仓单锁定，解锁，过户方法
	 * @param warrantyOthers 锁定过户传值对象
	 * @param flag 标记103：仓单锁定，104：仓单过户  105 仓单解锁
	 * @return 结果集对象
	 */
	public ResultMsg warrantyOthers(WarrantyOthers warrantyOthers,String flag);
	
	/**
	 * 仓单锁定，解锁，过户方法
	 * @param warrantyOthers 锁定过户传值对象
	 * @param flag 标记103：仓单锁定，104：仓单过户  105 仓单解锁
	 * @return 结果集对象
	 */
	public ResultMsgB warrantyOthersB(WarrantyOthers warrantyOthers,String flag);
}
