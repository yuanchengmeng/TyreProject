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
	  var nameId=document.getElementById("nameId").value;
	  var pageSize=document.getElementById("pageSize").value;
      var pageNo=document.getElementById("pageNo").value;
		location.href = "/TyreProject/manage/queryDept?pageSize="+pageSize+"&&pageNo="+pageNo+"&&nameId="+nameId;
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
	<s:form id="" name="" action="addDept" namespace="/manage"
		theme="simple">
		<s:hidden name="pageNo" id="pageNo" value="%{pageNo}"></s:hidden>
		<s:hidden name="pageSize" id="pageSize" value="%{pageSize}"></s:hidden>
		<s:hidden name="nameId" id="nameId" value="%{nameId}"></s:hidden>
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig"><br>位置：添加部门记录</td>
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
																<td width="20%">部门名称</td>
																<td colspan="3"><input type="text" id="deptname"
																	name="dept.deptname"></td>
															</tr>
                                                            <tr class="query_one">
																<td>部门负责人</td>
																<td colspan="3"><input type="text" id="deptleader"
																	name="dept.deptleader">
																</td>
															</tr>
															<tr class="query_one">
																<td>分管部门领导</td>
																<td colspan="3"><s:select name="dept.boss.id" id="empId" required="true"
																		list="empList" listKey="id" listValue="ename" headerKey="" headerValue=""></s:select>
																</td>
															</tr>
															<tr>
																<td colspan="4" class="td_page_right"><input
																	type="submit" value="保存" class="input_submit">
																	<input onclick="back();" type="button" value="返回"
																	class="input_ok"></td>
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
	</s:form>
</body>

