<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>
<head>
<title>员工</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function back() {
		var pageSize = document.getElementById("pageSize").value;
		var pageNo = document.getElementById("pageNo").value;
		var nameId = document.getElementById("nameId").value;
		location.href = "/TyreProject/manage/queryEmp?pageNo=" + pageNo
				+ "&&pageSize=" + pageSize + "&&nameId=" + nameId;
	}
</script>
</head>
<body>
${success }
	<s:hidden name="nameId" id="nameId" value="%{nameId}"></s:hidden>
	<s:hidden name="pageNo" id="pageNo" value="%{pageNo}"></s:hidden>
	<s:hidden name="pageSize" id="pageSize" value="%{pageSize}"></s:hidden>
	<table width="100%" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td valign="top">
				<table border="0" cellpadding="0" cellspacing="0"
					class="cTableBorder">
					<tr>
						<td align="left" class="navig">位置：员工记录详情</td>
					</tr>
				</table>
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="table_blue">
					<tr align="center" valign="top">
						<td>
							<table width="100%" cellpadding="10" cellspacing="0">
								<tr>
									<td align="center">
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											bgcolor="#FFFFFF" class="table_blue">
											<tr>
												<td>
													<table width="100%" border="0" cellpadding="0"
														cellspacing="1">
														<s:iterator value="#request.emp" var="emp">
															<tr class="query_one">
																<td width="20%">员工名</td>
																<td colspan="3">${emp.ename}</td>
															</tr>
															<tr class="query_two">
																<td>部门</td>
																<td colspan="3">${emp.dept.deptname}</td>
															</tr>
															<tr class="query_two">
																<td>性别</td>
																<td colspan="3">${emp.sex}</td>
															</tr>
															<tr class="query_one">
																<td>职位</td>
																<td colspan="3">${emp.job.position}</td>
															</tr>
															<tr>
																<td colspan="4" class="td_page_right"><input
																	onclick="back();" type="button" value="返回"
																	class="input_submit"></td>
															</tr>
														</s:iterator>
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

