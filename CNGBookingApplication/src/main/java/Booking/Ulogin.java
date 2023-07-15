package Booking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ulogin
 */
public class Ulogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ulogin() {
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
		
		String Email=request.getParameter("Email");
		String psd=request.getParameter("psd");
		String umobile =request.getParameter("umobile");
		Demo.setUmobile(umobile);
		
		Connection con=DbConnection.connect();		
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from userreg where email=? and mobile=? and pwd=?");
			pstmt.setString(1, Email);
			pstmt.setString(2, umobile);
			pstmt.setString(3, psd);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				response.sendRedirect("udetail.html");
			}
			else
			{
				response.sendRedirect("userlog2.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
