<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h1 class="h3 mb-2 text-gray-800">${list[0].sTitle }</h1>
		</div>
		<div class="card-body">${list[0].sContents }</div>
		<div class="card-footer">
			<p class="mb-4">${list[0].sWriter }/ ${list[0].sDate }</p>
		</div>
	</div>
	<c:forEach var="list" items="${list }">
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Comments</h6>
			</div>
			<div class="card-body">
				<p>${list.cName } ${list.cDate } </p>
				<p>${list.cSubject } </p>
			</div>
		</div>
	</c:forEach>
</div>
<!-- /.container-fluid -->

<!-- Page level plugins -->

<!-- Page level custom scripts -->
