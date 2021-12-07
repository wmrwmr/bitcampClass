<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="shopping">
	<%
		String title3 = "Shopping"; // 에러 발생 예상!!!
	%>
	<h3><%=title3%></h3>
	<hr>
	<ul>
		<%
			for (int i = 0; i < 5; i++) {
				out.println("<li>" + i + "</li>");
			}
		%>
	</ul>
</div>