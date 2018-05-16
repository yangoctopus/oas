<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<script type="application/javascript" src="${ctx}/js/user.js"></script>
<body>
 
<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${ctx}/style/images/title_arrow.gif"/> 用户信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="" id="frm2" method="post" theme="simple">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${ctx}/style/blue/images/item_point.gif" /> 用户信息 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td width="100">所属部门</td>
                        <td>
                        	<s:select cssClass="SelectStyle"
                             name="dept.did" list="#request.dlist" listKey="did"
                             listValue="dname"
                             headerKey="-1" headerValue="--请选择--"
                             ></s:select>
                           
                        </td>
                    </tr>
                    <tr><td>登录名</td>
                        <td>
                            <s:textfield name="uid" cssClass="InputStyle" style="display:none"></s:textfield>
							<s:textfield name="username" cssClass="InputStyle"></s:textfield>
							*（登录名要唯一）
						</td>
                    </tr>
					<tr><td>性别</td>
                        <td>
                        
                        	<s:radio list="#{'男':'男','女':'女' }" name="sex"></s:radio>
                        	 
						</td>
                    </tr>
					<tr><td>联系电话</td>
                        <td>
                        <s:textfield name="phone" cssClass="InputStyle"></s:textfield>
                       </td>
                    	
                    </tr>
                    <tr><td>E-mail</td>
                        <td> <s:textfield name="email" cssClass="InputStyle"></s:textfield></td>
                    </tr>
                </table>
            </div>
        </div>
        
		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${ctx}/style/blue/images/item_point.gif" /> 岗位设置 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
						<td width="100">岗位</td>
                        <td>
                            <!-- 
                            	list：下拉列表框的所有选项集合
                            	listKey：下拉列表框选项的value
                            	listValue：下拉列表框选项的option标签中间的内容
                            	
                             -->
                            <s:select list="#request.plist" listKey="pid" listValue="pname"
                            name="pid" cssClass="SelectStyle"  multiple="true" size="10"></s:select>
                            按住Ctrl键可以多选或取消选择
                        </td>
                    </tr>
                </table>
            </div>
        </div>		
		
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${ctx}/style/images/save.png" onclick="saveUpdate()"/>
            <a href="javascript:canel();"><img src="${ctx}/style/images/goBack.png"/></a>
        </div>
    </s:form>
</div>

<div class="Description">
	说明：<br />
	1，用户的登录名要唯一，在填写时要同时检测是否可用。<br />
	2，新建用户后，密码被初始化为"1234"。<br />
	3，密码在数据库中存储的是MD5摘要（不是存储明文密码）。<br />
	4，用户登录系统后可以使用“个人设置→修改密码”功能修改密码。<br />
	5，新建用户后，会自动指定默认的头像。用户可以使用“个人设置→个人信息”功能修改自已的头像<br />
	6，修改用户信息时，登录名不可修改。
</div>
 
</body>
</html>