package com.ouyeelf.ftz.service.common.util;

import java.math.BigDecimal;
import java.util.List;

import com.ouyeelf.ftz.common.constant.LSConstants;
import com.ouyeelf.ftz.common.utils.StringUtil;
import com.ouyeelf.ftz.model.model.warranty.WarrantyGood;
import com.ouyeelf.ftz.model.model.warranty.WarrantyMain;
import com.ouyeelf.ftz.model.model.warranty.WarrantyOthers;

/**
 * 判断仓储接口接受数据的正确性
 * 
 * @author h
 *
 */
public class CommonIs {
	//判断主项数据不能为空且子项不能为空
	public static boolean registerMain(WarrantyMain wm,	List<WarrantyGood> wglist){
		boolean flag=false;
		if(wm!=null){
			if(wglist!=null && wglist.size()>0){
				if(!StringUtil.isEmpty(wm.getTrdSysNo())
						&& !StringUtil.isEmpty(wm.getTrdWarrantyNo())
						//&& !StringUtil.isEmpty(wm.getWhsWarrantyNo())仓库系统仓单号不需要校验
						&& !StringUtil.isEmpty(wm.getWarrantyType())
						//&& !StringUtil.isEmpty(wm.getCustCode())货主代码不需要校验
						&& !StringUtil.isEmpty(wm.getCustName())
						&& !StringUtil.isEmpty(wm.getCustTaxNum())
						&& !StringUtil.isEmpty(wm.getWarehouseNum())
						&& !StringUtil.isEmpty(wm.getWarehouseName())
//						&& !StringUtil.isEmpty(wm.getWarehouseAdd())
						&& !StringUtil.isEmpty(wm.getPrdCataName())
						&& !StringUtil.isEmpty(wm.getPrdCataCode())
//						&& !StringUtil.isEmpty(wm.getCtmPrdCode())
						&& !StringUtil.isEmpty(wm.getUnit())
						&& !StringUtil.isEmpty(wm.getTaxedFlag())
						&& !StringUtil.isEmpty(wm.getWeightUnit())//重量单位
						){
					//如果仓单状态为保证金时
					if(LSConstants.WARRANTY_TYPE_BAOZHENGJIN.equals(wm.getWarrantyType())){
						if(!"".equals(wm.getDepositRatio())
								&& !StringUtil.isEmpty(wm.getDepositManager())
								){
							flag=true;
						}
					}else{
						flag=true;
					}	
				}
			}
		}
		return flag;
	}
	//判断子项不能为空
	public static boolean registerGoods(WarrantyGood ws){
		boolean flag=false;
		if(ws!=null){
				if(!StringUtil.isEmpty(ws.getGoodId())
						&& !StringUtil.isEmpty(ws.getPrdVarietyName())
						&& !StringUtil.isEmpty(ws.getPrdVarietyCode())
						&& !StringUtil.isEmpty(ws.getTypeName())
						&& !StringUtil.isEmpty(ws.getSpecDesc())
						&& !StringUtil.isEmpty(ws.getAreaP())
						&& !StringUtil.isEmpty(ws.getGrade())
						&& ws.getWeight()!=null
						&& !"".equals(ws.getWeight())
						&& !StringUtil.isEmpty(ws.getWeightUnit())
						&& !"".equals(ws.getSheetNum())
						&& !StringUtil.isEmpty(ws.getUnit())
//						&& checkBigDecimal(ws.getTotalPrice())//子项总价
//						&& checkBigDecimal(ws.getUnitPrice())//子项单价
//						&& !StringUtil.isEmpty(ws.getCheckType())
						){
					flag=true;
				}
		}
		return flag;
	}
	
	//判断锁定 过户对象字段不能为空
		public static boolean lockAndChange(WarrantyOthers ws,String status){
			boolean flag=false;
			if(ws ==null)
				return true;
			if(LSConstants.WARRANTY_UNLOCK.equals(status)
					&& !StringUtil.isEmpty(ws.getTrdSysNo())
					&& !StringUtil.isEmpty(ws.getWarrantyNo())
					&& !StringUtil.isEmpty(ws.getLockType())) {
				flag=true;
				
			} else if(!StringUtil.isEmpty(ws.getTrdSysNo())
					&& !StringUtil.isEmpty(ws.getWarrantyNo())
					//&& !StringUtil.isEmpty(ws.getNewCustCode())
					//&& !StringUtil.isEmpty(ws.getNewCustName())
					&& !StringUtil.isEmpty(ws.getOrgCustCode())
					&& !StringUtil.isEmpty(ws.getOrgCustName())
					){
				if(LSConstants.WARRANTY_LOCK.equals(status)){
					if(!StringUtil.isEmpty(ws.getBussinessNumber())
							&& !StringUtil.isEmpty(ws.getBussinessPrice())
							&& !StringUtil.isEmpty(ws.getBussinessTime())
							//&& !StringUtil.isEmpty(ws.getBussinessNo())
							&& !StringUtil.isEmpty(ws.getNewCustCode())
					        && !StringUtil.isEmpty(ws.getNewCustName())
					        && !StringUtil.isEmpty(ws.getNewCustEName())
							){
						flag=true;
					}
				}else{
					flag=true;
				}
			}
			
			return flag;
		}
		
		
		private static boolean checkBigDecimal(BigDecimal value){
			boolean result=true;
			if(value ==null||"".equals(value)){
				result=false;
			}
			return result;
			
		}
}
