<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Login Page</title>
</head>
<body>
<h1>Login Form</h1>
	${msg}
	<form action="login" method="post">
	<a href="registration">Need an account? Register here!</a>
	<br><br>
		<label style="font-size: 18px;"> Username</label> <input type="text"
			name="email" class="form-control" placeholder="Enter email" style="width: 60%;" /> <label
			style="font-size: 18px;"> Password</label> <input type="password"
			name="pswd" class="form-control" placeholder="Enter password" style="width: 60%;" /><br>
		<button type="submit" class="btn btn-info">Login</button>
		<button type="reset" class="btn btn-danger">Reset</button>
	</form>
</body>
</html>