<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ page isELIgnored="false"%>
<head>
<title>员工</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function back() {
		var nameId = document.getElementById("nameId").value;
		var pageNo = document.getElementById("pageNo").value;
		var pageSize = document.getElementById("pageSize").value;
		location.href = "/TyreProject/manage/queryEmp?pageNo=" + pageNo
				+ "&&pageSize=" + pageSize + "&&nameId=" + nameId;
	}
	function validate() {
		var mpdate = document.getElementById("mpdate").value;
		var record = document.getElementById("record").value;
		var barcode = document.getElementById("barcode").value;
		if (mpdate == "" || record == "" || barcode == "") {
			alert("必选项不能为空！！");
		} else {
			document.forms[0].submit();
		}
	}
</script>
<style type="text/css">
font {
	font-size: 20px;
	font-family: '宋体 ';
	color: red;
}
</style>
</head>
<body>
	<s:form id="" name="" action="addEmp" namespace="/manage" theme="simple">
		<s:hidden name="nameId" id="nameId" value="%{nameId}"></s:hidden>
		<s:hidden name="pageNo" id="pageNo" value="%{pageNo}"></s:hidden>
		<s:hidden name="pageSize" id="pageSize" value="%{pageSize}"></s:hidden>
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig"><br>位置：添加新员工</td>
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
																<td width="20%">员工名称</td>
																<td colspan="3"><input type="text" id="name"
																	name="emp.ename">
																</td>
															</tr>
															<tr class="query_two">
																<td width="20%">部门</td>
																<td colspan="3"><select name="emp.dept.id">
																		<option value=0>请选择</option>
																		<s:iterator var="dept" value="deptList">
																			<option value=<s:property value="#dept.getId()"/>>
																				<s:property value="#dept.getDeptname()" />
																			</option>
																		</s:iterator>
																</select>
																</td>
															</tr>
															<tr class="query_two">
																<td>性别</td>
																<td colspan="3"><input type="text" id="sex"
																	name="emp.sex"></td>
															</tr>
															<tr class="query_one">
																<td>职位</td>
																<td colspan="3"> 
																	<s:select name="emp.job.id" id="jobId" required="true"
																		list="jobList" listKey="id" listValue="position" headerKey="0" headerValue="请选择"></s:select>
																	</td>
															</tr>
														    <tr>
																<td colspan="4" class="td_page_right"><input
																	type="submit" value="保存" class="input_submit">
																	<input onclick="back();" type="button" value="返回"
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

