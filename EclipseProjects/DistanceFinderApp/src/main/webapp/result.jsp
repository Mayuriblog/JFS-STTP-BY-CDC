<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Distance Result</title></head>
<body>
    <h2>Distance from <%= request.getAttribute("source") %> to <%= request.getAttribute("destination") %></h2>
    <p>Distance: <%= request.getAttribute("distance") %> km</p>
    <br>
    <a href="index.jsp">Calculate Another Distance</a>
</body>
</html>
