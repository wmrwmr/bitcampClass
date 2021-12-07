<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		request.setCharacterEncoding("utf-8");
	%>

	<%
		String uid = request.getParameter("userid");
	%>
	<%
		String pw = request.getParameter("pw");
	%>
	<%
		String uname = request.getParameter("username");
	%>
	<%
		String comment = request.getParameter("comment");
	%>
	<%
		String gender = request.getParameter("gender");
	%>

	<%
		String[] interests = request.getParameterValues("interest");
	%>

	<%
		String byear = request.getParameter("byear");
	%>


	<%
		response.setContentType("text/html; charset=utf-8");
	%>






	<h1>
		uid :
		<%=uid%></h1>
	<br>

	<h1>
		pw :
		<%=pw%></h1>
	<br>
	<h1>
		username :
		<%=uname%></h1>
	<br>
	<h1>
		comment :
		<%=comment%></h1>
	<br>
	<h1>
		gender :
		<%=gender%></h1>
	<br>
	<div>
		<h1>

			<%
				if (interests != null) {
					for (int i = 0; i < interests.length; i++) {
			%>
			interest :
			<%=interests[i]%>
			<br>
			<%
				}
				} else {
			%>
			interest : 선택된 관심사가 없습니다.<br>
			<%
				}
			%>

		</h1>
	</div>


	<h1>
		byear :
		<%=byear%></h1>
	<br>












</body>
</html>