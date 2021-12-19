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

	<h1>고객 목록</h1>

	<c:choose>
		<c:when test="${empty list }">
			<h3>**고객 정보가 없습니다.**</h3>
		</c:when>
		<c:otherwise>
			<table border="1">
				<thead>
					<tr>
						<th>id</th>
						<th>password</th>
						<th>name</th>
						<th>자세히보기</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" items="${list }">
						<tr>
							<td><c:out value="${i.id }" /></td>
							<td><c:out value="${i.password }" /></td>
							<td><c:out value="${i.name }" /></td>
							<td><a href="detail.do?id=${i.id }">보기</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tr>
				<td colspan="2"/>
					<td><input type="button" value="추가하기"
						onclick="location.href='insert.do'"></td>
					<td><input type="button" value="뒤로가기"
						onclick="location.href='index.jsp'"></td>
				</tr>
			</table>
		</c:otherwise>

	</c:choose>

</body>
</html>