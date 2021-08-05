<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<jsp:include page="../home/header.jsp"/>
<body>
	<div align="center">
		<div><h1>Log-in</h1></div>
		<div>
			<form id="frm" action="login.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="150">ID</th><td width="200"><input type="text" id="id" name="id" placeholder="id" required="required"></td>
						</tr>
						<tr>
							<th width="150">Pass</th><td width="200"><input type="password" id="password" name="password" placeholder="pass" required="required"></td>
						</tr>
					</table>
				</div><br>
				<div>
					<input type="submit" value="login">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="cancel">
				</div>
			</form>
		</div>
	</div>
</body>
</html>