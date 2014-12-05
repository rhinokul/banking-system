package net.rhinokul;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddAmount {
	public String depositAmount(String userid,String pin,String amount1)
	{
		String flag="default";
		int amount;
		model=new Model();
        model.connectDB();
        
		try
		{
			amount=Integer.parseInt(amount1);
			System.out.println("this is to be deposit");
			Statement st=model.dbCon.getConnectionClass().createStatement();
			System.out.println("this is before the statement");
			ResultSet rs=st.executeQuery("select * from AccInfo where userid='"+userid+"' and pin='"+pin+"'");
			
			if(rs.next())
			{                 
  				int tempbalance=rs.getInt(3);
			  	int currentbalance=tempbalance+amount;
				rs.close();
				st.close();
			  	Statement st1=model.dbCon.getConnectionClass().createStatement();
				System.out.println("this is in if statemetnt and before 2 and balance is "+tempbalance);
			  	int r=st1.executeUpdate("update AccInfo  set balance="+currentbalance+" where userid='"+userid+"'");
				System.out.println("this is before r"+r);
				if(r>=1)
				{
			 		flag= "updation is sucessfull and your current balance is Tk"+currentbalance+"";
				}
				else flag="Deposit money transaction is Faild please try again";
				st1.close();
			}
			else
			{
			flag= "you are not authrized user";
			}
			
		
			model.dbCon.getConnectionClass().close();
			System.out.println(flag);
			}catch(Exception e){System.out.println(e);}
		
	
			System.out.println(flag);

	
			return flag;

	}
    private Model model;
    Statement statement;
    PreparedStatement prepareStatement; 
}
