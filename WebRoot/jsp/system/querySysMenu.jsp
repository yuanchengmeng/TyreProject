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
	function addsysMenu() {
		var pageSize=document.getElementById("pageSize").value;
	    var page=document.getElementById("page").value;
		var sysMenuname=document.getElementById("sysMenuname").value;
		location.href = "/TyreProject/system/initSysMenu?pageSize="+pageSize+"&&sysMenuname="+sysMenuname+"&&page="+page;
	}
	function detailPage(sysMenuId){
	    var pageSize=document.getElementById("pageSize").value;
	    var page=document.getElementById("page").value;		
	    var sysMenuname=document.getElementById("sysMenuname").value;
	    location.href="/TyreProject/system/getSysMenuById?sysMenu.id="+sysMenuId+"&&page="+page+"&&pageSize="+pageSize+"&&sysMenuname="+sysMenuname;  
	}
	function modifyCheckBox() {
		var value = "";
		var count = 0;
		var box = document.getElementsByName("ids");
		var page=document.getElementById("page").value;
		var pageSize=document.getElementById("pageSize").value;	  
	   var sysMenuname=document.getElementById("sysMenuname").value;
		for ( var i = 0; i < box.length; i++) {
			if (box[i].checked) { //判断复选框是否选中   
				value = box[i].value;
				count = count + 1;
			}
		}
		if (count == 1) {
			location.href = "/TyreProject/system/getSysMenuById?flag=modify&&sysMenu.id="
					+ value+"&&page="+page+"&&pageSize="+pageSize+"&&sysMenuname="+sysMenuname;
		} else {
			alert("请选择一个选项！");
		}
	}

	function deleteCheckBox() {
		var value = "";
		var count = 0;
		var box = document.getElementsByName("ids");
		var pageSize=document.getElementById("pageSize").value;	
	    var sysMenuname=document.getElementById("sysMenuname").value;
		
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
				location.href = "/TyreProject/system/deleteSysMenu?ids=" + value+"&&pageSize="+pageSize+"&&sysMenuname="+sysMenuname;
			}
		}
	}
	function setPageSize(){
		var pageSize=document.getElementById("pageSize").value;
	    var sysMenuname=document.getElementById("sysMenuname").value;
		location.href="/TyreProject/system/findSysMenu?page=1"+"&&pageSize="+pageSize+"&&sysMenuname="+sysMenuname;
	}
	function querysysMenu(){
	 var sysMenuname=document.getElementById("sysMenuname").value;
	 location.href="/TyreProject/system/findSysMenu?sysMenuname="+sysMenuname;
	}
	function gotopage(){
		var totalPage = document.getElementById("totalPage").value;
		var pageSize=document.getElementById("pageSize").value;
	    var sysMenuname=document.getElementById("sysMenuname").value;
	    var gopage = document.getElementById("gopage").value;
	    if(gopage==""||gopage>totalPage){
           alert("请输入不大于"+totalPage+"的正整数");
        }else{
    	   location.href="/TyreProject/system/findSysMenu?page="+gopage+"&&pageSize="+pageSize+"&&sysMenuname="+sysMenuname;
        }
	}
</script>

</head>

