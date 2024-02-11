<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
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
		
		<h2>Registration Form</h2>
		<a href="login">Already have an account? Login here!</a>
	<br><br>
		<h3>${message}</h3>
		<form action="registration" method="post">



			<div class="form-group">
				<label for="empName">Employee Name:</label> <input type="text"
					class="form-control" placeholder="Enter name" name="employeeName">
			</div>

			<div class="form-group">
				<label for="salary">Salary:</label> <input type="text"
					class="form-control" placeholder="Enter salary" name="salary">
			</div>

			<div class="form-group">
				<label for="emailId">Email Id:</label> <input type="text"
					class="form-control" placeholder="Enter email" name="emailId">
			</div>

			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" placeholder="Enter password" name="password">
			</div>

			<button type="submit" class="btn btn-primary">Register</button>


		</form>
	</div>

</body>
</html>