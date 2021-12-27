<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>

<style>

#content>div {
	padding: 15px;
}

#content>table {
	border: 0;
	border-collapse: collapse;
	
	width: 900px;
}
#content>table td, #content>table th {
	border: 1px solid #aaa;
	padding: 10px;
	
	text-align: center;
}

#listInfo {
	border : 1px solid #aaa;
	width : 870px;
}

#paging {
	overflow: hidden;
}

#paging>a {
	display: block;
	
	width: 30px;
	height: 30px;
	
	border: 1px solid #aaa;
	
	text-align: center;
	line-height: 30px;
	
	float : left;
	
	margin-right: 5px;
	
	text-decoration: none;
}

#paging>a:hover {
	background-color: #ff0;
	color: #00f;
}

.curpage {
	background-color: #333;
	color: #fff;
}

</style>
</head>
<body>

	<!-- 해더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 해더 끝 -->

	<!-- 네비게이션 시작 -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	<!-- 네비게이션 끝 -->

	<!-- content 시작 -->
	<div id="content">
		<h3>회원 리스트</h3>
		<hr>
		<div id="listInfo">
			전체 회원 수: ${listView.totalCount}명 , 현재 페이지: ${listView.currentPage}/${listView.pageTotalCount} 
		</div>
		<table>
			<tr>
				<th>idx</th>
				<th>user ID</th>
				<th>password</th>
				<th>user Name</th>
				<th>photo</th>
				<th>regdate</th>
				<th>manage</th>
			</tr>
			
			<c:if test="${empty listView.list}">\
			<tr>
				<td colspan="7">등록된 회원 데이터가 없습니다.</td>
			</tr>
			</c:if>
			<c:if test="${not empty listView.list}">
			
			<c:forEach items="${listView.list}" var="member">
			<tr>
				<td>${member.idx}</td>
				<td>${member.userid}</td>
				<td>${member.pw}</td>
				<td>${member.username}</td>
				<td>${member.photo}</td>
				<td>${member.regdate}</td>
				<td>
					<a href="edit.do?idx=${member.idx}">수정</a>					
					<a href="javascript:delMember(${member.idx})">삭제</a>
				</td>
			</tr>
			</c:forEach>
			
			</c:if>
			
			
		</table>
		<div id="paging">
			<c:if test="${listView.pageTotalCount > 0}">
			
			<c:forEach begin="1" end="${listView.pageTotalCount}" var="pnum">
				<a href="list.do?p=${pnum}" class="${listView.currentPage eq pnum ? 'curpage': ''}">${pnum}</a>  
			</c:forEach>
			
			</c:if>
		</div>
		
		
	
	</div>
	<!-- content 끝 -->


	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp" %>

<script>

function delMember(idx){
	
	if(confirm("해당 회원 정보를 삭제하시겠습니까?")){
		location.href = 'delete.do?idx='+99;
	}
	
}

</script>

</body>
</html>








