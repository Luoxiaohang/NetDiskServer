package com.yun.web;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yun.domain.User;
import com.yun.service.UserService;
import com.yun.util.getFilePath;

public class LoginServlet extends HttpServlet {
	
	String loginUser=new String();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		UserService service = new UserService();
		//获取用户名密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//调用Service中的方法检查用户名密码是否正确
		User user=null;
		try {
			user = service.isUsernameAndPsw(username, password);

		  } catch (SQLException e) {
			e.printStackTrace();
		}
		if(user == null){
			 response.getOutputStream().write("noUser".getBytes());
			return;
		}else{
			//如果正确，则记录登录用户的用户名
			loginUser=user.getUsername();
			//获取登录用户的文件列表						
			File file=new File(this.getServletContext().getRealPath("/userFile/")+"\\"+username);	       
			//如果用户文件夹不存在则新建一个以用户名为名的文件夹
			if(!file.exists())	        
	        	file.mkdirs();   
			else{
			     File[] filelist=file.listFiles();     
	             if(filelist.length!=0){ 
	        	   getFilePath getPath=new getFilePath(this.getServletContext().getRealPath("/userFile/")+"\\"+username);
	        	   response.getOutputStream().write(getPath.path.getBytes());
	        	   getPath.path="";
	               } 
	             else{
	        	   response.getOutputStream().write("nofile".getBytes());
	                 }
	             return;
		       }
			}		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		return;
	}

}
