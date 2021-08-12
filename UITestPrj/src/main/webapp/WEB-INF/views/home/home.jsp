<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div align="center">
		<h1>로그인</h1>
		<form id="frm" name="frm" action="login.do" method="post">
		<div>
			<table border="1">
				<tr>
					<th width="100">아이디</th><td><input type="text" id="id" name="id"></td>
				</tr>
				<tr>
					<th>패스워드</th><td><input type="password" id="password" name="password"></td>
				</tr>
			</table>
		</div><br><br>
		<button type="submit">로그인</button>&nbsp;&nbsp;<button type="reset">취소</button>
		</form>
	</div>
</body>
</html>