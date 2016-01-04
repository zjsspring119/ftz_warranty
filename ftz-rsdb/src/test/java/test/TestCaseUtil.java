package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.ouyeelf.ftz.common.constant.Operation;
import com.ouyeelf.ftz.model.mdbean.WarrantyBean;
import com.ouyeelf.ftz.rsdb.imp.buffer.IByteBufferFactory;
import com.ouyeelf.ftz.rsdb.imp.buffer.INByteBuffer;
import com.ouyeelf.ftz.rsdb.imp.callback.ICallback;
import com.ouyeelf.ftz.rsdb.imp.main.ImpMain;

public class TestCaseUtil {

	
	@Test
	public void testSynWarranty(){
		try {
			List<WarrantyBean> resList= CreatResource.getResource(1);
			INByteBuffer<WarrantyBean> bb = IByteBufferFactory.createNResourceByteBuffer(10*1024*1024);
			for(int i = 0; i < resList.size(); i++){
				WarrantyBean warranty = resList.get(i);
				bb.put(warranty);
			}
			ICallback cb = new CallbackImpl();
			//获得批次号
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			Date now = new Date();
			String batch = sdf.format(now);
			System.out.println("push buffer start");
			ImpMain.synchro(bb, Operation.INSERT, cb, batch,"");
			System.out.println("push buffer end");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
