<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int id=Integer.parseInt(request.getParameter("id")); %>
<div align="center">
<form action="EditServlet" method="post">
<h1>Update Employee</h1>
<table border="1px" bordercollapse="collapse">
	<tr><td>Id       : <input type="text" name="id" value=<%=id%> readonly="readonly"></td></tr><br>
	<tr><td>Name     : <input type="text" name="name"></td></tr><br>
	<tr><td>Password : <input type="password" name="password"></td></tr><br>
	<tr><td>Email    : <input type="text" name="email"></td></tr><br>
	<tr><td>
			<select name="country"style="width:150px">  
				<option>India</option>  
				<option>USA</option>  
				<option>UK</option>  
				<option>Other</option>  
			</select>
	</td></tr><br>
	</table><br>
<input type="submit" name="save" value="Edit & Save">
</div>
</form>
</body>
</html>