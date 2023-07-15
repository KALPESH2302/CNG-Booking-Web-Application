package Booking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Regpump
 */
public class Regpump extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regpump() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		int Id=0;
		String pname=request.getParameter("pname");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String taluka=request.getParameter("taluka");
		String dist=request.getParameter("dist");
		String optime=request.getParameter("optime");
		String cltime=request.getParameter("cltime");
		String mobile=request.getParameter("mobile");
		String lat=request.getParameter("lat");
		String lon=request.getParameter("lon");
		String psd=request.getParameter("psd");
		int cngkg=Integer.parseInt(request.getParameter("cngkg"));
		String pending="pending";
		
		Connection con=DbConnection.connect();
		
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into pumpreg values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, Id);
			pstmt.setString(2, pname);
			pstmt.setString(3, address);
			pstmt.setString(4, city);
			pstmt.setString(5, taluka);
			pstmt.setString(6, dist);
			pstmt.setString(7, optime);
			pstmt.setString(8, cltime);
			pstmt.setString(9, mobile);
			pstmt.setString(10, lat);
			pstmt.setString(11, lon);
			pstmt.setString(12, psd);
			pstmt.setInt(13, cngkg);
			pstmt.setString(14, pending);
			
			int i=pstmt.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("index.html");
			}
			else
			{
				response.sendRedirect("regpump2.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}
