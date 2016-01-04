
package com.ouyeelf.ftz.service.common;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ouyeelf.ftz.common.constant.LSConstants;
import com.ouyeelf.ftz.common.utils.DateUtil;
import com.ouyeelf.ftz.common.utils.GuidUtil;
import com.ouyeelf.ftz.common.utils.StringUtil;
import com.ouyeelf.ftz.model.domain.warranty.Warranty;
import com.ouyeelf.ftz.persist.dao.CommonDao;

@Service("businessCommon")
public class BusinessCommon {
	private static Log logger = LogFactory.getLog(BusinessCommon.class);
	/**
	 * 按照规则生成业务单据代码
	 */
	@Autowired
	private CommonDao commonDao;
	

	// 授信协议号
	public static final int CREDIT_CODE = 1;
	// 融资协议
	public static final int TRIPLE_CODE = 3;
	// 融资申请
	public static final int APPLICATION_CODE = 2;
	// 赎单号
	public static final int REDEEM_CODE = 9;
	// 贷款批次号
	public static final int LOAD_BATCH_ID = 11;

	// 质押清单号
	public static final int MORTGAGE_ID = 12;

	// 盘库指令号
	public static final int MORTGAGE_CHECK_ID = 15;

	// 解押通知号
	public static final int RZ_RELEASW_MOR_NOTICE_ID = 18;
	
	// 库位标签号
	public static final int RZ_MORTGAGE_LABEL = 19;
	
	// 明细标签号
	public static final int RZ_MORTGAGE_DETAIL_LABEL = 20;
	
	//仓单号
	public static final int WARRANTY_NO = 25;
	//仓单申请号
	public static final int WARRANTY_APP_NO=26;
	
	//银行质权登记申请号
	public static final int REGISTER_CODE = 27;
	//银行质权登记号
	public static final int REGISTER_REAL_CODE = 28;
	//盘点单主项Id
	public static final int  CHECK_GOODS_ID=32 ; //
	//委托监管主项Id
	public static final int  DELEGATE_SUPV_ID=33 ; //
	/**
	 * 自贸区比对结果单据号：(ftz comparison result首字母缩写+年月日+7位流水) FCR1404090000001
	 */
	
	public static final int FTZ_COM_RESULT=50;
	public String generateCode(int codeType) {
		return generateCode(codeType, "");
	}

