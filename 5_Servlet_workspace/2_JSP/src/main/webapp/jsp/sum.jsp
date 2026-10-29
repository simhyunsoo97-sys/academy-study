<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, java.util.HashMap" errorPage="error/errorPage.jsp"%>
<%-- page 지시어 : 현재 JSP페이지를 컨테이너에서 처리하는데 필요한 각종 속성을 기술하는 부분으로 보통 소스의 맨 앞에 위치
	language : 사용할 스크립트 언어 유형 지정
	contentType : 웹 브라우저가 받아볼 페이지의 인코딩 방식
	pageEncoding : JSP파일에 기록된 소스코드 자체의 인코딩 방식
	import : 자바의 import와 같음
	errorPage : 현재 JSP페이지에서 오류가 발생할 경우 호출할 페이지 지정
	isErrorPage : 오류 처리에 이용하는 속성으로 true로 두면 exception객체 사용 가능
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- JSP 주석 --%>
	<!-- HTML 주석 -->
	
	<% // scriptlet
		int total = 0;
		for(int i = 1; i <= 10; i++){
			total += i;
	%>
			<span style="color: red;">안녕하세요</span><br/>
	<% 
		}
		System.out.println("덧셈 끝! : " + total);
		
		ArrayList<String> list = new ArrayList<>();
		HashMap<Integer, String> map = new HashMap<>();
		HashSet<String> set = new HashSet<>();
		list.add(null);
		System.out.println(list.get(0).charAt(0));
	%>
	
	expression 출력 : 1부터 10까지의 합은 <span style="color: green; font-size: 16pt;"><%= total %></span>입니다.
	<br/>
	scriptlet 출력 :1부터 10까지의 합은 <span style="color: blue; font-size: 16pt;"><% out.println(total); %></span>입니다.
	
	
</body>
</html>