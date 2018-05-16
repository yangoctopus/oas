<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>

<!-- 导入ztree的资源 -->
<link type="text/css" rel="stylesheet" href="ztree/css/zTreeStyle/zTreeStyle.css"/>

<script type="text/javascript" src="ztree/js/jquery.ztree.all.js"></script>
<script type="text/javascript" src="js/grantPrivilege.js"></script>

<body>
	<input id="pid" value="${pid}" type="hidden"/>
	<div id="privilegeTree" class="ztree"></div>
  
  
  	
     <!-- 表单操作 -->
     <div id="InputDetailBar">
         <input type="image" src="${ctx}/style/images/save.png" onclick="grantPrivilege()"/>
         <a href="javascript:history.go(-1);">
         <img src="${ctx}/style/images/goBack.png"/></a>
     </div>

</body>
</html>