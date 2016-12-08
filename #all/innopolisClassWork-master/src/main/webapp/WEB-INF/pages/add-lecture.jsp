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
    <form class="form-horizontal" method="post" action="/add-lecture">
        <fieldset>

            <!-- Form Name -->
            <legend>Add new Lecture</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Лекция</label>
                <div class="col-md-5">
                    <input id="name" name="name" type="text" placeholder="Введите название лекции" class="form-control input-md">

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