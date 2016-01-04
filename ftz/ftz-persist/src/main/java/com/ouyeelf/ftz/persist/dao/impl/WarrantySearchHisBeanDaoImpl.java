package com.ouyeelf.ftz.persist.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ouyeelf.ftz.common.utils.StringUtil;
import com.ouyeelf.ftz.model.resource.WarrantySearchHisBean;
import com.ouyeelf.ftz.model.resource.query.WarrantySearchHisQuery;
import com.ouyeelf.ftz.persist.dao.BaseDao;
import com.ouyeelf.ftz.persist.dao.WarrantySearchHisBeanDao;
import com.ouyeelf.ftz.persist.domain.NpageImpl;
import com.ouyeelf.ftz.persist.repository.CommonResourceRepository;

public class WarrantySearchHisBeanDaoImpl extends BaseDao implements WarrantySearchHisBeanDao {

	@Autowired
	private CommonResourceRepository<WarrantySearchHisBean> commonResourceRepository;
	
	public Page<WarrantySearchHisBean> findAll(WarrantySearchHisQuery hisQuery,
			Pageable pageable) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		Query query =makeQuery(hisQuery);
		long count = commonResourceRepository.countResources(query,WarrantySearchHisBean.class);
		query=this.addPageableQuery(query, pageable);
		List<WarrantySearchHisBean> warrantySearchHisList=commonResourceRepository.findResources(query, WarrantySearchHisBean.class);
		long endTime = System.currentTimeMillis();
		Page<WarrantySearchHisBean> warrantySearchHisPage = new NpageImpl<WarrantySearchHisBean>(
				warrantySearchHisList, pageable, count, endTime - startTime);
		return warrantySearchHisPage;
	}

	

	/**
	 * 拼接动态查询条件
	 * @param warrantyQueryBean
	 * @return
	 */
	private  Query makeQuery(WarrantySearchHisQuery warrantySearchHisQuery) {
		Query query = new Query();
		if (warrantySearchHisQuery == null) {
			return query;
		}
		
		if(!StringUtil.isEmpty(warrantySearchHisQuery.getSearcher())){//查询人代码
			query.addCriteria(Criteria.where("searcher").is(warrantySearchHisQuery.getSearcher()));
		}
		//单个仓单号
		if(!StringUtil.isEmpty(warrantySearchHisQuery.getWarrantyNo())){
			Pattern pattern = Pattern.compile("^" + warrantySearchHisQuery.getWarrantyNo() + "",Pattern.CASE_INSENSITIVE);
			query.addCriteria(Criteria.where("warrantyNo").regex(pattern));
		}
		//品种查询，多个品种以逗号分开
		if(!StringUtil.isEmpty(warrantySearchHisQuery.getPrdCataName())){
			
			List<String> pmClassList=Arrays.asList(warrantySearchHisQuery.getPrdCataName().split(","));
			if(pmClassList.size()>1){//多个in
				query.addCriteria(Criteria.where("prdCataName").in(pmClassList));
				
			}else{//一个like
				Pattern pattern = Pattern.compile(".*" + warrantySearchHisQuery.getPrdCataName() + ".*$", Pattern.CASE_INSENSITIVE);
				query.addCriteria(Criteria.where("prdCataName").regex(pattern));
			}
		}
		//状态查询
		if(!StringUtil.isEmpty(warrantySearchHisQuery.getWarrantyStatus())){
			query.addCriteria(Criteria.where("warrantyStatus").is(warrantySearchHisQuery.getWarrantyStatus()));
		}
		
		//仓库名称 支持模糊查询
		if(!StringUtil.isEmpty(warrantySearchHisQuery.getWarehouseName())){
			Pattern pattern = Pattern.compile(".*" + warrantySearchHisQuery.getWarehouseName() + ".*$", Pattern.CASE_INSENSITIVE);
			query.addCriteria(new Criteria("warehouseName").regex(pattern));
		}
		//查询时间2014/12/25~2015/02/28
		if(!StringUtil.isEmpty(warrantySearchHisQuery.getSearchTime())){
			String [] time =	warrantySearchHisQuery.getSearchTime().replace("/", "-").split("~");
			query.addCriteria(new Criteria("searchTime").gte(time[0]+" 00:00:00").lte(time[1]+" 23:59:59"));
		}
		//关注标记
				if(!StringUtil.isEmpty(warrantySearchHisQuery.getFavoritesFlag())){
					if("1".equals(warrantySearchHisQuery.getFavoritesFlag())){//查询关注
						query.addCriteria(Criteria.where("favorites").is(warrantySearchHisQuery.getFavoritesCode()));
					}else if("0".equals(warrantySearchHisQuery.getFavoritesFlag())){// 查询不关注
						query.addCriteria(Criteria.where("favorites").nin(warrantySearchHisQuery.getFavoritesCode()));
					}
				}
		
		//排序
		Map<String,String> sortMap=warrantySearchHisQuery.getSortMap();
		if(null!=sortMap&&sortMap.size()>0){
			List<Order> orders=new ArrayList<Order>();
			Set<String> keys = warrantySearchHisQuery.getSortMap().keySet( );  
			if(keys != null) {  
			Iterator<String> iterator = keys.iterator( );  
			while(iterator.hasNext( )) {  
			String key = iterator.next( );  
			String value = sortMap.get(key);  
				if (value.equalsIgnoreCase("desc")) {
					orders.add(new Order(Direction.DESC, key))  ;
				} else {
					orders.add(new Order(Direction.ASC, key))  ;
				}
			 }
			}  
			if(orders.size()>0){
			query.with(new Sort(orders));
			}
		}
		return query;
	}
}
