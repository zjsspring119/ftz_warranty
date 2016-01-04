package com.ouyeelf.ftz.rsdb.imp.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskPool extends ThreadPoolExecutor {

	public TaskPool(int corePoolSize, int maximumPoolSize, long keepAliveTime,
			int queueSize) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>(queueSize), Executors
						.defaultThreadFactory(), new DiscardPolicy() {
					public void rejectedExecution(Runnable r,
							ThreadPoolExecutor e) {
						ITask task = (ITask) r;
						task.cancel();
					}
				});
	}
}
