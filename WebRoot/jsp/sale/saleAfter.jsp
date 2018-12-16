<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function back() {
		history.go(-1);
	}
</script>
</head>
<body>
	${success}
	<s:hidden name="nameId" id="nameId" value="%{nameId}"></s:hidden>
	<s:hidden name="pageNo" id="pageNo" value="%{pageNo}"></s:hidden>
	<s:hidden name="pageSize" id="pageSize" value="%{pageSize}"></s:hidden>
	<table width="100%" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td valign="top">
				<table border="0" cellpadding="0" cellspacing="0"
					class="cTableBorder">
					<tr>
						<td align="left" class="navig">位置：售后信息详情</td>
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
														<s:iterator value="#request.saleAfter" var="saleAfter">
															<tr class="query_one">
																<td width="20%">理赔客户</td>
																<td colspan="3">${saleAfter.lperson}</td>
															</tr>
															<tr class="query_two">
																<td>轮胎条码</td>
																<td colspan="3">${saleAfter.barcode}</td>
															</tr>
															<tr class="query_one">
																<td width="20%">轮胎规格</td>
																<td colspan="3">${saleAfter.product}</td>
															</tr>
															<tr class="query_two">
																<td>病象</td>
																<td colspan="3">${saleAfter.reason}</td>
															</tr>
															<tr class="query_one">
																<td width="20%">理赔率</td>
																<td colspan="3">${saleAfter.rate}</td>
															</tr>
															<tr class="query_two">
																<td width="20%">状态</td>
																<td colspan="3">${saleAfter.statusAfter.name}</td>
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

