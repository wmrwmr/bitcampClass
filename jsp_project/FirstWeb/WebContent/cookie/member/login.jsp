<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	// CookieBox를 이용해서 아이디를 저장 -> 다른 페이지에 이동했을 때 로그인 유무를 판단

	// 사용자 요청 정보: id, pw를 받아서 쿠키에 저장
	// id/pw 값이 일치할 때 저장

	// 데이터 받기
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String checkId = request.getParameter("checkId");
	

	// id/pw 값이 일치할 때 저장: 로그인 처리
	if (id.equals(pw)) {

		response.addCookie(CookieBox.createCookie("LOGIN", "SUCCESS", -1, "/"));
		response.addCookie(CookieBox.createCookie("ID", id, -1, "/"));

		
		if(checkId != null && checkId.equals("on")) {
			response.addCookie(CookieBox.createCookie("checkId", id, 60*60*24*365, "/"));
		} else {
			response.addCookie(CookieBox.createCookie("checkId", "", 0, "/"));
		}
		
		
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>로그인 되었습니다.</h1>
	<h3>
		<a href="<%= request.getContextPath() %>/cookie/member/mypage.jsp">my page</a>
	</h3>
</body>
</html>

<%
	} else {
%>
<script>
	alert('로그인 실패!!');
	history.go(-1);
</script>
<%
	}
%>
















