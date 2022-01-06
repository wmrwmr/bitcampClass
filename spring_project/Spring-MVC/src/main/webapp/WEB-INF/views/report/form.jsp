<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>리포트 등록 : 커멘드 객체를 이용</h1>
	<hr>
	
	<!--  action="/mvc/report/submit3" -->
	<form action="submit3" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>학번</td>
				<td> <input type="text" name="sno">  </td>
			</tr>
			<tr>
				<td>이름</td>
				<td> <input type="text" name="sname"> </td>
			</tr>
			<tr>
				<td>리포트 파일</td>
				<td> <input type="file" name="report"> </td>
			</tr>
			<tr>
				<td></td>
				<td> <input type="submit">  </td>
			</tr>
		</table>
	</form>


	<hr>

	<h1>리포트 등록 : MultipartHttpServletReqeust 객체를 이용</h1>
	<hr>
	
	<!-- action="/mvc/report/submit2" -->
	<form action="submit2" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>학번</td>
				<td> <input type="text" name="sno">  </td>
			</tr>
			<tr>
				<td>이름</td>
				<td> <input type="text" name="sname"> </td>
			</tr>
			<tr>
				<td>리포트 파일</td>
				<td> <input type="file" name="report"> </td>
			</tr>
			<tr>
				<td></td>
				<td> <input type="submit">  </td>
			</tr>
		</table>
	</form>


	<hr>

	<h1>리포트 등록 : @RequestParam을 이용</h1>
	<hr>
	
	<!-- action="/mvc/report/submit1" -->
	<form action="submit1" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>학번</td>
				<td> <input type="text" name="sno">  </td>
			</tr>
			<tr>
				<td>이름</td>
				<td> <input type="text" name="sname"> </td>
			</tr>
			<tr>
				<td>리포트 파일</td>
				<td> <input type="file" name="report"> </td>
			</tr>
			<tr>
				<td></td>
				<td> <input type="submit">  </td>
			</tr>
		</table>
	</form>

</body>
</html>