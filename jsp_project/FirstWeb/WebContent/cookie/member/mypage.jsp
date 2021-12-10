<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	CookieBox cookieBox = new CookieBox(request);

	boolean loginCheck = cookieBox.exists("LOGIN") && cookieBox.exists("ID") && cookieBox.getValue("LOGIN").equals("SUCCESS");
	
	if (loginCheck) {
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
</head>
<body>

	<h1>로그인 상태입니다.</h1>
	<h3>ID: <%= cookieBox.getValue("ID") %></h3>
	<h3>
		<a href = "<%= request.getContextPath() %>/cookie/member/logout.jsp">로그아웃</a>
	</h3>
</body>
</html>

<%
	} else {
		%>
		<script>
			alert("로그인이 필요한 페이지입니다!!!");
			location.href= '<%= request.getContextPath() %>/cookie/member/loginForm.jsp';
		</script>
		<%
	}
%>