	public String generateCode(int codeType, String prefix) {
		String returnValue = "";
		String seq = "";
		int codeLength = 3;
		String prefixSelf = prefix;
		switch (codeType) {
		case TRIPLE_CODE: // 生成系统协议号：XY+yyyymmdd+三位流水号
			seq = "SEQ_TRIPLE_AGREEMENT";
			prefixSelf = (StringUtil.isEmpty(prefix) ? "XY" : prefix)
					+ DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
							2, 8);
			codeLength = 3;
			break;
		case CREDIT_CODE: // 生成系统授信号：SX+yyyymmdd+三位流水号
			seq = "SEQ_CREDIT_LIMITS";
			prefixSelf = (StringUtil.isEmpty(prefix) ? "SX" : prefix)
					+ DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
							2, 8);
			codeLength = 3;
			break;
		case REDEEM_CODE: // 生成赎单号：SD+yyyymmdd+三位流水号
			seq = "SEQ_REDEEM_ID";
			prefixSelf = (StringUtil.isEmpty(prefix) ? "SD" : prefix)
					+ DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
							2, 8);
			codeLength = 3;
			break;
		case APPLICATION_CODE: //
			seq = "SEQ_RZ_T_FINANCE_APPLICATION";
			prefixSelf = (StringUtil.isEmpty(prefix) ? "FA" : prefix)
					+ DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
							2, 8);
			codeLength = 5;
			break;
		case LOAD_BATCH_ID: // 放款批次主键
			seq = "SEQ_RZ_T_FINANCE_LOAN_BATCH_ID";
			prefixSelf = DateUtil.toDateString(new Date(), "yyyyMMdd")
					.substring(2, 6);
			codeLength = 4;
			break;
		case MORTGAGE_ID: //
			seq = "SEQ_RZ_MORTGAGE";
			prefixSelf = (StringUtil.isEmpty(prefix) ? "ZY" : prefix)
					+ DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
							2, 8);
			codeLength = 7;
			break;

		case MORTGAGE_CHECK_ID: //
			seq = "SEQ_RZ_T_MORTGAGE_CHECK";
			prefixSelf = (StringUtil.isEmpty(prefix) ? "CM" : prefix)
					+ DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
							2, 8);
			codeLength = 4;
			break;
		case RZ_RELEASW_MOR_NOTICE_ID: // 解押通知号
			seq = "SEQ_RZ_RELEASW_MOR_NOTICE";
			prefixSelf = (StringUtil.isEmpty(prefix) ? "RM" : prefix)
					+ DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
							2, 8);
			codeLength = 4;
			break;
		case RZ_MORTGAGE_LABEL: // 库位标签号
			seq = "SEQ_RZ_MORTGAGE_LABEL";
			prefixSelf = (StringUtil.isEmpty(prefix) ? "" : prefix)
					+ DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
							2, 8);
			codeLength = 3;
			break;
		case RZ_MORTGAGE_DETAIL_LABEL: // 库位标签号+明细流水号
			seq = "SEQ_RZ_MORTGAGE_DETAIL_LABEL";
			prefixSelf = (StringUtil.isEmpty(prefix) ? "KWMX" : prefix);
			codeLength = 3;
			break;
		case WARRANTY_NO: // 生成仓单号 ：CD+yyyymmdd+三位流水号
			seq = "SEQ_WARRANTY_NO";
			prefixSelf = (StringUtil.isEmpty(prefix) ? "W" : prefix)
					+ DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
							2, 8);
			codeLength = 6;
			break;
		case WARRANTY_APP_NO: // 生成预申请号 ：CD+yyyymmdd+三位流水号
			seq = "SEQ_WARRANTY_APP_NO";
			prefixSelf = (StringUtil.isEmpty(prefix) ? "P" : prefix)
					+ DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
							2, 8);
			codeLength = 6;
			break;
		case REGISTER_CODE: //银行质权登记申请号  ：RAS+yymmdd+4位流水号 //银行质权登记申请号 20131104 原来是HT开头，改成RA开头
			seq = "SEQ_REGISTER_CODE";
			prefixSelf = (StringUtil.isEmpty(prefix) ? "RAS" : prefix)
					+ DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
							2, 8);
			codeLength = 4;
			break;
		case REGISTER_REAL_CODE: //银行质权登记号  ：PAS+yymmdd+4位流水号
			seq = "SEQ_REGISTER_REAL_CODE";
			prefixSelf = (StringUtil.isEmpty(prefix) ? "PAS" : prefix)
					+ DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
							2, 8);
			codeLength = 4;
			break;
		case CHECK_GOODS_ID: // 2位仓库号+6位日期+4位流水 : CHECKGOODSID
			seq = "SEQ_CHECK_GOODS_ID";
			prefixSelf = (StringUtil.isEmpty(prefix) ? "GC" : prefix)
					+ DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
							2, 8);
			codeLength = 4;
			break;
		case FTZ_COM_RESULT: // 2位仓库号+6位日期+4位流水 :id
			seq = "SEQ_FTZ_COM_RESULT";
			prefixSelf = (StringUtil.isEmpty(prefix) ? "FCR" : prefix)
					+ DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
							2, 8);
			codeLength = 7;
			break;	
		case DELEGATE_SUPV_ID: // 2位仓库号+6位日期+4位流水 :id
			seq = "SEQ_DS_T_DELEGATE_SUPV";
			prefixSelf = (StringUtil.isEmpty(prefix) ? "SDS" : prefix)
					+ DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
							2, 8);
			codeLength = 4;
			break;		
			
			
		}
		
		returnValue = commonDao.getSequenceValue(seq);
		returnValue = prefixSelf + loopString(returnValue, "0", codeLength, true);
				
		return returnValue;
	}

	public String getSequenceValue(String sequenceName) {
		return commonDao.getSequenceValue(sequenceName);
	}

	/**
	 * 在一个字符串前面或后面补充一些字符以将原来的字符串处理为要求的长度。 但是如果源字符串的长度已经足够长就什么也不干。
	 * 
	 * @param source
	 *            　要进行处理的字符串，如"123"
	 * @param loopString
	 *            　要补充的字符串,如"0"
	 * @param destinctLength
	 *            最终要生成的字符串的长度
	 * @param appendHead
	 *            　补充在前面还是后面，true表示补充在源字符串的前面，false表示补充在源字符串的后面
	 * @return 最终生成的字符串
	 */
	public static String loopString(String source, String loopString,
			int destinctLength, boolean appendHead) {
		// TODO:用StringBuffer代替String的＋操作
		String returnValue = source;
		int loopCount = destinctLength - source.length();
		for (int i = 0; i < loopCount; i++) {
			if (appendHead)
				returnValue = loopString + returnValue;
			else
				returnValue += loopString;
		}
		return returnValue;
	}
	
