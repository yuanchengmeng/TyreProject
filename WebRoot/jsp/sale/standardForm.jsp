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
   function validate() {
		var nameID = document.getElementById("nID").value;
		var codeID = document.getElementById("cID").value;
		var treadID = document.getElementById("tID").value;
		var speedID = document.getElementById("sID").value;
		if (nameID == "" || codeID == ""|| speedID == ""|| treadID == "") {
			alert("都不能为空!!");
		} else {
		      document.forms[0].submit();
		}
	}
	function back() {
		history.go(-1);
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
	<s:form action="addStandard" namespace="/sale" theme="simple">
		<s:hidden name="nameId" id="nameId" value="%{nameId}"></s:hidden>
		<s:hidden name="pageNo" id="pageNo" value="%{pageNo}"></s:hidden>
		<s:hidden name="pageSize" id="pageSize" value="%{pageSize}"></s:hidden>
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig"><br>位置：新增规格</td>
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
																<td width="20%">规格名称</td>
																<td colspan="3"><s:textfield name="standard.name" id="nID"/></td>
															</tr>
															<tr class="query_two">
																<td width="20%">速度级别</td>
																<td colspan="3"><s:textfield name="standard.speed" id="sID"/></td>
															</tr>
															<tr class="query_one">
																<td width="20%">花纹</td>
																<td colspan="3"><s:textfield name="standard.tread" id="tID"/></td>
															</tr>
															<tr class="query_two">
																<td width="20%">规格代码</td>
																<td colspan="3"><s:textfield name="standard.code" id="cID"/></td>
															</tr>
															<tr>
																<td colspan="4" class="td_page_right"><input
																	type="button" value="保存" onclick="validate();" class="input_submit">
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

