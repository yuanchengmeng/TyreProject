<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ page isELIgnored="false"%>
<head>
<title>母胶使用记录</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
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
	<s:form action="addSaleAfter" namespace="/sale" theme="simple">
		<s:hidden name="nameId" id="nameId" value="%{nameId}"></s:hidden>
		<s:hidden name="pageNo" id="pageNo" value="%{pageNo}"></s:hidden>
		<s:hidden name="pageSize" id="pageSize" value="%{pageSize}"></s:hidden>
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig"><br>位置：添加售后信息</td>
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
																<td width="20%">备注<s:hidden name="saleAfter.statusAfter.id" value="1"/></td>
																<td colspan="3"><s:textarea rows="3" cols="22" name="saleAfter.remark"/></td>
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

