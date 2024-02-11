<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
<h1>Congratulations ${employeeEntity.employeeName} you are a valid user</h1>
  <h2>Basic Table</h2>
  <p>The .table class adds basic styling (light padding and horizontal dividers) to a table:</p>            
  <table class="table">
    <thead>
      <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Salary</th>
        <th>Password</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${employeeEntity.employeeName}</td>
        <td>${employeeEntity.emailId}</td>
        <td>${employeeEntity.salary}</td>
        <td>${employeeEntity.password}</td>
      </tr>
  
    </tbody>
  </table>
  <a href="showAll">Display all users</a>
</div>

</body>
</html>

