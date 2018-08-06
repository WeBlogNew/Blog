<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

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
    <link rel="stylesheet" href="${basePath}/resource/layui/css/layui.css">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="${basePath}/resource/webuploader/webuploader.css">

    <script src="${basePath}/resource/layui/layui.js"></script>
    <script>
        var basePath = ${basePath};
    </script>
    <script src="${basePath}/resource/webuploader/upload.js"></script>

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
        <div class="col-md-2">
            <ul class="nav nav-list">
                <li class="nav-header">
                    功能列表
                </li>
                <li class="active">
                    <a href="${basePath}/member/index">个人信息</a>
                </li>
                <li>
                    <a href="#">我的博客</a>
                </li>
                <li>
                    <a href="#">关注/粉丝</a>
                </li>
                <li>
                    <a href="${basePath}/article/add">编写博客</a>
                </li>
                <li>
                    <a href="${basePath}/member/editInfo">编辑个人资料</a>
                </li>
                <li>
                    <a href="${basePath}/member/resetpwd">修改密码</a>
                </li>
                <li class="divider">
                </li>
                <li>
                    <a href="${basePath}/member/logout">退出登录</a>
                </li>
            </ul>
        </div>
        <div class="col-md-8">
            <form class="layui-form"  method="post" id="myForm" enctype="multipart/form-data" action="${basePath}/article/save">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">内容</label>
                    <div class="layui-input-block">
                        <textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="content"></textarea>
                    </div>
                </div>
                <button type="submit" id="publishBtn" class="btn btn-primary block full-width m-b">发布</button>
            </form>
        </div>
        <div class="col-md-2"></div>
    </div>

</div>

<br>
<br>
<br>
<br>

<%@include file="/WEB-INF/views/common/footer.jsp"%>

</body>
<script>
    layui.use(['form', 'layedit'], function() {
        var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
        //上传图片,必须放在 创建一个编辑器前面
        layedit.set({
            uploadImage: {
                url: '${basePath}/upload/uploadFile' //接口url
                ,done: function (res) {
                    if(res.code == 0){
                       layer.alert("success");
                    }else {
                        layer.alert("failed");
                    }
                }
            }
        });
        //创建一个编辑器
        var index = layedit.build('content',{
                    height:400
                }
        );

        //编辑器外部操作
        var active = {
            content: function(){
                alert(layedit.getContent(index)); //获取编辑器内容
            }
            ,text: function(){
                alert(layedit.getText(index)); //获取编辑器纯文本内容
            }
            ,selection: function(){
                alert(layedit.getSelection(index));
            }
        };

        $('.site-demo-layedit').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

    });

</script>

</html>
