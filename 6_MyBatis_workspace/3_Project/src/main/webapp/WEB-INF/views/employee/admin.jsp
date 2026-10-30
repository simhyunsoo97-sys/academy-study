<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	html, body{width: 99%; height: 98%;}
	#container{width: 99%; height: 75%; display: flex;}
 	#adminDiv{height: 100%; width: 15%; background: #111; display: inline-block;}
	.adminMenu{
		width: 95%; height: 60px; background: #888; text-align: center; margin: auto; 
		line-height: 60px; font-size: 20px; color: #eee;
	}
	.adminMenu:hover{font-weight: bold; cursor: pointer;}
	
	.menuContent{margin-left: 10px; width: 85%; height: 100%; display:none;}
	
	#enrollDiv{margin: auto; padding: 130px;}
	#enrollDiv td{text-align: right;}
	.enrollInput{height: 30px; width: 200px;}
	.enrollInput.select{width: 208px;}
	#enrollButton{border: 1px solid black; width: 300px; padding: 15px; border-radius: 15px; background: white;}
	#enrollButton:hover{background: black; color: white; cursor: pointer;}

	#adminDiv+div{height: 92%; width: 80%; padding: 30px; overflow: scroll;}
	#adminDiv+div>table{width: 100%; text-align: center;}
	th{border-bottom: 1px solid black;}
	#adminDiv+div>table td{height: 35px;}
	
	#adminDiv+div>table td>div{
		border: 1px solid black; height: 80%; width: 45%; display: inline-block; padding-top: 3%; cursor: pointer;
	}
	.selectState{background: lightgray;}
	.unselectState{background: none;}
