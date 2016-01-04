function(key, value){
	
     if(value.htfphm!=null){
    	 var zyhs={htfphm:0,sl2:0};
    	 var zyhsResource=[];
    	 zyhs.htfphm=value.htfphm;
    	 zyhs.sl2=value.sl2;
    	 zyhsResource.push(zyhs);
    	 value.zyhsResource=zyhsResource;
    	 return {zyhsResource:zyhsResource};
     }else{
    	 return value;
     }
     
}