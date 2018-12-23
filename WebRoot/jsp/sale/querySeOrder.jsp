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
	
	function detailPage(id) {
 	  var nameId = document.getElementById("nameId").value;
	  var pageSize=document.getElementById("pageSize").value;
      var pageNo=document.getElementById("pageNo").value;
      var orderDate1 = document.getElementById("orderDate1").value; 
	  var orderDate2 = document.getElementById("orderDate2").value;
	  location.href = "/TyreProject/sale/getSeOrderEntryById?pageSize="+pageSize+"&&pageNo="+pageNo+"&&id="+id+"&&nameId="+nameId+"&&seOrder.orderDate1="+orderDate1+"&&seOrder.orderDate2="+orderDate2;
	}
	
	function page(flag) {
	    var nameId = document.getElementById("nameId").value; 
		var pageSize = document.getElementById("pageSize").value;
		var pageCount = document.getElementById("pageCount").value;
		var pageNo = document.getElementById("pageNo").value;
		var gotopage = document.getElementById("gotopage").value;
		var orderDate1 = document.getElementById("orderDate1").value; 
		var orderDate2 = document.getElementById("orderDate2").value;
		if ("first" == flag) {
			location.href = "/TyreProject/sale/querySeOrder?pageNo=1"+"&&pageSize="+pageSize+"&&nameId="+nameId+"&&seOrder.orderDate1="+orderDate1+"&&seOrder.orderDate2="+orderDate2;
		} else if ("end" == flag) {
			location.href = "/TyreProject/sale/querySeOrder?pageNo="+pageCount+"&&pageSize="+pageSize+"&&nameId="+nameId+"&&seOrder.orderDate1="+orderDate1+"&&seOrder.orderDate2="+orderDate2;
		} else if ("last" == flag) {
			location.href = "/TyreProject/sale/lastSeOrderPage?pageNo="+pageNo+"&&pageSize="+pageSize+"&&nameId="+nameId+"&&seOrder.orderDate1="+orderDate1+"&&seOrder.orderDate2="+orderDate2;
		} else if ("next" == flag) {
			location.href = "/TyreProject/sale/nextSeOrderPage?pageNo="+pageNo+"&&pageSize="+pageSize+"&&nameId="+nameId+"&&seOrder.orderDate1="+orderDate1+"&&seOrder.orderDate2="+orderDate2;
		} else if ("go" == flag) {
			if (gotopage == "" || gotopage > pageCount) {
				alert("请输入不大于" + pageCount + "的正整数");
			} else {
				location.href = "/TyreProject/sale/querySeOrder?pageNo="+gotopage+"&&pageSize="+pageSize+"&&nameId="+nameId+"&&seOrder.orderDate1="+orderDate1+"&&seOrder.orderDate2="+orderDate2;
			}
		} else if ("selectPageSize" == flag) {
			location.href = "/TyreProject/sale/querySeOrder?pageNo=1"+"&&pageSize="+pageSize+"&&nameId="+nameId+"&&seOrder.orderDate1="+orderDate1+"&&seOrder.orderDate2="+orderDate2;
		}
	}
	
	function addVehicle() {
		var value = "";
		var count = 0;
	 	var nameId = document.getElementById("nameId").value;
	 	var orderDate1 = document.getElementById("orderDate1").value;
	 	var orderDate2 = document.getElementById("orderDate2").value;
	    var pageSize=document.getElementById("pageSize").value;
        var pageNo=document.getElementById("pageNo").value;
		var box = document.getElementsByName("ids");
		for ( var i = 0; i < box.length; i++) {
			if (box[i].checked) { //判断复选框是否选中   
				value = box[i].value;
				count = count + 1;
			}
		}
		if (count == 1) {
			location.href = "/TyreProject/sale/getVehicleForm?seOrder.finterID=" + value+"&&seOrder.orderDate1="+orderDate1+"&&seOrder.orderDate2="+orderDate1+"&&pageSize="+pageSize+"&&pageNo="+pageNo+"&&nameId="+nameId;
		} else {
			alert("请选择一个选项！");
		}
	}
	
	function addCarton() {
		var value = "";
		var count = 0;
	 	var nameId = document.getElementById("nameId").value;
	 	var orderDate1 = document.getElementById("orderDate1").value;
	 	var orderDate2 = document.getElementById("orderDate2").value;
	    var pageSize=document.getElementById("pageSize").value;
        var pageNo=document.getElementById("pageNo").value;
		var box = document.getElementsByName("ids");
		for ( var i = 0; i < box.length; i++) {
			if (box[i].checked) { //判断复选框是否选中   
				value = box[i].value;
				count = count + 1;
			}
		}
		if (count == 1) {
			location.href = "/TyreProject/sale/getCartonForm?seOrder.finterID=" + value+"&&seOrder.orderDate1="+orderDate1+"&&seOrder.orderDate2="+orderDate1+"&&pageSize="+pageSize+"&&pageNo="+pageNo+"&&nameId="+nameId;
		} else {
			alert("请选择一个选项！");
		}
	}
