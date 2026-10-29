<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : ${ param.name }<br/>
	나이 : ${ param.age }<br/>
	성별 : ${ param.gender }<br/>
	물건1 : ${paramValues.product[0] }<br/>
	물건2 : ${paramValues.product[1] }<br/>
	물건3 : ${paramValues.product[3] }<br/>
</body>
</html>