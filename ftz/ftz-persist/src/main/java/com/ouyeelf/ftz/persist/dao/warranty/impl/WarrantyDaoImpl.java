package com.ouyeelf.ftz.persist.dao.warranty.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.warranty.Warranty;
import com.ouyeelf.ftz.persist.dao.warranty.WarrantyDao;
import com.ouyeelf.ftz.persist.repository.warranty.WarrantyRespository;

@Service("warrantyDao")
public class WarrantyDaoImpl implements WarrantyDao {

	@Autowired
	WarrantyRespository warrantyRespository;


	public Warranty save(Warranty warranty) {

		return warrantyRespository.save(warranty);
	}

	public Warranty delete(Warranty warranty) {

		return warrantyRespository.delete(warranty);
	}

	public Warranty findOne(String warrantyNo) {
		return warrantyRespository.findOne(warrantyNo);
	}

	public List<Warranty> findByWarrantyAppNo(String warrantyAppNo) {
		return warrantyRespository.findByWarrantyAppNo(warrantyAppNo);
	}

	public List<Warranty> findByApplicationId(String applicationId) {
		return warrantyRespository.findByApplicationId(applicationId);
	}


	public List<Warranty> findByApplicationIdAndWarrantyStatus(
			String applicationId, String warrantyStatus) {
		return warrantyRespository.findByApplicationIdAndWarrantyStatus(applicationId);
	}


	public List<Warranty> findByWarrantyNoAndWarrantyStatus(String warrantyNo,
			String warrantyStatus) {
		
		return warrantyRespository.findByWarrantyNoAndWarrantyStatus(warrantyNo, warrantyStatus);
	}


	public List<String> findByCustomerCode(String customerCode) {
		return warrantyRespository.findByCustomerCode(customerCode);
	}


	public BigDecimal findByCustomerCodeAndStatus(String customerCode) {
		return warrantyRespository.findByCustomerCodeAndStatus(customerCode);
	}


	public BigDecimal findByCustomerCodeAndSta(String customerCode) {
		return warrantyRespository.findByCustomerCodeAndSta(customerCode);
	}
	
	public List<Warranty> findWarrantyByCustomerCode(String customerCode) {
		return warrantyRespository.findWarrantyByCustomerCode(customerCode);
	}

	public List<Warranty> findByWarehouseNum(String warehouseNum) {
		return warrantyRespository.findByWarehouseNum(warehouseNum);
	}

	public List<Warranty> findByBankCode(String bankCode) {
		return warrantyRespository.findByPledgeeCode(bankCode);
	}


	public int findByCustomerCodeAndStatus(String customerCode, String riqi) {
		return warrantyRespository.findByCustomerCodeAndStatus(customerCode, riqi).intValue();
	}


	public int findByCustomerCodeAndSta(String customerCode, String riqi) {
		return warrantyRespository.findByCustomerCodeAndSta(customerCode, riqi).intValue();
	}


	public Warranty findByRzWarehouseCodeAndPackNum(
			String packNum) {
		return warrantyRespository.findByRzWarehouseCodeAndPackNum(packNum);
	}
	
	
	//通过仓库代码查询仓单下不是已注销状态下的所有重量
	public BigDecimal getWeightByWarehouseNum(String warehouseNum){
		return warrantyRespository.getWeightByWarehouseNum(warehouseNum);
	}


	public BigDecimal getByWarehouseNum(String warehouseNum) {
		return warrantyRespository.getByWarehouseNum(warehouseNum);
	}


	public List<Warranty> findAll() {
		return warrantyRespository.findAll();
	}

	public Warranty findByOrgBillNo(String orgBillNo,String trdSysNo) {
		return warrantyRespository.findByOrgBillNo(orgBillNo,trdSysNo);
	}

	public int updateIsSynchronize(String isSynchronize,
			List<String> warrantyNoList) {
		// TODO Auto-generated method stub
		return warrantyRespository.updateIsSynchronize(isSynchronize, warrantyNoList);
	}

	

}
