package net.rhinokul;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SubtractAmount {
	public String withdrawAmount(String userid,String pin,String amount1)
	{
		String flag="default";
		int amount;
		model=new Model();
        model.connectDB();
        
		try
		{
			System.out.println("this bean for with draw amount");
			amount=Integer.parseInt(amount1);
			Statement st=model.dbCon.getConnectionClass().createStatement();
			System.out.println("this is before the statement");
			ResultSet rs=st.executeQuery("select * from AccInfo where userid='"+userid+"' and pin='"+pin+"'");
			
			if(rs.next())
			{   System.out.println("this is in if satement"); 
  				int tempbalance=rs.getInt(3);
				if(tempbalance>=500 && tempbalance<amount)
				{	
				int x=amount-500;
				flag="you can withdraw "+x+"Tk only from this account";
				}
				else
				{
			  	int currentbalance=tempbalance-amount;
				rs.close();
				st.close();
			  	Statement st1=model.dbCon.getConnectionClass().createStatement();
				System.out.println("this is in if statemetnt and before 2 and balance is "+tempbalance);
			  	int r=st1.executeUpdate("update AccInfo  set balance="+currentbalance+" where userid='"+userid+"'");
				System.out.println("this is before r"+r);
				if(r>=1)
				{
			 		flag= "updation is sucessfull and your balance is "+currentbalance+"";
				}
				else flag="with draw account is Faild plase try again";
				st1.close();
				}
				
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