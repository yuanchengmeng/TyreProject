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
		var pageSize = document.getElementById("pageSize").value;
		var pageNo = document.getElementById("pageNo").value;
		location.href = "/TyreProject/store/getStoreById?flag=3&&store.id="+ id+"&&pageNo="+pageNo
					+ "&&pageSize=" + pageSize;
		}
	function page(flag) {
	    var codeId = document.getElementById("codeId").value; 
		var BarcodeId = document.getElementById("BarcodeId").value;
	    var productName = document.getElementById("productName").value;
	    var inTime1Id = document.getElementById("inTime1Id").value;
	    var inTime2Id = document.getElementById("inTime2Id").value;
	    var classId = document.getElementById("classId").value;
		var pageSize = document.getElementById("pageSize").value;
		var pageCount = document.getElementById("pageCount").value;
		var pageNo = document.getElementById("pageNo").value;
		var gotopage = document.getElementById("gotopage").value;
	    var inMan = document.getElementById("inMan").value;
		if ("first" == flag) {
		location.href = "/TyreProject/store/queryStore?flag=3&&pageNo=1"
					+ "&&pageSize=" + pageSize+ "&&store.barcode=" + BarcodeId+"&&store.boxCode="+codeId+"&&store.productName="+productName+"&&store.inTime1="+inTime1Id+"&&store.inTime2="+inTime2Id+"&&store.classId="+classId+"&&inMan="+inMan;
		} else if ("end" == flag) {
		location.href = "/TyreProject/store/queryStore?flag=3&&pageNo=" + pageCount
					+ "&&pageSize=" + pageSize+ "&&store.barcode=" + BarcodeId+"&&store.boxCode="+codeId+"&&store.productName="+productName+"&&store.inTime1="+inTime1Id+"&&store.inTime2="+inTime2Id+"&&store.classId="+classId+"&&inMan="+inMan;
		} else if ("last" == flag) {
		location.href = "/TyreProject/store/lastPage?flag=3&&pageNo=" + pageNo
					+ "&&pageSize=" + pageSize+ "&&store.barcode=" + BarcodeId+"&&store.boxCode="+codeId+"&&store.productName="+productName+"&&store.inTime1="+inTime1Id+"&&store.inTime2="+inTime2Id+"&&store.classId="+classId+"&&inMan="+inMan;
		} else if ("next" == flag) {
		location.href = "/TyreProject/store/nextPage?flag=3&&pageNo=" + pageNo
					+ "&&pageSize=" + pageSize+ "&&store.barcode=" + BarcodeId+"&&store.boxCode="+codeId+"&&store.productName="+productName+"&&store.inTime1="+inTime1Id+"&&store.inTime2="+inTime2Id+"&&store.classId="+classId+"&&inMan="+inMan;
		} else if ("go" == flag) {
		   if (parseInt(gotopage) <= parseInt(pageCount)){
				location.href = "/TyreProject/store/queryStore?flag=3&&pageNo="
						+ gotopage + "&&pageSize=" + pageSize+ "&&store.barcode=" + BarcodeId+"&&store.boxCode="+codeId+"&&store.productName="+productName+"&&store.inTime1="+inTime1Id+"&&store.inTime2="+inTime2Id+"&&store.classId="+classId+"&&inMan="+inMan;
			} else {
			    alert("请输入不大于" + pageCount + "的正整数");
			}
		} else if ("selectPageSize" == flag) {
		location.href = "/TyreProject/store/queryStore?flag=3&&pageNo=1"
					+ "&&pageSize=" + pageSize+ "&&store.barcode=" + BarcodeId+"&&store.boxCode="+codeId+"&&store.productName="+productName+"&&store.inTime1="+inTime1Id+"&&store.inTime2="+inTime2Id+"&&store.classId="+classId+"&&inMan="+inMan;
		}
	}
	function deleteIn() {
		var value = "";
		var count = 0;
		/* var dateId = document.getElementById("dateId").value; */
	    var codeId = document.getElementById("codeId").value; 
		var BarcodeId = document.getElementById("BarcodeId").value;
	    var productName = document.getElementById("productName").value;
	    var inTime1Id = document.getElementById("inTime1Id").value;
	    var inTime2Id = document.getElementById("inTime2Id").value;
	    var classId = document.getElementById("classId").value;
		var pageSize=document.getElementById("pageSize").value;
        var pageNo=document.getElementById("pageNo").value;
		var box = document.getElementsByName("ids");
	    var inMan = document.getElementById("inMan").value;
		for ( var i = 0; i < box.length; i++) {
			if (box[i].checked) { //判断复选框是否选中   
				value = value + box[i].value + ",";
				count = count + 1;
			}
		}

		if (count == 0) {
			alert("请至少选择一个选项！");
		} else {
			if (window.confirm('你确定要删除吗？')) {
				location.href = "/TyreProject/store/deleteIn?ids=" + value+"&&flag=3&&pageNo=" + pageNo+ "&&pageSize=" + pageSize+ "&&store.barcode=" + BarcodeId+"&&store.boxCode="+codeId+"&&store.productName="+productName+"&&store.inTime1="+inTime1Id+"&&store.inTime2="+inTime2Id+"&&store.classId="+classId+"&&inMan="+inMan;
			}
		}
	}
	function exportIn() {
	   /*  var dateId = document.getElementById("dateId").value; */
	    var recordCount = document.getElementById("recordCount").value;
 	    if(recordCount>20000){
	       alert("导出条数不能大于2万条！！");
	    }else{
	    var codeId = document.getElementById("codeId").value; 
		var BarcodeId = document.getElementById("BarcodeId").value;
	    var productName = document.getElementById("productName").value;
	    var inTime1Id = document.getElementById("inTime1Id").value;
	    var inTime2Id = document.getElementById("inTime2Id").value;
	    var classId = document.getElementById("classId").value;
	    var inMan = document.getElementById("inMan").value;
		location.href = "/TyreProject/store/exportExcel?flag=3&&store.barcode=" + BarcodeId+"&&store.boxCode="+codeId+"&&store.productName="+productName+"&&store.inTime1="+inTime1Id+"&&store.inTime2="+inTime2Id+"&&store.classId="+classId+"&&inMan="+inMan;
	    }
	 }
