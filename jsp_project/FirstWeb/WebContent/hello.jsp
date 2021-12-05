<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
    <%@ page import="java.time.LocalDateTime" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
		
			// java 코드를 작성
			// java.util.Date now1 = new java.util.Date();
			Date now1 = new Date(); 
		
		%>
		<%= now1 %>
		<h1><%= LocalDateTime.now() %></h1>
		
		
		<h1> 처음 작성한 JSP 파일 </h1>
		
		
</body>
</html>