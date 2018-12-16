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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(/TyreProject/jsp/images/left1.jpg);
}
-->
</style>
<link href="<%=path%>/jsp/css/css.css" rel="stylesheet" type="text/css" />
</head>
<script language="javascript" src="<%=path%>/jsp/js/myproject.js"></script>
<body>
	<table width="198" border="0" cellpadding="0" cellspacing="0"
		class="left-table01">
		<tr>
			<TD>
				<s:iterator var="parentList" value="parentMenuList">
				<s:iterator var="menuList" value="sysMenuList">
					<s:if test="#parentList.getId()==#menuList.getId()">
						<TABLE width="100%" border="0" cellpadding="0" cellspacing="0"
							class="left-table03">
							<tr>
								<td height="29">
									<table width="85%" border="0" align="center" cellpadding="0"
										cellspacing="0">
										<tr>
											<td width="8%"><img
												name="img<s:property value='#menuList.getId()'/>" id="img1"
												src="<%=path%>/jsp/images/ico04.gif" width="8" height="11" />
											</td>
											<td width="92%"><a href="javascript:" target="mainFrame"
												class="left-font03"
												onClick="list('<s:property value="#menuList.getId()" />');"><s:property
														value="#menuList.getName()" /> </a>
											</td>
										</tr>
									</table></td>
							</tr>
						</TABLE>
						<table id="subtree<s:property value='#menuList.getId()'/>"
							style="DISPLAY: none" width="80%" border="0" align="center"
							cellpadding="0" cellspacing="0" class="left-table02">

							<s:iterator var="menuList1" value="sysMenuList">
								<s:if test="#menuList.getId()==#menuList1.getParent_menu_id()">
									<tr>
										<td width="9%" height="20"><img
											id="xiaotu<s:property value='#menuList1.getId()'/>"
											src="<%=path%>/jsp/images/ico06.gif" width="8" height="12" />
										</td>
										<td width="91%"><a
											href="<s:property value='#menuList1.getPage_url()'/>"
											class="left-font03"
											onClick="tupian('<s:property value='#menuList1.getId()'/>');"
											target="mainFrame"><s:property
													value="#menuList1.getName()" /> </a></td>
									</tr>
								</s:if>
							</s:iterator>

						</table>
					</s:if>	 
				</s:iterator>
				</s:iterator></TD>
		</tr>
	</table>
</body>
</html>
