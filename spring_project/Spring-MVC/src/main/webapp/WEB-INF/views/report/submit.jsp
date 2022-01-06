<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>리포트 등록 </h1>
	<hr>
		<table>
			<tr>
				<td>학번</td>
				<td> ${sno}  </td>
			</tr>
			<tr>
				<td>이름</td>
				<td> ${sname} </td>
			</tr>
			<tr>
				<td>리포트 파일</td>
				<td> ${report} <br> ${report.report.originalFilename} </td>
			</tr>
		</table>

</body>
</html>