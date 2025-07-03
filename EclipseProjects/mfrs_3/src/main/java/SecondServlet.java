

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {

   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		//read the first form
		if(Integer.parseInt(request.getParameter("formno"))==2)
		{
			String email=request.getParameter("email").trim();
			String pass=request.getParameter("pass").trim();
			// storing  form data tnto HttpSession object is called
			// as client state persistent
			session.setAttribute("email", email);
			session.setAttribute("pass", pass);
			
			//sending HTML file from servlet to browser
			response.sendRedirect("./Third.html");
			
		}
	}

}
