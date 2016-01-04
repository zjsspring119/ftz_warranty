package com.ouyeelf.ftz.service.warranty;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ouyeelf.ftz.persist.dao.warranty.FtzWarrantyLogDao;
import com.ouyeelf.ftz.persist.dao.warranty.WarrantyDao;
import com.ouyeelf.ftz.persist.dao.warranty.WarrantySearchHisDao;



@Service("warrantyCommonService")
public class WarrantyCommonService {

	@Autowired
	private WarrantyDao warrantyDao;
	
	@Autowired
	private FtzWarrantyLogDao ftzWarrantyLogDao;
	
	@Autowired
	private WarrantySearchHisDao warrantySearchHisDao;
	
	@Transactional
	public void updateIsSynchronize(String isSynchronize,List<String> warrantyNoList){
		warrantyDao.updateIsSynchronize(isSynchronize,warrantyNoList);
	}
	
	@Transactional
	public void updateIsSynchronizeByFtzWarrantyLog(String isSynchronize,List<String> idList){
		ftzWarrantyLogDao.updateIsSynchronize(isSynchronize,idList);
	}
	
	@Transactional
	public void updateIsSynchronizeByWarrantySearchHis(String isSynchronize,List<String> idList){
		warrantySearchHisDao.updateIsSynchronize(isSynchronize,idList);
	}
}
