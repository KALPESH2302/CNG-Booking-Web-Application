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
 * Servlet implementation class Reguser
 */
public class Reguser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reguser() {
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
		String uname=request.getParameter("uname");
		String mob=request.getParameter("mob");
		String city=request.getParameter("city");
		String Email=request.getParameter("Email");
		String psd=request.getParameter("psd");
		
		Connection con=DbConnection.connect();
		
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into userreg values(?,?,?,?,?,?)");
			pstmt.setInt(1, Id);
			pstmt.setString(2, uname);
			pstmt.setString(3, mob);
			pstmt.setString(4, city);
			pstmt.setString(5, Email);
			pstmt.setString(6, psd);
			int i=pstmt.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("index.html");
			}
			else
			{
				response.sendRedirect("reguser.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
