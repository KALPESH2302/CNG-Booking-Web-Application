<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<style>
body{
	background-image : url("e.png")
}
</style>


</head>
<body>
	<h><center>
 <h1>Registrations for Approvals</h1></h>
	<%@ page import="java.sql.*" %>
	<%@ page import="Booking.*" %>
	

	<%
	
		Connection con = DbConnection.connect();
		PreparedStatement pst = con.prepareStatement("select * from pumpreg");
		ResultSet rs = pst.executeQuery();
	%>
	
	
	<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
	
	
	<table style="width:100%" border="1">
	<tr>
		<th>PumpId</th>
		<th>PName</th>
		<th>Address</th>
		<th>City</th>
		<th>Taluka</th>
		<th>District</th>
		<th>OpTime</th>
		<th>ClTime</th>
		<th>MobileNo</th>
		<th>Latitude</th>
		<th>Longitude</th>
		<th>CNG in KG</th>
		<th>Status</th>
		
	</tr>
	
	<%while(rs.next()){ %>	
	<tr>
		<td><%=rs.getInt(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getString(4) %></td>
		<td><%=rs.getString(5) %></td>
		<td><%=rs.getString(6) %></td>
		<td><%=rs.getString(7) %></td>
		<td><%=rs.getString(8) %></td>
		<td><%=rs.getString(9) %></td>
		<td><%=rs.getString(10) %></td>
		<td><%=rs.getString(11) %></td>
		<td><%=rs.getString(13) %></td>
		<td><%=rs.getString(14) %></td>
		<td><a href="approve.jsp?PumpId=<%=rs.getInt(1) %>">approve</a></td>
	
	</tr>
	<%} %>
	</table>
</body>
</html>