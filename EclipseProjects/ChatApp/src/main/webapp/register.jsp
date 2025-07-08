<!DOCTYPE html>
<html>
<head>
    <title>Register - ChatApp</title>
</head>
<body>
    <h2>New User Registration</h2>
    
    <form action="register" method="post">
        <label>Username:</label>
        <input type="text" name="username" required /><br><br>

        <label>Password:</label>
        <input type="password" name="password" required /><br><br>

        <input type="submit" value="Register" />
    </form>

    <br>
    <p>Already registered? <a href="login.jsp">Login Here</a></p>

    <% 
        String error = request.getParameter("error");
        if ("UserExists".equals(error)) {
    %>
        <p style="color:red;">Username already exists.</p>
    <% } %>
</body>
</html>
