package com.ouyeelf.ftz.common.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import com.waxberry.log.ILogger;
import com.waxberry.log.LoggerFactory;

/**
 * **************************************************
 *@Copyrigth(c) by baosight Co., Ltd
 *@Create Date 2015-3-19 
 *@author zjs
 *@File Name：
 *@Last version：1.0
 *@Function: 接口日志保存工具类
 *@Change Log:
 **************************************************
 */
public class IfaceLogUtil {
	protected final ILogger log = getLogger(this);
	private  Map map=PropertiesUtil.read("lgs_ftz");
	private  static IfaceLogUtil ifaceLogUtil=null;
	
    public static IfaceLogUtil getInstance() {  
        if (ifaceLogUtil == null) {                             
        	ifaceLogUtil = new IfaceLogUtil();         
        }  
        return ifaceLogUtil;  
    }  
    private  IfaceLogUtil(){
    	
    }
    
    /**
     * 保存接口日志
     * @param ifaceName 接口名称
     * @param methodName 接口方法名称
     * @param jsonStr   接口数据
     */
    public void saveIfaceLog(String ifaceName,String methodName,String batchNo,String jsonStr){
    	if(StringUtil.isEmpty(ifaceName) || StringUtil.isEmpty(jsonStr))
    		return;
    	if(null==map) 
    		return;
    	String savePath=String.valueOf(map.get("IFACE_LOG_PATH"))+ifaceName+"/"+methodName+"/";
    	//String savePath="d:/tmp/iface/"+ifaceName+"/"+methodName+"/";
    	log.info("接口数据日志保存路径==="+savePath);
		File file1 = new File(savePath);//
		 if(!file1.exists()){
			 file1.mkdirs();
		 }
		FileWriter  fos = null;
		try{
			String logName=DateUtil.nowDate("yyyy-MM-dd")+".txt";
			String fileSavePath = savePath+"/"+logName;
			File file = new File(fileSavePath);
			fos = new FileWriter(file,true);  //设置追加
			fos.write("\r\n"+DateUtil.nowDate("HH:mm:ss")+"--"+batchNo+":\r\n");//时间--批次号
			fos.write(jsonStr);			
		}catch(IOException e) {
			throw new RuntimeException("写接口日志文档失败!", e);
		}finally {
		  try {
			  fos.flush();
			  fos.close();
			  } catch (IOException ex) {
			   ex.printStackTrace();
			  }
		}
    }
    public ILogger getLogger(Object classObject) {
		return LoggerFactory.getLogger(classObject.getClass());
	}
    
}
