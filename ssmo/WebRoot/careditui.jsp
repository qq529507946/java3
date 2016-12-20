<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTMLu>
<html>
  <head>
  	<meta charset="utf-8">
   <title>SSMO Demo</title>
  
  <body>
    <h1>SpringMVC - Spring - Mybatis - Oracle</h1>
    <form action="carController_save" method="post" name="f" id="form">
    	<input type="hidden" name="id" value="${car.id }">
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;车名:
    	<input class="easyui-textbox" name="name"
    		value="${car.name }" data-options="required:true"/><br><br>
    	&nbsp;销售日期:
    	<input class="easyui-datebox" name="saleDate"
    		value="${car.saleDate }"/><br><br>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格:
    	<input class="easyui-textbox" name="price"
    		value="${car.price }"/><br><br>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="submit" value="Save">
    </form>
    <script type="text/javascript">
    	$("#form").form({
    		url:'carui_save',
    		success:function(data){
    			if(data){
    				$.messager.show({
    					title: '提示',
    					msg: '保存销售汽车'+data+'成功'
    				});
    				$("#editCar").window("close",true);
    			}
    		}
    	});
    </script>
  </body>
</html>
