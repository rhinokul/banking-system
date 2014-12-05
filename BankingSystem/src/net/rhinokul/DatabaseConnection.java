/*
 * Open the Config.java file
 * Set the url of your database;
 * Set the user name of your Mysql user name;
 * Set the mysql password;
 */
package net.rhinokul;
import java.sql.*;

public class DatabaseConnection{
	public boolean startConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        config=new Config();
        System.out.println(config.username);
		Class.forName(config.driver).newInstance();
		con= DriverManager.getConnection(config.url, config.username, config.password);
		state= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
		connection_state= true;
		return connection_state;
		}

	public boolean removeConnection(){
		if(!connection_state)connection_state= false;

		try{
			state.close();
			con.close();
			}
		catch(SQLException e){
                        connection_state= true;
			e.printStackTrace();
			}
		finally{
			connection_state= true;
			}
                connection_state= false;
		return connection_state;
		}

	public Statement getStatement(){
		return state;
		}

	public Connection getConnectionClass(){
		return con;
		}

	private Connection con;
	private Statement state;
	private ResultSet result;
	private ResultSetMetaData meta_data;
	private boolean connection_state= false;
	private int row_no;
    private Config config;
}
