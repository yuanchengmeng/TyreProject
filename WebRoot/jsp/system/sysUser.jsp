<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ page isELIgnored="false" %>
<head>

<title>用户管理</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function back() {
		var page = document.getElementById("page").value;
		 var queryname=document.getElementById("queryname").value;
		location.href = "/TyreProject/system/findSysUser?page="+page+"&&queryname="+queryname;
	}
</script>
</head>

<body>
		<input type="hidden" value="${page}" id="page" />
		<input type="hidden" value="${queryname}" id="queryname" />
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig">位置：用户详情</td>
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
																	<td width="20%">姓名</td>
																	<td colspan="3">
																	${sysUser.emp.ename}
																	</td>
																</tr>
																<tr class="query_two">
 																	<td>部门</td>
																	<td colspan="3">
																	${sysUser.emp.dept.deptname}
																	</td>
																</tr>  
																<tr class="query_one">
																	<td width="20%">用户名</td>
																	<td colspan="3">
																	${sysUser.name}
																	</td>
																</tr>
																<tr class="query_two">
 																	<td>密码</td>
																	<td colspan="3">
																	${sysUser.password}
																	</td>
																</tr>
 																<tr class="query_one">
																	<td>用户角色</td>
																	<td colspan="3">
																	${sysUser.sysRole.name}
																	</td>
 																</tr>
 																<tr class="query_two">
																	<td>k3用户</td>
																	<td colspan="3">
																	${sysUser.k3User.FName}
																	</td>
 																</tr>
																<tr>
																	<td colspan="4" class="td_page_right"><input
																		onclick="back();" type="button" value="返回"
																		class="input_submit"></td>
																</tr>
														</table></td>
												</tr>
											</table>
										</td>
									</tr>
								</table></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
</body>

