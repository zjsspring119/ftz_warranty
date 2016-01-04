package com.ouyeelf.ftz.common.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 ***********************************************
 * Copyright (c)  by bsteel
 * All right reserved.
 * File Name:  日期操作工具类
 * Last version:  1.0
 * Last Update Date:
 * Change Log:
 *************************************************
 */
public class DateUtil {
	/**
	 * 默认日期格式：yyyy-MM-dd
	 */
	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

	/**
	 * 默认时间格式：yyyy-MM-dd HH:mm:ss
	 */
	public static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 默认时间戳格式，到毫秒 yyyy-MM-dd HH:mm:ss SSS
	 */
	public static final String DEFAULT_DATEDETAIL_PATTERN = "yyyy-MM-dd HH:mm:ss SSS";

	/**
	 * 1天折算成毫秒数
	 */
	public static final long MILLIS_A_DAY = 24 * 3600 * 1000;
	
	private static Map<String, Object> parsers = new HashMap<String, Object>();

	private static SimpleDateFormat getDateParser(String pattern) {
		Object parser = parsers.get(pattern);
		if (parser == null) {
			parser = new SimpleDateFormat(pattern);
			parsers.put(pattern, parser);
		}
		return (SimpleDateFormat) parser;
	}

	/**
	 * 取得当前系统日期
	 * 
	 * @return
	 */
	public static java.util.Date currentDate() {
		return new java.util.Date();
	}
	
	/**
	 * 取得当前系统时间
	 * 
	 * @return
	 */
	public static long currentTimeMillis() {
		return System.currentTimeMillis();
	}
	
	/**
	 * 取得系统当前日期，返回默认日期格式的字符串。
	 * 
	 * @param strFormat
	 * @return
	 */
	public static String nowDate(String strFormat) {
		java.util.Date date = new java.util.Date();
		return getDateParser(strFormat).format(date);
	}

	/**
	 * 取得当前系统时间戳
	 * 
	 * @return
	 */
	public static Timestamp currentTimestamp() {
		return new Timestamp(new Date().getTime());
	}

	/**
	 * 将日期字符串转换为java.util.Date对象
	 * 
	 * @param dateString
	 * @param pattern
	 *            日期格式
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date toDate(String dateString, String pattern)
			throws Exception {
		return getDateParser(pattern).parse(dateString);
	}

	/**
	 * 将日期字符串转换为java.util.Date对象，使用默认日期格式
	 * 
	 * @param dateString
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date toDate(String dateString) throws Exception {
		return getDateParser(DEFAULT_DATE_PATTERN).parse(dateString);
	}

	/**
	 * 将时间字符串转换为java.util.Date对象
	 * @param dateString
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date toDateTime(String dateString) throws Exception {
		return getDateParser(DEFAULT_DATETIME_PATTERN).parse(dateString);
	}

	/**
	 * 将java.util.Date对象转换为字符串
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String toDateString(java.util.Date date, String pattern) {
		return getDateParser(pattern).format(date);
	}

	/**
	 * 将java.util.Date对象转换为字符串，使用默认日期格式
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String toDateString(java.util.Date date) {
		return getDateParser(DEFAULT_DATE_PATTERN).format(date);
	}

	/**
	 * 将java.util.Date对象转换为时间字符串，使用默认日期格式
	 * @param date
	 * @return
	 */
	public static String toDateTimeString(java.util.Date date) {
		return getDateParser(DEFAULT_DATETIME_PATTERN).format(date);
	}

	/**
	 * 日期相减
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date diffDate(java.util.Date date, int day) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) - ((long) day) * MILLIS_A_DAY );
		return c.getTime();
	}
	
	/**
	 * 返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}
	
	
	/**
	 * 日期相加
	 * 
	 * @param date
	 *            日期
	 * @param day
	 *            天数
	 * @return 返回相加后的日期
	 */
	public static java.util.Date addDate(java.util.Date date, int day) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		
		c.setTimeInMillis(getMillis(date) + ((long) day) * MILLIS_A_DAY);
		return c.getTime();
	}
	/**
	 * 获取当月第一天
	 * @return
	 */
	public static String getFirstDayOfCurrMonth(){ 
		String str = ""; 
		SimpleDateFormat sdf=new SimpleDateFormat(DEFAULT_DATE_PATTERN); 
		Calendar beginDate = Calendar.getInstance(); 
		beginDate.set(Calendar.DATE,1);//设为当前月的1号
		str=sdf.format(beginDate.getTime()); 
		return str; 
	} 
	
	/**
	 * 获取N月之前的日期
	 * @return
	 */
	public static String getSeveralMonthBeforeDate(int months){ 
		String str = ""; 
		SimpleDateFormat sdf=new SimpleDateFormat(DEFAULT_DATE_PATTERN); 
		Calendar beginDate = Calendar.getInstance(); 
		beginDate.set(Calendar.MONTH,-months);//设为N月之前日期
		str=sdf.format(beginDate.getTime()); 
		return str; 
	} 
	/**
	 * 获取之前N月的第一段
	 * @return
	 */
	public static String getFirstOfSeveralMonthBeforeDate(int months){ 
		String str = ""; 
		SimpleDateFormat sdf=new SimpleDateFormat(DEFAULT_DATE_PATTERN); 
		Calendar beginDate = Calendar.getInstance(); 
		beginDate.set(Calendar.MONTH,-months);//设为N月之前日期
		beginDate.set(Calendar.DATE,1);//设为当月的1号
		str=sdf.format(beginDate.getTime()); 
		return str; 
	} 

}
