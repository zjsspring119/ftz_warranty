package com.ouyeelf.ftz.common.utils;

import java.rmi.RemoteException;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import javax.xml.soap.Name;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.message.PrefixedQName;
import org.apache.axis.message.SOAPHeaderElement;

/**
 * **************************************************
 *@Copyrigth(c) by ftzWarranty Co., Ltd
 *@Create Date 2015-8-26 
 *@author zjs
 *@File Name：
 *@Last version：1.0
 *@Function:  webservice 工具类
 *@Change Log:
 **************************************************
 */
public class WsdlUtil {
	
	/**
	 *	Java Singleton Pattern
	 */
	private static WsdlUtil instance = null;  
	   
    public static WsdlUtil getInstance() {  
        if (instance == null) {                             
            instance = new WsdlUtil();         
        }  
        return instance;  
    }  

	public String wsClient(String url, String tns, String wsMethodName, String[] param, String[] xmltype, String[] mod,
			Object[] objS) {
		if (param.length > xmltype.length || xmltype.length != mod.length || objS.length != param.length) {
			return "error";
		}
		Service service = new Service();
		Call call = null;
		try {
			call = (Call) service.createCall();
		} catch (ServiceException e) {
			return "error";
		}
		call.setTargetEndpointAddress(url);
		call.setOperationName(new javax.xml.namespace.QName(tns, wsMethodName));// WSDL里面描述的接口名称
		call.setUseSOAPAction(true);
		call.setSOAPActionURI(tns + wsMethodName);
		call.setEncodingStyle(null);
		call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
		call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
		call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		for (int i = 0; i < xmltype.length; i++) {
			if (xmltype[i].length() > 1) {
				if ("in".equals(mod[i])) {
					call.addParameter(new javax.xml.namespace.QName(tns, param[i]), new javax.xml.namespace.QName(tns,
							xmltype[i]), javax.xml.rpc.ParameterMode.IN);// 接口的参数
				} else {
					call.setReturnType(new javax.xml.namespace.QName(tns, xmltype[i]));// 设置返回类型
				}
			} else if ("S".equals(xmltype[i].toUpperCase())) {
				if ("in".equals(mod[i])) {
					call.addParameter(new javax.xml.namespace.QName(tns, param[i]),
							org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);// 接口的参数
				} else {
					call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
				}
			} else if ("D".equals(xmltype[i].toUpperCase())) {
				if ("in".equals(mod[i])) {
					call.addParameter(new javax.xml.namespace.QName(tns, param[i]),
							org.apache.axis.encoding.XMLType.XSD_DOUBLE, javax.xml.rpc.ParameterMode.IN);// 接口的参数
				} else {
					call.setReturnType(org.apache.axis.encoding.XMLType.XSD_DOUBLE);// 设置返回类型
				}
			} else if ("C".equals(xmltype[i].toUpperCase())) {
				if ("in".equals(mod[i])) {
					call.addParameter(new javax.xml.namespace.QName(tns, param[i]),
							org.apache.axis.encoding.XMLType.XSD_DECIMAL, javax.xml.rpc.ParameterMode.IN);// 接口的参数
				} else {
					call.setReturnType(org.apache.axis.encoding.XMLType.XSD_DECIMAL);// 设置返回类型
				}
			} else if ("I".equals(xmltype[i].toUpperCase())) {
				if ("in".equals(mod[i])) {
					call.addParameter(new javax.xml.namespace.QName(tns, param[i]),
							org.apache.axis.encoding.XMLType.XSD_INT, javax.xml.rpc.ParameterMode.IN);// 接口的参数
				} else {
					call.setReturnType(org.apache.axis.encoding.XMLType.XSD_INT);// 设置返回类型
				}
			} else if ("L".equals(xmltype[i].toUpperCase())) {
				if ("in".equals(mod[i])) {
					call.addParameter(new javax.xml.namespace.QName(tns, param[i]),
							org.apache.axis.encoding.XMLType.XSD_LONG, javax.xml.rpc.ParameterMode.IN);// 接口的参数
				} else {
					call.setReturnType(org.apache.axis.encoding.XMLType.XSD_LONG);// 设置返回类型
				}
			} else if ("E".equals(xmltype[i].toUpperCase())) {
				if ("in".equals(mod[i])) {
					call.addParameter(new javax.xml.namespace.QName(tns, param[i]),
							org.apache.axis.encoding.XMLType.XSD_DATE, javax.xml.rpc.ParameterMode.IN);// 接口的参数
				} else {
					call.setReturnType(org.apache.axis.encoding.XMLType.XSD_DATE);// 设置返回类型
				}
			} else if ("O".equals(xmltype[i].toUpperCase())) {
				if ("in".equals(mod[i])) {
					call.addParameter(new javax.xml.namespace.QName(tns, param[i]),
							org.apache.axis.encoding.XMLType.XSD_DATE, javax.xml.rpc.ParameterMode.IN);// 接口的参数
				} else {
					call.setReturnType(org.apache.axis.encoding.XMLType.XSD_DATE);// 设置返回类型
				}
			} else if("OBJ".equals(xmltype[i].toUpperCase())){
				if ("in".equals(mod[i])) {
					call.addParameter(new javax.xml.namespace.QName(tns, param[i]),
							org.apache.axis.encoding.XMLType.XSD_DATE, javax.xml.rpc.ParameterMode.IN);// 接口的参数
				} else {

				}
			}
		}

		String result = "";
		try {
			result = (String) call.invoke(objS);
		} catch (RemoteException e) {
			e.printStackTrace();
			
			result = "error";
		}
		return result;
	}

