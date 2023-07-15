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
	
		
		Connection con = DbConnection.connect();
	
		String status = "approved";
		int OrderId = Integer.parseInt(request.getParameter("OrderId"));
		PreparedStatement pst = con.prepareStatement("update userbook set status = ? where oid = ?");
		pst.setString(1,status);
		pst.setInt(2, OrderId);
		int m=pst.executeUpdate();
		
		
		String mobile=Demo.getMobile();
		int precng=0,remain=0;
		int order = Demo.getOrder();
		
		PreparedStatement pstmt = con.prepareStatement("select * from userbook where oid = ? and status = ?");
		pstmt.setInt(1, OrderId);
		pstmt.setString(2, status);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			order=rs.getInt(6);
		}
		PreparedStatement pstmt1 = con.prepareStatement("select * from pumpreg where mobile = ?");
		pstmt1.setString(1, mobile);
		ResultSet rs1=pstmt1.executeQuery();
		while(rs1.next())
		{
			precng=rs1.getInt(13);
		}
		remain=precng-order;
		PreparedStatement pstmt2=con.prepareStatement("update pumpreg set cngkg = ? where mobile = ?");
		pstmt2.setInt(1, remain);
		pstmt2.setString(2, mobile);
		int i=pstmt2.executeUpdate();
		
		if(i>0)
		{
			response.sendRedirect("apuser.jsp");
		}
	%>
</body>
</html>