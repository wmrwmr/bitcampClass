<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	CookieBox cookieBox = new CookieBox(request);
	%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/cookie/member/login.jsp" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="<%= cookieBox.exists("checkId") ? cookieBox.getValue("checkId"): "" %>"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
				<td><input type="checkbox" name="checkId"<%= cookieBox.exists("checkId") ? "checked": "" %>> 아이디 저장하기</td>
			</tr>
		</table>
		
		
	

	</form>

</body>
</html>