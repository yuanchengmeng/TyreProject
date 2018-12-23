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
	function getEmpItem() {
	 var nameId = document.getElementById("nameId").value;
	  var pageSize=document.getElementById("pageSize").value;
      var pageNo=document.getElementById("pageNo").value; 
	 location.href = "/TyreProject/manage/getEmpItem?pageNo="+pageNo+"&&pageSize="+pageSize+"&&nameId="+nameId;
	}
	function detailPage(id) {
	  var nameId = document.getElementById("nameId").value;
	  var pageSize=document.getElementById("pageSize").value;
      var pageNo=document.getElementById("pageNo").value;
		location.href = "/TyreProject/manage/getEmpById?flag=first"
				+ "&&pageSize="+pageSize+"&&pageNo="+pageNo+"&&emp.id="+id+"&&nameId="+nameId;
	}
	function modifyCheckBox() {
		var value = "";
		var count = 0;
	 	var nameId = document.getElementById("nameId").value; 
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
			location.href = "/TyreProject/manage/getEmpById?emp.id=" + value+"&&pageSize="+pageSize+"&&pageNo="+pageNo+"&&nameId="+nameId;
		} else {
			alert("请选择一个选项！");
		}
	}
	function deleteEmp() {
		var value = "";
		var count = 0;
		var nameId = document.getElementById("nameId").value; 
		var pageSize=document.getElementById("pageSize").value;
        var pageNo=document.getElementById("pageNo").value;
		var box = document.getElementsByName("ids");
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
				location.href = "/TyreProject/manage/deleteEmp?ids=" + value+"&&pageSize="+pageSize+"&&pageNo="+pageNo+"&&nameId="+nameId;
			}
		}
	}
	function page(flag) {
	    var nameId = document.getElementById("nameId").value; 
		var pageSize = document.getElementById("pageSize").value;
		var pageCount = document.getElementById("pageCount").value;
		var pageNo = document.getElementById("pageNo").value;
		var gotopage = document.getElementById("gotopage").value;
		if ("first" == flag) {
			location.href = "/TyreProject/manage/queryEmp?pageNo=1"+"&&pageSize="+pageSize+"&&nameId="+nameId;
		} else if ("end" == flag) {
			location.href = "/TyreProject/manage/queryEmp?pageNo="+pageCount+"&&pageSize="+pageSize+"&&nameId="+nameId;
		} else if ("last" == flag) {
			location.href = "/TyreProject/manage/lastEmpPage?pageNo="+pageNo+"&&pageSize="+pageSize+"&&nameId="+nameId;
		} else if ("next" == flag) {
			location.href = "/TyreProject/manage/nextEmpPage?pageNo="+pageNo+"&&pageSize="+pageSize+"&&nameId="+nameId;
		} else if ("go" == flag) {
			if (gotopage == "" || gotopage > pageCount) {
				alert("请输入不大于" + pageCount + "的正整数");
			} else {
				location.href = "/TyreProject/manage/queryEmp?pageNo="+gotopage+"&&pageSize="+pageSize+"&&nameId="+nameId;
			}
		} else if ("selectPageSize" == flag) {
			location.href = "/TyreProject/manage/queryEmp?pageNo=1"+"&&pageSize="+pageSize+"&&nameId="+nameId;
		}
	}
	function empQuery(){
		var nameId = document.getElementById("nameId").value; 
	    var pageSize = document.getElementById("pageSize").value;
		var pageNo = document.getElementById("pageNo").value;
		location.href = "/TyreProject/manage/queryEmp?pageSize="+pageSize+"&&pageNo="+pageNo+"&&nameId="+nameId;
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
															width="20" height="42"></td>
														<td
															background="<%=request.getContextPath()%>/jsp/images/xxnr_10.jpg"></br>&nbsp;<span
															class="dqwz"><b>当前位置：</b>员工表记录</span>
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
														<td><br style="line-height:3px">员工名称:<input
															name="emp.ename" id="nameId" value="${emp.ename}"
															size="7"> &nbsp;<input style="color:white"
															type="button" id="" onclick="empQuery();" value="查询"
															class="input_submit"> &nbsp;<input
															style="color:white" type="button" value="新建"
															class="input_ok" onclick="getEmpItem();"> <input
															style="color:white" type="button" value="修改"
															class="input_ok" onclick="modifyCheckBox();"> <input
															style="color:white" type="button" value="删除"
															class="input_ok" onclick="deleteEmp();">
															<div>
																</br>
															</div>
															<table id="list" cellpadding="0" class="table"
																cellspacing="0">
																<thead>
																	<tr>
																		<th><div style="text-align:center;">
																				<input type="checkbox" name="selectall"
																					onclick="selectAll('ids',this);"
																					style="border:none">
																			</div></th>
																		<th style="color:black">员工名字</th>
																		<th style="color:black">部门</th>
 																		<th style="color:black">员工性别</th>
																		<th style="color:black">职位</th>
  																	</tr>
																</thead>
																<tbody>
																	<s:iterator value="empList" var="emp">
																		<tr class="even">
																			<td style="width:30px;text-align:center"><input
																				type="checkBox" name="ids"
																				value="<s:property
																					value='#emp.getId()' />"
																				style="border: none">
																			</td>
																			<td><a href="javascript:void(0)"
																				onclick="detailPage(<s:property value='#emp.getId()' />);"><s:property
																						value="#emp.getEname()" /> </a>
																			</td>
																			<td><s:property
																					value="#emp.getDept().getDeptname()" />
																			</td>
 																			<td><s:property value="#emp.getSex()" /></td>
																			<td><s:property value="#emp.getJob().getPosition()" /></td>
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