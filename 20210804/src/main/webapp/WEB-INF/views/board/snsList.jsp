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
	<div align="center">
		<c:forEach var="sns" items="${list }">
			글 번호 : ${sns.SNo } / 제목 : ${sns.STitle } <br>
		</c:forEach>
	</div>
</body>
</html>