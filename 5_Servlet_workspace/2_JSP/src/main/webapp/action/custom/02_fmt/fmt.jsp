<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>jstl fmt</h2>
	<p>날짜, 시간, 숫자 데이터의 출력 형식을 지어할 때 사용</p>
	<h3>숫자 데이터 포멧 지정</h3>
	천단위 구분 기호 적용 : <fmt:formatNumber value="123456789"/><br/>
	숫자 그대로 출력 : <fmt:formatNumber value="123456789" groupingUsed="false"/><br/>
	<p>formatNumber에서 groupingUsed는 true가 기본 값</p>
	
	<b>실수 값 소수점 아래 자리수 지정</b><br/>
	<fmt:formatNumber value="1.234567"/><span>기본적으로 소수점 아래 세자리까지 표현(반올림)</span><br/>
	#을 사용한 경우 : <fmt:formatNumber value="1.234567" pattern="#.##"/><br/>
	#을 사용한 경우 : <fmt:formatNumber value="1.2" pattern="#.##"/><br/>
	0을 사용한 경우 : <fmt:formatNumber value="1.2" pattern="#.00"/><br/>
	
	<h3>type속성으로 백분율, 통화기호 표시</h3>
	<fmt:formatNumber var="0.12" type="percent"/><br/> 
	<fmt:formatNumber var="123456789" type="currency"/><br/> 
	<fmt:formatNumber var="0.12" type="currency" currencySymbol="$"/><br/> 
</body>
</html>