<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>상품 주문 완료 (${msg}) </h1>
	<hr>
	
	<h3> 주문 상품 </h3>
	<c:forEach items="${order.orderItems}" var="item">
		상품 아이디 : ${item.itemId} <br>
		수량 : ${item.number} <br>
		주의 : ${item.remark} <br><br>
	</c:forEach>
	
	<h3> 배송지 주소 </h3>
	(${order.address.zipcode}) ${order.address.address1} , ${order.address.address2}
	
	








</body>
</html>