<body>
	<s:form id="" action="findSysMenu" namespace="/system" theme="simple">
		<input type="hidden" id="page" value="${page}"> 
		<input type="hidden" id="totalPage" value="${totalPage}"> 
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
															height="42">
														</td>
														<td background="<%=path%>/jsp/images/xxnr_10.jpg"></br>&nbsp;<span
															class="dqwz"><b>当前位置：</b>菜单管理</span></td>
														<td width="20" height="42"><img
															src="<%=path%>/jsp/images/xxnr_18.jpg" width="20"
															height="42"></td>
													</tr>
													<tr>
														<td width="20"
															background="<%=path%>/jsp/images/xxnr_25.jpg"><img
															src="<%=path%>/jsp/images/xxnr_25.jpg">
														</td>
														<td><br style="line-height:3px"> &nbsp; 菜单名称：<input
															type="text" name="sysMenu.name" id="sysMenuname"
															value="${sysMenu.name}" size="8"> <input
															style="color:white" type="button" value="查询"
															class="input_submit" onclick="querysysMenu();"> &nbsp;<input
															style="color:white" type="button" value="新建"
															class="input_submit" onclick="addsysMenu();"> <input
															style="color:white" type="button" value="修改"
															class="input_ok" onclick="modifyCheckBox();"> <input
															style="color:white" type="button" name="delete"
															value="删除" class="input_ok" onclick="deleteCheckBox();">
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
																			</div>
																		</th>
																		<th style="color:black">菜单名称</th>
																		<th style="color:black">地址</th>
																		<th style="color:black">父菜单</th>
																		<th style="color:black">标识</th>
																	</tr>
																</thead>
																<tbody>
																	<s:iterator value="sysMenuList" id="sysMenu">
																		<tr class="even">
																			<td style="width:30px;text-align:center"><input
																				type="checkBox" name="ids"
																				value="<s:property
																					value='#sysMenu.id' />"
																				style="border: none">
																			</td>
																			<td><a href="javascript:void(0)"
																				onclick="detailPage(<s:property
																					value='#sysMenu.id' />);">
																					<s:property value="#sysMenu.name" /> </a>
																			</td>
																			<td><s:property value="#sysMenu.page_url" /></td>
																			<td><s:property value="#sysMenu.parent_menu_id" />
																			</td>
																			<td><s:property value="#sysMenu.flag" /></td>
																		</tr>
																	</s:iterator>
																</tbody>
															</table> <br> <s:actionmessage cssStyle="color:red" />
															<div>
																</br>
															</div>
															<table width="98%" border="0" cellpadding="0"
																cellspacing="0">
																<s:iterator value="pageBean">
																	<tr>
																		<td width="50%" height="25" nowrap>共 <s:property
																				value="allRow" /> 条记录 第 <input type="hidden"
																			id="page" value="${page}"> <s:property
																				value="currentPage" /> 页/共<input type="hidden"
																			id="totalPage" value="${totalPage}"> <s:property
																				value="totalPage" /> 页 每页显示 <s:select
																				name="pageSize" id="pageSize" list="pageSizeList"
																				listKey="psize" listValue="psize"
																				onchange="setPageSize();"></s:select>条记录</td>
																	    <td width="50%" align="right" nowrap>跳转到 <input
																		id="gopage" type="text" size="3">&nbsp;<input
																		type="button" onclick="gotopage();" class="input_ok"
																		value="GO">
																		<s:if test="%{currentPage == 1}">
																				<span class="input_blank">首页</span>
																				<span class="input_blank">上页</span>
																         </s:if> <!-- currentPage为当前页 --> <s:else>
																				<a style="color:white"
																					href="findSysMenu.action?page=1&&pageSize=<s:property value="%{pageSize}"/>"><span
																					class="input_href">首页</span> </a>
																				<a style="color:white"
																					href="findSysMenu.action?page=<s:property value="%{currentPage-1}"/>&&pageSize=<s:property value="%{pageSize}"/>"><span
																					class="input_href">上页</span> </a>
																			</s:else> <s:if
																				test="%{currentPage != totalPage && totalPage !=0}">
																				<a style="color:white"
																					href="findSysMenu.action?page=<s:property value="%{currentPage+1}"/>&&pageSize=<s:property value="%{pageSize}"/>"><span
																					class="input_href">下页</span> </a>
																				<a style="color:white"
																					href="findSysMenu.action?page=<s:property value="totalPage"/>&&pageSize=<s:property value="%{pageSize}"/>"><span
																					class="input_href">末页</span> </a>
																			</s:if> <s:else>
																				<span class="input_blank">下页</span>
																				<span class="input_blank">末页</span>
																			</s:else>
																		</td>
																	</tr>
																</s:iterator>
															</table>
														</td>
														<td width="20"
															background="<%=path%>/jsp/images/xxnr_28.jpg">&nbsp;</td>
													</tr>
													<tr>
														<td><img src="<%=path%>/jsp/images/xxnr_30.jpg"
															width="20" height="12">
														</td>
														<td height="12"
															background="<%=path%>/jsp/images/xxnr_31.jpg"><img
															src="<%=path%>/jsp/images/xxnr_31.jpg" width="32"
															height="12"></td>
														<td><img src="<%=path%>/jsp/images/xxnr_33.jpg"
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