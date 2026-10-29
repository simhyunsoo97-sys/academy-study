<%@page import="java.util.ArrayList"%>
<%@page import="person.model.vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String str1 = "안녕";
		String str2 = new String("안녕");
		
		int big = 10;
		int small = 3;
		Person p1 = new Person("강건강", '님', 20);
		Person p2 = new Person("강건강", '님', 20);
		
		ArrayList<String> list1 = new ArrayList<>();
		list1.add(str1);
		ArrayList<String> list2 = new ArrayList<>();
		ArrayList<String> list3 = null;
		
		pageContext.setAttribute("str1", str1);
		pageContext.setAttribute("str2", str2);
		pageContext.setAttribute("big", big);
		pageContext.setAttribute("small", small);
		pageContext.setAttribute("p1", p1);
		pageContext.setAttribute("p2", p2);
		pageContext.setAttribute("list1", list1);
		pageContext.setAttribute("list2", list2);
		pageContext.setAttribute("list3", list3);
	%>
	
	<h2>EL 연산</h2>
	<p>EL을 가지고 어떤 연산 처리를 하는 것이 속성 값들을 화면에 뿌리는 용도(간단한 연산만 진행)</p>
	
	10 곱하기 7 = ${10*7 }<br/>
	10 나누기 7 = ${10/7 } = ${ 10 div 7 }<br/>
	10 나머지 7 = ${10%7 } = ${ 10 mod 7 }<br/>
	
	<hr/>
	
	<b>str1과 str2 비교<b></b>
	스크립팅 : <%= str1 == str2 %> (내용 비교 : <%= str1.equals(str2) %>)<br/>
	el : ${str1 == str2 } = ${str1 eq str2 } = ${str1.equals(str2) }<br/>
	<br/>
	스크립팅 :  <%= str1 != str2 %><br/>
	el : ${str1 != str2 } = ${ str1 ne str2 }
	
	<hr/>
	
	big > small : ${ big > small } = ${ big gt small }<br/>
	big > small : ${ big < small } = ${ big lt small }<br/>
	big >= small : ${ big >= small } = ${big ge small }<br/>
	big >= small : ${ big <= small } = ${big le small }
	
	<hr/>
	
	<b>p1 == p2 :</b><br/>
	스크립팅 : <%= p1 == p2 %><br/>
	el : ${ p1 == p2 } = ${ p1 eq p2 }
	
	<hr/>
	
	empty list1 : ${ empty list1 }<br/>
	empty list2 : ${ empty list2 } / list2 == null ${ list2 == null }<br/>
	empty list3 : ${ empty list3 } / list3 == null ${ list3 == null }
	
	<hr/>
	
	true && true : ${ true && true } = ${ true and true }<br/>
	false || true : ${ false || true } = ${ false or true }<br/>
	!false : ${ !false } = ${ not false }
	
	
</body>
</html>