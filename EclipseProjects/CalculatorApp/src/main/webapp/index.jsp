<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <h2>Simple Calculator</h2>
    <form action="CalculateServlet" method="post">
        First Number: <input type="text" name="num1"><br><br>
        Second Number: <input type="text" name="num2"><br><br>
        Operation:
        <select name="operation">
            <option value="add">Add</option>
            <option value="sub">Subtract</option>
            <option value="mul">Multiply</option>
            <option value="div">Divide</option>
        </select><br><br>
        <input type="submit" value="Calculate">
    </form>
</body>
</html>
