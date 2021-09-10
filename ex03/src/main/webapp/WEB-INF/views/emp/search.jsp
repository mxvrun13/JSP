<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="emp" items="${list }">
	<div class="emp">
		<span>${emp.employee_id }</span>
		<span>${emp.first_name }</span>
		<span>${emp.last_name }</span>
		<span>${emp.email }</span>
	</div>
</c:forEach>
<script>
	$(function(){
		$(".emp").on("click", function(){
			var span = $(this).find("span");
			$("#manager_id").val(span.eq(0).text());
			$("#manager_name").val(span.eq(1).text());
			$("#exampleModal").modal('hide');
		})
	});
</script>