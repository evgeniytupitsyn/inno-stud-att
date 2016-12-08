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
    <table id="students" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Group</th>
            <th>COUNT LECTURE</th>

        </tr>
        </thead>
        <tfoot>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Group</th>
            <th>COUNT LECTURE</th>
        </tr>
        </tfoot>
        <tbody>
        <c:forEach items="${students}" var="element">
            <tr>
               <td>${element.getFirstName()}</td>
               <td>${element.getLastName()}</td>
               <td>${element.getGroup()}</td>
               <td>${element.getCountLecture()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