</script>

</head>

<body>
	${success}
	<s:form action="queryStore" namespace="/store">
		<s:hidden name="flag" value="3" />
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
															class="dqwz"><b>当前位置：</b> 轮胎库存记录表</span></td>
														<td width="20" height="42"><img
															src="<%=request.getContextPath()%>/jsp/images/xxnr_18.jpg"
															width="20" height="42"></td>
													</tr>
													<tr>
														<td width="20"
															background="<%=request.getContextPath()%>/jsp/images/xxnr_25.jpg"><img
															src="<%=request.getContextPath()%>/jsp/images/xxnr_25.jpg">
														</td>
														<td><br>
															<table width="100%" border="0" cellpadding="0"
																cellspacing="1">
																<tr class="query_two">
																	<td>条形码：<input type="text" name="store.barcode"
																		value="${store.barcode}" id="BarcodeId"
																		style="width: 100px;">
																	</td>
																	<td>规格型号：<input type="text"
																		name="store.productName" value="${store.productName}"
																		id="productName" style="width: 100px;"></td>
																	<%-- <td>&nbsp;入库日期： <input type="text"
																		name="store.inDate" id="dateId"
																		onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
																		class="Wdate" style="width:110px"
																		value="${store.inDate}" /></td> --%>
																	<td colspan="2">&nbsp;入库时间： <input type="text"
																		name="store.inTime1" id="inTime1Id"
																		onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
																		class="Wdate" style="width:150px"
																		value="${store.inTime1}" /> 至 <input type="text"
																		name="store.inTime2" id="inTime2Id"
																		onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
																		class="Wdate" style="width:150px"
																		value="${store.inTime2}" />
																	</td>

																</tr>
																<tr class="query_one">
																	<td>入库笼框：<input type="text" name="store.boxCode"
																		value="${store.boxCode}" id="codeId"
																		style="width: 100px;"></td>
																	<td>班次： <select name="store.classId"
																		style="width:80" id="classId">
																			<s:if test="0==store.classId">
																				<option value=0 selected></option>
																			</s:if>
																			<s:else>
																				<option value=0></option>
																			</s:else>
																			<s:if test="1==store.classId">
																				<option value=1 selected>甲班</option>
																			</s:if>
																			<s:else>
																				<option value=1>甲班</option>
																			</s:else>
																			<s:if test="2==store.classId">
																				<option value=2 selected>乙班</option>
																			</s:if>
																			<s:else>
																				<option value=2>乙班</option>
																			</s:else>
																			<s:if test="3==store.classId">
																				<option value=3 selected>丙班</option>
																			</s:if>
																			<s:else>
																				<option value=3>丙班</option>
																			</s:else>
																	</select></td>
																	<td>&nbsp;入库人：<input type="text"
																		name="store.inMan" value="${store.inMan}"
																		id="inMan" style="width: 100px;"></td>
																	<td>&nbsp;&nbsp;<input style="color:white"
																		type="submit" id="" value="查询" class="input_submit">
																		&nbsp; <input style="color:white" type="button"
																		value="返回" class="input_ok" onclick="back();">&nbsp;
																		<input style="color:white" type="button" value="删除"
																		class="input_ok" onclick="deleteIn();">&nbsp;
																		<input style="color:white" type="button"
																		value="导出Excel" class="input_ok" onclick="exportIn();">
																	</td>
																</tr>
															</table> <br>
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
																		<th style="text-align: center;color:black">序号</th>
																		<th style="color:black">条形码</th>
																		<th style="color:black">入库笼框</th>
																		<th style="color:black">规格型号</th>
																		<th style="color:black">入库时间</th>
																		<th style="color:black">入库人</th>
																		<th style="color:black">入库班次</th>
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
																						value="#store.getBarcode()" /> </a></td>
																			<td><s:property value="#store.getBoxCode()" />
																			</td>
																			<td><s:property
																					value="#store.getProduct().getFName()" />
																			</td>
																			<td><s:property value="#store.getInTime()" />
																			</td>
																			<td><s:property value="#store.getInMan()" />
																			</td>
																			<td><s:property value="#store.getInClass()" />
																			</td>
																		</tr>
																	</s:iterator>
																</tbody>
															</table>
															<div>
																<br></br>
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