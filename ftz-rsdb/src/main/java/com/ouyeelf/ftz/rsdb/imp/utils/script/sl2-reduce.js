function(zyh, values){
	
	if(values.length>0){
		var zyhsResource=new Array();
		values.forEach(
				function(r){
					var zyhs={htfphm:0,sl2:0};
					if(r.htfphm!=undefined&&r.sl2!=undefined){
						zyhs.htfphm=r.htfphm;
						zyhs.sl2=r.sl2;
						zyhsResource.push(zyhs);
						r.zyhResource=zyhsResource;
					}
					
				}
			)
			
	}
	
	return {zyhsResource:zyhsResource};
}