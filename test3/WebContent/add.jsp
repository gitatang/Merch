<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<form action="merch/merchAdd" method="post">
<body>
		<table>
  <tr>
   		<td>名称</td>
   		<td><input type="text" name="name"></td>
  </tr>
  <tr>
   		<td>代码</td>
   		<td><input type="text" name="cade"></td>
  </tr>
  <tr>
   		<td>厂商</td>
   		<td><input type="text" name="factory"></td>
  </tr>
  <tr>
   		<td>包装类型</td>
   		<td><input type="text" name="packages"></td>
  </tr>
   <tr>
   		<td>价格</td>
   		<td><input type="text" name="price"></td>
  </tr>
   <tr>
   		<td><button>保存</button></td>
   		
  </tr>
</table>
		
</form>
<td><a href="http://localhost:8080/test3/index.jsp"><button>返回</button></a></td>
</body>
</html>