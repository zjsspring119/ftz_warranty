package com.ouyeelf.ftz.persist.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.ouyeelf.ftz.model.resource.WarrantyBean;


public interface ResourceRepository {
	
	public List<WarrantyBean> findResources(Query query);
	
	public long countResources(Query query);
	
//	public Resource findResDetail(String id);
//	
//	public List<Resource> findResRecom(Query query);
//	
//	public Map<String, Double> statResource(DBObject match, DBObject group);
	
}
