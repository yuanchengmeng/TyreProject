<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>
<head>
<title></title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function back() {
		var dateId = document.getElementById("dateId").value;
		var productId = document.getElementById("productId").value;
		var BarcodeId = document.getElementById("BarcodeId").value;
		var pageNo = document.getElementById("pageNo").value;
		var pageSize = document.getElementById("pageSize").value;
		location.href = "/TyreProject/store/queryOutStore?pageNo=" + pageNo
				+ "&&pageSize=" + pageSize + "&&storeOut.product.id="
				+ productId + "&&storeOut.barcode=" + BarcodeId
				+ "&&storeOut.outDate=" + dateId;
	}
</script>
</head>
<body>
	${success }
	<s:hidden name="pageNo" id="pageNo" value="%{pageNo}"></s:hidden>
	<s:hidden name="pageSize" id="pageSize" value="%{pageSize}"></s:hidden>
	<s:hidden name="productId" id="productId" value="%{productId}"></s:hidden>
	<s:hidden name="BarcodeId" id="BarcodeId" value="%{BarcodeId}"></s:hidden>
	<s:hidden name="dateId" id="dateId" value="%{dateId}"></s:hidden>
	<table width="100%" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td valign="top">
				<table border="0" cellpadding="0" cellspacing="0"
					class="cTableBorder">
					<tr>
						<td align="left" class="navig">位置：出库轮胎订单详情</td>
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
														<tr class="query_two">
															<td width="20%">产品品牌</td>
															<td colspan="3">${storeOut.product.brand.name }</td>
														</tr>
														<tr class="query_one">
															<td width="20%">产品规格</td>
															<td colspan="3">${storeOut.product.standard.name }</td>
														</tr>
														<tr class="query_two">
															<td>产品花纹</td>
															<td colspan="3">${storeOut.product.pattern.name }</td>
														</tr>
														<tr class="query_one">
															<td>产品层级</td>
															<td colspan="3">${storeOut.product.levels.name }</td>
														</tr>
														<tr class="query_two">
															<td>客户名称</td>
															<td colspan="3">${order.customer.name }</td>
														</tr>
														<tr class="query_one">
															<td>订单日期</td>
															<td colspan="3">${order.odate}</td>
														</tr>
														<tr class="query_two">
															<td>业务员</td>
															<td colspan="3">${order.delivery.storeman}</td>
														</tr>
														<tr class="query_one">
															<td>物流公司</td>
															<td colspan="3">${order.delivery.company}</td>
														</tr>
														<tr class="query_two">
															<td>收货人</td>
															<td colspan="3">${order.customer.cusRep}</td>
														</tr>
														<tr class="query_one">
															<td>电话</td>
															<td colspan="3">${order.customer.phone}</td>
														</tr>
														<tr class="query_two">
															<td>地址</td>
															<td colspan="3">${order.customer.address}</td>
														</tr>
														<tr>
															<td colspan="4" class="td_page_right"><input
																onclick="back();" type="button" value="返回"
																class="input_submit"></td>
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
</body>

</body>

