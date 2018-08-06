function checkForm() {
    if($("#name").val() == "")
        return false;
    if($("#password").val() == "")
        return false;
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

function login(){
    if(!checkForm()){
        layer.alert("用户名或密码不能为空！");
        return;
    }
    $("#WeBlog_login_form").ajaxSubmit(options);
}