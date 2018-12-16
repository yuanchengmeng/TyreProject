<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ page isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>仓储管理系统</title>
    <link rel="shortcut icon" href="<%=path %>/jsp/images/favicon.ico"/>
  </head>
  <frameset rows="95,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="/TyreProject/jsp/first/top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="198,*" frameborder="no" border="0" framespacing="0">
    <frame src="/TyreProject/system/getSysMenu" name="leftFrame" scrolling="yes" noresize="noresize" id="leftFrame" title="leftFrame" />
  <frame src="/TyreProject/jsp/first/first.jsp" name="mainFrame" id="mainFrame" title="mainFrame" />
  </frameset>
  
</frameset>
</html>

