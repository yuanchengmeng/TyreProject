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
		 history.go(-1);
	}
</script>
</head>
<body>
	${success }
	<s:hidden name="pageNo" id="pageNo" value="%{pageNo}"></s:hidden>
	<s:hidden name="pageSize" id="pageSize" value="%{pageSize}"></s:hidden>
	<s:hidden name="productId" id="productId" value="%{productId}"></s:hidden>
	<s:hidden name="patternId" id="patternId" value="%{patternId}"></s:hidden>
	<s:hidden name="dateId" id="dateId" value="%{dateId}"></s:hidden>
	<s:hidden name="BarcodeId" id="BarcodeId" value="%{BarcodeId}"></s:hidden>
	<table width="100%" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td valign="top">
				<table border="0" cellpadding="0" cellspacing="0"
					class="cTableBorder">
					<tr>
						<td align="left" class="navig">位置：库存轮胎信息详情</td>
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
														<s:iterator value="#request.store" var="store">
															<tr class="query_one">
																<td width="20%">条形码</td>
																<td colspan="3">${store.barcode}</td>
															</tr>
															<tr class="query_two">
																<td colspan="4" style="font-size:18px;font-weight:bold;text-align:center">入库信息</td>
																
															</tr>
															<tr class="query_one">
																<td width="20%">入库笼框</td>
																<td colspan="3">${store.boxCode}</td>
															</tr>
															<tr class="query_two">
																<td>规格型号</td>
																<td colspan="3">${store.product.FName}</td>
															</tr>
															 <tr class="query_one">
																<td>入库时间</td>
																<td colspan="3">${store.inTime}</td>
															</tr>
															<tr class="query_two">
																<td>入库日期</td>
																<td colspan="3">${store.inDate}</td>
															</tr>
															<tr class="query_one">
																<td>入库人</td>
																<td colspan="3">${store.inMan}</td>
															</tr>
															<tr class="query_two">
																<td>入库班次</td>
																<td colspan="3">${store.inClass}</td>
															</tr>
															<!-- 2018-04-18新增字段 -->
															<tr class="query_one">
																<td>上传k3时间</td>
																<td colspan="3">${store.k3Time}</td>
															</tr>
															<tr class="query_two">
																<td colspan="4" style="font-size:18px;font-weight:bold;text-align:center">原始入库信息</td>
																
															</tr>
															<tr class="query_one">
																<td>原始入库时间</td>
																<td colspan="3">${store.oldrkTime}</td>
															</tr>
															<tr class="query_two">
																<td>原始入库人</td>
																<td colspan="3">${store.oldrkMan}</td>
															</tr>
															<tr class="query_one">
																<td>原始入库班次</td>
																<td colspan="3">${store.oldrkClass}</td>
															</tr>
															<tr class="query_two">
																<td colspan="4" style="font-size:18px;font-weight:bold;text-align:center">取消入库信息</td>
																
															</tr>
															<tr class="query_one">
																<td>取消入库时间</td>
																<td colspan="3">${store.qxrkTime}</td>
															</tr>
															<tr class="query_two">
																<td>取消入库人</td>
																<td colspan="3">${store.qxrkMan}</td>
															</tr>
															<tr class="query_one">
																<td>取消入库班次</td>
																<td colspan="3">${store.qxrkClass}</td>
															</tr>
															<tr class="query_one">
																<td colspan="4" style="font-size:18px;font-weight:bold;text-align:center">反入库(取消出库)信息</td>
																
															</tr>
															<tr class="query_two">
																<td>返入库时间</td>
																<td colspan="3">${store.frkTime}</td>
															</tr>
															<tr class="query_one">
																<td>返入库人</td>
																<td colspan="3">${store.frkMan}</td>
															</tr>
															<tr class="query_two">
																<td>返入库班次</td>
																<td colspan="3">${store.frkClass}</td>
															</tr>
															<tr class="query_one">
																<td>返入库前笼框号</td>
																<td colspan="3">${store.nofrkBoxcode}</td>
															</tr>
															<tr class="query_two">
																<td colspan="4" style="font-size:18px;font-weight:bold;text-align:center">笼框转移信息</d>
															
															</tr>
															<tr class="query_one">
																<td>修改笼框时间</td>
																<td colspan="3">${store.changeboxTime}</td>
															</tr>
															<tr class="query_two">
																<td>修改笼框人</td>
																<td colspan="3">${store.changeboxMan}</td>
															</tr>
															<tr class="query_one">
																<td>修改笼框班次</td>
																<td colspan="3">${store.changeboxClass}</td>
															</tr>
															<tr class="query_two">
																<td>修改笼框前笼框号</td>
																<td colspan="3">${store.nochangeBoxcode}</td>
															</tr>
														</s:iterator>
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

