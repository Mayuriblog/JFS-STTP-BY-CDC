import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String username = req.getParameter("username");
	        String password = req.getParameter("password");

	        try {
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_app", "root", "root");
	            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
	            ps.setString(1, username);
	            ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();

	            if(rs.next()) {
	                req.getSession().setAttribute("user", username);
	                resp.sendRedirect("chat.jsp");
	            } else {
	                resp.sendRedirect("login.jsp?error=invalid");
	            }
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


