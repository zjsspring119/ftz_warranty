package com.ouyeelf.ftz.persist.dao.compare;

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
public interface CompareDataDao {

	public CompareData findByOrgSysNoAndWarehouseNum(String orgSysNo, String warehouseNum);
	
	public CompareData findByWarehouseNum(String warehouseNum);
	
	public void save(CompareData compareData);
	
	public void delete(CompareData compareData);
	
	public CompareData findOne(String id);
	
	public CompareData findByWarehouseNumAndOrgSysNo(String warehouseNum,String orgSysNo);

	public CompareData findByOrgSysNoAndWarehouseName(String orgSysNo,String warehouseName);
}
