package com.ouyeelf.ftz.persist.dao;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;

public abstract class BaseDao {

	
	/**
	 * 拼接翻頁條件
	 * 
	 * @param query
	 * @param pageable
	 * @param count
	 */
	protected  Query addPageableQuery(Query query, Pageable pageable) {
		if(null==pageable){
			pageable=new PageRequest(0, 10);
		}
		int size = pageable.getPageSize(); // 显示数量
		int offset = pageable.getOffset(); // 偏移量
			query.skip(offset);
			query.limit(size);
		return query;
	}
}
