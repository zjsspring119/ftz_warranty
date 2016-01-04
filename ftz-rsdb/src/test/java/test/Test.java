package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ouyeelf.ftz.common.constant.Operation;
import com.ouyeelf.ftz.model.mdbean.NStoreRecordBean;
import com.ouyeelf.ftz.model.mdbean.WarrantyBean;
import com.ouyeelf.ftz.model.mdbean.WarrantySearchHisBean;
import com.ouyeelf.ftz.rsdb.imp.buffer.IByteBufferFactory;
import com.ouyeelf.ftz.rsdb.imp.buffer.INByteBuffer;
import com.ouyeelf.ftz.rsdb.imp.callback.ICallback;
import com.ouyeelf.ftz.rsdb.imp.main.ImpMain;

public class Test {
	private static Logger logger = LoggerFactory.getLogger(Test.class);
	public static void main(String[] args) {
			//testRun();
		//testRunByNStoreRecord();
		testRunByWarrantySearchHis();
	}
		
	public static void testRun() {
			
			try {
				List<WarrantyBean> resList= CreatResource.getResource(30);
				INByteBuffer<WarrantyBean> bb = IByteBufferFactory.createNResourceByteBuffer(1*1024*1024);
			    for(int i = 0; i < resList.size(); i++){
			    	WarrantyBean warranty = resList.get(i);
			    	bb.put(warranty);
			    }
			    ICallback cb = new CallbackImpl();
			    //获得批次号
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
				Date now = new Date();
				String batch = sdf.format(now);
			    logger.info("push buffer start");
			    ImpMain.synchro(bb, Operation.INSERT, cb, batch,"warrantyBean");
			    logger.info("push buffer end");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public static void testRunByNStoreRecord() {
		
		try {
			List<NStoreRecordBean> resList= CreatResource.getResourceByNStoreRecordBean(30);
			INByteBuffer<NStoreRecordBean> bb = IByteBufferFactory.createNResourceByteBuffer(1*1024*1024);
		    for(int i = 0; i < resList.size(); i++){
		    	NStoreRecordBean nStoreRecordBean = resList.get(i);
		    	bb.put(nStoreRecordBean);
		    }
		    ICallback cb = new CallbackImpl();
		    //获得批次号
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			Date now = new Date();
			String batch = sdf.format(now);
		    logger.info("push buffer start");
		    ImpMain.synchro(bb, Operation.INSERT, cb, batch,"nStoreRecordBean");
		    logger.info("push buffer end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void testRunByWarrantySearchHis() {
		
		try {
			List<WarrantySearchHisBean> resList= CreatResource.getResourceByWarrantySearchHisBean(2);
			INByteBuffer<WarrantySearchHisBean> bb = IByteBufferFactory.createNResourceByteBuffer(1*1024*1024);
		    for(int i = 0; i < resList.size(); i++){
		    	WarrantySearchHisBean warrantySearchHisBean = resList.get(i);
		    	bb.put(warrantySearchHisBean);
		    }
		    ICallback cb = new CallbackImpl();
		    //获得批次号
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			Date now = new Date();
			String batch = sdf.format(now);
		    logger.info("push buffer start");
		    ImpMain.synchro(bb, Operation.INSERT, cb, batch,"warrantySearchHisBean");
		    logger.info("push buffer end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

