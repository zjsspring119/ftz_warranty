package com.ouyeelf.ftz.persist.dao.warranty;

import java.math.BigDecimal;
import java.util.List;

import com.ouyeelf.ftz.model.domain.warranty.Warranty;

public interface WarrantyDao {

	public Warranty save(Warranty warranty);
	
	public Warranty delete(Warranty warranty);
	
	// 通过制单申请号查询仓单信息
	public List<Warranty> findByWarrantyAppNo(String warrantyAppNo);

	Warranty findOne(String warrantyNo); 
	
	//通过融资申请号查询仓单信息
	public  List<Warranty> findByApplicationId(String applicationId);

	List<Warranty> findByApplicationIdAndWarrantyStatus(String applicationId,
			String warrantyStatus);   

	public List<Warranty> findByWarrantyNoAndWarrantyStatus(
			String warrantyNo, String warrantyStatus); 
	
	public List<String> findByCustomerCode(String customerCode);
	
	
	//通过仓单信息查询仓单下不是已注销和不是已撤销状态下的所有重量
	public BigDecimal findByCustomerCodeAndStatus(String customerCode);
	
	//通过仓库代码查询仓单下不是已注销状态下的所有重量
	public BigDecimal getWeightByWarehouseNum(String warehouseNum);
	
	//通过仓单信息查询仓单下已质押状态下的所有重量
	public BigDecimal findByCustomerCodeAndSta(String customerCode);
	

	public List<Warranty> findWarrantyByCustomerCode(String customerCode);
		// TODO Auto-generated method stub
	
	public List<Warranty> findByWarehouseNum(String warehouseNum);


	public List<Warranty> findByBankCode(String bankCode);
	
	//通过仓单信息查询仓单下年月份不是已注销和不是已撤销状态下的所有重量createTime
	public int findByCustomerCodeAndStatus(String customerCode,String riqi);
	
	//通过仓单信息查询仓单下年月份已质押状态下的所有重量
	public int findByCustomerCodeAndSta(String customerCode,String riqi);
	//通过仓库代码和goodi查询仓单信息
	public Warranty findByRzWarehouseCodeAndPackNum(String packNum);
	//通过仓库代码查询仓单下已质押状态下的所有重量
	public BigDecimal getByWarehouseNum(String warehouseNum);
	
	public List<Warranty> findAll();
	public Warranty findByOrgBillNo(String orgBillNo,String trdSysNo);
	public int updateIsSynchronize(String isSynchronize,List<String> warrantyNoList);
	
}
