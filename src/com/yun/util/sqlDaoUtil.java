package com.yun.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
import com.yun.domain.User;
public class sqlDaoUtil {
		  
	static ResultSet rs=null;
	static Statement stat=null;
	static Connection conn=null;
		 
	static  {
		   try {
			DriverManager.registerDriver(new Driver());		
		    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myweb","root", "root");
		    stat=conn.createStatement();		   	  		   
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public static String getName(String username) throws SQLException {
			  String name=null;
			  rs=stat.executeQuery("select * from user");
			   while(rs.next()){
				   if(username.equals(rs.getString("username")))
				   { conn.close();
				   stat.close();
				   rs.close();
				   return rs.getString("username");			   
			      }
			}		   
			   rs.close();
			   return name;
		   }

	public static String getPassWord() throws SQLException {
		  String pw=null;
		  rs=stat.executeQuery("select * from user");
		   while(rs.next()){
			    conn.close();
			   stat.close();
			   rs.close();
			   return rs.getString("password");
		   }			   
		   rs.close();
		   return pw;
	   }
	public static String getNickName(String username) throws SQLException {
		  String nickname=null;
		  rs=stat.executeQuery("select * from user");
		   while(rs.next()){
			   if(username.equals(rs.getString("nickname")))
			   { conn.close();
			   stat.close();
			   rs.close();
			   return rs.getString("nackname");
		   }}			   
		   rs.close();
		   return nickname;
	   }
	public static String getEmail(String username) throws SQLException {
		  String email=null;
		  rs=stat.executeQuery("select * from user");
		   while(rs.next()){
			   if(username.equals(rs.getString("email")))
			   { conn.close();
			   stat.close();
			   rs.close();
			   return rs.getString("email");
		   }}			   
		   rs.close();
		   return email;
	   }
	
	public static void addUser(User user) throws SQLException
	{
		rs=stat.executeQuery("insert into user values(user.getUsername(),user.getPassword(),user.getNickname(),user.getEmail())");
	}
}

