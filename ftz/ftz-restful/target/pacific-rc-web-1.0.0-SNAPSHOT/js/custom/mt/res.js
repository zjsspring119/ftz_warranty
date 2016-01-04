function queryResource(url) {
	  var pz_value =[];      //品种
	  $('input[id="pz"]:checked').each(function(i){   
		  pz_value.push($(this).val());
	  });   
	  var cd_value = [];    //产地
	  $('input[id="cd"]:checked').each(function(i){   
		  cd_value[i]=$(this).val();
	  });  
	  var hz_value = [];    // 卖家
	  $('input[id="hz"]:checked').each(function(i){   
		  hz_value[i]=$(this).val();
	  });  
	  var syrjc_value = [];    // 特钢
	  $('input[id="syrjc"]:checked').each(function(i){   
		  syrjc_value[i]=$(this).val();
	  });  
	  var big_value = [];    // 大品种
	  $('input[id="bigProductTypeId"]:checked').each(function(i){   
		  big_value[i]=$(this).val();
	  });  
	  var small_value = [];    // 小品种
	  $('input[id="productTypeId"]:checked').each(function(i){   
		  small_value[i]=$(this).val();
	  });  
	  var gradePic_value = [];    // 等级
	  $('input[id="gradePic"]:checked').each(function(i){   
		  gradePic_value[i]=$(this).val();
	  });  
	  var coating_value = []; 	//涂层结构
	  $('input[id="coating"]:checked').each(function(i){   
		  coating_value[i]=$(this).val();
	  });  
	  var coatWeight_value = [];  //锌层
	  $('input[id="zinc"]:checked').each(function(i){   
		  coatWeight_value[i]=$(this).val();
	  }); 
	  var cz2_value = [];  //牌号多选
	  $('input[id="cz2"]:checked').each(function(i){   
		  cz2_value[i]=$(this).val();
	  }); 
	  var paintTypeTC_value = [];    //涂料类型
	  $('input[id="paint"]:checked').each(function(i){   
		  paintTypeTC_value[i]=$(this).val();
	  }); 
	  var apn_value = [];  //用途分类
	  $('input[id="use"]:checked').each(function(i){   
		  apn_value[i]=$(this).val();
	  }); 
	  
	var queryCondition = {
		   'pz':pz_value.join(","),
			'cd' :cd_value.join(","),
			'hz' :hz_value.join(","),
			'pm' :$("#pm").val(),
			'ggxs1Min' :"" != $.trim($("#ggxs1Min").val()) ? $("#ggxs1Min").val() : null,
			'ggxs1Max' :"" != $.trim($("#ggxs1Max").val()) ? $("#ggxs1Max").val() : null,
			'ggxs2Min' :"" != $.trim($("#ggxs2Min").val()) ? $("#ggxs2Min").val() : null,
			'ggxs2Max' :"" != $.trim($("#ggxs2Max").val()) ? $("#ggxs2Max").val() : null,
			'ggxs3Min' :"" != $.trim($("#ggxs3Min").val()) ? $("#ggxs3Min").val() : null,
			'ggxs3Max' :"" != $.trim($("#ggxs3Max").val()) ? $("#ggxs3Max").val() : null,
			'dj3Min' :"" != $.trim($("#dj3Min").val()) ? $("#dj3Min").val() : null,
			'dj3Max' :"" != $.trim($("#dj3Max").val()) ? $("#dj3Max").val() : null,
			'sl2Min' :"" != $.trim($("#sl2Min").val()) ? $("#sl2Min").val() : null,
			'sl2Max' :"" != $.trim($("#sl2Max").val()) ? $("#sl2Max").val() : null,
			
			'qt' :$("#qt").val(),
			'flag' :typeof($('input[id="flag"]:checked').val())  ==  "undefined" ? null : $('input[id="flag"]:checked').val(),
			'isImport' :$("#isimport").val(),
			'wzstr1' :$("#wzstr1").val(),
			'wzstr4' :$("#wzstr4").val(),
			'bigProductTypeId' :big_value.join(","),
			'productTypeId' :small_value.join(","),
			'dq' :$("#dq").val(),
			'ck' :$("#ck").val(),
			'producingAreashort' :$("#producingAreashort").val(),
		    'newFlag' :typeof($('input[id="newflag"]:checked').val())  ==  "undefined" ? null : $('input[id="newflag"]:checked').val(),
			'gradePic' :gradePic_value.join(","),
			'syrjc' :syrjc_value.join(","),
			'markert' :$("#markert").val(),
			'fszt' :$("#fszt").val(),
			'wzly' :$("#wzly").val(),
			'asscustomerIdFlag' :$("#asscustomerIdFlag").val(),
			'asscustomerId' :$("#asscustomerId").val(),
			
			'sortName' :$("#sortName").val(),
			'sortValue' :$("#sortValue").val(),
			'offset':$.trim($("#offset").val()),
			'limit': $.trim($("#limit").val()),
			'count':$.trim($("#count").val()),
			
			'coatStructure':coating_value.join(","),
			'coatWeight':coatWeight_value.join(","),
			'cz':cz2_value.join(","),
			'paintTypeTC':paintTypeTC_value.join(","),
			'apnChinese':apn_value.join(","),
			'color':$.trim($("#color").val()),
			'flag1':typeof($('input[id="flag1"]:checked').val())  ==  "undefined" ? null : $('input[id="flag1"]:checked').val(),
			'htfphm':$.trim($("#htfphm").val()),
			'basicType':$.trim($("#basicType").val()),
			'rkrq':$("#rkrq").val()
	};
	
	JSONP.get(url+"/queryAllRes",queryCondition,function(data){
		var table = document.getElementById("resTable");
			setTableInnerHTML(table,"");
			/*var resTable = "sumSl2----"+data.sumSl2+" *******  minDj3----"+data.minDj3;
			setTableInnerHTML(table,resTable);*/
			var resList = data.resourceList;
			if(resList != null && resList.length > 0){
				var resTable = "<tr><td>合同发票号码</td><td>挂牌流水号</td><td>材质</td><td>品种</td><td>品名</td><td>产地</td><td>资源号</td>";
				resTable +=  "<td>涂层结构</td><td>涂层重量</td><td>入库日期</td><td>质量等级</td><td>单价</td></tr>";
				for(var i = 0; i<resList.length;i++){
					var res = resList[i];
					resTable += "<tr><td>"+res.htfphm+"</td><td>"+res.gpls+"</td><td>"+res.cz+"</td><td>"+res.dl+"</td><td>"+res.pm+"</td>";
					resTable += "<td>"+res.cd+"</td><td>"+res.zyh+"</td><td>"+res.coatStructure+"</td><td>"+res.coatWeight+"</td><td>"+res.rkrq+
					"</td><td>"+res.wzstr1+"</td><td>"+res.dj3+"</td></tr>";
				}
				resTable += "<tr colspan='11'>耗时："+data.times+"毫秒</tr>";
				setTableInnerHTML(table,resTable);
			}
	});
}


