package com.yun.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class newFileServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		response.setContentType("text/html;charset=utf-8");
		String filePath=this.getServletContext().getRealPath("/userFile/")+"\\"+request.getParameter("Path");
		File f=new File(filePath);  
		f.mkdirs();
		response.getOutputStream().write("success".getBytes());
		}catch(Exception e){
			response.getOutputStream().write("error".getBytes());
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      doGet(request,response);
	}

}
