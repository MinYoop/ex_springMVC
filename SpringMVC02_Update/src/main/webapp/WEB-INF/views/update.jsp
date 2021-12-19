<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<h1>update</h1>

	<form action="updateAction.do">
		<table border="1">
			<tr>
				<td>ID :</td>
				<td><input type="text" name="id" value="${dto.id }" readonly="readonly"></td>
			</tr>
			<tr>
				<td>password :</td>
				<td><input type="text" name="password" placeholder="${dto.password }"></td>
			</tr>
			<tr>
				<td>name :</td>
				<td><input type="text" name="name" placeholder="${dto.name }"></td>
			</tr>
			<tr>
				<td><input type="submit" value="확인"></td>
			</tr>
		</table>
	</form>
</body>
</html>