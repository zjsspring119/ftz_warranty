$(function() {
	
	var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1" );
	
//	获取cdn地址列表并替换img、css、js
//	getCDNList();
		
//	图片延迟加载
	$("img.lazy").lazyload();
	
//	回填用户信息
	getUser("userInfo","accpAuthority");
	
//	回填菜单
	getMenu("Menu");
		
//	回填grid数据
	firstPage("tbody",'CURRENT_MONTH');
	
});

//轮询调度算法
var i = 3;
var n = 4;
var j ; 
function schedule(){
	j = i;
	i = (j+1)%n
	return i;
}

//获取cdn地址列表并替换img、css、js
function getCDNList(){
	if(window.location.protocol == "http:"){
		$.ajax({ 
			type: "POST", 
			url: contextpath+"/getValidCdns",
			contentType: "application/json", 
			dataType: 'json',
			cache:true,
			success: function(data) {
				var cdnlist = data.validCdnList;//cdn地址列表
//				var cdnhost = cdnlist[schedule()].url;//轮询获取cdn地址
				
				if(cdnlist.length > 0){
				//替换所有的img地址
				var img = $("img");//获取所有img标签
				for( var i=0;i<img.length;i++){//循环替换img的cdn地址
					var imgsrc = img[i].attributes.src.nodeValue;
					var cdnhost = cdnlist[0].url;
					var newurl = "http://"+cdnhost+"/demo_baosteel_com"+imgsrc;
					$("#"+img[i].id).attr("src",newurl);
				}
				
				//替换所有js文件地址
				var jsobj = $("script");
				for( var i=0;i<jsobj.length;i++){//循环替换js的cdn地址
					if(jsobj[i].attributes.length >0 ){
						var jssrc = jsobj[i].attributes[0].nodeValue;
						var cdnhost = cdnlist[0].url;
						var newurl = "http://"+cdnhost+"/demo_baosteel_com"+jssrc;
						$("#"+jsobj[i].id).attr("src",newurl);
					}
					
				}
				
				//替换所有js文件地址
				var cssobj = $("link");
				for( var i=0;i<cssobj.length;i++){//循环替换css的cdn地址
					if(cssobj[i].attributes.length >0 ){
						var csssrc = cssobj[i].attributes[2].nodeValue;
						var cdnhost = cdnlist[0].url;
						var newurl = "http://"+cdnhost+"/demo_baosteel_com"+csssrc;
						$("#"+cssobj[i].id).attr("href",newurl);
					}
					
				}
				
				//替换background 图片路径
				var styleobj = $("style");
				for( var i=0;i<styleobj.length;i++){//循环替换css的cdn地址
					if(styleobj[i].childNodes.length>0){
						var stylesrc = styleobj[i].childNodes[0].data;
						var stylearray = stylesrc.split("background-image:url(");
						var lateststyle = stylearray[0];
						for(var j=1;j<stylearray.length;j++){
							var cdnhost = cdnlist[0].url;
							var temp = "background-image:url(http://"+cdnhost+"/demo_baosteel_com";
							lateststyle = lateststyle + temp +  stylearray[j];
						}
						styleobj[i].childNodes[0].data = lateststyle;
					}
				}
				}
			}
		});
		
	}
}

