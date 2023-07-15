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
		<center><h1>Approvals for Booking Orders</h1></h>
	<%@ page import="java.sql.*" %>
	<%@ page import="Booking.*" %>
	

	<%
		String umobile=Demo.getUmobile(); 		
		Connection con = DbConnection.connect();
		PreparedStatement pst = con.prepareStatement("select * from userbook where umobile=?");
		pst.setString(1, umobile);
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
		<th>OrderId</th>
		<th>Pump Id</th>
		<th>Pump Mobile No.</th>
		<th>User Name</th>
		<th>Order(in KGs)</th>
		<th>Status</th>
		
	</tr>
	
	<%while(rs.next()){ %>	
	<tr>
		<td><%=rs.getInt(1) %></td>
		<td><%=rs.getInt(2) %></td>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getString(4) %></td>
		<td><%=rs.getInt(6) %></td>
		<td><%=rs.getString(7) %></td>
	
	</tr>
	<%} %>
	</table>
</body>
</html>