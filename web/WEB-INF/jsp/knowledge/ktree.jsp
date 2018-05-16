<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>

<!-- 导入ztree的资源 -->
<link type="text/css" rel="stylesheet" href="${ctx}/ztree/css/zTreeStyle/zTreeStyle.css"/>

<script type="text/javascript" src="${ctx}/ztree/js/jquery.ztree.all.js"></script>
<script type="text/javascript" src="${ctx}/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${ctx}/js/ktree.js"></script>



<body>

<DIV ID="Title_bar">
    <DIV ID="Title_bar_Head">
        <DIV ID="Title_Head"></DIV>
        <DIV ID="Title"><!--页面标题-->
            <IMG BORDER="0" WIDTH="13" HEIGHT="13" SRC="../style/images/title_arrow.gif"/> 知识管理
        </DIV>
        <DIV ID="Title_End"></DIV>
    </DIV>
</DIV>

<!--当前路径-->
<DIV ID="QueryArea">
	<DIV ID="FilePath">
		<DIV CLASS="PathTitle">
			当前路径:
		</DIV>
	</DIV>
</DIV>

<!--目录列表-->
<DIV ID="dirListArea" STYLE="width: 260px; float: left;">
	<DIV STYLE="margin-left: 15px;">
		<!--显示文件夹树-->
		<div ID="kynamicTree" class="ztree">
		</div>
	</DIV>
</DIV>
<input type="hidden" value="" name="ktree.ktid" id="ktid"/>
<!--目录内容显示-->
<DIV ID="MainArea" STYLE="margin-left: 3px; width: 700px; float: left;display: none" border="3">
	<table width="700" border="0" cellspacing="0" cellpadding="0" 
	style="border:1px solid #91C0E3;">
  <tr>
    <td width="94" height="40" align="center" valign="middle" bgcolor="#F0F7FD" style="color: #069;"><strong>标题</strong></td>
    <td width="540" bgcolor="#F0F7FD"><input name="title" id="title" type="text" style="background-color: #FFFFFF;
    border: 1px solid #91C0E3;
    color: #004779;width:250px;" /></td>
  </tr>
  <tr>
    <td height="53" align="center" valign="middle" bgcolor="#F0F7FD" style="color:#069;"><strong>内容</strong></td>
    <td bgcolor="#F0F7FD"><textarea  name="content" id="content" cols="" rows="" style="background-color: #FFFFFF;
    border: 1px solid #91C0E3;
    color: #004779;width:250px;height:auto;" >

    </textarea>
        <script type="text/javascript">
            CKEDITOR.replace('content');
        </script>
    </td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#F0F7FD" height="50"><table width="199" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="100"><input name="" type="button" value="check in" style="background: #D3EDFC;border:1px solid  #91C0E3; cursor:pointer;" onclick="updateVersion()"/></td>
        <td width="99"><input name="" type="button" value="check out" style="background: #D3EDFC;border:1px solid  #91C0E3; cursor:pointer;"/></td>
      </tr>
    </table></td>
    </tr>
</table>
</DIV>

<!--目录内容列表显示-->
<DIV ID="MainArea1" STYLE="margin-left: 3px; width: 700px; float: left; display:none;" border="2">
	 <table width="700" height="57" border="0" cellpadding="0" cellspacing="0" style="font-size:12px;">
  <tr>
    <td height="30"><table width="700" height="26" border="0" cellpadding="0" cellspacing="0" style="background: url(../style/images/411.jpg) repeat-x;">
      <tr>
        <td align="center" valign="middle" style="border:1px solid #CBE3ED;border-right:none;">版本号</td>
        <td align="center" valign="middle" style="border:1px solid #CBE3ED;">修改时间</td>
        <td align="center" valign="middle" style="border:1px solid #CBE3ED;border-left:none;">相关操作</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>
    
    <table width="700" border="0" cellspacing="0" cellpadding="0" id="vtab">
   
  
 
	</table>
</td>
  </tr>
         <tr>
             <td>
             <div id="TableTail">
                 <div id="TableTail_inside">
                     <a href="javascript:addKversion()"><img src="${ctx}/style/images/createNew.png" /></a>
                 </div>
             </div>
             </td>
         </tr>
</table>
</DIV>
<div class="addnodes" id="rMenu" style="position:absolute;display:none;">
       <ul>
         <li style="background: url(../style/images/jia.jpg) 10px 5px no-repeat;
         	border-bottom:1px solid #8ab2e6;cursor: pointer;" id="add">增加节点</li>
         <li style="background: url(../style/images/jian.jpg)
			10px 9px no-repeat;cursor: pointer;" id="del">
         	删除节点</li>
       </ul>
 </div>

      
</body>
</html>