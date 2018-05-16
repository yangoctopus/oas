function  addPost() {
    layui.use('layer', function() {

            layer.open({
                type: 2,
                title: '新建岗位',
                shade: [0.8, '#393D49'],
                shadeClose: true,
                //开启最大化最小化按钮 右上角
                maxmin: true,
                anim: 6,
                area: ['600px', '300px'],
                content: 'postAction_addPostUI.action'
            });
        });

}

function  updatePost(index) {
    layui.use('layer', function() {

        layer.open({
            type: 2,
            title: '修改岗位',
            shade: [0.8, '#393D49'],
            shadeClose: true,
            //开启最大化最小化按钮 右上角
            maxmin: true,
            anim: 6,
            area: ['600px', '300px'],
            content: 'postAction_loadPost.action?pid='+index,
        });
    });

}