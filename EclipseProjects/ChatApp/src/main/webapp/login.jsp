<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login - ChatApp</title>
</head>
<body>
    <h2>User Login</h2>
    
    <form action="login" method="post">
        <label>Username:</label>
        <input type="text" name="username" required /><br><br>

        <label>Password:</label>
        <input type="password" name="password" required /><br><br>

        <input type="submit" value="Login" />
    </form>

    <br>
    <p>Don't have an account? <a href="register.jsp">Register Here</a></p>

    <% 
        String error = request.getParameter("error");
        String success = request.getParameter("registered");
        if ("invalid".equals(error)) {
    %>
        <p style="color:red;">Invalid username or password.</p>
    <% } else if ("success".equals(success)) { %>
        <p style="color:green;">Registration successful. Please log in.</p>
    <% } %>
</body>
</html>
