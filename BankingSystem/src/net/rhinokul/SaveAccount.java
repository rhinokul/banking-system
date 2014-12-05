package net.rhinokul;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SaveAccount {
	
	public String openAccount(String userid,String password,String pin,String accounttype,String name,String fname,String address,String email)
	{
		String flag="deplecate";
		model=new Model();
        model.connectDB();
        
		try
		{
			PreparedStatement pt=model.dbCon.getConnectionClass().prepareStatement("insert into PersInfo (userid,password,name,fname,address,emailid) values(?,?,?,?,?,?)");	
			pt.setString(1,userid);
			pt.setString(2,password);
			pt.setString(3,name);
			pt.setString(4,fname);
			pt.setString(5,address);
			pt.setString(6,email);
			int ii=pt.executeUpdate();
			if(ii>0)		
			pt.close();
			pt=model.dbCon.getConnectionClass().prepareStatement("insert into AccInfo(accounttype,balance,pin,userid) 		values(?,?,?,?)");	
			pt.setString(1,accounttype);
			pt.setInt(2,500);	
			pt.setString(3,pin);
			pt.setString(4,userid);
			int i=pt.executeUpdate();
			pt.close();
			if (i>0 && ii>0)
			{
			Statement st=model.dbCon.getConnectionClass().createStatement();
			ResultSet rs=st.executeQuery("Select accountnumber from AccInfo where userid='"+userid+"'");
			if(rs.next())
			flag=rs.getString(1);
			else 
			flag=null;
			}
			else
			flag="problem";
			
			model.dbCon.getConnectionClass().close(); 
		}
		catch(Exception e){System.out.println(e);}		
		return flag;	
	}
    private Model model;
    Statement statement;
    PreparedStatement prepareStatement;    
}
