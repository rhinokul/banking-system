package net.rhinokul;

import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WithdrawAmount
 */
@WebServlet("/WithdrawAmount")
public class WithdrawAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init()
	{
		suba=new SubtractAmount();		
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
		flag=suba.withdrawAmount(userid,pin,amount);
		}catch(Exception e){System.out.println(e);}
		pw.println(flag);
	}
	
	public void destroy()
	{
	}
	
	private SubtractAmount suba;
}

