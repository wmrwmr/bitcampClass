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
		
		$('#myform').submit(function(){
			
			var param = {
				pname : $('#pname').val(),
				price : $('#price').val()
			};
			
			console.log('param1', $.param(param));
			console.log('param2', $(this).serialize());
			console.log('param3', $(this).serializeArray());
			
			$.ajax({
				url : 'parameter.jsp', // 통신 경로
				type : 'get', // http method : get, post, put, delete
				/* data : {
					pname : $('#pname').val(),
					price : $('#price').val() 
				}, */
				/* data : $(this).serialize(), */
				data : $(this).serializeArray(),
				
				success : function(data){
					$('#list').append(data);
				}
			});
			
			return false;
		});
		
		
		
	});


</script>
</head>
<body>

	<h1> 메뉴 표 </h1>
	<hr>
		<form id="myform">
			<input type="text" id="pname" name="pname" placeholder="제품이름 입력">
			<input type="number" id="price" name="price" placeholder="제품 가격 입력">
			<input type="submit" id="btn">
		</form>
	<hr>
	<h3 id="list">
	
	</h3>

</body>
</html>




