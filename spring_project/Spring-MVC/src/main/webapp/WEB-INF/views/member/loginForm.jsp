<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>login Form</h1>
	<hr>
	<form method="post">
		<input type="hidden" name="rurl" value="${url}">
		아이디 <input type="text" name="uid"> <br>
		비밀번호 <input type="password" name="pw"> <br>
		<input type="submit">
	</form>

</body>
</html>