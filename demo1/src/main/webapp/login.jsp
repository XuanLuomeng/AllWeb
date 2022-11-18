<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2022/11/18
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户输入用户名界面</title>
</head>
<body>
<form action="judge.jsp" method="post" style="...">
    <li>请输入用户名:<input type="text" name="username">只能由字母、数字或者下划线组成</li>
    <li><input type="submit" name="submit" value="验证"></li>
</form>
</body>
</html>
