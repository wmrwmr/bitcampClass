<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>request 객체 속성 값: <%= request.getAttribute("num1") %></h3>
	<h3>session 객체 속성 값: <%= session.getAttribute("id") %></h3>
	<h3>application 객체 속성 값: <%= application.getAttribute("num2") %></h3>


</body>
</html>