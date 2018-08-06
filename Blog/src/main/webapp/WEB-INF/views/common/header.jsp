<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<nav class="navbar navbar-default navbar-fixed-top">
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
                <a class="navbar-brand" href="${basePath}/">WEBLOG</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="${basePath}/">首页</a></li>
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
                <c:choose>
                    <c:when test="${empty loginUser}">
                        <li><a href="${basePath}/member/login">登录</a></li>
                        <li><a href="${basePath}/member/register">注册</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><img src="http://snowcoal.com/image/portrait/default_header.jpg" alt="..." class="img-circle" width="40" height="40" align="middle"></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${loginUser.name} <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${basePath}/member/index">个人信息</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="${basePath}/article/add">编写博客</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="${basePath}/member/logout" >退出登录</a></li>
                            </ul>
                        </li>
                    </c:otherwise>
                </c:choose>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div>
    </div><!-- /.container-fluid -->
</nav>