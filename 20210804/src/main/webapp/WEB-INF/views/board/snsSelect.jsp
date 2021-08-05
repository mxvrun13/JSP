<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	글 번호 : ${sns[0].SNo } / 제목 : ${sns[0].STitle } <br>
	<c:forEach var="comment" items="${sns }">
		댓글 번호 : ${comment.CNo } / 내용 : ${comment.CSubject }<br>
	</c:forEach>
</body>
</html>