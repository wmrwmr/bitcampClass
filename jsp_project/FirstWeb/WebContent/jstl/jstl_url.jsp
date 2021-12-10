<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value = "index.jsp" /> <br>
	<c:url value = "/index.jsp" /> <br>
	<c:url value = "/index.jsp" var="link1" />
	${link1}	
	<br>
	<a href = "${link1}">홈으로 가기</a>
	<br>
	<a href = "<c:url value = "/index.jsp" />">홈으로 가기</a>
	<br>
	<c:url value="/jstl/jstl_choosewhen.jsp" var = "link2">
		<%-- <c:param name="sel">c</c:param> --%>
		<c:param name="sel" value="c"/>
		
	</c:url>
	
	<a href="${link2}">choosewhen.jsp</a>
	
	
</body>
</html>