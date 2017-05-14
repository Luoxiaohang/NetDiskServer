<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>***你好，欢迎登录</title>
  </head> 
  <body>
        <h3>我的文件</h3>
        <h6>全部文件</h6>      
        <table border="0">        
         <tr>
          <td><input type="checkbox" name="chooseAll">文件名</td>          
          <td>文件 大小</td>
          <td>修改 日期</td>
         </tr>
         <tr>
          <td><input type="checkbox" name="chooseAll">文件名</td>          
          <td>文件大小</td>
          <td>修改日期</td>
         </tr>
         <tr>
          <td><input type="checkbox" name="chooseAll">文件名</td>          
          <td>文件大小</td>
          <td>修改日期</td>
         </tr>
         <tr>
          <td><input type="checkbox" name="chooseAll">文件名</td>          
          <td>文件大小</td>
          <td>修改日期</td>
         </tr>
         <tr>
          <td><input type="checkbox" name="chooseAll">文件名</td>          
          <td>文件大小</td>
          <td>修改日期</td>
         </tr>
         <tr>
          <td><input type="checkbox" name="chooseAll">文件名</td>          
          <td>文件大小</td>
          <td>修改日期</td>
         </tr>      
        </table> 
        <input type="button" value="下载"/>
        <input type="button" value="删除"/>
        <input type="button" value="上传本地文件" onclick="uploadFile"/>
  </body>
</html>
