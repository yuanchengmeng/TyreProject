<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ page isELIgnored="false"%>
<head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.3.2-vsdoc2.js"></script>
<title>菜单管理</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />
<script type="text/javascript">
	window.onload=function(){
		setstyle();
	}
	function back() {	
		var sysMenuname=document.getElementById("sysMenuname").value;
		var page = document.getElementById("page").value;
		var pageSize=document.getElementById("pageSize").value;
		location.href = "/TyreProject/system/findSysMenu?page="+page+"&&pageSize="+pageSize+"&&sysMenuname="+sysMenuname;
	}
	function setstyle(){
		var flag = $("input[name='sysMenu.flag']:checked").val();
		var obj = document.getElementById("pmenu");
		var pmenu = document.getElementById("parent_menu_id");
		if("N" == flag){
			obj.style.display="table-row";
		}else{
			obj.style.display="none";
			pmenu.value = 0;
		}
	}
</script>
</head>

<body>
	<s:form id="" action="editSysMenu" namespace="/system" theme="simple">
	<s:hidden id="id" name="sysMenu.id"></s:hidden>
	<s:hidden id="page" name="page" value="%{page}"></s:hidden>
	<s:hidden id="sysMenuname" name="sysMenuname" value="%{sysMenuname}"></s:hidden>
	<s:hidden id="pageSize" name="pageSize" value="%{pageSize}"></s:hidden>
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig">&nbsp; 位置：<c:if test="${sysMenu.id == 0}">
																		添加
																	</c:if>
																	<c:if test="${sysMenu.id != 0 && sysMenu.id != null}">
																		修改
																	</c:if>菜单</td>
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
																<td width="20%">菜单名称</td>
																<td colspan="3"><s:textfield name="sysMenu.name" />
																</td>
															</tr>
															<tr class="query_two">
																<td width="20%">地址</td>
																<td colspan="3"><s:textfield
																		name="sysMenu.page_url" style="width:500" />
																</td>
															</tr>
															<tr class="query_one">
																<td width="20%">菜单类别</td>
																<td colspan="3">
																	<s:radio name="sysMenu.flag" list="#{'Y':'父菜单','N':'子菜单'}" onclick="setstyle();"></s:radio>
																</td>
															</tr>
															<tr class="query_two" id="pmenu" style="display:none">
																<td width="20%">父菜单</td>
																<td colspan="3">
																	<s:select name="sysMenu.parent_menu_id" id="parent_menu_id" required="true"
																		list="psysMenuList" listKey="id" listValue="name" headerKey="0" headerValue="请选择"></s:select>
																</td>
															</tr>
															<tr>
																<td colspan="4" class="td_page_right">
																<c:if test="${sysMenu.id == 0}">
																	<s:submit method="addSysMenu" value="保存" cssClass="input_submit"></s:submit>
																</c:if>
																<c:if test="${sysMenu.id != 0 && sysMenu.id != null}">
																	<s:submit method="modifySysMenu" value="保存" cssClass="input_submit"></s:submit>
																</c:if>
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

