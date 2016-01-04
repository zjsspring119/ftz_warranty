package com.ouyeelf.ftz.common.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilCommon {
	private static final String format = "yyyyMMddHHmmss";
	public static String dateToString(Date date){
		String dateStr="";
		String format = "yyyy-MM-dd";
		SimpleDateFormat sdf  =   new  SimpleDateFormat(format);
		if(null != date && !"".equals(date)){
			dateStr = sdf.format(date);
		}
		return dateStr;
	}

	
	public static Date StringToDate(String string){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date s_date=null;
		if(null!=string&&!"".equals(string)) {
		try {
			s_date =(Date)sdf.parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		 return s_date;
	}
	/**
	 * 
	 * @param bigDecimal 要设置的Bigdecimal对象
	 * @param 数据精度
	 * @return 设置精度以后的Bigdecimal对象
	 */
	public static BigDecimal formateBigDecimal(BigDecimal bigDecimal,int i){
		BigDecimal  formateBigDecimal = bigDecimal.setScale(i, BigDecimal.ROUND_HALF_UP);
		return formateBigDecimal;
	}
	
	 /**
     * 获取当前日期和时间
     * 
     * @return String
     */
    public static String getCurrentDateStr() {
    	Date date = new Date();
    	String str = null;
    	SimpleDateFormat df = new SimpleDateFormat(format);
    	str = df.format(date);
    	return str;
    }
    
    /**
     * 日期和时间格式转换
     * 
     * @return String
     */
    public static String formateDateTime(String date) {
    	String str = null;
    	SimpleDateFormat df = new SimpleDateFormat(format);
    	str = df.format(date);
    	return str;
    }
    
    /**
     * 计算日期两个日期之间的天数
     * @param targetTime(目标日期)
     * @param sourceTime(源日期)
     * @return long
     */
    public static long getQuot(String targetTime, String sourceTime){
		long quot = 0;
		try {
			Date target = StringToDate(targetTime);
			Date source = StringToDate(sourceTime);
			quot = target.getTime() - source.getTime();
			quot = quot / 1000 / 60 / 60 / 24;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quot;
	}
    
    //产生n位随机码
    public static String getRandomCode(int n){
    	String result="";
    	while(result.length()<n)
    		result+=(int)(Math.random()*10);
    	return result;
    			    	
    };
}
