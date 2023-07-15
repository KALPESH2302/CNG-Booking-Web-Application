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
 * Servlet implementation class Ubook
 */
public class Ubook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ubook() {
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

		int oid = 0;
		int pid = Integer.parseInt(request.getParameter("pid"));
		String mobile = request.getParameter("mobile");
		String uname = request.getParameter("uname");
		String umobile = request.getParameter("umobile");
		int order = Integer.parseInt(request.getParameter("order"));

		Demo.setOrder(order);

		String pending = "pending";

		Connection con = DbConnection.connect();
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into userbook values(?,?,?,?,?,?,?)");
			pstmt.setInt(1, oid);
			pstmt.setInt(2, pid);
			pstmt.setString(3, mobile);
			pstmt.setString(4, uname);
			pstmt.setString(5, umobile);
			pstmt.setInt(6, order);

			pstmt.setString(7, pending);

			int i = pstmt.executeUpdate();

			if (i > 0) {
				response.sendRedirect("udetail.html");
			} else {
				response.sendRedirect("ubook.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
