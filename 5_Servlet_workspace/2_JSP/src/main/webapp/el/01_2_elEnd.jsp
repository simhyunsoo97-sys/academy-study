<%@page import="person.model.vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Person who = (Person)request.getAttribute("person"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>결과 페이지</h2>
	<h4>개인 정보(<%= request.getAttribute("year") %>)</h4>
	이름: : <%= who.getName() %><br/>
	성별: : ${ requestScope.person.gender }<br/>
	나이: : ${ person.age }<br/>
	<p>
		scope가 생략되면 pageScope -> requestScope -> sessionScope -> applicationScope 순으로 찾음<br/>
		여러 scope에 동일 속성을 기록하고 이름 충돌이 의심되면 명시적으로 scope를 지정해야 함
	</p>
	<h4>취향 정보</h4>
	${ requestScope.person.name } 님이 가장 좋아하는 음료 : ${ requestScope.beverage }<br/>
	${ requestScope.person.name } 님이 가장 좋아하는 물건 : ${products[0] }, ${products[1] }, ${products[2] }<br/>
	${ requestScope.person.name } 님이 가장 좋아하는 도선 : ${book }<br/>
	${ requestScope.person.name } 님이 가장 좋아하는 영화 : ${movie }
	
	<br/><br/>
	
	scripting ver. book : <%= request.getAttribute("book") %> <br/>
	EL ver. movie : ${ requestScope.movie }
</body>
</html>