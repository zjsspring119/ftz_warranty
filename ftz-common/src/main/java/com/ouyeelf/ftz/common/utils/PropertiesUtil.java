package com.ouyeelf.ftz.common.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * **********************************************
 * Copyright (c)  by goldensoft
 * All right reserved.
 * Create Date: 2012-1-11
 * Create Author: huangxin
 * File Name:  读取.properties配置文件的内容至Map中。
 * Last version:  1.0
 * Function:这里写注释
 * Last Update Date:
 * Change Log:
 *************************************************
 */
public class PropertiesUtil {

	protected final static Log logger = LogFactory.getLog(PropertiesUtil.class);
	
	/**
	 * 读取.properties配置文件的内容至Map中
	 * @param propertiesFile
	 * @return
	 */
	public static Map read(String propertiesFile) {
		ResourceBundle rb = ResourceBundle.getBundle(propertiesFile);
		Map map = new HashMap();
		Enumeration enu = rb.getKeys();
		while (enu.hasMoreElements()) {
			Object obj = enu.nextElement();
			Object objv = rb.getObject(obj.toString());
			
			if( logger.isDebugEnabled()){
				logger.debug("property ["+ obj +"]:"+ objv);
			}
			
			map.put(obj, objv);
		}
		return map;
	}

}

