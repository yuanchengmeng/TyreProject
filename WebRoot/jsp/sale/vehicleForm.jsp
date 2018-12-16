<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>
<head>
<title>添加车辆</title>
<link rel="Stylesheet" href="<%=request.getContextPath()%>/jsp/css/listtable.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css">
<script type="text/jscript" src="<%=request.getContextPath()%>/js/jquery-1.3.2-vsdoc2.js"></script>
<script type="text/jscript" src="<%=request.getContextPath()%>/jsp/js/jquery.jqprint-0.3.js"></script>

<script type="text/javascript">
	function back() {
		location.href = "/TyreProject/sale/querySeOrder?flag=first";
	}

	function AddRow(listSize) {
 	  if(listSize==""){
	     listSize=0;
	  }
	  if(document.getElementById("arrayCount").value==""){
	    document.getElementById("arrayCount").value=0;
 	  }
 	    document.getElementById("arrayCount").value=parseInt(document.getElementById("arrayCount").value)+1;
 	    var n=document.getElementById("arrayCount").value;
 		//所有的数据行有一个.MyRow的Class，得到数据行的大小;
		var vcount = $("#tb tr").length - 1-listSize*2;//表格有多少个数据行;
  		if (vcount % 2 == 0) {
			var row = $('<tr class="query_one" id=trDataRow' + n
					+ '>');
			row
					.append($('<td style="text-align:center" >'
							+ n
							+ '<a href="javascript:void(0)" onclick="deleteRow(\'trDataRow'
							+ n
							+ '\');"><img src="/TyreProject/jsp/images/del001.gif" border="0"> </a></td>'));
		} else {
			var row = $('<tr class="query_two" id=trDataRow' + n
					+ '>');
			row
					.append($('<td style="text-align:center">'
							+ n
							+ '<a href="javascript:void(0)" onclick="deleteRow(\'trDataRow'
							+ n
							+ '\');"><img src="/TyreProject/jsp/images/del002.gif" border="0"> </a></td>'));
		}
		row.append($('<td style="text-align:center"><input type="text" id="vehicleNo' + n + '" name="vehicleList[' + n + '].vehicleNo"></td>'));
		row.append($('<td style="text-align:center"><input type="text" id="driver' + n + '" name="vehicleList[' + n + '].driver"></td>'));
		row.append($('<td style="text-align:center"><input type="text" id="phone' + n + '" name="vehicleList[' + n + '].phone"></td>'));
		var $tr = $("#tb tr").eq(vcount+listSize*2);
		$tr.after(row);
	}

	function deleteRow(id) {
	     $("#" + id + "").remove();
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
	${ShowMessage}
	<s:form action="addVehicle" namespace="/sale" theme="simple">
		<s:hidden name="pageNo" id="pageNo" value="%{pageNo}" />
		<s:hidden name="pageSize" id="pageSize" value="%{pageSize}" />
		<s:hidden id="arrayCount" value="%{vehicleList.size}" />
		<s:hidden name="seOrder.orderDate1" id="orderDate1" value="%{seOrder.orderDate1}" />
		<s:hidden name="seOrder.orderDate2" id="orderDate2" value="%{seOrder.orderDate2}" />
		<s:hidden name="seOrder.finterID" id="finterID" value="%{seOrder.finterID}" />
		<s:hidden name="nameId" id="nameId" value="%{nameId}" />
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig"><br>位置：添加车辆</td>
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
																<td style="text-align:center;" width="10%">提单号：</td>
																<td width="35%">${seOrderDetail.fbillNo}</td>
																<td style="text-align:center;" width="20%">购买单位：</td>
																<td>${seOrderDetail.customer.FName}</td>
															</tr>
															<tr>
																<td colspan="6" align="center">
																	<table id="tb" width="80%" border="0" cellpadding="0"
																		cellspacing="1">
																		<tr class="query_two">
																			<td colspan="4" style="text-align:center;"><b>订单车辆信息</b></td>
 																		</tr>
																		<tr class="query_one">
																			<td style="text-align:center;" width="10%">车辆<a
																				href="javascript:void(0)"
																				onclick="AddRow('<s:property value="vehicleList.size" />');"><img
																					src="<%=request.getContextPath()%>/jsp/images/add1.gif" border="0">
																			</a>
																			</td>
																			<td style="text-align:center;" width="30%">车牌号</td>
																			<td style="text-align:center;" width="30%">司机姓名</td>
																			<td style="text-align:center;">电话</td>
 																		</tr>
																		<s:iterator var="vehicle" value="vehicleList"
																			status="stuts">
																			<s:if test="#stuts.even == true">
																				<tr class="query_one" id=trDataRow<s:property value="#stuts.count"/>>
																					  <td style="text-align:center" width="5%"><input
																						type="hidden"
																						name="vehicleList[<s:property value="#stuts.index"/>].id"
																						value="<s:property value="#vehicle.id"/>" /><%--  <input
																						type="hidden"
																						name="vehicleList[<s:property value="#stuts.index"/>].createdTime"
																						value="<s:property value="#vehicle.createdTime"/>" />
																						<input type="hidden"
																						name="vehicleList[<s:property value="#stuts.index"/>].createdBy.id"
																						value="<s:property value="#vehicle.createdBy.id"/>" /> --%>
																						<s:property value="#stuts.count" />
																						<s:if test="#vehicle.getOutNo() == null||#vehicle.getOutNo()==''">
																							<a
																						href="javascript:void(0)"
																						onclick="deleteRow('trDataRow<s:property value="#stuts.count"/>','<s:property value="#vehicle.isFinish.dictKey"/>');"><img src="/TyreProject/jsp/images/del001.gif" border="0"></a>
																						</s:if>
																					</td>
																			</s:if>
																			<s:else>
																				<tr class="query_two" id=trDataRow<s:property value="#stuts.count"/>>
																				 	<td style="text-align:center" width="5%"><input
																						type="hidden"
																						name="vehicleList[<s:property value="#stuts.index"/>].id"
																						value="<s:property value="#vehicle.id"/>" /> <%--<input
																						type="hidden"
																						name="vehicleList[<s:property value="#stuts.index"/>].createdTime"
																						value="<s:property value="#vehicle.createdTime"/>" />
																						<input type="hidden"
																						name="vehicleList[<s:property value="#stuts.index"/>].createdBy.id"
																						value="<s:property value="#vehicle.createdBy.id"/>" /> --%>
																						<s:property value="#stuts.count" />
																						<s:if test="#vehicle.getOutNo() == null||#vehicle.getOutNo()==''">
																							<a
																							href="javascript:void(0)"
																							onclick="deleteRow('trDataRow<s:property value="#stuts.count"/>','<s:property value="#vehicle.isFinish.dictKey"/>');"><img
																								src="/TyreProject/jsp/images/del002.gif" border="0"></a>
																						</s:if>
																					</td>
																			</s:else>
																			<s:if test="#vehicle.getOutNo() == null||#vehicle.getOutNo()==''">
																			    <td style="text-align:center">${vehicle.vehicleNo}<input type="hidden" id="pnodeBudget<s:property value="#stuts.index"/>"
																						name="vehicleList[<s:property value="#stuts.index"/>].vehicleNo" value="${vehicle.vehicleNo}">
																				</td>
																				<td style="text-align:center"><input type="text" id="pnodeBudget<s:property value="#stuts.index"/>"
																						name="vehicleList[<s:property value="#stuts.index"/>].driver" value="${vehicle.driver}">
																				</td>
																				<td style="text-align:center"><input type="text" id="pnodeBudget<s:property value="#stuts.index"/>"
																						name="vehicleList[<s:property value="#stuts.index"/>].phone" value="${vehicle.phone}">
																				</td>
																			</s:if>
																			<s:else>
																			    <td style="text-align:center">${vehicle.vehicleNo}</td>
																				<td style="text-align:center">${vehicle.driver}</td>
																				<td style="text-align:center">${vehicle.phone}</td>
																			</s:else>
																		</s:iterator>
																	</table></td>
															</tr>
															<tr>
																<td colspan="6" class="td_page_right">
																		<s:submit value="保存" cssClass="input_submit"></s:submit>
                                                                  <input onclick="back();" type="button" value="返回" class="input_ok"></td>
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

