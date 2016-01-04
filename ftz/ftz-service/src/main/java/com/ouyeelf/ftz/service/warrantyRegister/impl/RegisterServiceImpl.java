package com.ouyeelf.ftz.service.warrantyRegister.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ouyeelf.ftz.common.constant.LSConstants;
import com.ouyeelf.ftz.common.utils.DateUtil;
import com.ouyeelf.ftz.common.utils.GuidUtil;
import com.ouyeelf.ftz.common.utils.SMSPlatformImpl;
import com.ouyeelf.ftz.common.utils.StringUtil;
import com.ouyeelf.ftz.common.utils.UtilCommon;
import com.ouyeelf.ftz.common.utils.WsdlUtil;
import com.ouyeelf.ftz.model.domain.compare.CompareData;
import com.ouyeelf.ftz.model.domain.compare.WarrantyCompare;
import com.ouyeelf.ftz.model.domain.compare.WarrantyCompareDetail;
import com.ouyeelf.ftz.model.domain.goodsCata.GoodsCataMapping;
import com.ouyeelf.ftz.model.domain.message.OrcTMassageDetails;
import com.ouyeelf.ftz.model.domain.message.OrcTMessageUserphone;
import com.ouyeelf.ftz.model.domain.warranty.CreditIcon;
import com.ouyeelf.ftz.model.domain.warranty.FtzWarrantyLog;
import com.ouyeelf.ftz.model.domain.warranty.InterWarrantyGoods;
import com.ouyeelf.ftz.model.domain.warranty.InterWarrantyMain;
import com.ouyeelf.ftz.model.domain.warranty.InterWarrantysUpdate;
import com.ouyeelf.ftz.model.domain.warranty.Warranty;
import com.ouyeelf.ftz.model.mdbean.WarrantyBean;
import com.ouyeelf.ftz.model.mdbean.WarrantyGoodBean;
import com.ouyeelf.ftz.model.model.warranty.ResultMsg;
import com.ouyeelf.ftz.model.model.warranty.ResultMsgB;
import com.ouyeelf.ftz.model.model.warranty.WarrantyGood;
import com.ouyeelf.ftz.model.model.warranty.WarrantyMain;
import com.ouyeelf.ftz.model.model.warranty.WarrantyOthers;
import com.ouyeelf.ftz.persist.dao.CommonDao;
import com.ouyeelf.ftz.persist.dao.DbTimeDao;
import com.ouyeelf.ftz.persist.dao.compare.CompareDataDao;
import com.ouyeelf.ftz.persist.dao.compare.WarrantyCompareDao;
import com.ouyeelf.ftz.persist.dao.compare.WarrantyCompareDetailDao;
import com.ouyeelf.ftz.persist.dao.goodsCata.GoodsCataMappingDao;
import com.ouyeelf.ftz.persist.dao.message.OrcTMassageDetailsDao;
import com.ouyeelf.ftz.persist.dao.message.OrcTMessageUserphoneDao;
import com.ouyeelf.ftz.persist.dao.warranty.CreditIconDao;
import com.ouyeelf.ftz.persist.dao.warranty.FtzWarrantyLogDao;
import com.ouyeelf.ftz.persist.dao.warranty.InterUpdateDao;
import com.ouyeelf.ftz.persist.dao.warranty.InterWarrantyGoodsDao;
import com.ouyeelf.ftz.persist.dao.warranty.InterWarrantyMainDao;
import com.ouyeelf.ftz.persist.dao.warranty.WarrantyDao;
import com.ouyeelf.ftz.persist.dao.warranty.WarrantyGoodDao;
import com.ouyeelf.ftz.service.common.BusinessCommon;
import com.ouyeelf.ftz.service.common.util.CommonIs;
import com.ouyeelf.ftz.service.warrantyRegister.RegisterService;
import com.waxberry.common.util.PropertiesUtil;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

	private static Log logger = LogFactory.getLog(RegisterServiceImpl.class);
	private Map lgsBaols=PropertiesUtil.read("lgs_ftz");
	@Autowired
	private InterWarrantyMainDao interWarrantyMainDao;
	@Autowired
	private WarrantyDao warrantyDao;
	@Autowired
	private WarrantyGoodDao warrantyGoodDao;
	@Autowired
	private InterWarrantyGoodsDao interWarrantyGoodsDao;
	@Autowired
	private BusinessCommon businessCommon;
	@Autowired
	private InterUpdateDao interUpdateDao;
	@Autowired
	private GoodsCataMappingDao goodsCataMappingDao;
	@Autowired
	private FtzWarrantyLogDao ftzWarrantyLogDao;
	@Autowired
	private DbTimeDao dbTimeDao;
	@Autowired
	private CommonDao commonDao;
	
	@Autowired
	private CompareDataDao compareDataDao;
    
	@Autowired
    private CreditIconDao creditIconDao;
	
	@Autowired
	private WarrantyCompareDetailDao warrantyCompareDetailDao;
	
	@Autowired
	private WarrantyCompareDao warrantyCompareDao;
	
	@Autowired
	private OrcTMessageUserphoneDao orcTMessageUserphoneDao;
	
	@Autowired
	private OrcTMassageDetailsDao orcTMassageDetailsDao;

    @Transactional
	public ResultMsg saveAll(WarrantyMain wm, List<WarrantyGood> wglist) {
		ResultMsg result = new ResultMsg();
		result.setRetResult("1");
		try {
			// 根据业务单据号查询 以前校验重复性，同样电子仓单号 在临时表中不能存在相同的，现在 不过滤
			// InterWarrantyMain
			// main=interWarrantyMainDao.findByOrgBillNo(wm.getTrdWarrantyNo());
			// 如果当前业务单据号没有数据存在可以使用
			// if(main==null){
			Date date = DateUtil.toDateTime(dbTimeDao.getSysDateString());
			InterWarrantyMain main = new InterWarrantyMain();
			// 总重量，总数量
			BigDecimal weightSum = new BigDecimal(0);
			int num = 0;
			String warrantyNo =this.generateWarranntyNo(); ;// 生成仓单号
			for (WarrantyGood wg : wglist) {
				weightSum = weightSum.add(wg.getWeight());
				num += wg.getSheetNum();
				InterWarrantyGoods goods = new InterWarrantyGoods();
				BeanUtils.copyProperties(wg, goods);
				if (StringUtil.isEmpty(goods.getStoreDate())) {
					goods.setStoreDate(dbTimeDao.getSysDateString());
				}
				goods.setWarrantyNo(warrantyNo);
				interWarrantyGoodsDao.save(goods);
			}
			BeanUtils.copyProperties(wm, main);
			main.setId(GuidUtil.newGuid());
			main.setOrgSysNo(wm.getTrdSysNo());
			main.setOrgBillNo(wm.getTrdWarrantyNo());
			main.setNum(num);
			main.setWeight(weightSum);
			main.setDepositRatio(wm.getDepositRatio());
			main.setWarrantyNo(warrantyNo);
			main.setRegisterTime(date);
			interWarrantyMainDao.save(main);
			result.setWarrantyNo(warrantyNo);
			// }else{
			// result.setRetResult("0");
			// }
		} catch (Exception e) {
			result.setRetResult("0");
			e.getStackTrace();
		}
		return result;
	}

	@Transactional
	public ResultMsgB saveAllB(WarrantyMain wm, List<WarrantyGood> wglist) {
		ResultMsgB result = new ResultMsgB();
		String msg = "";
		result.setRetResult("1");
		List<WarrantyGoodBean> goodsList = new ArrayList<WarrantyGoodBean>();
		Map<String,String> sysOrgMap = new HashMap<String,String>();	//sysOrgNo  sysOrgName
		try {
			Date date = DateUtil.toDateTime(dbTimeDao.getSysDateString());
			Warranty warranty = warrantyDao.findByOrgBillNo(wm.getTrdWarrantyNo(),wm.getTrdSysNo());
			// 如果仓单主表中不存在当前业务单据号，可以使用
			if (warranty == null) {
				// 总重量，总数量
				BigDecimal weightSum = new BigDecimal(0);
				int num = 0;
				String warrantyNo = wm.getWarrantyNo();
				String[] storeDateStrings = new String[] { "storeDate" };
				String[] depositRatioStrings = new String[] { "depositRatio" };
				// 先保存仓单子表
				for (WarrantyGood wg : wglist) {
					weightSum = weightSum.add(wg.getWeight());
					//num += wg.getSheetNum();
					com.ouyeelf.ftz.model.domain.warranty.WarrantyGood goods = new com.ouyeelf.ftz.model.domain.warranty.WarrantyGood();
					WarrantyGoodBean goodBean = new WarrantyGoodBean();
					BeanUtils.copyProperties(wg, goods, storeDateStrings);
					goods.setWarrantyNo(warrantyNo);
					goods.setNewPmClass(wg.getPrdVarietyName());
					goods.setPmClass(wg.getPrdVarietyName());
					goods.setPmCode(wg.getPrdVarietyCode());
					goods.setSpec(wg.getSpecDesc());
					goods.setWeightB(wg.getWeight());
					goods.setWeightC(wg.getWeight());
					goods.setRzWarehouseCode(wm.getWarehouseNum());
					if (StringUtil.isEmpty(wg.getStoreDate())) {
						goods.setStoreDate(date);
					} else {
						goods.setStoreDate(new SimpleDateFormat("yyyy-MM-dd").parse(wg.getStoreDate()));
					}
					// 根据接口过来的品种查询 是否存在当前品种，存在这不保存，不存在保存
					GoodsCataMapping cataMapping = goodsCataMappingDao.findByFtzCatagoryCode(goods.getPmCode());
					if (cataMapping == null) {
						cataMapping = new GoodsCataMapping();
						cataMapping.setId(GuidUtil.newGuid());
						cataMapping.setFtzCatagoryCode(goods.getPmCode());
						cataMapping.setFtzCatagoryName(goods.getPmClass());
						cataMapping.setMarketFlag(LSConstants.FTZ_MARKET_FLAG);
						goodsCataMappingDao.save(cataMapping);
					}
					warrantyGoodDao.save(goods);
					BeanUtils.copyProperties(goods, goodBean);
					goodsList.add(goodBean);
				}
				Warranty main = new Warranty();
				WarrantyBean warrantyBean = new WarrantyBean();
				BeanUtils.copyProperties(wm, main, depositRatioStrings);
				// main.setCustomerCode(wm.getCustCode()); //仓单公示平台代码，由定时任务执行填写
				main.setCustomerName(wm.getCustName());
				main.setCustNameEn(wm.getCustEnName());
				main.setGoodsOwnerNum(wm.getCustCode());
				main.setGoodsOwnerName(wm.getCustName());
				main.setGoodsOwnerAddress(wm.getCustAdd());
				main.setWarrantyStatus(LSConstants.WARRANTY_CONFIRM);
				if (!StringUtil.isEmpty(wm.getBillCreateTime())) {
					main.setCreateTime(date);
				} else {
					main.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").parse(wm.getBillCreateTime()));
				}
				main.setUpdateTime(date);
				main.setWarehouseNameEn(wm.getWarehouseEName());
				main.setWarehouseAddress(wm.getWarehouseAdd());
				main.setOrgSysNo(wm.getTrdSysNo());
				
				String orgSysName = sysOrgMap.get(wm.getTrdSysNo());
				if(StringUtils.isBlank(orgSysName)) {
					orgSysName = commonDao.getSysOrgName(wm.getTrdSysNo());
					if(StringUtil.isEmpty(orgSysName)){
						msg += "交易平台代码："+wm.getTrdSysNo()+"没有在公示平台的注册过";
						result.setRetResult("0");
						return result;
					}
					sysOrgMap.put(wm.getTrdSysNo(), orgSysName);
				}
				main.setOrgSysName(orgSysName);
//				main.setOrgSysName(orgSysName);
				main.setOrgBillNo(wm.getTrdWarrantyNo());
				//main.setNum(num);
				main.setWeight(weightSum);
				main.setDepositRatio(new BigDecimal(wm.getDepositRatio()));
				main.setWarrantyNo(warrantyNo);
				main.setWhWarrantyNo(wm.getWhsWarrantyNo());
				main.setMarketFlag(LSConstants.FTZ_MARKET_FLAG);
				//实时比对
				this.handleComparisonResult(main, goodsList);
				warrantyDao.save(main);
				BeanUtils.copyProperties(main, warrantyBean);
				// 保存仓单履历信息
				FtzWarrantyLog ftzWarrantyLog = new FtzWarrantyLog();
				BeanUtils.copyProperties(main, ftzWarrantyLog);
				ftzWarrantyLog.setId(GuidUtil.newGuid());
				ftzWarrantyLog.setNewStatus(LSConstants.WARRANTY_CONFIRM);
				ftzWarrantyLog.setNewCustCode(main.getGoodsOwnerNum());
				ftzWarrantyLog.setNewCustName(main.getGoodsOwnerName());
				ftzWarrantyLog.setCreateTime(date);
				ftzWarrantyLogDao.save(ftzWarrantyLog);
				result.setWarrantyNo(warrantyNo);
				// 将子项数据加入到家口实体类中
				warrantyBean.setWarrantyGoodBean(goodsList);
				result.setMain(warrantyBean);
				result.setLog(ftzWarrantyLog);
			} else {
				msg += "当前交易平台注册仓单号在仓单表中已经存在，";
				result.setRetResult("0");
			}
		} catch (Exception e) {
			msg += "保存数据执行异常" + e.getStackTrace();
			result.setRetResult("0");
			e.printStackTrace();
		}
		result.setMsg(msg);
		return result;
	}

	@Transactional
	public ResultMsg warrantyCancel(String trdSysNo, String warrantyNo, String flag, String remark) {
		ResultMsg result = new ResultMsg();
		result.setRetResult("1");
		try {
			Date date = DateUtil.toDateTime(dbTimeDao.getSysDateString());
			InterWarrantysUpdate interWarrantysUpdate = interUpdateDao.findByWarrantyNoAndOrgSysNoAndNewStatus(
					warrantyNo, trdSysNo, flag);
			// 相同仓单号和交易平台代码做更新，不同状态 做保存
			if (interWarrantysUpdate == null) {
				interWarrantysUpdate = new InterWarrantysUpdate();
				interWarrantysUpdate.setId(GuidUtil.newGuid());
			}
			interWarrantysUpdate.setWarrantyNo(warrantyNo);
			interWarrantysUpdate.setNewStatus(flag);
			if (LSConstants.WARRANTY_PRELOGINOUT.equals(flag)) {
				interWarrantysUpdate.setInterfaceName("仓单注销");
			} else if (LSConstants.WARRANTY_FREEZE.equals(flag)) {
				interWarrantysUpdate.setInterfaceName("挂牌冻结");
			} else if (LSConstants.WARRANTY_LOSS.equals(flag)) {
				interWarrantysUpdate.setInterfaceName("仓单挂失");
			} else if (LSConstants.WARRANTY_UNFREEZE.equals(flag)) {
				interWarrantysUpdate.setInterfaceName("仓单解冻");
			}else if(LSConstants.WARRANTY_FREE_ZE.equals(flag)){
				interWarrantysUpdate.setInterfaceName("异常冻结");
			}
			interWarrantysUpdate.setReturnCode("1");
			interWarrantysUpdate.setUpdateTime(date);
			interWarrantysUpdate.setOrgSysNo(trdSysNo);
			interUpdateDao.save(interWarrantysUpdate);
		} catch (Exception e) {
			result.setRetResult("0");
			e.getStackTrace();
		}
		return result;
	}

	@Transactional
	public ResultMsgB warrantyCancelB(String trdSysNo, String warrantyNo, String flag, String remark) {
		ResultMsgB result = new ResultMsgB();
		result.setRetResult("1");
		String msg = "";
		try {
			Date date = DateUtil.toDateTime(dbTimeDao.getSysDateString());
			Warranty warranty = warrantyDao.findOne(warrantyNo);
			// 仓单号必须在我们平台存在
			if (warranty == null) {
				msg += "当前仓单号不存在，";
				result.setRetResult("0");
				result.setMsg(msg);
				return result;
			}
			// 注销仓单 不允许冻结
			if (LSConstants.WARRANTY_PRELOGINOUT.equals(warranty.getWarrantyStatus())) {
				msg += "当前仓单已注销不能操作，";
				result.setRetResult("0");
				result.setMsg(msg);
				return result;
			}
			
			warranty.setUpdateTime(date);
			
			// 如果是注销状态保存 注销时间
			if (LSConstants.WARRANTY_PRELOGINOUT.equals(flag)) {
				warranty.setCancelTime(date);
			}
			FtzWarrantyLog ftzWarrantyLog = new FtzWarrantyLog();
			ftzWarrantyLog.setNewStatus(flag);
			if(LSConstants.WARRANTY_FREEZE.equals(flag)){//当时挂牌锁定时
				if(LSConstants.COMPARE_DATA_QUANTITY_OWNER.equals(warranty.getWarehouseCredit())){//比对正常挂牌成功
					warranty.setWarrantyStatus(flag);	
				}else{//比对异常　挂牌失败，仓单状态置为待仓库验证
					warranty.setWarrantyStatus(LSConstants.WARRANTY_DWCYZ);
					ftzWarrantyLog.setNewStatus(LSConstants.WARRANTY_DWCYZ);
					warranty.setIsSynchronize("0");
					msg += "仓单仓库货物校验失败" ;
					result.setRetResult("0");
				}
			}else{
				warranty.setWarrantyStatus(flag);
			}
			warrantyDao.save(warranty);
			WarrantyBean bean = new WarrantyBean();
			BeanUtils.copyProperties(warranty, bean);
			// 保存仓单履历信息
			
			BeanUtils.copyProperties(warranty, ftzWarrantyLog);
			ftzWarrantyLog.setId(GuidUtil.newGuid());
			
			ftzWarrantyLog.setNewCustCode(warranty.getGoodsOwnerNum());
			ftzWarrantyLog.setNewCustName(warranty.getGoodsOwnerName());
			ftzWarrantyLog.setCreateTime(date);
			ftzWarrantyLog.setRemark(remark);
			ftzWarrantyLogDao.save(ftzWarrantyLog);
			result.setMain(bean);
			result.setLog(ftzWarrantyLog);
		} catch (Exception e) {
			msg += "修改仓单表状态异常" + e.getStackTrace();
			result.setRetResult("0");
			e.getStackTrace();
		}
		result.setMsg(msg);
		return result;
	}

	@Transactional
	public ResultMsg warrantyOthers(WarrantyOthers warrantyOthers, String flag) {
		ResultMsg result = new ResultMsg();
		result.setRetResult("1");
		try {
			Date date = DateUtil.toDateTime(dbTimeDao.getSysDateString());
			// //判断锁定 过户对象字段不能为空
			// if(!StringUtil.isEmpty(warrantyOthers.getWarrantyNo()) &&
			// !StringUtil.isEmpty(warrantyOthers.getTrdSysNo())){
			InterWarrantysUpdate interWarrantysUpdate = interUpdateDao.findByWarrantyNoAndOrgSysNoAndNewStatus(
					warrantyOthers.getWarrantyNo(), warrantyOthers.getTrdSysNo(), flag);
			// 相同仓单号和交易平台代码做更新，不同状态 做保存
			if (interWarrantysUpdate == null) {
				interWarrantysUpdate = new InterWarrantysUpdate();
				interWarrantysUpdate.setId(GuidUtil.newGuid());
			}
			interWarrantysUpdate.setWarrantyNo(warrantyOthers.getWarrantyNo());
			interWarrantysUpdate.setNewStatus(flag);
			interWarrantysUpdate.setNewCustCode(warrantyOthers.getNewCustCode());
			interWarrantysUpdate.setNewCustName(warrantyOthers.getNewCustName());
			interWarrantysUpdate.setOrgCustCode(warrantyOthers.getOrgCustCode());
			interWarrantysUpdate.setOrgCustName(warrantyOthers.getOrgCustName());
			interWarrantysUpdate.setNewCustEName(warrantyOthers.getNewCustEName());
			if (LSConstants.WARRANTY_LOCK.equals(flag)) {
				interWarrantysUpdate.setInterfaceName("仓单锁定");
				interWarrantysUpdate.setBussinessNo(warrantyOthers.getBussinessNo());
				if (!StringUtil.isEmpty(warrantyOthers.getBussinessNumber())) {
					interWarrantysUpdate.setBussinessNumber(new BigDecimal(warrantyOthers.getBussinessNumber()));
				}
				if (!StringUtil.isEmpty(warrantyOthers.getBussinessPrice())) {
					interWarrantysUpdate.setBussinessPrice(new BigDecimal(warrantyOthers.getBussinessPrice()));
				}
				interWarrantysUpdate.setBussinessTime(warrantyOthers.getBussinessTime());
			} else if (LSConstants.WARRANTY_CHANGE.equals(flag)) {
				interWarrantysUpdate.setInterfaceName("仓单过户");
			} else if (LSConstants.WARRANTY_UNLOCK.equals(flag)) {
				interWarrantysUpdate.setInterfaceName("仓单解锁");
				interWarrantysUpdate.setBussinessNo(warrantyOthers.getBussinessNo());
				if (!StringUtil.isEmpty(warrantyOthers.getBussinessNumber())) {
					interWarrantysUpdate.setBussinessNumber(new BigDecimal(warrantyOthers.getBussinessNumber()));
				}
				if (!StringUtil.isEmpty(warrantyOthers.getBussinessPrice())) {
					interWarrantysUpdate.setBussinessPrice(new BigDecimal(warrantyOthers.getBussinessPrice()));
				}
				interWarrantysUpdate.setBussinessTime(warrantyOthers.getBussinessTime());
			}
			interWarrantysUpdate.setReturnCode("1");
			interWarrantysUpdate.setUpdateTime(date);
			interWarrantysUpdate.setOrgSysNo(warrantyOthers.getTrdSysNo());
			interUpdateDao.save(interWarrantysUpdate);
			// }else{
			// result.setRetResult("0");
			// }
		} catch (Exception e) {
			result.setRetResult("0");
			e.printStackTrace();
		}
		return result;
	}

	@Transactional
	public ResultMsgB warrantyOthersB(WarrantyOthers warrantyOthers, String flag) {
		ResultMsgB result = new ResultMsgB();
		result.setRetResult("1");
		String msg = "";
		try {
			Date date = DateUtil.toDateTime(dbTimeDao.getSysDateString());
			// 判断锁定 过户对象字段不能为空
			if (!CommonIs.lockAndChange(warrantyOthers, flag)) {
				if (LSConstants.WARRANTY_LOCK.equals(flag)) {
					msg += "锁定关键字段为空，";
				} else {
					msg += "解锁关键字段为空，";
				}
				result.setRetResult("0");
				result.setMsg(msg);
				return result;
			}
			Warranty warranty = warrantyDao.findOne(warrantyOthers.getWarrantyNo());
			// 相同仓单号和交易平台代码不能存在相同数据
			if (warranty == null) { 
				msg += "当前仓单号不存在，";
				result.setRetResult("0");
				result.setMsg(msg);
				return result;
			}
			if (LSConstants.WARRANTY_PRELOGINOUT.equals(warranty.getWarrantyStatus())) {
				msg += "当前仓单已注销不能操作，";
				result.setRetResult("0");
				result.setMsg(msg);
				return result;
			}
		
			warranty.setUpdateTime(date);
			// 保存仓单履历信息
			FtzWarrantyLog ftzWarrantyLog = new FtzWarrantyLog();
			BeanUtils.copyProperties(warranty, ftzWarrantyLog);
			if (LSConstants.WARRANTY_CHANGE.equals(flag)) {
				//如果是过户，暂不修改原仓单上的货主信息,也不修改状态，但须记录履历by zjs
				warranty.setWarrantyStatus(flag);
				warranty.setGoodsOwnerNum(warrantyOthers.getNewCustCode());
				warranty.setGoodsOwnerName(warrantyOthers.getNewCustName());
				warranty.setCustomerCode(warrantyOthers.getNewCustCode());
				warranty.setCustomerName(warrantyOthers.getNewCustName());
				warranty.setCustNameEn(warrantyOthers.getNewCustEName());
			}else{
				warranty.setWarrantyStatus(flag);
			}
			if (LSConstants.WARRANTY_LOCK.equals(flag)) {
				warranty.setBussinessNo(warrantyOthers.getBussinessNo());
				warranty.setBussinessPrice(new BigDecimal(warrantyOthers.getBussinessPrice()));
				warranty.setBussinessTime(warrantyOthers.getBussinessTime());
				ftzWarrantyLog.setBussinessPrice(new BigDecimal(warrantyOthers.getBussinessPrice()));
				ftzWarrantyLog.setBussinessTime(warrantyOthers.getBussinessTime());
			} 
			warrantyDao.save(warranty);
			WarrantyBean bean = new WarrantyBean();
			BeanUtils.copyProperties(warranty, bean);

			
			ftzWarrantyLog.setId(GuidUtil.newGuid());
			ftzWarrantyLog.setNewStatus(flag);
			if(LSConstants.WARRANTY_CHANGE.equals(flag)){//过户需要保存新老货主信息到履历by zjs
				ftzWarrantyLog.setOrgCustCode(warrantyOthers.getOrgCustCode());
				ftzWarrantyLog.setOrgCustName(warrantyOthers.getOrgCustName());
				ftzWarrantyLog.setNewCustCode(warrantyOthers.getNewCustCode());
				ftzWarrantyLog.setNewCustName(warrantyOthers.getNewCustName());
				ftzWarrantyLog.setCompareFlag("0");
			}else{
				ftzWarrantyLog.setNewCustCode(warranty.getGoodsOwnerNum());
				ftzWarrantyLog.setNewCustName(warranty.getGoodsOwnerName());
			}
			ftzWarrantyLog.setCreateTime(date);
			ftzWarrantyLogDao.save(ftzWarrantyLog);
			result.setMain(bean);
			result.setLog(ftzWarrantyLog);
		} catch (Exception e) {
			msg += "修改仓单表状态异常" + e.getStackTrace();
			result.setRetResult("0");
		}
		result.setMsg(msg);
		return result;
	}
	
	
	private String generateWarranntyNo(){
	    return businessCommon.generateCode(BusinessCommon.WARRANTY_NO)+UtilCommon.getRandomCode(6);
      }
	
	
	//实物比对
	private void handleComparisonResult(Warranty warranty,List<WarrantyGoodBean> goodsList){
		String orgSysNo=warranty.getOrgSysNo();
		String warehouseNum=warranty.getWarehouseNum();
		String warehouseName=warranty.getWarehouseName();
		CompareData compareData=compareDataDao.findByOrgSysNoAndWarehouseName(orgSysNo,warehouseName);
		if(null!=compareData 
				&& LSConstants.COMPARE_DATA_ENTITY.equals(compareData.getCompareType())
				&& LSConstants.ENTITY_INTEEFACE_SS.equals(compareData.getInterfaceType())){//只做实物比对
			logger.info("仓库代码："+warehouseName+"和交易平台代码："+orgSysNo+"配置配置的实物比对");
			String resultFlag="1";//初始化比对结果
			for (WarrantyGoodBean warrantyGoodBean : goodsList) {
				String tnsByWarehouseUrl=compareData.getWareUrl();
				String uecp_url = (String)lgsBaols.get("FTZ_UECP_URL");
				//uecp_url="http://datacenter.bsteel.net/ws/proxy_ws";
				if(StringUtil.isEmpty(tnsByWarehouseUrl) || StringUtil.isEmpty(uecp_url) ) return;
				String goodId=warrantyGoodBean.getGoodId();
				String className=compareData.getWareClass();
				String methodName=compareData.getWareMethod();
				String formId=compareData.getUecpFormid();
				String toId=compareData.getUecpToid();
				String platcodeId=compareData.getUecpPlatCode();
				logger.info("交易平台代码："+orgSysNo+"--仓库代码："+warehouseNum+"--纸质仓单号（仓库提供）"+warrantyGoodBean.getGoodId()
						+"仓库webservice地址："+tnsByWarehouseUrl+"--uecp_url:"
						+uecp_url+"--formId:"+formId+"--toId:"+toId+"--platcodeId:"+platcodeId);
				String resultMsg="";
				try {
					Object[] objS = new Object[] {orgSysNo,warehouseNum,goodId};
					Object obj = WsdlUtil.getInstance().wsUECPClient(uecp_url, tnsByWarehouseUrl, methodName, formId,toId,platcodeId, objS);
					logger.info("obj="+obj);
					JSONObject json=JSONObject.fromObject(obj);
					String result=json.getString("RTN_CODE");
					JSONObject good=JSONObject.fromObject(json.get("RTN_DATA"));
					if("1".equals(result) && !good.isEmpty()){//查询到数据才比对
						BigDecimal weight=warrantyGoodDao.sumWeghtByGoodId(warrantyGoodBean.getGoodId());
						if(null==weight){
							weight=warrantyGoodBean.getWeightB();
						}
						BigDecimal cc_weight=BigDecimal.valueOf(Double.valueOf((String)good.get("weightB")));//重量
						String cc_weightUnit=(String) good.get("weightUnit");//重量单位	
						String cc_prdCataCode=(String)good.get("prdCataCode");//品种代码
						String ctmPrdCode=(String)good.get("ctmPrdCode");//海关商品编号
						//String ctmdeclarationNo=(String)good.get("ctmdeclarationNo");//海关报关单号
						//比对字段有：重量，重量单位，品种代码，海关报关单号
						logger.info("仓库数据："+cc_weight+"--"+cc_weightUnit+"--"+cc_prdCataCode+"--"+ctmPrdCode);
						logger.info("交易数据："+weight+"--"+warrantyGoodBean.getWeightUnit()+"--"+warrantyGoodBean.getPmCode()+"--"+warranty.getCtmPrdCode());
						
						if(weight.compareTo(cc_weight)>0 
								|| !warrantyGoodBean.getPmCode().equals(cc_prdCataCode)
								|| !warrantyGoodBean.getWeightUnit().equals(cc_weightUnit)
								|| !warranty.getCtmPrdCode().equals(ctmPrdCode)
								
								//|| !warrantyGoodBean.getCtmDeclarationNo().equals(ctmdeclarationNo)
								){
							resultFlag="0";
							StringBuffer bf=new StringBuffer();
							if(weight.compareTo(cc_weight)>0){
								bf.append("重量--");
							}
							if(!warrantyGoodBean.getPmCode().equals(cc_prdCataCode)){
								bf.append("品种 --");
							}
							if(!warrantyGoodBean.getWeightUnit().equals(cc_weightUnit)){
								bf.append("重量单位--");
							}
							if( !warranty.getCtmPrdCode().equals(ctmPrdCode)){
								bf.append("海关商品编号--");
							}
							bf.append("比对错误");
							resultMsg=bf.toString();
						}
					}else{
						resultMsg="查询不到数据比对，比对错误";
						resultFlag="0";
					}
				} catch (Exception e) {
					resultMsg="接口调用失败，比对错误";
					resultFlag="0";
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				logger.info(resultMsg);
				if("1".equals(resultFlag)){
					warranty.setWarehouseCredit( LSConstants.COMPARE_DATA_ENTITY);
			    	warranty.setWarehouseIconName(this.getCreditIconName(LSConstants.FROM_FLAG_CC, LSConstants.COMPARE_DATA_ENTITY));
				}else{//异议走比对异议逻辑+短信发送
					//保存比对异议信息
					String compareNo =this.warrantyCompareFail(warranty, resultMsg, LSConstants.FROM_FLAG_CC);
					this.sendMassage(compareNo, LSConstants.FROM_FLAG_CC);
					//保存短息发送信息
					//warranty.setWarehouseCredit( LSConstants.COMPARE_DATA_OBJECTION);//比对出错为4：异议
			    	//warranty.setWarehouseIconName(this.getCreditIconName(LSConstants.FROM_FLAG_CC, LSConstants.COMPARE_DATA_OBJECTION));
				}
			}
		}
	} 

	/**
	 * 1.查询可以发送的短信号码
	 * 2.给没有号码发送短信
	 * 3.记录短信发送消息
	 */
	private void sendMassage(String compareNo, String flag){
		List<OrcTMessageUserphone> userphones=orcTMessageUserphoneDao.findByFccodeAndMarketFlag(LSConstants.MSG_COMPARE_YY,LSConstants.FTZ_MARKET_FLAG);
		for (OrcTMessageUserphone userphone : userphones) {
			String compareName="";
			if(LSConstants.FROM_FLAG_CC.equals(flag)){
				compareName="仓库比对异议";
			}else if(LSConstants.FROM_FLAG_QS.equals(flag)){
				compareName="清算比对异议";
			}
			String format="您有一条"+compareName+"　异议单号为："+compareNo;
			//发送成功为0,失败为2
			String result= SMSPlatformImpl.getInstance().sendSMS(userphone.getPhoneNum(),format);//发短息
			OrcTMassageDetails details=new OrcTMassageDetails();
	   		details.setId(GuidUtil.newGuid());
	   		details.setUsercode(userphone.getCustomerCode());
	   		details.setPhone(userphone.getPhoneNum());
	   		details.setText(format);
	   		details.setFccode(userphone.getFccode());
	   		details.setUsername(userphone.getCustomerName());
	   		details.setSendtime(dbTimeDao.getSysDateString());
	   		details.setSendtimes(new BigDecimal(1));
	   		//为了让其重发 保存状态为 发送失败
	   		details.setFlag(result=="0"?"1":"0");
	   		orcTMassageDetailsDao.save(details);
		}
	}
	
	/**
	 * 生成比对异议信息
	 * @param warranty 仓单信息
	 * @param flag　比对类型
	 */
	private String  warrantyCompareFail(Warranty warranty,String resultMsg ,String flag){
		String mainId=GuidUtil.newGuid();
		String compareNo=businessCommon.generateCode(BusinessCommon.FTZ_COM_RESULT);
		WarrantyCompareDetail warrantyCompareDetail =new WarrantyCompareDetail();
		warrantyCompareDetail.setCustCode(warranty.getGoodsOwnerNum());
		warrantyCompareDetail.setCustName(warranty.getGoodsOwnerName());
		warrantyCompareDetail.setErrMsg(resultMsg);
		warrantyCompareDetail.setErrorType("");
		warrantyCompareDetail.setMainId(mainId);
		warrantyCompareDetail.setNum(warranty.getNum());
		warrantyCompareDetail.setResultFlag("0");
		warrantyCompareDetail.setUnit(warranty.getUnit());
		warrantyCompareDetail.setWarrantyNo(warranty.getWarrantyNo());
		warrantyCompareDetail.setWeight(warranty.getWeight());
		warrantyCompareDetail.setWeightUnit(warranty.getWeightUnit()==null?"吨":warranty.getWeightUnit());
		warrantyCompareDetail.setId(GuidUtil.newGuid());
		warrantyCompareDetailDao.save(warrantyCompareDetail);
		
		WarrantyCompare warrantyCompare=new WarrantyCompare();
		warrantyCompare.setCompareNo(compareNo);
		warrantyCompare.setCompareTime(dbTimeDao.getSysdate());
		warrantyCompare.setCompareType(LSConstants.COMPARE_DATA_ENTITY);
		warrantyCompare.setFromFlag(flag);
		warrantyCompare.setFtzTotalNum(warranty.getNum());//公示平台
		warrantyCompare.setFtzTotalWeight(warranty.getWeight());//公示平台
		warrantyCompare.setId(mainId);
		warrantyCompare.setIsPublic("1");//是否公开
		warrantyCompare.setNumUnit("--");
		warrantyCompare.setWeightUnit(warranty.getWeightUnit());
		warrantyCompare.setOrgSysNo(warranty.getOrgSysNo());
		warrantyCompare.setOrgSysName(warranty.getOrgSysName());
		warrantyCompare.setOtherTotalNum(0);//仓储品台
		warrantyCompare.setOtherTotalWeight(new BigDecimal(0));//仓库平台
		warrantyCompare.setPrdCataCode("--");
		warrantyCompare.setPrdCataName("--");
		warrantyCompare.setResultFlag("0");
	    warrantyCompare.setObjectionOrder("0");
		warrantyCompare.setTransferType(LSConstants.COMPARE_DATA_TRANSFER_NO);
		warrantyCompare.setWarehouseNum(warranty.getWarehouseNum());
		warrantyCompare.setWarehouseName(warranty.getWarehouseName());
		warrantyCompare.setMarketFlag(LSConstants.FTZ_MARKET_FLAG);
		warrantyCompare.setAbnormalNum(1);
		warrantyCompareDao.save(warrantyCompare);
		return compareNo;
	}
	
	
	/**
	 * 通过清算实时接口，比较过户信息
	 * @param warrantyOthers
	 * @param warranty
	 * @return warrantyStatus 仓单状态
	 */
	private String clearCompare( WarrantyOthers warrantyOthers,Warranty warranty){
		String warrantyStatus=warranty.getWarrantyStatus();
		String result="";
		String resultMsg="";
		if("1".equals(result)){//清算比对成功
			warranty.setGoodsOwnerNum(warrantyOthers.getNewCustCode());
			warranty.setGoodsOwnerName(warrantyOthers.getNewCustName());
			warranty.setCustomerCode(warrantyOthers.getNewCustCode());
			warranty.setCustomerName(warrantyOthers.getNewCustName());
			warranty.setCustNameEn(warrantyOthers.getNewCustEName());
		}else{//清算比对失败--保存比对异议信息
			result=LSConstants.WARRANTY_DQSYZ;
			warranty.setWarrantyStatus(result);
			String compareNo =this.warrantyCompareFail(warranty, resultMsg, LSConstants.FROM_FLAG_QS);
			this.sendMassage(compareNo, LSConstants.FROM_FLAG_QS);
		}
		return warrantyStatus;
	}
	
	/**
	 * 获取诚信标记图片
	 * @param platType
	 * @param compareType
	 * @return
	 */
	protected String getCreditIconName(String platType, String compareType){
		String iconName="";
		CreditIcon creditIcon=creditIconDao.findByPlatTypeAndCompareType(platType, compareType);
		if(null!=creditIcon){
			iconName=creditIcon.getIconName();
		}
		return iconName;
	}
}
