package net.rhinokul;

import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepositAmount
 */
@WebServlet("/DepositAmount")
public class DepositAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init()
	{
		aa=new AddAmount();		
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		PrintWriter pw=null;String flag=null;
		try
		{
		String userid=req.getParameter("userid");
		
		String pin=req.getParameter("pin");
		
		String amount=req.getParameter("amount");
		

		pw=res.getWriter();
		flag=aa.depositAmount(userid,pin,amount);
		pw.println(flag);
		}catch(Exception e){System.out.println(e);}
	}
	
	public void destroy()
	{
	}
	
	private AddAmount aa;
}
