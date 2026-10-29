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
	<h3>c:forEach</h3>
	<!-- for(int i =1; i <= 6; i++){System.out.println(i); -->
	<c:forEach begin="1" end="6" var="i">
		<h${ i }>반복문 ${ i }</h${ i }>
	</c:forEach>
	
	<c:forEach begin="1" end="6" var="i" step="2">
		<h${ i }>건너뛰기 ${ i }</h${ i }>
	</c:forEach>
	
	<c:forEach begin="1" end="6" var="i">
		<h${ 7-i }>거꾸로 ${ 7-i }</h${ 7-i }>
	</c:forEach>
	
	<hr/>
	
	<h4>배열에 forEach 적용</h4>
	<%
		String[] nameArr = {"신형만", "봉민선", "신짱구", "신짱아"};
		request.setAttribute("family", nameArr);
	%>
	<h1>우리 가족 - scriptlet</h1>
	<ol>
		<% for(String f : nameArr){ %>
			<li><%= f %></li>
		<% } %>
	</ol>
	
	<h1>우리 가족 - JSTL</h1>
	<ol>
		<c:forEach items="${ family }" var="f" varStatus="vs">
			<li>${ f }
				<ul>
					<li>vs.first : ${ vs.first }</li>
					<li>vs.last : ${ vs.last }</li>
					<li>vs.index : ${ vs.insex }</li>
					<li>vs.count : ${ vs.count }</li>
					<li>vs.current : ${ vs.current }</li>
				</ul>
			</li>
		</c:forEach>
	</ol>
</body>
</html>