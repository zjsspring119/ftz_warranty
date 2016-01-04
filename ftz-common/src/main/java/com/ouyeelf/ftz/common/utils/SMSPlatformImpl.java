package com.ouyeelf.ftz.common.utils;

import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * SMS platform interface
 * @author ethan du
 *
 */
public class SMSPlatformImpl {
	//短信平台地址
	Map lgsBaols = ReadPropertiesFile.getProperties();
	protected final static Log logger = LogFactory.getLog(SMSPlatformImpl.class);
	private String sms_address = (String) lgsBaols.get("SMS_ADDRESS");//获取短信平台地址
	private String sms_address_url = (String) lgsBaols.get("SMS_ADDRESS_URL");//获取短信平台地址
	/**
	 *	Java Singleton Pattern
	 */
	private static SMSPlatformImpl instance = null;  
	   
    public static SMSPlatformImpl getInstance() {  
        if (instance == null) {                             
            instance = new SMSPlatformImpl();         
        }  
        return instance;  
    }  
    /**
     * 
     * @param mobcode (手机号码)
     * @param content (短信内容包括：业务单据,执行时间等信息拼接的字符串)
     * @return String执行结果
     * @throws Exception
     */
	public String sendSMS(String mobcode,String content){
		
		try {
			Service service = new Service();
			Call call = (Call)service.createCall();
			/**
			 *  invoke webMethods RPC processor (RPC)
			 *  use default namesapce
			 */
			call.setTargetEndpointAddress(sms_address); // ok
			call.setOperationName(new QName(sms_address_url, "SMSService")); // universal namespace
			
			call.addParameter( "mobcode", XMLType.XSD_STRING, ParameterMode.IN );
			call.addParameter( "content", XMLType.XSD_STRING, ParameterMode.IN );
			call.addParameter( "appid", XMLType.XSD_STRING, ParameterMode.IN );
			call.addParameter( "field1", XMLType.XSD_STRING, ParameterMode.IN );
			call.addParameter( "field2", XMLType.XSD_STRING, ParameterMode.IN );
			call.setReturnType(XMLType.XSD_STRING);
			Object obj = call.invoke(new Object[] {mobcode, content,"OYZM","",""});
			logger.info("来自短信平台返回结果："+obj);//0-成功
			return (String)obj;
		} catch (Exception e) {
			e.getStackTrace();
			return "2";//异常返回结果
		}
	}
}
