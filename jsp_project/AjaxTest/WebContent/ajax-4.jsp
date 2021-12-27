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
		
		$.getJSON('data.json', function(data){
			// data 는 JSON 문자열이 아니라 자바스크립트의 객체로 변환된 데이터
			//$.each(data,function(){});
			//$('h1').each(function(){});
			
			$.each(data, function(index, value){
				var html = '제품명: ' + value.name + ', 가격: ' + value.price + '원 <br>';
				$('#list').append(html);
			});
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




