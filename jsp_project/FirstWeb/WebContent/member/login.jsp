<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Date now = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	String nowDate = format.format(now); // 오늘 날짜 문자열 2021-12-08

	if (nowDate.endsWith("12")) {
		// 다른 페이지로 이동
		response.sendRedirect("underCheck.jsp");
		return;
	}

	//////////////////////////////////////////////
	// 로그인 처리
	// 사용자 입력 데이터 id/pw를 확인/체크
	// 성공: session 에서 사용자 정보를 저장
	// 이번 테스트의 로그인 성공: id와 pw가 같을 때 성공으로 한다!!!
	// 실패: 로그인 페이지로 이동

	// 사용자 데이터 받기
	request.setCharacterEncoding("utf-8");

	// 스크립트릿 영역: Java 문법 코드 작성
	String uid = request.getParameter("userid");
	// request: 내장객체 (변수의 선언이 없고, 객체의 생성도 없다)
	String pw = request.getParameter("pw");

	if (uid.equals(pw)) {
		// 로그인 성공
		// session 객체 속성에 로그인 정보 저장: id만 저장
		session.setAttribute("id", uid);
	
		request.setAttribute("num1", 1);
		application.setAttribute("num2", 2);
	
		// mypage.jsp 이동
		response.sendRedirect("mypage.jsp");
	} else {
		// 로그인 실패: loginForm.html -> login.jsp
			%>
			<script>
				alert('로그인 실패! 로그인 페이지로 이동합니다.');
				//location.href='';
				// history.back();
				history.go(-1);
			</script>
		<%
		return;
		}
		%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>Login Form Data</h1>
	<!-- Test -->
	<%-- Test --%>


	아이디: <%=uid%>
	<br> 비밀번호: <%=request.getParameter("pw")%>

	<br>
	<%=new Date()%>
	<br>
	<%=nowDate%>
	<br> View Count
	<%=application.getAttribute("cnt")%>

</body>
</html>