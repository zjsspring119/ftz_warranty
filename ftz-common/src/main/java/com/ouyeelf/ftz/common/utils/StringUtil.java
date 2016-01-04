package com.ouyeelf.ftz.common.utils;

import java.util.List;

public final class StringUtil {

	private static final int TWO_BYTE_START = 0x100;

	/**
	 * @功能 判断字符串是否为空
	 * @说明 null或这trim().length==0 为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return null == str || str.trim().length() == 0;
	}

	
	/**
	 * @功能 将soure数组变成通过delimiter链接的字符串
	 * @param source
	 * @param delimiter
	 * @param appendTail
	 *            是否在字符串末尾增加delimiter
	 * @return
	 */
	public static <T> String arrayToString(T[] source, String delimiter,
			boolean appendTail) {
		if (source==null)
			return ""; 
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < source.length; i++) {
			if (i == 0) {
				bf.append(source[i]);
			} else {
				bf.append(delimiter + source[i]);
			}
		}
		if (appendTail) {
			bf.append(delimiter);
		}
		return bf.toString();
	}

	/**
	 * @功能 将soure集合变成通过delimiter链接的字符串
	 * @param source
	 * @param delimiter
	 * @param appendTail
	 *            是否在字符串末尾增加delimiter
	 * @return
	 */
	public static <T> String listToString(List<T> source, String delimiter,
			boolean appendTail) {
		if (source==null)
			return "";
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < source.size(); i++) {
			if (i == 0) {
				bf.append(source.get(i));
			} else {
				bf.append(delimiter + source.get(i));
			}
		}
		if (appendTail) {
			bf.append(delimiter);
		}
		return bf.toString();
	}
	
	/**
	 * @功能 将source集合变成有，链接的字符串，并将source集合的每个值的两端加上单引号
	 * @说明 数据库设置in (param) 参数专用
	 * @param source
	 * @return
	 */
	public static  String listToStringForSqlInParam(List<String> source) {
		if (source==null)
			return "";
		String delimiter = ",";
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < source.size(); i++) {
			if (i == 0) {
				bf.append("'"+source.get(i)+"'");
			} else {
				bf.append(delimiter +"'"+ source.get(i)+"'");
			}
		}
		return bf.toString();
	} 

	/**
	 *中文转换成  unicode 
	 * 
	 * @param gbStr
	 * @return
	 */
	public static String encodeUnicode(String gbStr) {
		char[] utfBytes = gbStr.toCharArray();
		StringBuffer buffer = new StringBuffer();
		for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
			String hexB = Integer.toHexString(utfBytes[byteIndex]);
			if (hexB.length() <= 2) {
				hexB = "00" + hexB;
			}
			buffer.append("\\u" + hexB);
		}
		return buffer.substring(0);
	}


	/**
	 * unicode 转换成 中文
	 * 
	 * @param unicodeStr
	 * @return
	 */
	public static String decodeUnicode(String unicodeStr) {
		char aChar;
		int len = unicodeStr.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = unicodeStr.charAt(x++);
			if (aChar == '\\') {
				aChar = unicodeStr.charAt(x++);
				if (aChar == 'u') {
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = unicodeStr.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException(
									"Malformed      encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't') {
						aChar = '\t';
					} else if (aChar == 'r') {
						aChar = '\r';
					} else if (aChar == 'n') {
						aChar = '\n';
					} else if (aChar == 'f') {
						aChar = '\f';
					}
					outBuffer.append(aChar);
				}
			} else {
				outBuffer.append(aChar);
			}
		}
		return outBuffer.toString();

	}

	/**
	 * 替换函数
	 * @param inString
	 * @param oldPattern
	 * @param newPattern
	 * @return
	 */
    public static String replace(String inString, String oldPattern,
            String newPattern) {
        if (inString == null) {
            return null;
        }
        if (oldPattern == null || newPattern == null) {
            return inString;
        }

        StringBuffer sbuf = new StringBuffer();
        // output StringBuffer we'll build up
        int pos = 0; // Our position in the old string
        int index = inString.indexOf(oldPattern);
        // the index of an occurrence we've found, or -1
        int patLen = oldPattern.length();
        while (index >= 0) {
            sbuf.append(inString.substring(pos, index));
            sbuf.append(newPattern);
            pos = index + patLen;
            index = inString.indexOf(oldPattern, pos);
        }
        sbuf.append(inString.substring(pos));

        // remember to append any characters to the right of a match
        return sbuf.toString();
    }
    

	/**当inString长度不足len位时在inString将左边用padStr字符补足len位
	 * @param inString
	 * @param len
	 * @param padStr
	 * @return
	 */
    public static String lpad(String inString,int len,String padStr){
	    while (inString.length() < len){
	    	inString = padStr + inString;
	    }
	    return inString;
	}
    
    /**当inString长度不足len位时在inString将右边用padStr字符补足len位
	 * @param inString
	 * @param len
	 * @param padStr
	 * @return
	 */
    public static String rpad(String inString,int len,String padStr){
	    while (inString.length() < len)
	    	inString = inString + padStr;
	    return inString;
	}
    /**当inString以delStr结尾时去掉 字符尾部的delStr
	 * @param inString
	 * @param delStr
	 * @return
	 */
    public static String rtrim(String inString,String delStr){
    	String regex = delStr+"*$";
    	inString = inString.replaceFirst(regex, "");
	    return inString;
	}
    /**当inString以delStr结尾时去掉 字符尾部的delStr
	 * @param inString
	 * @param delStr
	 * @return
	 */
    public static String ltrim(String inString,String delStr){
    	String regex = "^"+delStr+"*";
    	inString = inString.replaceFirst(regex, "");
	    return inString;
	}
    /**
     * 去掉换行符  
     * @param oldStr
     * @return
     */
    public static String cleanWrap(String oldStr) {
    	return oldStr.replaceAll("\r|\n", "");
    }
    
    
    
}
