<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 18-4-11
  Time: 上午1:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String path = request.getContextPath();
    String basePath =request.getScheme()+"://"+request.getServerName()+":"
            +request.getServerPort()+path;
    pageContext.setAttribute("basePath",basePath);
%>

<html>
<head>
    <style type="text/css">
        html {
            position: relative;
            min-height: 100%;
        }
        body {
            /* Margin bottom by footer height */
            margin-bottom: 60px;
        }
        .footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            /* Set the fixed height of the footer here */
            height: 60px;
            background-color: darkgrey;
        }
    </style>
    <script src="../../../resource/js/common/jquery-2.1.1.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="${basePath}/resource/js/common/jquery.form.js"></script>
    <script src="${basePath}/resource/layer/layer.js"></script>
    <script src="${basePath}/resource/js/member/weblog.js"></script>
    <title>会员注册 -  Poweer by WEBLOG</title>
</head>
<body>

<%@include file="/WEB-INF/views/common/header.jsp"%>
<%--<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="span12">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">WEBLOG</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/index">首页</a></li>
                    <li><a href="#">Link</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${basePath}/member/login">登录</a></li>
                    <li><a href="${basePath}/member/register">注册</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->

        </div>
    </div><!-- /.container-fluid -->
</nav>--%>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="animated fadeInDown">
    <div class="row login-panel">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="ibox-content">
                <h3>欢迎加入${SITE_NAME}</h3>
                <form class="m-t jeesns_form" action="${basePath}/member/register" method="post">
                    <div class="form-group">
                        用户名
                        <input type="text" name="name" class="form-control" placeholder="用户名" data-type="require">
                    </div>
                    <div class="form-group">
                        邮箱
                        <input type="email" name="email" class="form-control" placeholder="邮箱" data-type="require,email">
                    </div>
                    <div class="form-group">
                        密码
                        <input type="password" id="password" name="password" class="form-control" placeholder="密码" data-type="require">
                    </div>
                    <div class="form-group">
                        确认密码
                        <input type="password" name="repassword" class="form-control" placeholder="确认密码" data-type="require" data-rule="equal[password]">
                    </div>
                    <button type="submit" class="btn btn-primary block full-width m-b">注册</button>
                    <p></p>
                    <p class="text-muted text-center">
                        <a href="forgetpwd">忘记密码?</a>
                        <a href="login">我要登录</a>
                    </p>
                 </form>
            </div>
        </div>
    </div>
</div>
<br>
<br>
<br>
<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>
