
var settings={

    data:{
        simpleData:{
            enable:true,  //ztree提供数据的json为简单json
            idKey:"ktid",
            pIdKey:"ktpid"
        },
        key:{

            name:"ktname"
        }
    },
    callback: { //给ztree树注册右键事件
        onRightClick: zTreeOnRightClick,
        onClick: zTreeOnClick//给ztree树注册单击事件
    }

};
$(function(){

    $.post("ktreeAction_loadKnowLedgeTreeList.action",function(data){
        //显示ztree
        $.fn.zTree.init($("#kynamicTree"),settings,data);

    });
})

//////////////////////////////////////////////////

/*
 * 右键会调函数
 * */
function zTreeOnRightClick(event, treeId, treeNode){
    //获得右键菜单div
    var rMenu=$("#rMenu")
    rMenu.show();

    //获得鼠标点击的位置
    var x=event.clientX;
    var y=event.clientY;

    //设置右键菜单的位置（坐标）
    rMenu.css({"top":y+"px", "left":x+"px"});

    //alert(treeNode.ktid + ", " + treeNode.ktname+ "isRoot");

    /*
     * 右键菜单项绑定事件
     * */

    //绑定添加节点的事件
    var add=$("#add");
    add.unbind();
    add.bind("click",function(){
        rMenu.hide();

        //获得ztree树对象
        var treeObj = $.fn.zTree.getZTreeObj("kynamicTree");

        //获得新增的节点的父id
        var ktpid=treeNode.ktid;
        //输入节点名称
        var ktname=window.prompt("请输入节点名称:");

        if(ktname){

            var params="ktpid="+ktpid+"&ktname="+ktname;
            //发送ajax请求
            $.post("ktreeAction_addKtree.action",params,function(data){
                var node=data[0]; //当前添加的节点对应的json对象

                //客户端刷新ztree树，给当前点击的节点，增加子节点。
                treeObj.addNodes(treeNode,-1,node);
            });
        }


        //alert(ktname);

    });

    ////////////////////////////////////////////////////////////////////

    //绑定删除节点的事件
    var del=$("#del");
    del.unbind();
    del.click(function(){


        rMenu.hide();
        //判断是否有子节点
        if(!treeNode.children){

            //获得ztree树对象
            var treeObj = $.fn.zTree.getZTreeObj("kynamicTree");
            var params="ktid="+treeNode.ktid;
            //发送ajax请求
            $.post("ktreeAction_delKtree.action",
                params,function(){
                    //更新客户端的ztree树结构
                    treeObj.removeNode(treeNode);
                });
        }

    });


}


///////////////////////////////////////////////////////////////////////
/*
 * ztree单机事件回调函数
 * */
function zTreeOnClick(event, treeId, treeNode){



    //获得标题文本框对象
    var title=$("#title");
    //获得内容文本域对象
    //var content=$("#content");


    title.val("");
    //content.val("");
    CKEDITOR.instances.content.setData("");//清空内容

    //获得ktid
    var ktid=treeNode.ktid;
    $("#ktid").val(ktid);
    window.alert(treeNode.ktpid);

    //////code.......
    loadVersionList(ktid);

}

/*加载知识版本列表*/
function loadVersionList(ktid){

    var div1=$("#MainArea"); //新增版本的UI
    var div2=$("#MainArea1"); //版本列表的UI

    $.post("kversAction_loadKversion.action",
        "ktid="+ktid,function(data){
            if(data.length==0){
                //显示新增版本的UI
                div1.show();
                div2.hide();
            }else{
                //显示版本列表的UI
                div2.show();
                div1.hide();

                //获得显示版本列表的表格对象
                var table = $("#vtab");
                table.html("");
                //遍历响应回来的json数组
                $(data).each(function(index,item){

                    var tr="<tr>";
                    tr=tr+"<td height='26' align='center' valign='middle' bgcolor='#FFFFFF' " +
                        "style='border-bottom:1px solid #f3f8fd;'>"+
                        "<a href='javascript:loadKversion("+item.kvid+")'>"+
                        item.vernum+"</a></td>";

                    tr=tr+" <td align='center' valign='middle' bgcolor='#FFFFFF' " +
                        "style='border-bottom:1px solid #f3f8fd;'>"+item.verdate+"</td>";

                    tr=tr+"<td align='center' valign='middle' bgcolor='#FFFFFF' " +
                        "style='border-bottom:1px solid #f3f8fd;'>" +
                        "<a href='javascript:delKversion( "+item.kvid+" )' >删除</a>"+
                        "</td>";
                    tr=tr+"</tr>";

                    table.append(tr);


                });
            }
        });

}
//////////////////////////////////////////////////////////////////////

/*
 * 加载某个版本信息
 * */
function loadKversion(kvid){

    //发送ajax请求
    $.post("kversAction_loadKnowLedgeVersion.action"
        ,"kvid="+kvid,function(data){

            var div1=$("#MainArea"); //新增版本的UI
            var div2=$("#MainArea1"); //版本列表的UI

            div2.hide();
            div1.show();

            //获得标题文本框对象
            var title=$("#title");
            //获得内容文本域对象
            //var content=$("#content");

            title.val(data[0].title);
            //content.val(data[0].content);
            //CKEDITOR回显数据
            CKEDITOR.instances.content.setData(data[0].content);


        });
}

///////////////////////////////////////////////////////////////////

/*
 * 发送版本更新的请求
 * */
function updateVersion(){
    var title=$("#title").val();
    var content=CKEDITOR.instances.content.getData();
    var ktid=$("#ktid").val();
    window.alert(ktid);


    var params="title="+title+"&content="+content+"&ktid="+ktid;
    $.post("kversAction_saveKversion.action",params,function(){
        /*加载知识版本列表*/
        loadVersionList(ktid);

    });
    var title=$("#title");
    //获得内容文本域对象
    //var content=$("#content");


    title.val("");
    //content.val("");
    CKEDITOR.instances.content.setData("");//清空内容
}

function delKversion(kvid) {

    var params="kvid="+kvid;
    var ktid=$("#ktid").val();
    //window.alert(ktid);
    $.post("kversAction_delKversion.action",params,function () {
        loadVersionList(ktid);
        //获得标题文本框对象
        var title=$("#title");
        //获得内容文本域对象
        //var content=$("#content");


        title.val("");
        //content.val("");
        CKEDITOR.instances.content.setData("");//清空内容
    })
}
function addKversion() {
    var div1=$("#MainArea"); //新增版本的UI
    div1.show();
}










