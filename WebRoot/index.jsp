<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>欢迎来到我的网盘</title>
  </head>
  
  <body>
  <div align="center">
     <h2>用户登录</h2>
	  <form action="" method="post">
	  <table border="0">
		   <tr>
		   	<td>用户名</td>
		   	<td><input type="text" name="userName"/></td>
		   </tr>
		    <tr>
		   	<td>密码</td>
		   	<td><input type="text" name="passWord"></td>
		   </tr>
		    </table> 
	  </form>   
		   <input type="checkbox" name="remName value="true"/>记住密码  
		   <input type="submit" value="登录"/>	  
  </div>
    
  </body>
</html>
