<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>

<style>

#content>form>table td {
	padding: 5px;
}
#content>form input {
	padding: 5px;
}

#msg {
	display: none;
}

.text_red {
	color : red;
}
.text_blue {
	color: blue;
}

</style>
<script>
	
	$(document).ready(function(){
		
		$('#userid').focusin(function(){
			$('#msg').css('display', 'none');
			$('#msg').removeClass('text_blue');
			$('#msg').removeClass('text_red');
			$('#msg').text('');
		});
		
		$('#userid').focusout(function(){
			
			$.ajax({
				url : 'checkid.do',
				type : 'get',
				data : {
					userid : $('#userid').val()
				},
				success : function(data){
					// Y | N
					if(data == 'Y') {
						// 사용 가능한 아이디
						$('#msg').css('display', 'block');
						$('#msg').text('멋진 아이디 입니다!');
						$('#msg').addClass('text_blue');
						
					} else {
						// 사용 불가능한 아이디
						$('#msg').css('display', 'block');
						$('#msg').text('사용중이거나 탈퇴한 아이디 입니다!');
						$('#msg').addClass('text_red');
					}
				},
				error : function() {
					console.log('비동기 통신 오류');
				}
			});
			
		});
		
		
		$('#ajaxBtn').click(function(){
			
			// 비동기 통신을 이용해서 파일을 업로드 하는 경우
			// FormData 를 이용
			// 파라미터 이름과 전송할 데이터를 설정
			
			var photoFile = $('#photo');
			var file = photoFile[0].files[0];
			
			var formData = new FormData();
			formData.append('userid', $('#userid').val());
			formData.append('pw', $('#pw').val());
			formData.append('username', $('#username').val());
			formData.append('photo', file);
			
			$.ajax({
				url : 'reg2.do',
				type : 'POST',
				data : formData,
				enctype : 'multipart/form-data',
				processData : false,
				contentType : false,
				cash : false,
				success : function(data){
					if(data == '1'){
						alert('회원가입 성공!');
						location.href = 'login.do';
					} else {
						alert('회원가입 실패!');
						history.go(-1);
					}
				},
				error : function(req){
					console.log(req);
				}
			});
			
		});
		
	});
	
	
</script>


</head>
<body>

	<!-- 해더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 해더 끝 -->

	<!-- 네비게이션 시작 -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	<!-- 네비게이션 끝 -->

	<!-- content 시작 -->
	<div id="content">
		<h3>회원 가입</h3>
		<hr>
		<!-- form 경로와 처리 경로가 동일 -> method 로 구분 -->
		<!-- action="reg.do" 생략 가능 -->
		<form action="reg.do" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>아이디</td>
					<td>  
					<!-- 
					http://localhost:8080/op/member/checkid.do?id=coo@gmail.com
					1 | 0, Y | N
					 -->
					<input type="text" name="userid" id="userid">
					<div id="msg"></div>
					
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" id="pw"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="username" id="username"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="photo" id="photo"></td>
				</tr>
				<tr>
					<td></td>
					<td> 
						<input type="submit" value="회원가입"> 
						<input type="reset">
						<input type="button" value="ajax로 회원가입" id="ajaxBtn"> 
					</td>
				</tr>			
			</table>
		
		</form>
	
	</div>
	<!-- content 끝 -->


	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp" %>

</body>
</html>