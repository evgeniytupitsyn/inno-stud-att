<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  Student: Nikolay
  Date: 24.11.2016
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>${title}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <spring:url value="/resources/css/index.css" var="mainCss" />
    <spring:url value="/resources/css/jquery.dataTables.min.css" var="dataTablesCss" />
    <spring:url value="/bootstrap/css/bootstrap.min.css" var="bootstrapCss"/>
    <spring:url value="/bootstrap/css/bootstrap-theme.min.css" var="bootstrapThemeCss"/>


    <spring:url value="/resources/js/jquery.min.js" var="jqueryJs"/>
    <spring:url value="/resources/js/jquery.dataTables.min.js" var="dataTablesJs"/>
    <spring:url value="/bootstrap/js/bootstrap.min.js" var="bootstrapJs"/>
    <spring:url value="/resources/js/index.js" var="mainJs" />

    <link href="${mainCss}" rel="stylesheet" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${bootstrapThemeCss}" rel="stylesheet" />
    <link href="${dataTablesCss}" rel="stylesheet" />
    <script src="${jqueryJs}"></script>
    <script src="${dataTablesJs}"></script>
    <script src="${bootstrapJs}"></script>
    <script src="${mainJs}"></script>
  </head>
  <body>
  <div class="container">
    <nav class="navbar navbar-light bg-faded">
      <a href="/" class="btn btn-primary" role="button">Main</a>
      <a href="/add-journal-row" class="btn btn-primary" role="button">Add Journal Row</a>
      <a href="/students" class="btn btn-primary" role="button">Students</a>
      <a href="/lectures" class="btn btn-primary" role="button">Lectures</a>
      <a href="/add-student" class="btn btn-primary" role="button">Add student</a>
      <a href="/add-lecture" class="btn btn-primary" role="button">Add lecture</a>

    </nav>
  </div>
  </body>
  <script type="javascript">
    <%@include file="/resources/js/index.js"%>
  </script>
</html>
