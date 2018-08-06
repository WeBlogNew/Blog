function checkForm() {
    if($("#oldPassword").val() == ""){
        layer.alert("旧密码不能为空！");
        return false;
    }
    if($("#newPassword").val() == ""){
        layer.alert("新密码不能为空！");
        return false;
    }
    if($("#renewPassword").val() == ""){
        layer.alert("两处新密码不一致！");
        return false;
    }
    return true;
}

var index;
var options = {
    type : 'post',
    timeout : 5000,
    beforeSubmit : function () {
        $(":button").attr("disabled","disabled");
        index = layer.load(0);
    },
    error : function () {
        layer.close(index);
        $(":button").removeAttr("disabled");
        layer.msg("请求失败！");
    },
    success:function (result) {
        layer.close(index);
        $(":button").removeAttr("disabled");
        switch (result.code){
            case 0:
            case 1:
            case 2:
            case 3:
                layer.msg(result.message, {icon: 6});
                window.location.href = window.location.href;
                break;
            case -1:
                layer.msg(result.message, {icon: 5});
                break;
            default:
                layer.msg(result.message);
                break;
        }
    }
};

function changePwd(){
    if(!checkForm()){
        return;
    }
    $(".WeBlog_form").ajaxSubmit(options);
}
