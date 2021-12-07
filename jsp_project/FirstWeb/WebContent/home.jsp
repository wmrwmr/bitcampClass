<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
#header>h1 {
	text-align: center;
	border-bottom: 1px solid #aaa;
}

#news, #shopping {
	width: 45%;
	background-color: #ddd;
}

#new {
float: left;
}

#shopping {
float: right;
}

#news>h3, #shopping>h3 {
text-align: center;
}
</style>

</head>
<body>

	<%@ include file="include/header.jsp"%>
	<%@ include file="include/news.jsp"%>
	<%@ include file="include/shopping.jsp"%>



</body>
</html>