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
	    var timeStart = document.getElementById("timeStart").value;
	    var timeEnd = document.getElementById("timeEnd").value;
	    var classId = document.getElementById("classId").value;
		var pageSize = document.getElementById("pageSize").value;
		var pageCount = document.getElementById("pageCount").value;
		var pageNo = document.getElementById("pageNo").value;
		var gotopage = document.getElementById("gotopage").value;
		if ("first" == flag) {
		location.href = "/TyreProject/store/queryStoreReport?flag=3&&pageNo=1"
					+ "&&pageSize=" + pageSize+"&&storeReport.timeStart="+timeStart+"&&storeReport.timeEnd="+timeEnd+"&&classId="+classId;
		} else if ("end" == flag) {
		location.href = "/TyreProject/store/queryStoreReport?flag=3&&pageNo=" + pageCount
					+ "&&pageSize=" + pageSize+"&&storeReport.timeStart="+timeStart+"&&storeReport.timeEnd="+timeEnd+"&&classId="+classId;
		} else if ("last" == flag) {
		location.href = "/TyreProject/store/lastStoreReportPage?flag=3&&pageNo=" + pageNo
					+ "&&pageSize=" + pageSize+"&&storeReport.timeStart="+timeStart+"&&storeReport.timeEnd="+timeEnd+"&&classId="+classId;
		} else if ("next" == flag) {
		location.href = "/TyreProject/store/nextStoreReportPage?flag=3&&pageNo=" + pageNo
					+ "&&pageSize=" + pageSize+"&&storeReport.timeStart="+timeStart+"&&storeReport.timeEnd="+timeEnd+"&&classId="+classId;
		} else if ("go" == flag) {
		   if (parseInt(gotopage) <= parseInt(pageCount)){
				location.href = "/TyreProject/store/queryStoreReport?flag=3&&pageNo="
						+ gotopage + "&&pageSize=" + pageSize+"&&storeReport.timeStart="+timeStart+"&&storeReport.timeEnd="+timeEnd+"&&classId="+classId;
			} else {
			    alert("请输入不大于" + pageCount + "的正整数");
			}
		} else if ("selectPageSize" == flag) {
		location.href = "/TyreProject/store/queryStoreReport?flag=3&&pageNo=1"
					+ "&&pageSize=" + pageSize+"&&storeReport.timeStart="+timeStart+"&&storeReport.timeEnd="+timeEnd+"&&classId="+classId;
		}
	}
	 
	function exportIn() {
	    var timeStart = document.getElementById("timeStart").value;
	    var timeEnd = document.getElementById("timeEnd").value;
	    var classId = document.getElementById("classId").value;
		location.href = "/TyreProject/store/exportStoreReportExcel?flag=3&&storeReport.timeStart="+timeStart+"&&storeReport.timeEnd="+timeEnd+"&&classId="+classId;
	 }
	 
	 function IsNullDay(){
	    var timeStart = document.getElementById("timeStart").value;
	    var timeEnd = document.getElementById("timeEnd").value;
		if(timeStart == "" || timeEnd == ""){
		   alert("查询时间不能为空！！");
		}else{
			document.forms[0].submit(); 
		}
	 }
</script>

</head>

<body>
	${success}
	<s:form action="queryStoreReport" namespace="/store">
		<s:hidden name="flag" value="3" />
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
															class="dqwz"><b>当前位置：</b> 轮胎入库统计</span></td>
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
																	<td width="50%">&nbsp;入库时间：<input type="text"
																		name="storeReport.timeStart" id="timeStart"
																		onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
																		class="Wdate" style="width:150px"
																		value="${storeReport.timeStart}" /> 至 <input type="text"
																		name="storeReport.timeEnd" id="timeEnd"
																		onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
																		class="Wdate" style="width:150px"
																		value="${storeReport.timeEnd}" />
																	</td>
																	<td>入库班次：<select id="classId" name="classId">
																					<s:iterator var="handClass" value="handClassList">
																						<s:if test="handClass.id==#classId">
																							<option value=<s:property value="#handClass.getId()" />
																								selected>
																								<s:property value="#handClass.getName()" />
																							</option>
																						</s:if>
																						<s:else>
																							<option value=<s:property value="#handClass.getId()" />>
																								<s:property value="#handClass.getName()" />
																							</option>
																						</s:else>
																					</s:iterator>
																			</select></td>
																	<td><input style="color:white"
																		type="button" onclick="IsNullDay();" value="查询" class="input_submit">&nbsp;&nbsp;
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
																		<th style="color:black">入库班次</th>
																		<th style="color:black">规格型号</th>
																		<th style="color:black">规格全名</th>
																		<th style="color:black">数量</th>
																		<th style="color:black">单位</th>
																		
																	</tr>
																</thead>
																<tbody>
																	<s:iterator value="storeReportList" var="storeReport"
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
																			<td><s:property value="#storeReport.getStoreClass()" /></td>
																			<td><s:property value="#storeReport.getProduct().getFModel()" /></td>
																			<td><s:property value="#storeReport.getProduct().getFName()" /></td>
																			<td><s:property value="#storeReport.getCollectCount()" /></td>
																			<td>条</td>
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