<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="04_2urlEnd.jsp?name=강건강&age=20&gender=M&hobby=축구">쿼리스트링</a>
	<br/>
	<c:url value="04_2_urlEnd.jsp" var="u">
		<c:param name="name" value="남나눔"/>
		<c:param name="age" value="17"/>
		<c:param name="gender" value="M"/>
		<c:param name="hobby" value="꼿꼿이"/>
	</c:url>
	<a href="${ u }">jstl-url</a>
</html>