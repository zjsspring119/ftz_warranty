package com.ouyeelf.ftz.common.utils;

import java.util.UUID;

public class GuidUtil {
	
	/**
	 * UUID的生成
	 * @return
	 */
	public static String newGuid()
	{
		return UUID.randomUUID().toString();
	}
	
	/*public static String newGuid(String objectGuid)
	{
		if (StringUtil.isEmpty(objectGuid))
			return UUID.randomUUID().toString();
		else
			return objectGuid.trim();
	}*/

	public static void main(String[] args) {
		System.out.println(GuidUtil.newGuid().length());
	}
}
