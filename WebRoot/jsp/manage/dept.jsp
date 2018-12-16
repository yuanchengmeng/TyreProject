<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ page isELIgnored="false"%>
<head>

<title>部门</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function back() {
		var nameId = document.getElementById("nameId").value;
		var pageSize = document.getElementById("pageSize").value;
		var pageNo = document.getElementById("pageNo").value;
		location.href = "/TyreProject/manage/queryDept?pageSize=" + pageSize
				+ "&&pageNo=" + pageNo + "&&nameId=" + nameId;
	}
</script>
</head>

<body>
${success }
	<s:hidden name="pageNo" id="pageNo" value="%{pageNo}"></s:hidden>
	<s:hidden name="pageSize" id="pageSize" value="%{pageSize}"></s:hidden>
	<s:hidden name="nameId" id="nameId" value="%{nameId}"></s:hidden>
	<table width="100%" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td valign="top">
				<table border="0" cellpadding="0" cellspacing="0"
					class="cTableBorder">
					<tr>
						<td align="left" class="navig">位置：部门详情</td>
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
														<tr class="query_one">
															<td width="20%">部门名称</td>
															<td colspan="3">${dept.deptname}</td>
														</tr>
														<tr class="query_one">
															<td width="20%">部门负责人</td>
															<td colspan="3">${dept.deptleader}</td>
														</tr>
														<tr class="query_two">
															<td width="20%">分管部门领导</td>
															<td colspan="3">${dept.boss.ename}</td>
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

