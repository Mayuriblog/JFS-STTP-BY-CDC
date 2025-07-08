package com.quizapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	HttpSession session = request.getSession();
    	Integer userId = (Integer) session.getAttribute("userId");
    	int score = 0;

    	try {
    	    Class.forName("com.mysql.jdbc.Driver");
    	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb", "root", "root");

    	    Statement stmt = conn.createStatement();
    	    ResultSet rs = stmt.executeQuery("SELECT id, correct_option FROM questions");

    	    while (rs.next()) {
    	        int qid = rs.getInt("id");
    	        String correct = rs.getString("correct_option");
    	        String userAnswer = request.getParameter("q" + qid);
    	        if (correct.equalsIgnoreCase(userAnswer)) {
    	            score++;
    	        }
    	    }

    	    // Save result using user_id
    	    PreparedStatement ps = conn.prepareStatement("INSERT INTO results(user_id, score) VALUES (?, ?)");
    	    ps.setInt(1, userId);
    	    ps.setInt(2, score);
    	    ps.executeUpdate();

    	    conn.close();
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}

    	request.setAttribute("result", "Your Score: " + score);
    	request.getRequestDispatcher("result.jsp").forward(request, response);

    }
}
