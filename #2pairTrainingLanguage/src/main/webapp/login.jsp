<%--
  Created by IntelliJ IDEA.
  User: evgeniytupitsyn
  Date: 19.11.2016
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/index.jsp"%>
<div class="container">
    <div class="row main">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title">Innopolis pairTraining &trade;</h1>
                <hr />
            </div>
        </div>
        <div class="main-login main-center">
            <c:if test="${not empty requestScope.message}">
                <div class="alert alert-danger">
                ${message}
                </div>
            </c:if>

            <form class="form-horizontal" method="post" action="/login">
                <div class="form-group">
                    <label for="login" class="cols-sm-2 control-label">Login</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="login" id="login"  placeholder="Enter your Login" required/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">Password</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password" required/>
                        </div>
                    </div>
                </div>
                <div class="form-group ">
                    <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Login</button>
                </div>
                <div class="login-register">
                    <a href="register">Register</a>
                </div>
            </form>
        </div>
    </div>
</div>
