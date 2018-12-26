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
	<s:form action="queryStoreAmount" namespace="/store">
		<s:hidden name="flag" value="0" />
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
															class="dqwz"><b>当前位置：</b> 库存数量统计</span></td>
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
																	<td width="30%">&nbsp;日期：<input type="text"
																		name="params.timeStart" id="timeStart"
																		onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
																		class="Wdate" style="width:150px"
																		value="${params.timeStart}" /> 至 <input type="text"
																		name="params.timeEnd" id="timeEnd"
																		onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
																		class="Wdate" style="width:150px"
																		value="${params.timeEnd}" />
																	</td>
																	<td width="20%">&nbsp;操作人：<input type="text"
																		name="params.person" id="person"
																		value="${params.person}" />
																	</td>
																	<td><input style="color:white"
																		type="button" onclick="IsNullDay();" value="查询" class="input_submit">&nbsp;&nbsp;
																	</td>
																</tr>
																<tr class="query_two">
																	<td colspan="3">&nbsp;【注：查询只针对入库/出库数量】</td>
																</tr>
															</table> <br>
														<br>
															<table id="list" cellpadding="0" class="table"
																cellspacing="0">
																<thead>
																	<tr>
																		<th style="text-align:center;font-size:15px;color:black;">实时库存</th>
																		<th style="text-align:center;font-size:15px;color:black;">入库数量</th>
																		<th style="text-align:center;font-size:15px;color:black;">出库数量</th>
																	</tr>
																</thead>
																<tbody>
																		<tr class="even">
																			<td style="text-align:center;font-style:normal;font-size:25px; font-weight:bold;">
																			<s:property value="storeStatisVo.getStoreAmount()" /></td>
																			<td style="text-align:center;font-style:normal;font-size:25px; font-weight:bold;">
																			<s:property value="storeStatisVo.getInStoreAmount()" /></td>
																			<td style="text-align:center;font-style:normal;font-size:25px; font-weight:bold;">
																			<s:property value="storeStatisVo.getOutStoreAmount()" /></td>
																		</tr>
																</tbody>
															</table>
															<div>
																<br></br>
															</div>
															 </td>
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