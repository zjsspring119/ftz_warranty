package com.ouyeelf.ftz.persist.repository.warranty;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import com.ouyeelf.ftz.model.domain.warranty.Warranty;

/**
 * 仓单查询
 * 
 * @author zhouwei
 * 
 */
public interface WarrantyRespository extends Repository<Warranty, String>,
		JpaSpecificationExecutor<Warranty> {

	public Page<Warranty> findAll(Pageable pageable);

	public Warranty save(Warranty warranty);

	public Warranty delete(Warranty warranty);

	// 通过制单申请号查询仓单信息
	public List<Warranty> findByWarrantyAppNo(String warrantyAppNo);

	public Warranty findOne(String warrantyNo);

	// 通过融资申请号查询仓单信息
	public List<Warranty> findByApplicationId(String applicationId);

	// @Query("from Warranty t where t.customerCode = ?1 and t.warrantyStatus = '05'")
	// public List<Warranty> findByCustomerId(String customerId);

	// @Query("from Warranty t where t.warrantyStatus = '05'")
	public List<Warranty> findAll();

	@Query("from Warranty a where a.applicationId=?1 ")
	public List<Warranty> findByApplicationIdAndWarrantyStatus(
			String applicationId);

	public List<Warranty> findByWarrantyNoAndWarrantyStatus(String warrantyNo,
			String warrantyStatus);

	// 通过客户代码查询仓单代码,group by仓库代码
	@Query("select a.warehouseNum from Warranty a where a.customerCode=?1 group by warehouseNum")
	public List<String> findByCustomerCode(String customerCode);

	// 通过仓单信息查询仓单下不是已注销和不是已撤销状态下的所有重量
	@Query("select nvl(round(sum(a.weight),0),0) from Warranty a where a.customerCode=?1 and a.warrantyStatus not in('01','99','02')")
	public BigDecimal findByCustomerCodeAndStatus(String customerCode);

	// 通过仓库代码查询仓单下不是已注销、撤销、预生成状态下的所有重量
	@Query("select nvl(round(sum(a.weight),0),0) from Warranty a where a.warehouseNum=?1 and a.warrantyStatus not in('01','02','99') ")
	public BigDecimal getWeightByWarehouseNum(String warehouseNum);

	// 通过仓库代码查询仓单下已质押状态下的所有重量
	@Query("select nvl(round(sum(a.weight),0),0) from Warranty a where a.warehouseNum=?1 and a.warrantyStatus = '51' ")
	public BigDecimal getByWarehouseNum(String warehouseNum);

	// 通过仓单信息查询仓单下已质押状态下的所有重量
	@Query("select nvl(round(sum(a.weight),0),0) from Warranty a where a.customerCode=?1 and a.warrantyStatus='51'")
	public BigDecimal findByCustomerCodeAndSta(String customerCode);

	@Query("select a from Warranty a where a.customerCode=?1 ")
	public List<Warranty> findWarrantyByCustomerCode(String customerCode);// 客户代码

	public List<Warranty> findByWarehouseNum(String warehouseNum);// 仓库代码

	public List<Warranty> findByPledgeeCode(String bankCode);// 银行(质权人)代码

	/*
	 * //通过仓单信息查询仓单下年月份不是已注销和不是已撤销状态下的所有重量createTime
	 * 
	 * @Query(
	 * "select nvl(round(sum(a.weight),0),0) from Warranty a where a.customerCode=?1 and a.warrantyStatus not in('01','99') and a.createTime >= to_date(?2,'yyyy-MM') and a.createTime < add_months(to_date(?2,'yyyy-MM'),1)"
	 * ) public BigDecimal findByCustomerCodeAndStatus(String
	 * customerCode,String riqi);
	 * 
	 * //通过仓单信息查询仓单下年月份已质押状态下的所有重量
	 * 
	 * @Query(
	 * "select nvl(round(sum(a.weight),0),0) from Warranty a where a.customerCode=?1 and a.warrantyStatus='51' and a.createTime >= to_date(?2,'yyyy-MM') and a.createTime < add_months(to_date(?2,'yyyy-MM'),1)"
	 * ) public BigDecimal findByCustomerCodeAndSta(String customerCode,String
	 * riqi);
	 */

	/*
	 * //通过仓单信息查询仓单下年月日不是已注销和不是已撤销状态下的所有重量createTime
	 * 
	 * @Query(
	 * "select nvl(round(sum(a.weight),0),0) from Warranty a where a.customerCode=?1 and a.warrantyStatus not in('01','99') and a.createTime like to_date(?2,'yyyy-MM-dd')"
	 * ) public BigDecimal findByCustomerCodeAndStatus(String
	 * customerCode,String riqi);
	 * 
	 * //通过仓单信息查询仓单下年月份已质押状态下的所有重量
	 * 
	 * @Query(
	 * "select nvl(round(sum(a.weight),0),0) from Warranty a where a.customerCode=?1 and a.warrantyStatus='51' and a.createTime like to_date(?2,'yyyy-MM-dd')"
	 * ) public BigDecimal findByCustomerCodeAndSta(String customerCode,String
	 * riqi);
	 */

	// 通过仓单信息查询仓单下年月日不是已注销和不是已撤销状态下的所有重量createTime
	@Query("select nvl(round(sum(a.weight),0),0) from Warranty a where a.customerCode=?1 and a.warrantyStatus not in('01','99') and a.createTime <= to_date(?2,'yyyy-MM-dd')")
	public BigDecimal findByCustomerCodeAndStatus(String customerCode,
			String riqi);

	// 通过仓单信息查询仓单下年月份已质押状态下的所有重量
	@Query("select nvl(round(sum(a.weight),0),0) from Warranty a where a.customerCode=?1 and a.warrantyStatus='51' and a.createTime <= to_date(?2,'yyyy-MM-dd')")
	public BigDecimal findByCustomerCodeAndSta(String customerCode, String riqi);

	// 通过仓库代码和goodi查询仓单信息
	@Query("select w from Warranty w where  exists(select 1 from WarrantyGood wg where w.warrantyNo = wg.warrantyNo and wg.packNum=?1)")
	public Warranty findByRzWarehouseCodeAndPackNum(String packNum);

	@Query("select w from Warranty w where  w.orgBillNo=?1 and w.warrantyStatus<>'01' and w.orgSysNo=?2)")
	public Warranty findByOrgBillNo(String orgBillNo,String trdSysNo);
	
	@Modifying
	@Query(" update Warranty w set w.isSynchronize=?1  where w.warrantyNo in(?2) ")
	public int updateIsSynchronize(String isSynchronize, List<String> warrantyNoList);
	

	

}
