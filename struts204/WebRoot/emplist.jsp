<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Emp CRUD</title>
<script src="js/jquery-2.2.2.min.js"></script>
<script type="text/javascript">
	//加载完页面自动设置 tr 标签的颜色
	$(function() {
		$("tr").filter(":odd").css("background-color", "skyblue");
		$("tr").filter(":even").css("background-color", "white");
	});
	
	function removeEmp(empno,ename){
		//alert(empno+"  "+ename);
		if(window.confirm("是否确认删除:"+ename+" ?")){
			// 跳转形式删除
			// window.location.href="empAction_remove?emp.empno="+empno;
			
			// Ajax形式删除
			$.post("empAction_removeAjax",{"empno":empno},function(data){
				// alert(data+" "+eval("("+data+")").flag);
				if(eval("("+data+")").flag > 0) {
				  // 删除指定的dom元素
				  $("#"+empno).remove();
				}
			});
		}
	}
</script>
</head>

<body>
	<h1>Emp CRUD</h1>
  
  <s:a href="empedit.jsp">Add a Emp</s:a>
  <br><br>
  <form action="empAction_list" method="post" name="f">
    <input type="text" name="ename" placeholder="雇员名" size="6">
    <input type="date" name="sbeginDate">
    <input type="date" name="sendDate">
    <input type="submit" value="查询">
  </form>
  <br><br>
	<table border="1">
		<tr>
			<th>序号</th>
			<th>Empno</th>
			<th>Ename</th>
			<th>hiredate</th>
			<th>Sal</th>
			<th>操作</th>
		</tr>

		<!-- 迭代输出 emps 
	  emps = getEmps();
	  for (Emp emp : emps) {
      System.out.println(emp.getEname() + " " + emp.getSal() + " " + emp.getHiredate());
    }
	   -->

		<s:iterator var="emp" value="emps" status="rows">
			<tr id="<s:property value="#emp.empno" />">
				<!-- property标签输出指定的值 相当于out.println(emp.getEmpno()) 
	     # 引用 iterator 标签的变量名
	     -->
				<td><s:property value="#rows.index + 1" /></td>
				<td><s:property value="#emp.empno" /></td>
				<td><s:property value="#emp.ename" /></td>
				<td><s:date name="#emp.hiredate" format="yyyy-MM-dd" /></td>
				<td><s:property value="#emp.sal" /></td>
				<td>
				<!-- 设置url路径  类似于empAction_findById?emp.empno=7788-->
				<s:url var="findByIdUrl" action="empAction_findById">
				  <!-- 设置url的参数 -->
				  <s:param name="emp.empno" value="#emp.empno"/>
				</s:url>
				
				<!-- %{} 计算字符串的值 -->
				<s:a href="%{findByIdUrl}">Modify</s:a> 
				&nbsp;&nbsp; 
				<!-- JavaScript传入参数:数字不需要引用,字符串必需有引号 -->
				<a href="javaScript:removeEmp(<s:property value="#emp.empno" />,'<s:property value="#emp.ename" />')">Remove</a>				
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
