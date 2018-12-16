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
	function back() {
		 history.go(-1);
	}
	 
    function detailPage(id) {
        var sid = document.getElementById("id").value;
		var pageSize = document.getElementById("pageSize").value;
		var pageNo = document.getElementById("pageNo").value;
		location.href = "/TyreProject/store/getStoreById?flag=2&&store.id="+ id+"&&pageNo="+pageNo
					+ "&&pageSize=" + pageSize+"&&id="+sid;
	}
		
	function page(flag) {
	    var id = document.getElementById("id").value;
	    var outTime1Id = document.getElementById("outTime1Id").value;
		var outTime2Id = document.getElementById("outTime2Id").value;		
	    var productName = document.getElementById("productName").value;
		var BarcodeId = document.getElementById("BarcodeId").value;
		var pageSize = document.getElementById("pageSize").value;
		var pageCount = document.getElementById("pageCount").value;
		var pageNo = document.getElementById("pageNo").value;
		var gotopage = document.getElementById("gotopage").value;
		var fbillNo = document.getElementById("fbillNo").value;
		var outMan = document.getElementById("outMan").value;
		if ("first" == flag) {
		location.href = "/TyreProject/store/queryStore?flag=2&&pageNo=1"
					+ "&&pageSize=" + pageSize+ "&&store.barcode=" + BarcodeId+"&&store.outTime1="+outTime1Id+"&&store.outTime2="+outTime2Id+"&&store.productName="+productName+"&&id="+id+"&&store.seOrderEntry.seOrder.fbillNo="+fbillNo+"&&outMan="+outMan;
		} else if ("end" == flag) {
			location.href = "/TyreProject/store/queryStore?flag=2&&pageNo=" + pageCount
					+ "&&pageSize=" + pageSize+ "&&store.barcode=" + BarcodeId+"&&store.outTime1="+outTime1Id+"&&store.outTime2="+outTime2Id+"&&store.productName="+productName+"&&id="+id+"&&store.seOrderEntry.seOrder.fbillNo="+fbillNo+"&&outMan="+outMan;
		} else if ("last" == flag) {
		  location.href = "/TyreProject/store/lastPage?flag=2&&pageNo=" + pageNo
					 + "&&pageSize=" + pageSize + "&&store.barcode=" + BarcodeId+"&&store.outTime1="+outTime1Id+"&&store.outTime2="+outTime2Id+"&&store.productName="+productName+"&&id="+id+"&&store.seOrderEntry.seOrder.fbillNo="+fbillNo+"&&outMan="+outMan;
		} else if ("next" == flag) {
			location.href = "/TyreProject/store/nextPage?flag=2&&pageNo=" + pageNo
					+ "&&pageSize=" + pageSize+ "&&store.barcode=" + BarcodeId+"&&store.outTime1="+outTime1Id+"&&store.outTime2="+outTime2Id+"&&store.productName="+productName+"&&id="+id+"&&store.seOrderEntry.seOrder.fbillNo="+fbillNo+"&&outMan="+outMan;
		} else if ("go" == flag) {
			if (parseInt(gotopage) <= parseInt(pageCount)) {
				location.href = "/TyreProject/store/queryStore?flag=2&&pageNo="
						+ gotopage + "&&pageSize=" + pageSize+ "&&store.barcode=" + BarcodeId+"&&store.outTime1="+outTime1Id+"&&store.outTime2="+outTime2Id+"&&store.productName="+productName+"&&id="+id+"&&store.seOrderEntry.seOrder.fbillNo="+fbillNo+"&&outMan="+outMan;
				
			} else {
		    	alert("请输入有效页数！！");
			}
		} else if ("selectPageSize" == flag) {
			location.href = "/TyreProject/store/queryStore?flag=2&&pageNo=1"
					+ "&&pageSize=" + pageSize+ "&&store.barcode=" + BarcodeId+"&&store.outTime1="+outTime1Id+"&&store.outTime2="+outTime2Id+"&&store.productName="+productName+"&&id="+id+"&&store.seOrderEntry.seOrder.fbillNo="+fbillNo+"&&outMan="+outMan;
		}
	}
	function exportOut() {
	    var id = document.getElementById("id").value;
	    var recordCount = document.getElementById("recordCount").value;
 	    if(recordCount>20000){
	       alert("导出条数不能大于2万条！！");
	    }else{
		    var outTime1Id = document.getElementById("outTime1Id").value;
		    var outTime2Id = document.getElementById("outTime2Id").value;		
		    var productName = document.getElementById("productName").value;
			var BarcodeId = document.getElementById("BarcodeId").value;
			var fbillNo = document.getElementById("fbillNo").value;
	        var outMan = document.getElementById("outMan").value;
	 		location.href = "/TyreProject/store/exportExcel?flag=2&&store.barcode=" + BarcodeId+"&&store.outTime1="+outTime1Id+"&&store.outTime2="+outTime2Id+"&&store.productName="+productName+"&&id="+id+"&&store.seOrderEntry.seOrder.fbillNo="+fbillNo+"&&outMan="+outMan;
  	    }
	   }
