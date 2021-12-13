<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<c:set var = "number" value = "1000000" />
	
	<p>	
	
	<fmt:formatNumber value="100000" /> <br>
	<fmt:formatNumber value="${number}" /> <br>
	<fmt:formatNumber value="${number}" groupingUsed = "false" /> <br>
	<fmt:formatNumber value="${number}" var="num" /> <br>
	
	숫자: ${num} <br>
	퍼센트: <fmt:formatNumber value="${number/4000000}" type="percent" /> <br>
	통화: <fmt:formatNumber value="${number}" type="currency" currencySymbol="\\" /> <br>
	패턴: <fmt:formatNumber value="${number*1000}" pattern="000,000.00"/>
	</p> 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>