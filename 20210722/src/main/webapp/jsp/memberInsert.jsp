<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	int age = Integer.valueOf(request.getParameter("age"));
	String[] hobby = request.getParameterValues("hobby"); // 배열은 values 사용
%>
<body>
	<div align="center">
		<div><h1>회원가입내역</h1></div>
		<div>
			<h3>아이디 : <%= id %> : ${param.id }</h3>
			<h3>패스워드 : <%= password %></h3>
			<h3>이	름 : <%= name %></h3>
			<h3>나	이 : <%= age %></h3>
			<h3>취	미 : <% for(String h : hobby) {
								out.print(h + " "); } %></h3>
			<h3>EL 취미 : ${paramValues.hobby[0] }</h3>
		</div>
	</div>
</body>
</html>