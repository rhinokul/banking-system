package net.rhinokul;

import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpenAccount
 */
@WebServlet("/OpenAccount")
public class OpenAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init()
	{
		sa=new SaveAccount();
	}
	
	@SuppressWarnings("unused")
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
		String userid=req.getParameter("userid");
		String password=req.getParameter("password");
		String pin=req.getParameter("pin");
		String accounttype=req.getParameter("accounttype");
		String name=req.getParameter("name");

		String fname=req.getParameter("fname");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		

		PrintWriter pw=res.getWriter();
		String flag=sa.openAccount(userid,password,pin,accounttype,name,fname,address,email);
		if (flag.equals("problem"))
			pw.println("<b> Problem in creation of ur account--change the pin number. Try Again");
		else 
		if(flag==null)
			pw.println("<b>Sorry ur Account is not created.");
		else
		if(flag.equals("deplecate"))
		{pw.println("Account can't be crated with this user name choose another userid ");}
		else
			pw.println("<B>Welcome to ABC Bank Mr. " + name+" ur account number is " + flag);

		}catch(Exception e){System.out.println(e);}
	}
	
	public void destroy()
	{
	}
	
	private SaveAccount sa;

}
