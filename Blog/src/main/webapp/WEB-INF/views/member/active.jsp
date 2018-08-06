<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 18-4-20
  Time: 上午9:20
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
                <h2 class="font-bold">激活账号</h2>
                <form class="m-t jeesns_form" action="${basePath}/member/active" method="post">
                    <div class="form-group">
                        邮箱
                        <input type="text" class="form-control" disabled data-type="require" value="${loginUser.email}">
                    </div>
                    <div class="form-group">
                        验证码
                        <input type="text" class="form-control" name="randomCode" placeholder="验证码" data-type="require">
                    </div>
                    <button type="button" class="btn btn-primary m-b" id="getValidCodeBtn">获取验证码</button>
                    <button type="submit" class="btn btn-primary m-b">激活账号</button>
                </form>
                <p></p>

            </div>
        </div>
    </div>
</div>
<#include "/member/common/footer.ftl"/>
<script>
    $(document).ready(function () {
        $("#getValidCodeBtn").click(function () {
            var index;
            var _this = this;
            $(_this).attr("disabled","disabled");
            $.ajax({
                url:"${basePath}/member/sendEmailActiveValidCode",
                type:"get",
                dataType:"json",
                beforeSend: function(){
                    index = jeesnsDialog.loading();
                },
                error: function(){
                    jeesnsDialog.close(index);
                    jeesnsDialog.errorTips("请求失败");
                },
                success:function(res){
                    jeesnsDialog.close(index);
                    if(res.code == 0){
                        jeesnsDialog.successTips(res.message);
                    }else {
                        jeesnsDialog.errorTips(res.message);
                    }
                    window.sendSmsID;
                    window.curCount = 60;//当前剩余秒数
                    $(_this).attr("disabled", "true");
                    $(_this).html(window.curCount + "秒");
                    window.sendSmsID = window.setInterval(function() {
                        if (window.curCount == 1) {
                            window.clearInterval(window.sendSmsID);//停止计时器
                            $(_this).removeAttr("disabled");//启用按钮
                            $(_this).html("获取验证码");
                        }else {
                            window.curCount--;
                            $(_this).html(window.curCount + "秒");
                        }
                    }, 1000);
                }
            });
        });
    });
</script>
</body>
</body>
</html>
