<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2022/11/18
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>邮件信息</title>
</head>
<body>
<jsp:useBean id="email" class="pojo.Email"></jsp:useBean>
<jsp:useBean id="encoding" class="util.CharactorEncoding"></jsp:useBean>
<jsp:setProperty name="email" property="*"></jsp:setProperty>
<div align="center">
    <div id="container">
        <div id="title">
            <%=encoding.toString(email.getTitle())%>
        </div>
        <hr>
        <div id="content">
            <%=encoding.toString(email.getContent())%>
        </div>
    </div>
</div>
</body>
</html>
