<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="col-md-2">
    <ul class="nav nav-list">
        <li class="nav-header">
            功能列表
        </li>
        <li class="active">
            <a href="${basePath}/member/index">个人信息</a>
        </li>
        <li>
            <a href="${basePath}/member/${loginUser.id}/articles">我的博客</a>
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
            <a href="${basePath}/member/password">修改密码</a>
        </li>
        <li class="divider">
        </li>
        <li>
            <a href="${basePath}/member/logout">退出登录</a>
        </li>
    </ul>
</div>