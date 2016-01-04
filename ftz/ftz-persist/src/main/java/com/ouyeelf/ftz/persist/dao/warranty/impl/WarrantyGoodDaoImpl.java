package com.ouyeelf.ftz.persist.dao.warranty.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.warranty.WarrantyGood;
import com.ouyeelf.ftz.model.domain.warranty.WarrantyGoodView;
import com.ouyeelf.ftz.persist.dao.warranty.WarrantyGoodDao;
import com.ouyeelf.ftz.persist.repository.warranty.WarrantyGoodRespository;
import com.ouyeelf.ftz.persist.repository.warranty.WarrantyGoodViewRespository;

@Service("warrantyGoodDao")
public class WarrantyGoodDaoImpl implements WarrantyGoodDao {

	@Autowired
	WarrantyGoodRespository warrantyGoodRespository;
	
	@Autowired
	private WarrantyGoodViewRespository warrantyGoodViewRespository;
	 
	public WarrantyGood findOne(String id) {
		return warrantyGoodRespository.findOne(id);
	}
	
	public WarrantyGood save(WarrantyGood warrantyGood) {
		return warrantyGoodRespository.save(warrantyGood);
	}
	
	public List<WarrantyGood> findByWarrantyNo(String warrantyNo) {
		return warrantyGoodRespository.findByWarrantyNo(warrantyNo);
	}
	
	public void delete(WarrantyGood warrantyGood2) {
		warrantyGoodRespository.delete(warrantyGood2);
	}
	
	public List<WarrantyGoodView> findWarrantyGoodViewByWarrantyNo(String warrantyNo) {
		return warrantyGoodViewRespository.queryByWarrantyNo(warrantyNo);
	}
	
	public List<WarrantyGood> findByCoditions(String warrantyNo,String typeName, String saveNo,
											  String grade, String spec, String gradeNumXh,String memo) {
		if(memo != null && !"".equals(memo)){
			return warrantyGoodRespository.findByCoditions(warrantyNo,typeName,saveNo,grade,spec,gradeNumXh,memo); 
		}
		
		if(memo == null || "".equals(memo)){
			return warrantyGoodRespository.findByCoditionsAndMemoIsNull(warrantyNo,typeName,saveNo,grade,spec,gradeNumXh);
		}
		return null;
	}
	
	public List<WarrantyGood> findByCodition(String warrantyNo,String typeName,
											  String grade, String spec,String areaP) {
			return warrantyGoodRespository.findByCodition(warrantyNo,typeName,grade,spec,areaP); 
	}
	
	public long queryCountPackageNo(String applicationId) {
		return warrantyGoodRespository.queryCountPackageNo(applicationId);
	}

	public List<String> findGradeListByWarrantyNo(String warrantyNo) {
		// TODO Auto-generated method stub
		return warrantyGoodRespository.findGradeListByWarrantyNo(warrantyNo);
	}
	

	public List<String> findTypeNameByWarrantyNo(String warrantyNo) {
		// TODO Auto-generated method stub
		return warrantyGoodRespository.findTypeNameByWarrantyNo(warrantyNo);
	}

	public List<WarrantyGood> findByNo(List<String> warrantyNo,
			String typeName, String grade, String spec, String areaP) {
		// TODO Auto-generated method stub
		return warrantyGoodRespository.findByNo(warrantyNo, typeName, grade, spec, areaP);
	}

	public List<WarrantyGood> queryByWarehouseCodeAndAreaAndLocation(
			String rzWarehouseCode, String area, String location,
			String warrantyNo) {
		// TODO Auto-generated method stub
		return warrantyGoodRespository.queryByWarehouseCodeAndAreaAndLocation(rzWarehouseCode, area, location, warrantyNo);
	}

	public List<WarrantyGood> queryWarrantyLabels(String mortgageNo,
			String area, String location) {
		// TODO Auto-generated method stub
		return warrantyGoodRespository.queryWarrantyLabels(mortgageNo, area, location);
	}

	public WarrantyGood findByWarrantyNoAndGoodId(String warrantyNo,
			String goodId) {
		return warrantyGoodRespository.findByWarrantyNoAndGoodId(warrantyNo, goodId);
	}

	public List<WarrantyGood> findByLabelLocationNo(String labelLocationNo) {
		// TODO Auto-generated method stub
		return warrantyGoodRespository.findByLabelLocationNo(labelLocationNo);
	}

	public BigDecimal sumWeghtByGoodId(String goodId) {
		// TODO Auto-generated method stub
		return warrantyGoodRespository.sumWeghtByGoodId(goodId);
	}


}
