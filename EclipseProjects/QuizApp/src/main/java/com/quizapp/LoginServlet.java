package com.quizapp;

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
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		HttpSession session = request.getSession();
		session.setAttribute("username", username);

		int userId = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb", "root", "root");

			PreparedStatement ps = conn.prepareStatement("INSERT IGNORE INTO users(username) VALUES (?)");
			ps.setString(1, username);
			ps.executeUpdate();

			// Now retrieve the ID
			ps = conn.prepareStatement("SELECT id FROM users WHERE username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				userId = rs.getInt("id");
				session.setAttribute("userId", userId);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("quiz.jsp");
	}
}
