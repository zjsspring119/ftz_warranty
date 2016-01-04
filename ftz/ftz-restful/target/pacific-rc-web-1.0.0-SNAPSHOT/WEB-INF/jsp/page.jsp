<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<input type="hidden" id="offset"/>
<input type="hidden" id="allPage"/>
<input type="hidden" id="cPage"/>
<table id='page' cellspacing="0" border="0" align="right">
	<tr>
		<td id="currentPage">第&nbsp;0&nbsp;页&nbsp;&nbsp;</td>
		<td id="totalPageCount">共&nbsp;0&nbsp;页&nbsp;&nbsp;</td>&nbsp;
		<td id="allCount">共&nbsp;0&nbsp;条&nbsp;&nbsp;</td>&nbsp;
		<td>
			<input id="pageNum" type="text" size="1" value="" />
			<a onClick="javascript:goPage('tbody',$('#hidtab').val())">
				<span id="GoPage">&nbsp;&nbsp;&nbsp;&nbsp;</span>
			</a>
		</td>
		<td>
			<select  id="perPageRecord" name="perPageRecord" width="1"  onchange="perPage('tbody',$('#hidtab').val())">
				<option  value="10"  >10</option>
				<option  value="100" >100</option>
				<option  value="500" >500</option>
			</select>
		</td>
		<td><a onClick="javascript:firstPage('tbody',$('#hidtab').val())">
				<span id="firstPage">&nbsp;&nbsp;&nbsp;</span>
			</a>
		</td>
		<td><a onClick="javascript:prePage('tbody',$('#hidtab').val())">
				<span id="prePage">&nbsp;&nbsp;&nbsp;</span>
			</a>
		</td>
		<td><a onClick="javascript:nextPage('tbody',$('#hidtab').val())">
				<span id="nextPage">&nbsp;&nbsp;</span>
			</a>
		</td>
		<td><a onClick="javascript:lastPage('tbody',$('#hidtab').val())">
				<span id="lastPage">&nbsp;&nbsp;&nbsp;</span>
			</a>
		</td>
	</tr>
</table>