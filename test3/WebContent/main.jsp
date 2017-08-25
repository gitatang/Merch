<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script language="Javascript" src="http://www.fusioncharts.com/free/demos/Blueprint/FusionCharts/FusionCharts.js">
</script>　 -->

<script type="text/javascript" src="../js/FusionCharts.js">
</script>
<script type="text/javascript" src="../js/jquery.min.js"></script>
 <script type="text/javascript">
var json = <%=request.getAttribute("json")%>;

$(function () {
    var column3D = new FusionCharts("../FusionCharts/FusionCharts/Column3D.swf", "myChartId", "100%", "520", "0");
    var json = <%=(String)request.getAttribute("json")%>;

    column3D.setJSONData(json);

    column3D.render("chart1div");
});
</script>  
<title>Insert title here</title>
</head>
<body>

    <table border="1px">
		<tr>
		 <td>序号</td>
		 <td>名称</td>
		 <td>代码</td>
		 <td>厂商</td>
		 <td>包装类型</td>
		 <td>价格</td>
		</tr>
		<c:forEach items="${requestScope.pagemsg.lists }" var="l">
		<tr>
			<td id="id">${l.id }</td>
			<td id="name">${l.name}</td>
			<td id="cade">${l.cade }</td>
			<td id="factory">${l.factory }</td>
			<td id="packages">${l.packages }</td>
			<td id="price">${l.price }</td>
			
		</tr>	
		
		</c:forEach>
		
	</table>
	
	 <span>第${requestScope.pagemsg.currPage }/ ${requestScope.pagemsg.totalPage}页</span>&nbsp;&nbsp;
   <span>总记录数：${requestScope.pagemsg.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagemsg.pageSize}</span>&nbsp;&nbsp;
   <span>
       <c:if test="${requestScope.pagemsg.currPage != 1}">
           <a href="${pageContext.request.contextPath }/merch/main?currentPage=1">[首页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/merch/main?currentPage=${requestScope.pagemsg.currPage-1}">[上一页]</a>&nbsp;&nbsp;
       </c:if>

       <c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">
           <a href="${pageContext.request.contextPath }/merch/main?currentPage=${requestScope.pagemsg.currPage+1}">[下一页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/merch/main?currentPage=${requestScope.pagemsg.totalPage}">[尾页]</a>&nbsp;&nbsp;
       </c:if>
   </span>
   
   
  <div id="chart1div"></div>  
	<a href="http://localhost:8080/test3/index.jsp"><input type="submit" value="返回"></a>

        <form action="http://localhost:8080/test3/merch/excel" method="post">
        <button>上传</button>
        
        </form>
        
            <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase=http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="600" height="500" id="Column3D" >     
             <param name="movie" value="../FusionCharts/FusionCharts/Column3D.swf" />     
             <param name="FlashVars" value="&dataURL=../FusionCharts/datas/Data.xml&chartWidth=600&chartHeight=500">     
             <param name="quality" value="high" />     
            <embed src="../FusionCharts/FusionCharts/Column3D.swf" flashVars="&dataURL=../FusionCharts/datas/Data.xml&chartWidth=600&chartHeight=500" quality="high" width="600" height="500" name="Column3D" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />     
          </object>    
        
	
</body>

</html>