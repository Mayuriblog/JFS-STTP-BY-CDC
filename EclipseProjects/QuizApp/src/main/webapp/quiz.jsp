<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.sql.*"%>
	<%
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb", "root", "root");
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT * FROM questions");
	%>

	<form action="result" method="post">
		<%
		int qno = 1;
		while (rs.next()) {
		%>
		<p>
			<b>Q<%=qno++%>: <%=rs.getString("question")%></b>
		</p>
		<input type="radio" name="q<%=rs.getInt("id")%>" value="A">
		<%=rs.getString("option_a")%><br /> <input type="radio"
			name="q<%=rs.getInt("id")%>" value="B">
		<%=rs.getString("option_b")%><br /> <input type="radio"
			name="q<%=rs.getInt("id")%>" value="C">
		<%=rs.getString("option_c")%><br /> <input type="radio"
			name="q<%=rs.getInt("id")%>" value="D">
		<%=rs.getString("option_d")%><br />
		<hr>
		<%
		}
		%>
		<input type="submit" value="Submit Quiz">
	</form>


</body>
</html>