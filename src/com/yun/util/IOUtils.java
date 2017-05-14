package com.yun.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {

  private IOUtils(){
	  
  }
  public static void in2out(InputStream in,OutputStream out) throws IOException{
	  byte[] bs=new byte[1024];
      int i=0;
      while((i=in.read(bs))!=-1)
      {
   	   out.write(bs,0,i);
       }
  }
  
  public static void close(InputStream in,OutputStream out) throws IOException{
	  if(in!=null){
		in.close();
		}
	  if(out!=null){
	  out.close();
	  }
  }
}
