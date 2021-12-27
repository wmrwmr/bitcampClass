<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>
<style>
#content table td {
	padding: 5px;
}

#content>table tr>td:nth-child(1) { 
	width: 100px;
	text-align: center;
	background-color: #ddd;
	
}



#content>table td>img {
	height : 25px;
	border: 1px solid #aaa;
	border-radius: 50%;
	
	vertical-align: middle;
}

#content>table {
	border: 0;
	border-collapse: collapse;
	
	width: 900px;
}
#content>table td {
	padding: 10px;
	
}

#content>table tr {
	border-top: 1px solid #aaa;
	border-bottom: 1px solid #aaa;
}

div.replyarea {
	
	width : 880px;

	padding: 15px;
	margin : 15px 0;
	
	border: 1px solid #aaa;
	
}

img.pimg {
	height : 50px;
	border: 1px solid #aaa;
	border-radius: 50%;
	
	
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
		<h3>방명록 보기</h3>
		<hr>
		<table>
			<tr>
				<td>작성자</td>
				<td>
					<img src="${pageContext.request.contextPath}/uploadfile/${pageView.photo}">
					${pageView.username}
				</td>
			</tr>			
			<tr>
				<td>작성일</td>
				<td>${pageView.regdate} </td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${pageView.subject} </td>
			</tr>
			<tr>
				<td>내용</td>
				<td >
					<pre style="line-height: 180%">${pageView.content}</pre>
				</td>
			</tr>
		</table>
		<div class="replyarea">
			<div class="replylist">	
				<table>
					<tr>
						<td style="vertical-align: top;"><img class="pimg" src="/op/uploadfile/starwars.png"></td>
						<td>
							<h4>손흥민</h4>
							<p style="margin-top:10px;">
								<pre>댓글을 달았습니다.
안녕
안녕
안녕
안녕
안녕
안녕
								</pre>
							</p>
						</td>
					</tr>
				</table>
			</div>
			
			<hr>
			
			<div class="replywriteform">	
				<table>
					<tr>
						<td style="vertical-align: top;"><img class="pimg" src="/op/uploadfile/starwars.png"></td>
						<td>
							<h4>손흥민</h4>
							<p style="margin-top:10px;">
								<textarea rows="3" style="width: 500px;"></textarea>
							</p> <br>
							<input type="submit" value="작성">
						</td>
					</tr>
				</table>
			</div>
		
		</div>
		<div class="viewpagemenu">
			<a href="">목록</a> 
			<c:if test="${loginInfo.idx eq pageView.memberidx}">
			<a href="">수정</a> 
			<a href="">삭제</a>
			</c:if>
		</div>

	</div>
	<!-- content 끝 -->


	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp"%>

</body>
</html>