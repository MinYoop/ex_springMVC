<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>insert</h1>

	<form action="insertAction.do">
		<table border="1">
			<tr>
				<td>ID :</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>password :</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td>name :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><input type="submit" value="확인"></td>
			</tr>
		</table>
	</form>
</body>
</html>