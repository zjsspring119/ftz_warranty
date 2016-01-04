package com.ouyeelf.ftz.persist.dao.compare.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouyeelf.ftz.model.domain.compare.CompareData;
import com.ouyeelf.ftz.persist.dao.compare.CompareDataDao;
import com.ouyeelf.ftz.persist.repository.compare.CompareDataRepository;

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
@Service("compareDataDao")
public class CompareDataDaoImpl implements CompareDataDao {


	@Autowired
	private CompareDataRepository compareDataRepository;
	
	public CompareData findByOrgSysNoAndWarehouseNum(String orgSysNo,
			String warehouseNum) {
		// TODO Auto-generated method stub
		List<CompareData> list=compareDataRepository.findByOrgSysNoAndWarehouseNum(orgSysNo, warehouseNum);
		if(null!=list&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public CompareData findByWarehouseNum(String warehouseNum) {
		// TODO Auto-generated method stub
		List<CompareData> list=compareDataRepository.findByWarehouseNum(warehouseNum);
		if(null!=list&&list.size()>0){
			return list.get(0);
		}
		return null;
	}


	public void save(CompareData compareData) {
		compareDataRepository.save(compareData);
	}

	public void delete(CompareData compareData) {
		compareDataRepository.delete(compareData);
	}

	public CompareData findOne(String id) {
		// TODO Auto-generated method stub
		return compareDataRepository.findOne(id);
	}

	public CompareData findByWarehouseNumAndOrgSysNo(String warehouseNum,
			String orgSysNo) {
		// TODO Auto-generated method stub
		return compareDataRepository.findByWarehouseNumAndOrgSysNo(warehouseNum, orgSysNo);
	}
	public CompareData findByOrgSysNoAndWarehouseName(String orgSysNo,
			String warehouseName) {
		// TODO Auto-generated method stub
		List<CompareData> list=compareDataRepository.findByOrgSysNoAndWarehouseName(orgSysNo,warehouseName);
		if(null!=list&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
