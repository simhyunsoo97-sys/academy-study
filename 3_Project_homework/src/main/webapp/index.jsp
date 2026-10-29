<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	※ 이 파일은 새로 만든 파일 (원본 스크린샷에 내용이 안 보여서 새로 작성)
	index.jsp : 메인 페이지 (프로젝트 주소로 들어오면 제일 먼저 열리는 화면)
	 - 공통 헤더(top.jsp) 와 로그인 메뉴(loginbar.jsp) 를 불러와서 보여주기만 함
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP&amp;Servlet JDBC Project</title>
</head>
<body>
	<%-- top.jsp 를 먼저 불러와야 그 안에서 contextPath 가 저장됨 → loginbar.jsp 에서 ${ contextPath } 사용 가능 --%>
	<jsp:include page="WEB-INF/views/common/top.jsp"/>
	<jsp:include page="WEB-INF/views/common/loginbar.jsp"/>
</body>
</html>