/*	 *//**
	  * 通过仓库代码查询监管公司信息
	  * 
	  *//*
	  public OrcTBindConf  queryOrcTBindConfByDepotUCode(String depotUCode){
		  return commonDao.queryOrcTBindConfByDepotUCode(depotUCode);
	  }
	  */
	  
		
		

		
		//计算仓单比对结果表总重量总数量
		public Object[] queryWarrantyCompareDetail(String mainId,String resultFlag){
			return commonDao.queryWarrantyCompareDetail(mainId,resultFlag);
		}
		
		// 查询当前市场标记，且状态不是注销的仓单数据
		public List<Object[]> findSys(Warranty vo,String flag) {
			return commonDao.findSys(vo,flag);
		}
		
		public  List<Object[]> findsome(String customerName,String orgSysNo,String markFlag,String warhouseName,String status){
			return commonDao. findsome(customerName, orgSysNo, markFlag, warhouseName, status);
		}
		
		//查询宝赢通仓库代码，货主代码
		public List<String> queryWarehouseInfo(String code,String resultFlag){
			return commonDao.queryWarehouseInfo(code,resultFlag);
		}
		
		//计算仓单比对结果表总重量总数量
		public Object[] queryCheckGoodDetail(String checkNo){
			return commonDao.queryCheckGoodDetail(checkNo);
		}
		
		/**
		 * 自贸区首页统计总重量
		 * @param pmCode
		 * @return
		 */
		public long sumWeight(String pmCode){
			return commonDao.sumWeight(pmCode);
		}
		/**
		 * 自贸区查询某角色代码名称
		 * @param pmCode
		 * @return
		 */
		public List<Object[]> selectCodeAndName(String role){
			return commonDao.selectCodeAndName(role);
		}
		/**
		 * 模糊查询贸易商
		 * @param pmCode
		 * @return
		 */
		public List<Object[]> selectFinLikeName(String name) {
			return commonDao.selectFinLikeName(name) ;
		}
		/*
		 * 查询收藏 操作员代码对应  与收藏量
		 */
		public List<Object[]> queryFavorites(){
			return commonDao.queryFavorites();
		}
		
		/*
		 * 查询收藏 操作员代码对应 手机 与变化收藏量
		 */
		public long queryFavoritesChange(String operId){
			return commonDao.queryFavoritesChange(operId);
		}
		
		/**
		 * 查询海关，清算，仓库异常
		 * @return
		 */
		public List<Object[]> findAbnormal(){
			return commonDao.findAbnormal();
		}
		
		/**
		 * 查询投诉,对比，质检异议待处理
		 * @return
		 */
		public List<Object[]> findDissent(){
			return commonDao.findDissent();
		} 
		
		/**
		 * 查询投诉,对比，质检异议待反馈
		 * @return
		 */
		public List<Object[]> findFeedback(){
			   return commonDao.findFeedback();
		}
		
		/**
		 * 获取公示日期
		 * @return
		 */
		public String getCompareDate(){
			return commonDao.findCompareDate();
		}
		
	/*	public List<String> queryUserPhone(OrcTMessageUserphoneVo vo   ) {
			return commonDao.queryUserPhone(vo);
		}
*/
		public List<Object[]> queryUserFccname(String phone){
			return commonDao.queryUserFccname(phone);
		}
		
		//查询是否是会员
		public String getUsercode(String usercode) {
			return commonDao.getUsercode(usercode);
		}
		//查询当前登录的用户的电话号码是否在orc_t_message_userphone表中存在
		public List<Object[]> isExisPhone(String usercode,String marketFlag){
			return commonDao.isExisPhone(usercode,marketFlag);
		}
		
		//查询用户的电话号码
		public String gettellphone(String usercode) {
			return commonDao.gettellphone(usercode);
		}
		
	/*	public List<String> queryUserPhonePage(OrcTMessageUserphoneVo vo ,String flag  ) {
			return commonDao.queryUserPhonePage(vo,flag);
		}*/
		/*
		 * 	//自贸区短信维护 弹出列表查询
		 */
		public List<Object[]> queryWeihu(String customerCode,String marketFlag){
			return commonDao.queryWeihu(customerCode,marketFlag);
		}
		
		/**
		 根据操作员代码差名称
		 * @return
		 */
		public String getUserNameByUserCode(String userCode){
			return commonDao.getUserNameByUserCode(userCode);
		}
		
		public  String  isJinFu(String applicationId)
		{
			return commonDao.isJinFu(applicationId);
		}
		/**
		 * 查询数据授权，是否存在
		 * @param userId
		 * @param userName
		 * @param pageUrl
		 * @param trdCode
		 * @param authStatus
		 * @return
		 */
		public BigDecimal findDataFilter(String userId,String pageUrl,String trdCode,String authStatus){
			return commonDao.findDataFilter( userId, pageUrl, trdCode, authStatus);
		}
		/**
		 *  统计当前日每个交易平台的登记（数）量<br>
		 *  Object[0] 交易平台名称<br>
		 *  Object[1] 交易平台代码<br>
		 *  Object[3] 登记数量
		 */
		public List<Object[]> queryTraderRegisterCount(){
			return commonDao.queryTraderRegisterCount();
		}
		
		public List<Object[]> countOrgSysNameTraderRegister(){
			return commonDao.countOrgSysNameTraderRegister();
			
		}
		public Object[] getPlatformInfo(){
			return commonDao.getPlatformInfo();
		}
		
}
