package com.ouyeelf.ftz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.resource.NStoreRecordBean;
import com.ouyeelf.ftz.model.resource.query.NStoreRecordQueryBean;
import com.ouyeelf.ftz.persist.dao.NStoreRecordBeanDao;
import com.ouyeelf.ftz.service.NStoreRecordBeanService;

public class NStoreRecordBeanServiceImpl implements NStoreRecordBeanService {

	@Autowired
	private NStoreRecordBeanDao nStoreRecordBeanDao;
	
	public Page<NStoreRecordBean> findAll(
			NStoreRecordQueryBean nstoreRecordQueryBean, Pageable pageable) {
		// TODO Auto-generated method stub
		return nStoreRecordBeanDao.findAll(nstoreRecordQueryBean, pageable);
	}

}
