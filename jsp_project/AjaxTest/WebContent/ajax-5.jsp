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
		
		// $.get(url, data, success)
		/* $.get('data.html', function(data){
			$('#list').html(data);
		}); */
		
		$.post('data.html', function(data){
			$('#list').html(data);
		});
		
		
	});


</script>
</head>
<body>

	<h1> 메뉴 표 </h1>
	<hr>

			<input type="text" id="pname" placeholder="제품이름 입력">
			<input type="number" id="price" placeholder="제품 가격 입력">
			<input type="submit" id="btn">

	<hr>
	<h3 id="list">
	
	</h3>

</body>
</html>




