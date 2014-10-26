<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import ="java.util.List,tyokin.SavingMoney" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="public/animate.css">
<title>top</title>
</head>
<body align="center">
<a href="setting.html"><p align="right">設定画面</p></a>
<h1>
目標
<%=request.getAttribute("target") %>
<br>
目標金額
<%=request.getAttribute("money") %>円
<br>
</h1>
<form action="../kr1/Regist" method="post">
<input type="text" name="memo">で
<input type="text" name="money">円
<input type="submit" value="節約！" style="font-size:30px">
</form>
<br>

<table align="center">

<%
	List<SavingMoney> list = (List<SavingMoney>)request.getAttribute("savingMoneyList");
  	for(int i=0;i<list.size();i++){
  		SavingMoney account = list.get(i);
%>
	<tr class="animated fadeInDown">
		<td><%=account.getDate() %></td>
		<td><%=account.getMemo() %>で</td>
		<td><%=account.getMoney() %>円の節約</td>
<%
  }
%>
</table>
<br>
現在の合計節約金額は
<%=request.getAttribute("sum") %>
円
<br>
<br>

<%=request.getAttribute("stutas") %>
</body>
</html>