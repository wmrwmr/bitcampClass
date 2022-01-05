<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>상품 주문</h1>
	<hr>
	<form method="post">
	
		<table>
			<tr>
				<td rowspan="3">제품 1</td>
				<td> 아이디 </td>
				<td> <input type="text" name="orderItems[0].itemId"> </td>
			</tr>
			<tr>
				<td> 수량 </td>
				<td> <input type="number" name="orderItems[0].number"> </td>
			</tr>
			<tr>
				<td> 주의 </td>
				<td> <input type="text" name="orderItems[0].remark"> </td>
			</tr>
			<tr>
				<td rowspan="3">제품 2</td>
				<td> 아이디 </td>
				<td> <input type="text" name="orderItems[1].itemId"> </td>
			</tr>
			<tr>
				<td> 수량 </td>
				<td> <input type="number" name="orderItems[1].number"> </td>
			</tr>
			<tr>
				<td> 주의 </td>
				<td> <input type="text" name="orderItems[1].remark"> </td>
			</tr>
			<tr>
				<td rowspan="3">제품 3</td>
				<td> 아이디 </td>
				<td> <input type="text" name="orderItems[2].itemId"> </td>
			</tr>
			<tr>
				<td> 수량 </td>
				<td> <input type="number" name="orderItems[2].number"> </td>
			</tr>
			<tr>
				<td> 주의 </td>
				<td> <input type="text" name="orderItems[2].remark"> </td>
			</tr>
			<tr>
				<td rowspan="3"> 주소 </td>
				<td> 우편번호 </td>
				<td> <input type="text" name="address.zipcode"> </td>
			</tr>
			<tr>
				<td> 주소1 </td>
				<td> <input type="text" name="address.address1"> </td>
			</tr>
			<tr>
				<td> 주소2 </td>
				<td> <input type="text" name="address.address2"> </td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td> 
					<input type="submit"> <input type="reset">
				</td>
			</tr>
			
		</table>
	
	</form>
	

</body>
</html>