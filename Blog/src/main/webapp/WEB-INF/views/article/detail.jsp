<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>test</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="${basePath}/resource/js/common/jquery-2.1.1.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${basePath}/resource/js/common/extendPagination.js"></script>
</head>

<body>


<div class="container">
    <div class="row">
        <div class="col-md-9">
            <p>正文</p><!--正文-->
            <p>${article.content}</p>
        </div>
        <div class="col-md-3">
            <p>${article.description}</p><!--相关信息-->
        </div>
    </div>
</div>


</body>

</html>