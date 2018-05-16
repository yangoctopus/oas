/*
 * 
 * 通过privilege.jsp页面的加载事件，向服务器发送请求
 * 
 */
var settings={
		
		data:{
			simpleData:{
				enable:true,  //ztree提供数据的json为简单json
				idKey:"mid",
				pIdKey:"pid"
			},
			key:{
				
				name:"mname"
			} 
		},
		check:{
			
			enable:true
		}
		
};
$(function() {

    $.post("menusAction_loadMenus.action", function (data) {
        //window.alert(data)
        //显示ztree
        $.fn.zTree.init($("#privilegeTree"), settings, data);

        //发送二次ajax请求，加载某个角色的资源
        var pid = $("#pid").val();
        //window.alert(pid);

        $.post("postAction_loadPostMenus.action", "pid=" + pid, function (data) {
           // window.alert(data);
            //获得整棵树对象
            var treeObj = $.fn.zTree.getZTreeObj("privilegeTree");

            $(data).each(function (index, item) {
                var mid = item[0].mid; //获得需要回显树节点对应的id
                //获得需要选中的节点对象
                //window.alert(item[0].mid)
                var node = treeObj.getNodesByParam("mid", mid, null)[0];
                /*if(node.isParent){
                    treeObj.expandNode(node,true,false);
                };*/
                treeObj.checkNode(node, true, false);

            });
        });
    });
});


/*
提交授权的请求
*/
function grantPrivilege(){
	//获得需要提交的角色的id
	var pid=$("#pid").val();
	
	var pmids=pid+",";
	//1,2,3,5 
	//获得被选中的资源的id
	var treeObj = $.fn.zTree.getZTreeObj("privilegeTree");
	var nodes = treeObj.getCheckedNodes(true);
	//遍历nodes节点
	for(var x=0;x<nodes.length;x++){
		if(x==nodes.legnth-1){
			pmids=pmids+nodes[x].mid;
		}else{
			pmids=pmids+nodes[x].mid+",";
		}
	}
	
	//发送ajax请求
	$.post("postAction_postGrant.action","pmids="+pmids,function(result){
		 if (result=="error"){
        	 alert("------------授权异常------------");
         }
		 window.close(); 
		 alert("-------------x");
	});
}

