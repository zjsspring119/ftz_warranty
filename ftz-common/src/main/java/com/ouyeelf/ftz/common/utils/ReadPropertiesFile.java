package com.ouyeelf.ftz.common.utils
;

import java.util.Map;

public class ReadPropertiesFile {

	@SuppressWarnings("rawtypes")
	private static Map properties;
	
	@SuppressWarnings("rawtypes")
	public static Map getProperties() {
		if(null==properties){
			properties = PropertiesUtil.read("lgs_ftz");
		}
		return properties;
	}

	public void setPropertiesFile() {
		properties = PropertiesUtil.read("lgs_baofc");
	}

}
