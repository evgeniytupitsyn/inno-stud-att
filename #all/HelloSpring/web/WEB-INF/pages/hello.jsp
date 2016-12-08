<%--
  Created by IntelliJ IDEA.
  User: mega
  Date: 05.03.2010
  Time: 0:04:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Simple jsp page</title></head>
  <body>
  Hello <%= request.getAttribute("name")%>
  </body>
</html>