<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta name="menu" content="RoleMenu">
<link rel="Stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/listtable.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css">
<script type="text/javascript"
	src="<%=request.getContextPath() %>/jsp/js/validate.js"></script>
<script type="text/javascript">
	
	function detailPage(id) {
	    var orderID = document.getElementById("order"+id).value;
		var productID = document.getElementById("product"+id).value;
		var orderNo = document.getElementById("orderNo"+id).value;
		var productName = document.getElementById("productName"+id).value;
		location.href = "/TyreProject/store/queryStore?flag=2&&store.productID="+productID+"&&store.orderId="+orderID+"&&store.productName="+productName+"&&store.seOrderEntry.seOrder.fbillNo="+orderNo;
	}
	
	function page(flag) {
		var pageSize = document.getElementById("pageSize").value;
		var pageCount = document.getElementById("pageCount").value;
		var pageNo = document.getElementById("pageNo").value;
		var gotopage = document.getElementById("gotopage").value;
		if ("first" == flag) {
			location.href = "/TyreProject/sale/querySeOrder?pageNo=1"+"&&pageSize="+pageSize+"&&nameId="+nameId;
		} else if ("end" == flag) {
			location.href = "/TyreProject/sale/querySeOrder?pageNo="+pageCount+"&&pageSize="+pageSize+"&&nameId="+nameId;
		} else if ("last" == flag) {
			location.href = "/TyreProject/sale/lastSeOrderPage?pageNo="+pageNo+"&&pageSize="+pageSize+"&&nameId="+nameId;
		} else if ("next" == flag) {
			location.href = "/TyreProject/sale/nextSeOrderPage?pageNo="+pageNo+"&&pageSize="+pageSize+"&&nameId="+nameId;
		} else if ("go" == flag) {
			if (gotopage == "" || gotopage > pageCount) {
				alert("请输入不大于" + pageCount + "的正整数");
			} else {
				location.href = "/TyreProject/sale/querySeOrder?pageNo="+gotopage+"&&pageSize="+pageSize+"&&nameId="+nameId;
			}
		} else if ("selectPageSize" == flag) {
			location.href = "/TyreProject/sale/querySeOrder?pageNo=1"+"&&pageSize="+pageSize+"&&nameId="+nameId;
		}
	}
	function queryseOrder1(){
	    var pageSize = document.getElementById("pageSize").value;
		var pageNo = document.getElementById("pageNo").value;
		location.href = "/TyreProject/sale/querySeOrder?pageSize="+pageSize+"&&pageNo="+pageNo+"&&nameId="+nameId;
	}
	function back(){
 		location.href = "/TyreProject/sale/querySeOrder?flag=first";
	}
</script>

</head>

<body>
	${success}
	<s:form>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
				<tr>
					<td><table width="100%" border="0" cellspacing="0"
							cellpadding="0" class="zong">
							<tbody>
								<tr>
									<td>
										<div class="right">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tbody>
													<tr>
														<td width="20"><img
															src="<%=request.getContextPath()%>/jsp/images/xxnr_13.jpg"
															width="20" height="42">
														</td>
														<td
															background="<%=request.getContextPath()%>/jsp/images/xxnr_10.jpg"></br>&nbsp;<span
															class="dqwz"><b>当前位置：</b>订单明细信息</span></td>
														<td width="20" height="42"><img
															src="<%=request.getContextPath()%>/jsp/images/xxnr_18.jpg"
															width="20" height="42"></td>
													</tr>
													<tr>
														<td width="20"
															background="<%=request.getContextPath()%>/jsp/images/xxnr_25.jpg"><img
															src="<%=request.getContextPath()%>/jsp/images/xxnr_25.jpg">
														</td>
														<td><br style="line-height:3px">
														<br>
															<table id="list" cellpadding="0" class="table"
																cellspacing="0">
																<thead>
																	<tr>
																		<th><div style="text-align:center;">
																				<input type="checkbox" name="selectall"
																					onclick="selectAll('ids',this);"
																					style="border:none">
																			</div>
																		</th>
																		<th style="color:black">规格型号</th>
																		<th style="color:black">订单数量</th>
																		<th style="color:black">扫码数量</th>
																	</tr>
																</thead>
																<tbody>
																	<s:iterator value="seOrderEntryList" var="seOrderEntry" status="stuts">
																		<tr class="even">
																			<td style="width:30px;text-align:center"><input
																				type="checkBox" name="ids"
																				value="<s:property
																					value='#seOrderEntry.getFDetailID()' />"
																				style="border: none"></td>
																			<td><s:property
																					value="#seOrderEntry.getProduct().getFName()" />
																			</td>
																			<td><s:property value="#seOrderEntry.getFQty()" />
																			</td>
																			<td><a href="javascript:void(0)"
																				onclick="detailPage(<s:property value='#stuts.count' />);">
																					<s:property value="#seOrderEntry.getAllBarcode()" />
																			</a>
																			<input type="hidden" value="<s:property value='#seOrderEntry.getSeOrder().getFbillNo()' />" id="orderNo<s:property value='#stuts.count' />"> 
																			<input type="hidden" value="<s:property value='#seOrderEntry.getProduct().getFName()' />" id="productName<s:property value='#stuts.count' />"> 
																			<input type="hidden" value="<s:property value='#seOrderEntry.getSeOrder().getFinterID()' />" id="order<s:property value='#stuts.count' />"> 
																			<input type="hidden" value="<s:property value='#seOrderEntry.getProduct().getFItemID()' />" id="product<s:property value='#stuts.count' />"> 
																			</td>
																		</tr>
																	</s:iterator>
																</tbody>
															</table> <br>
															<table width="98%" border="0" cellpadding="0"
																cellspacing="0">
																<tr>
																	<td width="50%" align="right" nowrap>
																		<input style="color:white" type="button" onclick="back();" value="返回" class="input_submit">
																		</td>
																</tr>
															</table></td>
														<td width="20"
															background="<%=request.getContextPath()%>/jsp/images/xxnr_28.jpg">&nbsp;</td>
													</tr>
													<tr>
														<td><img
															src="<%=request.getContextPath()%>/jsp/images/xxnr_30.jpg"
															width="20" height="12">
														</td>
														<td height="12"
															background="<%=request.getContextPath()%>/jsp/images/xxnr_31.jpg"><img
															src="<%=request.getContextPath()%>/jsp/images/xxnr_31.jpg"
															width="32" height="12"></td>
														<td><img
															src="<%=request.getContextPath()%>/jsp/images/xxnr_33.jpg"
															width="20" height="12">
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</td>
								</tr>
							</tbody>
						</table></td>
				</tr>
			</tbody>
		</table>
	</s:form>
</body>
</html>