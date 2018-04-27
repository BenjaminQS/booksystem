<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
<title>修改商品信息</title>
</head>

<body> 
<form>
<table width="100%" border=1>
<tr>
	<td>BookId</td>
	<td><input type="text" name="bookId" value=""/></td>
	
</tr>
<tr>
	<td>BookName</td>
	<td><input type="text" name="name" value=""/></td>
</tr>
<tr>
	<td>BookNumber</td>
	<td><input type="text" name="number"  value=""/></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>
</form>
</body>
</html>