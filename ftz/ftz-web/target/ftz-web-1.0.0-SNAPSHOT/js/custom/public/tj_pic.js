
var autoParam = 2;
function getObject(objectId) {
	if(document.getElementById && document.getElementById(objectId)) {
		return document.getElementById(objectId);
	} else if (document.all && document.all(objectId)) {
		return document.all(objectId);
	} else if (document.layers && document.layers[objectId]) {
		return document.layers[objectId];
	} else {
		return false;
	}
}
function focusTab(n){
	for(var i=1;i<=5;i++){
		if (i==n){
			
			getObject('focusTable'+i).style.display='';
			getObject('changecolor'+i).style.color='#FF0000';
		}
		else {
			
			getObject('focusTable'+i).style.display='none';
			getObject('changecolor'+i).style.color='#000000';
		}
	}
}
function focusHandTab(n){
	
	for(var i=1;i<=5;i++){
		if (i==n){
			
			getObject('focusTable'+i).style.display='';
			getObject('changecolor'+i).style.color='#FF0000';
			autoParam = n+1;
		}
		else {
			
			getObject('focusTable'+i).style.display='none';
			getObject('changecolor'+i).style.color='#000000';
		}
	}
}
function autoFocusTab(num){
 try 
    { 
	if(autoParam >= num || autoParam >5){
	autoParam = 1;
	}
	//alert(autoParam);
	focusTab(autoParam);
	autoParam = autoParam+1;
	//alert(autoParam);
	
	 } 
    catch(ex)//catch the ex 
    { 
            autoParam = autoParam+1;
    } 
}

