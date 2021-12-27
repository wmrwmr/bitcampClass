<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax-1</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>

	// 서버의 리소스를 요청해서 현재 페이지의 엘리먼트에 추가
	$(document).ready(function(){
		//$.ajax(url, {});
		$.ajax('data.jsp?num=123', {
			success : function(data){
				$('div').append(data);	
			}
		});
	});


</script>
</head>
<body>

	<h1>ajax-1.jsp</h1>
	<hr>
	<div></div>

</body>
</html>




