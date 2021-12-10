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

	<select>
		<option value="a" ${param.sel eq 'a'? 'selected' : ''}>AAA</option>
		<option value="b" ${param.sel eq 'b'? 'selected' : ''}>BBB</option>
		<option value="c" ${param.sel eq 'c'? 'selected' : ''}>CCC</option>
	</select>



	<c:choose>
		<c:when test="${param.sel == 'a'}">
			<h3>a를 선택했습니다.</h3>
		
		</c:when>
		<c:when test="${param.sel eq 'b' }">
			<h3>b를 선택했습니다.</h3>
			
		</c:when>
		
		<c:otherwise>
			a, b가 아닌 데이터를 선택했습니다.
		
		</c:otherwise>
	</c:choose>

</body>
</html>