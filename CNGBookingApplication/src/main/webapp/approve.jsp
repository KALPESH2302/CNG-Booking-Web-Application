<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.sql.*" %>
    <%@ page import="Booking.*" %>
	

	<%
	
		String status = "approved";
		Connection con = DbConnection.connect();
		int PumpId = Integer.parseInt(request.getParameter("PumpId"));
		PreparedStatement pst = con.prepareStatement("update pumpreg set status = ? where id = ?");
		pst.setString(1,status);
		pst.setInt(2, PumpId);
		int i = pst.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("appump.jsp");
		}
	%>
</body>
</html>