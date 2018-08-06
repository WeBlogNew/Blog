<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="box-tools">
    <form method="get" action="${managePath}/member/manageList">
        <div class="input-group input-group-sm" style="width: 350px;">
            <input id="searchKey" type="text" name="key" class="form-control pull-right"
                   placeholder="请输入关键词" value="${key}">
            <div class="input-group-btn">
                <button id="searchButton" type="submit" class="btn btn-default"><i class="fa fa-search"></i>
                </button>
            </div>
        </div>
    </form>
</div>