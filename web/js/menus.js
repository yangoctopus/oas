/*
 * 页面的加载事件，发送异步请求
 */
//1 配置ztree树
var setting={

    data:{
        simpleData:{
            enable:true,  //ztree提供数据的json为简单json
            idKey:"mid",
            pIdKey:"pid"
        },
        key:{

            name:"mname"
        },
        check:{

            enable:true
        }
    }

};
//2发送异步请求
$(document).ready(function(){

    $.post("menusAction_loadMenus.action",function(data){
        //window.alert(data)

        //3 显示ztree
        $.fn.zTree.init($("#menuTree"),setting,data)
    });
});