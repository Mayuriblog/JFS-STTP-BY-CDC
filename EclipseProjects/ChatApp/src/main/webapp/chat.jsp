<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*, javax.servlet.http.*" %>
<%
    // Ensure user is logged in
    String username = (String) session.getAttribute("user");
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chat Room</title>
</head>
<body>
    <h2>Welcome, <%= username %>!</h2>

    <!-- Message Sending Form -->
    <form action="sendMessage" method="post">
        <label for="message">Message:</label>
     <!--    <input type="text" id="message" name="message" required /> -->
<textarea id="message" name="message" rows="3" cols="50" required></textarea>

        <label for="room">Choose Room:</label>
        <select name="room_id" id="room">
            <%
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_app", "root", "root");
                    Statement stmt = conn.createStatement();
                    ResultSet rooms = stmt.executeQuery("SELECT room_id, room_name FROM chat_rooms");

                    while (rooms.next()) {
                        int roomId = rooms.getInt("room_id");
                        String roomName = rooms.getString("room_name");
            %>
                        <option value="<%= roomId %>"><%= roomName %></option>
            <%
                    }
                    conn.close();
                } catch (Exception e) {
                    out.println("<option>Error loading rooms</option>");
                }
            %>
        </select>

        <input type="submit" value="Send" />
    </form>

    <hr>

    <!-- Message Display Section -->
    <h3>Recent Messages</h3>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>Sender</th>
            <th>Room</th>
            <th>Message</th>
            <th>Time</th>
        </tr>
        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_app", "root", "root");

                String query = "SELECT u.username AS sender, c.room_name, m.content, m.sent_time " +
                               "FROM messages m " +
                               "JOIN users u ON m.sender_id = u.user_id " +
                               "LEFT JOIN chat_rooms c ON m.room_id = c.room_id " +
                               "ORDER BY m.sent_time DESC LIMIT 20";

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    String sender = rs.getString("sender");
                    String room = rs.getString("room_name") != null ? rs.getString("room_name") : "No Room";
                    String content = rs.getString("content");
                    String time = rs.getTimestamp("sent_time").toString();
        %>
        <tr>
            <td><%= sender %></td>
            <td><%= room %></td>
            <td><%= content %></td>
            <td><%= time %></td>
        </tr>
        <%
                }
                conn.close();
            } catch (Exception e) {
                out.println("<tr><td colspan='4'>Error loading messages: " + e.getMessage() + "</td></tr>");
            }
        %>
    </table>

    <br>
    <a href="logout.jsp">Logout</a>
</body>
</html>

