<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="memberList.do">리스트</a></h1>
	<div>
	<form id="frm" name="frm" action="memberSelect.do" method="POST">
		<input type="text" id="id" name="id">
		<button type="submit" value="검색">검색</button>
	</form>
	</div>
</body>
</html>