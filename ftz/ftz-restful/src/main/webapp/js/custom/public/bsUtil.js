

var CONTEXT_PATH ;
var EiCommunicator = {send:function (path, dataObj, sCallback, ajaxMode) {
	if (ajaxMode != true) {
		ajaxMode = false;
	}
	//var jsonEi = EiInfo2Json.prototype.EiInfo2JsonString(sEiInfo);
	$.ajax({type:"POST", 
			async:ajaxMode, 			
			//url:"<c:url value="+path+"/>", 
			url:path, 
			data:dataObj, 
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			//dataType: "text", 
			dataType:"json",
			cache:true,		
			beforeSend: function(req) {req.setRequestHeader("Accept", "application/json;text/plain;charset=UTF-8"); }, 
			success:function (msg) {
				//ajaxEi = Json2EiInfo.prototype.parseJsonObject(msg);				
				
				if ((typeof (sCallback) == "object") && (sCallback != null)) {
					if (typeof (sCallback.onSuccess) == "function") {
						//sCallback.onSuccess(ajaxEi);
						sCallback.onSuccess(msg);
					}
				}
			}, 
			error:function (xmlR, status, e) {
				//ajaxEi = null;
				if (typeof (sCallback) == "object") {
					if (typeof (sCallback.onFail) == "function") {
						sCallback.onFail(xmlR, status, e);
					}
				}
				
			}});
}, $send:function (sUrl, sContent, sCallback) {
	$.ajax({type:"POST", 
		async:false, 
		url:sUrl, 
		data:sContent, 
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		dataType:"json", 
		beforeSend: function(req) {req.setRequestHeader("Accept", "application/json;text/plain;charset=UTF-8"); }, 
		success:function (msg) {
		//ajaxEi = Json2EiInfo.prototype.parseJsonObject(msg);
		sCallback.onSuccess(msg);
	}, error:function (xmlR, status, e) {
		sCallback.onFail(xmlR, status, e);
	}});
}};
//将一个表单的数据返回成JSON对象   
$.fn.serializeObject = function() {   
  var o = {};   
  var a = this.serializeArray();   
  $.each(a, function() {   
    if (o[this.name]) {   
      if (!o[this.name].push) {   
        o[this.name] = [ o[this.name] ];   
      }   
      o[this.name].push(this.value || '');   
    } else {   
      o[this.name] = this.value || '';   
    }   
  });   
  return o;   
};   
//简单表单数据绑定
$.fn.simpleFormBind = function(model) {   
	var eles = $('input,select,textarea', this);
	$.each(eles, function() { 
		var fieldName = this.name;
		var fieldValue = eval("model."+fieldName);
		alert(fieldName+"="+fieldValue);
		if(fieldValue){
			var t = this.type, tag = this.tagName.toLowerCase();
			if (t == 'text' || t == 'password' || tag == 'textarea') {
				this.value = fieldValue;
			}
			else if (t == 'checkbox' || t == 'radio') {
				if(fieldValue == '1')
					this.checked = true;
			}
			else if (tag == 'select') {
				this.value = fieldValue;
			}
		}
	});
};
