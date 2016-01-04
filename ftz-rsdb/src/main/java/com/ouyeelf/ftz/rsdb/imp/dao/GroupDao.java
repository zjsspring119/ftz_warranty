package com.ouyeelf.ftz.rsdb.imp.dao;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.ouyeelf.ftz.rsdb.imp.utils.MongoUtil;

public class GroupDao {
	
	private static  DB db = MongoUtil.getDB();
	private static DBCollection dc = db.getCollection("Resource");
	private static DBCollection dlc = db.getCollection("GroupDl");
	
	/**
	 * 种类分组
	 * @return
	 */
	public CommandResult groupByDl(){
		DBObject groupDBObj = new BasicDBObject("$group",new BasicDBObject("_id","$dl"));
		AggregationOutput outPut = dc.aggregate(groupDBObj);
		CommandResult cr = outPut.getCommandResult();
		return cr;
	}
	
	/**
	 * 添加新的类别
	 * 已有的更新
	 * 没有的添加
	 * @param groupDl
	 * @return
	 */
	public boolean saveDL(String _id){
		
		DBObject obj = new BasicDBObject();
		obj.put("_id", _id);
		WriteResult ws = dlc.save(obj);
		return result(ws);
	}
	
	/**
	 * 移除表中多余数据
	 * @param dls
	 * @return
	 */
	public boolean deleteDl(String[] dls){
		DBObject obj = new BasicDBObject();
		obj.put("_id", new BasicDBObject("$nin",dls));
		WriteResult ws = dlc.remove(obj);
		return result(ws);
	}
	
	public  boolean result(WriteResult ws){
		CommandResult cmrs = ws.getLastError();
		return cmrs.ok();
	}

	
}
