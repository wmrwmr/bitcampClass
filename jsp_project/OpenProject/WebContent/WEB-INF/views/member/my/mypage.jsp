<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not loginChk}">
<script>
	alert('로그인이 필요한 페이지입니다.');
	location.href = '${pageContext.request.contextPath}/member/login.do';
</script>
</c:if>
<c:if test="${loginChk}">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>

<style>

#content>form>table td {
	padding: 5px;
}
#content>form input {
	padding: 5px;
}

</style>


</head>
<body>

	<!-- 해더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 해더 끝 -->

	<!-- 네비게이션 시작 -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	<!-- 네비게이션 끝 -->

	<!-- content 시작 -->
	<div id="content">
		<h3>회원 정보</h3>
		<hr>
			<table>
				<tr>
					<td>아이디</td>
					<td> ${member.userid} </td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td> ${member.pw}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td> ${member.username}</td>
				</tr>
				<tr>
					<td>사진</td>
					<td>
						<img src="${pageContext.request.contextPath}/uploadfile/${member.photo}" height="100">
					</td>
				</tr>
				<tr>
					<td>가입일</td>
					<td> ${member.regdate}</td>
				</tr>		
			</table>

	</div>
	<!-- content 끝 -->


	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp" %>

</body>
</html>
</c:if>