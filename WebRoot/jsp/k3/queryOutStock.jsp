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
	 
	function page(flag) {
	    var FBillNo = document.getElementById("FBillNo").value; 
		var pageSize = document.getElementById("pageSize").value;
		var pageCount = document.getElementById("pageCount").value;
		var pageNo = document.getElementById("pageNo").value;
		var gotopage = document.getElementById("gotopage").value;
		if ("first" == flag) {
			location.href = "/TyreProject/k3/queryOutStock?pageNo=1"+"&&pageSize="+pageSize+"&&vo.FBillNo="+FBillNo;
		} else if ("end" == flag) {
			location.href = "/TyreProject/k3/queryOutStock?pageNo="+pageCount+"&&pageSize="+pageSize+"&&vo.FBillNo="+FBillNo;
		} else if ("last" == flag) {
			location.href = "/TyreProject/k3/queryOutStock?pageNo="+(Number(pageNo)-1)+"&&pageSize="+pageSize+"&&vo.FBillNo="+FBillNo;
		} else if ("next" == flag) {
			location.href = "/TyreProject/k3/queryOutStock?pageNo="+(Number(pageNo)+1)+"&&pageSize="+pageSize+"&&vo.FBillNo="+FBillNo;
		} else if ("go" == flag) {
			if (gotopage == "" || gotopage > pageCount) {
				alert("请输入不大于" + pageCount + "的正整数");
			} else {
				location.href = "/TyreProject/k3/queryOutStock?pageNo="+gotopage+"&&pageSize="+pageSize+"&&vo.FBillNo="+FBillNo;
			}
		} else if ("selectPageSize" == flag) {
			location.href = "/TyreProject/k3/queryOutStock?pageNo=1"+"&&pageSize="+pageSize+"&&vo.FBillNo="+FBillNo;
		}
	}
 
 	function detailPage(id) {
	  	location.href = "/TyreProject/k3/getDetail?vo.FInterID="+(Number(id));
	}
</script>

</head>

<body>
	${success}
	<s:form action="queryOutStock" namespace="/k3">
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
															width="20" height="42"></td>
														<td
															background="<%=request.getContextPath()%>/jsp/images/xxnr_10.jpg"></br>&nbsp;<span
															class="dqwz"><b>当前位置：</b>出库单</span>
														</td>
														<td width="20" height="42"><img
															src="<%=request.getContextPath()%>/jsp/images/xxnr_18.jpg"
															width="20" height="42">
														</td>
													</tr>
													<tr>
														<td width="20"
															background="<%=request.getContextPath()%>/jsp/images/xxnr_25.jpg"><img
															src="<%=request.getContextPath()%>/jsp/images/xxnr_25.jpg">
														</td>
														<td><br style="line-height:3px"/>出库单号:<input
															name="vo.FBillNo" id="FBillNo" value="${emp.ename}"
															size="7"> &nbsp;<input style="color:white"
															type="submit" value="查询" class="input_submit"> &nbsp;
															<div>
																<br/>
															</div>
															<table id="list" cellpadding="0" class="table"
																cellspacing="0">
																<thead>
																	<tr>
																		<th style="text-align: center;color:black">序号</th>
																		<th style="color:black">出库单号</th>
 																		<th style="color:black">出库时间</th>
																		<th style="color:black">出库人</th>
  																	</tr>
																</thead>
																<tbody>
																	<s:iterator value="outStockList" var="outStock" status="status">
																		<tr class="even">
																			<td style="text-align: center;"><s:property
																					value="#status.index+1" />
																			</td>
																			<td>
																			<a href="javascript:void(0)"
																				onclick="detailPage(<s:property value='#outStock.getFInterID()' />);">
																					<s:property value="#outStock.getFBillNo()" /> </a>
																			</td>
																			<td><s:property
																					value="#outStock.getFDate()" />
																			</td>
 																			<td><s:property value="#outStock.getK3User().getFName()" /></td>
  																		</tr>
																	</s:iterator>
																</tbody>
															</table>
															<div>
																<br/>
															</div>
															<table width="98%" border="0" cellpadding="0"
																cellspacing="0">
																<tr>
																	<!--所有的变量都是从后台获取到的-->
																	<td width="50%" height="25" nowrap>共 <s:property
																			value="pageBean.getAllRow()" /> 条记录 第 <input type="hidden"
																		id="pageNo" value="${pageBean.currentPage}"> <s:property
																			value="pageBean.getCurrentPage()" /> 页/共<input type="hidden"
																		id="pageCount" value="${pageBean.totalPage}"> <s:property
																			value="pageBean.getTotalPage()" /> 页 每页显示 <select
																		onchange="page('selectPageSize');" name="pageSize"
																		style="width:80" id="pageSize">
																			<!--用于选择当前页有多少条记录的-->
																			<s:iterator var="page" value="pageBean.getList()">
																				<s:if test="pageBean.getPageSize()==#page.getPsize()">
																					<option
																						value=<s:property value="#page.getPsize()" />
																						selected>
																						<s:property value="#page.getPsize()" />
																					</option>
																				</s:if>
																				<s:else>
																					<option
																						value=<s:property value="#page.getPsize()" />>
																						<s:property value="#page.getPsize()" />
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
																		</s:else></td>
																</tr>
															</table>
														</td>
														<td width="20"
															background="<%=request.getContextPath()%>/jsp/images/xxnr_28.jpg">&nbsp;</td>
													</tr>
													<tr>
														<td><img
															src="<%=request.getContextPath()%>/jsp/images/xxnr_30.jpg"
															width="20" height="12"></td>
														<td height="12"
															background="<%=request.getContextPath()%>/jsp/images/xxnr_31.jpg"><img
															src="<%=request.getContextPath()%>/jsp/images/xxnr_31.jpg"
															width="32" height="12">
														</td>
														<td><img
															src="<%=request.getContextPath()%>/jsp/images/xxnr_33.jpg"
															width="20" height="12"></td>
													</tr>
												</tbody>
											</table>
										</div></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</s:form>
 </body>
</html>