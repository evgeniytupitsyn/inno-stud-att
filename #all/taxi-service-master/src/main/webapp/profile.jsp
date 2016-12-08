<%@ page import="ru.innopolis.nikn.dao.User" %><%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 21.11.2016
  Time: 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/index.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="well well-sm">
                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <img src="http://placehold.it/380x500" alt="" class="img-rounded img-responsive" />
                    </div>
                    <div class="col-sm-6 col-md-8">
                        <h4> ${sessionScope.login} </h4>
                        <h4>${requestScope.user.getFirstName()} ${requestScope.user.getLastName()}l</h4>
                        <small><cite title="San Francisco, USA">San Francisco, USA <i class="glyphicon glyphicon-map-marker">
                        </i></cite></small>
                        <p>
                            <i class="glyphicon glyphicon-envelope"></i>  ${requestScope.user.getEmail()}
                            <br />
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>