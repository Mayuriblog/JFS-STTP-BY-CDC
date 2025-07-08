import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Statement;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.*;
@WebServlet("/fetchMessages")
public class FetchMessagesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        JSONArray messagesArray = new JSONArray();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/chat_app", "root", "root");

            String query = "SELECT m.msg_id, u.username AS sender, c.room_name, " +
                           "m.content, m.sent_time " +
                           "FROM messages m " +
                           "JOIN users u ON m.sender_id = u.user_id " +
                           "LEFT JOIN chat_rooms c ON m.room_id = c.room_id " +
                           "ORDER BY m.sent_time DESC LIMIT 20";

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                JSONObject msg = new JSONObject();
                msg.put("sender", rs.getString("sender"));
                msg.put("room", rs.getString("room_name") == null ? "No Room" : rs.getString("room_name"));
                msg.put("content", rs.getString("content"));
                msg.put("time", rs.getTimestamp("sent_time").toString());
                messagesArray.put(msg);
            }

            out.print(messagesArray.toString());
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.print("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}
