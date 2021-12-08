<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String uid = (String)session.getAttribute("id");
    
    // 로그인 정보 존재 유무 체크
    if(uid == null) {
    	response.sendRedirect("loginForm.html");
    	return;
    }
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>My page</h1>
	<hr>
	<h3>
		사용자 로그인 아이디: <%= uid %> <br>
		
		request 속성값:  <%= request.getAttribute("num1") %> <br>
		application 속성값: <%= application.getAttribute("num2") %> <br>
		
		<a href = "logout.jsp">로그아웃</a>
	</h3>
</body>
</html>