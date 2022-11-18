<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2022/11/18
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书信息</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="book" class="pojo.Book" scope="page">
    <jsp:setProperty name="book" property="*"></jsp:setProperty>
</jsp:useBean>
<table align="center" width="400">
    <tr><td align="center">
        名称:<jsp:getProperty name="book" property="bookName"/>
    </td> </tr>
    <tr><td align="center">
        价格:<jsp:getProperty name="book" property="price"/>
    </td> </tr>
    <tr><td align="center">
        作者:<jsp:getProperty name="book" property="author"/>
    </td> </tr>
</table>
</body>
</html>
