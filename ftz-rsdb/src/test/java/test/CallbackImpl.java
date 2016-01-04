package test;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ouyeelf.ftz.rsdb.imp.callback.ICallback;

public class CallbackImpl implements ICallback {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void result(String[] unsuccessful, String[] success, List<String> unList,String batch,long startTime,long endTime) {
		// TODO Auto-generated method stub
		logger.info("unsuccessful:{}",unsuccessful.length);
		logger.info("successful:{}",success.length);
		logger.info("batch:{}",batch);
	}

}
