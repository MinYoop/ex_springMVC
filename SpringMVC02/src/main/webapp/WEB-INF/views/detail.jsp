<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

<form action="update.do">
	<table border="1">
		<tr>
			<td><input type="text" name="id" value="${dto.id }"></td>
			<td><input type="text" name="password" value="${dto.password }"></td>
			<td><input type="text" name="name" value="${dto.name }"></td>
			<td><input type="submit" value="수정"	>
			<td><input type="button" value="삭제" onclick="location.href='delete.do?id=${dto.id}' "></td>
			<td><input type="button" value="뒤로가기" onclick="location.href='list.do' "></td>
		</tr>
	</table>
</form>	
</body>
</html>