package com.ouyeelf.ftz.persist.repository.warranty;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.warranty.FtzWarrantyLog;

public interface FtzWarrantyLogRepository extends Repository<FtzWarrantyLog, String> {
	
	/**
	 * 根据交易平台,仓库，品种分组查询
	 * @return
	 */
	@Query(" select w.orgSysNo,w.orgSysName,w.warehouseNum,w.warehouseName,g.pmClass from FtzWarrantyLog t ,Warranty w,  WarrantyGood g " +
			"   where t.compareFlag='0' and w.warrantyNo=t.warrantyNo and g.warrantyNo=t.warrantyNo" +
			"  group by  w.orgSysNo,w.orgSysName,w.warehouseNum,w.warehouseName,g.pmClass ")
	public List<Object[]> findGroupByOrgsysAndWarehouseAndPmCalss();
	
	/**
	 * 
	 * @param orgSysNo
	 * @param warehouseNum
	 * @param pmCalss
	 * @return
	 */
	@Query("select t.orgBillNo ,t.warrantyNo from FtzWarrantyLog t,Warranty w,WarrantyGood g  " +
			" where t.compareFlag ='0' and w.warrantyNo=t.warrantyNo and g.warrantyNo=t.warrantyNo and  w.orgSysNo=?1 and w.warehouseNum=?2 and g.pmClass=?3 " +
			" group by t.orgBillNo,t.warrantyNo")
	public List<Object[]> findOrgBillNoAndWarrantyNoByOrgsysNoAndWarehouseNumAndPmCalss(String orgSysNo,String warehouseNum ,String pmCalss);
	
	
	/**
	 *  select  *  from ftz_warranty_log g where  g.org_bill_no='jy0001'    and g.warranty_no='W141126005946'   order by g.bussiness_time desc;
	 */

	public List<FtzWarrantyLog> findByOrgBillNoAndBussinessTime(String orgBillNo,String bussinessTime);
	
	@Query("select t.orgBillNo from FtzWarrantyLog t , Warranty w,WarrantyGood g " +
			" where t.compareFlag ='0' and w.warrantyNo=t.warrantyNo and g.warrantyNo=t.warrantyNo and w.orgSysNo=?1 and w.warehouseNum=?2 and g.pmClass=?3 " +
			" group by t.orgBillNo")
	public List<String> findOrgBillNoByOrgsysNoAndWarehouseNumAndPmCalss(String orgSysNo,String warehouseNum ,String pmCalss);
	
	/**
	 * select  g.bussiness_time   from ftz_warranty_log g where  g.org_bill_no='jy0001'   group by g.bussiness_time order by g.bussiness_time desc;
	 * @param orgBillNo
	 * @return
	 */
	
	@Query("select g.bussinessTime from FtzWarrantyLog g where g.orgBillNo=?1 and g.compareFlag='0' group  by g.bussinessTime order by g.bussinessTime desc")
	public List<String> findBussinessTimeByOrgBillNo(String orgBillNo);
	
	public FtzWarrantyLog save(FtzWarrantyLog ftzWarrantyLog);
	
	@Modifying
	@Query("update FtzWarrantyLog f set f.isSynchronize =?1  where f.id in(?2)")
	public int updateIsSynchronize(String isSynchronize,List<String> idList);
}
