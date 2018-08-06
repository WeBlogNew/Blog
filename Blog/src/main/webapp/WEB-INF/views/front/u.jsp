<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 2018/5/7
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="wrapper wrapper-content">
    <div class="member-banner" style="background-image: url(${basePath}/res/common/images/member_banner.png);">
        <div class="attempts"></div>
        <div class="container">
            <div class="container content">
                <div class="left">
                    <div class="avatar">
                        <img src="${basePath}${member.avatar}" class="img-circle" width="80px" height="80px"/>
                    </div>
                    <div class="info">
                        <div class="name">
                            ${member.name}

                                <span class="sex"><i class="fa fa-venus"></i></span>

                        </div>
                        <p>${member.website}</p>
                        <p>${member.introduce}</p>
                        <p class="operator">
                            <a class="label label-primary member-follows" member-id="${member.id}">
                                <i class="fa fa-heart-o"></i> 关注
                            </a>
                            <a class="label label-primary" href="${basePath}/member/sendMessageBox?mid=${member.id}" target="_jeesnsOpen" title="私信" height="285px">
                                <i class="fa fa-comments"></i> 私信
                            </a>
                        </p>
                    </div>
                </div>
                <div class="right">
                    <div class="follows">
                        <span>关注</span>
                        <a href="${basePath}/u/${member.id}/home/follows">${member.follows}</a>
                    </div>
                    <div class="fans">
                        <span>粉丝</span>
                        <a href="${basePath}/u/${member.id}/home/fans">${member.fans}</a>
                    </div>
                    <div class="score">
                        <span>积分</span>
                        <a href="${basePath}/member/scoreDetail/list">${member.score}</a>
                    </div>
                    <div class="login-info">
                        加入时间:${member.createTime}

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="ibox">
                <div class="ibox-content float-left">
                    <div class="col-sm-2">
                        <div class="float-e-margins">
                            <div class="feed-activity-list">
                                <a href="${basePath}/u/${member.id}">
                                    <div class="feed-element">
                                        <div class="media-body">
                                            动态
                                        </div>
                                    </div>
                                </a>
                                <a href="${basePath}/picture/album/${member.id}">
                                    <div class="feed-element">
                                        <div class="media-body">
                                            相册
                                        </div>
                                    </div>
                                </a>
                                <a href="${basePath}/u/${member.id}/home/fans">
                                    <div class="feed-element">
                                        <div class="media-body">
                                            粉丝
                                        </div>
                                    </div>
                                </a>
                                <a href="${basePath}/u/${member.id}/home/follows">
                                    <div class="feed-element">
                                        <div class="media-body">
                                            关注
                                        </div>
                                    </div>
                                </a>
                                <a href="${basePath}/u/${member.id}/home/article">
                                    <div class="feed-element">
                                        <div class="media-body">
                                            文章
                                        </div>
                                    </div>
                                </a>
                                <a href="${basePath}/u/${member.id}/home/groupTopic">
                                    <div class="feed-element">
                                        <div class="media-body">
                                            群帖
                                        </div>
                                    </div>
                                </a>
                                <a href="${basePath}/u/${member.id}/home/weibo">
                                    <div class="feed-element">
                                        <div class="media-body">
                                            微博
                                        </div>
                                    </div>
                                </a>
                                <a href="${basePath}/u/${member.id}/home/group">
                                    <div class="feed-element">
                                        <div class="media-body">
                                            关注群组
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-10">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>动态</h5>
                            </div>
                            <div>
                                <div class="feed-activity-list">
                                    <#list actionLogModel.data as actionLog>
                                        <div class="feed-element">
                                            <a href="${basePath}/u/${actionLog.member.id}" class="pull-left">
                                                <img alt="image" class="img-circle"
                                                     src="${basePath}${actionLog.member.avatar}">
                                            </a>
                                            <div class="media-body ">
                                                <small class="pull-right text-navy">${actionLog.createTime}</small>
                                                <strong><a href="${basePath}/u/${actionLog.member.id}">${actionLog.member.name}</a> </strong>${actionLog.action.log}：<br/>
                                                <#if actionLog.type==1>
                                                    <a href="${basePath}/article/detail/${actionLog.foreignId}"
                                                       target="_blank">${actionLog.remark}</a>
                                                    <#elseif actionLog.type==2>
                                                        <p>${actionLog.remark}</p>
                                                        <a href="${basePath}/weibo/detail/${actionLog.foreignId}"
                                                           target="_blank">查看</a>
                                                        <#elseif actionLog.type==4>
                                                            <a href="${basePath}/group/topic/${actionLog.foreignId}"
                                                               target="_blank">${actionLog.remark}</a>
                                                </#if>
                                                <br>
                                                <div class="actions">
                                                </div>
                                            </div>
                                        </div>
                                    </#list>
                                    <div class="box-footer clearfix">
                                        <ul class="pagination pagination-sm no-margin pull-right"
                                            url="${basePath}/u/${member.id}"
                                            currentPage="${actionLogModel.page.pageNo}"
                                            pageCount="${actionLogModel.page.totalPage}">
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
