package com.ouyeelf.ftz.persist.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.resource.NStoreRecordBean;
import com.ouyeelf.ftz.model.resource.query.NStoreRecordQueryBean;

public interface NStoreRecordBeanDao {

	public Page<NStoreRecordBean> findAll(NStoreRecordQueryBean nStoreRecordQueryBean,
			Pageable pageable);
	
	
}
