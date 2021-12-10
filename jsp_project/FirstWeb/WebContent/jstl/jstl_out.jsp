<%@page import="member.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List<Member> members = new ArrayList<Member>();
	members.add(new Member(null, 20));
	members.add(new Member("이강인", 19));
	members.add(new Member("손흥민", 30));
	members.add(new Member(null, 35));
	members.add(new Member("박지성", 40));
	
	request.setAttribute("members", members);
	
%>
<title>Insert title here</title>
<style>
	.no_name {
		color: red;
	}
</style>
</head>
<body>
	<!-- escapeXml="false" -> c:out 태그 내부를 html로 인식시킴(true만 아니면 다됨) -->
	<c:out value="${members[0].name}" escapeXml="">
		<span style="color:red;">입력된 이름 정보가 없습니다. (출력 값이 null일 때 기본값)</span>
	</c:out>
	
	<br>
	
	<c:out value="${members[0].name}" default="NO NAME" />
	
	<br>
		
	<c:out value="${members[1].name}"></c:out>
	
	<hr>
	이름: 나이 <br>
	<!-- 회원 정보 리스트 출력 -->
	<c:forEach items="${members}" var="member"> 
		
		
		<c:out value="${member.name}" escapeXml="">
			<span class="no_name">No Name</span>
		</c:out>
		: ${member.age} <br>
		
	</c:forEach>
	


</body>
</html>