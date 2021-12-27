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
		<h3>방명록 작성</h3>
		<hr>
		<form method="post">
			<input type="text" name="memberIdx" value="${loginInfo.idx}" >
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject" placeholder="제목을 입력하세요"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea name="content" rows="10" cols="50"></textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="작성"> <input type="reset">
					</td>
				</tr>
				
			</table>
		</form>
	
	</div>
	<!-- content 끝 -->


	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp" %>

</body>
</html>