<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>고객 목록</h1>
	<c:choose>
		<c:when test="${empty list  }">
			<h3>****고객 정보가 없습니다.****</h3>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>id</th>
					<th>비밀번호</th>
					<th>이름</th>
				</tr>

				<c:forEach var="dto" items="${list }">
					<tr>
						<td>${dto.id }</td>
						<td>${dto.password }</td>
						<td>${dto.name }</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>


</body>
</html>