<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Emp CRUD</title>
</head>

<body>
	<h1>Emp CRUD</h1>
	<s:if test="emp == null">
	  Add a Emp
	  <form action="empAction_add" method="post" name="f">
	    <input type="number" name="emp.empno" placeholder="雇员号"
	      min="8000" max="9999" required="required"><br>
	    <input type="text" name="emp.ename" placeholder="雇员名"
	      required="required" maxlength="10"><br>
	    <input type="date" name="emp.hiredate"><br>
	    <input type="number" name="emp.sal" placeholder="薪资"
	      step="0.01"><br>
	    <input type="submit" value="Add">
	  </form>
	</s:if>
	<s:else>
	  Modify a Emp
	  <form action="empAction_modify" method="post" name="f">
      <input type="number" name="emp.empno" readonly="readonly"
        value="${emp.empno }"><br>
      <input type="text" name="emp.ename" placeholder="雇员名"
        value="${emp.ename }" required="required" maxlength="10"><br>
      <input type="date" name="emp.hiredate" 
        value="${emp.hiredate }"><br>
      <input type="number" name="emp.sal" placeholder="薪资"
        value="${emp.sal }" step="0.01"><br>
      <input type="submit" value="Modify">
    </form>
	  
	  <!-- html 注释(客户端查看源码可见)  -->
	  <%-- jsp 注释(客户端查看源码不可见)
	  <s:form action="empAction_modify" method="post">
	    <s:textfield name="emp.empno" label="雇员号" readonly="true" />
	    <s:textfield name="emp.ename" label="雇员名" />
	    <s:textfield name="emp.hiredate" label="入职日期" />
	    <s:textfield name="emp.sal" label="薪资" />
	    <s:submit value="修改" />
	  </s:form>	 
	  --%> 
	</s:else>
</body>
</html>
