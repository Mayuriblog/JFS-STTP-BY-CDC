
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {

	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	// first life cycle method in servlet
	public void init(ServletConfig config) throws ServletException {
		try {
			// to connect to database
			// load JDBC DRiver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish connection to Database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedb", "root", "root");
			stmt = con.createStatement();
			pstmt = con.prepareStatement("INSERT INTO REGISTRATION VALUES(?,?,?,?,?,?,?)");

			// second lifecycle method of servlet
			// use class instance variables in service()
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			// read form data
			String firstname = request.getParameter("firstname").trim();
			String lastname = request.getParameter("lastname").trim();
			String email = request.getParameter("email").trim();
			String password = request.getParameter("password").trim();
			long mobile = Long.parseLong(request.getParameter("mobile").trim());
			String address = request.getParameter("address").trim();
			// get PK value
			int regid = 0;
			rs = stmt.executeQuery("SELECT MAX(REGID) FROM REGISTRATION");
			if (rs.next()) {
				regid = rs.getInt(1);
			}
			regid++;
			// insert record stmt into db
			pstmt.setInt(1, regid);
			pstmt.setString(2, firstname);
			pstmt.setString(3, lastname);
			pstmt.setString(4, email);
			pstmt.setString(5, password);
			pstmt.setLong(6, mobile);
			pstmt.setString(7, address);
			int i = pstmt.executeUpdate();
			if (i == 1)
				out.println("Registration successful, regid is: " + regid);
			else
				out.println("Record not inserted");

		} catch (Exception e) {
			e.printStackTrace();
			out.println(e.getMessage());
		}
		out.flush();
		out.close();
	}

	public void destroy() {
		try {
			pstmt.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
