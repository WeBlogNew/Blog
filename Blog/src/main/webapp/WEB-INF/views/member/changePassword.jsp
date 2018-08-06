<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 18-4-11
  Time: 上午10:13
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
    <script src="${basePath}/resource/js/common/jquery.form.js"></script>
    <script src="${basePath}/resource/layer/layer.js"></script>
    <script src="${basePath}/resource/js/member/changePassword.js"></script>
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
            <div class="animated fadeInDown">
                <div class="row login-panel">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <div class="ibox-content">
                            <h2 class="font-bold">修改密码</h2>
                            <form class="m-t WeBlog_form" action="${basePath}/member/changePassword">
                                <div class="form-group">
                                    旧密码
                                    <input id="oldPassword" name="oldPassword" class="form-control" type="password" data-type="require" alt="新密码">
                                </div>
                                <div class="form-group">
                                    新密码
                                    <input id="newPassword" name="newPassword" class="form-control" type="password" data-type="require" alt="新密码">
                                </div>
                                <div class="form-group">
                                    确认新密码
                                    <input id="renewPassword" name="renewPassword" class="form-control" type="password" data-type="require" data-rule="equal[newPassword]" alt="两次密码必须一致">
                                </div>
                                <center><button type="button" class="btn btn-primary m-b" onclick="changePwd()">修改密码</button></center>
                            </form>
                            <p></p>

                        </div>
                    </div>
                </div>
            </div>
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
