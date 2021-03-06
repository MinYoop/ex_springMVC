<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%request.setCharacterEncoding("UTF-8");%>
<%response.setContentType("text/html; charset=UTF-8");%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- enctype : 폼에서 넘겨받은 데이터들의 인코딩 
		form tag의 enctype 속성
		1. application/www-form-urlencoded : (defalut) 문자 encoding
		2. multipart/form-data : file upload (post로 보내야함) : request header에 크기가 제한되어 있어서 ?
		3. text/plain : encoding 하지 않는다 . 내용자체로 보낸다.
		4. 
	 -->
	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
		<h3>업로드 할 파일 선택</h3>
		파일 : <input type="file" name="file" /><br/>
		<p style="color: red; font-weight: bold;">
			<form:errors path="file" />
		</p><br/>
		설명 : <br/>
		<textarea rows="10" cols="40" name="desc" ></textarea><br/>
		<input type="submit" value="전송">
	</form:form>
	<!--
		 form:errors - errors(bindingResult) 사용 시,
		 command 객체의 특정 field에서 발생한 에러 메시지 출력
	 -->

</body>
</html>