	public String[] getXmlStr(String xmlStr) {
		if (xmlStr.indexOf("$") > 0) {
			return xmlStr.split("\\$");
		} else {
			String[] str = { xmlStr };
			return str;
		}
	}
	
	/**
	 * web service 接口调用
	 * @param obj				方法参数object数组
	 * @param operationName		方法名
	 * @param qName				webservice服务名
	 * @param endpoint			webservice地址
	 * @return					方法返回值
	 * @throws Exception
	 */
	public Object clientWS(Object[] obj, String operationName, String qName,String endpoint) throws Exception {
		Object result = "";
		Service service = new Service();
		Call call = (Call) service.createCall();
		QName qn = new QName(endpoint, qName);
		call.registerTypeMapping(Map.class, qn, new BeanSerializerFactory(Map.class, qn), new BeanDeserializerFactory(Map.class, qn));

		call.setOperationName(new QName(operationName));
		call.setTargetEndpointAddress(new java.net.URL(endpoint));
		result = call.invoke(obj);	
		return result;
	}
	
	
	/**
	 * UACP  client
	 * @param url UACP地址
	 * @param tns webservice地址（外部）
	 * @param wsMethodName  接口方法
	 * @param formId  发送方标识 
	 * @param toId  接收方标识
	 * @param platcodeId 项目编号
	 * @param param 参数
	 * @param xmltype
	 * @param mod 
	 * @param objS 接口参数
	 * @return
	 */
	public String wsUECPClient(String url, String tns, String wsMethodName,String formId,String toId,String platcodeId,Object[] objS) {
		if (StringUtil.isEmpty(url) || StringUtil.isEmpty(tns) 
				|| StringUtil.isEmpty(wsMethodName) || StringUtil.isEmpty(formId)
				|| StringUtil.isEmpty(toId) || StringUtil.isEmpty(platcodeId)) {
			return "error";
		}
		Service service = new Service();
		Call call = null;
		try {
			call = (Call) service.createCall();
		} catch (ServiceException e) {
			return "error";
		}
		
		call.setTargetEndpointAddress(url);
		call.setOperationName(new javax.xml.namespace.QName(tns,wsMethodName));// WSDL里面描述的接口名称
		call.setUseSOAPAction(true);
		call.setSOAPActionURI(tns+wsMethodName);
		call.setEncodingStyle(null);
		call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
		call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
		call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		Name headerName = new PrefixedQName(new javax.xml.namespace.QName(tns,wsMethodName));  
		//跟上面的_call.setOperationName里的一样
        SOAPHeaderElement head = new SOAPHeaderElement(headerName);
        head.setActor(null);
        try{
        	//BeanUtils
				head.addChildElement("from").addTextNode(formId); 
				head.addChildElement("to").addTextNode(toId); 
				head.addChildElement("platcode").addTextNode(platcodeId); 
				head.addChildElement("end_point").addTextNode(tns); 
				head.addChildElement("ext_id").addTextNode(""); 
	        }catch(Exception e){
		        System.out.println(" soapheader Exception == ");
		        e.printStackTrace();
	        }
		call.addHeader(head);  
		String result = "";
		try {
			result = (String) call.invoke(objS);
		} catch (RemoteException e) {
			e.printStackTrace();
			
			result = "error";
			
		}
		return result;
	}
}
