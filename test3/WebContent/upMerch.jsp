<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="http://localhost:8080/test3/merch/update" method="post">
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
			<td><input type="text" name="id" readonly="readonly"  value="${merch.id}"></td>
			<td><input type="text" name="name" value="${merch.name}"></td>
			<td><input type="text" name="cade" value="${merch.cade}"></td>
			<td><input type="text" name="factory" value="${merch.factory}"></td>
			<td><input type="text" name="packages" value="${merch.packages}"></td>
			<td><input type="text" name="price" value="${merch.price}"></td>
			
		</tr>	
		
	</table>
	<input type="submit" value="更新"/>
</form>

<a href="http://localhost:8080/test3/index.jsp">返回</a>
</body>
</html>