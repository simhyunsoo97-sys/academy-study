<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	※ 이 파일은 코드 수정 없음 (학원 원본 그대로 + 설명 주석만 추가)
	login.jsp : 로그인 화면
	 - WEB-INF 안에 있어서 주소창으로 직접 못 열고, LoginViewServlet(/loginView.me) 을 거쳐서만 열림
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#loginDiv{border: 1px solid black; margin: auto; margin-top: 150px; padding: 150px; width: 500px;}
	/* "로그인", "ID/PW 찾기" 글자(label)에 마우스를 올리면 버튼처럼 보이게 */
	#loginDiv>label:hover{font-weight: bold; text-decoration: underline; cursor: pointer;}
	input{height: 30px;}
</style>
</head>
<body>
	<%-- 공통 헤더 불러오기 (이때 top.jsp 안에서 contextPath 가 저장되므로 아래 ${ contextPath } 를 쓸 수 있음) --%>
	<jsp:include page="../common/top.jsp"/>

	<%--
		action : submit 하면 요청을 보낼 주소 → LoginServlet(@WebServlet("/login.me"))
		method="post" : 비밀번호가 주소창에 보이지 않도록 POST 방식으로 전송
	--%>
	<form action="${ contextPath }/login.me" method="post" id="loginForm">
		<div align="center" id="loginDiv">
			<table>
				<tr>
					<%-- label 의 for 와 input 의 id 가 같으면, 글자를 클릭해도 입력칸에 커서가 들어감 --%>
					<td align="right"><label for="id">사원번호</label></td>
					<%-- name="id" → 서블릿에서 request.getParameter("id") 로 꺼냄 / autofocus : 페이지 열리면 바로 커서 --%>
					<td><input type="text" name="id" id="id" size="25" autofocus></td>
				</tr>
				<tr>
					<td align="right"><label for="pwd">비밀번호</label></td>
					<%-- type="password" : 입력한 글자가 ●●● 로 가려짐 --%>
					<td><input type="password" name="pwd" id="pwd" size="25"></td>
				</tr>
			</table>
			<br>
			<%-- submit 버튼 대신 label 을 클릭하면 doLoginLabel() 함수에서 검사 후 직접 submit --%>
			<label onclick="doLoginLabel();">로그인</label>&nbsp;&nbsp;&nbsp;&nbsp;
			<label id="findIdPwdLabel">ID/PW 찾기</label>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
	</form>

	<script>
		// 로그인 버튼(label) 클릭 시 : 빈칸 검사 → 통과하면 form 전송
		const doLoginLabel = () => {
			const id = document.getElementById('id');		// id 로 요소 찾기
			const pwd = document.querySelector('#pwd');		// CSS 선택자로 요소 찾기 (두 방법 다 결과는 같음)
			// trim() : 앞뒤 공백 제거 → 스페이스만 입력한 경우도 빈칸으로 처리
			if(id.value.trim() === ''){
				alert('사원번호를 입력하세요.');
				id.focus();		// 빈 칸으로 커서 이동
			} else if(pwd.value.trim() === ''){
				alert('비밀번호를 입력하세요.');
				pwd.focus();
			} else{
				// 둘 다 입력했으면 form 을 직접 전송 → action 주소(/login.me)로 POST 요청
				document.getElementById('loginForm').submit();
			}
		}

		// 페이지가 다 로드된 뒤 실행
		// form 안에 submit 버튼이 없고 입력칸이 2개 이상이면 Enter 를 눌러도 전송이 안 됨
		// → 모든 input 에 "Enter 키를 떼면 doLoginLabel() 실행" 이벤트를 직접 달아줌
		window.onload = () => {
			const inputIdPwd = document.getElementsByTagName('input');	// input 태그 전부 (배열처럼 사용)
			for(let i = 0; i < inputIdPwd.length; i++){
				inputIdPwd[i].addEventListener('keyup', e => {
					if(e.key == 'Enter'){
						doLoginLabel();
					}
				})
			}
		}
	</script>
</body>
</html>
