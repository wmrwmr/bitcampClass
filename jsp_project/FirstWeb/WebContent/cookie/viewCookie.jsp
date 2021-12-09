<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 
	Cookie[] cookies = request.getCookies();

	// 2021.12.09
	CookieBox cookieBox = new CookieBox(request);

%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 리스트</h1>
	<hr>
	<h3>
		<%
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					out.println(cookies[i].getName() + "=" + cookies[i].getValue() + "<br>");
					System.out.println(cookies[i].getName() + "=" + cookies[i].getValue());
				}
			}
			
		
			// 쿠키 검색
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals("kName")) {
						out.println(cookies[i].getName() + "=" + cookies[i].getValue() + "<br>");
						break;
					}
				}
			}
		%>
		
		<hr>
		
		<h3>
			<%= cookieBox.exists("uid")%> /	<%= cookieBox.exists("uName")%>
		</h3>
		<h3>
			<%
				if(cookieBox.exists("uid")) {
					Cookie c = cookieBox.getCookie("uid");
					out.println(c.getName()+"="+cookieBox.getValue(c.getName()));
				}
			%>
		</h3>
		
		<hr>
		
		<a href="editCookie.jsp">쿠키값 수정</a> <br>
		<a href="deleteCookie.jsp"> 쿠키값 삭제</a>
	</h3>

</body>
</html>