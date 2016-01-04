package com.ouyeelf.ftz.rsdb.imp.dao;

import java.util.List;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.ouyeelf.ftz.model.mdbean.FtzWarrantyLogBean;
import com.ouyeelf.ftz.rsdb.imp.domain.change.FtzWarrantyLogBeanChange;
import com.ouyeelf.ftz.rsdb.imp.exception.ResourceException;
import com.ouyeelf.ftz.rsdb.imp.utils.MongoUtil;

/**
 * The Class ResourceDao.
 */
public class CommonMongoDao{

	/** The db. */
	private static DB db = MongoUtil.getDB();

	/** The dc. */
	private static DBCollection dc = db.getCollection("warrantyBean");
	private static DBCollection wsh = db.getCollection("warrantySearchHisBean");
	
	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public boolean updateWarrantyBeanByFavorites(String jsonStr) {
		boolean result=false;
		logger.info("jsonStr:"+jsonStr.toString());
		JSONObject json=JSONObject.fromObject(jsonStr);
		String  operateFlag=json.getString("operateFlag");
		String Dcode=json.getString("Dcode");
		BasicDBObject query = new BasicDBObject();
		query.put("warrantyNo", json.getString("warrantyNo"));
		DBObject warrantyBean=dc.findOne(query);
		//同步仓单关注
		if(null!=warrantyBean){
			if(warrantyBean.containsKey("favorites")){
				BasicDBList  list= (BasicDBList) warrantyBean.get("favorites") ;
				if("1".equals(operateFlag)){//添加
					if(!list.contains(Dcode)){
						list.add(Dcode);
					}
			    }else{//删除
		    	 if(list.contains(Dcode)){
		                list.remove(Dcode);
		            }
			    }
				warrantyBean.put("favorites", list);
			 }else if("1".equals(operateFlag)){
				 warrantyBean.put("favorites", new String[]{Dcode}); 
			 }
			WriteResult ws = dc.save(warrantyBean);
			result=result(ws);
		}
		//同步到查询历史关注
		DBObject warrantySearchBean=wsh.findOne(query);
		if(null!=warrantySearchBean){
			if(warrantySearchBean.containsKey("favorites")){
				BasicDBList  list= (BasicDBList) warrantySearchBean.get("favorites") ;
				if("1".equals(operateFlag)){//添加
					if(!list.contains(Dcode)){
						list.add(Dcode);
					}
			    }else{//删除
		    	 if(list.contains(Dcode)){
		                list.remove(Dcode);
		            }
			    }
				warrantySearchBean.put("favorites", list);
			 }else if("1".equals(operateFlag)){
				 warrantySearchBean.put("favorites", new String[]{Dcode}); 
			 }
			wsh.save(warrantySearchBean);
		}
		return result;
	}

	/**
	 * Adds the resource all.
	 *
	 * @param warranty the warranty
	 * @return true, if successful
	 */
	public boolean addResourceAll(List<FtzWarrantyLogBean> ftzWarrantyLogBean) {
		DBObject[] dbos = new DBObject[ftzWarrantyLogBean.size()];

		for (int i = 0, size = ftzWarrantyLogBean.size(); i < size; i++) {
			
			dbos[i] = FtzWarrantyLogBeanChange.change(ftzWarrantyLogBean.get(i));
		}

		WriteResult ws = dc.insert(dbos);

		return result(ws);
	}


	
	/**
	 * Result.
	 *
	 * @param ws the ws
	 * @return true, if successful
	 */
	public boolean result(WriteResult ws) {
		CommandResult cmrs = ws.getLastError();

		return cmrs.ok();
	}

	/**
	 * Start.
	 */
	public void start() {
		db.requestStart();
	}

	/**
	 * Done.
	 */
	public void done() {
		db.requestDone();
	}

	/**
	 * Drop collection.
	 *
	 * @param collectionName the collection name
	 */
	public void dropCollection(String collectionName) {
		if ((collectionName == null) || (collectionName.length() == 0)) {
			if (logger.isInfoEnabled()) {
				logger.info("dropCollection fail:collectionName can not be empty");
			}

			return;
		}
		db.getCollection(collectionName).drop();
	}

