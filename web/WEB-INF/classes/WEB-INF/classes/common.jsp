<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 
	String path = request.getContextPath();
	request.setAttribute("ctx",path );
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${ctx}/style/blue/pageCommon.css" />
<script type="text/javascript" src="${ctx}/ztree/js/jquery-1.4.4.min.js"></script>
</head>

<!-- 该页面用来引入公共的静态资源 -->