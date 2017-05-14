<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <script type="text/javascript">
    function addOne(){
        document.getElementById("adddiv").innerHTML+="<div><input type='file' name='file1'/><input type='button' value='取消' onclick='delOne(this)'/><br></div>";        
    }
    function delOne(but){
      var div=but.parentNode;
      div.parentNode.removeChild(div);    
    }
  </script>
  </head>
  
  <body>
      <h4>上传本地文件</h4>
      
      <form action="${pageContext.request.contextPath}/servlet/UploadServlet" method="post">
      	<div id="addDiv">
	      <input type="file" name="file1">
	      <input type="button" value="取消" onclick="delOne()"/><br>	      
	    </div>
	      <input type="button" value="加一个" onclick="addOne()"/>
	      <input type="submit" value="上传" onclick="upload"/>
      </form>
  </body>
</html>
