var JSONP = {
	get : function(url, params, callback, ajaxMode) {
		if (ajaxMode != false) {
			ajaxMode = true;
		}
		$.ajax({
			type:"GET", 
			async:ajaxMode, 			
			url:url, 
			data:params, 
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			dataType:"jsonp",
			cache:true,		
			success:callback
		});
	}
};