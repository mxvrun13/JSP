<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath }/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath }/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath }/resources/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath }/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- jQuery -->
<script
	src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script
	src="${pageContext.request.contextPath }/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script
	src="${pageContext.request.contextPath }/resources/vendor/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script
	src="${pageContext.request.contextPath }/resources/dist/js/sb-admin-2.js"></script>

<script src="https://cdn.datatables.net/1.11.1/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#emp').DataTable();
	});
</script>
</head>
<body>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Employees</h1>
				</div>
				<table id="emp" class="display table table-striped table-bordered table-hover dataTable no-footer dtr-inline" style="width:100%">
					<thead>
						<tr>
							<th>Employee ID</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Phone Number</th>
							<th>Hire Date</th>
							<th>Job ID</th>
							<th>Salary</th>
							<th>Commission PCT</th>
							<th>Manager ID</th>
							<th>Department ID</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="emp" items="${list }">
							<tr>
								<td>${emp.employee_id }</td>
								<td><a
									href="updateForm?employee_id=${emp.employee_id}">${emp.first_name }</a></td>
								<td>${emp.last_name }</td>
								<td>${emp.email }</td>
								<td>${emp.phone_number }</td>
								<td><fmt:formatDate value="${emp.hire_date }"
										pattern="yyyy-MM-dd" /></td>
								<td>${emp.job_id }</td>
								<td>${emp.salary }</td>
								<td>${emp.commission_pct }</td>
								<td>${emp.manager_id }</td>
								<td>${emp.department_id }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a class="btn btn-default btn-lg btn-block"
					href="${pageContext.request.contextPath }/emp/registerForm">Register</a>
			</div>
		</div>
	</div>
</body>

</html>