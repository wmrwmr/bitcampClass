<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>View 페이지 입니다.</h1>
	<h3> 데이터를 받아서 출력합니다. 다른 자바 연산은 하지 않습니다.</h3>
	<hr>
	result: ${requestScope.result} <br>
	result: ${param.uid} : ${param.pw}
</body>
</html>