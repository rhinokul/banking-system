/**
 * Main Servlet File
 * @author Delower Hossain <rhine71@gmail.com>
 */

package net.rhinokul;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class Main extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    public void init(){
    	model=new Model();
    	String query=("select * from test");
        rs=model.getData(query);
        try{
            while(rs.next()) {
            	System.out.print("Data Found");
            	flag=true;
            }
        } catch(Exception e){e.printStackTrace();}    	
        model.disconnectDB();
        
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
        if(flag){writer.println("<h3>Database Connected!</h3>");}
        writer.println("<a href=\"/BankingSystem/OpenView\" >Open an Account</a>");
        writer.println("<a href=\"/BankingSystem/DeleteView\" >Delete an Account</a>");
        writer.println("<a href=\"/BankingSystem/DepositView\" >Deposit Amount</a>");
        writer.println("<a href=\"/BankingSystem/WithdrawView\" >Withdraw Amount</a>");
        writer.println("</form>");
        writer.println("</b>");
        writer.println("</div>");

        writer.println("</body>");
        writer.println("</html>");
        
    }

    private Model model;
    private ResultSet rs;
    public boolean flag;
}