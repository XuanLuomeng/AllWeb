<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2022/11/18
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="username" class="bean.Username" scope="page">
    <jsp:setProperty name="username" property="*"/>
</jsp:useBean>
<html>
<head>
    <title>验证反馈界面</title>
</head>
<body>
<ul style="...">
    <li>输入的用户名为:
        <jsp:getProperty name="username" property="username"/>
    </li>
    <li>&nbsp;是否有效:
        <jsp:getProperty name="username" property="isval"/>
    </li>
    <li>&nbsp;提示信息:
        <jsp:getProperty name="username" property="tip"/>
    </li>
</ul>
</body>
</html>
