<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Controller" method="post">
<%
int id=Integer.parseInt(request.getParameter("id"));
String name=request.getParameter("id1");
%>
<center><header><p><b><u>Generate Investigation Report</u></b></p></header></center>
<center>Patient Id           : <input type="text" name="pid" value=<%=id%> readonly="readonly"></center><br>
<center>Patient Name         :<input type="text" name="pname" value=<%=name%> readonly="readonly"></center><br>
<center>Patient Investigation: <textarea rows="4" cols="50" name="pinves"></textarea></center> <br>
<center><input type="submit" name="action123" value="Generate"></center> 
</form>
</body>
</html>