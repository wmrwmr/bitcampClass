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

	<c:set var="appName" value = "JSP Program" scope = "application"/>
	1. application 영역에 appName 속성이 있는지 확인
	2. 속성 생성 또는 덮어 쓰는 처리

	<c:set var="name" value = "JSP"	scope = "session"/>
	
	<hr>
	
	${member.name} <br>
	
	저장된 속성의 변수값을 변경 <br>
	
	setName("손흥민");<br>
	
	<c:set value="손흥민" target="${member}" property="name" />
	
	${member.name}
</body>
</html>