<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 林立鹏
  Date: 2018/5/2
  Time: 17:52
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
    <script src="../../../resource/js/common/jquery-2.1.1.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Title</title>
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
            <div class="page-header">
                <h1>
                    我的博客
                </h1>
            </div>


            <c:forEach items="${articleModel.data.list}" var="article">
                <div class="media"><a class="pull-left" href="#"><img class="media-object" src="${article.thumbnail}" /> </a>
                    <div class="media-body" contenteditable="true">
                        <h4 class="media-heading">${article.title}</h4>
                            ${article.description}</div>
                </div>
            </c:forEach>

        </div>
        <div class="col-md-2"></div>
    </div>
</div>
<br>
<br>
<br>
<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>
