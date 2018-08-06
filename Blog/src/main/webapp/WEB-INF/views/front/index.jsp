<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 18-4-11
  Time: 上午10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
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
    <script src="${basePath}/resource/js/article/showDetail.js"></script>

    <title>WeBlog - Power by WEBLOG</title>
</head>

<body>
<%@include file="/WEB-INF/views/common/header.jsp"%>
<%--<nav class="navbar navbar-default navbar-fixed-top">
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
            <a class="navbar-brand" href="#">WEBLOG</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">首页 <span class="sr-only">(current)</span></a></li>
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
                    <li><a href="${basePath}/member/login">登录</a></li>
                    <li><a href="${basePath}/member/register">注册</a></li>
                    &lt;%&ndash;<li><a href="${managePath}/member/manageList">管理成员</a> </li>&ndash;%&gt;
                </ul>
            </div><!-- /.navbar-collapse -->

        </div>
    </div><!-- /.container-fluid -->
</nav>--%>

<div class="container-fluid">

    <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="http://www.bootcss.com/p/layoutit/img/2.jpg" alt="">
                    <div class="carousel-caption">
                        <h4>
                            冲浪
                        </h4>
                        <p>
                            冲浪是以海浪为动力，利用自身的高超技巧和平衡能力，搏击海浪的一项运动。运动员站立在冲浪板上，或利用腹板、跪板、充气的橡皮垫、划艇、皮艇等驾驭海浪的一项水上运动。
                        </p>
                    </div>
                </div>
                <div class="item">
                    <img src="http://www.bootcss.com/p/layoutit/img/3.jpg" alt="">
                    <div class="carousel-caption">
                        <h4>
                            自行车
                        </h4>
                        <p>
                            以自行车为工具比赛骑行速度的体育运动。1896年第一届奥林匹克运动会上被列为正式比赛项目。环法赛为最著名的世界自行车锦标赛。
                        </p>
                    </div>
                </div>
                <div class="item">
                    <img src="http://www.bootcss.com/p/layoutit/img/1.jpg" alt="">
                    <div class="carousel-caption">
                        <h4>
                            棒球
                        </h4>
                        <p>
                            棒球运动是一种以棒打球为主要特点，集体性、对抗性很强的球类运动项目，在美国、日本尤为盛行。
                        </p>
                    </div>
                </div>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="carousel-control left" href="#myCarousel"
               data-slide="prev"> <span aria-hidden="true" class="glyphicon glyphicon-chevron-left"></span></a>
            <a class="carousel-control right" href="#myCarousel"
               data-slide="next"><span aria-hidden="true" class="glyphicon glyphicon-chevron-right"></span></a>
        </div>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <br>
            <br>

            <div class="row">

                <c:forEach items="${articleModel.data.list}" var="article">
                    <div class="col-sm-5 col-md-4">
                        <div class="thumbnail">
                            <img src="${article.thumbnail}" alt="" >
                            <div class="caption">
                                <h3>${article.title}</h3>
                                <p>${article.description}</p>
                                <p>
                                    <a href="javascript:void(0)" class="btn btn-primary btn_article" role="button" url="${basePath}/article/detail/${article.id}">查看详情</a>
                                    <a href="#" class="btn btn-default" role="button">Button</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
            <br>
            <br>
            <div style="text-align: center">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="${basePath}/?pageNo=1">1</a></li>
                        <li><a href="${basePath}/?pageNo=2">2</a></li>
                        <li><a href="${basePath}/?pageNo=3">3</a></li>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <br>
            <br>
            <br>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>
<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>
