<%--
  Created by IntelliJ IDEA.
  User: evgeniytupitsyn
  Date: 18/11/2016
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>
    Hello World Sample
  </title>
</head>

<body>
<h1>
  <%
    String name = request.getParameter("name");
    if (name == null || name.length() == 0) {
  %>
  Hello, world !
  <%            } else {
  %>
  Hello, world ! I'm <%= name%>
  <%
    }
  %>
</h1>
</body>
</html>