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
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function page(flag) {
	    var logTime1 = document.getElementById("logTime1").value;
		var logTime2 = document.getElementById("logTime2").value;		
	    var orderNo = document.getElementById("orderNo").value;
		var BarcodeId = document.getElementById("BarcodeId").value;
		
		var pageSize = document.getElementById("pageSize").value;
		var pageCount = document.getElementById("pageCount").value;
		var pageNo = document.getElementById("pageNo").value;
		var gotopage = document.getElementById("gotopage").value;
		if ("first" == flag) {
		location.href = "/TyreProject/store/queryBarcodeLog?pageNo=1"
					+ "&&pageSize=" + pageSize+ "&&barcodeLog.store.barcode=" + BarcodeId+"&&barcodeLog.orderNo="+orderNo+"&&barcodeLog.logTime1="+logTime1+"&&barcodeLog.logTime2="+logTime2;
		} else if ("end" == flag) {
			location.href = "/TyreProject/store/queryBarcodeLog?pageNo=" + pageCount
					+ "&&pageSize=" + pageSize+ "&&barcodeLog.store.barcode=" + BarcodeId+"&&barcodeLog.orderNo="+orderNo+"&&barcodeLog.logTime1="+logTime1+"&&barcodeLog.logTime2="+logTime2;
		} else if ("last" == flag) {
		  location.href = "/TyreProject/store/lastBarcodeLogPage?pageNo=" + pageNo
					 + "&&pageSize=" + pageSize + "&&barcodeLog.store.barcode=" + BarcodeId+"&&barcodeLog.orderNo="+orderNo+"&&barcodeLog.logTime1="+logTime1+"&&barcodeLog.logTime2="+logTime2;
		} else if ("next" == flag) {
		  location.href = "/TyreProject/store/nextBarcodeLogPage?pageNo=" + pageNo
					+ "&&pageSize=" + pageSize+ "&&barcodeLog.store.barcode=" + BarcodeId+"&&barcodeLog.orderNo="+orderNo+"&&barcodeLog.logTime1="+logTime1+"&&barcodeLog.logTime2="+logTime2;
		} else if ("go" == flag) {
			if (gotopage == "" || gotopage > pageCount) {
				alert("请输入不大于" + pageCount + "的正整数");
			} else {
				location.href = "/TyreProject/store/queryBarcodeLog?pageNo="
						+ gotopage + "&&pageSize=" + pageSize+ "&&barcodeLog.store.barcode=" + BarcodeId+"&&barcodeLog.orderNo="+orderNo+"&&barcodeLog.logTime1="+logTime1+"&&barcodeLog.logTime2="+logTime2;
			}
		} else if ("selectPageSize" == flag) {
			location.href = "/TyreProject/store/queryBarcodeLog?pageNo=1"
					+ "&&pageSize=" + pageSize+ "&&barcodeLog.store.barcode=" + BarcodeId+"&&barcodeLog.orderNo="+orderNo+"&&barcodeLog.logTime1="+logTime1+"&&barcodeLog.logTime2="+logTime2;
		}
	}
</script>

</head>

