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

<div class="box-body table-responsive no-padding">
    <table class="table table-hover">
        <thead>
        <tr>
            <th style="width: 10px">#</th>
            <th>用户名</th>
            <th>邮箱</th>
            <th>手机号码</th>
            <th>注册时间</th>
            <th width="150px">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${model.data.list}" var="member">
            <tr>
                <td>${member.id}</td>
                <td>${member.name}</td>
                <td>${member.email}</td>
                <td>${member.phone}</td>
                <td><fmt:formatDate type="both" value="${member.createTime}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="box-footer clearfix">
    <ul class="pagination pagination-sm no-margin pull-right"
        url="${managePath}/member/manageList"
        currentPage="${model.data.pageNum}"
        pageCount="${model.data.pages}">

    </ul>
</div>


</body>

<script type="text/javascript">
    $(function () {
        $(".pagination").paginate();
    });

    $("#searchKey").blur(function(){
        if($(this).val() == ""){
            $("#searchButton").click();
        }
    });
</script>

</html>