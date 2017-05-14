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
		//��ȡ�û�������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//����Service�еķ�������û��������Ƿ���ȷ
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
			//�����ȷ�����¼��¼�û����û���
			loginUser=user.getUsername();
			//��ȡ��¼�û����ļ��б�						
			File file=new File(this.getServletContext().getRealPath("/userFile/")+"\\"+username);	       
			//����û��ļ��в��������½�һ�����û���Ϊ�����ļ���
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
