<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% request.setCharacterEncoding("utf-8"); %>
	
	<h1>id : <%= request.getParameter("userid") %></h1>
	<h1>pw : <%= request.getParameter("pw") %></h1>
	<h1>userName : <%= request.getParameter("username") %></h1>
	<h1>comment : <%= request.getParameter("comment") %></h1>
	<h1>gender : <%= request.getParameter("gender") %></h1>
	<% 
		String [] interests = request.getParameterValues("interest");
		if(interests == null){
			out.println("<h1>interset : 선택된 관심사가 없습니다  </h1>");
		} else {
			for(int i=0; i< interests.length;i++){
				out.println("<h1>interset : "+ interests[i] +"</h1>");
			}
		}
	%>
	
	<h1>byear : <%= request.getParameter("byear") %></h1>



</body>
</html>