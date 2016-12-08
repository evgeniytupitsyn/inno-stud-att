<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 28.11.2016
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp"%>

<div class="container">
    <table id="journal" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>FIRST NAME</th>
            <th>LAST NAME</th>
            <th>GROUP</th>
            <th>LECTURE NAME</th>
            <th>DATA</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <th>FIRST NAME</th>
            <th>LAST NAME</th>
            <th>GROUP</th>
            <th>LECTURE NAME</th>
            <th>DATA</th>
        </tr>
        </tfoot>
        <tbody>
        <c:forEach items="${journal}" var="element">
            <tr>
                <td>${element.getStudent().getFirstName()}</td>
                <td>${element.getStudent().getLastName()}</td>
                <td>${element.getStudent().getGroup()}</td>
                <td>${element.getLecture().getName()}</td>
                <td>${element.getDate()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
