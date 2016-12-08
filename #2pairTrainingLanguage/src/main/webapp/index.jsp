<%--
  Created by IntelliJ IDEA.
  User: evgeniytupitsyn
  Date: 18.11.2016
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
      <%@include file='resources/css/main.css'%>
    </style>
    <title><%request.getPathInfo(); %></title>
  </head>
  <body>
  <nav class="navbar navbar-inverse">
      <div class="container-fluid">
          <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="/">Innopolis pairTraining &trade;</a>
          </div>
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav navbar-right">
                  <c:choose>
                      <c:when test="${empty sessionScope.login}">
                          <li><a href="login">Login</a></li>
                          <li><a href="register">Register</a></li>
                      </c:when>
                      <c:otherwise>
                          <li><a href="profile">Profile ${sessionScope.login}</a></li>
                          <li><a href="logout">Logout</a></li>
                      </c:otherwise>
                  </c:choose>
              </ul>
          </div>
      </div>
  </nav>
  </body>
  <script src="resources/js/main.js"></script>
  <script src="resources/node_modules/jquery/dist/jquery.js"></script>
  <script src="resources/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
</html>
