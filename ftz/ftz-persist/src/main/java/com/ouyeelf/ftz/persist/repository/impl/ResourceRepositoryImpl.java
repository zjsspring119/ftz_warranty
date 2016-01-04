package com.ouyeelf.ftz.persist.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ouyeelf.ftz.model.resource.WarrantyBean;
import com.ouyeelf.ftz.persist.repository.ResourceRepository;

@Repository
public class ResourceRepositoryImpl implements ResourceRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<WarrantyBean> findResources(Query query) {
		return mongoTemplate.find(query , WarrantyBean.class);
	}
	
	public long countResources(Query query) {
		return mongoTemplate.count(query , WarrantyBean.class);
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
