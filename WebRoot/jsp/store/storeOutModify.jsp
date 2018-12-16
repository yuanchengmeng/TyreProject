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
		var productId = document.getElementById("productId1").value;
		var BarcodeId = document.getElementById("BarcodeId").value;
		var pageNo = document.getElementById("pageNo").value;
		var pageSize = document.getElementById("pageSize").value;
		location.href = "/TyreProject/store/queryOutStore?pageNo=" + pageNo
				+ "&&pageSize=" + pageSize + "&&store.product.id=" + productId
				+ "&&store.barcode=" + BarcodeId + "&&storeOut.outDate="
				+ dateId;
	}
	function updateStoreOut() {
		var dateId = document.getElementById("dateId").value;
		var storeOutId = document.getElementById("storeOutId").value;
		var productId = document.getElementById("productId1").value;
		var productID = document.getElementById("productID").value;
		var BarcodeId = document.getElementById("BarcodeId").value;
		var outCardId = document.getElementById("outCardId").value;
		var pageNo = document.getElementById("pageNo").value;
		var pageSize = document.getElementById("pageSize").value;
		location.href = "/TyreProject/store/updateStoreOut?storeOut.id="
				+ storeOutId + "&&pageNo=" + pageNo + "&&pageSize=" + pageSize
				+ "&&productID=" + productID + "&&BarcodeId=" + BarcodeId
				+ "&&productId=" + productId + "&&outCardId=" + outCardId
				+ "&&dateId=" + dateId;
	}
</script>
</head>
<body>
	${success }
	<s:form namespace="/store" action="updateStore">
		<s:hidden name="pageNo" id="pageNo" value="%{pageNo}"></s:hidden>
		<s:hidden name="pageSize" id="pageSize" value="%{pageSize}"></s:hidden>
		<s:hidden name="productId" id="productId1" value="%{productId}"></s:hidden>
		<s:hidden name="productId" id="productId1" value="%{productId}"></s:hidden>
		<s:hidden name="BarcodeId" id="BarcodeId" value="%{BarcodeId}"></s:hidden>
		<s:hidden name="storeOut.id" id="storeOutId" value="%{storeOut.id}"></s:hidden>
		<s:hidden name="dateId" id="dateId" value="%{dateId}"></s:hidden>
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig">位置：出库轮胎修改</td>
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
																<td width="20%">条形码</td>
																<td colspan="3">${storeOut.barcode}</td>
															</tr>
															<tr class="query_two">
																<td width="20%">原产品规格|花纹|层级</td>
																<td colspan="3">${storeOut.product.standard.name}/${storeOut.product.pattern.name}/${storeOut.product.levels.name}
																</td>
															</tr>
															<tr class="query_one">
																<td width="20%">产品规格|花纹|层级</td>
																<td colspan="3"><select name="storeOut.product.id"
																	id="productID"><option value=0></option>
																		<s:iterator var="product" value="productList1">
																			<s:if test="storeOut.product.id==#product.getId()">
																				<option
																					value=<s:property value="#product.getId()" />
																					selected>
																					<s:property value="#product.getName()" />
																				</option>
																			</s:if>
																			<s:else>
																				<option
																					value=<s:property value="#product.getId()" />>
																					<s:property value="#product.getName()" />
																				</option>
																			</s:else>
																		</s:iterator>
																</select></td>
															</tr>
															<tr class="query_one">
																<td width="20%">原出库单号</td>
																<td colspan="3">${storeOut.outCard}</td>
															</tr>
															<tr class="query_two">
																<td width="20%">出库单号</td>
																<td colspan="3"><input type="text" id="outCardId"
																	name="storeOut.outCard" value="${storeOut.outCard}" />
																</td>
															</tr>
															<tr>
																<td colspan="4" class="td_page_right"><input
																	type="button" value="保存" class="input_submit"
																	onclick="updateStoreOut();"> <input
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
	</s:form>
</body>



