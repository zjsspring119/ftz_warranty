package com.ouyeelf.ftz.rsdb.imp.threadpool;

public interface ITask extends Runnable {
	void cancel();
}
