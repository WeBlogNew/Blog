<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 18-4-13
  Time: 下午3:44
  To change this template use File | Settings | File Templates.
--%>
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
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${basePath}/resource/js/common/jquery.form.js"></script>
    <script src="${basePath}/resource/layer/layer.js"></script>
    <script src="${basePath}/resource/js/member/editInfo.js"></script>

    <script src="${basePath}/resource/js/member/weblog.js"></script>
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
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <form id="info_edit_form" action="${basePath}/member/editBaseInfo">
                    <h2 class="font-bold" style="text-align: center">编辑个人资料</h2>
                    <br>
                    <hr />
                    <div class="form-group">
                        用户名
                        <input type="text" id="name" class="form-control" name="name" value="${loginUser.name}" data-type="require">
                    </div>
                    <div class="form-group">
                        简介
                        <input type="text" id="introduce" class="form-control" name="introduce" value="${loginUser.introduce}" data-type="require">
                    </div>
                    <center>
                        <input type="hidden" id="oldSex" value="${loginUser.sex}">
                        <input value="" type="radio" id="secret" name="sex" />保密
                        <input value="男" type="radio" id="man" name="sex" />男
                        <input value="女" type="radio" id="woman" name="sex"/>女
                    </center>
                    <br>
                    <center><button type="button" class="btn btn-primary block full-width m-b" onclick="editInfo()">确认修改</button></center>
                    <br>
                    <center><a href=${basePath}/member/avatar>编辑头像</a></center>
                </form>
            </div>


            <div class="col-md-4"></div>
        </div>

        <div id="tab-2" class="tab-pane">
            <div class="panel-body">
                <form class="form-horizontal m-t jeesns_form"
                      action="${basePath}/member/editOtherInfo" method="post">
                    <input name="id" class="form-control" type="hidden" dataType=""
                           value="${loginUser.id}">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">生日：</label>
                        <div class="col-sm-8">
                            <input id="birthday" name="birthday" type="text" class="form-control"
                                   value="${loginUser.birthday}" onClick="WdatePicker()"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">QQ：</label>
                        <div class="col-sm-8">
                            <input id="qq" name="qq" class="form-control" type="text"
                                   dataType="" value="${loginUser.qq}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">微信：</label>
                        <div class="col-sm-8">
                            <input id="wechat" name="wechat" class="form-control" type="text"
                                   dataType="" value="${loginUser.wechat}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">联系电话：</label>
                        <div class="col-sm-8">
                            <input id="contactPhone" name="contactPhone" class="form-control"
                                   type="text" dataType="" value="${loginUser.contactPhone}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">联系邮箱：</label>
                        <div class="col-sm-8">
                            <input id="contactEmail" name="contactEmail" class="form-control"
                                   type="text" dataType="" value="${loginUser.contactEmail}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">个人网站：</label>
                        <div class="col-sm-8">
                            <input id="website" name="website" class="form-control" type="text"
                                   dataType="" value="${loginUser.website}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-8 col-sm-offset-2">
                            <input type="submit"
                                   class="btn btn-primary block full-width m-b jeesns-submit"
                                   value="修改">
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>

<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>
