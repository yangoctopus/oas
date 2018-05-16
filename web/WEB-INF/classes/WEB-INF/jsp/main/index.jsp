<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>OA系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<frameset rows="100,*,25" framespacing="0" border="0" frameborder="0">
    <frame src="mainAction_loadTop.action" name="TopMenu"  scrolling="no" noresize />
    <frameset cols="180,*" id="resize">
        <frame noresize name="menu" src="mainAction_loadLeft.action" scrolling="yes" />
        <frame noresize name="right" src="mainAction_loadRight.action" scrolling="yes" />
    </frameset>
    <frame noresize name="status_bar" scrolling="no" src="mainAction_loadBottom.action" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