//grid模板
var source = "<%for (var i = 0; i < lfqmPdfInfoList.length; i++) { %>"
			+"<tr>"
      +"<td><img style='cursor:pointer;' id='imgUid<%=pagination.page*pagination.limit + i+1 %>' src='"+contextpath+"/style/defaultStyle/images/b_icon.gif' onclick=expandRow('<%=pagination.page*pagination.limit + i+1  %>','<%=lfqmPdfInfoList[i]['orderNum']%>') /></td>"
      +"<td align='center'><%=pagination.page*pagination.limit + i+1  %></td>"
      +"<td align=center><img style='cursor:pointer;' src='"+contextpath+"/style/defaultStyle/images/icon_xq.gif'/></td>"
      +"<td><%=lfqmPdfInfoList[i]['orderNum']%></td>"
      +"<td><%=lfqmPdfInfoList[i]['tcNumTc']%></td>"
      +"<%if(lfqmPdfInfoList[i].pdfCertificate != null){%>"
      +"<td><%=lfqmPdfInfoList[i].pdfCertificate.accpCtrolId %></td>"
      +"<td><%=lfqmPdfInfoList[i].pdfCertificate.pdfCreatTime %></td>"
      +"<td><%=lfqmPdfInfoList[i].pdfCertificate.shopsign %></td>"
      +"<td align='right'><%=lfqmPdfInfoList[i].pdfCertificate.thickTbthDim %></td>"
      +"<td align='right'><%=lfqmPdfInfoList[i].pdfCertificate.totalWeight %></td>"
      +"<%}else{%>"
      +"<td>&nbsp;</td>"
      +"<td>&nbsp;</td>"
      +"<td>&nbsp;</td>"
      +"<td>&nbsp;</td>"
      +"<td>&nbsp;</td>"
      +"<%}%>"
      +"<td><%=lfqmPdfInfoList[i]['status']%></td>"
      +"<td><a href='http://www.baosteel.net.cn/baosteel_dss/DSS/D1/TS/ShipBoardPdfFile/J3F0003576_BGSAJ1303310023200.pdf'><input type='button' class='btn01' value='查看'/></a></td>"
      +"<td><%=lfqmPdfInfoList[i]['accpAuthority']%></td>"
      +"</tr>"
      +"<tr id=sid<%=pagination.page*pagination.limit + i+1%>></tr>"
			+"<% } %>";


function query(bodyid,url,queryCondition){
	/*$.ajax({ 
			type: "POST", 
			async:true, 
			url: url,
			data: queryCondition, 
			contentType: "application/json", 
			dataType: 'json',
			cache:true,
			success: function(data) {
				$('#'+bodyid).empty();	
				if(data.lfqmPdfInfoList != null){
					var render = template.compile(source);
					var html = render(data);					
					$('#'+bodyid).append(html);
				}
	        $("#currentPage").html("第&nbsp;"+Math.ceil(data.pagination['offset']/data.pagination['limit'])+"&nbsp;页&nbsp;&nbsp;");
	        $("#totalPageCount").html("共&nbsp;"+data.pagination['allPage']+"&nbsp;页&nbsp;&nbsp;");
	        $("#allCount").html("共&nbsp;"+data.pagination['count']+"&nbsp;条&nbsp;&nbsp;");
	        $("#offset").val(data.pagination['offset']);
			}
		});*/
	
	var iframe=document.getElementById("transbox");
	iframe.style.display="";
	iframe.style.height=document.body.clientHeight;
	var target = document.getElementById('main');
	var spinner = new Spinner(opts).spin(target);
			
	var sCallback =
	{
			onSuccess : 
	    		function(data)
				{ 
					$('#'+bodyid).empty();	
					if(data.lfqmPdfInfoList != null){
						var render = template.compile(source);
						var html = render(data);					
						$('#'+bodyid).append(html);
					}
					var currPage = parseInt(data.pagination['page']) >= parseInt(data.pagination['allPage'])?(parseInt(data.pagination['allPage'])):(parseInt(data.pagination['page'])+1);
			        $("#currentPage").html("第&nbsp;"+currPage+"&nbsp;页&nbsp;&nbsp;");
			        $("#totalPageCount").html("共&nbsp;"+data.pagination['allPage']+"&nbsp;页&nbsp;&nbsp;");
			        $("#allCount").html("共&nbsp;"+data.pagination['count']+"&nbsp;条&nbsp;&nbsp;");
			        $("#offset").val(data.pagination['offset']);
			        $("#allPage").val(data.pagination['allPage']);
			        $("#cPage").val(data.pagination['page']);
			        iframe.style.display="none";
			        spinner.stop();
	    		},
	  		onFail: 
	    		function(eMsg) 
				{
	    			alert("服务调用失败: " + eMsg);
	    			iframe.style.display="none";
	    			spinner.stop();
				}
		}; 
	EiCommunicator.send(url, queryCondition, sCallback, true);
}

//获取json对象并回填
function getData(bodyid,flag,queryCondition){
	queryCondition["timeLineFlag"] = flag;
	query(bodyid,contextpath+"/queryLfqmPdfInfo?",queryCondition)
}

