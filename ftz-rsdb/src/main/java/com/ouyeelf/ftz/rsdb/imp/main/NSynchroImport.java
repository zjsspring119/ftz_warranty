package com.ouyeelf.ftz.rsdb.imp.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ouyeelf.ftz.common.constant.Operation;
import com.ouyeelf.ftz.rsdb.imp.buffer.IByteBuffer;
import com.ouyeelf.ftz.rsdb.imp.buffer.INByteBuffer;
import com.ouyeelf.ftz.rsdb.imp.callback.ICallback;
import com.ouyeelf.ftz.rsdb.imp.event.GroupDlEvent;
import com.ouyeelf.ftz.rsdb.imp.listener.GroupDlListener;
import com.ouyeelf.ftz.rsdb.imp.threadpool.TaskPool;

public class NSynchroImport<T> extends Thread {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private INByteBuffer<T> rbb;

	private ExecutorService service;

	private Operation operation;

	private ICallback callback;

	private List<String> unsuccessful = new ArrayList<String>();
	
	public static final int DEFAULT_INIT_THREAD=4;
	public static final long DEFAULT_KEEP_ALIVE_TIME=300;
	public static final int DEFAULT_QUEUE_SIZE=500;
	private List<String> successful = new ArrayList<String>();
	private String batch;
	private String tableName;
	private GroupDlListener gdl;
	private long startTime;

	public NSynchroImport(INByteBuffer<T> rbb, Operation operation,ICallback callback,String batch,String tableName ) {

		this.rbb = rbb;
		this.operation = operation;
		this.callback = callback;
		this.gdl = GroupDlListener.getInstance();
		this.batch = batch;
		this.tableName=tableName;
	}

	public void run() {
		logger.info("Start {} resource data: {} ", operation, Thread
				.currentThread().getName());
		startTime=System.currentTimeMillis();
		logger.info("startTime:"+startTime);
		IByteBuffer<T>[] ibb = rbb.getUsedBuffer();
		// service = Executors.newCachedThreadPool();
		int DEFAULT_MAX_THREAD=Runtime.getRuntime().availableProcessors();
		logger.info("DEFAULT_MAX_THREAD:"+DEFAULT_MAX_THREAD);
		service = new TaskPool(DEFAULT_INIT_THREAD, DEFAULT_MAX_THREAD, DEFAULT_KEEP_ALIVE_TIME, DEFAULT_QUEUE_SIZE);
		for (IByteBuffer<T> ib : ibb) {
			if("warrantyBean".equals(tableName)){
				service.submit(new SynchroImport<T>(ib, operation, this));
			}else if("nStoreRecordBean".equals(tableName)){
				service.submit(new SynImportNStoreRecord<T>(ib, operation, this));
			}else if("warrantySearchHisBean".equals(tableName)){
				service.submit(new SynImportWarrantySearchHis<T>(ib, operation, this));
			}else if("ftzWarrantyLogBean".equals(tableName)){
				service.submit(new SynImportFtzWarrantyLog<T>(ib, operation, this));
			}
			
		}
		service.shutdown();
		checkTerminated();
	}

	protected void callBack(List<String> subUnIds, List<String> subIds) {
		unsuccessful.addAll(subUnIds);
		successful.addAll(subIds);
	}

	protected void activateMyEvent() {
		GroupDlEvent e = new GroupDlEvent(this);
		gdl.EventActivated(e);
	}

	private void checkTerminated() {
		while (!service.isTerminated()) {
		}
		String[] uncuccess = unsuccessful.toArray(new String[unsuccessful
				.size()]);
		String[] cuccess = successful.toArray(new String[successful.size()]);
		long endTime = System.currentTimeMillis();
		callback.result(uncuccess,cuccess,successful,tableName,startTime,endTime);
		logger.info("End {} resource data: {}", operation, Thread
				.currentThread().getName());
		//log
		this.activateMyEvent();
	}

	

}
