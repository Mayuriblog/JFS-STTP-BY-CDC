package com.calc;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/CalculatorServlet")


public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String expression = (String) session.getAttribute("expression");
        if (expression == null) expression = "";

        String num = request.getParameter("num");
        String op = request.getParameter("op");

        if (num != null) {
            expression += num;
        } else if (op != null) {
            switch (op) {
                case "=":
                    try {
                        double result = evaluateExpression(expression);
                        request.setAttribute("result", String.format("%.2f", result));
                        expression = ""; // clear after evaluation
                    } catch (Exception e) {
                        request.setAttribute("result", "Error");
                        expression = "";
                    }
                    break;
                case "C":
                    expression = "";
                    request.setAttribute("result", "0");
                    break;
                case "⌫":
                    if (!expression.isEmpty()) {
                        expression = expression.substring(0, expression.length() - 1);
                    }
                    break;
                case "%":
                    expression += "*0.01";
                    break;
                default:
                    expression += op;

            }
        }

        session.setAttribute("expression", expression);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public static double evaluateExpression(String expression) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;
                if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expression.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                return x;
            }
        }.parse();
    }
}
