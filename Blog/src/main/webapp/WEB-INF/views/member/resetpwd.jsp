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
    <title>Title</title>
</head>
<body>
<div class="animated fadeInDown">
    <div class="row login-panel">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="ibox-content">
                <h2 class="font-bold">重置密码</h2>
                <form class="m-t jeesns_form" action="${basePath}/member/resetpwd" method="post">
                    <input name="email" class="form-control" type="hidden" value="${email}">
                    <input name="token" class="form-control" type="hidden" value="${token}">
                    <div class="form-group">
                        新密码
                        <input id="newPassword" name="password" class="form-control" type="password" data-type="require" alt="新密码">
                    </div>
                    <div class="form-group">
                        确认新密码
                        <input id="renewPassword" name="repassword" class="form-control" type="password" data-type="require" data-rule="equal[newPassword]" alt="两次密码必须一致">
                    </div>
                    <button type="submit" class="btn btn-primary m-b">重置密码</button>
                </form>
                <p></p>

            </div>
        </div>
    </div>
</div>
</body>
</html>
