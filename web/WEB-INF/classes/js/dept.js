function  addDept() {
    layui.use('layer', function() {

        layer.open({
            type: 2,
            title: '新建部门',
            shade: [0.8, '#393D49'],
            shadeClose: true,
            //开启最大化最小化按钮 右上角
            maxmin: true,
            anim: 6,
            area: ['600px', '300px'],
            content: 'deptAction_addDeptUI.action'
        });
    });

}

function updateDept(did) {
    layui.use('layer', function() {

        layer.open({
            type: 2,
            title: '修改部门',
            shade: [0.8, '#393D49'],
            shadeClose: true,
            //开启最大化最小化按钮 右上角
            maxmin: true,
            anim: 6,
            area: ['600px', '300px'],
            content: 'deptAction_toUpdateDept.action?did='+did
        });
    });

}