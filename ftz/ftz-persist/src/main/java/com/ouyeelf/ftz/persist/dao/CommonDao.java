package com.ouyeelf.ftz.persist.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.common.constant.LSConstants;
import com.ouyeelf.ftz.common.utils.DateUtil;
import com.ouyeelf.ftz.common.utils.StringUtil;
import com.ouyeelf.ftz.model.domain.compare.WarrantyCompare;
import com.ouyeelf.ftz.model.domain.warranty.Warranty;

@Service("commonDao")
public class CommonDao {
	private static final String BigDecimals = null;
	private static Log logger = LogFactory.getLog(CommonDao.class);
	@PersistenceUnit
	private EntityManagerFactory emf;
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@SuppressWarnings("unchecked")
	public List<Object[]> executeFindSql(String sql) {
		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sql).getResultList();
	}

	@SuppressWarnings("unchecked")
	public String getSequenceValue(String sequenceName) {
		String sql = "select to_char(" + sequenceName
				+ ".nextval) as value from dual";
		EntityManager em = emf.createEntityManager();
		List<String> valueList = (List<String>) em.createNativeQuery(
				sql.toString()).getResultList();
		if (valueList != null && valueList.size() > 0)
			return valueList.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getMortgageInfos() {
		String sql = "select t1.customer_code,t1.customer_name,t1.warehouse_num,t1.warehouse_name, "
				+ "t1.bank_code,t1.bank_name,t1.supervior_code,t1.supervior_name,t2.area,t2.location, "
				+ "t1.application_id,sum(t2.sheet_num),t2.unit,sum(t2.weight_c),t1.mortgage_no "
				+ "from rz_mortgage t1,rz_mortgage_good t2 where t1.mortgage_status >= '30' and "
				+ "t1.mortgage_no=t2.mortgage_no and trim(t2.label_location_no) is null and "
				+ "trim(t2.label_no) is null group by t1.customer_code,t1.customer_name, "
				+ "t1.warehouse_num,t1.warehouse_name,t1.bank_code,t1.bank_name,t1.supervior_code, "
				+ "t1.supervior_name,t2.area,t2.location,t1.application_id,t2.unit,t1.mortgage_no";

		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sql).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getWarrantyInfos() {
		String sql = "select t1.customer_code,t1.customer_name,t1.warehouse_num,t1.warehouse_name,t1.pledgee_Code,t1.pledgee_Name, t2.area,t2.location, "
				+ "t1.application_id,sum(t2.sheet_num),t2.unit,sum(t2.weight_c),t1.warranty_no "
				+ "from rz_warranty t1,rz_warranty_good t2 where t1.warranty_status in  ('05','51')  and "
				+ "t1.warranty_no=t2.warranty_no and trim(t2.label_location_no) is null and "
				+ "trim(t2.label_no) is null group by t1.customer_code,t1.customer_name, "
				+ "t1.warehouse_num,t1.warehouse_name,t1.pledgee_Code,t1.pledgee_Name,"
				+ "t2.area,t2.location,t1.application_id,t2.unit,t1.warranty_no";

		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sql).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> queryOperator(String userId, String operatorName) {
		String sql = "select t.operator_id as operatorId,t.operator_name as operatorName from tb_operator t where t.user_id='"
				+ userId
				+ "'"
				+ " and t.operator_name like '%"
				+ operatorName
				+ "%'";

		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sql).getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Object[]> queryOwnName(String operatorName) {
		String sql = "select b.userNum,b.chineseUserName from UserRefRole a,Tscsc01 b where a.userId = b.userNum and a.roleId='01'"
				+ "  and b.chineseUserName  like '%" + operatorName + "%'";

		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createQuery(sql).getResultList();

	}

	// select b.userNum,b.chineseUserName from UserRefRole a,Tscsc01 b where
	// a.userId = b.userNum and a.roleId='01'

	@SuppressWarnings("unchecked")
	public List<Object[]> queryGrede(String typeName, String operatorGrade) {

		String sql = "select distinct t.grade as grade from rz_stock_info t where  t.warranty_app_no is null and ( t.flag = '0' or t.flag = '4' or t.flag is null ) and t.type_name='"
				+ typeName
				+ "'"
				+ " and t.grade like '%"
				+ operatorGrade
				+ "%'";

		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sql).getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Object> getGrade(String typeName) {

		String sql = "select distinct t.grade as grade from rz_stock_info t where  t.warranty_app_no is null and ( t.flag = '0' or t.flag = '4' or t.flag is null ) and t.type_name='"
				+ typeName + "'";
		EntityManager em = emf.createEntityManager();
		return (List<Object>) em.createNativeQuery(sql).getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Object> getGradeBy(String typeName, String customerBspCode,
			String warehouseNum) {

		String sql = "select distinct t.grade as grade from rz_stock_info t where  t.warranty_app_no is null and ( t.flag = '0' or t.flag = '4' or t.flag is null ) and t.type_name='"
				+ typeName
				+ "'"
				+ " and t.customer_bsp_code='"
				+ customerBspCode
				+ "'"
				+ " and t.rz_warehouse_code='"
				+ warehouseNum + "'";
		EntityManager em = emf.createEntityManager();
		return (List<Object>) em.createNativeQuery(sql).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> queryWarrantyNo(String operatorWarrantyNo) {

		String sql = "select t.warranty_no as warrantyNo from rz_warranty t where t.warranty_no like '"
				+ operatorWarrantyNo
				+ "%'"
				+ " and t.warranty_status='10' order by t.create_time desc";

		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sql).getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Object> queryDeptCustomerName(String operatorDeptCustomerName,
			String deptName) {
		StringBuffer sql = new StringBuffer(
				"select distinct wc.dept_customer_name  from rz_warehouse_customer_info wc where 1=1 ");

		if (!StringUtil.isEmpty(deptName)) {
			sql.append("  and wc.DEPT_NAME='" + deptName + "'");
		}

		sql.append("  and wc.dept_customer_name like '"
				+ operatorDeptCustomerName + "%'");

		// String sql =
		// "select distinct wc.dept_customer_name  from rz_warehouse_customer_info wc where 1=1 wc.dept_customer_name like '"+operatorDeptCustomerName+"%'";

		EntityManager em = emf.createEntityManager();
		return (List<Object>) em.createNativeQuery(sql.toString())
				.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Object> queryDeptName(String operatorDeptName,
			String deptCustomerName) {
		StringBuffer sql = new StringBuffer(
				"select distinct wc.DEPT_NAME  from rz_warehouse_customer_info wc where 1=1 ");

		if (!StringUtil.isEmpty(deptCustomerName)) {
			sql.append("  and wc.dept_customer_name='" + deptCustomerName + "'");
		}

		sql.append("  and wc.DEPT_NAME like '" + operatorDeptName + "%'");
		EntityManager em = emf.createEntityManager();
		return (List<Object>) em.createNativeQuery(sql.toString())
				.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Object[]> queryDeptNameCustomerBspCode(String operatorDeptName,
			String customerBspCode) {
		StringBuffer sql = new StringBuffer(
				"select distinct wc.DEPT_NAME  from rz_warehouse_customer_info wc where 1=1 ");

		if (!StringUtil.isEmpty(customerBspCode)) {
			sql.append("  and wc.CUSTOMER_BSP_CODE='" + customerBspCode + "'");
		}

		sql.append("  and wc.DEPT_NAME like '" + operatorDeptName + "%'");
		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sql.toString())
				.getResultList();

	}

	// 通过仓库BSP名称查询仓库代码
	@SuppressWarnings("unchecked")
	public String getDeptIdByDeptName(String deptName) {
		String result = "";
		// StringBuffer sql = new
		// StringBuffer(" select distinct wc.dept_id from rz_warehouse_customer_info wc where wc.dept_name = '"+deptName+"'");
		StringBuffer sql = new StringBuffer(
				" select distinct wc.dept_id from rz_warehouse_customer_info wc where wc.dept_bsp_name = '"
						+ deptName + "'");
		EntityManager em = emf.createEntityManager();
		try {
			return (String) em.createNativeQuery(sql.toString())
					.getSingleResult();
		} catch (NoResultException e) {
			return result;
		}
	}

	// 通过存货人BSP名称查询存货人代码
	public String getGoodsOwnerNumByGoodsOwnerName(String goodsOwnerName,
			String deptId) {
		// StringBuffer sql = new
		// StringBuffer("select distinct wc.dept_customer_id from  rz_warehouse_customer_info wc where wc.dept_customer_name like '"+goodsOwnerName+"'");
		StringBuffer sql = new StringBuffer(
				"select distinct wc.dept_customer_id from  rz_warehouse_customer_info wc where wc.dept_customer_bsp_name like '"
						+ goodsOwnerName + "'");
		if (!StringUtil.isEmpty(deptId)) {
			sql.append("  and wc.dept_id='" + deptId + "'");
		}
		EntityManager em = emf.createEntityManager();
		try {
			return (String) em.createNativeQuery(sql.toString())
					.getSingleResult();
		} catch (NoResultException e) {
			return "";
		}
	}

	// 通过bsp的仓库名称查询bsp的客户名称
	public List<String> getDeptCustomerBspNameByDeptBspName(String deptName) {
		StringBuffer sql = new StringBuffer(
				"select distinct c.dept_customer_bsp_name from rz_warehouse_customer_info c where c.dept_name='"
						+ deptName + "'");
		EntityManager em = emf.createEntityManager();
		return em.createNativeQuery(sql.toString()).getResultList();
	}

	// select wi.dept_id,wi.dept_name from rz_warehouse_info wi where
	// wi.dept_id='0301';
	public List<Object[]> getWarehouseInfoByDepId(String depId) {
		StringBuffer sql = new StringBuffer(
				"select wi.dept_id,wi.dept_name  from rz_warehouse_info wi where wi.dept_id= '"
						+ depId + "'");
		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sql.toString())
				.getResultList();

	}

	// 根据银行的companyId查找岗位流程
	@SuppressWarnings("unchecked")
	public List<Object[]> queryJobProcess(String companyId, String jobId) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select");

		sbf.append(" d.id as Id,");
		sbf.append(" d.job_id as jobId,");
		sbf.append(" d.job_name as jobName,");
		sbf.append(" d.superior_job_id as superiorJobId,");
		sbf.append(" d.bank_num as bankNum,");
		sbf.append(" d.bank_name as bankName,");
		sbf.append(" d.remark as remark, ");
		sbf.append(" d.bank_branch_num as  bankBranchNum,");
		sbf.append(" d.bank_branch_name as bankBranchName");

		sbf.append(" from rz_job_process d");
		sbf.append(" where d.bank_branch_num = '" + companyId + "'");

		sbf.append(" start with d.job_id = '" + jobId + "'");
		sbf.append(" connect by prior d.job_id = d.superior_job_id");

		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sbf.toString())
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> queryJob(String paramStr) {
		String sql = "select a.job_id as jobId, a.job_name as jobName, b.umc_company_code as companyId, b.chinese_user_name as chineseUserName "
				+ "from RZ_JOB a, tscsc01 b where a.company_id = b.user_num and b.umc_company_code in ("
				+ paramStr
				+ ") "
				+ "and not exists (select * from RZ_JOB_PROCESS j where j.bank_branch_num in ("
				+ paramStr + ") and j.job_id = a.job_id)";
		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sql).getResultList();

	}

	// 根据公司代码获取父节点代码
	public String getParentUserNum(String userNum) {
		String sql = "select t.parent_user_num from RZ_T_UUP_ORGTREE t where t.user_num = '"
				+ userNum + "'";
		EntityManager em = emf.createEntityManager();
		return (String) em.createNativeQuery(sql).getSingleResult();
	}

	// 库存统计 在沪仓库库存量
	@SuppressWarnings("unchecked")
	public List<Object> getCurrReserveAndYesterdayRk() {
		String sql = "select sum(t2.curr_reserve) as currReserve, "
				+ "sum(t2.yesterday_rk) as yesterdayRk, "
				+ "sum(t2.yesterday_ck) as yesterdayCk "
				+ "from rz_n_store t2, RZ_WAREHOUSE_INFO w " + "where 1 = 1 "
				+ "and t2.type = '1' " + "and t2.store_no = w.dept_id "
				+ "and t2.DEPLOY_DATE = (select max(t.deploy_date) "
				+ "from rz_n_store t " + "where t.store_no = t2.store_no) "
				+ "and t2.store_no not like '03%' "
				+ "and t2.store_no not like 'MG%' ";
		EntityManager em = emf.createEntityManager();
		return (List<Object>) em.createNativeQuery(sql.toString())
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> queryStockInfoWareHouse(String bspCode) {
		String sql = "select distinct t.rz_warehouse_code,t.warehouse_name from rz_stock_info t where t.customer_bsp_code='"
				+ bspCode + "'";
		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sql).getResultList();

	}

	public List<Object[]> queryStockInfoWareCustomer() {
		String sql = "select  s.rz_warehouse_code,s.warehouse_code , "
				+ "s.warehouse_name,"
				+ "s.customer_code ,s.customer_name ,s.customer_bsp_code "
				+ "from rz_stock_info s "
				+ "group by  s.rz_warehouse_code,s.warehouse_code,"
				+ "s.warehouse_name,"
				+ "s.customer_code ,s.customer_name ,s.customer_bsp_code ";
		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sql).getResultList();

	}

	// 查询仓库信息：仓库代码，仓库锦商名称，仓库bsp名称
	public List<Object[]> queryWarehouseInfoAll() {
		// String sql="select t.dept_id,t.dept_name from rz_warehouse_info t";
		String sql = "select t.dept_id,t.dept_name,t.dept_bsp_name from rz_warehouse_customer_info t";
		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sql).getResultList();
	}

	// 通过仓库id查询仓库bsp名称
	public String getDeptNameByDeptId(String deptName) {
		String sql = "select t.dept_bsp_name  from rz_warehouse_customer_info t where t.dept_id='"
				+ deptName + "'";
		EntityManager em = emf.createEntityManager();
		String result = "";
		List<String> list = em.createNativeQuery(sql).getResultList();
		if (null != list && list.size() > 0) {
			result = list.get(0);
		}
		return result;
	}

	public List<Object[]> getDeptBspCodeAndDeptNameAll() {
		String sql = "select distinct t.dept_bsp_code, t.dept_name from rz_warehouse_info t where t.dept_bsp_code is not null ";
		EntityManager em = emf.createEntityManager();

		return (List<Object[]>) em.createNativeQuery(sql).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> queryNStoreAll() {
		String sql = "select a.cuurReserve,a.dept_name from (select nvl(round(sum(a.curr_Reserve),0),0) cuurReserve,a.dept_name from rz_n_store  a where a.deploy_date=(select max(a.deploy_date) from rz_n_store a) and a.type='1' group by a.dept_name) a order by a.cuurReserve desc";
		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sql).getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<String> findByDate(String date, String storeNo)
			throws ParseException {
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		String sql = "select to_char(a.deploy_date,'yyyy-MM-dd hh24:mi:ss') from rz_n_Store a where a.deploy_date=(select max(a.deploy_date) from (select * from rz_n_Store a where a.store_No='"
				+ storeNo
				+ "' and a.deploy_Date like to_date('"
				+ date
				+ "','yyyy-MM-dd'))a)";
		EntityManager em = emf.createEntityManager();
		// String str =
		// dateFormat.format(em.createNativeQuery(sql).getSingleResult());
		return (List<String>) em.createNativeQuery(sql).getResultList();
	}

	/* 库存总量, 统计质押银行数,质押总量,质押金额,涉及仓库 */

	// 库存总量
	public BigDecimal getStockTotal() {
		BigDecimal stockTotal = new BigDecimal(0.00);// 重量
		String sql = "select t.stock_total from orc_t_stock_total t where t.sys_id = 'BAOSAAS' and t.type='1'  and t.area = '沪内'";
		EntityManager em = emf.createEntityManager();
		stockTotal = (BigDecimal) em.createNativeQuery(sql).getSingleResult();
		if (null != stockTotal) {
			stockTotal = stockTotal.divide(new BigDecimal(10000), 2);
		} else {
			stockTotal = new BigDecimal(0.00);
		}
		return stockTotal;
	}

	// 统计质押银行数
	public Long getCountMorBank() {
		Long bank = 0L;
		String sql = "select count(1) from (select f.bank_num from rz_t_finance_application f where f.finance_status = '80' group by f.bank_num)";
		EntityManager em = emf.createEntityManager();
		BigDecimal b = (BigDecimal) em.createNativeQuery(sql).getSingleResult();
		if (null != b) {
			bank = Long.valueOf(b.toString());
		} else {
			bank = 0L;
		}
		return bank;
	}

	// 质押总量
	public BigDecimal getMorTotalWeight() {
		BigDecimal morTotalWeight = new BigDecimal(0.00);// 金额
		String sql = "select sum(w.weight) from rz_warranty w where w.warranty_status='51'";
		EntityManager em = emf.createEntityManager();
		if (null != em.createNativeQuery(sql).getSingleResult()) {
			morTotalWeight = (BigDecimal) em.createNativeQuery(sql)
					.getSingleResult();
		}
		return morTotalWeight;
	}

	// 质押金额
	public BigDecimal getMorTotalMoney() {

		BigDecimal morTotalMoney = new BigDecimal(0.00);// 金额
		String sql = "select sum(l.batch_open_money)  from rz_t_finance_batch l  where l.finance_status = '80'";
		EntityManager em = emf.createEntityManager();
		morTotalMoney = (BigDecimal) em.createNativeQuery(sql)
				.getSingleResult();
		if (null != morTotalMoney) {
			morTotalMoney = morTotalMoney.divide(new BigDecimal(10000), 2,
					BigDecimal.ROUND_HALF_UP);
		} else {
			morTotalMoney = new BigDecimal(0.00);
		}
		return morTotalMoney;
	}

	// 涉及仓库
	public Long getCountWarehouse() {

		Long count = 0L;
		String sql = " select count(1) from (select w.warehouse_num from rz_warranty w  where w.warranty_status='51' group by w.warehouse_num)";
		EntityManager em = emf.createEntityManager();
		BigDecimal b = (BigDecimal) em.createNativeQuery(sql).getSingleResult();
		if (null != b) {
			count = Long.valueOf(b.toString());
		} else {
			count = 0L;
		}
		return count;
	}

	/* 银行质押动态——银行质押动态分布 */

	public List<Object[]> queryMortgageBank() {

		String sql = "select *  from (select sum(w.weight) as finance_weight, w.pledgee_code, w.pledgee_name"
				+ "  from rz_warranty w"
				+ "  where w.warranty_status = '51'"
				+ " group by w.pledgee_code, w.pledgee_name) gg order by gg.finance_weight desc";
		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sql).getResultList();

	}

	/* 统计当年的质押金额数据 */

	public Object[] getAnyMonthMortgageMoeny() {
		String year = DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
				0, 4);
		String sql = " SELECT SUM(DECODE(EXTRACT(MONTH FROM f.THIRD_APPROVAL_DATE), 1, f.batch_open_money, 0)) AS A, "
				+ "  SUM(DECODE(EXTRACT(MONTH FROM f.THIRD_APPROVAL_DATE), 2, f.batch_open_money, 0)) AS B,"
				+ "  SUM(DECODE(EXTRACT(MONTH FROM f.THIRD_APPROVAL_DATE), 3, f.batch_open_money, 0)) AS C, "
				+ "  SUM(DECODE(EXTRACT(MONTH FROM f.THIRD_APPROVAL_DATE), 4, f.batch_open_money, 0)) AS D, "
				+ "  SUM(DECODE(EXTRACT(MONTH FROM f.THIRD_APPROVAL_DATE), 5, f.batch_open_money, 0)) AS E,"
				+ "  SUM(DECODE(EXTRACT(MONTH FROM f.THIRD_APPROVAL_DATE), 6, f.batch_open_money, 0)) AS F, "
				+ "  SUM(DECODE(EXTRACT(MONTH FROM f.THIRD_APPROVAL_DATE), 7, f.batch_open_money, 0)) AS G, "
				+ "  SUM(DECODE(EXTRACT(MONTH FROM f.THIRD_APPROVAL_DATE), 8, f.batch_open_money, 0)) AS H, "
				+ "  SUM(DECODE(EXTRACT(MONTH FROM f.THIRD_APPROVAL_DATE), 9, f.batch_open_money, 0)) AS I, "
				+ "  SUM(DECODE(EXTRACT(MONTH FROM f.THIRD_APPROVAL_DATE), 10, f.batch_open_money, 0)) AS J,"
				+ "  SUM(DECODE(EXTRACT(MONTH FROM f.THIRD_APPROVAL_DATE), 11, f.batch_open_money, 0)) AS K,"
				+ "  SUM(DECODE(EXTRACT(MONTH FROM f.THIRD_APPROVAL_DATE), 12, f.batch_open_money, 0)) AS L "
				+ "  	FROM  rz_t_finance_batch f "
				+ "  	where f.finance_status = '80' "
				+ "  AND EXTRACT(YEAR FROM f.THIRD_APPROVAL_DATE) = '"
				+ year
				+ "'";
		EntityManager em = emf.createEntityManager();
		return (Object[]) em.createNativeQuery(sql).getSingleResult();
	}

	/* 统计当年的质押重量数据 */

	public Object[] getAnyMonthMortgageWeight() {
		String year = DateUtil.toDateString(new Date(), "yyyyMMdd").substring(
				0, 4);
		String sql = " SELECT SUM(DECODE(EXTRACT(MONTH FROM w.pe_approval_date), 1, w.weight, 0)) AS A, "
				+ "  SUM(DECODE(EXTRACT(MONTH FROM w.pe_approval_date), 2, w.weight, 0)) AS B,"
				+ "  SUM(DECODE(EXTRACT(MONTH FROM w.pe_approval_date), 3, w.weight, 0)) AS C, "
				+ "  SUM(DECODE(EXTRACT(MONTH FROM w.pe_approval_date), 4, w.weight, 0)) AS D, "
				+ "  SUM(DECODE(EXTRACT(MONTH FROM w.pe_approval_date), 5, w.weight, 0)) AS E,"
				+ "  SUM(DECODE(EXTRACT(MONTH FROM w.pe_approval_date), 6, w.weight, 0)) AS F, "
				+ "  SUM(DECODE(EXTRACT(MONTH FROM w.pe_approval_date), 7, w.weight, 0)) AS G, "
				+ "  SUM(DECODE(EXTRACT(MONTH FROM w.pe_approval_date), 8, w.weight, 0)) AS H, "
				+ "  SUM(DECODE(EXTRACT(MONTH FROM w.pe_approval_date), 9, w.weight, 0)) AS I, "
				+ "  SUM(DECODE(EXTRACT(MONTH FROM w.pe_approval_date), 10, w.weight, 0)) AS J,"
				+ "  SUM(DECODE(EXTRACT(MONTH FROM w.pe_approval_date), 11, w.weight, 0)) AS K,"
				+ "  SUM(DECODE(EXTRACT(MONTH FROM w.pe_approval_date), 12, w.weight, 0)) AS L "
				+ "  	FROM  rz_warranty w "
				+ "  	WHERE w.warranty_status = '51' "
				+ "   AND EXTRACT(YEAR FROM w.pe_approval_date) = '"
				+ year
				+ "'";
		EntityManager em = emf.createEntityManager();
		return (Object[]) em.createNativeQuery(sql).getSingleResult();
	}

	public List<Object[]> getKcByQymc(String ucode, String chrUcode) {
		// String
		// sql="select sum(t.weight),(select max(a.dept_short) from rz_warehouse_info a where a.dept_bsp_code = t.warehouse_num),max(t.warehouse_num) from RZ_WARRANTY t where t.pledgee_code='"+ucode+"' "
		// +
		// " and  t.goods_owner_num =  '"+chrUcode+"'"+
		// " group by t.warehouse_num order by sum(t.weight) desc";
		//
		String sql = "select sum(k.weight),max(k.name),max(k.code) from "
				+ " (select sum(t.weight) as weight,(select max(a.dept_short) from rz_warehouse_info a where a.dept_bsp_code = t.warehouse_num) as name,"
				+ " max(t.warehouse_num) as code  from RZ_WARRANTY t where t.application_id in (select a.application_id from rz_t_finance_application a where a.finance_status = '80') and t.pledgee_code = '"
				+ ucode
				+ "' and t.goods_owner_num = '"
				+ chrUcode
				+ "'"
				+ " group by t.warehouse_num"
				+ " union"
				+ " select sum(t.register_weight) as weight, "
				+ " (select max(a.dept_short)from rz_warehouse_info a where a.dept_bsp_code = t.store_code) as name,"
				+ " max(t.store_code) as code  from orc_t_info_register t where t.store_code is not null and t.status = '35' "
				+ " and t.storage_code = '" + chrUcode
				+ "' and t.register_bank_num = '" + ucode
				+ "' group by t.store_code) k "
				+ " group by k.code order by sum(k.weight)";
		EntityManager em = emf.createEntityManager();

		return (List<Object[]>) em.createNativeQuery(sql).getResultList();
	}

	public String isChrOrCk(String param) {

		String sql = "select b.role_name from tb_role b where b.role_id = (select a.role_id "
				+ " from rel_users_role a"
				+ " where a.user_id = "
				+ " (select t.user_num"
				+ " from tscsc01 t"
				+ " where t.chinese_user_name like '" + param + "%'))";
		EntityManager em = emf.createEntityManager();

		List<?> list = (List<?>) em.createNativeQuery(sql).getResultList();

		return (String) (list.get(0));
	}

	/**
	 * 根据存货人中文名获取角色中文
	 * 
	 * @param param
	 * @return
	 */
	public String isChr(String param) {

		String sql = "select a.role_id from rel_users_role a where a.user_id = "
				+ "(select distinct b.customer_bsp_code from rz_warehouse_customer_info b where b.customer_bsp_code in (select distinct t.customer_code from orc_t_customer_info t  where t.customer_name = '"
				+ param + "'))";
		EntityManager em = emf.createEntityManager();

		List<?> list = (List<?>) em.createNativeQuery(sql).getResultList();

		String reStr = "";
		if (list.size() > 0)
			reStr = (String) (list.get(0));

		return reStr;
	}

	/**
	 * 根据仓库中文名获取角色中文
	 * 
	 * @param param
	 * @return
	 */
	public String isCk(String param) {

		String sql = "select a.role_id from rel_users_role a where a.user_id = "
				+ " (select t.dept_bsp_code from rz_warehouse_info t where t.dept_name = '"
				+ param + "')";
		EntityManager em = emf.createEntityManager();

		List<?> list = (List<?>) em.createNativeQuery(sql).getResultList();

		String reStr = "";
		if (list.size() > 0)
			reStr = (String) (list.get(0));

		return reStr;
	}

	/**
	 * 根据存货人中文名获取bsp U代码
	 * 
	 * @param param
	 * @return
	 */
	public String getChrUcode(String param) {

		String sql = "select t.customer_code from orc_t_customer_info t  where t.customer_name = '"
				+ param + "'";
		EntityManager em = emf.createEntityManager();

		List<?> list = (List<?>) em.createNativeQuery(sql).getResultList();

		String reStr = "";
		if (list.size() > 0)
			reStr = (String) (list.get(0));

		return reStr;
	}

	/**
	 * 根据仓库中文名获取bsp U代码
	 * 
	 * @param param
	 * @return
	 */
	public String getCkUcode(String param) {

		String sql = "select t.dept_bsp_code from rz_warehouse_info t where t.dept_name = '"
				+ param + "'";
		EntityManager em = emf.createEntityManager();

		List<?> list = (List<?>) em.createNativeQuery(sql).getResultList();

		String reStr = "";
		if (list.size() > 0)
			reStr = (String) (list.get(0));

		return reStr;
	}

	/**
	 * 根据存货人锦商代码获取中文
	 * 
	 * @param ucode
	 * @return
	 */
	public String getChrNameByKcode(String kcode) {
		String sql = "select t.dept_customer_name from rz_warehouse_customer_info t  where t.dept_customer_id = '"
				+ kcode + "'";
		EntityManager em = emf.createEntityManager();

		List<?> list = (List<?>) em.createNativeQuery(sql).getResultList();

		String reStr = "";
		if (list.size() > 0)
			reStr = (String) (list.get(0));

		return reStr;
	}

	public List<Object[]> getZyInfoByMonth(String ucode, String qymc) {
		String sql = "select to_char(a.register_date,'yyyy-mm'),sum(a.register_weight) "
				+ " from ORC_T_INFO_REGISTER a"
				+ " where a.register_bank_num = '"
				+ ucode
				+ "'"
				+ "  and a.storage_code = "
				+ "(select b.customer_bsp_code from rz_warehouse_customer_info b where b.dept_customer_name = '"
				+ qymc
				+ "')"
				+ " group by to_char(a.register_date,'yyyy-mm')"
				+ " order by to_char(a.register_date,'yyyy-mm') asc ";
		EntityManager em = emf.createEntityManager();

		return (List<Object[]>) em.createNativeQuery(sql).getResultList();
	}

	public List<Object[]> getRzInfoByMonth(String ucode, String qymc) {
		String sql = "select max(to_char(t.validity_time,'yyyy-mm')),sum(t.weight) "
				+ " from RZ_WARRANTY t"
				+ " where t.pledgee_code = '"
				+ ucode
				+ "'"
				+ "  and t.goods_owner_num = "
				+ "(select a.customer_bsp_code from rz_warehouse_customer_info a where a.dept_customer_name = '"
				+ qymc
				+ "')"
				+ " group by to_char(t.validity_time,'yyyy-mm')"
				+ " order by max(to_char(t.validity_time,'yyyy-mm')) asc ";
		EntityManager em = emf.createEntityManager();

		return (List<Object[]>) em.createNativeQuery(sql).getResultList();
	}

	public List<Object[]> getZyWeightByDay(String ucode, String chrUcode,
			String today) {
		String sql = "select decode((select sum(t.weight) from orc_t_pawn_list t where t.register_num = a.register_code and t.status = '1'),null,0,(select sum(t.weight) from orc_t_pawn_list t where t.register_num = a.register_code and t.status = '1')) "
				+ " from ORC_T_INFO_REGISTER a "
				+ " where a.register_bank_num = '"
				+ ucode
				+ "'"
				+ "and a.storage_code =  '"
				+ chrUcode
				+ "' "
				+ "and a.status = '35' "
				+ "and '"
				+ today
				+ "' >= to_char(a.start_date,'yyyy-MM-dd') "
				+ " and '"
				+ today
				+ "' <= to_char(a.end_date,'yyyy-MM-dd')";
		logger.info(sql);
		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sql).getResultList();
	}

	/*
	 * 根据银行代码和存货人代码获得融资申请单的总量
	 */
	public List<Object[]> getRzWeightByMonth(String ucode, String chrUcode) {
		String sql = "select to_char(t.validity_time,'yyyy-MM') , sum(t.weight) "
				+ " from rz_warranty t where t.warranty_status = '51' "
				+ " and t.pledgee_code = '"
				+ ucode
				+ "' and t.customer_code = '"
				+ chrUcode
				+ "' "
				+ " group by to_char(t.validity_time,'yyyy-MM')  order by to_char(t.validity_time, 'yyyy-MM')";
		logger.info(sql);
		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createNativeQuery(sql).getResultList();
	}

	public List<?> getZyInfoAll(String ucode, String chrUcode, String flag) {
		StringBuffer sb = new StringBuffer();
		// sb.append("select count(*) as rnum,sum(weight) as weight ");
		// sb.append(" from RZ_WARRANTY t");
		// sb.append(" where 1=1");
		// if("0".equals(flag)){
		// sb.append(" and t.pledgee_code = '"+ucode+"'");
		// }
		// sb.append(" and t.goods_owner_num = '"+chrUcode+"'");

		sb.append("select count1+count2 as rnum,weight1+weight2 as weight");
		sb.append(" from (select count(1) as count1, decode(sum(a.finance_weight),null,0,sum(a.finance_weight)) as weight1");
		sb.append(" from RZ_T_FINANCE_APPLICATION a");
		sb.append(" where a.customer_id = '" + chrUcode + "' ");
		if ("0".equals(flag)) {
			sb.append(" and a.bank_num = '" + ucode + "'");
		}
		sb.append(" and a.application_id in (select b1.application_id from rz_warranty b1 where b1.warranty_status = '51')) o,");
		sb.append(" (select count(1) as count2, decode(sum(b.register_weight),null,0,sum(b.register_weight)) as weight2");
		sb.append(" from ORC_T_INFO_REGISTER b");
		sb.append(" where b.storage_code = '" + chrUcode
				+ "' and b.status = '35' ");
		if ("0".equals(flag)) {
			sb.append("and b.register_bank_num = '" + ucode + "' ");
		}
		sb.append(") p");

		logger.info("sql=" + sb.toString());
		EntityManager em = emf.createEntityManager();

		return (List<?>) em.createNativeQuery(sb.toString()).getResultList();
	}

	public List<?> getCkInfoAll(String ucode, String ckUcode, String flag) {
		StringBuffer sb = new StringBuffer();
		// sb.append("select count(*) as rnum,sum(weight) as weight ");
		// sb.append(" from RZ_WARRANTY t");
		// sb.append(" where 1=1");
		// if("0".equals(flag)){
		// sb.append(" and t.pledgee_code = '"+ucode+"'");
		// }
		// sb.append(" and t.warehouse_num = '"+ckUcode+"'");

		sb.append("select count1+count2 as rnum,weight1+weight2 as weight");
		sb.append(" from (select count(1) as count1, decode(sum(a.finance_weight),null,0,sum(a.finance_weight)) as weight1");
		sb.append(" from RZ_T_FINANCE_APPLICATION a");
		sb.append(" where a.warehouse_num = '" + ckUcode + "' ");
		if ("0".equals(flag)) {
			sb.append(" and a.bank_num = '" + ucode + "'");
		}
		sb.append(") o,");
		sb.append(" (select count(1) as count2, decode(sum(b.register_weight),null,0,sum(b.register_weight)) as weight2");
		sb.append(" from ORC_T_INFO_REGISTER b");
		sb.append(" where b.store_code = '" + ckUcode + "' ");
		if ("0".equals(flag)) {
			sb.append("and b.register_bank_num = '" + ucode + "' ");
		}
		sb.append(") p");
		// logger.info(sb.toString());
		EntityManager em = emf.createEntityManager();

		return (List<?>) em.createNativeQuery(sb.toString()).getResultList();
	}

	public List<?> queryAllCustomerName() {
		StringBuffer sql = new StringBuffer(
				"select distinct wc.customer_name as name, '存货人' as auth  from orc_t_customer_info wc where wc.customer_code in (select distinct t.customer_bsp_code from rz_warehouse_customer_info t where 1=1) ");

		EntityManager em = emf.createEntityManager();
		return (List<?>) em.createNativeQuery(sql.toString()).getResultList();

	}

	public List<?> queryAllDeptName() {
		StringBuffer sql = new StringBuffer(
				"select distinct wc.DEPT_NAME as name, '仓库' as auth  from rz_warehouse_info wc where 1=1 ");

		EntityManager em = emf.createEntityManager();
		return (List<?>) em.createNativeQuery(sql.toString()).getResultList();

	}

	public List<?> queryRzsqd(String ckUcode, String bankUcode, String type,
			String czr, String pm, String status, String startDate,
			String endDate) {

		StringBuffer sql = new StringBuffer();
		if (type.equals(LSConstants.RZSQD_STATUS_CODESET)) {
			sql.append("select b.application_id as applicationId,"
					+ "'0' as type,"
					+ "b.customer_name as czr,"
					+ "F_FINANCE_APPLICATION_LIST(b.application_id) as pm,"
					+ "b.finance_weight as weight,"
					+ "(select c.item_chs_code from t_hx_code_item c where c.codeset_code = 'S002' and c.item_code = b.finance_status) as status, "
					+ " (select to_char(max(o.validity_time),'yyyy-MM-dd')  from rz_warranty o where o.application_id = b.application_id) as endDate,"
					+ " b.warehouse_name as ckName "
					+ " from RZ_T_FINANCE_APPLICATION b "
					+ " where b.warehouse_num =  '" + ckUcode
					+ "' and b.bank_num = '" + bankUcode + "' ");
			if (!StringUtil.isEmpty(czr)) {
				sql.append(" and b.customer_id in (select f.customer_bsp_code from rz_warehouse_customer_info f where f.customer_bsp_code in (select distinct t.customer_code from orc_t_customer_info t  where t.customer_name  like '%"
						+ czr + "%'))");
			}

			if (!StringUtil.isEmpty(pm)) {
				sql.append(" and b.application_id in (select d.application_id from RZ_WARRANTY d where d.warranty_no in (select e.warranty_no from rz_warranty_good e where e.type_name like '%"
						+ pm + "%'))");
			}

			if (!StringUtil.isEmpty(status)) {
				sql.append(" and b.finance_status = '" + status + "'");
			}

			if (!StringUtil.isEmpty(startDate)) {// 格式为yyyyMMdd
				sql.append(" and (select to_char(max(o.validity_time),'yyyy-MM-dd') from rz_warranty o where o.application_id = b.application_id) >= '"
						+ startDate + "'");
			}

			if (!StringUtil.isEmpty(endDate)) {
				sql.append(" and (select to_char(max(o.validity_time),'yyyy-MM-dd') from rz_warranty o where o.application_id = b.application_id) <= '"
						+ endDate + "'");
			}
			sql.append(" order by applicationId ");
		} else if (type.equals(LSConstants.ZYSQD_STATUS_CODESET)) {
			sql.append("select a.register_code as applicationId,'1' as type,a.storage_name as czr,"
					+ "F_ORC_T_LIST(a.register_code) as pm,"
					+ "(select sum(o.weight) from orc_t_pawn_list o where o.register_num = a.register_code) as weight,"
					+ "(select c.item_chs_code from t_hx_code_item c where c.codeset_code = 'S035' and c.item_code = a.status) as status,"
					+ "to_char(a.end_date,'yyyy-MM-dd') as endDate,"
					+ "a.store_name as ckName "
					+ " from ORC_T_INFO_REGISTER a "
					+ " where a.store_code = '"
					+ ckUcode
					+ "' and a.register_bank_num = '" + bankUcode + "'");

			if (!StringUtil.isEmpty(czr)) {
				sql.append(" and a.storage_code in (select f.customer_bsp_code from rz_warehouse_customer_info f where f.customer_bsp_code in (select distinct t.customer_code from orc_t_customer_info t  where t.customer_name  like '%"
						+ czr + "%'))  ");
			}

			if (!StringUtil.isEmpty(pm)) {
				sql.append(" and a.register_code in (select e.register_num from orc_t_pawn_list e where e.type_name like '%"
						+ pm + "%')");
			}

			if (!StringUtil.isEmpty(status)) {
				sql.append(" and a.status = '" + status + "'");
			}

			if (!StringUtil.isEmpty(startDate)) {
				sql.append(" and to_char(a.end_date,'yyyyMMdd') >= '"
						+ startDate + "'");
			}

			if (!StringUtil.isEmpty(endDate)) {
				sql.append(" and to_char(a.end_date,'yyyyMMdd') <= '" + endDate
						+ "'");
			}

			sql.append(" order by applicationId ");
		} else {
			sql.append("select b.application_id as applicationId,"
					+ "'0' as type,"
					+ "b.customer_name as czr,"
					+ "F_FINANCE_APPLICATION_LIST(b.application_id) as pm,"
					+ "b.finance_weight as weight,"
					+ "(select c.item_chs_code from t_hx_code_item c where c.codeset_code = 'S002' and c.item_code = b.finance_status) as status, "
					+ " (select to_char(max(o.validity_time),'yyyy-MM-dd')  from rz_warranty o where o.application_id = b.application_id) as endDate,"
					+ " b.warehouse_name as ckName "
					+ " from RZ_T_FINANCE_APPLICATION b "
					+ " where b.warehouse_num = '" + ckUcode
					+ "' and b.bank_num = '" + bankUcode + "' ");
			if (!StringUtil.isEmpty(czr)) {
				sql.append(" and b.finance_status = '80' and b.customer_id in (select f.customer_bsp_code from rz_warehouse_customer_info f where f.customer_bsp_code in (select distinct t.customer_code from orc_t_customer_info t  where t.customer_name  like '%"
						+ czr + "%'))  ");
			}

			if (!StringUtil.isEmpty(pm)) {
				sql.append(" and b.application_id in (select d.application_id from RZ_WARRANTY d where d.warranty_no in (select e.warranty_no from rz_warranty_good e where e.type_name like '%"
						+ pm + "%'))");
			}

			if (!StringUtil.isEmpty(status)) {
				sql.append(" and b.finance_status = '" + status + "'");
			}

			if (!StringUtil.isEmpty(startDate)) {
				sql.append(" and (select to_char(max(o.validity_time),'yyyy-MM-dd') from rz_warranty o where o.application_id = b.application_id) >= '"
						+ startDate + "'");
			}

			if (!StringUtil.isEmpty(endDate)) {
				sql.append(" and (select to_char(max(o.validity_time),'yyyy-MM-dd') from rz_warranty o where o.application_id = b.application_id) <= '"
						+ endDate + "'");
			}

			sql.append("union select a.register_code as applicationId,'1' as type,a.storage_name as czr,"
					+ "F_ORC_T_LIST(a.register_code) as pm,"
					+ "(select sum(o.weight) from orc_t_pawn_list o where o.register_num = a.register_code) as weight,"
					+ "(select c.item_chs_code from t_hx_code_item c where c.codeset_code = 'S035' and c.item_code = a.status) as status,"
					+ "to_char(a.end_date,'yyyy-MM-dd') as endDate,"
					+ "a.store_name as ckName "
					+ " from ORC_T_INFO_REGISTER a "
					+ " where a.store_code = '"
					+ ckUcode
					+ "' and a.register_bank_num = '" + bankUcode + "'");

			if (!StringUtil.isEmpty(czr)) {
				sql.append("and a.status = '35' and a.storage_code in (select f.customer_bsp_code from rz_warehouse_customer_info f where f.customer_bsp_code in (select distinct t.customer_code from orc_t_customer_info t  where t.customer_name  like '%"
						+ czr + "%'))  ");
			}

			if (!StringUtil.isEmpty(pm)) {
				sql.append(" and a.register_code in (select e.register_num from orc_t_pawn_list e where e.type_name like '%"
						+ pm + "%')");
			}

			if (!StringUtil.isEmpty(status)) {
				sql.append(" and a.status = '" + status + "'");
			}

			if (!StringUtil.isEmpty(startDate)) {
				sql.append(" and to_char(a.end_date,'yyyyMMdd') >= '"
						+ startDate + "'");
			}

			if (!StringUtil.isEmpty(endDate)) {
				sql.append(" and to_char(a.end_date,'yyyyMMdd') <= '" + endDate
						+ "'");
			}

			sql.append(" order by applicationId ");
		}

		logger.info("sql==" + sql.toString());

		EntityManager em = emf.createEntityManager();
		return (List<?>) em.createNativeQuery(sql.toString()).getResultList();
	}

	public List<?> queryZysqd(String param, String type, String czr, String pm,
			String status, String startDate, String endDate) {
		StringBuffer sql = new StringBuffer(
				"select a.register_code as applicationId,'质押登记' as type,a.storage_name as czr,"
						+ "(select distinct e.type_name from rz_warranty_good e where e.warranty_no in "
						+ "(select d.warranty_no from RZ_WARRANTY d where d.application_id = a.register_code)) as pm,"
						+ "'2000' as weight,"
						+ "(select c.item_chs_code from t_hx_code_item c where c.codeset_code = 'S035' and c.item_code = a.status) as status,"
						+ "to_char(a.end_date,'yyyy-MM-dd') as endDate "
						+ " from ORC_T_INFO_REGISTER a "
						+ " where a.store_code =(select b.dept_bsp_code from rz_warehouse_info b where b.dept_name = '"
						+ param + "')");

		if (!StringUtil.isEmpty(czr)) {
			sql.append(" and a.register_code = (select f.customer_bsp_code from rz_warehouse_customer_info f where f.dept_customer_name like '%"
					+ czr + "&')  ");
		}

		if (!StringUtil.isEmpty(pm)) {

		}

		if (!StringUtil.isEmpty(status)) {

		}

		if (!StringUtil.isEmpty(startDate)) {

		}

		if (!StringUtil.isEmpty(endDate)) {

		}
		EntityManager em = emf.createEntityManager();
		return (List<?>) em.createNativeQuery(sql.toString()).getResultList();
	}

	/**
	 * 根据codeset代码获取值集列表
	 * 
	 * @param codeset
	 * @return
	 */
	public List<?> queryCodesetList(String codeset) {
		StringBuffer sb = new StringBuffer(
				"select c.item_code,c.item_chs_code from t_hx_code_item c where c.codeset_code = '"
						+ codeset + "'");

		EntityManager em = emf.createEntityManager();
		return (List<?>) em.createNativeQuery(sb.toString()).getResultList();
	}

	/**
	 * 根据值集codeset和代码获取代码对应中文
	 * 
	 * @param codeset
	 * @param statuscode
	 * @return
	 */
	public String queryCodeitemZh(String codeset, String statuscode) {
		StringBuffer sb = new StringBuffer(
				"select c.item_chs_code from t_hx_code_item c where c.codeset_code = '"
						+ codeset + "' and c.item_code = '" + statuscode + "'");

		EntityManager em = emf.createEntityManager();
		List<?> resList = (List<?>) em.createNativeQuery(sb.toString())
				.getResultList();

		return (String) resList.get(0);
	}

	/**
	 * 根据捆包号，查询捆包明细信息
	 * 
	 * @param packnum
	 * @return
	 */
	public List<?> queryPackByPacknum(String packnum) {
		StringBuffer sb = new StringBuffer(
				"select t.pack_num as \"packNum\", to_char(t.store_date,'yyyy-MM-dd') as \"storeDate\","
						+ "t.spec as \"spec\",t.grade as \"grade\",t.area_p as \"area\", t.resource_num as \"resourceNum\",to_char(t.weight_b) as \"weight\","
						+ "(select b.item_chs_code from t_hx_code_item b where b.codeset_code = 'S029' and b.item_code = "
						+ "(select a.warranty_status from rz_warranty a where a.warranty_no = t.warranty_no)) as \"status\","
						+ "(select a.goods_owner_name from rz_warranty a where a.warranty_no = t.warranty_no) as \"owner\","
						+ "(select a.warehouse_address from rz_warranty a where a.warranty_no = t.warranty_no) as \"address\""
						+ " from rz_warranty_good t where t.pack_num = '"
						+ packnum + "'");

		EntityManager em = emf.createEntityManager();
		return (List<?>) em.createNativeQuery(sb.toString()).getResultList();
	}

	/*
	 * 监管方：模糊查询存货人（仓库）名称 customerBspCodeType： 01 ：存货人 ，02：仓库 注意：不可以
	 * 查询到已经加入黑名单的数据
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> queryDeptNameOrCustomerBspCode(
			String operatorCustomerBspName, String customerBspCodeType) {
		StringBuffer hql = new StringBuffer(
				"select rd.userName  from RoleToUserDomain rd where 1=1 ");

		if (!StringUtil.isEmpty(operatorCustomerBspName)) {
			hql.append("  and  rd.userName like  '%" + operatorCustomerBspName
					+ "%'");
		}
		hql.append("  and rd.roleId = '" + customerBspCodeType + "'");
		hql.append("  and not exists (select 1 from OrcTBlacklist bc where bc.customerBspName=rd.userName)");
		EntityManager em = emf.createEntityManager();
		return (List<Object[]>) em.createQuery(hql.toString()).getResultList();

	}

	/*
	 * 通过企业名称查询企业U代码
	 */
	@SuppressWarnings("unchecked")
	public List<String> queryCustomerBspCodeByCustomerBspName(
			String operatorCustomerBspName) {
		StringBuffer hql = new StringBuffer(
				"select rd.userNum  from RoleToUserDomain rd where 1=1 ");
		hql.append("  and  rd.userName='" + operatorCustomerBspName + "'");
		EntityManager em = emf.createEntityManager();
		return (List<String>) em.createQuery(hql.toString()).getResultList();

	}

	/**
	 * 配置系统开关 added by ethan.du
	 * 
	 * @return String flag
	 */
	public String queryFlag() {
		StringBuffer sb = new StringBuffer(
				"select t.FLAG from ORC_T_SYS_CONFIG t");
		EntityManager em = emf.createEntityManager();
		List<?> resList = (List<?>) em.createNativeQuery(sb.toString())
				.getResultList();
		return (String) resList.get(0);
	}

	/*
	 * 统计当天的盘点任务
	 */
	public Long getTodayCountCheck() {
		Long count = 0L;
		String sql = " select count(1) from orc_t_check_result t where 1=1 and t.create_date>= to_date(to_char(sysdate,'yyyyMMdd'),'yyyyMMdd')";
		EntityManager em = emf.createEntityManager();
		BigDecimal b = (BigDecimal) em.createNativeQuery(sql).getSingleResult();
		if (null != b) {
			count = Long.valueOf(b.toString());
		} else {
			count = 0L;
		}
		return count;
	}

	/*
	 * 统计待评价的
	 */
	public Long getCountWaitEvaluate(String companyNo) {
		Long count = 0L;
		String sql = " select count(1) from ("
				+ " select a.application_id as applicationId,a.warehouse_name as warehouseName,a.customer_name as customerName,a.bank_name as bankName"
				+ " from rz_t_finance_application a where 1=1 and a.application_id not in (select t.doc_no from ORC_T_JUDGEMENT t)"
				+ " and a.warehouse_num in (select n.depot_code from ORC_T_BIND_CONF n where n.COMPANY_CODE = '"
				+ companyNo
				+ "')"
				+ " union"
				+ " select b.register_code as applicationId,b.store_name as warehouseName,b.storage_name as customerName,b.register_bank_name as bankName"
				+ " from orc_t_info_register b where 1=1 and b.is_system = '0'  "
				+ " and b.register_code not in (select t.doc_no from ORC_T_JUDGEMENT t)"
				+ " and b.store_code in (select n.depot_code from ORC_T_BIND_CONF n where n.COMPANY_CODE = '"
				+ companyNo + "')" + " )";
		EntityManager em = emf.createEntityManager();
		BigDecimal b = (BigDecimal) em.createNativeQuery(sql).getSingleResult();
		if (null != b) {
			count = Long.valueOf(b.toString());
		} else {
			count = 0L;
		}
		return count;
	}

	/*
	 * 统计标签打印的
	 */

	public Long getCountBillInfo(String companyNo) {
		Long count = 0L;
		String sql = " select count(1) from ("
				+ "  select b.application_id as applicationId,b.warranty_app_no as appNo,a.id as id"
				+ "  from rz_warranty_good a inner join rz_warranty b on a.warranty_no = b.warranty_no"
				+ "  and b.warranty_status != '01' and   b.warranty_app_no in (select t.warranty_app_no from rz_warranty_app t where t.warranty_status in ('10','11')) "
				+ "  and b.warehouse_num in (select n.depot_code from ORC_T_BIND_CONF n where n.COMPANY_CODE = '"
				+ companyNo
				+ "')"
				+ " union"
				+ " select  d.register_code as applicationId,  d.register_code as appNo,c.id as id"
				+ "  from orc_t_pawn_list c inner join orc_t_info_register d on c.register_num = d.register_code"
				+ "  and d.status = '35' and d.is_entrust_supervise = '1' and d.is_system = '0' and c.status = '0'"
				+ "  and d.store_code in (select n.depot_code from ORC_T_BIND_CONF n where n.COMPANY_CODE = '"
				+ companyNo + "')" + " )";
		EntityManager em = emf.createEntityManager();
		BigDecimal b = (BigDecimal) em.createNativeQuery(sql).getSingleResult();
		if (null != b) {
			count = Long.valueOf(b.toString());
		} else {
			count = 0L;
		}
		return count;
	}

	/********************************** 获取货主与仓库的BSP中文全称 *******************************************************/
	@SuppressWarnings("unchecked")
	public List<Object> queryDeptCustomerBspName(
			String operatorDeptCustomerName, String deptName) {
		StringBuffer sql = new StringBuffer(
				"select distinct wc.DEPT_CUSTOMER_BSP_NAME  from rz_warehouse_customer_info wc where 1=1 ");

		if (!StringUtil.isEmpty(deptName)) {
			sql.append("  and wc.DEPT_BSP_NAME='" + deptName + "'");
		}

		sql.append("  and wc.DEPT_CUSTOMER_BSP_NAME like '"
				+ operatorDeptCustomerName + "%'");

		// String sql =
		// "select distinct wc.dept_customer_name  from rz_warehouse_customer_info wc where 1=1 wc.dept_customer_name like '"+operatorDeptCustomerName+"%'";

		EntityManager em = emf.createEntityManager();
		return (List<Object>) em.createNativeQuery(sql.toString())
				.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Object> queryDeptCustomerBspName1(
			String operatorDeptCustomerName, String deptName) {
		StringBuffer sql = new StringBuffer(
				"select distinct wc.GOODSOWNERNAME  from v_goods_check wc where 1=1 ");

		if (!StringUtil.isEmpty(deptName)) {
			sql.append("  and wc.WAREHOUSENAME like '%" + deptName + "%'");
		}

		sql.append("  and wc.GOODSOWNERNAME like '%" + operatorDeptCustomerName
				+ "%'");

		EntityManager em = emf.createEntityManager();
		return (List<Object>) em.createNativeQuery(sql.toString())
				.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Object> queryGoodsOwnerName(String operatorDeptCustomerName,
			String deptName) {
		StringBuffer sql = new StringBuffer(
				"select distinct wc.GOODS_OWNER_NAME  from ORC_T_REGISTER_CENTER wc where 1=1 ");

		if (!StringUtil.isEmpty(deptName)) {
			sql.append("  and wc.WAREHOUSE_NAME like '%" + deptName + "%'");
		}

		sql.append("  and wc.GOODS_OWNER_NAME like '%"
				+ operatorDeptCustomerName + "%'");

		EntityManager em = emf.createEntityManager();
		return (List<Object>) em.createNativeQuery(sql.toString())
				.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Object> queryDeptBspName(String operatorDeptName,
			String deptCustomerName) {
		StringBuffer sql = new StringBuffer(
				"select distinct wc.DEPT_BSP_NAME  from rz_warehouse_customer_info wc where 1=1 ");

		if (!StringUtil.isEmpty(deptCustomerName)) {
			sql.append("  and wc.DEPT_CUSTOMER_BSP_NAME='" + deptCustomerName
					+ "'");
		}

		sql.append("  and wc.DEPT_BSP_NAME like '" + operatorDeptName + "%'");
		EntityManager em = emf.createEntityManager();
		return (List<Object>) em.createNativeQuery(sql.toString())
				.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Object> queryDeptBspName1(String operatorDeptName,
			String deptCustomerName) {
		StringBuffer sql = new StringBuffer(
				"select distinct wc.WAREHOUSENAME  from v_goods_check wc where 1=1 ");

		if (!StringUtil.isEmpty(deptCustomerName)) {
			sql.append("  and wc.GOODSOWNERNAME ='" + deptCustomerName + "'");
		}

		sql.append("  and wc.WAREHOUSENAME like '" + operatorDeptName + "%'");
		EntityManager em = emf.createEntityManager();
		return (List<Object>) em.createNativeQuery(sql.toString())
				.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Object> queryWarehouseName(String operatorDeptName,
			String deptCustomerName) {
		StringBuffer sql = new StringBuffer(
				"select distinct wc.WAREHOUSE_NAME  from ORC_T_REGISTER_CENTER wc where 1=1 ");

		if (!StringUtil.isEmpty(deptCustomerName)) {
			sql.append("  and wc.GOODS_OWNER_NAME ='" + deptCustomerName + "'");
		}

		sql.append("  and wc.WAREHOUSE_NAME like '" + operatorDeptName + "%'");
		EntityManager em = emf.createEntityManager();
		return (List<Object>) em.createNativeQuery(sql.toString())
				.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Object> queryBankName(String operatorBankName) {
		StringBuffer sql = new StringBuffer(
				"select distinct wc.BANK_NAME  from ORC_T_REGISTER_CENTER wc where 1=1 ");

		sql.append("  and wc.BANK_NAME like '" + operatorBankName + "%'");
		EntityManager em = emf.createEntityManager();
		return (List<Object>) em.createNativeQuery(sql.toString())
				.getResultList();

	}

	public List<Object> getCurrReserve() {
		// StringBuffer sql = new
		// StringBuffer("WITH latest_date AS ( SELECT u_code, MAX(DEPLOY_DATE) AS max_date FROM rz_n_store WHERE type = 1 GROUP BY u_code ) "
		// +
		// " select sum(t.curr_reserve) from rz_n_store t,latest_date t1 " +
		// " where  t.u_code = t1.u_code AND t.DEPLOY_DATE = t1.max_date and t.type = '1' and t.store_no not in ('0301','MG01','0312') ");

		StringBuffer sql = new StringBuffer(
				"select sum(t.curr_reserve) from rz_n_store t "
						+ " where t.DEPLOY_DATE = (select max(t.deploy_date) from rz_n_store t) and t.type = '1' and t.store_no not in ('0301','MG01','0312')");

		EntityManager em = emf.createEntityManager();
		return (List<Object>) em.createNativeQuery(sql.toString())
				.getResultList();

	}

	/*public OrcTBindConf queryOrcTBindConfByDepotUCode(String depotUCode) {
		OrcTBindConf bg = new OrcTBindConf();
		EntityManager em = emf.createEntityManager();
		String hql = " from 	OrcTBindConf bf where 1=1 and bf.depotCode ='"
				+ depotUCode + "'";
		List list = em.createQuery(hql).getResultList();
		if (null != list && list.size() > 0) {
			bg = (OrcTBindConf) list.get(0);
		}
		return bg;
	}*/

	public int localExceSql(String sql) {
		return jdbcTemplate.update(sql);
	}

	// 集合装换成'',''字符串

	private String getStringByList(List<String> list) {
		StringBuffer sql = new StringBuffer("''");
		if (null != list && list.size() > 0) {
			for (String string : list) {
				sql.append("," + "'" + string + "'");
			}
		}
		return sql.toString();
	}

/*	public CreditLimitsTrack insertCreditLimitsTrack(
			CreditLimitsTrack creditLimitsTrack) {
		return creditLimitsTrackRepository.save(creditLimitsTrack);
	}
*/
	/*
	 * 
	 * 
	 * 根据融资订单号查询监管公司
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> queryCompanyList(String applicationId) {
		EntityManager em = emf.createEntityManager();
		String sql = "select r.company_code, r.company_name";
		sql = sql
				+ " from orc_t_bind_conf r, rz_warranty w, rz_t_finance_application_sub rfas";
		sql = sql + " where r.depot_code = w.warehouse_num";
		sql = sql + "   and w.warranty_no = rfas.warranty_no";
		sql = sql + "   and rfas.application_id = '" + applicationId + "'";
		sql = sql + "  and rownum = 1";
		return em.createNativeQuery(sql).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> queryDelegateSupItemList() {
		EntityManager em = emf.createEntityManager();
		String sql = "select t.id,t.ds_no from ds_t_delegate_supv t "
				+ "where t.status = '20' and t.flag = '0' and t.type = '20' "
				+ "and not exists(select 1 from ORC_T_PAWN_LIST v where t.ref_no = v.register_num and v.status='1') "
				+ "union all "
				+ "select t.id,t.ds_no from ds_t_delegate_supv t "
				+ "where t.status = '20' and t.flag = '1' and (t.type = '10' or t.type = '30') "
				+ "and not exists(select 1 from ds_t_delegate_supv_d d where t.id=d.rm_id and d.supervison_Flag='1')";
		return em.createNativeQuery(sql).getResultList();
	}

	public void executeSql(String sql) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery(sql).executeUpdate();
		em.getTransaction().commit();
	}

	/* 统计当年的质押重量数据 */

	public Object[] queryWarrantyCompareDetail(String mainId, String resultFlag) {
		String sql = "select nvl(sum(t.num),0) num,nvl(sum(t.weight),0) weight from rz_warranty_compare_detail t where 1=1  ";
		if (!StringUtil.isEmpty(mainId)) {
			sql += "and t.main_id='" + mainId + "'";
		}
		if (!StringUtil.isEmpty(resultFlag)) {
			sql += "and t.result_flag='" + resultFlag + "'";
		}
		EntityManager em = emf.createEntityManager();
		return (Object[]) em.createNativeQuery(sql).getSingleResult();
	}

	/**
	 * 
	 * @param warrantyStatus
	 *            仓单状态
	 * @param marketFlag
	 *            市场标记
	 * @param flag
	 *            查询标记 1表示查询 仓库数据，2表示查询交易品台数据,3表示查询货主,4表示仓单号
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> findSys(Warranty vo, String flag) {
		String sql = "";
		if ("1".equals(flag)) {
			sql += "select distinct t.warehouse_num,t.warehouse_name ";
		} else if ("2".equals(flag)) {
			sql += "select distinct t.org_sys_no,t.org_sys_name ";
		} else if ("3".equals(flag)) {
			sql += "select distinct t.customer_code,t.customer_name ";
		} else if ("4".equals(flag)) {
			sql += "select distinct t.warranty_no ";
		}
		sql += "from rz_warranty t where t.warranty_status!='"
				+ vo.getWarrantyStatus() + "' and t.market_flag='"
				+ vo.getMarketFlag() + "'";
		if ("1".equals(flag)) {
			sql += " and t.warehouse_num is not null and  t.warehouse_name is not null ";
		} else if ("2".equals(flag)) {
			sql += " and t.org_sys_no is not null and t.org_sys_name is not null ";
		} else if ("3".equals(flag)) {
			sql += " and t.customer_code is not null and t.customer_name like '%"
					+ vo.getCustomerName() + "%' ";
			if (!StringUtil.isEmpty(vo.getCreateName())) {
				sql += "and t.customer_name not in(" + vo.getCreateName() + ")";
			}
		}
		EntityManager em = emf.createEntityManager();
		logger.info("查询当前市场标记，且状态不是注销的仓单数据sql:" + sql);
		return (List<Object[]>) em.createNativeQuery(sql).getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Object[]> findsome(String customerName, String orgSysNo,
			String markFlag, String warhouseName, String status) {
		String sql = "select t.warranty_no,t.weight_b,t.warranty_type,t.pm_calss,t.customer_name,t.sheet_num from v_warranty_rr t where 1=1";
		if (!StringUtil.isEmpty(customerName)) {
			sql += " and t.customer_name in (" + customerName + ")";
		}
		if (!StringUtil.isEmpty(orgSysNo)) {
			sql += " and t.org_sys_no='" + orgSysNo + "'";
		}
		if (!StringUtil.isEmpty(markFlag)) {
			sql += " and t.market_flag='" + markFlag + "'";
		}
		if (!StringUtil.isEmpty(warhouseName)) {
			sql += " and t.warehouse_name='" + warhouseName + "'";
		}
		if (!StringUtil.isEmpty(status)) {
			sql += " and t.warranty_status !='" + status + "'";
		}
		sql += " order by dbms_random.random";
		EntityManager em = emf.createEntityManager();
		logger.info("抽检随机仓单数据sql:" + sql);
		return (List<Object[]>) em.createNativeQuery(sql).getResultList();

	}

	// 查询宝赢通仓库代码，货主代码
	public List<String> queryWarehouseInfo(String code, String resultFlag) {
		String sql = "";
		if ("1".equals(resultFlag)) {// 查询宝赢通仓库代码
			sql = "select t.dept_id from rz_warehouse_info t where t.dept_bsp_code='"
					+ code + "'";
			logger.info("查询宝赢通仓库代码sql:" + sql);
		} else if ("2".equals(resultFlag)) {// 查询宝赢通货主代码
			sql = "select t.dept_customer_id from rz_warehouse_customer_info t where t.customer_bsp_code='"
					+ code + "'";
			logger.info("查询宝赢通货主代码sql:" + sql);
		}
		EntityManager em = emf.createEntityManager();
		return (List<String>) em.createNativeQuery(sql).getResultList();
	}

	/* 统计抽检子项总数量总重量 */

	public Object[] queryCheckGoodDetail(String checkNo) {
		String sql = "select nvl(sum(t.sheet_num),0),nvl(sum(t.weight),0) from orc_t_checkgoods_detail t where t.checkgoodsid='"
				+ checkNo + "'";
		EntityManager em = emf.createEntityManager();
		logger.info("统计抽检子项总数量总重量sql:" + sql);
		return (Object[]) em.createNativeQuery(sql).getSingleResult();
	}

	public long sumWeight(String pmCode) {
		long bank = 0L;
		String sql = " select count(1) num from rz_warranty where warranty_no in (select t.warranty_no num from rz_warranty_good t ";
		sql += " where exists (select 1 from fds_goods_cata_mapping a where 1 = 1  and t.pm_code = a.ftz_catagory_code  and a.base_p_code = '"
				+ pmCode + "'))";
		sql += "  and warranty_status != '01' and market_flag = '10'";
		logger.info("自贸区首页统计总条数sql:" + sql);
		EntityManager em = emf.createEntityManager();
		BigDecimal b = (BigDecimal) em.createNativeQuery(sql).getSingleResult();
		if (null != b) {
			bank = Long.valueOf(b.toString());
		} else {
			bank = 0L;
		}
		return bank;
	}

	/**
	 * 
	 * 
	 * @param pmCode
	 * @return
	 */
	public List<Object[]> selectCodeAndName(String role) {
		String sql = "select r.user_id,c.chinese_full_name from rel_users_role r inner join rz_bsp_umc_company c on r.user_id=c.bsp_company_code where c.chinese_full_name is not  null and  r.role_id='"
				+ role + "'";
		logger.info("自贸区查询某角色代码名称sql：" + sql);
		return executeFindSql(sql);
	}

	/**
	 * 模糊查询贸易商
	 * 
	 * @param pmCode
	 * @return
	 */
	public List<Object[]> selectFinLikeName(String name) {
		String sql = "select r.user_id,c.chinese_full_name from rel_users_role r "
				+ "inner join rz_bsp_umc_company c on r.user_id=c.bsp_company_code where r.role_id='11' and c.chinese_full_name like '%"
				+ name + "%'";
		logger.info("自贸区模糊查询贸易商代码名称sql：" + sql);
		return executeFindSql(sql);
	}

	/**
	 * 查询收藏 操作员代码对应 与收藏量
	 * 
	 * @param pmCode
	 * @return
	 */
	public List<Object[]> queryFavorites() {
		String sql = "select count(1) num,t.oper_id from ORC_T_FAVORITES t group by t.oper_id";
		return executeFindSql(sql);
	}

	/**
	 * 查询收藏 操作员代码对应 手机 与变化收藏量
	 * 
	 * @param pmCode
	 * @return
	 */
	public long queryFavoritesChange(String operId) {
		long count = 0L;
		String sql = "select count(*) from ORC_T_FAVORITES t1 where t1.bill_no in (select t.warranty_no from ftz_warranty_log t where t.create_time between sysdate - 1 and sysdate) and t1.oper_id = '"
				+ operId + "'";
		EntityManager em = emf.createEntityManager();
		BigDecimal b = (BigDecimal) em.createNativeQuery(sql).getSingleResult();
		if (null != b) {
			count = Long.valueOf(b.toString());
		} else {
			count = 0L;
		}
		return count;
	}

	// --对比异常;from_flag = 0 为仓库；1为清算；2为海关
	public List<Object[]> findAbnormal() {
		List<Object[]> objectCount=new ArrayList<Object[]>();
		objectCount.addAll(getAdmin("0"));
		objectCount.addAll(getAdmin("1"));
		objectCount.addAll(getAdmin("2"));
		return objectCount;
	}

	// 异议待处理； TS-YY 为投诉异议；CJ-YY为抽检异议；DB-YY为对比异议
	public List<Object[]> findDissent() {
		String sql = "select t.type,count(1) from woe_order_main t where t.type in('TS-YY','CJ-YY','DB-YY') and t.status = '10' group by t.type ";
		EntityManager ee = emf.createEntityManager();
		return (List<Object[]>) ee.createNativeQuery(sql).getResultList();

	}

	// 异议待反馈； TS-YY 为投诉异议；CJ-YY为抽检异议；DB-YY为对比异议
	public List<Object[]> findFeedback() {
		String sql = "select t.type,count(1) from woe_order_main t where t.type in('TS-YY','CJ-YY','DB-YY') and t.status in('20','30') group by t.type ";
		EntityManager ee = emf.createEntityManager();
		return (List<Object[]>) ee.createNativeQuery(sql).getResultList();
	}

	//
	public String findCompareDate() {
		String result = "";
		WarrantyCompare wc = new WarrantyCompare();
		String sql = "select to_char(rz.compare_time,'yyyy-MM-dd') from rz_warranty_compare rz order by rz.compare_time desc";
		EntityManager e = emf.createEntityManager();
		List<String> compare = new ArrayList<String>();
		compare = e.createNativeQuery(sql).getResultList();
		if (compare != null && compare.size() > 0) {
			result = compare.get(0);
		}

		return result;
	}

	// 查询是否是会员
	public String getUsercode(String usercode) {
		String sql = "select t.IS_ADM from RZ_BSP_UMC_USER t where t.user_id='"
				+ usercode + "'";
		String result = "";
		EntityManager em = emf.createEntityManager();
		List<String> list = em.createNativeQuery(sql).getResultList();
		if (null != list && list.size() > 0) {
			result = list.get(0);
		}
		return result;
	}

	/*@SuppressWarnings("unchecked")
	public List<String> queryUserPhone(OrcTMessageUserphoneVo vo) {
		String sql = "select t.phone_num  from orc_t_message_userphone t where 1=1 ";
		String usercode = vo.getUserCode();
		String isadmin = getUsercode(usercode);
		vo.setIsAdm(isadmin);
		if ("1".equals(vo.getIsAdm())) {
			sql += " and t.CUSTOMERCODE='" + vo.getCustomerCode() + "'";
		} else {
			sql += " and t.USER_CODE='" + vo.getUserCode() + "'";
		}
		sql += " group by t.phone_num";
		EntityManager em = emf.createEntityManager();
		return em.createNativeQuery(sql.toString()).getResultList();
	}
*/
	public List<Object[]> queryUserFccname(String phone) {
		String sql = "select a.fcname, a.fccode from orc_t_massage_util a where a.fccode in (select t.fccode  from orc_t_message_userphone t where t.phone_num = '"
				+ phone + "')";
		return executeFindSql(sql);
	}

	public List<Object[]> isExisPhone(String usercode, String marketFlag) {
		String sql = "select t.phone_num from orc_t_message_userphone t where t.phone_num=(select td.mobile from RZ_BSP_UMC_USER td where td.user_id='"
				+ usercode
				+ "') and t.market_flag='"
				+ marketFlag
				+ "' and t.user_code='" + usercode + "'";
		return executeFindSql(sql);
	}

	// 查询用户的电话号码
	public String gettellphone(String usercode) {
		String sql = "select t.mobile from RZ_BSP_UMC_USER t where t.user_id='"
				+ usercode + "'";
		EntityManager em = emf.createEntityManager();
		logger.info("" + sql);
		String result = "";
		List<String> list = em.createNativeQuery(sql).getResultList();
		if (null != list && list.size() > 0) {
			result = list.get(0);
		}
		return result;
	}

/*	@SuppressWarnings("unchecked")
	public List<String> queryUserPhonePage(OrcTMessageUserphoneVo vo,
			String flag) {
		String sql = "select customercode from (select tem.*,rownum as num from (select distinct t.customercode from orc_t_message_userphone t where 1=1 ";
		if (!StringUtil.isEmpty(vo.getCustomerCode())) {
			sql += " and t.customercode like '%"
					+ vo.getCustomerCode().toUpperCase() + "%'";
		}
		if (!StringUtil.isEmpty(vo.getCustomerName())) {
			sql += " and t.customername like '%" + vo.getCustomerName() + "%'";
		}
		if (!StringUtil.isEmpty(vo.getPhoneNum())) {
			sql += " and t.phone_num like '%" + vo.getPhoneNum() + "%'";
		}
		sql += "  ) tem   ) where  1=1  ";
		EntityManager em = emf.createEntityManager();
		// Query query= em.createNativeQuery(sql);
		if ("1".equals(flag)) {
			sql += " and num between " + (vo.getFirstResult() + 1) + " and "
					+ (vo.getFirstResult() + vo.getMaxResults()) + "";
		}
		logger.info("会员定制管理分页查询sql:" + sql);
		return em.createNativeQuery(sql.toString()).getResultList();
	}
*/
	public List<Object[]> queryWeihu(String customerCode, String marketFlag) {
		String sql = "select t.fccode,(select a.fcname from orc_t_massage_util a where a.fccode = t.fccode) fcname,t.phone_num from orc_t_message_userphone t where t.market_flag = '"
				+ marketFlag + "' and t.customercode = '" + customerCode + "'";
		return executeFindSql(sql);
	}

	@SuppressWarnings("unchecked")
	public String getUserNameByUserCode(String userCode) {
		String result = " select t.user_name from RZ_BSP_UMC_USER t where t.user_id='"
				+ userCode + "'";
		EntityManager em = emf.createEntityManager();
		return (String) em.createNativeQuery(result.toString())
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public BigDecimal findBizObjFile(String bizObj, String bizPkValue,
			String fileGroup) {
		String result = " select count(1) from T_HX_BIZ_OBJ_FILE t where t.BIZ_OBJ='"
				+ bizObj
				+ "' and BIZ_PK_VALUE='"
				+ bizPkValue
				+ "' and FILE_GROUP='" + fileGroup + "'";
		EntityManager em = emf.createEntityManager();
		return (BigDecimal) em.createNativeQuery(result).getSingleResult();
	}

	// 是否是金服公司
	public String isJinFu(String applicationid) {
		String sql = "select v.is_partner from rz_t_finance_application t,T_HX_BANK_TYPE v where t.BANK_NUM = v.bank_code  and t.application_id='"
				+ applicationid + "'";
		EntityManager em = emf.createEntityManager();
		List list = em.createNativeQuery(sql).getResultList();
		String is = "";
		if (null != list && list.size() > 0) {
			is = (String) list.get(0);
		}
		return is;
	}

	// 查询数据授权，是否存在
	@SuppressWarnings("unchecked")
	public BigDecimal findDataFilter(String userId, String pageUrl,
			String trdCode, String authStatus) {
		String result = " select count(1) from T_HX_DATA_FILTER t where t.USER_ID='"
				+ userId
				+ "' and PAGE_URL='"
				+ pageUrl
				+ "' and TRD_CODE='"
				+ trdCode + "' and AUTH_STATUS='" + authStatus + "'";
		EntityManager em = emf.createEntityManager();
		return (BigDecimal) em.createNativeQuery(result).getSingleResult();
	}

	public List<Object[]> searchAllBankName() {
		String sql = "select bsp_company_code,chinese_full_name from rel_users_role a,rz_bsp_umc_company b where a.role_id='04' and a.user_id=b.bsp_company_code";
		return executeFindSql(sql);
	}
	 
	/**
	 *  统计当前日每个交易平台的登记（数）量
	 *  Object[0] 交易平台名称
	 *  Object[1] 交易平台代码
	 *  Object[3] 登记数量
	 */
	public List<Object[]> queryTraderRegisterCount() {
		String sql = "  select w.org_sys_name, w.org_sys_no, count(1)　from rz_warranty w　where w.warranty_no  not in ('W150729011228711662', 'W150730011328481721', 'W150729011268577902') " +
				" and to_char(w.create_time, 'yyyy-mm-dd') > '2015-07-28'  w.market_flag = '10'  and w.org_sys_name is not null group by w.org_sys_name, w.org_sys_no";
		logger.info(" 统计当前日每个交易平台的登记（数）量SQL:"+sql);
		return executeFindSql(sql);
	}
	
	/**
	 *  统计当前日每个交易平台的登记（数）量
	 *  Object[0] 交易平台名称
	 *  Object[1] 交易平台代码
	 *  Object[3] 登记数量
	 */
	public List<Object[]> countOrgSysNameTraderRegister() {
		String sql = " select t.org_sys_name ,t.org_sys_no from ftz_chart_traderregister_stat t group by t.org_sys_name, t.org_sys_no";
		logger.info(" 统计交易平台数SQL:"+sql);
		return executeFindSql(sql);
	}
	
	private List<Object[]> getAdmin(String fromFlag){
		String sql="select v.flag,v.sumnum"+
          "  from (  select t.from_flag as flag,to_char(t.compare_time,'yyyy-mm-dd') as test,count(t.ABNORMAL_NUM) as sumnum "+
          " from rz_warranty_compare t"+
          " where t.market_flag = '10' "+
          " and t.from_flag = '"+fromFlag+"'  "+
          " and t.RESULT_FLAG = '0'"+
          " group by to_char(t.compare_time,'yyyy-mm-dd'),t.from_flag"+
          " order by to_char(t.compare_time,'yyyy-mm-dd') desc) v"+
          " where rownum <= 1";
		EntityManager ee = emf.createEntityManager();
		return (List<Object[]>) ee.createNativeQuery(sql).getResultList();
	}
	/**
	 * 需要非空判断
	 * Object[0]平台代码
	 * Object[1]平台名称
	 */
	public Object[] getPlatformInfo(){
		String sql="select r.user_id,c.chinese_full_name from rel_users_role r,rz_bsp_umc_company c where r.role_id='05' and r.user_id=c.bsp_company_code";
		EntityManager em=emf.createEntityManager();
		List<Object[]> list=em.createNativeQuery(sql).getResultList();
		if(null!=list&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	
//=====================================日报表首页列表仓库==>品种==>交易数据==========================================//
			/*
			     录入当天仓单的仓单信息，做日报表展示
			     包括仓库和仓库下具体某个品种的以下信息：
			     生成仓单笔数(笔)  
			     生成仓单重量(吨)  
			     生成仓单数量(件)  
			     注销仓单笔数   
			     注销仓单重量   
			     注销仓单数量
			 */
		/**
		 * 查询当天仓单信息中所有仓库
		 */
		public List<Object[]> queryWarehouseList(){
			String sql = " select  w.warehouse_num, w.warehouse_name from rz_warranty w where 1 = 1" 
					     +getDailySheetCondition()+
					     " group by  w.warehouse_num, w.warehouse_name ";
			logger.info("【###查询当天仓单信息中所有仓库SQL###】："+sql);
			EntityManager em = emf.createEntityManager();
			return  (List<Object[]>) em.createNativeQuery(sql).getResultList();
		}
		
		private String getDailySheetCondition(){
			String sql=" and w.market_flag='10'  and ( " +
					" (to_char(w.create_time, 'yyyy-mm-dd') =to_char(sysdate, 'yyyy-mm-dd') and w.Warranty_Status = '05')"+
					" or (to_char(w.cancel_time, 'yyyy-mm-dd') =to_char(sysdate, 'yyyy-mm-dd') and w.Warranty_Status = '01')" +
					" ) " ;
			return sql;
		}
	/*	*//**
		 * 查询当天仓单信息中某个仓库下所有品种
		 *//*
		public List<Object[]> queryWarehousePrdList(String warehouseNum){
			EntityManager em = emf.createEntityManager();
			List<Object[]> list = new ArrayList<Object[]>();
			StringBuffer sb=new StringBuffer();
			sb.append("select   m.base_catagory_code, m.base_catagory_name  from fds_goods_cata_mapping m where m.ftz_catagory_code in  ( " +
					  " select t.pm_code from  rz_warranty w, rz_warranty_good t, fds_goods_cata_mapping m " +
					  "  where 1 = 1 and w.warranty_no = t.warranty_no and t.pm_code = m.ftz_catagory_code  " 
					  +getDailySheetCondition());
			if(!warehouseNum.isEmpty()&&!"".equals(warehouseNum)){
				sb.append("and w.warehouse_num='"+warehouseNum+"' )    group by m.base_catagory_code, m.base_catagory_name");
				logger.info("【###查询仓库代码：##"+warehouseNum+"##下所有品种SQL###】："+sb.toString());
				list = (List<Object[]>) em.createNativeQuery(sb.toString()).getResultList();
			}
			return list;
		}*/
		
		/**
		 * 查询当天仓单信息中某个仓库下某个品种的：
		 * 生成仓单笔数(笔)  
	     * 生成仓单重量(吨)  
	     * 生成仓单数量(件) 
		 */
/*		public Object[] queryCreate(String warehouseNum,String prdCode,String flag){//flag=0表示汇总信息 1表示查某一个品种下的信息
			EntityManager em = emf.createEntityManager();
			StringBuffer sb=new StringBuffer();
			sb.append(" select count(1), nvl(sum(w.num), 0), nvl(sum(w.weight), 0)  from rz_warranty w  where 1 = 1  " +
					  " and  w.warranty_no in (select g.warranty_no  from rz_warranty_good g where exists (" +
					  " select 1  from fds_goods_cata_mapping m where m.ftz_catagory_code = g.pm_code " );
			if("1".equals(flag)){
				if(StringUtil.isEmpty(prdCode)){
					sb.append(" and m.base_catagory_code is null");
				}else{
					sb.append(" and m.base_catagory_code='"+prdCode+"'");
				}
			}	
			sb.append(" ))  and w.market_flag = '10' and (to_char(w.create_time, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd') and w.Warranty_Status = '05')");
			if(!warehouseNum.isEmpty()&&!"".equals(warehouseNum)){
				sb.append(" and w.warehouse_num='"+warehouseNum+"'");
			}
			logger.info("【###查询仓库代码：##"+warehouseNum+"##下品种代码：##"+prdCode+"##的生成仓单笔数,重量,数量SQL###】："+sb.toString());
			return  (Object[]) em.createNativeQuery(sb.toString()).getSingleResult();
		}*/
		
		/**
		 * 当天仓单信息中某个仓库下某个品种的：
		 * 注销仓单笔数   
	     * 注销仓单重量   
	     * 注销仓单数量
		 */
/*		public Object[] queryCancel(String warehouseNum,String prdCode,String flag){//flag=0表示汇总信息 1表示查某一个品种下的信息
			EntityManager em = emf.createEntityManager();
			StringBuffer sb=new StringBuffer();
			sb.append(" select count(1), nvl(sum(w.num), 0), nvl(sum(w.weight), 0)  from rz_warranty w  where 1 = 1  " +
					  " and  w.warranty_no in (select g.warranty_no  from rz_warranty_good g where exists (" +
					  " select 1  from fds_goods_cata_mapping m where m.ftz_catagory_code = g.pm_code " );
			if("1".equals(flag)){
				if(StringUtil.isEmpty(prdCode)){
					sb.append(" and m.base_catagory_code is null");
				}else{
					sb.append(" and m.base_catagory_code='"+prdCode+"'");
				}
			}	
			sb.append(" ))  and w.market_flag = '10' and (to_char(w.cancel_time, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd') and w.Warranty_Status = '01')");
			if(!warehouseNum.isEmpty()&&!"".equals(warehouseNum)){
				sb.append(" and w.warehouse_num='"+warehouseNum+"'");
			}
			logger.info("【###查询仓库代码：##"+warehouseNum+"##下品种代码：##"+prdCode+"##的的注销仓单笔数,重量,数量SQL###】："+sb.toString());
			return  (Object[]) em.createNativeQuery(sb.toString()).getSingleResult();
		}*/
			
//=====================================日报表首页列表（仓库==>品种==>交易数据）==========================================//	

		
//=====================================日报表第二页图（交易平台==>交易重量）==========================================//
		/**
		 * 查询当天仓单信息中所有交易平台
		 */
		public List<Object[]> queryOrgSysList(){//sysdate
			String sql = "select distinct w.org_sys_no,w.org_sys_name from rz_warranty w " +
					     "where 1 = 1 and to_char(w.create_time, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd') " +
					     "and w.market_flag='10' and w.Warranty_Status in ('05','103','106')  ";
			logger.info("【###查询当天仓单信息中所有交易平台SQL###】："+sql);
			EntityManager em = emf.createEntityManager();
			return  (List<Object[]>) em.createNativeQuery(sql).getResultList();
		}
		
		/**
		 * 统计某个平台下(某个仓库)的交易重量
		 * Warranty_Status仓单状态:05 已生成  103交易锁定   106挂牌锁定
		 * market_flag市场区分标识:10自贸区分市场
		 */
	/*	public BigDecimal querySumWeight(String orgSysNo,String warehouseNum){
			EntityManager em = emf.createEntityManager();
			StringBuffer sb=new StringBuffer();
			sb.append("select nvl(sum(w.weight), 0) from rz_warranty w where 1 = 1 " +
					  "and to_char(w.create_time, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd') " +
					  "and w.Warranty_Status in('05','103','106') and w.market_flag='10' ");
			if(!orgSysNo.isEmpty()&&!"".equals(orgSysNo)){
				sb.append("and w.org_sys_no='"+orgSysNo+"'");
				if(!warehouseNum.isEmpty()&&!"".equals(warehouseNum)){
					sb.append("and w.warehouse_num='"+warehouseNum+"'");
					logger.info("【###查询交易平台代码为：##"+orgSysNo+"##下仓库代码为："+warehouseNum+"下总交易重量SQL###】："+sb.toString());
				}else{
					logger.info("【###查询交易平台代码为：##"+orgSysNo+"##下总交易重量SQL###】："+sb.toString());
				}
			}
			return (BigDecimal)em.createNativeQuery(sb.toString()).getSingleResult();
		}*/
		

//=====================================日报表第二页图（交易平台==>交易重量）==========================================//

		
//=====================================日报表第三页第一个图（平台==>仓库==>交易重量）==========================================//

	/*	*//**
		 * 查询当天仓单信息中某个平台下所有仓库
		 *//*
		public List<Object[]> queryWarehouseListByorgSysNo(String orgSysNo){//sysdate
			StringBuffer sb=new StringBuffer();
			sb.append("select distinct w.warehouse_num, w.warehouse_name from rz_warranty w " +
					  "where 1 = 1 and to_char(w.create_time, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd') " +
					  "and w.market_flag='10' and w.Warranty_Status in ('05','103','106') ");
			if(!orgSysNo.isEmpty()&&!"".equals(orgSysNo)){
				sb.append("and w.org_sys_no='"+orgSysNo+"'");
			}
			logger.info("【###查询当天仓单信息中平台代码为："+orgSysNo+"下所有仓库SQL###】："+sb.toString());
			EntityManager em = emf.createEntityManager();
			return  (List<Object[]>) em.createNativeQuery(sb.toString()).getResultList();
		}
		*/
//=====================================日报表第三页第一个图（平台==>仓库==>交易重量）==========================================//
		
		
//=====================================日报表第三页第二个图（平台==>品种==>交易数据）==========================================//
													 /*
													     生成仓单笔数(笔)  
													     生成仓单重量(吨)  
													     生成仓单数量(件)  
													     注销仓单笔数   
													     注销仓单重量   
													     注销仓单数量
													  */
		
		/**
		 * 查询当天仓单信息中所有交易平台
		 */
		public List<Object[]> queryOrgSysList01and05(){//sysdate
			String sql = "select  w.org_sys_no,w.org_sys_name from rz_warranty w " +
					     "where 1 = 1 "+getDailySheetCondition();
			logger.info("【###查询当天仓单信息中所有交易平台SQL###】："+sql);
			EntityManager em = emf.createEntityManager();
			return  (List<Object[]>) em.createNativeQuery(sql).getResultList();
		}
		
		/**
		 * 查询数据同步后所有交易平台
		 */
		public List<Object[]> queryOrgSysListVisual(){//sysdate
			String sql = "select distinct w.org_sys_no,w.org_sys_name from rz_warranty w " +
					     "where 1 = 1 " +
					     "and to_char(w.create_time, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd') and w.market_flag='10' " +
					     "and w.warranty_Status in ('05','103','106','01')";
			EntityManager em = emf.createEntityManager();
			return  (List<Object[]>) em.createNativeQuery(sql).getResultList();
		}
		
		/**
		 * 查询当天仓单信息中某个平台下所有品种
		 */
	/*	public List<Object[]> queryPrdListByOrgSysNo(String orgSysNo){
			EntityManager em = emf.createEntityManager();
			List<Object[]> list = new ArrayList<Object[]>();
			StringBuffer sb=new StringBuffer();
			sb.append("select   m.base_catagory_code, m.base_catagory_name  from fds_goods_cata_mapping m where m.ftz_catagory_code in  ( " +
					  " select t.pm_code from  rz_warranty w, rz_warranty_good t, fds_goods_cata_mapping m " +
					  "  where 1 = 1 and w.warranty_no = t.warranty_no and t.pm_code = m.ftz_catagory_code  " 
					  +getDailySheetCondition());
			if(!orgSysNo.isEmpty()&&!"".equals(orgSysNo)){
				sb.append("and w.org_sys_no='"+orgSysNo+"') group by m.base_catagory_code, m.base_catagory_name");
				list = (List<Object[]>) em.createNativeQuery(sb.toString()).getResultList();
				logger.info("【###查询平台代码：##"+orgSysNo+"##下所有品种SQL###】："+sb.toString());
			}
			return list;
		}*/
		/**
		 * 查询当天仓单信息中某个平台下某个品种的生成仓单数据信息
		 */
		public Object[] queryCreateByOrgSysNo(String orgSysNo,String prdCode){
			EntityManager em = emf.createEntityManager();
			StringBuffer sb=new StringBuffer();
			sb.append(" select count(1), nvl(sum(w.num), 0), nvl(sum(w.weight), 0)  from rz_warranty w  where 1 = 1  " +
					  " and  w.warranty_no in (select g.warranty_no  from rz_warranty_good g where exists (" +
					  " select 1  from fds_goods_cata_mapping m where m.ftz_catagory_code = g.pm_code " );
			if(StringUtil.isEmpty(prdCode)){
				sb.append(" and m.base_catagory_code is null");
			}else{
				sb.append(" and m.base_catagory_code='"+prdCode+"'");
			}
			sb.append(" ))  and w.market_flag = '10' and (to_char(w.create_time, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd') and w.Warranty_Status = '05')");
			if(!StringUtil.isEmpty(orgSysNo)){
				sb.append("and w.org_sys_no='"+orgSysNo+"'");
			}
			logger.info(" 查询仓单生成当天交易平台为："+orgSysNo+"--"+"品种代码："+prdCode+"－Sql:"+sb.toString());
			return  (Object[]) em.createNativeQuery(sb.toString()).getSingleResult();
		}
		
		/**
		 * 查询当天仓单信息中某个平台下某个品种的注销仓单信息
		 */
		public Object[] queryCancelByOrgSysNo(String orgSysNo,String prdCode){
			EntityManager em = emf.createEntityManager();
			StringBuffer sb=new StringBuffer();
			sb.append(" select count(1), nvl(sum(w.num), 0), nvl(sum(w.weight), 0)  from rz_warranty w  where 1 = 1  " +
					  " and  w.warranty_no in (select g.warranty_no  from rz_warranty_good g where exists (" +
					  " select 1  from fds_goods_cata_mapping m where m.ftz_catagory_code = g.pm_code " );
			if(StringUtil.isEmpty(prdCode)){
				sb.append(" and m.base_catagory_code is null");
			}else{
				sb.append(" and m.base_catagory_code='"+prdCode+"'");
			}
			sb.append(" ))  and w.market_flag = '10' and (to_char(w.cancel_time, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd') and w.Warranty_Status = '01')");
			if(!StringUtil.isEmpty(orgSysNo)){
				sb.append("and w.org_sys_no='"+orgSysNo+"'");
			}
			logger.info(" 查询仓单注销当天交易平台为："+orgSysNo+"--"+"品种代码："+prdCode+"－Sql:"+sb.toString());
			return  (Object[]) em.createNativeQuery(sb.toString()).getSingleResult();
		}
				
//=====================================日报表第三页第二个图（平台==>品种==>交易数据）==========================================//
//查询最新的31天的品种登记量计	
		@SuppressWarnings("unchecked")
		public String getSysOrgName(String sysOrgNo) {
	        String sql =  "select r.chinese_full_name from RZ_BSP_UMC_COMPANY r where r.bsp_company_code='"+sysOrgNo+"'";
	        EntityManager em = emf.createEntityManager();
	        List<String> valueList = (List<String>)em.createNativeQuery(sql.toString()).getResultList(); 
	        if(valueList != null && valueList.size() > 0) return valueList.get(0);
	        return null;
		}
		
}