//查询条件
//var queryStr = "'orderNum':"+$("#orderNum").val()+",'tcNumTc':"+$("#tcNumTc").val()
//+",'accpCtrolId':"+$("#accpCtrolId").val()+",'packNum':"+$("#packNum").val()
//+",'prodcode':"+$("#prodcode").val()+",'accpAuthority':"+$("#accpAuthority").val()
//+",'factory':"+$("#factory").val()+",'impactNum':"+$("#impactNum").val()
//+",'pdfCreatTimeFrom':"+$("#pdfCreatTimeBegin").val()+",'pdfCreatTimeTo':"+$("#pdfCreatTimeEnd").val()

//下一页
function nextPage(bodyid,flag){
	var queryCondition = {
			'limit':$("#perPageRecord").val(),
			'page':parseInt($("#allPage").val())==0?0:(parseInt($("#cPage").val())+1)>=parseInt($("#allPage").val())?(parseInt($("#allPage").val())-1):(parseInt($("#cPage").val())+1),
//			'offset':$("#offset").val()==""?"0":(parseInt($("#offset").val())+parseInt($("#perPageRecord").val())*parseInt($("#pageNum").val()==""?"1":("#pageNum").val())),
			'orderNum':$("#orderNum").val(),
			'tcNumTc':$("#tcNumTc").val(),
			'accpCtrolId':$("#accpCtrolId").val(),
			'packNum':$("#packNum").val(),
			'prodcode':$("#prodcode").val(),
			'accpAuthority':$("#accpAuthority").val(),
			'factory':$("#factory").val(),
			'impactNum':$("#impactNum").val(),
			'pdfCreatTimeFrom':$("#pdfCreatTimeBegin").val(),
			'pdfCreatTimeTo':$("#pdfCreatTimeEnd").val(),
			'userId':'10000'
	};
	$("#pageNum").val("");
	getData(bodyid,flag,queryCondition);
}

//上一页
function prePage(bodyid,flag){
	var queryCondition = {
			'limit':$("#perPageRecord").val(),
			'page':parseInt($("#allPage").val())==0?0:parseInt($("#cPage").val())-1<0?0:parseInt($("#cPage").val())-1,
//			'offset':$("#offset").val()==""?"0":(parseInt($("#offset").val())-parseInt($("#perPageRecord").val())*parseInt($("#pageNum").val()==""?"1":("#pageNum").val())),
			'orderNum':$("#orderNum").val(),
			'tcNumTc':$("#tcNumTc").val(),
			'accpCtrolId':$("#accpCtrolId").val(),
			'packNum':$("#packNum").val(),
			'prodcode':$("#prodcode").val(),
			'accpAuthority':$("#accpAuthority").val(),
			'factory':$("#factory").val(),
			'impactNum':$("#impactNum").val(),
			'pdfCreatTimeFrom':$("#pdfCreatTimeBegin").val(),
			'pdfCreatTimeTo':$("#pdfCreatTimeEnd").val(),
			'userId':'10000'
	};
	$("#pageNum").val("");
	getData(bodyid,flag,queryCondition);
}

//第一页
function firstPage(bodyid,flag){
	var queryCondition = {
			'limit':$("#perPageRecord").val(),
			'page':"0",
			'offset':"0",
			'orderNum':$("#orderNum").val(),
			'tcNumTc':$("#tcNumTc").val(),
			'accpCtrolId':$("#accpCtrolId").val(),
			'packNum':$("#packNum").val(),
			'prodcode':$("#prodcode").val(),
			'accpAuthority':$("#accpAuthority").val(),
			'factory':$("#factory").val(),
			'impactNum':$("#impactNum").val(),
			'pdfCreatTimeFrom':$("#pdfCreatTimeBegin").val(),
			'pdfCreatTimeTo':$("#pdfCreatTimeEnd").val(),
			'userId':'10000'
	};
	$("#pageNum").val("");
	getData(bodyid,flag,queryCondition);
}

//最后一页
function lastPage(bodyid,flag){
	var queryCondition = {
			'limit':$("#perPageRecord").val(),
			'page':parseInt($("#allPage").val())==0?0:parseInt($("#allPage").val())-1,
//			'offset':(parseInt($("#allPage").val())-1)*parseInt($("#perPageRecord").val()),
			'orderNum':$("#orderNum").val(),
			'tcNumTc':$("#tcNumTc").val(),
			'accpCtrolId':$("#accpCtrolId").val(),
			'packNum':$("#packNum").val(),
			'prodcode':$("#prodcode").val(),
			'accpAuthority':$("#accpAuthority").val(),
			'factory':$("#factory").val(),
			'impactNum':$("#impactNum").val(),
			'pdfCreatTimeFrom':$("#pdfCreatTimeBegin").val(),
			'pdfCreatTimeTo':$("#pdfCreatTimeEnd").val(),
			'userId':'10000'
	};
	$("#pageNum").val("");
	getData(bodyid,flag,queryCondition);
}

