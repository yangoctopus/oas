<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<script src="jquery/jquery-3.3.1.min.js" type="application/javascript" charset="utf-8"></script>
<script src="layui/layui.js" type="application/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" />
<script type="text/javascript" src="js/dept.js"></script>
<body>

 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${ctx}/style/images/title_arrow.gif"/> 部门管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="300px">部门名称</td>
                <td width="500px">部门说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="roleList">
			<s:iterator value="#request.dvolist" var="dept">
			
				<tr class="TableDetail1 template">
					<td>${dept.dname}&nbsp;</td>
					<td>${dept.ddesc}&nbsp;</td>
					<td>
					<a href="deptAction_delDept.action?did=${dept.did}">删除</a>
						<a href="javascript:updateDept(${dept.did})">修改</a>

					</td>
				</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="javascript:addDept()"><img src="${ctx}/style/images/createNew.png" /></a>
        </div>
    </div>
</div>
</body>
</html>