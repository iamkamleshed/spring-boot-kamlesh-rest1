<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h1>All Records</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Employee Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Salary</th>
				<th>Password</th>
				<th colspan=2>Action(delete/edit)</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tempVar" items="${listOfEmployees}">
				<tr>
					<td>${tempVar.employeeId}</td>
					<td>${tempVar.employeeName}</td>
					<td>${tempVar.emailId}</td>
					<td>${tempVar.salary}</td>
					<td>${tempVar.password}</td>
					<td><a href="deleteEmployee?employeeId=${tempVar.employeeId}">
							<button type="button" class="btn btn-danger">
								<img src="images/delete.jpg" alt="delete logo"
									style="height: 30px; width: 30px">
							</button>
					</a></td>
					<td><a href="updateEmployee?employeeId=${tempVar.employeeId}">
							<button type="button" class="btn btn-edit">
								<img src="images/edit.jpg" alt="edit logo"
									style="height: 30px; width: 30px">
							</button>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>