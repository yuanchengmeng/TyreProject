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
		var productId = document.getElementById("productId").value;
		var BarcodeId = document.getElementById("BarcodeId").value;
		var pageNo = document.getElementById("pageNo").value;
		var pageSize = document.getElementById("pageSize").value;
		location.href = "/TyreProject/store/queryOutStore?pageNo=" + pageNo
				+ "&&pageSize=" + pageSize + "&&storeOut.product.id="
				+ productId+ "&&storeOut.Barcode=" + BarcodeId;
	}
	function checkTyre() {
 		var productId = document.getElementById("product1Id").value;
  		if (productId == 0) {
			alert("请选择规格型号！！");
		} else { 
			 return document.forms[0].submit();
		} 
	}
</script>
</head>
<body >
	${success }
	<s:form action="backInStore" namespace="/store">
	<s:hidden name="storeOut1.id"/>
	<s:hidden name="pageNo" id="pageNo" value="%{pageNo}"></s:hidden>
	<s:hidden name="pageSize" id="pageSize" value="%{pageSize}"></s:hidden>
	<s:hidden name="productId" id="productId" value="%{productId}"></s:hidden>
	<s:hidden name="BarcodeId" id="BarcodeId" value="%{BarcodeId}"></s:hidden>
	<table width="100%" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td valign="top">
				<table border="0" cellpadding="0" cellspacing="0"
					class="cTableBorder">
					<tr>
						<td align="left" class="navig">位置：返库型号修改</td>
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
														<s:if test="#storeOut1.getInStoreNo()!=null">
															<tr class="query_two">
																<td width="20%">入库类型</td>
																<td colspan="3">${storeOut1.inCategory}</td>
															</tr>
															<tr class="query_one">
																<td width="20%">来源单位</td>
																<td colspan="3">${storeOut1.inSourseDept}</td>
															</tr>
															<tr class="query_two">
																<td>来源库区</td>
																<td colspan="3">${storeOut1.inSoursePlant}</td>
															</tr>
															<tr class="query_one">
																<td>入库库区</td>
																<td colspan="3">${storeOut1.inPlant}</td>
															</tr>
															<tr class="query_two">
																<td>入库品质</td>
																<td colspan="3">${storeOut1.inLevel}</td>
															</tr>
															</s:if><s:else>
															<tr class="query_two">
																<td>入库类型</td>
																<td colspan="3">补充入库</td>
															</tr>
															</s:else>
															<tr class="query_one">
																<td>入库时间</td>
																<td colspan="3">${storeOut1.inTime}</td>
															</tr>
															<tr class="query_two">
																<td>入库人</td>
																<td colspan="3">${storeOut1.inMan}</td>
															</tr>
															<tr class="query_one">
																<td>入库日期</td>
																<td colspan="3">${storeOut1.inDate}</td>
															</tr>
															<tr class="query_two">
																<td>出库单号</td>
																<td colspan="3">${storeOut1.outCard}</td>
															</tr>
															<tr class="query_one">
																<td>出库时间</td>
																<td colspan="3">${storeOut1.outTime}</td>
															</tr>
															<tr class="query_two">
																<td>出库人</td>
																<td colspan="3">${storeOut1.outMan}</td>
															</tr>
															<tr class="query_one">
																<td>出库日期</td>
																<td colspan="3">${storeOut1.outDate}</td>
															</tr>
															<tr class="query_two">
																<td>出库类型</td>
																<td colspan="3">${storeOut1.outCategory}</td>
															</tr>
															<tr class="query_one">
																<td>出库类型</td>
																<td colspan="3">${storeOut1.outCategory}</td>
															</tr>
															<tr class="query_two">
															 <td>产品规格|花纹|层级</td> 
															 <td colspan="3"><select
															id="product1Id" name="storeOut1.product.id"><option
																	value=0>请选择</option>
																<s:iterator var="product" value="productList">
																  <option value=<s:property value="#product.getId()" />>
																     <s:property value="#product.getName()" />
															      </option>
 																</s:iterator>
														</select></td>
													     	</tr>
														<tr>
															<td colspan="4" class="td_page_right">
															<input type="button" value="提交" class="input_submit" onclick="checkTyre();">
															<input onclick="back();" type="button" value="返回" class="input_submit">
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

