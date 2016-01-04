package com.ouyeelf.ftz.rsdb.imp.domain.change;

import java.math.BigDecimal;
import java.util.Date;

import com.ouyeelf.ftz.common.utils.DateUtil;

public abstract class BaseChange {

	
	
	/**
	 * 日期转换成"yyyy-MM-dd HH:mm:ss" 字符串
	 * @param date
	 * @return dateStr
	 */
	protected static String dateToStr(Date date){
		String dateStr="";
		if(null!=date){
			dateStr=DateUtil.toDateString(date, DateUtil.DEFAULT_DATETIME_PATTERN);
		}
		return dateStr;
	}
	
	/**
	 * BigDecimal转换成字符串
	 * @param bigDec
	 * @return bigDecStr
	 */
	protected static String bigDecimalToStr(BigDecimal bigDec){
		String bigDecStr="0";
		if(null!=bigDec){
			bigDecStr=String.valueOf(bigDec.doubleValue());
		}
		return bigDecStr;
	}
	
	/**
	 * Integer转换成字符串
	 * @param integer
	 * @return intStr
	 */
	protected  static String integerToStr(Integer integer){
		String intStr="0";
		if(null!=integer){
			intStr=integer.toString();
		}
		return intStr;
	}
}