<body>
	<s:form action="queryBarcodeLog" namespace="/store">
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
															class="dqwz"><b>当前位置：</b> <s:if test="id==2">
															订单<b>${seOrderEntry.seOrder.fBillNo}</b>
																</s:if> 出库记录表</span></td>
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
															<table width="100%" border="0" cellpadding="0"
																cellspacing="0">
																<tr>
																	<td>条形码:<input type="text"
																		name="barcodeLog.store.barcode" id="BarcodeId"
																		style="width: 80px;" value="${barcodeLog.store.barcode}"></td>
																  	<td>&nbsp;订单编号:<input type="text" style="width: 100px;" id="orderNo"
																		name="barcodeLog.orderNo" value="${barcodeLog.orderNo}"></td>  
																	<td>&nbsp;时间：<input type="text"
																		name="barcodeLog.logTime1" id="logTime1"
																		onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
																		class="Wdate" style="width:140px"
																		value="${barcodeLog.logTime1}" />-<input type="text"
																		name="barcodeLog.logTime2" id="logTime2"
																		onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
																		class="Wdate" style="width:140px"
																		value="${barcodeLog.logTime2}" />
																	</td>
																	<td>&nbsp;<input
																		style="color:white" type="submit" id="" value="查询"
																		class="input_submit">&nbsp;<input
																		style="color:white" type="button" onclick="back();"
																		id="" value="返回" class="input_ok"></td>
																</tr>

															</table> <br>
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
																		<th style="text-align: center;color:black">序号</th>
																		<th style="color:black">条形码</th>
																		<th style="color:black">订单编号</th>
																		<th style="color:black">原因</th>
																		<th style="color:black">时间</th>
																		<th style="color:black">出库人</th>

																	</tr>
																</thead>
																<tbody>
																	<s:iterator value="barcodeLogList" var="barcodeLog"
																		status="status">
																		<tr class="even">
																			<td style="width:30px;text-align:center"><input
																				type="checkBox" name="ids"
																				value="<s:property
																					value='#barcodeLog.getId()' />"
																				style="border: none"></td>
																			<td style="text-align: center;"><s:property
																					value="#status.index+1+(pageNo-1)*pageSize" />
																			</td>
																			<td><s:property value="#barcodeLog.getStore().getBarcode()" />
																			</td>
																			<td><s:property
																					value="#barcodeLog.getOrderNo()" />
																			</td>
																			<td><s:property
																					value="#barcodeLog.getRemark()" />
																			</td>
																			<td><s:property value="#barcodeLog.getLogTime()" />
																			</td>
																			<td><s:property value="#barcodeLog.getLogMan()" />
																		</tr>
																	</s:iterator>
																</tbody>
															</table>
															<div>
																</br>
															</div>
															<table width="98%" border="0" cellpadding="0"
																cellspacing="0">
																<tr>
																	<!--所有的变量都是从后台获取到的-->
																	<td width="50%" height="25" nowrap>共<input type="hidden"
																		id="recordCount" value="${recordCount}"> <s:property
																			value="recordCount" /> 条记录 第 <input type="hidden"
																		id="pageNo" value="${pageNo}"> <s:property
																			value="pageNo" /> 页/共<input type="hidden"
																		id="pageCount" value="${pageCount}"> <s:property
																			value="pageCount" /> 页 每页显示 <select
																		onchange="page('selectPageSize');" name="pageSize"
																		style="width:80" id="pageSize">
																			<!--用于选择当前页有多少条记录的-->
																			<s:iterator var="pageSize" value="pageSizeList">
																				<s:if test="pageSize==#pageSize.getPsize()">
																					<option
																						value=<s:property value="#pageSize.getPsize()" />
																						selected>
																						<s:property value="#pageSize.getPsize()" />
																					</option>
																				</s:if>
																				<s:else>
																					<option
																						value=<s:property value="#pageSize.getPsize()" />>
																						<s:property value="#pageSize.getPsize()" />
																					</option>
																				</s:else>
																			</s:iterator>
																	</select> 条记录</td>
																	<td width="50%" align="right" nowrap>跳转到 <input
																		id=gotopage type="text" size="3"> <input
																		type="button" onclick="page('go');" class="input_ok"
																		value="GO"> <s:if test="pageNo==1">
																			<input type="button" class="input_ok" value="首页">
																			<input type="button" class="input_ok" value="上页">
																		</s:if> <s:else>
																			<input type="button" onclick="page('first');"
																				class="input_ok" value="首页">
																			<input type="button" onclick="page('last');"
																				class="input_ok" value="上页">
																		</s:else> <s:if test="pageNo==pageCount">
																			<input type="button" class="input_ok" value="下页">
																			<input type="button" class="input_ok" value="末页">
																		</s:if> <s:else>
																			<input type="button" onclick="page('next');"
																				class="input_ok" value="下页">
																			<input type="button" onclick="page('end');"
																				class="input_ok" value="末页">
																		</s:else>
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