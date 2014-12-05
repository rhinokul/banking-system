package net.rhinokul;

import java.sql.*;

public class Model {
  public Model(){
      dbCon=new DatabaseConnection();
      System.out.println("DatabaseConnection initialized");
      }

  public boolean connectDB(){
      try{
      connectionState=dbCon.startConnection();
      System.out.println("database connected");
      }catch(Exception e){
      e.printStackTrace();
      }
      return connectionState;
      }

  public boolean disconnectDB(){
      return dbCon.removeConnection();
      }

  public boolean executeSQL(String sql){
      System.out.println(sql+"   12");
   
      connectDB();
      try{
          
          statement=dbCon.getConnectionClass().createStatement();
         
          //System.out.println(sql+"   13");
          statement.execute(sql);
          flag=true;

         }catch(SQLException e){
             //System.out.println(sql+"   1232");
             flag=false;
          e.printStackTrace();
          }
      disconnectDB();
      return flag;
      }
  
  public ResultSet getData(String sql){
      connectDB();
      try{

         statement=dbCon.getConnectionClass().createStatement();
         resultSet=statement.executeQuery(sql);
         resultSetMetaData=resultSet.getMetaData();
      }catch(SQLException e){
      e.printStackTrace();
      }
      //disconnectDB();
      return resultSet;
  }

  public static void main(String[] arg){
      new Model().connectDB();
  }


  ResultSet resultSet;
  ResultSetMetaData resultSetMetaData;
  DatabaseConnection dbCon;
  boolean connectionState=false;
  boolean flag=false;
  Statement statement;
  PreparedStatement prepareStatement;
}