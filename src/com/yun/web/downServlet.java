package com.yun.web;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class downServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {          
          response.setContentType("Text/html;charset=utf-8");
          String filenames= request.getParameter("filenames");
         
          String [] filename=filenames.split("---");
           for (int j=0;j<filename.length;j++)        
           {  
              FileInputStream FileInputStream = new FileInputStream(this.getServletContext().getRealPath("/userFile/")+"\\"+filename[j]);        
              int b=FileInputStream.read();
              for(int i=0;b!=-1;i++)
              {
	              response.getOutputStream().write((char)b);
	        	  b=FileInputStream.read();
              }
           response.getOutputStream().write("****************************************".getBytes());
           FileInputStream.close();
         }                   
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      
	
	}

}
