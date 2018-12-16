<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>top.jsp</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/jsp/css/css.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/jsp/js/Clock.js" type=text/javascript></script>
<script type="text/javascript">
	
	function logout() {
		if (window.confirm('确认退出?')) {
			parent.location.href = "/TyreProject/system/removeSuccess";
		}
	}
</script>

</head>
<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="95" background="/TyreProject/jsp/images/top_bg.gif">
				<table width="99%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="60" colspan="6" style="padding-left:10px"><img src="/TyreProject/jsp/images/top_left.jpg" width="800" height="50" border="0" /></td>
 					</tr>
					<tr>	
						<td valign="center" height="35" width="196">
							<img src="/TyreProject/jsp/images/menu_top.gif" width="196" height="35" />
						</td>
						<td align="left"><span style="color:white;font-size:13px;padding-left:18px;" id="clock"></span></td>
						<td align="right" style="font-size:13px;color:white;padding-right:20px;">${u.name} | ${u.sysRole.name} </td>
						<td width="35px" align="center">
						</td>
						<td width="35px" align="center"><a href="/TyreProject/system/queryUser" title="修改密码" target="mainFrame"><img src="/TyreProject/jsp/images/psw.gif"
								alt="修改密码" border="0" /></a></td>
						<td width="35px" align="center"><a href="#" title="注销" onclick="logout();"> <img src="/TyreProject/jsp/images/logout.gif"
								alt="安全退出" border="0" /></a></td>
					</tr>		
				</table>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		var clock = new Clock();
		clock.display(document.getElementById("clock"));
	</script>
</body>
</html>