</script>

</head>

<body>
	${success}
	<s:form action="querySeOrder" namespace="/sale">
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
															class="dqwz"><b>当前位置：</b>订单信息</span></td>
														<td width="20" height="42"><img
															src="<%=request.getContextPath()%>/jsp/images/xxnr_18.jpg"
															width="20" height="42"></td>
													</tr>
													<tr>
														<td width="20"
															background="<%=request.getContextPath()%>/jsp/images/xxnr_25.jpg"><img
															src="<%=request.getContextPath()%>/jsp/images/xxnr_25.jpg">
														</td>
														<td><br style="line-height:3px">提单号:<input
															type="text" name="seOrder.fbillNo" id="nameId"
															value="${seOrder.fbillNo}" size="7">&nbsp;&nbsp;订单日期：<input
															type="text" name="seOrder.orderDate1" id="orderDate1"
															onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
															class="Wdate" style="width:90px"
															value="${seOrder.orderDate1}" />-<input type="text"
															name="seOrder.orderDate2" id="orderDate2"
															onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
															class="Wdate" style="width:90px"
															value="${seOrder.orderDate2}" />&nbsp;&nbsp;&nbsp;<input style="color:white"
															type="submit" id="" value="查询" class="input_ok">
															&nbsp;<input style="color:white"
															type="button" onclick="addVehicle();" value="添加车辆" class="input_submit">
															&nbsp;<input style="color:white"
															type="button" onclick="addCarton();" value="添加箱号" class="input_submit">
															
															<br>
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
																		<th style="color:black;text-align:center;">提单号</th>
																		<th style="color:black;text-align:center;">购买公司</th>
																		<th style="color:black;text-align:center;">订单日期</th>
																		<th style="color:black;text-align:center;">订单数量</th>
																		<th style="color:black;text-align:center;">扫码数量</th>
																	</tr>
																</thead>
																<tbody>
																	<s:iterator value="seOrderList" var="seOrder">
																		<tr class="even">
																			<td style="width:30px;text-align:center"><input
																				type="checkBox" name="ids"
																				value="<s:property
																					value='#seOrder.getFinterID()' />"
																				style="border: none"></td>
																			<td style="text-align:center"><a href="javascript:void(0)"
																				onclick="detailPage(<s:property value='#seOrder.getFinterID()' />);">
																					<s:property value="#seOrder.getFbillNo()" /> </a></td>
																			<td style="text-align:center"><s:property value="#seOrder.getCustomer().getFName()" />
																			</td>
																			<td  style="text-align:center"><s:property value="#seOrder.getFdate()" />
																			</td>
																			<td  style="text-align:center"><s:property value="#seOrder.getAllCount()" />
																			</td>
																			<td  style="text-align:center"><s:property value="#seOrder.getAllBarcode()" />
																			</td>
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
																	<td width="50%" height="25" nowrap>共 <s:property
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