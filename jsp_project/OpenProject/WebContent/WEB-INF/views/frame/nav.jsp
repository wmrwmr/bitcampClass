<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<nav>
		<ul>
			<li><a href="${pageContext.request.contextPath}/member/reg.do">회원 가입</a></li>
			<li><a href="${pageContext.request.contextPath}/member/manager/list.do">회원 리스트</a></li>
			<li><a href="${pageContext.request.contextPath}/member/my/mypage.do">마이페이지</a></li>
			
			
			<c:if test="${empty loginInfo}">
			<li><a href="${pageContext.request.contextPath}/member/login.do">로그인</a></li>
			</c:if>
			
			<c:if test="${not empty loginInfo}">
			<li><a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a></li>
			</c:if>
			
			<li><a href="${pageContext.request.contextPath}/guestbook/write.do">방명록 글쓰기</a></li>
			<li><a href="${pageContext.request.contextPath}/guestbook/list.do">방명록 리스트</a></li>
			
		</ul>
	</nav>