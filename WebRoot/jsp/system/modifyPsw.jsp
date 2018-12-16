<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ page isELIgnored="false"%>
<head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<title>用户管理</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />

</head>

<body>
	<s:form id="" action="editSysUser" namespace="/system" theme="simple">
	  <s:hidden name="flag" value="1" required="true" />
 		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig">&nbsp; 位置：修改密码</td>
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
																<td width="20%">工号</td>
																<td colspan="3">
															      <s:hidden name="sysUser.id"  required="true" />
 															      <input type="text" disabled="disabled" value="${sysUser.jobNo}">
															</tr>
															<tr class="query_one">
																<td width="20%">姓名</td>
																<td colspan="3">
																        <s:hidden name="sysUser.name"  required="true" />
																		<input type="text" disabled="disabled" value="${sysUser.name}"></td>
															</tr>
															<tr class="query_two">
 																<td>密码</td>
																<td colspan="3"><s:password name="sysUser.password"
																		showPassword="true" id="password" required="true" />
																</td>
															</tr>
															<tr class="query_one">
																<td>用户角色</td>
																<td colspan="3"> 
																		<s:hidden name="sysUser.sysRole.id"  required="true" />
															      <input type="text" disabled="disabled" value="${sysUser.sysRole.name}">
																		
																		</td>
															</tr>
															<tr>
																<td colspan="4" class="td_page_right"> 
																		 <s:submit method="modifySysUser" value="保存"
																			cssClass="input_submit"></s:submit>
																	  <input onclick="javascript:history.go(-1);" type="button" value="返回"
																	class="input_ok">
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
				</td>
			</tr>
		</table>
	</s:form>
</body>

