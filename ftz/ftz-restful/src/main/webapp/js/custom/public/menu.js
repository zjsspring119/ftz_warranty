
var RightMenuUID = "";
/************һ���˵�����****************/
function spreadMenu(n){
	
//	for(var i=1;i<=n;i++){
//		var szSubMenuClassName = szSubMenuClassName+i;
//		szSubMenuClassName = document.getElementById('SubMenu'+i).className ;
//		document.getElementById('SubMenu'+i).className = 'SubMenuLayerHidden' ;
//		document.getElementById('ArrowLayer1Down').style.display = '' ;
//		document.getElementById('ArrowLayer1Right').style.display = 'none' ;
//	}
 var szSubMenuClassName1 = document.getElementById('SubMenu1').className ;
 document.getElementById('SubMenu1').className = 'SubMenuLayerHidden' ;
 document.getElementById('ArrowLayer1Down').style.display = '' ;
 document.getElementById('ArrowLayer1Right').style.display = 'none' ;
 
 var szSubMenuClassName2 = document.getElementById('SubMenu2').className ;
 document.getElementById('SubMenu2').className = 'SubMenuLayerHidden' ;
 document.getElementById('ArrowLayer2Down').style.display = '' ;
 document.getElementById('ArrowLayer2Right').style.display = 'none' ;
 
 var szSubMenuClassName3 = document.getElementById('SubMenu3').className ;
 document.getElementById('SubMenu3').className = 'SubMenuLayerHidden' ;
 document.getElementById('ArrowLayer3Down').style.display = '' ;
 document.getElementById('ArrowLayer3Right').style.display = 'none' ;
 
 var szSubMenuClassName4 = document.getElementById('SubMenu4').className ;
 document.getElementById('SubMenu4').className = 'SubMenuLayerHidden' ;
 document.getElementById('ArrowLayer4Down').style.display = '' ;
 document.getElementById('ArrowLayer4Right').style.display = 'none' ;
 
 var szSubMenuClassName5 = document.getElementById('SubMenu5').className ;
 document.getElementById('SubMenu5').className = 'SubMenuLayerHidden' ;
 document.getElementById('ArrowLayer5Down').style.display = '' ;
 document.getElementById('ArrowLayer5Right').style.display = 'none' ;
 
// var szSubMenuClassName6 = document.getElementById('SubMenu6').className ;
// document.getElementById('SubMenu6').className = 'SubMenuLayerHidden' ;
// document.getElementById('ArrowLayer6Down').style.display = '' ;
// document.getElementById('ArrowLayer6Right').style.display = 'none' ;



  
  
 switch (n){
 
  case 1 :
   if (szSubMenuClassName1 == 'SubMenuLayerHidden'){
    document.getElementById('SubMenu1').className = 'SubMenuLayer' ;
    document.getElementById('ArrowLayer1Down').style.display = 'none' ;
    document.getElementById('ArrowLayer1Right').style.display = '' ;
   }
   else{
    document.getElementById('SubMenu1').className = 'SubMenuLayerHidden' ;
    document.getElementById('ArrowLayer1Down').style.display = '' ;
    document.getElementById('ArrowLayer1Right').style.display = 'none' ;
   }
   break ;
 
  case 2 :
   if (szSubMenuClassName2 == 'SubMenuLayerHidden'){
    document.getElementById('SubMenu2').className = 'SubMenuLayer' ;
    document.getElementById('ArrowLayer2Down').style.display = 'none' ;
    document.getElementById('ArrowLayer2Right').style.display = '' ;
   }
   else{
    document.getElementById('SubMenu2').className = 'SubMenuLayerHidden' ;
    document.getElementById('ArrowLayer2Down').style.display = '' ;
    document.getElementById('ArrowLayer2Right').style.display = 'none' ;
   }
   break ;
 
  case 3 :
   if (szSubMenuClassName3 == 'SubMenuLayerHidden'){
    document.getElementById('SubMenu3').className = 'SubMenuLayer' ;
    document.getElementById('ArrowLayer3Down').style.display = 'none' ;
    document.getElementById('ArrowLayer3Right').style.display = '' ;
   }
   else{
    document.getElementById('SubMenu3').className = 'SubMenuLayerHidden' ;
    document.getElementById('ArrowLayer3Down').style.display = '' ;
    document.getElementById('ArrowLayer3Right').style.display = 'none' ;
   }
   break ;
 
  case 4 :
   if (szSubMenuClassName4 == 'SubMenuLayerHidden'){
    document.getElementById('SubMenu4').className = 'SubMenuLayer' ;
    document.getElementById('ArrowLayer4Down').style.display = 'none' ;
    document.getElementById('ArrowLayer4Right').style.display = '' ;
   }
   else{
    document.getElementById('SubMenu4').className = 'SubMenuLayerHidden' ;
    document.getElementById('ArrowLayer4Down').style.display = '' ;
    document.getElementById('ArrowLayer4Right').style.display = 'none' ;
   }
   break ;
 
  case 5 :
   if (szSubMenuClassName5 == 'SubMenuLayerHidden'){
    document.getElementById('SubMenu5').className = 'SubMenuLayer' ;
    document.getElementById('ArrowLayer5Down').style.display = 'none' ;
    document.getElementById('ArrowLayer5Right').style.display = '' ;
   }
   else{
    document.getElementById('SubMenu5').className = 'SubMenuLayerHidden' ;
    document.getElementById('ArrowLayer5Down').style.display = '' ;
    document.getElementById('ArrowLayer5Right').style.display = 'none' ;
   }
   break ;
 
//  case 6 :
//   if (szSubMenuClassName6 == 'SubMenuLayerHidden'){
//    document.getElementById('SubMenu6').className = 'SubMenuLayer' ;
//    document.getElementById('ArrowLayer6Down').style.display = 'none' ;
//    document.getElementById('ArrowLayer6Right').style.display = '' ;
//   }
//   else{
//    document.getElementById('SubMenu6').className = 'SubMenuLayerHidden' ;
//    document.getElementById('ArrowLayer6Down').style.display = '' ;
//    document.getElementById('ArrowLayer6Right').style.display = 'none' ;
//   }
//   break ;
   
 }
 

 if (SubMenu1.scrollHeight > 440  &&  screen.availHeight <= 600){
  SubMenu1.style.height = 440;
  SubMenu1.style.overflowY = 'scroll';
 }
}
/**********�����˵�����**********/
//function spreadSubMenu(k){
// 
// var szSubMenuClassName1 = document.getElementById('SubSubMenu1').className ;
// document.getElementById('SubSubMenu1').className = 'SubMenuLayerHidden' ;
// document.getElementById('ArrowSubLayer1Down').style.display = '' ;
// document.getElementById('ArrowSubLayer1Right').style.display = 'none' ;
// 
// var szSubMenuClassName2 = document.getElementById('SubSubMenu2').className ;
// document.getElementById('SubSubMenu2').className = 'SubMenuLayerHidden' ;
// document.getElementById('ArrowSubLayer2Down').style.display = '' ;
// document.getElementById('ArrowSubLayer2Right').style.display = 'none' ;
// 
// var szSubMenuClassName3 = document.getElementById('SubSubMenu3').className ;
// document.getElementById('SubSubMenu3').className = 'SubMenuLayerHidden' ;
// document.getElementById('ArrowSubLayer3Down').style.display = '' ;
// document.getElementById('ArrowSubLayer3Right').style.display = 'none' ;
// 
// var szSubMenuClassName4 = document.getElementById('SubSubMenu4').className ;
// document.getElementById('SubSubMenu4').className = 'SubMenuLayerHidden' ;
// document.getElementById('ArrowSubLayer4Down').style.display = '' ;
// document.getElementById('ArrowSubLayer4Right').style.display = 'none' ;
// 
// var szSubMenuClassName5 = document.getElementById('SubSubMenu5').className ;
// document.getElementById('SubSubMenu5').className = 'SubMenuLayerHidden' ;
// document.getElementById('ArrowSubLayer5Down').style.display = '' ;
// document.getElementById('ArrowSubLayer5Right').style.display = 'none' ;
// 
// var szSubMenuClassName6 = document.getElementById('SubSubMenu6').className ;
// document.getElementById('SubSubMenu6').className = 'SubMenuLayerHidden' ;
// document.getElementById('ArrowSubLayer6Down').style.display = '' ;
// document.getElementById('ArrowSubLayer6Right').style.display = 'none' ;
//  
// var szSubMenuClassName7 = document.getElementById('SubSubMenu7').className ;
// document.getElementById('SubSubMenu7').className = 'SubMenuLayerHidden' ;
// document.getElementById('ArrowSubLayer7Down').style.display = '' ;
// document.getElementById('ArrowSubLayer7Right').style.display = 'none' ;
//  
//  
// switch (k){
// 
// 
//  case 1 :
//   if (szSubMenuClassName1 == 'SubMenuLayerHidden'){
//    document.getElementById('SubSubMenu1').className = 'SubMenuLayer' ;
//    document.getElementById('ArrowSubLayer1Down').style.display = 'none' ;
//    document.getElementById('ArrowSubLayer1Right').style.display = '' ;
//   }
//   else{
//    document.getElementById('SubSubMenu1').className = 'SubMenuLayerHidden' ;
//    document.getElementById('ArrowSubLayer1Down').style.display = '' ;
//    document.getElementById('ArrowSubLayer1Right').style.display = 'none' ;
//   }
//   break ;
// 
//  case 2 :
//   if (szSubMenuClassName2 == 'SubMenuLayerHidden'){
//    document.getElementById('SubSubMenu2').className = 'SubMenuLayer' ;
//    document.getElementById('ArrowSubLayer2Down').style.display = 'none' ;
//    document.getElementById('ArrowSubLayer2Right').style.display = '' ;
//   }
//   else{
//    document.getElementById('SubSubMenu2').className = 'SubMenuLayerHidden' ;
//    document.getElementById('ArrowSubLayer2Down').style.display = '' ;
//    document.getElementById('ArrowSubLayer2Right').style.display = 'none' ;
//   }
//   break ;
// 
//  case 3 :
//   if (szSubMenuClassName3 == 'SubMenuLayerHidden'){
//    document.getElementById('SubSubMenu3').className = 'SubMenuLayer' ;
//    document.getElementById('ArrowSubLayer3Down').style.display = 'none' ;
//    document.getElementById('ArrowSubLayer3Right').style.display = '' ;
//   }
//   else{
//    document.getElementById('SubSubMenu3').className = 'SubMenuLayerHidden' ;
//    document.getElementById('ArrowSubLayer3Down').style.display = '' ;
//    document.getElementById('ArrowSubLayer3Right').style.display = 'none' ;
//   }
//   break ;
// 
//  case 4 :
//   if (szSubMenuClassName4 == 'SubMenuLayerHidden'){
//    document.getElementById('SubSubMenu4').className = 'SubMenuLayer' ;
//    document.getElementById('ArrowSubLayer4Down').style.display = 'none' ;
//    document.getElementById('ArrowSubLayer4Right').style.display = '' ;
//   }
//   else{
//    document.getElementById('SubSubMenu4').className = 'SubMenuLayerHidden' ;
//    document.getElementById('ArrowSubLayer4Down').style.display = '' ;
//    document.getElementById('ArrowSubLayer4Right').style.display = 'none' ;
//   }
//   break ;
// 
//  case 5 :
//   if (szSubMenuClassName5 == 'SubMenuLayerHidden'){
//    document.getElementById('SubSubMenu5').className = 'SubMenuLayer' ;
//    document.getElementById('ArrowSubLayer5Down').style.display = 'none' ;
//    document.getElementById('ArrowSubLayer5Right').style.display = '' ;
//   }
//   else{
//    document.getElementById('SubSubMenu5').className = 'SubMenuLayerHidden' ;
//    document.getElementById('ArrowSubLayer5Down').style.display = '' ;
//    document.getElementById('ArrowSubLayer5Right').style.display = 'none' ;
//   }
//   break ;
//  
//  case 6 :
//   if (szSubMenuClassName5 == 'SubMenuLayerHidden'){
//    document.getElementById('SubSubMenu6').className = 'SubMenuLayer' ;
//    document.getElementById('ArrowSubLayer6Down').style.display = 'none' ;
//    document.getElementById('ArrowSubLayer6Right').style.display = '' ;
//   }
//   else{
//    document.getElementById('SubSubMenu6').className = 'SubMenuLayerHidden' ;
//    document.getElementById('ArrowSubLayer6Down').style.display = '' ;
//    document.getElementById('ArrowSubLayer6Right').style.display = 'none' ;
//   }
//   break ; 
//   
//  case 7 :
//   if (szSubMenuClassName7 == 'SubMenuLayerHidden'){
//    document.getElementById('SubSubMenu7').className = 'SubMenuLayer' ;
//    document.getElementById('ArrowSubLayer7Down').style.display = 'none' ;
//    document.getElementById('ArrowSubLayer7Right').style.display = '' ;
//   }
//   else{
//    document.getElementById('SubSubMenu7').className = 'SubMenuLayerHidden' ;
//    document.getElementById('ArrowSubLayer7Down').style.display = '' ;
//    document.getElementById('ArrowSubLayer7Right').style.display = 'none' ;
//   }
//   break ;  
// }
// 
//
// if (SubSubMenu1.scrollHeight > 440  &&  screen.availHeight <= 600){
//  SubSubMenu1.style.height = 440;
//  SubSubMenu1.style.overflowY = 'scroll';
// }
//}