//跳转页
function goPage(bodyid,flag){
	var queryCondition = {
			'limit':$("#perPageRecord").val(),
			'page':parseInt($("#pageNum").val())>=parseInt($("#allPage").val())?parseInt($("#allPage").val())-1:parseInt($("#pageNum").val())-1,
//			'offset':(parseInt($("#pageNum").val())-1)*parseInt($("#perPageRecord").val()),
			'orderNum':$("#orderNum").val(),
			'tcNumTc':$("#tcNumTc").val(),
			'accpCtrolId':$("#accpCtrolId").val(),
			'packNum':$("#packNum").val(),
			'prodcode':$("#prodcode").val(),
			'accpAuthority':$("#accpAuthority").val(),
			'factory':$("#factory").val(),
			'impactNum':$("#impactNum").val(),
			'pdfCreatTimeFrom':$("#pdfCreatTimeBegin").val(),
			'pdfCreatTimeTo':$("#pdfCreatTimeEnd").val(),
			'userId':'10000'
	};
	$("#pageNum").val("");
	getData(bodyid,flag,queryCondition);
}

//每页显示记录数调整
function perPage(bodyid,flag){
	var queryCondition = {
			'limit':$("#perPageRecord").val(),
			'page':"0",
//			'offset':"0",
			'orderNum':$("#orderNum").val(),
			'tcNumTc':$("#tcNumTc").val(),
			'accpCtrolId':$("#accpCtrolId").val(),
			'packNum':$("#packNum").val(),
			'prodcode':$("#prodcode").val(),
			'accpAuthority':$("#accpAuthority").val(),
			'factory':$("#factory").val(),
			'impactNum':$("#impactNum").val(),
			'pdfCreatTimeFrom':$("#pdfCreatTimeBegin").val(),
			'pdfCreatTimeTo':$("#pdfCreatTimeEnd").val(),
			'userId':'10000'
	};
	$("#pageNum").val("");
	getData(bodyid,flag,queryCondition);
}



//行展开
function expandRow(id,orderNum){
	$("#imgUid"+id).attr("src",contextpath+"/style/defaultStyle/images/b_icon_01.gif");
	$("#imgUid"+id).attr("onclick","packRow('"+id+"','"+orderNum+"')");
	$("#sid"+id).append("<td colspan=13>" +
							"<table border=0 width=98% align='right'>" +
//								"<tr>" +
////									"<td width='3%><div style='display:none'></td></td>" +
//									"<td width='10%' class='infor_title'>捆包号</td>" +
//									"<td width='10%' class='infor_title'>卖方公司</td>" +
//									"<td width='8%' class='infor_title'>品种代码</td>" +
//									"<td width='15%' class='infor_title'>品种名称</td>" +
//									"<td width='10%' class='infor_title'>牌号</td>" +
//									"<td width='22%' class='infor_title'>规格</td>" +
//									"<td width='10%' class='infor_title'>包装方式</td>" +
//									"<td width='12%' class='infor_title'>净重</td>" +
//								"</tr>" +
							"<tr>" +
//						"<td width='3%><div style='display:none'></td></td>" +
						"<td width='10%'>捆包号</td>" +
						"<td width='10%'>卖方公司</td>" +
						"<td width='8%'>品种代码</td>" +
						"<td width='15%'>品种名称</td>" +
						"<td width='10%'>牌号</td>" +
						"<td width='22%'>规格</td>" +
						"<td width='10%'>包装方式</td>" +
						"<td width='12%'>净重</td>" +
					"</tr>" +
								"<tr id=trid"+id+">" +
								"</tr>" +
							"</table>" +
						"</td>");

	$.ajax({ 
			type: "POST", 
			url: contextpath+"/queryPackInfo/"+orderNum,
			data: "{}", 
			contentType: "application/json", 
			dataType: 'json',
			cache:true,
			success: function(data) { 
				 $.each(data.packages,function(entryindex,entry){
            var html='<tr>';
            html+='<td>'+entry['packId']+'</td>';
            html+='<td>'+entry['companyCode']+'</td>';
            html+='<td>'+entry['productType']+'</td>';
            html+='<td>'+entry['productName']+'</td>';
            html+='<td>'+entry['shopsignName']+'</td>';
            html+='<td>'+entry['specDesc']+'</td>';
            html+='<td>'+entry['wrapMode']+'</td>';
            html+='<td align=right>'+entry['netWeight']+'</td>';
            html+='</tr>';
            $('#trid'+id).after(html);
        });
			}
		});
}
//行收缩
function packRow(id,orderNum){
	$("#imgUid"+id).attr("src",contextpath+"/style/defaultStyle/images/b_icon.gif");
	$("#imgUid"+id).attr("onclick","expandRow('"+id+"','"+orderNum+"')");
	$("#sid"+id).empty();
}

