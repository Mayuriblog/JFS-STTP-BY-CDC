import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
@WebServlet("/sendMessage")
public class MessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	String senderUsername = (String) req.getSession().getAttribute("user");
    	String content = req.getParameter("message");
    	String roomIdStr = req.getParameter("room_id"); // ✅ get room_id from form

    	try {
    	    int roomId = Integer.parseInt(roomIdStr); // ✅ convert room_id to int

    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	    Connection conn = DriverManager.getConnection(
    	        "jdbc:mysql://localhost:3306/chat_app", "root", "root");

    	    // Step 1: Lookup sender_id from username
    	    PreparedStatement findUser = conn.prepareStatement(
    	        "SELECT user_id FROM users WHERE username = ?");
    	    findUser.setString(1, senderUsername);
    	    ResultSet rs = findUser.executeQuery();

    	    if (rs.next()) {
    	        int senderId = rs.getInt("user_id");

    	        // ✅ Step 2: Insert message with room_id
    	        PreparedStatement ps = conn.prepareStatement(
    	            "INSERT INTO messages (sender_id, room_id, content) VALUES (?, ?, ?)");
    	        ps.setInt(1, senderId);
    	        ps.setInt(2, roomId);     // ✅ insert room_id
    	        ps.setString(3, content);
    	        ps.executeUpdate();

    	        resp.sendRedirect("chat.jsp");
    	    } else {
    	        resp.getWriter().println("User not found.");
    	    }

    	    conn.close();
    	} catch (Exception e) {
    	    e.printStackTrace();
    	    resp.getWriter().println("Error: " + e.getMessage());
    	}

    }
}
