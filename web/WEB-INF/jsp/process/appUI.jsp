<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<body>
 
<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${ctx}/style/images/title_arrow.gif"/> 发起审批
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="leaveAction_saveLeave.action" method="post" theme="simple">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${ctx}/style/blue/images/item_point.gif" /> 流程选择 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
				   	  
                    <tr>
                        <td>所用流程</td>
                        <td>
                        
                         <s:select list="#request.plist"  name="pdid"
                         listKey="id" listValue="key"
                         headerKey="-1" headerValue="--请选择--"
                         ></s:select> *
						</td>
                    </tr>
                </table>
            </div>
        </div>
		
		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${ctx}/style/blue/images/item_point.gif" /> 流程数据 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
               
	               	 <table cellpadding="0" cellspacing="0" class="mainForm">
	               	 	<tr>
	                        <td width="120px;">选择审批人</td>
	                        <td>
	                        	<input type="checkbox" name="apper" value="习近平"
	                        	class="InputStyle"/>习近平

	                        	<input type="checkbox" name="apper" value="李克强"
	                        	class="InputStyle" />李克强

	                        	<input type="checkbox" name="apper" value="张德江"
	                        	class="InputStyle" />张德江 </td>
	                        	
	                    </tr>
					   	<tr>
	                        <td width="120px;">开始日期</td>
	                        <td><input type="text" name="start" class="InputStyle" style="width:450px;" /> </td>
	                    </tr>
	                     <tr>
	                        <td width="120px;">结束日期</td>
	                        <td><input type="text" name="end" class="InputStyle" style="width:450px;" /> </td>
	                    </tr>
	                    <tr>
	                        <td width="120px;">请假原因</td>
	                        <td><input type="text" name="desces" class="InputStyle" style="width:450px;" /> </td>
	                    </tr>
	                    <tr>
	                        
	                        
	                    </tr>
	               	</table>
            
            </div>
        </div>
         
        
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${ctx}/style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="${ctx}/style/images/goBack.png"/></a>
        </div>
    </s:form>
</div>

<div class="Description">
	说明：<br />
	1，模板文件是doc扩展名的文件（Word文档）。<br />
	2，如果是添加：必须要选择模板文件。<br />
	3，如果是修改：只是在 需要更新模板文件时 才选择一个文件。
</div>
  
</body>
</html>