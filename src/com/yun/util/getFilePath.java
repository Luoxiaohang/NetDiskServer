package com.yun.util;

import java.io.File;
  
public class getFilePath {
	public static String path="";
	
	public static void main(String args[]){
		getFilePath get=new getFilePath("D:\\MyEclipse Professional\\workspace\\.metadata\\.me_tcat7\\webapps\\yunServlet\\userFile\\nina");
		System.out.println(get.path);
	}
	
	public getFilePath(String Path){		
		 File file=new File(Path);		 
         File[] filelist=file.listFiles();
         if(filelist.length!=0)
        	{
         	 for(int i=0;i<filelist.length;i++)  
        	     if(!filelist[i].getPath().substring(84).contains("."))
        	     {
        	    	 path=path+filelist[i].getPath().substring(84)+"!!!"+"\n";
        	    	 new getFilePath(filelist[i].getPath());        	    	
        	     }
                 else  path=path+filelist[i].getPath().substring(84)+"!!!"+"\n";                      		
	        }  
        	 
         
	}
}
