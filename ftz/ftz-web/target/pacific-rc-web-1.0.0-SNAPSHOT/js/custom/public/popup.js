function starts(lily){
popup=window.open(lily,"popup","width=421,height=500,toolbar=no,scrollbars=yes,resizable=yes")
popup.focus()
}
function start(lily){
popup=window.open(lily,"","width=421,height=500,toolbar=no,scrollbars=yes,resizable=yes")
popup.focus()
}
function openw(lily){
popup=window.open(lily,"open","width=700,height=500,toolbar=yes,scrollbars=yes,resizable=yes");
popup.focus();
}

function openCalendar(formName, fieldName)
{
	var w = null;
	w = window.open("/baokhb/common/calendar.jsp?parent_form_name=" + formName + "&parent_name=" + fieldName,"","status=0,width=225,height=210,left=" + (event.screenX-225) + ",top=" + (event.screenY-95));
}

function openCalendar_baobao(formName, fieldName)
{
	var w = null;
	w = window.open("/baokhb/common/calendar_baobao.jsp?parent_form_name=" + formName + "&parent_name=" + fieldName,"","status=0,width=225,height=210,left=" + (event.screenX-225) + ",top=" + (event.screenY-95));
}

function openCalendar_yearMonth(formName, fieldName)
{
	var w = null;
	w = window.open("/baokhb/common/calendar_yearMonth.jsp?parent_form_name=" + formName + "&parent_name=" + fieldName,"","status=0,width=225,height=210,left=" + (event.screenX-225) + ",top=" + (event.screenY-95));
}
  function openUrl(url){
         open(url,'','menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=0,resizable=0,height=320,width=540');
  }
   /*
   * Open a new popup window with the link
   * @param	url		link
   * @param	width	width of the new window
   * @param height	height of the new window
   * modifid by iDay
   */
  function openUrl(url,width,height){
	  leftx = screen.width/2 - width/2;
	  topx =  screen.height/2 - height/2;
         window.open(url,'','menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=auto,resizable=1,left=' + leftx + ',top=' + topx + ',height=' + height + ',width=' + width);
  }
