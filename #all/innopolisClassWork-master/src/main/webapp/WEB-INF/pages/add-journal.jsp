<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 25.11.2016
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp"%>
<div class="container">
    <form class="form-horizontal" method="post" action="/add-journal-row">
        <fieldset>
            <!-- Form Name -->
            <legend>Add new Journal Row</legend>
            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="student_id">Студент</label>
                <div class="col-md-5">
                    <select id="student_id" name="student_id" class="selectpicker">
                        <c:forEach items="${students}" var="element">
                            <option value="${element.getId()}">${element.getFirstName()}  ${element.getLastName()} ${element.getGroup()}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="lecture_id">Лекция</label>
                <div class="col-md-5">
                    <select id="lecture_id" name="lecture_id" class="selectpicker">
                        <c:forEach items="${lectures}" var="element">
                            <option value="${element.getId()}">${element.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="date">Введите дату:</label>
                <input type="date" class="form-control" id="date" name="date">
            </div>
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="success"></label>
                <div class="col-md-4">
                    <button type="submit" id="success" name="success" class="btn btn-success">Добавить</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>