<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Departments</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function() {
		deptList();
		//목록 조회
		function deptList() {
			$.ajax({
				url : "deptList",
				dataType : "json",
				success : function(data) {
					$.each(data, function(i, data) {
						$("<div>").append($("<span>").html(data.department_id))
								.append($("<span>").html(data.department_name))
								.append($("<span>").html(data.manager_id))
								.append($("<span>").html(data.location_id))
								.appendTo($("#list"));
					})
				}
			});
		}
	})
</script>
</head>
<body>
	<h3>부서 관리</h3>
	<div id="list"></div>
	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModal">부서 등록</button>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">부서 등록</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>Department ID</label><input class="form-control" name="department_id">
					</div>
					<div class="form-group">
						<label>Department Name</label><input class="form-control" name="department_name">
					</div>
					<div class="form-group">
						<label>Manager ID</label><input class="form-control" name="manager_id">
					</div>
					<div class="form-group">
						<label>location ID</label><input class="form-control" name="location_id">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="deptInsert">Submit</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>