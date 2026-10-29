<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= request.getContextPath() %>
	<form action="<%= request.getContextPath() %>/myEL.do" method="post">
		<h2>개인 정보 입력</h2>
		이름 : <input type="text" name="name" id="name"/><br/>
		성별 : <input type="radio" name="gender" value="남"/> 남자
			  	<input type="radio" name="gender" value="여"/>여자 <br/>
		나이 : <input type="number" name="age"/>
		
		<hr/>
		
		<h2>당신이 가장 좋아하는____은?</h2>
		<span class="user">OOO</span>님이 가장좋하는 음료는? <input type="text" name="becerage"/><br/>
		<span class="user">OOO</span>님이 가장좋하는 물건1은? <input type="text" name="product"/><br/>
		<span class="user">OOO</span>님이 가장좋하는 물건2은? <input type="text" name="product"/><br/>
		<span class="user">OOO</span>님이 가장좋하는 물건3은? <input type="text" name="product"/><br/>
		<span class="user">OOO</span>님이 가장좋하는 책은? <input type="text" name="book"/><br/>
		<span class="user">OOO</span>님이 가장좋하는 영화는? <input type="text" name="movie"/><br/>
		
		<br/>
		
		<input type="submit" value="전송"/>
		
	</form>
	
	<script>
		window.onload = () => {
			// 사용자가 이름을 작성하고 커서가 밖으로 나가면 OOO 부분에 이름이 나타나게 하기
			// 만일 입력한 이름이 없다면 OOO으로 다시 돌아오게 하기
			const name = document.getElementById('name');
			name.addEventListener('blur', (e) => {
				const value = e.target.value.trim();
				const users = document.querySelectorAll('.user');
				for(const user of users){
					user.innerText = value.length === 0 ? 'OOO' : value;
				}
			});
		}
	</script>
</body>
</html>