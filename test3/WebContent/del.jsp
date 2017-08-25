
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<title>Insert title here</title>
</head>
<body>

<form action="merch/del" method="post">

id:<input type="text" name="id">
<input type="submit" value="删除" onclick="del">

</form>
<a href="http://localhost:8080/test3/index.jsp"><input type="submit" value="返回"></a>

</body>
</html>