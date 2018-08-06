layui.use(['form', 'layedit', 'laydate'], function () {
    var layer = layui.layer
        , layedit = layui.layedit
    //上传图片,必须放在 创建一个编辑器前面
    layedit.set({
        uploadImage: {
            url: 'upload/uploadImage' //接口url
            , type: 'post' //默认post
            , done: function (res) {
                if (res.code == 0) {
                    alert("success");
                } else {
                    alert("failed");
                }
            }
        }
    });
    //创建一个编辑器
    var editIndex = layedit.build('content', {
            height: 400
        }
    );
});



