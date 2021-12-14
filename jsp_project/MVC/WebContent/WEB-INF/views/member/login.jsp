<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not loginChk}">
	<script>
		alert('아이디 또는 비밀번호를 확인해주세요.');
		history.go(-1);
	</script>
</c:if>
<c:if test="${loginChk}">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
</head>
<body>
	
	<h1>로그인 되었습니다.</h1>
	<h3>${loginInfo}</h3>

</body>
</html>
</c:if>