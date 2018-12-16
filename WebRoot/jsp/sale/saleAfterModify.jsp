<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ page isELIgnored="false"%>
<head>

<title>终炼胶标识卡</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function back() {
		var pageSize = document.getElementById("pageSize").value;
		var nameId = document.getElementById("nameId").value;
		var pageNo = document.getElementById("pageNo").value;
		location.href = "/TyreProject/sale/querySaleAfter?pageSize=" + pageSize
				+ "&&pageNo=" + pageNo + "&&nameId=" + nameId;

	}
	function validate() {
		var password = document.getElementById("password").value;
		if (password == "") {
			alert("请填写完整的密码！！");
		} else {
			document.forms[0].submit();
		}
	}
</script>
</head>

<body>
	<s:form action="modifySaleAfter" namespace="/sale" theme="simple">
		<s:hidden name="nameId" id="nameId" value="%{nameId}"></s:hidden>
		<s:hidden name="pageSize" id="pageSize" value="%{pageSize}"></s:hidden>
		<s:hidden name="pageNo" id="pageNo" value="%{pageNo}"></s:hidden>
		<!-- <input type="hidden" name="saleAfter.flag" value="0"> -->
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig">位置：修改手持用户密码</td>
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
																<td width="20%">条码</td>
																<td colspan="3"><s:textfield id="name" name="saleAfter.barcode"/></td>
															</tr>
															<tr class="query_two">
																<td>轮胎规格</td>
																<td colspan="3"><s:textfield name="saleAfter.product" id="" />
																</td>
															</tr>
															<tr class="query_one">
																<td width="20%">销售客户</td>
																<td colspan="3"><s:textfield id="name" name="saleAfter.sperson"/></td>
															</tr>
															<tr class="query_two">
																<td>理赔客户</td>
																<td colspan="3"><s:textfield name="saleAfter.lperson" id="" />
																</td>
															</tr>
															<tr class="query_one">
																<td width="20%">病象</td>
																<td colspan="3"><s:textfield name="saleAfter.reason" id="" /></td>
															</tr>
															<tr class="query_two">
																<td>理赔率</td>
																<td colspan="3"><s:textfield name="saleAfter.rate" id="" />
																</td>
															</tr>
															<tr class="query_one">
																<td width="20%">备注</td>
																<td colspan="3"><textarea rows="3" cols="22" name=""></textarea></td>
															</tr>
															<tr>
																<td colspan="4" class="td_page_right"><input
																	type="submit" value="保存" class="input_submit">
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

