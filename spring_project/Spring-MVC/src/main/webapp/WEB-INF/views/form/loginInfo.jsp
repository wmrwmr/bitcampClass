<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>로그인 정보</h1>
	
		아이디 <input type="text" name="uid" value="${uid}">
		비밀번호 <input type="text" name="pw" value="${pw}">
		
		<hr>
		${loginRequest}
		<br>
		${loginParam}

</body>
</html>