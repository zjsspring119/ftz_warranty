package com.ouyeelf.ftz.persist.dao.warranty;

import java.math.BigDecimal;
import java.util.List;

import com.ouyeelf.ftz.model.domain.warranty.WarrantyGood;
import com.ouyeelf.ftz.model.domain.warranty.WarrantyGoodView;

public interface WarrantyGoodDao {

	public WarrantyGood findOne(String id); 
   
	public WarrantyGood save(WarrantyGood warrantyGood);
	
	 public List<WarrantyGood> findByWarrantyNo(String warrantyNo);

	public void delete(WarrantyGood warrantyGood2);

	public List<WarrantyGoodView>  findWarrantyGoodViewByWarrantyNo(String warrantyNo);

	public List<WarrantyGood> findByCoditions(String warrantyNo,String typeName, String saveNo,
			String grade, String spec, String gradeNumXh,String memo); 
	
	public long queryCountPackageNo(String applicationId);

	public List<String> findGradeListByWarrantyNo(String warrantyNo);

	public List<String> findTypeNameByWarrantyNo(String warrantyNo); 
	
	public List<WarrantyGood> queryWarrantyLabels(String mortgageNo,
			String area, String location);
	
	public List<WarrantyGood> findByNo(List<String> warrantyNo,
			String typeName, String grade, String spec,String areaP); 
	public List<WarrantyGood> queryByWarehouseCodeAndAreaAndLocation(String rzWarehouseCode,String area, String location,String warrantyNo);
	
	public WarrantyGood findByWarrantyNoAndGoodId(String warrantyNo,
			String goodId);
	
	public List<WarrantyGood> findByLabelLocationNo(String labelLocationNo);
	
	public List<WarrantyGood> findByCodition(String warrantyNo,String typeName,
			  String grade, String spec,String areaP) ;
	
	public BigDecimal sumWeghtByGoodId(String goodId);
	
	
}
