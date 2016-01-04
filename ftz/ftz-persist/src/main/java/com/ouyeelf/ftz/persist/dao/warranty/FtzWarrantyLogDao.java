package com.ouyeelf.ftz.persist.dao.warranty;

import java.util.List;

import com.ouyeelf.ftz.model.domain.warranty.FtzWarrantyLog;

public interface FtzWarrantyLogDao {

	public List<Object[]> findGroupByOrgsysAndWarehouseAndPmCalss();
	public List<Object[]> findOrgBillNoAndWarrantyNoByOrgsysNoAndWarehouseNumAndPmCalss(String orgSysNo,String warehouseNum ,String pmCalss);
	public List<FtzWarrantyLog> findByOrgBillNoAndBussinessTime(String orgBillNo,String bussinessTime);
	public List<String> findOrgBillNoByOrgsysNoAndWarehouseNumAndPmCalss(String orgSysNo,String warehouseNum ,String pmCalss);
	public List<String> findBussinessTimeByOrgBillNo(String orgBillNo);
	public FtzWarrantyLog save(FtzWarrantyLog ftzWarrantyLog);
	public int updateIsSynchronize(String isSynchronize,List<String> idList);
}
