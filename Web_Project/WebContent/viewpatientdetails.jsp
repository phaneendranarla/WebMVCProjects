<%@page import="Bean.Patient"%>
<%@page import="Bean.Doctor"%>

<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<Doctor> alist=(ArrayList<Doctor>)request.getAttribute("patient"); %>
<%if(request.getAttribute("update")!=null)
	{
	out.print((String)request.getAttribute("update"));
	}%>
<form action="Controller" method="post">
<table border="1px" bordercollapse="collapse">
<center>
<header>
<p><b><u>Patient Details</u></b></p>
</header>
<tr>
<td>PatientId</td>
<td>PatientName</td>
<td>PatientStatus</td>
<td>PatientInvestigation</td>
<td>DoctorId</td>
<td>DoctorName</td>
<td>DoctorSpecialization</td>
<td>Action</td>
</tr>
<% for(Doctor d:alist){%>
<% for(Patient p:d.getAp()){%>
<tr>
<td><% out.print(p.getPatientId()); %></td>
<td><% out.print(p.getPatientName());%></td>
<td><% out.print(p.getPatientStatus());%></td>
<td><% out.print(p.getPatientInvestigation());%></td>
<td><% out.print(d.getDoctorId());%></td>
<td><% out.print(d.getDoctorName());%></td>
<td><% out.print(d.getDoctorSpecialization());%></td>
<%if(p.getPatientStatus().equalsIgnoreCase("admitted")){ %>

<td> <a href="Controller?action=update&id=<%=p.getPatientId()%>&id1=<%=p.getPatientName()%>">Generate Investigation</a></td>
</tr>
<%}}} %>
</table>
<p align="center"><a href="home.jsp">Home</a></p>
</center>
</form>
</body>
</html>