//查询按钮
button_query_onclick = function(){
	firstPage("tbody",$("#hidtab").val());
	$("#hidtab").val($("#hidtab").val());
}

button_clear_onclick = function(){
	$("input[name$='-i0']").val("");
	$("select[name$='-i0']").val("");
}

//tab按钮
tab_query_onclick = function(flag,tabid){
	firstPage("tbody",flag);
	$("#hidtab").val(flag);
	
	//修改当前css
	if(tabid == "tab0"){
		$("#tab0").toggleClass("TabbedPanelsTabSelected");
		if($("#tab1").attr("class") != "TabbedPanelsTab")
			$("#tab1").toggleClass("TabbedPanelsTabSelected");
		if($("#tab2").attr("class") != "TabbedPanelsTab")
			$("#tab2").toggleClass("TabbedPanelsTabSelected");
	}else if(tabid == "tab1"){
		$("#tab1").toggleClass("TabbedPanelsTabSelected");
		if($("#tab0").attr("class") != "TabbedPanelsTab")
			$("#tab0").toggleClass("TabbedPanelsTabSelected");
		if($("#tab2").attr("class") != "TabbedPanelsTab")
			$("#tab2").toggleClass("TabbedPanelsTabSelected");
	}else if(tabid == "tab2"){
		$("#tab2").toggleClass("TabbedPanelsTabSelected");
		if($("#tab1").attr("class") != "TabbedPanelsTab")
			$("#tab1").toggleClass("TabbedPanelsTabSelected");
		if($("#tab0").attr("class") != "TabbedPanelsTab")
			$("#tab0").toggleClass("TabbedPanelsTabSelected");
	}
	
//	if(tabid == "tab0"){
//		document.getElementById('tab0').className = "TabbedPanelsTabSelected";
//		document.getElementById('tab1').className = "TabbedPanelsTab";
//		document.getElementById('tab2').className = "TabbedPanelsTab";
//	}else if(tabid == "tab1"){
//		document.getElementById('tab0').className = "TabbedPanelsTab";
//		document.getElementById('tab1').className = "TabbedPanelsTabSelected";
//		document.getElementById('tab2').className = "TabbedPanelsTab";
//	}else if(tabid == "tab2"){
//		document.getElementById('tab0').className = "TabbedPanelsTab";
//		document.getElementById('tab1').className = "TabbedPanelsTab";
//		document.getElementById('tab2').className = "TabbedPanelsTabSelected";
//	}

}

//加载会签部门
var accpAuthority = "<option selected='selected' value=''>全部</option>" 
		+"<%for (var i = 0; i < checkOrgs.length; i++) { %>"
		+"<option value='<%=checkOrgs[i].orgCode %>'><%=checkOrgs[i].orgName %></option>"
		+"<%}%>"
		
//初始化用户信息
var userInfo = "<%=userId %>&nbsp;&nbsp;<%=userName %><span class='white'>您好！ </span><span class='yellow'><%=orgName %></span><span class='white'>为您服务！</span>";


function getUser(id,accpId){
	$.ajax({ 
			type: "POST", 
			url: contextpath+"/getUser/10000",
			//data: data, 
			contentType: "application/json", 
			dataType: 'json',
			cache:true,
			success: function(data) { 
				$('#'+id).empty();	
				var render = template.compile(userInfo);
				var html = render(data);
				$('#'+id).append(html);
				
				$('#'+accpId).empty();	
				var render1 = template.compile(accpAuthority);
				var html1 = render1(data);					
				$('#'+accpId).append(html1);
        
			}
		});
}
