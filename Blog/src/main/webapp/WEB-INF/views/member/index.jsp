<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 18-4-11
  Time: 下午2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

    <script src="${basePath}/resource/js/common/jquery-2.1.1.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>个人中心 - Power by WEBLOG</title>
</head>
<body>

<%@include file="/WEB-INF/views/common/header.jsp"%>

<br>
<hr />
<br>
<br>
<br>
<div class="container-fluid">
    <div class="row">
        <%@include file="functionNav.jsp"%>

        <div class="col-md-8">
            <div class="row">
                <div class="col-md-2">
                    <div class="avatar">
                        <img src="${basePath}${loginUser.avatar}" class="img-circle" width="100px" height="100px"/>
                    </div>
                </div>
                <div class="col-md-10">
                    <div class="info">
                            <div class="name">
                                <c:choose>
                                    <c:when test="${loginUser.sex=='女'}">
                                        <p class="text-left"><h2>${loginUser.name} <a href="http://pic.wenwen.soso.com/p/20130526/20130526191300-2042020679.jpg"><img alt="" src="http://pic.wenwen.soso.com/p/20130526/20130526191300-2042020679.jpg" style="width: 15px; height: 15px;" /></a></h2></p>                            </c:when>
                                    <c:when test="${loginUser.sex=='男'}">
                                        <p class="text-left"><h2>${loginUser.name} <a href="http://ico.ooopic.com/ajax/iconpng/?id=99084.png"><img alt="" src="http://ico.ooopic.com/ajax/iconpng/?id=99084.png" style="width: 15px; height: 15px;" /></a></h2></p>                            </c:when>
                                    <c:otherwise>
                                        <p class="text-left"><h2>${loginUser.name} </h2></p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    <p>个人网站：${loginUser.website}</p>
                    <p>个人简介：${loginUser.introduce}</p>
                    <br>
                    <br>
                    <div class="follows">
                        <span>关注</span>
                        <a href="${basePath}/u/${loginUser.id}/home/follows">${loginUser.follows}</a>
                    </div>
                    <div class="fans">
                        <span>粉丝</span>
                        <a href="${basePath}/u/${loginUser.id}/home/fans">${loginUser.fans}</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>
