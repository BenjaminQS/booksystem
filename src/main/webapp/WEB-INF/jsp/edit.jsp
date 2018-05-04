<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 <div style="width:500px;margin:0px auto;text-align:center">
	
	
	<div style="text-align:center;margin-top:40px">
		
		<form method="post" action="update">
			图书编号： <input name="bookId" value="${book.bookId}" type="text"> <br><br>
			图书名称： <input name="name" value="${book.name}" type="text"> <br><br>
			图书数量： <input name="number" value="${book.number}" type="text"> <br><br>
			图书详情： <input name="detail" value="${book.detail}" type="text"> <br><br>
			
			<input type="submit" value="修改">
		</form>

	</div>	
 </div>