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
		<form method="post" id="writeform">
			<input type="hidden" name="memberIdx" id="memberIdx" value="${loginInfo.idx}" >
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject" id="subject" placeholder="제목을 입력하세요"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea name="content" id="message" rows="10" cols="50"></textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="작성"> 
						<input type="reset">
						<!-- <button>click</button> -->
						
						<input type="button" value="ajax로 게시물 입력" id="btnAjax">
						
					</td>
				</tr>
				
			</table>
		</form>
	
	</div>
	<!-- content 끝 -->


	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp" %>


<script>

	$(document).ready(function(){
		
		$('#btnAjax').click(function(){
			
			var params = {
					memberIdx : $('#memberIdx').val() ,
					subject : $('#subject').val(),
					content :  $('#message').val()					
			};
			
			console.log(params);
			
			// 비동기 통신 			
			$.ajax({
				url : "writeAjax.do",
				type : 'POST',
				data : $('#writeform').serialize(), //params,
				success : function(data){
					console.log(data);
					
					
					
					if(data == '1'){
						alert('게시글이 등록되었습니다.');
						location.href = 'list.do';
						
						
					} else  {
						alert('게시물 등록이 실패했습니다.\n다시 등록해주세요.');
					}
				}, 
				error : function(request){
					console.log(request);
				}
			});
			
		});
		
	});	

</script>



</body>
</html>