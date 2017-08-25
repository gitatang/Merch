<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">



</script>

    <table border="1px">
		<tr>
		 <td>序号</td>
		 <td>名称</td>
		 <td>代码</td>
		 <td>厂商</td>
		 <td>包装类型</td>
		 <td>价格</td>
		</tr>
		<tr>
			<td>${merch.id}</td>
			<td>${merch.name}</td>
			<td>${merch.cade }</td>
			<td>${merch.factory }</td>
			<td>${merch.packages }</td>
			<td>${merch.price }</td>
			
		</tr>	
		
	</table>
	<a href="http://localhost:8080/test3/index.jsp"><input type="submit" value="返回"></a>
</body>
</html>