import java.io.File;

public class test {
public static  String path="";

	public static void main(String[] args) {
		String s="sjdlfls___";
		String [] ss=s.split("___");
		System.out.println(ss[0]);
	}	
		
	public test(String Path)
	{		
			 File file=new File(Path);
			 
	         File[] filelist=file.listFiles();
	        
	         if(filelist.length!=0)
	         	{
	        	 
		        	 for(int i=0;i<filelist.length;i++)               
		         	   { if(!filelist[i].getPath().contains("."))
			        	     {
			        	    	 path=path+filelist[i].getPath()+"!!!"+"\n";
			        	    	  new test(filelist[i].getPath());        	    	
			        	      }
		        	     else 
		        	    	 path=path+filelist[i].getPath()+"!!!"+"\n";                      		
			           }
	        	 
	         	}
	        }
			
	}


