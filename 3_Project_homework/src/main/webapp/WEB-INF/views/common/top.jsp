<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSTL core 태그(c:set, c:if 등)를 쓰겠다는 선언 / prefix="c" 라서 <c:태그명> 으로 씀 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	※ 이 파일의 코드 수정 : [수정 10] ~ [수정 11] (총 2곳) / 표시 없는 코드는 학원 원본 그대로
	top.jsp : 모든 페이지 맨 위에 공통으로 들어가는 제목(헤더) 부분
	다른 JSP 에서 <jsp:include page="../common/top.jsp"/> 로 불러다 씀
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1>a{color: black; text-decoration: none;}
	/* ▼▼▼▼▼ [수정 10] 시작 : 오타 수정 (원본 : h1>a:action{color: orangered}) ▼▼▼▼▼ */
	/* CSS 에 :action 은 없는 선택자라 아무 효과가 없었음 → 클릭하는 순간 = :active */
	h1>a:active{color: orangered}
	/* ▲▲▲▲▲ [수정 10] 끝 ▲▲▲▲▲ */
</style>
</head>
<body>
	<%--
		contextPath(프로젝트 경로, 예: /3_Project) 를 application 영역에 저장
		 - pageContext.servletContext.contextPath = request.getContextPath() 와 같은 값
		 - application 영역 = 서버가 켜져 있는 동안 "모든 페이지"가 같이 쓰는 저장공간
		 → 그래서 login.jsp, loginbar.jsp 에서 ${ contextPath } 만 써도 값이 나옴
		 → 프로젝트 이름이 바뀌어도 주소를 일일이 고칠 필요가 없음
	--%>
	<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }" scope="application"/>
	<%-- 제목을 누르면 메인 페이지(index.jsp)로 이동 --%>
	<%-- ▼▼▼▼▼ [수정 11] 시작 : & → &amp; (원본 : JSP&Servlet JDBC Project) ▼▼▼▼▼ --%>
	<%-- & 는 HTML 특수문자라 &amp; 로 써야 이클립스 경고(노란 느낌표)가 안 뜸 / 화면에는 똑같이 & 로 보임 --%>
	<h1 align="center"><a href="${ contextPath }">JSP&amp;Servlet JDBC Project</a></h1>
	<%-- ▲▲▲▲▲ [수정 11] 끝 ▲▲▲▲▲ --%>
</body>
</html>
