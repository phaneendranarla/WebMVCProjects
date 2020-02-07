<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="SaveServlet" method="post">
	<div align = "center">
	<table border="1px" bordercollapse="collapse">
	<tr><td><header>
		<h1>Add New Employee</h1>
	</header></td></tr>
	<tr><td>Id       :<input type="text" name="id"></td></tr><br>
	<tr><td>Name     : <input type="text" name="ename"></td></tr><br>
	<tr><td>Password : <input type="password" name="password"></td></tr><br>
	<tr><td>Email    : <input type="text" name="email"></td></tr><br>
	<tr><td>
			<select name="country"style="width:150px">  
				<option>select</option>
				<option>India</option>  
				<option>USA</option>  
				<option>UK</option>  
				<option>Other</option>  
			</select>
	</td></tr><br>
	</table><br>
	<input type="submit" name="save" value = "Save Employee">
	</div>
</form> <br>
<a href="ViewServlet">View Employees</a>
<div>
</body>
</html>