	/**
	 * Creates the collection.
	 *
	 * @param collectionName the collection name
	 */
	public void createCollection(String collectionName) {
		if ((collectionName == null) || (collectionName.length() == 0)) {
			if (logger.isInfoEnabled()) {
				logger.info("createCollection can not be empty");
			}

			return;
		}
		boolean exists = db.collectionExists(collectionName);
		if (!exists) {
			DBObject options = new BasicDBObject();
			options.put("capped", false);
			db.createCollection(collectionName, options);
		} else {
			if (logger.isInfoEnabled()) {
				logger.info("collectionName:" + collectionName
						+ " Already Exist");
			}
		}
	}

	/**
	 * Removes the collection.
	 *
	 * @param collectionName the collection name
	 */
	public void removeCollection(String collectionName) {
		if ((collectionName == null) || (collectionName.length() == 0)) {
			if (logger.isInfoEnabled()) {
				logger.info("removeCollection fail:collectionName can not be empty");
			}

			return;
		}

		BasicDBObject query = new BasicDBObject();
		query.put("_id", new BasicDBObject("$ne", null));
		db.getCollection(collectionName).remove(query);
	}

	/**
	 * Ensure index.
	 *
	 * @param collectionName the collection name
	 * @param unique the unique
	 * @param indexInfos the index infos
	 * @throws ResourceException the resource exception
	 */
	public void ensureIndex(final String collectionName, boolean unique,
			final IndexInfo... indexInfos) throws ResourceException {
		if (isEmpty(collectionName)
				|| ((indexInfos == null) || (indexInfos.length == 0))) {
			if (logger.isInfoEnabled()) {
				logger.info("ensureIndex fail:collectionName and indexName can not be empty");
			}

			return;
		}

		DBCollection coll = db.getCollection(collectionName);
		DBObject index = new BasicDBObject();
		for (IndexInfo indexInfo : indexInfos) {
			int sort = indexInfo.getSort();
			if ((sort != -1) && (sort != 1)) {
				/** 默认升序 */
				sort = 1;
			}
			index.put(indexInfo.getName(), sort);
		}
		coll.ensureIndex(index, new BasicDBObject("unique", unique));
	}

	/**
	 * The Class IndexInfo.
	 */
	class IndexInfo {

		/** The name. */
		private String name;

		/** The sort. */
		private int sort;

		/**
		 * Instantiates a new index info.
		 *
		 * @param name the name
		 * @param sort the sort
		 */
		public IndexInfo(String name, int sort) {
			this.name = name;
			this.sort = sort;
		}

		/**
		 * Gets the name.
		 *
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * Sets the name.
		 *
		 * @param name the new name
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * Gets the sort.
		 *
		 * @return the sort
		 */
		public int getSort() {
			return sort;
		}

		/**
		 * Sets the sort.
		 *
		 * @param sort the new sort
		 */
		public void setSort(int sort) {
			this.sort = sort;
		}

	}

	/**
	 * Checks if is empty.
	 *
	 * @param str the str
	 * @return true, if is empty
	 */
	public static boolean isEmpty(String str) {
		return ((str == null) || (str.length() == 0));
	}

	/**
	 * Ensure index.
	 *
	 * @param collectionName the collection name
	 * @param indexName the index name
	 * @throws ResourceException the resource exception
	 */
	public void ensureIndex(final String collectionName, final String indexName)
			throws ResourceException {
		ensureIndex(collectionName, indexName, 1, false);
	}

	/**
	 * Ensure index.
	 *
	 * @param collectionName the collection name
	 * @param indexName the index name
	 * @param sort the sort
	 * @param unique the unique
	 * @throws ResourceException the resource exception
	 */
	public void ensureIndex(final String collectionName,
			final String indexName, final int sort, boolean unique)
			throws ResourceException {
		IndexInfo indexInfo = new IndexInfo(indexName, sort);
		ensureIndex(collectionName, unique, indexInfo);
	}

	/**
	 * Execute map reduce.
	 *
	 * @throws ResourceException the resource exception
	 */
	public void executeMapReduce() throws ResourceException {
		IMongodbMapReduceService mongodbMapReduceService = new DefaultMongodbMapReduceService(
				db);
		mongodbMapReduceService.mapReduce();
	}
}
