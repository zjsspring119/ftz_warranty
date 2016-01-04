package com.ouyeelf.ftz.rsdb.imp.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ouyeelf.ftz.common.constant.Operation;
import com.ouyeelf.ftz.rsdb.imp.buffer.INByteBuffer;
import com.ouyeelf.ftz.rsdb.imp.callback.ICallback;
import com.ouyeelf.ftz.rsdb.imp.dao.CommonMongoDao;

public class ImpMain {
	
	private static ExecutorService service = Executors.newCachedThreadPool();
	
	public static <T> void synchro(INByteBuffer<T> ibb,Operation operation,ICallback callback, String batch,String tableName){
		NSynchroImport<T> si = new NSynchroImport<T>(ibb, operation, callback, batch,tableName);
		service.submit(si);
	}
	
	//{warrantyNo:"",Dcode:"D0001",operateFlag:1}
	public static void synUpdateWareDate(String jsonStr){
		CommonMongoDao commonMongoDao=new CommonMongoDao();
		commonMongoDao.updateWarrantyBeanByFavorites(jsonStr);
	} 
	
	
}
