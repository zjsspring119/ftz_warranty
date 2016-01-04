package com.ouyeelf.ftz.model.base;

/**
 * **************************************************
 *@Copyrigth(c) by ftzWarranty Co., Ltd
 *@Create Date 2015-9-1 
 *@author zjs
 *@File Name：
 *@Last version：1.0
 *@Function: 封装restful结果信息
 *@Change Log:
 **************************************************
 */
public class Result {
	private Object message;
	
	public Result(final String message){
		this.message = message;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
}
