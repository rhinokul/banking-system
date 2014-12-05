package net.rhinokul;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteView
 */
@WebServlet("/DeleteView")
public class DeleteView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init(){
    }

    @Override
    public void service(HttpServletRequest request,
                      HttpServletResponse response)
      throws IOException, ServletException {
    	response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Welcome to ABC Bank</title>");
        writer.println("</head>");
        writer.println("<body bgcolor=white>");

        writer.println("<div style=\"border: 1px solid black;padding: 20px 0;text-align: center;\">");
        writer.println("<h1>Welcome to ABC Bank</h1>");
        writer.println("<b>");
        writer.println("<form action=\"/BankingSystem/DeleteAccount\" >");
        writer.println("Enter User ID: <input type=text name=\"userid\"><br/>");
        writer.println("Enter Your PIN: <input type=text name=\"pin\"><br/>");
        writer.println("<br/>");
        writer.println("<input type=submit value=\"Delete Account\">");
        writer.println("</form>");
        writer.println("</b>");
        writer.println("</div>");

        writer.println("</body>");
        writer.println("</html>");
        
    }
}
