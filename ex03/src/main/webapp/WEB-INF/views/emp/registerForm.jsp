<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
<style type="text/css">
	.required {
		color : red;
	}
	.emp{
		cursor: pointer;
	}
	.emp:hover {
		color : blue;
	}
</style>
<script type="text/javascript">
	//매니저 검색
	$(function() {
		fuuction validation() {
			if(frm.last_name.value == "") {
				alert("이름 입력");
				frm.last_name.focus();
				return false;
			}
			return 
		}
		//등록 버튼 이벤트
		$("#btnRegister").on("click", function(){
			if(validation()) {
				frm.submit();
			}
		})
	
		$("#btnEmpSearch").on("click", function() {
			//검색페이지를 ajax -> modal body에 추가
			$.ajax({
				url : "search",
				success : function(data) {
					$("#exampleModal .modal-body").html(data);
					$("#exampleModal").modal('show');
				}
			});
		});
		//매니저 단건 검색
		$("#manager_id").on("keydown", function(e) {
			$("#name").val("");
			if ($("#manager_id").val() == "") {
				return;
				if (e.keyCode == 13) {
					e.preventDefault();
					$.ajax({
						url : "ajaxEmp",
						data : {
							employee_id : $("#manager_id").val()
						},
						success : function(data) {
							if (data) {
								$("#manager_name").val(data.first_name)
							} else {
								$("#btnEmpSearch").click();
							}
						}
					});
				}
			}
		});
	});
</script>
</head>
<body>
	<div id="page-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Employee Register</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel-body">
						<form name="frm" role="form"
							action="${empty emp ? 'updateForm' : 'registerForm'}"
							method="post">
							<c:if test="${not empty emp}">
							<div class="form-group">
								<label>Employee ID</label><span class="required">*</span> <input class="form-control"
									name="employee_id" value="${emp.employee_id }">
							</div>
							</c:if>
							<div class="form-group">
								<label>First Name</label> <input class="form-control"
									name="first_name" value="${emp.first_name }">
							</div>
							<div class="form-group">
								<label>Last Name</label> <input class="form-control"
									name="last_name" value="${emp.last_name }">
							</div>
							<div class="form-group">
								<label>Email</label> <input class="form-control" name="email" value="${emp.email }"><span id="result"></span>
							</div>
							<div class="form-group">
								<label>Phone Number</label> <input class="form-control"
									name="phone_number" value="${emp.phone_number }">
							</div>
							<div class="form-group">
								<label>Hire Date</label> <input type="date" class="form-control"
									name="hire_date" value="${emp.hire_date }">
							</div>
							<div class="form-group">
								<label>Job ID</label><br> <select class="custom-select"
									name="job_id">
									<c:forEach var="job" items="${opt.jobs }">
										<option value="${job.job_id })">${job.job_title }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label>Salary</label> <input class="form-control" name="salary" value="${emp.salary }">
							</div>
							<div class="form-group">
								<label>Commission PCT</label> <input class="form-control"
									name="commission_pct" value="${emp.commission_pct }">
							</div>
							<div class="form-group">
								<label>Manager ID</label><br> <input id="manager_id"
									name="manager_id" value="${emp.manager_id }">&nbsp;<input id="manager_name">&nbsp;
								<button type="button" class="btn btn-secondary"
									id="btnEmpSearch">검색</button>
							</div>
							<div class="form-group">
								<label>department ID</label><br> <select
									class="custom-select" name="department_id">
									<c:forEach var="dept" items="${opt.depts }">
										<option value="${dept.department_id })">${dept.department_name }</option>
									</c:forEach>
								</select>
							</div>
							<button type="button" id="btnRegister" class="btn btn-success">등록</button>
							<button type="reset" class="btn btn-danger">취소</button>
						</form>
					</div>
				</div>
			</div>
			<div id="exampleModal" class="modal" tabindex="-1">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title">Modal title</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<p>Modal body text goes here.</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary">Save
								changes</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>