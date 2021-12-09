<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();

	CookieBox cookieBox = new CookieBox(request);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 값 삭제</h1>
	<hr>
	<h3>
		<%
			
			
		
			// 쿠키 검색 -> 쿠키 삭제
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals("kName")) {
						// 변경하고자 하는 값을 가지는 쿠키 객체를 생성
						Cookie c = new Cookie("kName", "이강인");
						
						// 쿠키의 유효 시간을 0으로 설정
						c.setMaxAge(0);
						response.addCookie(c);
						break;
					}
				}
			}
			
			/////////////////////////////////////////
			// CookieBox를 이용한 쿠키 삭제
			if(cookieBox.exists("uid")) {
				response.addCookie(cookieBox.createCookie("uid", "", 0));
			}
			
			
			
			
			
		%>
		
		<a href="viewCookie.jsp">쿠키 보기</a>
	</h3>

</body>
</html>