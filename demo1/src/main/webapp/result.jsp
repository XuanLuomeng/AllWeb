<%@ page import="pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2022/11/18
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结果显示</title>
</head>
<body>
<div align="center">
  <%
      String username = request.getParameter("username");
      String passowrd = request.getParameter("password");
      User user = new User(username,passowrd);
      if(!user.getUsername().equals("")&&!user.getPassword().equals("")){
          out.print("恭喜您，登陆成功");
      }else {
          out.print("请输入正确的用户名和密码");
      }
  %>
    <br/><br/>
    <a href="index.jsp">返回</a>
</div>
</body>
</html>
