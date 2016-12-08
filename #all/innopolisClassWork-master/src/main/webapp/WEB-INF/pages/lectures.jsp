<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 24.11.2016
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp"%>
<div class="container">
    <table id="lectures" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>Name</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <th>Name</th>
        </tr>
        </tfoot>
        <tbody>
        <c:forEach items="${lectures}" var="element">
            <tr>
               <td>${element.getName()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
