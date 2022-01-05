<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	인기 키워드 :  

	<c:forEach items="${keywords}" var="keyword">
		${keyword} 
	</c:forEach>
	
	
	<br>
	
	<select>
	
	<c:forEach items="${searchType}" var="type">
		<option value="${type.value}">${type.text}</option>
	</c:forEach>
	
	</select>
	
	<input>

</body>
</html>