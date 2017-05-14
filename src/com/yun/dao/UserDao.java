package com.yun.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;
import com.yun.domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
public class UserDao {
	
	static ResultSet rs=null;
	static Statement stat=null;
	static Connection conn=null;
	static ResultSetMetaData metaData =null;
	//1.根据用户名查找对应的用户
	public User findUser(String username) throws SQLException{
		DriverManager.registerDriver(new Driver());		
	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myweb","root", "root");
	    stat=conn.createStatement();
		      User userb=new User();
			  String name=null;
			  rs=stat.executeQuery("select * from user");
			    ResultSetMetaData metaData = rs.getMetaData();
			  while(rs.next()){
				  name=(String)rs.getObject(1);
					if(username.equals(name))
				      {
						
				         for(int i=1;i<=metaData.getColumnCount();i++)
				         {
						   Object obj = rs.getObject(i);
						   String stem=obj.toString();
						   if(i==1)
							   userb.setUsername(stem);
						   else if(i==2) 
							   userb.setPassword(stem);
						   else if(i==3)
							   userb.setNickname(stem); 
						   else if(i==4)
							   userb.setEmail(stem);
						   }						   					   						   
                         }
				      }
					   rs.close();
					   stat.close();
					   conn.close();               
				       return userb;
			 }		   
	
	public void addUser(User user) throws SQLException{ 
		DriverManager.registerDriver(new Driver());		
	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myweb","root", "root");	    
		PreparedStatement ps=conn.prepareStatement("insert into user values(?,?,?,?)");
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
	    ps.setString(3, user.getNickname());
	    ps.setString(4, user.getEmail());
	    int i=ps.executeUpdate();
	    if(i==1){
	    	System.out.println("插入曾工");
	    }
		stat.close();
		conn.close(); 
	}
	
}