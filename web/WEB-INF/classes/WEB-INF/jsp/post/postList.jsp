<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<script type="text/javascript" src="${ctx}/js/privilege.js"></script>
<script type="text/javascript" src="js/post.js"></script>
<script src="jquery/jquery-3.3.1.min.js" type="application/javascript" charset="utf-8"></script>
<script src="layui/layui.js" type="application/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" />
<body>

 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${ctx}/style/images/title_arrow.gif"/> 岗位管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="300px">岗位名称</td>
                <td width="500px">岗位说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="roleList">
			<s:iterator value="#request.pvoList" var="post">
			
				<tr class="TableDetail1 template">
					<td>${post.pname}&nbsp;</td>
					<td>${post.pdesc}&nbsp;</td>
					<td>
					<a onClick="return delConfirm()" href="postAction_delPost.action?pid=${post.pid}">删除</a>
						<a href="javascript:updatePost(${post.pid})">修改</a>
						<a href="javascript:openPrivielege(${post.pid})">授权</a>

					</td>
				</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="javascript:addPost()"><img src="${ctx}/style/images/createNew.png" /></a>
        </div>
    </div>
</div>
</body>
</html>