function queryResDetail(url){
	var queryCondition = {
			'htfphm' : $("#htfphm").val()
	};
	

	JSONP.get(url+"/detailResource",queryCondition,function(data){
			var table = document.getElementById("resTable");
			setTableInnerHTML(table,"");
			var resTable = "<tr><td>合同发票号码</td><td>挂牌流水号</td><td>材质</td><td>品种</td><td>品名</td><td>产地</td><td>资源号</td>";
			resTable +=  "<td>地区</td><td>货主名称</td><td>入库日期</td><td>质量等级</td></tr>";
			var res = data.resource;
			resTable += "<tr><td>"+res.htfphm+"</td><td>"+res.gpls+"</td><td>"+res.cz+"</td><td>"+res.dl+"</td><td>"+res.pm+"</td>";
			resTable += "<td>"+res.cd+"</td><td>"+res.zyh+"</td><td>"+res.dq+"</td><td>"+res.hzmc+"</td><td>"+res.rkrq+"</td><td>"+res.wzstr1+"</td></tr>";
			setTableInnerHTML(table,resTable);
	});
	
	
}

function resRecommend(url){
	var queryCondition = {
			'zyh' : $("#zyh").val(),
			'limit' : $("#count").val(),
			'page':$("#page").val()
	};
	JSONP.get(url+"/recommendRes",queryCondition,function(data){
		var table = document.getElementById("resTable");
		setTableInnerHTML(table,"");
		var resList = data.resourceList;
		if(resList != null && resList.length > 0){
			var resTable = "<tr><td>合同发票号码</td><td>挂牌流水号</td><td>材质</td><td>品种</td><td>品名</td><td>产地</td><td>资源号</td>";
			resTable +=  "<td>地区</td><td>货主名称</td><td>入库日期</td><td>质量等级</td></tr>";
			for(var i = 0; i<resList.length;i++){
				var res = resList[i];
				resTable += "<tr><td>"+res.htfphm+"</td><td>"+res.gpls+"</td><td>"+res.cz+"</td><td>"+res.dl+"</td><td>"+res.pm+"</td>";
				resTable += "<td>"+res.cd+"</td><td>"+res.zyh+"</td><td>"+res.dq+"</td><td>"+res.hzmc+"</td><td>"+res.rkrq+"</td><td>"+res.wzstr1+"</td></tr>";
			}
			setTableInnerHTML(table,resTable);
		}
	});
}

function init(url){
	JSONP.get(url+"/resGroupByDl",queryCondition,function(data){
		var resultDiv = document.getElementById("result");
		setTableInnerHTML(resultDiv,"");
		if(data != null){
			var list = data.groupDlList;
			var count = 0;
			var dl = "";
			for(var i = 0; i<list.length; i++){
				 dl = list[i];
				 dl += "<input type='checkBox' name='dl' id="+dl.id+" value="+dl.id+"/>"+dl.id;
				 count++;
				 if(count % 15 == 0){
					 	dl += "<br/><br/>";
				 }
			}
			setTableInnerHTML(resultDiv,dl);
		 } 
	});
}

function setTableInnerHTML(table, html) { 
	if(navigator && navigator.userAgent.match(/msie/i)){ 
		var temp = table.ownerDocument.createElement('div'); 
		temp.innerHTML = '<table><tbody>' + html + '</tbody></table>'; 
		if(table.tBodies.length == 0){ 
			var tbody=document.createElement("tbody"); 
			table.appendChild(tbody); 
		} 
		table.replaceChild(temp.firstChild.firstChild, table.tBodies[0]); 
	} else { 
		table.innerHTML=html; 
	} 
} 

