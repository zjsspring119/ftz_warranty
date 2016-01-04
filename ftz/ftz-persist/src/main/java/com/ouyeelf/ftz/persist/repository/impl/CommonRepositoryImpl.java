package com.ouyeelf.ftz.persist.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ouyeelf.ftz.persist.repository.CommonResourceRepository;

@Repository
public class CommonRepositoryImpl<T> implements CommonResourceRepository<T> {

	@Autowired
	private MongoTemplate mongoTemplate;


	public List<T> findResources(Query query,Class<T> entityClass) {
		return mongoTemplate.find(query , entityClass);
	}
	
	public long countResources(Query query,Class<T> entityClass) {
		//mongoTemplate.mapReduce(inputCollectionName, mapFunction, reduceFunction, entityClass)
		return mongoTemplate.count(query ,entityClass);
	}

//	public Resource findResDetail(String id) {
//		return mongoTemplate.findById(id, Resource.class);
//	}
//
//	public List<Resource> findResRecom(Query query) {
//		return mongoTemplate.find(query, Resource.class);
//	}
//	
//	public Map<String, Double> statResource(DBObject match, DBObject group) {
//		DBCollection dc = mongoTemplate.getDb().getCollection("Resource");
//		AggregationOutput output = dc.aggregate(match,group);
//		Map<String, Double> reslut = new HashMap<String, Double>();
//		for(DBObject obj:output.results())
//        {
//             BasicDBObject obj2 = (BasicDBObject)obj;
//             reslut.put("sumSl2",obj2.getDouble("sumSl2"));
//             reslut.put("minDj3",obj2.getDouble("minDj3"));
//        }
//		return reslut;
//	}

}
