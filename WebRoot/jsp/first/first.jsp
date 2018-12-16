<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta name="menu" content="RoleMenu">
<link rel="Stylesheet" href="<%=path%>/jsp/css/listtable.css"
	type="text/css">
<link rel="stylesheet" href="<%=path%>/jsp/css/style.css"
	type="text/css">
<script type="text/javascript" src="<%=path%>/jsp/js/validate.js"></script>
<script type="text/jscript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
</script>
<style type="text/css">
#second {
	position: absolute;
	right: 50px;
	top: 14px;
	z-index: 1;
}
</style>
</head>

<body bgcolor="#f2f2f2">

<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img alt="" src="<%=path%>/jsp/images/first.jpg">
</body>
</html>