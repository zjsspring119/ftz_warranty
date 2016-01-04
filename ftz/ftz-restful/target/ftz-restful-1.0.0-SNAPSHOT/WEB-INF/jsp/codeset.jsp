<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="bs" tagdir="/WEB-INF/tags" %>
<html>
<header>
</header>
<body>
<h2>代码查询</h2>
<div id="contain">
		<bs:CodeSetTable id="codesetCode" name="codesetCode" isEdit="false" tableData="${codesetList}"
									colNames="选择,代码集编码 ,代码集名称,代码集英文名称,备注,操作"/>
	<div>
	<ul>
	<li>customer:</li>
	<c:forEach var="rowData" items="${customerList}" varStatus="i" >
	<li>${rowData.userName}.${rowData.realName}
	</li>
	</c:forEach>
	</ul>
	</div>
	<ul>
	<li>user:</li>
	<c:forEach var="rowData" items="${userList}" varStatus="i" >
	<li>${rowData.userName}.${rowData.orgName}
	</li>
	</c:forEach>
	</ul>
	</div>
</div>

</body>
</html>
<script type="text/javascript">

</script>
