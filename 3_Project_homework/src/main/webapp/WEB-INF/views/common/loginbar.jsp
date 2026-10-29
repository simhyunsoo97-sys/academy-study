<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	※ 이 파일의 코드 수정 : [수정 9] (총 1곳) / 표시 없는 코드는 학원 원본 그대로
	loginbar.jsp : 화면 오른쪽 위에 나오는 로그인 메뉴 (index.jsp 에서 include 해서 사용)
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#Loginbar{text-align: right; margin: 50px;}
	#Loginbar>a{color: black; text-decoration: none;}
	#Loginbar>a:hover{font-weight: bold; text-decoration: underline;}
</style>
</head>
<body>
	<div id="Loginbar">
		<%-- ▼▼▼▼▼ [수정 9] 시작 : 추가 (원본 : <a href="${ contextPath }/loginView.me">로그인</a> 한 줄만 있었음) ▼▼▼▼▼ --%>
		<%--
			로그인 상태에 따라 다르게 보여주기 (로그인 성공했는지 화면으로 확인하려고 추가함)
			 - loginUser : LoginServlet 에서 로그인 성공 시 session 에 넣어둔 값
			 - empty : 값이 null 이거나 비어있으면 true
		--%>
		<c:if test="${ empty loginUser }">
			<%-- 로그인 안 했을 때 : 로그인 링크 → LoginViewServlet(/loginView.me) 이 login.jsp 를 보여줌 --%>
			<a href="${ contextPath }/loginView.me">로그인</a>
		</c:if>
		<c:if test="${ !empty loginUser }">
			<%-- 로그인 했을 때 : ${ loginUser.empNo } 는 내부적으로 loginUser.getEmpNo() 를 호출함 --%>
			${ loginUser.empNo }님 환영합니다.
		</c:if>
		<%-- ▲▲▲▲▲ [수정 9] 끝 ▲▲▲▲▲ --%>
	</div>
</body>
</html>
