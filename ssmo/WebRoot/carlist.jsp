<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTMLu>
<html>
  <head>
  	<meta charset="utf-8">
   <title>SSMO Demo</title>
    <script src="${pageContext.request.contextPath }/resources/js/jquery-2.2.2.min.js"></script>
   <script type="text/javascript">
	//加载完页面自动设置 tr 标签的颜色
	$(function() {
		$("tr").filter(":odd").css("background-color", "skyblue");
		$("tr").filter(":even").css("background-color", "white");
	});
	</script>
  <body>
    <h1>SpringMVC - Spring - Mybatis - Oracle</h1>
    <img alt="hzw" src="${pageContext.request.contextPath }/resources/images/u=2375608873,1466798716&fm=21&gp=0.jpg">
    <form action="carController_find" method="post" name="f">
    	<input type="text" name="name" placeholder="Name"/>
    	<input type="date" name="beginDate" placeholder="开始时间"/>
    	<input type="date" name="endDate" placeholder="结束时间"/>
    	<input type="submit" value="go">
    </form>
    <table border="1">
    	<tr>
    		<th>ID</th>
    		<th>NAME</th>
    		<th>Sale Date</th>
    		<th>Price</th>
    		<th>操作</th>
    	</tr>
    	<c:forEach var="car" items="${requestScope.cars }">
    	<tr>
    		<td>${car.id }</td>
    		<td>${car.name }</td>
    		<td>
    			<f:formatDate value="${car.saleDate }" pattern="yyyy-MM-dd"/>
    		</td>
    		<td>${car.price }</td>
    		<td><a href="carController_findById?id=${car.id }">Modify</a>
    		&nbsp;&nbsp; 
    			<a href="carController_remove?id=${car.id }" onclick="return confirm('是否删除${car.name }?')">Remove</a></td>
    	</tr>
    	</c:forEach>
    </table>
    <a href="caredit.jsp">Go</a>
  </body>
</html>
