package com.ouyeelf.ftz.persist.repository.compare;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.compare.CompareData;

/*****************************************
 *@Copyright (c)  by baosight Co., Ltd 
 *@All right reserved
 *@Create Date 2015-1-23
 *@author zjs
 *@File Name:  
 *@Last version:  1.0
 *@Function:
 *@Last Update Date:
 *@Change Log:
 *****************************************/
public interface CompareDataRepository extends Repository<CompareData, String>,JpaSpecificationExecutor<CompareData> {

	public List<CompareData> findByOrgSysNoAndWarehouseNum(String orgSysNo, String warehouseNum);
	public List<CompareData> findByOrgSysNoAndWarehouseName(String orgSysNo, String warehouseName);
	
	public List<CompareData> findByWarehouseNum(String warehouseNum);
	
	public Page<CompareData> findAll(Pageable pageable);
	
	public void save(CompareData compareData);
	
	@Modifying
	public void delete(CompareData compareData);
	
	public CompareData findOne(String id);
	
	public CompareData findByWarehouseNumAndOrgSysNo(String warehouseNum,String orgSysNo);
}
