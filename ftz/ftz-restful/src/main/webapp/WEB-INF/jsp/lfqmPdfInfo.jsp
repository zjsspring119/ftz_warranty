<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>宝钢国际电子商务服务平台</title>
<c:set var="contextpath" value="${pageContext.request.contextPath}" />
<script>
	var contextpath = '${contextpath}';
	var orghost = window.location.host;
</script>

<link id="css" href="<c:url value='/style/defaultStyle/css/css.css'/>"
	rel="stylesheet" type="text/css" />
<link id="menucss" href="<c:url value='/style/defaultStyle/css/menu_css.css'/>"
	rel="stylesheet" type="text/css" />
<script id="menujs" type="text/javascript"
	src="<c:url value='/js/custom/public/menu.js'/>"></script>
<script id="indexjs" type="text/javascript"
	src="<c:url value='/js/custom/public/index.js'/>"></script>
<script id="spyjs" src="<c:url value='/js/widget/SpryAssets/SpryTabbedPanels.js'/>"
	type="text/javascript"></script>
<link id="spycss" href="<c:url value='/js/widget/SpryAssets/SpryTabbedPanels.css'/>"
	rel="stylesheet" type="text/css" />


<script id="jqueryjs" type=text/javascript
	src="<c:url value='/js/core/jquery-1.9.1.min.js'/>"></script>
<script id="lazyjs" type=text/javascript
	src="<c:url value='/js/core/jquery.lazyload.js'/>"></script>
<script id="artjs" type=text/javascript src="<c:url value='/js/core/template.js'/>"></script>
<script id="my97js" type="text/javascript"
	src="<c:url value='/js/widget/My97DatePicker/WdatePicker.js'/>"></script>
<script id="bsUtiljs" type=text/javascript
	src="<c:url value='/js/custom/public/bsUtil.js'/>"></script>
<script id="antilopejs" type=text/javascript
	src="<c:url value='/js/custom/mt/antelope.js'/>"></script>