//初始化菜单
var menu1 = "<%for (var i = 0; i < subMenus.length; i++) { %>"
	+"<div onClick='javascript:spreadMenu(<%=i+1 %>)' class='MenuLevel1'>" +
			"<span id='ArrowLayer<%=i+1 %>Down' style='display:inline ; ' class='<%=subMenus[i].id %>'></span>" +
			"<span id='ArrowLayer<%=i+1 %>Right' style='display:none ;' class='<%=subMenus[i].id %>_over'></span>" +
	 "</div>"
	+"<div id='SubMenu<%=i+1 %>' class='SubMenuLayerHidden' style='overflow-y:block;'>"
	+"<%for (var j = 0; j < subMenus[i].menuItems.length; j++) {%>"
	+"<a class='MenuLevel4' href='"+contextpath+"<%=subMenus[i].menuItems[j].uri %>'  target='_self' id='link101'   onblur='blurChangeColor(this)'  onfocus='focusChangeColor(this)' onmouseover='mouseoverChangeColor(this)' onmouseout='mouseoutChangeColor(this)'>·<%=subMenus[i].menuItems[j].label %></a>"
	+"<% } %>"
	+"<img src='"+contextpath+"/style/defaultStyle/images/menu_bg_over_c.gif' /></div>"
	+"<% } %>"; 


function getMenu(bodyid){
	$.ajax({ 
			type: "POST", 
			url: contextpath+"/initMenu",
			//data: data, 
			contentType: "application/json", 
			dataType: 'json',
			cache:true,
			success: function(data) { 
				$('#'+bodyid).empty();	
				var render = template.compile(menu1);
				var html = render(data);
				$('#'+bodyid).append(html);
        
			}
		});
}

