<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ page isELIgnored="false"%>
<head>

<title>菜单管理</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function back() {
		var sysMenuname=document.getElementById("sysMenuname").value;
		var page = document.getElementById("page").value;
		var pageSize = document.getElementById("pageSize").value;
		location.href = "/TyreProject/system/findSysMenu?page=" + page
				+ "&&pageSize=" + pageSize+"&&sysMenuname="+sysMenuname;
	}
</script>
</head>

<body>
		 <input type="hidden" value="${page}" id="page" /> <input
			type="hidden" value="${sysMenuname}" id="sysMenuname" /> <input
			type="hidden" value="${pageSize}" id="pageSize" />
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig">位置：菜单详情</td>
						</tr>
					</table>
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="table_blue">
						<tr align="center" valign="top">
							<td>
								<table width="100%" cellpadding="10" cellspacing="0">
									<tr>
										<td align="center">
											<table width="100%" border="0" cellpadding="0"
												cellspacing="0" bgcolor="#FFFFFF" class="table_blue">
												<tr>
													<td>
														<table width="100%" border="0" cellpadding="0"
															cellspacing="1">

															<tr class="query_one">
																<td width="20%">菜单名称</td>
																<td colspan="3">${sysMenu.name}</td>
															</tr>
															<tr class="query_two">

																<td>地址</td>
																<td colspan="3">${sysMenu.page_url}</td>
															</tr>

															<tr class="query_one">
																<td>父菜单</td>
																<td colspan="3">${sysMenu.parent_menu_id}</td>

															</tr>

															<tr class="query_two">
																<td>标识</td>
																<td colspan="3">${sysMenu.flag}</td>

															</tr>
															<tr>
																<td colspan="4" class="td_page_right"><input
																	onclick="back();" type="button" value="返回"
																	class="input_submit">
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table></td>
									</tr>
								</table>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
</body>