<style type="text/css">
.ImgMenu{
	width: 165px;
	height:45px;
	border:1px solid red;
	background-image:url(<c:url value='/style/defaultStyle/images/menu.gif'/>);
	cursor:pointer;
}


 .ifr_div{width:600px;height:600px; position:relative;} 
 .ifr_div img{ vertical-align:middle;} 
 .proccess{border:0px solid;border-color:#009900;height:600px;line-height:600px;width:600px;text-align:center;background:#eee;margin:0;position:absolute;top:0;left:0;} 
 .proccess b{vertical-align:middle;background:url(http://ok22.org/upload/images/20110902143538381.gif) no-repeat 0 center;padding-left:35px;display:inline-block;} 

</style>
</head>
<body>
<input type="hidden" id="hidtab" value="CURRENT_MONTH"/>
	<div id="wrapper">
		<div id="logo"></div>
		<div id="quinklink">
			<div id="userInfo" class="left yellow bold">
				
			</div>
			<div class="right" id="icon">
				<ul>
					<li class="right" onmouseover="MM_showHideLayers('tc','','show')"
						onmouseout="MM_showHideLayers('tc','','hide')"><a href="#"
						onmouseout="MM_swapImgRestore()"
						onmouseover="MM_swapImage('Image3','','<c:url value='/style/defaultStyle/images/bank_over.png'/>',1)">
						<img src="<c:url value='/style/defaultStyle/images/delay.gif'/>" 
							data-original="<c:url value='/style/defaultStyle/images/bank.png'/>"
							name="Image3" width="24" border="0" id="Image3" class="lazy"/></a></li>
					<li class="right" onmouseover="MM_showHideLayers('sx','','show')"
						onmouseout="MM_showHideLayers('sx','','hide')"><a href="#"
						onmouseout="MM_swapImgRestore()"
						onmouseover="MM_swapImage('Image2','','<c:url value='/style/defaultStyle/images/help_over.png'/>',1)"><img
							src="<c:url value='/style/defaultStyle/images/help.png'/>"
							name="Image2" border="0" id="Image2" /></a></li>
					<li class="right" onmouseover="MM_showHideLayers('fh','','show')"
						onmouseout="MM_showHideLayers('fh','','hide')"><a href="#"
						onmouseout="MM_swapImgRestore()"
						onmouseover="MM_swapImage('Image16','','<c:url value='/style/defaultStyle/images/home_over.png'/>',1)"><img
							src="<c:url value='/style/defaultStyle/images/home.png'/>"
							name="Image16" width="25" height="22" border="0" id="Image16" /></a></li>
				</ul>
				<div style="position: absolute; top: 25px; left: 0px;"
					class="quink_link_icon  blue" id="fh">返回首页</div>
				<div style="position: absolute; top: 25px; left: 20px;"
					class="quink_link_icon  blue" id="sx">帮助中心</div>
				<div style="position: absolute; top: 25px; left: 40px;"
					class="quink_link_icon  blue" id="tc">退出系统</div>
			</div>
		</div>
		<div id="main">
			<div id="Menu" style="display: inline;"></div>
			<div id="contant">
				<div id="contant_main">
					<div id="contant_iframe" class="page_bg">
						<div id="cg02">
							<div width="99%">
								<img
									src="<c:url value='/style/defaultStyle/images/little.png'/>"
									width="99%" />
							</div>
							<table width="99%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="70%"><table width="99%" border="0"
											cellspacing="0" class="search_table">
											<tr>
												<td width="1" valign="bottom"><img
													src="<c:url value='/style/defaultStyle/images/search_line.gif'/>"
													width="1" /></td>
												<td valign="top"><table width="100%" border="0"
														cellspacing="2">
														<tr>
															<td colspan="6" class="kg font_14 bold height_30">查询条件</td>
														</tr>
														<tr>
															<td align="right">合同号</td>
															<td><input size='13' type="text" id="orderNum"
																name="orderNum-i0" value="" class="inputField" /></td>
															<td align="right">证书号</td>
															<td><input size='13' type="text" id="tcNumTc"
																name="tcNumTc-i0" value="" class="inputField" /></td>
														</tr>
														<tr>
															<td align="right">控制号</td>
															<td><input size='13' type="text" id="accpCtrolId"
																name="accpCtrolId-i0" value="" class="inputField" /></td>
															<td align="right">钢板/捆包号</td>
															<td><input size='13' type="text" id="packNum"
																name="packNum-i0" value="" class="inputField" /></td>
														</tr>
														<tr>
															<td align="right">品种</td>
															<td><select id="prodcode" name="prodcode-i0">
																	<option selected="selected" value="">全部</option>
																	<option value="('I','X')">热轧</option>
																	<option value="('J')">厚板</option>
															</select></td>
															<td align="right">会检部门</td>
															<td><select id="accpAuthority"
																name="accpAuthority-i0">
																	
															</select></td>
														</tr>
														<tr>
															<td align="right">产线</td>
															<td><select id="factory" name="factory-i0">
																	<option selected="selected" value="">全部</option>
																	<option value="B">总部及总部厚板1号线</option>
																	<option value="L">总部厚板2号线</option>
															</select></td>
															<td align="right">验签时间</td>
															<td>
																<!--此处写时间控件 --> <input type="text" class="Wdate"
																onClick="WdatePicker()" size='18' ,readonly='true'
																id="pdfCreatTimeBegin"
																name="pdfCreatTimeBegin-i0" value="" /> - <input
																type="text" class="Wdate" onClick="WdatePicker()"
																size='18' ,readonly='true' id="pdfCreatTimeEnd"
																name="pdfCreatTimeEnd-i0" value="" />
															</td>
														</tr>
														<tr>
															<td align="right">拉伸试样号</td>
															<td><input size='13' type="text" id="impactNum"
																name="impactNum-i0" value="" class="inputField" /></td>
														</tr>
														<tr>
															<td colspan="4" align="center"><input type="button"
																class="btn01" id="button" value='查询'
																onClick="button_query_onclick()" /> <input name="button"
																type="button" class="btn01" id="button" value='清空'
																onclick="button_clear_onclick()" /></td>
														</tr>

													</table></td>
												<td><table width="100%" border="0" cellspacing="0"
														class="search_table">
														<tr>
															<td width="1" valign="bottom"><img
																src="<c:url value='/style/defaultStyle/images/search_line.gif'/>"
																width="1" /></td>
															<td valign="top"><table width="100%" border="0"
																	cellspacing="32" id="sel2">
																	<tr>
																		<td class="kg font_14 bold height_30">业务提醒</td>
																	</tr>
																	<tr>
																		<td class="kg">. 红冲 &nbsp;2 &nbsp; 份
																		</td>
																	</tr>
																	<tr>
																		<td></td>
																	</tr>
																</table> <label></label></td>
														</tr>
													</table></td>
											</tr>
										</table>
										<div id="TabbedPanels1" class="TabbedPanels">
											<ul class="TabbedPanelsTabGroup">
												<li class="TabbedPanelsTab" tabindex="0"
													onclick="tab_query_onclick('CURRENT_MONTH')">本月</li>
												<li class="TabbedPanelsTab" tabindex="1"
													onclick="tab_query_onclick('LAST_3MONTH')">近三个月</li>
												<li class="TabbedPanelsTab" tabindex="2"
													onclick="tab_query_onclick('ALL')">全部</li>
											</ul>
											<div class="TabbedPanelsContentGroup">
												<div class="TabbedPanelsContent"
													style="overflow-x: scroll; overflow-y: hidden; width: 99%">
													<table width="100%" border="0" cellspacing="0"
														cellpadding="0">
														<tr>
															<td>
																<table width="100%" border="0" cellspacing="1"
																	cellpadding="5" class="infor_table">
																	<thead>
																		<tr id='title' class="infor_title">

																			<td width="2%" class="infor_title">&nbsp;</td>
																			<td width="4%" class="infor_title">序号</td>
																			<!-- 序号 -->
																			<td width="4%" class="infor_title">操作</td>
																			<!-- 操作 -->
																			<td width="6%" class="infor_title">合同号</td>
																			<!-- 合同号 -->
																			<td width="6%" class="infor_title">证书号</td>
																			<!--证书号  -->
																			<td width="10%" class="infor_title">控制号</td>
																			<!-- 控制号 -->
																			<td width="8%" class="infor_title">验签时间</td>
																			<!-- 验签时间 -->
																			<td width="10%" class="infor_title">钢种</td>
																			<!-- 钢种 -->
																			<td width="6%" class="infor_title">厚度</td>
																			<!-- 厚度 -->
																			<td width="11%" class="infor_title">重量(t)</td>
																			<!-- 重量 -->
																			<td width="8%" class="infor_title">红冲标识</td>
																			<!-- 红冲标识 -->
																			<td width="6%" class="infor_title">查看</td>
																			<!-- 查看 -->
																			<td width="12%" class="infor_title">会检部门</td>
																			<!-- 会检部门 -->
																		</tr>
																	</thead>
																	<!-- 这里写数据 -->
																	<tbody id="tbody">

																	</tbody>
																</table>
															</td>
															<td width="10" valign="middle"></td>
														</tr>
													</table>
												</div>
											</div>

											<table id='page' cellspacing="0" border="0" align="right">
												<tr>
													<td id='pagination' align=right><jsp:include
															page="page.jsp"></jsp:include></td>
												</tr>
											</table>
										</div>
										</div>
										</div>
										<div id="contant_bottom"></div>
										</div>
										<div class="clear"></div>
										<div id="bottom">
											宝钢国际经济贸易有限公司 版权所有<br /> 东方钢铁电子商务有限公司提供运营服务 服务热线：800 820 8018
										</div>
										</div>
										</div>
<div id="transbox" style="position:absolute; left:0px; top:0px; display:none;width: 100%;height: 100%;
margin: 0 0px;background-color: #fff;border: 0px;filter:alpha(opacity=30);opacity: 0.5;-moz-opacity:0.5;"></div>	
</body>
</html>

<%-- <script id="list" type="text/html">

<%for(int i = 0; i < rows.length; i ++) {%>
	<tr>
		<td><input type='checkbox' value='<%=rows[i]["uid"]%>'/></td>
		<td><img id='imgUid<%=rows[i]["uid"]%>' src='<%=contextpath%>/style/defaultStyle/images/b_icon.gif' onclick='expandRow(<%=rows[i]["uid"]%>)'/><%=rows[i]["sno"]%></td>
   		<td><%=rows[i]["opra"]%></td>
      	<td><%=rows[i]["contractNo"]%></td>
      	<td><%=rows[i]["certNo"]%></td>
      	<td><%=rows[i]["ctrNo"]%></td>
      	<td><%=rows[i]["checkTime"]%></td>
      	<td><%=rows[i]["ano"]%></td>
      	<td><%=rows[i]["thick"]%></td>
      	<td><%=rows[i]["weight"]%></td>
      	<td><%=rows[i]["flag"]%></td>
      	<td><%=rows[i]["isCheck"]%></td>
      	<td><%=rows[i]["dept"]%></td>
     </tr>
     <tr id='sid<%=rows[i]["uid"] %>'></tr>"
<%}%>

</script> --%>