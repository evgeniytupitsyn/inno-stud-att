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
    <form class="form-horizontal" method="post" action="/add-student">
        <fieldset>

            <!-- Form Name -->
            <legend>Add new Student</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="last-name">Фамилия</label>
                <div class="col-md-5">
                    <input id="last-name" name="last-name" type="text" placeholder="Введите фамилию" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="first-name">Имя</label>
                <div class="col-md-5">
                    <input id="first-name" name="first-name" type="text" placeholder="Введите имя" class="form-control input-md">

                </div>
            </div>

            <!-- Multiple Radios (inline) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="sex">Пол</label>
                <div class="col-md-4">
                    <label class="radio-inline" for="sex-0">
                        <input type="radio" name="sex" id="sex-0" value="1" checked="checked">
                        М
                    </label>
                    <label class="radio-inline" for="sex-1">
                        <input type="radio" name="sex" id="sex-1" value="2">
                        Ж
                    </label>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="group">Группа</label>
                <div class="col-md-5">
                    <input id="group" name="group" type="text" placeholder="Введите номер группы" class="form-control input-md">

                </div>
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