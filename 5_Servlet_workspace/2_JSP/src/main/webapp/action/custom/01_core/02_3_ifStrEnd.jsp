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
	<c:if test="${ param.str1 == param.str2 }">
		== 비교를 통해 str1과 str2가 같음을 확인했습니다.
	</c:if>
	<c:if test="${ param.str != param.str2 }">
		!= 비교를 통해 str1과 str2가 같지않음을 확인했습니다.
	</c:if>
	
	<c:if test="${ param.str1 eq param.str2 }">
		eq 비교를 통해 str1과 str2가 같음을 확인했습니다.
	</c:if>
	<c:if test="${ param.str ne param.str2 }">
		ne 비교를 통해 str1과 str2가 같지않음을 확인했습니다.
	</c:if>
	
	<c:if test="${ param.str1.equals(param.str2) }">
		equals 비교를 통해 str1과 str2가 같음을 확인했습니다.
	</c:if>
	<c:if test="${ !param.str1.equals(param.str2) }">
		!equals 비교를 통해 str1과 str2가 같지않음을 확인했습니다.
	</c:if>
</body>
</html>