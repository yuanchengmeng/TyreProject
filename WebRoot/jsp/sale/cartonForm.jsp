<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>
<head>
<title>添加箱号</title>
<link rel="Stylesheet" href="<%=request.getContextPath()%>/jsp/css/listtable.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css">
<script type="text/jscript" src="<%=request.getContextPath()%>/js/jquery-1.3.2-vsdoc2.js"></script>
<script type="text/jscript" src="<%=request.getContextPath()%>/jsp/js/jquery.jqprint-0.3.js"></script>

<script type="text/javascript">
	function back() {
		location.href = "/TyreProject/sale/querySeOrder?flag=first";
	}

	function AddRow(listSize) {
	    var oprion1 = "";
		var count = $("#vehicleId option").length;
		for ( var i = 0; i < count; i++) {
			oprion1 = oprion1 + "<option value='"
					+ $("#vehicleId ").get(0).options[i].value + "'>"
					+ $("#vehicleId ").get(0).options[i].text + "</option>";
		}
		
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
		row.append($('<td style="text-align:center"><select name="cartonList[' + (n-1) + '].vehicle.id" >' + oprion1 + ' </select></td>'));
		/* <input type="text" id="vehicleNo' + n + '" name="cartonList[' + n + '].vehicle.id"></td>')); */
		row.append($('<td style="text-align:center"><input type="text" id="cartonNo' + (n-1) + '" name="cartonList[' + (n-1) + '].cartonNo"></td>'));
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
	<s:form action="addCarton" namespace="/sale" theme="simple">
		<s:hidden name="pageNo" id="pageNo" value="%{pageNo}" />
		<s:hidden name="pageSize" id="pageSize" value="%{pageSize}" />
		<s:hidden id="arrayCount" value="%{cartonList.size}" />
		<s:hidden name="seOrder.orderDate1" id="orderDate1" value="%{seOrder.orderDate1}" />
		<s:hidden name="seOrder.orderDate2" id="orderDate2" value="%{seOrder.orderDate2}" />
		<s:hidden name="seOrder.finterID" id="finterID" value="%{seOrder.finterID}" />
		<div style="display: none;">
		<s:select list="vehicleList" listKey="id"
				  listValue="vehicleNo" headerKey="0" headerValue="请选择车牌号" id="vehicleId" />
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig"><br>位置：添加箱号</td>
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
																	<table id="tb" width="70%" border="0" cellpadding="0"
																		cellspacing="1">
																		<tr class="query_two">
																			<td colspan="4" style="text-align:center;"><b>订单箱号信息</b></td>
 																		</tr>
																		<tr class="query_one">
																			<td style="text-align:center;" width="10%">车辆<a
																				href="javascript:void(0)"
																				onclick="AddRow('<s:property value="cartonList.size" />');"><img
																					src="<%=request.getContextPath()%>/jsp/images/add1.gif" border="0">
																			</a>
																			</td>
																			<td style="text-align:center;" width="30%">车牌号</td>
																			<td style="text-align:center;" width="30%">箱号</td>
 																		</tr>
																		<s:iterator var="carton" value="cartonList"
																			status="stuts">
																			<s:if test="#stuts.even == true">
																				<tr class="query_one" id=trDataRow<s:property value="#stuts.count"/>>
																					  <td style="text-align:center" width="5%"><input
																						type="hidden"
																						name="cartonList[<s:property value="#stuts.index"/>].id"
																						value="<s:property value="#carton.id"/>" />
																						<s:property value="#stuts.count" />
																						<a href="javascript:void(0)" onclick="deleteRow('trDataRow<s:property value="#stuts.count"/>');">
																						<img src="/TyreProject/jsp/images/del001.gif" border="0"></a>
																					</td>
																			</s:if>
																			<s:else>
																				<tr class="query_two" id=trDataRow<s:property value="#stuts.count"/>>
																				 	<td style="text-align:center" width="5%"><input
																						type="hidden"
																						name="cartonList[<s:property value="#stuts.index"/>].id"
																						value="<s:property value="#carton.id"/>" />
																						<s:property value="#stuts.count" />
																						<a href="javascript:void(0)" onclick="deleteRow('trDataRow<s:property value="#stuts.count"/>');">
																						<img src="/TyreProject/jsp/images/del002.gif" border="0"></a>
																					</td>
																			</s:else>
																			    <td style="text-align:center">${carton.vehicle.vehicleNo}</td>
																				<td style="text-align:center">${carton.cartonNo}</td>
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

