<%@page import="bean.Employee"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.ArrayList"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%ArrayList<Employee> alist = (ArrayList<Employee>)request.getAttribute("Employees"); %>


<div align = "center">
<table border="1px" bordercollapse="collapse">
<center>
<header>
<p><b><u>All Employees</u></b></p>
</header>
<tr>
<td>Id</td>
<td>Name</td>
<td>Password</td>
<td>Email</td>
<td>Country</td>
<td>Edit</td>
<td>Delete</td>
</tr>
<% for(Employee e:alist){%>
<tr>
<td><% out.print(e.getId()); %></td>
<td><% out.print(e.getName());%></td>
<td><% out.print(e.getPassword());%></td>
<td><% out.print(e.getEmail());%></td>
<td><% out.print(e.getCountry());%></td>
<td> <a href="edit.jsp?action=update&id=<%=e.getId()%>">edit</a> </td>
<td> <a href="DeleteServlet?action=update&id=<%=e.getId()%>">delete</a> </td>
<%} %>
</table>
<p align="center"><a href="home.jsp">Home</a></p>
</center>
</div>
</body>
</html>