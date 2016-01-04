package com.ouyeelf.ftz.persist.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ouyeelf.ftz.common.utils.StringUtil;
import com.ouyeelf.ftz.model.resource.FtzWarrantyLogBean;
import com.ouyeelf.ftz.model.resource.query.FtzWarrantyLogQueryBean;
import com.ouyeelf.ftz.persist.dao.BaseDao;
import com.ouyeelf.ftz.persist.dao.FtzWarrantyLogBeanDao;
import com.ouyeelf.ftz.persist.domain.NpageImpl;
import com.ouyeelf.ftz.persist.repository.CommonResourceRepository;

public class FtzWarrantyLogBeanDaoImp extends BaseDao implements FtzWarrantyLogBeanDao {
	
	
	@Autowired
	private CommonResourceRepository<FtzWarrantyLogBean> commonResourceRepository;
	
    /**
     * 1.拼接查询条件
     * 2.拼接分页参数
     */
	public Page<FtzWarrantyLogBean> findAll(FtzWarrantyLogQueryBean ftzWarrantyLogQueryBean,
			Pageable pageable) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		Query query =makeFtzWarrantyLogQuery(ftzWarrantyLogQueryBean);
		long count = commonResourceRepository.countResources(query,FtzWarrantyLogBean.class);
		query=this.addPageableQuery(query, pageable);
		List<FtzWarrantyLogBean> ftzWarrantyLogBeanList=commonResourceRepository.findResources(query, FtzWarrantyLogBean.class);
		long endTime = System.currentTimeMillis();
		Page<FtzWarrantyLogBean> FtzWarrantyLogBeanPage = new NpageImpl<FtzWarrantyLogBean>(
				ftzWarrantyLogBeanList, pageable, count, endTime - startTime);
		
		return FtzWarrantyLogBeanPage;
	}

	
	
	/**
	 * 拼接动态查询条件
	 * @param warrantyQueryBean
	 * @return
	 */
	private static Query makeFtzWarrantyLogQuery(FtzWarrantyLogQueryBean ftzWarrantyLogQueryBean) {
		Query query = new Query();
		if (ftzWarrantyLogQueryBean == null) {
			return query;
		}
		//单个仓单号或多个用逗号分开的仓单号查询
		if(!StringUtil.isEmpty(ftzWarrantyLogQueryBean.getWarrantyNo())){
			List<String> warrnatyList=Arrays.asList(ftzWarrantyLogQueryBean.getWarrantyNo().split(","));
			query.addCriteria(Criteria.where("warrantyNo").in(warrnatyList));
		}
		query.with(new Sort(Direction.DESC, "createTime"));
		return query;
	}

	
}