</script>

</head>

<body>
	${success}
	<s:form action="queryStore" namespace="/store">
		<s:hidden name="flag" value="2" />
		<s:hidden name="id" id="id"/>
		<s:hidden name="productID" />
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
																cellspacing="1">
																<tr class="query_two">
																	<td>条形码:<input type="text"
																		name="store.barcode" id="BarcodeId"
																		style="width: 80px;" value="${store.barcode }"></td>
																	<td>&nbsp;规格型号：<input type="text"
																		name="store.productName" value="${store.productName}"
																		id="productName" style="width: 100px;">
																		
																	</td>
																  	<td>&nbsp;出库时间：<input type="text"
																		name="store.outTime1" id="outTime1Id"
																		onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
																		class="Wdate" style="width:140px"
																		value="${store.outTime1}" />-<input type="text"
																		name="store.outTime2" id="outTime2Id"
																		onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
																		class="Wdate" style="width:140px"
																		value="${store.outTime2}" />
																	</td>
																</tr>
																<tr class="query_one">
																	<td>订单编号:<input type="text" style="width: 100px;" id="fbillNo"
																		name="store.seOrderEntry.seOrder.fbillNo" value="${store.seOrderEntry.seOrder.fbillNo}"></td>  
																	<td>&nbsp;出库人：<input type="text"
																		name="store.outMan" value="${store.outMan}"
																		id="outMan" style="width: 100px;"></td>
																	<td>&nbsp;<input
																		style="color:white" type="submit" id="" value="查询"
																		class="input_submit">&nbsp;<input
																		style="color:white" type="button" onclick="back();"
																		id="" value="返回" class="input_ok"> &nbsp;
                                                                        <input style="color:white" type="button"
																		value="导出Excel" class="input_ok"
																		onclick="exportOut();"></td>
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
																		<th style="color:black">规格型号</th>
																		<th style="color:black">订单编号</th>
																		<th style="color:black">购买单位</th>
																		<th style="color:black">出库时间</th>
																		<th style="color:black">出库人</th>

																	</tr>
																</thead>
																<tbody>
																	<s:iterator value="storeList" var="store"
																		status="status">
																		<tr class="even">
																			<td style="width:30px;text-align:center"><input
																				type="checkBox" name="ids"
																				value="<s:property
																					value='#store.getId()' />"
																				style="border: none"></td>
																			<td style="text-align: center;"><s:property
																					value="#status.index+1+(pageNo-1)*pageSize" />
																			</td>
																			<td><a href="javascript:void(0)"
																				onclick="detailPage(<s:property value='#store.getId()' />);"><s:property
																						value="#store.getBarcode()" /> </a>
																			</td>

																			<td><s:property
																					value="#store.getSeOrderEntry().getProduct().getFName()" />
																			</td>
																			<td><s:property
																					value="#store.getSeOrderEntry().getSeOrder().getFbillNo()" />
																			</td>
																			<td><s:property
																					value="#store.getSeOrderEntry().getSeOrder().getCustomer().getFName()" />
																			</td>
																			<td><s:property value="#store.getOutTime()" />
																			</td>
																			<td><s:property value="#store.getOutMan()" />
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