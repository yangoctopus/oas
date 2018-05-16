<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<script src="jquery/jquery-3.3.1.min.js" type="application/javascript" charset="utf-8"></script>
<script src="layui/layui.js" type="application/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" />


<body>

  
<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${ctx}/style/images/title_arrow.gif"/> 添加部门
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
    <s:form action="" id="frm" method="post" theme="simple">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${ctx}/style/blue/images/item_point.gif" /> 岗位信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td width="100">部门名称</td>
                        <td>
                        	 
                        	<s:textfield name="dname" cssClass="InputStyle"></s:textfield>
                         *</td>
                    </tr>
                    <tr>
                        <td>部门说明</td>
                        <td>
             
                        <s:textarea name="ddesc" cssClass="TextareaStyle"></s:textarea>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${ctx}/style/images/save.png" onclick="save()" />
            <a href="javascript:canel();"><img src="${ctx}/style/images/goBack.png"/></a>
        </div>
    </s:form>
</div>

</body>
<script>
    function save(){
        $.ajax({
            url:'deptAction_addDept.action',
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
</script>
</html>