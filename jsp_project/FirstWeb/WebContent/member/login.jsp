<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>Login Form Data</h1>
	<!-- Test -->
	<%-- Test --%>
	<%
	
		request.setCharacterEncoding("utf-8");	
	
		// 스크립트릿 영역: Java 문법 코드 작성
		String uid = request.getParameter("userid");
		// request: 내장객체 (변수의 선언이 없고, 객체의 생성도 없다)
	%>
	
	아이디: <%= uid %>
	<br>
	비밀번호: <%= request.getParameter("pw") %>
	
	<br>
	<%= new Date() %>


</body>
</html>