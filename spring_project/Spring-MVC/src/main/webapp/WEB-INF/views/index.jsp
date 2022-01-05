<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	li {
		font-size: 1.5em;
	}
</style>

</head>
<body>

	<ul> 
		<li><a href="${pageContext.request.contextPath}/hello">/hello</a></li>
		<li><a href="${pageContext.request.contextPath}/form">/form</a></li>
		<li><a href="${pageContext.request.contextPath}/param">/param</a></li>
		<li><a href="${pageContext.request.contextPath}/member/reg">/member/reg</a></li>
		<li><a href="${pageContext.request.contextPath}/order/order">/order/order</a></li>
		<li><a href="${pageContext.request.contextPath}/cookie/make">/cookie/make</a></li>
		<li><a href="${pageContext.request.contextPath}/header/check">/header/check</a></li>
	</ul>










</body>
</html>