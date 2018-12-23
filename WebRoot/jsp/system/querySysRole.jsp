<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../commons/taglib.jsp"%>
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
<link rel="Stylesheet" href="<%=path%>/jsp/css/listtable.css"
	type="text/css">
<link rel="stylesheet" href="<%=path%>/jsp/css/style.css"
	type="text/css">
<script type="text/javascript" src="<%=path%>/jsp/js/validate.js"></script>
<script type="text/javascript">
function add() {
    var pageSize=document.getElementById("pageSize").value;
    var sysRolename=document.getElementById("sysRolename").value;
    var pageNo=document.getElementById("pageNo").value;
	location.href = "/TyreProject/system/initSysRole?sysRolename="+sysRolename+"&&pageSize="+pageSize+"&&pageNo="+pageNo;
}
function detailPage(sysRoleId){
    //var page=document.getElementById("page").value;
    var pageSize=document.getElementById("pageSize").value;
    var sysRolename=document.getElementById("sysRolename").value;
    var pageNo=document.getElementById("pageNo").value;
    location.href="/TyreProject/system/getSysRoleById?sysRole.id="+sysRoleId+"&&sysRolename="+sysRolename+"&&pageSize="+pageSize+"&&pageNo="+pageNo; 
}
function modifyCheckBox() {
	var value = "";
	var count = 0;
	var pageSize=document.getElementById("pageSize").value;
    var sysRolename=document.getElementById("sysRolename").value;
    var pageNo=document.getElementById("pageNo").value;
	var box = document.getElementsByName("ids");
	//var page=document.getElementById("page").value;
	for ( var i = 0; i < box.length; i++) {
		if (box[i].checked) { //判断复选框是否选中   
			value = box[i].value;
			count = count + 1;
		}
	}
	if (count == 1) {
		location.href = "/TyreProject/system/getSysRoleById?flag=modify"+"&&sysRole.id="+value+"&&sysRolename="+sysRolename+"&&pageSize="+pageSize+"&&pageNo="+pageNo;
				
	} else {
		alert("请选择一个选项！");
	}
}

function deleteCheckBox() {
	var value = "";
	var count = 0;
	var pageSize=document.getElementById("pageSize").value;
    var sysRolename=document.getElementById("sysRolename").value;
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
			location.href = "/TyreProject/system/deleteSysRole?ids=" + value+"&&sysRolename="+sysRolename+"&&pageSize="+pageSize+"&&pageNo="+pageNo;;
		}
	}
}
 function querySysRole(){
  var sysRolename=document.getElementById("sysRolename").value;
  location.href="/TyreProject/system/findSysRole?flag=first"+"&&sysRolename="+sysRolename;
 }
 /* 分页 */
  function page(flag){
    var pageSize=document.getElementById("pageSize").value;
    var sysRolename=document.getElementById("sysRolename").value;
    var pageCount=document.getElementById("pageCount").value;
    var pageNo=document.getElementById("pageNo").value;
    var gotopage=document.getElementById("gotopage").value;	
    if("first"==flag){
        location.href="/TyreProject/system/findSysRole?pageNo=1"+"&&pageSize="+pageSize;
    }else if("end"==flag){
        location.href="/TyreProject/system/findSysRole?pageNo="+pageCount+"&&pageSize="+pageSize;
    }else if("last"==flag){
    	location.href="/TyreProject/system/lastSysRolePage?pageNo="+pageNo+"&&pageSize="+pageSize;
    }else if("next"==flag){
    	location.href="/TyreProject/system/nextSysRolePage?pageNo="+pageNo+"&&pageSize="+pageSize;
    }else if("go"==flag){
        if(gotopage==""||gotopage>pageCount){
           alert("请输入不大于"+pageCount+"的正整数");
        }else{
    	   location.href="/TyreProject/system/findSysRole?pageNo="+gotopage+"&&pageSize="+pageSize;
        }
    }else if("selectPageSize"==flag){
    	location.href="/TyreProject/system/findSysRole?pageNo=1"+"&&pageSize="+pageSize;
    }else{
    }	
}
</script>

</head>

<body>
	<s:form id="" action="findSysRole" namespace="/system" theme="simple">
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
															src="<%=path%>/jsp/images/xxnr_13.jpg" width="20"
															height="42"></td>
														<td background="<%=path%>/jsp/images/xxnr_10.jpg"></br>&nbsp;<span
															class="dqwz"><b>当前位置：</b>角色管理</span>
														</td>
														<td width="20" height="42"><img
															src="<%=path%>/jsp/images/xxnr_18.jpg" width="20"
															height="42">
														</td>
													</tr>
													<tr>
														<td width="20"
															background="<%=path%>/jsp/images/xxnr_25.jpg"><img
															src="<%=path%>/jsp/images/xxnr_25.jpg"></td>
														<td><br style="line-height:3px">&nbsp; 角色名称:<input
															type="text" id="sysRolename" value="${sysRole.name}"
															size="7"> <input style="color:white"
															type="button" value="查询" class="input_submit"
															onclick="querySysRole();"> <input
															style="color:white" type="button" value="新建"
															class="input_submit" onclick="add();"> <input
															style="color:white" type="button" value="修改"
															class="input_ok" onclick="modifyCheckBox();"> <input
															style="color:white" type="button" value="删除"
															class="input_ok" onclick="deleteCheckBox();">
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
																		<th style="color:black">角色名称</th>
																		<th style="color:black">角色描述</th>
																	</tr>
																</thead>
																<tbody>
																	<s:iterator value="sysRoleList" id="sysRole">
																		<tr class="even">
																			<td style="width:30px;text-align:center"><input
																				type="checkBox" name="ids"
																				value="<s:property
																					value='#sysRole.id' />"
																				style="border: none">
																			</td>
																			<td><a href="javascript:void(0)"
																				onclick="detailPage(<s:property
																					value='#sysRole.id' />);">
																					<s:property value="#sysRole.name" /> </a>
																			</td>
																			<td><s:property value="#sysRole.descr" /></td>
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
																		id="pageNo" value="${pageNo}" name="pageNo"> <s:property
																			value="pageNo" /> 页/共<input type="hidden"
																		id="pageCount" value="${pageCount}" name="pageCount">
																		<s:property value="pageCount" /> 页 每页显示 <select
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
																			<input type="button" onclick="page('end');" class="input_ok" value="末页">
																		</s:else>																	</td>
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