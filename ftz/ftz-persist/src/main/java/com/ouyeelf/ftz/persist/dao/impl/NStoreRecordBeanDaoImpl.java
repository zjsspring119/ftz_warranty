package com.ouyeelf.ftz.persist.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ouyeelf.ftz.common.utils.StringUtil;
import com.ouyeelf.ftz.model.resource.NStoreRecordBean;
import com.ouyeelf.ftz.model.resource.query.NStoreRecordQueryBean;
import com.ouyeelf.ftz.persist.dao.BaseDao;
import com.ouyeelf.ftz.persist.dao.NStoreRecordBeanDao;
import com.ouyeelf.ftz.persist.domain.NpageImpl;
import com.ouyeelf.ftz.persist.repository.CommonResourceRepository;

public class NStoreRecordBeanDaoImpl extends BaseDao implements NStoreRecordBeanDao {

	@Autowired
	private CommonResourceRepository<NStoreRecordBean> commonResourceRepository;
	
	public Page<NStoreRecordBean> findAll(
			NStoreRecordQueryBean nStoreRecordQueryBean, Pageable pageable) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		Query query =makeQuery(nStoreRecordQueryBean);
		long count = commonResourceRepository.countResources(query,NStoreRecordBean.class);
		//query=this.addPageableQuery(query, pageable); 履历查询不需要分页
		List<NStoreRecordBean> nStoreRecordList=commonResourceRepository.findResources(query, NStoreRecordBean.class);
		long endTime = System.currentTimeMillis();
		Page<NStoreRecordBean> nStoreRecordPage = new NpageImpl<NStoreRecordBean>(
				nStoreRecordList, pageable, count, endTime - startTime);
		return nStoreRecordPage;
	}

	
	/**
	 * 拼接动态查询条件
	 * @param warrantyQueryBean
	 * @return
	 */
	private  Query makeQuery(NStoreRecordQueryBean nStoreRecordQueryBean) {
		Query query = new Query();
		if (nStoreRecordQueryBean == null) {
			return query;
		}
		if(!StringUtil.isEmpty(nStoreRecordQueryBean.getStoreNo())){//仓单号
			query.addCriteria(Criteria.where("storeNo").is(nStoreRecordQueryBean.getStoreNo()));
		}
		//query.with(new Sort(Direction.ASC, "generateDate"));
		query.with(new Sort(Direction.DESC, "generateDate"));
		return query;
	}

	
}
