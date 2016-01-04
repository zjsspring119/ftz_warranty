<jsp:directive.tag language="java"  pageEncoding="UTF-8" import="java.text.SimpleDateFormat,java.util.Date"/><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ attribute name="value"  required="true" rtexprvalue="true"%><%@ attribute name="format"  required="false" rtexprvalue="true"%><%
if(null== format || "".equals(format)){
	format = "yyyy-MM-dd";
}
SimpleDateFormat sdf  =   new  SimpleDateFormat(format); 
String dateStr ="";
if(null != value && !"".equals(value)){
	Date date = sdf.parse(value); 
	dateStr = sdf.format(date);
}
%><%=dateStr%>