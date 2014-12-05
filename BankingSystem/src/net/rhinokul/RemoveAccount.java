package net.rhinokul;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RemoveAccount {
	public String deleteAccount(String userid,String pin)
	{
		String flag="default",flag1=null;
		model=new Model();
        model.connectDB();
        
		try
		{
			PreparedStatement pst1=model.dbCon.getConnectionClass().prepareStatement("select * from AccInfo where userid=? and pin=?");
			pst1.setString(1,userid);
			pst1.setString(2,pin);			
			ResultSet rs=pst1.executeQuery();

			System.out.println("this isafter the statement");
			if(rs.next())
			{                 
				System.out.println("this is in if :");
	  			
				flag1="you have Rs "+rs.getString(3)+"in your Account it will be send back to you ";
				rs.close();
					
				PreparedStatement pst2=model.dbCon.getConnectionClass().prepareStatement("delete from AccInfo where userid=?");
				pst2.setString(1,userid);			
				int r=pst2.executeUpdate();
				pst2.close();
	
				PreparedStatement pst3=model.dbCon.getConnectionClass().prepareStatement("delete from PersInfo where userid=?");
				pst3.setString(1,userid);			
				int r1=pst3.executeUpdate();
	 			pst3.close();
				
				
				if(r>=1 && r1>=1)
				{
				 flag= "your record is sucessfully deleted from the database";
				}
				else flag="Sorry your transaction is not sucessfull try again";
				
			}
			else
			{
				flag= "you are not authorized user";
				pst1.close();
			}
				
			
			model.dbCon.getConnectionClass().close();
			System.out.println(flag);
		}catch(Exception e){System.out.println(e);}

		flag=flag1+flag;
		return flag;	
	}
    private Model model;
    Statement statement;
    PreparedStatement prepareStatement; 
}