</style>
</head>
<body>
	<jsp:include page="../common/top.jsp"/>
	<jsp:include page="../common/loginbar.jsp"/>

	<hr>
	
	<div id="container">
		<div id="adminDiv">
			<h2 style="margin-left: 5px;">
				<a href="${ contextPath }" style="color: white;">
					JSP&amp;Servlet<br>
					JDBC Project
				</a>
			</h2>
			<div class="adminMenu">사원 전체 보기</div>
			<br>
			<div class="adminMenu">사원 등록 하기</div>
		</div>
		
		<div class="menuContent" style="background: pink;">
					<table id="empList">
					<tr>
						<th width="6%">사번</th>
						<th width="10%">이름</th>
						<th width="10%">직업</th>
						<th width="10%">매니저</th>
						<th width="10%">입사일</th>
						<th width="10%">급여</th>
						<th width="10%">커미션</th>
						<th width="10%">부서</th>
						<th width="12%">관리자</th>
						<th width="12%">활동여부</th>
					</tr>
				<c:forEach items="${ empList }" var="e">
					<tr>
						<td>${ e.empNo }</td>
						<td>${ e.empName }</td>
						<td>${ e.job }</td>
						<td>${ e.mgr }</td>
						<td>${ e.hireDate }</td>
						<td>${ e.sal }</td>
						<td>${ e.comm }</td>
						<td>${ e.dept }</td>
						<td>
							<div class="${ e.isAdmin == 'Y' ? 'selectState' : 'unselectState' }">Y</div>
							<div class="${ e.isAdmin == 'N' ? 'selectState' : 'unselectState' }">N</div>
						</td>
						<td>
							<div class="${ e.status == 'Y' ? 'selectState' : 'unselectState' }">Y</div>
							<div class="${ e.status == 'N' ? 'selectState' : 'unselectState' }">N</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="menuContent" style="background: yellowgreen;">
						<form action="${ contextPath }/insertEmp.me" method="post" id="enrollForm" name="enrollFrm">
				<div align="center" id="enrollDiv">
					<table>
						<tr>
							<td><label for="id">사원번호</label></td>
							<td><input type="text" name="id" id="id" class="enrollInput" required autofocus></td>
						</tr>
						<tr>
							<td colspan="2"></td>
						</tr>
						<tr>
							<td><label for="name">이름</label></td>
							<td><input type="text" name="name" id="name" class="enrollInput" size="25" required></td>
						</tr>
						<tr>
							<td><label for="job">직업</label></td>
							<td><input type="text" name="job" id="job" class="enrollInput" size="25" required></td>
						</tr>
						<tr>
							<td><label for="mgr">매니저</label></td>
							<td>
								<select name="mgr" class="enrollInput select">
									<option>---------------------------------------</option>   <!-- option은 value속성이 없으면 안에 있는 값이 들어감 -->
									<c:forEach items="${ empList }" var="e">
										<c:if test="${ e.status == 'Y' }">
											<option value="${ e.empNo }">${ e.empName }</option>
										</c:if>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td><label for="sal">급여</label></td>
							<td><input type="number" name="sal" class="enrollInput" id="sal" size="25" value="0"></td>
						</tr>
						<tr>
							<td><label for="comm">커미션</label></td>
							<td><input type="number" name="comm" class="enrollInput" id="comm" size="25" value="0"></td>
						</tr>
						<tr>
							<td><label for="dept">부서</label></td>
							<td>
								<select name="dept" class="enrollInput select">
									<option>---------------------------------------</option>
									<option value="10">ACCOUNTING</option>
									<option value="20">RESEARCH</option>
									<option value="30">SALES</option>
									<option value="40">OPERATIONS</option>
								</select>
							</td>
						</tr>
						<tr>
							<td><label for="isAdmin">관리자 여부</label></td>
							<td>
								<input type="checkbox" name='isAdmin' id="isAdmin" value="Y">
							</td>
						</tr>
					</table>
					<br>
					<button id="enrollButton">사원등록</button>
				</div>
			</form>
		</div>
	</div>
	
	<script>
		window.onload = () => {
		    const adminMenus = document.getElementsByClassName('adminMenu');
		    const menuContents = document.querySelectorAll('.menuContent');
		    let validate = false;
		    adminMenus[0].addEventListener('click', () => {
		        menuContents[0].style.display = 'block';
		        menuContents[1].style.display = 'none';
		    });
	
		    adminMenus[1].addEventListener('click', () => {
		        menuContents[0].style.display = 'none';
		        menuContents[1].style.display = 'block';
		    });
		    
		 	document.getElementById("enrollButton").addEventListener('click', (e) => {
		 		const dept = document.getElementsByName("dept")[0];
		 		if(dept.value.indexOf('-') == 0){	
		 			alert('부서는 필수 선택 항목입니다.');
		 			dept.focus();
		 			e.preventDefault(); // form태그에서는 submit이 기본이기 때문에 이벤트 객체 e에 preventDefault()를 하여 기본 이벤트를 막아줌
		 		}
		 		
		 		if(!validate){
		 			alert('사원번호를 확인하세요');
		 			document.getElementById('id').focus();
		 			e.preventDefault();
		 		}
		 	});   
		 	
		 	const afterEnroll = '${param.afterEnorll}'; // '' or 'Y' Y가 변수가 아닌 리터럴 값이기 때문에 ''으로 감싸야함
		 	if(afterEnroll == 'Y'){
		 		menuContents[0].style.display = 'block';
		 		menuContents[1].style.display = 'none';
		 	}
		 	
		 	document.getElementById("id").addEventListener('focusout', (e) => {      // 커서가 밖으로 나올때 focusout == blur / blur 이벤트는 이벤트 버블링이 적용되지 않음
		 		const value = e.target.value.trim();
				
		 		// console.log(e.target.parentElement.parentElement.nextElementSibling.children[0]);
		 		const targetTd = e.target.parentElement.parentElement.nextElementSibling.children[0];
		 	
				if(value == ''){
					targetTd.innerText = '';
					validate = false;
				} else {
					/*
						fetch('주소', {설정})						-> 요청
						.then(response => response.json()) 		-> 응답 받은 json데이터를 js로 변환		
						.then(data => {내용})						-> 응답 결과 작성						
						.catch(err =? console.log(err))			-> 에러 발생 시 잡아주는 구문
					
						- {설정} : 필요하면 작성, 필요 없으면 생략 가능
							method: 요청 방식(get/post/put/patch/delete)
							headers: 서버 요청 시 부가적 정보, {key:value} 형식으로 들어감
							body: 서버에 보낼 데이터
					*/
					fetch('${contextPath}/checkEmpNo.me?value=' + value)
					.then(response => response.json())
					.then(data => {
						if(data === 0){
							targetTd.innerText = '사용 가능한 사원번호입니다.';
							targetTd.style.color = 'green';
							validate = true;
						} else {
							targetTd.innerText = '중복된 사원번호입니다.'
							targetTd.style.color = 'red';
							validate = false;
						}
						targetTd.style.fontsize = '12px';
					})
					.catch(err => console.log(err))
				}
		 	});
		 	
		 	// const table = document.getElementById('empList');
		 	// const stateButtons = table.querySelectorAll('div');
		 	const stateButtons = document.querySelectorAll('#empList div');
		 	//console.log(stateButtons);
		 	for(const button of stateButtons){
				//console.log(button);
				button.addEventListener('click', (e) => {
					if(e.target.className == 'unselectState'){
						const myTd = e.target.parentElement;						
						const myTr = myTd.parentElement;
						const myTrChildren = myTr.children;
						const empNo = (Number)(myTrChildren[0].innerText); //사번, innerText로 뽑으면 항상 string타입으로 반환됨
						
						let clickColumnIndext;
						for(const index in myTrChildren){
							if(myTd == myTrChildren[index]){
								clickColumnIndex = index;
							}
						}
						const clickItem = clickColumnIndex == 8 ? 'is_admin' : 'status'; //컬럼명
						
						// 바꿀 값 : 내가 클릭한 div의 내용
						
						fetch('${contextPath}/updateState.me', {
							method: 'post',
							headers: {'content-type':'application/json'},
							body: JSON.stringify({empNo:empNo, column:clickItem, value:e.target.innerText}) // JSON 문자열로 반환
						})
						.then(res => res.json())
						.then(data =>{
							//console.log(data); // {message:'success'}
							if(data.message === 'success'){
								e.target.className = 'selectState';
								for(const siblings of myTd.children){
									if(siblings != e.target){
										siblings.className = 'unselectState';
									}									
								}
							} else{
								alert('상태 변경을 실패하였습니다.');
							}
							
						})
						.catch(err => console.log(err))
					
					}
				})
		 	}
		}
	</script>
</body>
</html>