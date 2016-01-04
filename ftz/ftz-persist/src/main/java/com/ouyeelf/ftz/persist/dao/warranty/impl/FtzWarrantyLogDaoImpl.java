package com.ouyeelf.ftz.persist.dao.warranty.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ouyeelf.ftz.model.domain.warranty.FtzWarrantyLog;
import com.ouyeelf.ftz.persist.dao.warranty.FtzWarrantyLogDao;
import com.ouyeelf.ftz.persist.repository.warranty.FtzWarrantyLogRepository;

@Service("ftzWarrantyLogDao")
public class FtzWarrantyLogDaoImpl implements FtzWarrantyLogDao {

	@Autowired
	private  FtzWarrantyLogRepository ftzWarrantyLogRepository;
	
	public List<Object[]> findGroupByOrgsysAndWarehouseAndPmCalss() {
		// TODO Auto-generated method stub
		return  ftzWarrantyLogRepository.findGroupByOrgsysAndWarehouseAndPmCalss();
	}
	public List<Object[]> findOrgBillNoAndWarrantyNoByOrgsysNoAndWarehouseNumAndPmCalss(
			String orgSysNo, String warehouseNum, String pmCalss) {
		// TODO Auto-generated method stub
		return ftzWarrantyLogRepository.findOrgBillNoAndWarrantyNoByOrgsysNoAndWarehouseNumAndPmCalss(orgSysNo, warehouseNum, pmCalss);
	}

	public List<String> findBussinessTimeByOrgBillNo(String orgBillNo) {
		// TODO Auto-generated method stub
		return ftzWarrantyLogRepository.findBussinessTimeByOrgBillNo(orgBillNo);
	}
	public List<String> findOrgBillNoByOrgsysNoAndWarehouseNumAndPmCalss(
			String orgSysNo, String warehouseNum, String pmCalss) {
		// TODO Auto-generated method stub
		return ftzWarrantyLogRepository.findOrgBillNoByOrgsysNoAndWarehouseNumAndPmCalss(orgSysNo, warehouseNum, pmCalss);
	}
	public List<FtzWarrantyLog> findByOrgBillNoAndBussinessTime(
			String orgBillNo, String bussinessTime) {
		// TODO Auto-generated method stub
		return ftzWarrantyLogRepository.findByOrgBillNoAndBussinessTime(orgBillNo, bussinessTime);
	}
	public FtzWarrantyLog save(FtzWarrantyLog ftzWarrantyLog) {
		// TODO Auto-generated method stub
		return ftzWarrantyLogRepository.save(ftzWarrantyLog);
	}
	public int updateIsSynchronize(String isSynchronize, List<String> idList) {
		// TODO Auto-generated method stub
		return ftzWarrantyLogRepository.updateIsSynchronize(isSynchronize, idList);
	}

}
