<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty replyList}">
	<c:forEach items="${replyList}" var="reply">

		<div id="reply${reply.idx}" class="reply">
			<div class="img">
				<img src="/op/uploadfile/${reply.photo}">
			</div>
			<div class="content">
				<h4>${reply.userName}</h4>
				<div>
					<pre>${reply.content}</pre>
				</div>
				<div>${reply.regdate}</div>
			</div>
			<div class="close">
				<div onclick="deleteReply(${reply.idx})">X</div>
			</div>
		</div>

	</c:forEach>
</c:if>