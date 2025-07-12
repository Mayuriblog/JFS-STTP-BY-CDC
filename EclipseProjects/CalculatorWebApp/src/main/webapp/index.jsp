<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<html>
<head>
    <title>Calculator</title>
    <style>
        body {
            background: #0d1b2a;
            color: white;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .calculator {
            background: #1b263b;
            padding: 20px;
            border-radius: 20px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.5);
            text-align: right;
            width: 300px;
        }

        .display {
            font-size: 2em;
            height: 60px;
            color: white;
            padding: 10px;
            background: #415a77;
            border-radius: 10px;
            margin-bottom: 20px;
            text-align: right;
            overflow-x: auto;
        }

        .buttons {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            gap: 10px;
        }

        .btn {
            padding: 20px;
            background: #778da9;
            border: none;
            border-radius: 50%;
            font-size: 18px;
            color: white;
            cursor: pointer;
        }

        .btn:hover {
            background: #a8dadc;
            color: black;
        }

        .equal {
            background: #00b4d8;
        }

        .equal:hover {
            background: #48cae4;
        }
    </style>
</head>
<body>
    <form action="CalculatorServlet" method="post" class="calculator">
        <%
            String result = (String) request.getAttribute("result");
            String expression = (String) session.getAttribute("expression");
        %>
        <div class="display">
            <%= (result != null) ? result : (expression != null && !expression.isEmpty()) ? expression : "0" %>
        </div>

        <div class="buttons">
            <button type="submit" name="op" value="C" class="btn">C</button>
            <button type="submit" name="op" value="%" class="btn">%</button>
            <button type="submit" name="op" value="⌫" class="btn">⌫</button>
            <button type="submit" name="op" value="/" class="btn">÷</button>

            <button type="submit" name="num" value="7" class="btn">7</button>
            <button type="submit" name="num" value="8" class="btn">8</button>
            <button type="submit" name="num" value="9" class="btn">9</button>
            <button type="submit" name="op" value="*" class="btn">×</button>

            <button type="submit" name="num" value="4" class="btn">4</button>
            <button type="submit" name="num" value="5" class="btn">5</button>
            <button type="submit" name="num" value="6" class="btn">6</button>
            <button type="submit" name="op" value="-" class="btn">−</button>

            <button type="submit" name="num" value="1" class="btn">1</button>
            <button type="submit" name="num" value="2" class="btn">2</button>
            <button type="submit" name="num" value="3" class="btn">3</button>
            <button type="submit" name="op" value="+" class="btn">+</button>

            <button type="submit" name="num" value="0" class="btn">0</button>
            <button type="submit" name="num" value="00" class="btn">00</button>
            <button type="submit" name="num" value="." class="btn">.</button>
            <button type="submit" name="op" value="=" class="btn equal">=</button>
        </div>
    </form>
</body>
</html>
