<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>导入数据库XLS文件</title>
</head>
<body>
    <h1>上传质保书、验签及捆包文件（支持Excel和CSV格式文件）</h1>
        <form method="post"
            action="upload"
            enctype="multipart/form-data">
            
          	  配置信息：<a id="showa" href="javascript:show()">[+]</a><br/>
          	  	<table  id="config" style="display: none;">
          	  		<tr>
          	  			<td>IP地址：</td><td><input type="text" name="ip" value="127.0.0.1"/></td>
          	  		</tr>
          	  		<tr>
          	  			<td>端口：</td><td><input type="text" name="port" value="27017"/></td>
          	  		</tr>
          	  		<tr>
          	  			<td>数据库名称:</td><td><input type="text" name="dbname" value="antelope"/></td>
          	  		</tr>
          	  		<tr>
          	  			<td>用户名:</td><td><input type="text" name="username"/></td>
          	  		</tr>
          	  		<tr>
          	  			<td>密码:</td><td><input type="text" name="password"/></td>
          	  		</tr>
          	  	</table>
            	<br/><br/>
            	删除旧数据<input type="checkbox" name="dropCheck" onchange="changeDrop(this)"/><input type="hidden" id="drop" name="drop" value="0"/><br/>
            	PDF数据：<input type="file" name="pdf_info"/><br/>
            	验签数据：<input type="file" name="pdf_certificate"/><br/>
            	捆包数据：<input type="file" name="tpl_trans_pack"/><br/>

            <input type="submit" value="上传"/>
            <input type="reset"/>
        </form>
        
        <script type="text/javascript">
        	function $(id){
        		return document.getElementById(id);
        	}
        	function show(){
        		if ($("showa").innerHTML == "[+]"){
        			$("config").style.display="inline";
        			$("showa").innerHTML = "[-]";
        		}else{
        			$("config").style.display="none";
        			$("showa").innerHTML = "[+]";
        		}
        	}
        	function changeDrop(obj){
        		if (obj.checked){
        			$("drop").value = 1;
        		}else{
        			$("drop").value = 0;
        		}
        	}
        </script>
        
</body>
</html>