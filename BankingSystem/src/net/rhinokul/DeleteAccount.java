package net.rhinokul;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteAccount
 */
@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init()
	{
		ra=new RemoveAccount();		
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		PrintWriter pw=null;String flag=null;
		try
		{
		String userid=req.getParameter("userid");
		
		String pin=req.getParameter("pin");		

		pw=res.getWriter();
		 flag=ra.deleteAccount(userid,pin);
		}catch(Exception e){System.out.println(e);}
		pw.println(flag);
	}
	
	public void destroy()
	{
	}
	
	private RemoveAccount ra;
}
