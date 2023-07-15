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
 * Servlet implementation class Pumplog
 */
public class Pumplog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Pumplog() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String mobile = request.getParameter("mobile");
		String psd = request.getParameter("psd");
		String status = "approved";

		Connection con = DbConnection.connect();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from pumpreg where mobile=? and password=? and status=?");
			pstmt.setString(1, mobile);
			pstmt.setString(2, psd);
			pstmt.setString(3, status);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				response.sendRedirect("pdetail.html");
				Demo.setMobile(mobile);
			} else {
				response.sendRedirect("pumplog2.html");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
