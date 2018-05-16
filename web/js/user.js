function  addUser() {
    layui.use('layer', function() {

        layer.open({
            type: 2,
            title: '新建用户',
            shade: [0.8, '#393D49'],
            shadeClose: true,
            //开启最大化最小化按钮 右上角
            maxmin: true,
            anim: 6,
            area: ['600px', '300px'],
            content: 'userAction_addUserUI.action'
        });
    });

}

function saveAdd(){
    $.ajax({
        url:'userAction_saveUser.action',
        type:'POST', //GET  默认为GET
        data:$("#frm").serialize()
    });
    window.parent.location.reload();
    var index = window.parent.layer.getFrameIndex(window.name);
    //alert(index);
    window.parent.layer.close(index);
}

function canel(){
    var index = window.parent.layer.getFrameIndex(window.name);
    //alert(index);
    window.parent.layer.close(index);
}

function updateUser(uid) {
    layui.use('layer', function() {

        layer.open({
            type: 2,
            title: '修改用户',
            shade: [0.8, '#393D49'],
            shadeClose: true,
            //开启最大化最小化按钮 右上角
            maxmin: true,
            anim: 6,
            area: ['600px', '300px'],
            content: 'userAction_updateUserUI.action?uid='+uid
        });
    });

}

function saveUpdate(){
    $.ajax({
        url:'userAction_updateUser.action',
        type:'POST', //GET  默认为GET
        data:$("#frm2").serialize()
    });
    window.parent.location.reload();
    var index = window.parent.layer.getFrameIndex(window.name);
    //alert(index);
    window.parent.layer.close(index);
}