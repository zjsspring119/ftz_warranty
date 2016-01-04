function queryResource(url) {
//	  var pz_value =[];      //品种
//	  $('input[id="pz"]:checked').each(function(i){   
//		  pz_value.push($(this).val());
//	  });   
//	  var cd_value = [];    //产地
//	  $('input[id="cd"]:checked').each(function(i){   
//		  cd_value[i]=$(this).val();
//	  });  
//	  var hz_value = [];    // 卖家
//	  $('input[id="hz"]:checked').each(function(i){   
//		  hz_value[i]=$(this).val();
//	  });  
//	  var syrjc_value = [];    // 特钢
//	  $('input[id="syrjc"]:checked').each(function(i){   
//		  syrjc_value[i]=$(this).val();
//	  });  
//	  var big_value = [];    // 大品种
//	  $('input[id="bigProductTypeId"]:checked').each(function(i){   
//		  big_value[i]=$(this).val();
//	  });  
//	  var small_value = [];    // 小品种
//	  $('input[id="productTypeId"]:checked').each(function(i){   
//		  small_value[i]=$(this).val();
//	  });  
//	  var gradePic_value = [];    // 等级
//	  $('input[id="gradePic"]:checked').each(function(i){   
//		  gradePic_value[i]=$(this).val();
//	  });  
//	  var coating_value = []; 	//涂层结构
//	  $('input[id="coating"]:checked').each(function(i){   
//		  coating_value[i]=$(this).val();
//	  });  
//	  var coatWeight_value = [];  //锌层
//	  $('input[id="zinc"]:checked').each(function(i){   
//		  coatWeight_value[i]=$(this).val();
//	  }); 
//	  var cz2_value = [];  //牌号多选
//	  $('input[id="cz2"]:checked').each(function(i){   
//		  cz2_value[i]=$(this).val();
//	  }); 
//	  var paintTypeTC_value = [];    //涂料类型
//	  $('input[id="paint"]:checked').each(function(i){   
//		  paintTypeTC_value[i]=$(this).val();
//	  }); 
//	  var apn_value = [];  //用途分类
//	  $('input[id="use"]:checked').each(function(i){   
//		  apn_value[i]=$(this).val();
//	  }); 
	  
	var queryCondition = {
//		   'pz':pz_value.join(","),
//			'cd' :cd_value.join(","),
//			'hz' :hz_value.join(","),
//			'pm' :$("#pm").val(),
//			'ggxs1Min' :"" != $.trim($("#ggxs1Min").val()) ? $("#ggxs1Min").val() : null,
//			'ggxs1Max' :"" != $.trim($("#ggxs1Max").val()) ? $("#ggxs1Max").val() : null,
//			'ggxs2Min' :"" != $.trim($("#ggxs2Min").val()) ? $("#ggxs2Min").val() : null,
//			'ggxs2Max' :"" != $.trim($("#ggxs2Max").val()) ? $("#ggxs2Max").val() : null,
//			'ggxs3Min' :"" != $.trim($("#ggxs3Min").val()) ? $("#ggxs3Min").val() : null,
//			'ggxs3Max' :"" != $.trim($("#ggxs3Max").val()) ? $("#ggxs3Max").val() : null,
//			'dj3Min' :"" != $.trim($("#dj3Min").val()) ? $("#dj3Min").val() : null,
//			'dj3Max' :"" != $.trim($("#dj3Max").val()) ? $("#dj3Max").val() : null,
//			'sl2Min' :"" != $.trim($("#sl2Min").val()) ? $("#sl2Min").val() : null,
//			'sl2Max' :"" != $.trim($("#sl2Max").val()) ? $("#sl2Max").val() : null,
//			
//			'qt' :$("#qt").val(),
//			'flag' :typeof($('input[id="flag"]:checked').val())  ==  "undefined" ? null : $('input[id="flag"]:checked').val(),
//			'isImport' :$("#isimport").val(),
//			'wzstr1' :$("#wzstr1").val(),
//			'wzstr4' :$("#wzstr4").val(),
//			'bigProductTypeId' :big_value.join(","),
//			'productTypeId' :small_value.join(","),
//			'dq' :$("#dq").val(),
//			'ck' :$("#ck").val(),
//			'producingAreashort' :$("#producingAreashort").val(),
//		    'newFlag' :typeof($('input[id="newflag"]:checked').val())  ==  "undefined" ? null : $('input[id="newflag"]:checked').val(),
//			'gradePic' :gradePic_value.join(","),
//			'syrjc' :syrjc_value.join(","),
//			'markert' :$("#markert").val(),
//			'fszt' :$("#fszt").val(),
//			'wzly' :$("#wzly").val(),
//			'asscustomerIdFlag' :$("#asscustomerIdFlag").val(),
//			'asscustomerId' :$("#asscustomerId").val(),
//			
//			'sortName' :$("#sortName").val(),
//			'sortValue' :$("#sortValue").val(),
//			'offset':$.trim($("#offset").val()),
//			'limit': $.trim($("#limit").val()),
//			'count':$.trim($("#count").val()),
//			
//			'coatStructure':coating_value.join(","),
//			'coatWeight':coatWeight_value.join(","),
//			'cz':cz2_value.join(","),
//			'paintTypeTC':paintTypeTC_value.join(","),
//			'apnChinese':apn_value.join(","),
//			'color':$.trim($("#color").val()),
//			'flag1':typeof($('input[id="flag1"]:checked').val())  ==  "undefined" ? null : $('input[id="flag1"]:checked').val(),
//			'htfphm':$.trim($("#htfphm").val()),
//			'basicType':$.trim($("#basicType").val()),
			'cdh':$("#cdh").val()
	};
	
	JSONP.get(url+"/queryWarranty",queryCondition,function(data){
		var table = document.getElementById("resTable");
			setTableInnerHTML(table,"");
			var resList = data.resourceList;
			if(resList != null && resList.length > 0){
				var resTable = "<tr><td>仓单号</td><td>货主名称</td></tr>";
				for(var i = 0; i<resList.length;i++){
					var res = resList[i];
					resTable += "<tr><td>"+res.warrantyNo+"</td><td>"+res.customerName+"</td></tr>";
				}
				resTable += "<tr colspan='11'>耗时："+data.times+"毫秒</tr>";
				setTableInnerHTML(table,resTable);
			}
	});
}


