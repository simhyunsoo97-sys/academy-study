<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>난 에러페이지임!</h1>
	<%= exception %>
	<%= exception.getClass().getName() %><br/>
	<%= exception.getMessage() %>
	
	<hr/>
	
	<h2>
		에러가 발생한 날짜는
		<span style="color: yellowgreen;"><%@ include file="../today.jsp" %></span>
	</h2>
	<% //String now = "3교시"; %>
</body>
</html>