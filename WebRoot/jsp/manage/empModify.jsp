<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ page isELIgnored="false"%>
<head>

<title></title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function back() {
		var pageSize = document.getElementById("pageSize").value;
		var nameId = document.getElementById("nameId").value;
		var pageNo = document.getElementById("pageNo").value;
		location.href = "/TyreProject/manage/queryEmp?pageSize=" + pageSize
				+ "&&pageNo=" + pageNo + "&&nameId=" + nameId;
	}
</script>
</head>

<body>
	<s:form action="modifyEmp" namespace="/manage" theme="simple">
		<s:hidden name="nameId" id="nameId" value="%{nameId}"></s:hidden>
		<s:hidden name="pageSize" id="pageSize" value="%{pageSize}"></s:hidden>
		<s:hidden name="pageNo" id="pageNo" value="%{pageNo}"></s:hidden>
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig">位置：修改员工相关记录</td>
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
																<td width="20%">员工名</td>
																<td colspan="3"><input type="hidden" name="emp.id"
																	value="${ emp.id}" /> <input type="text"
																	name="emp.ename" value="${emp.ename}" /></td>
															</tr>
															<tr class="query_two">
																<td>部门</td>
																<td colspan="3"><s:select name="emp.dept.id" id="deptId" required="true"
																		list="deptList" listKey="id" listValue="deptname" headerKey="0" headerValue="请选择"></s:select></td>
															</tr>
															<tr class="query_one">
																<td>性别</td>
																<td colspan="3"><input type="text" id="sex"
																	name="emp.sex" value="${emp.sex}">
																</td>
															</tr>
															<tr class="query_two">
																<td>职位</td>
																<td colspan="3"><s:select name="emp.job.id" id="jobId" required="true"
																		list="jobList" listKey="id" listValue="position" headerKey="0" headerValue="请选择"></s:select>
																</td>
															</tr>
															<tr>
																<td colspan="4" class="td_page_right"><input
																	type="submit" value="提交" class="input_submit">
																	<input onclick="back();" type="button" value="返回"
																	class="input_ok"></td>
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

