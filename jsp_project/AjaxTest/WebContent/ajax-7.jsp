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
		
		$.ajax({
			url : 'data.xml', // xml 문서
			// type : '' 생략 -> get
			success : function(data){
				// contentType : text/xml
				// data : xmlDoc 
				// 문자열( xml 문서 형식으로 작성 ) -> xml문서로 변환 -> $(xmlDox) jquery 객체로 변환
				$(data).find('product').each(function(){
					var pname = $(this).find('name').text();
					var price = $(this).find('price').text();
					
					var html = '이름: '+pname+', 가격: '+price+'원<br>'
					
					$('#list').append(html);
					
				});
			}
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




