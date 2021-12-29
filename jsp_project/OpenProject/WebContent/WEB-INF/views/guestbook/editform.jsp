<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>
<style>
#content table td {
	padding : 5px;
}

#content input, #content textarea {
	padding: 10px;
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
		<h3>방명록 수정</h3>
		<hr>
		<form method="post" id="editform">
			<input type="hidden" name="memberIdx" id="memberIdx" value="${loginInfo.idx}" >
			<input type="hidden" name="guestbookIdx" id="memberIdx" value="${message.idx}" >
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject" id="subject" value="${message.subject}" placeholder="제목을 입력하세요"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea name="content" id="message" rows="10" cols="50">${message.content}</textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="수정"> 
						<input type="reset">
						
						
					</td>
				</tr>
				
			</table>
		</form>
	
	</div>
	<!-- content 끝 -->


	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp" %>


<script>

</script>



</body>
</html>