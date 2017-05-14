package com.yun.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.yun.util.IOUtils;

public class uploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println("sldfjs");
		try { 
	    	 DiskFileItemFactory factory=new DiskFileItemFactory(10,new File(this.getServletContext().getRealPath("temp")));
	    	 ServletFileUpload fileUpload= new ServletFileUpload(factory);

	        fileUpload.setFileSizeMax(1024*1024*10);
	        fileUpload.setSizeMax(1024*1024*100);
	       
	        fileUpload.setHeaderEncoding("utf-8");
	         List<FileItem> list= fileUpload.parseRequest(request);
			//获取登录用户的用户名
	         	         
	         for(FileItem item  : list){	        	
	        	 if(!item.isFormField()){	

	        		String userName="people";//默认文件夹
	        		
	        		String filename=item.getName();
	        		
	        		String [] file=filename.split("!!!");
	        		userName=file[0];
	        		
	        		File f=new File(this.getServletContext().getRealPath("/userFile/")+"\\"+file[0]);
	        		if(!f.exists())
	        		   f.mkdirs();   
	        	    		
	                filename=UUID.randomUUID().toString()+"!!!"+file[1];
	                InputStream in=item.getInputStream();
	               //   OutputStream out=new FileOutputStream(this.getServletContext().getRealPath("/userFile/"+filename));
	                 OutputStream out=new FileOutputStream(this.getServletContext().getRealPath("/userFile/"+"\\"+userName+"/"+filename));                
	                IOUtils.in2out(in, out);
	                IOUtils.close(in, out);	           
	        	    item.delete();
	             }
	        }
	         response.getOutputStream().write("successfuly".getBytes());
	    } catch(FileSizeLimitExceededException e){
	        response.getOutputStream().write("单个文件不能超过10M，不能超过100M".getBytes());         
	          return;	    	   
	    }catch (FileUploadException e) {
	  			e.printStackTrace();
	  			response.getOutputStream().write("文件上传失败".getBytes()); 
	         }     
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doGet(request,response);
	}

}
