package com.ouyeelf.ftz.persist.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;


public interface CommonResourceRepository<T> {
	
	public  List<T> findResources(Query query ,Class<T> entityClass);
	
	public long countResources(Query query,Class<T> entityClass);
	
//	public Resource findResDetail(String id);
//	
//	public List<Resource> findResRecom(Query query);
//	
//	public Map<String, Double> statResource(DBObject match, DBObject group);
	
}
