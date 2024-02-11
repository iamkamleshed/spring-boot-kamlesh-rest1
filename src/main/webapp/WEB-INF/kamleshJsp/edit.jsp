<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

		<h2>Update Form</h2>
		<a href="login">Ready to Login? Login here!</a> <br>
		<br>
		<h3>${message}</h3>
		<form action="finalUpdateEmployee" method="post">

			<div class="form-group">
				<label for="empId">Employee ID:</label> <input type="text"
					class="form-control"  name="employeeId" value ="${employeeEntity.employeeId }" readonly>
			</div>

			<div class="form-group">
				<label for="empName">Employee Name:</label> <input type="text"
					class="form-control"  name="employeeName" value ="${employeeEntity.employeeName }">
			</div>

			<div class="form-group">
				<label for="salary">Salary:</label> <input type="text"
					class="form-control"  name="salary"value ="${employeeEntity.salary }">
			</div>

			<div class="form-group">
				<label for="emailId">Email Id:</label> <input type="text"
					class="form-control"  name="emailId" value ="${employeeEntity.emailId }">
			</div>

			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" name="password" value ="${employeeEntity.password }">
			</div>

			<button type="submit" class="btn btn-primary">Update</button>


		</form>
	</div>

</body>
</html>