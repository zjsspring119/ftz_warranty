package com.ouyeelf.ftz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.resource.NStoreRecordBean;
import com.ouyeelf.ftz.model.resource.query.NStoreRecordQueryBean;

public interface NStoreRecordBeanService {

	
	public Page<NStoreRecordBean> findAll(NStoreRecordQueryBean nstoreRecordQueryBean ,Pageable pageable);
}
