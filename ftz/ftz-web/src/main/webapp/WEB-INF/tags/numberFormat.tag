<jsp:directive.tag language="java"  pageEncoding="UTF-8" import="java.text.NumberFormat"/><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ attribute name="value"  required="true" rtexprvalue="true"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ attribute name="fractionDigits"  required="false" rtexprvalue="true"%><%
String numberStr = "";
if(null != value && !"".equals(value)){
	 if(null == fractionDigits){
		 fractionDigits = "2";
	 }
	 Integer i = new Integer(fractionDigits);
	 NumberFormat format = NumberFormat.getInstance();   
	 format.setMaximumFractionDigits(i.intValue());   
	 numberStr = format.format(new Double(value));
}
%><%=numberStr%>