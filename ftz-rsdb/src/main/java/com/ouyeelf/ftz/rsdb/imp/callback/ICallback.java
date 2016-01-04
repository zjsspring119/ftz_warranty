package com.ouyeelf.ftz.rsdb.imp.callback;

import java.util.List;


public interface ICallback{
	//flag :是否都处理完成   COMPLETE处理完成  RUNNING处理中
	public void result(String[] unsuccessfulIds, String[] successfulIds,List<String> unList, String batch,long startTIme,long endTime);
	
}
