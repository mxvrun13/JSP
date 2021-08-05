<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<h1>List</h1>
	<table border="1">
		<tr>
			<th width="100">아이디</th>
			<th width="100">이름</th>
			<th width="100">나이</th>
			<th width="100">취미</th>
			<th width="100">권한</th>
			<th width="100">상태</th>
		</tr>
		<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.id }</td>
				<td>${list.name }</td>
				<td>${list.age }</td>
				<td>${list.hobby }</td>
				<td>${list.author }</td>
				<td>${list.state }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>