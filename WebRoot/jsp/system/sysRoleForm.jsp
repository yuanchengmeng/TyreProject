<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	function back() {
	  var pageSize=document.getElementById("pageSize").value;
      var sysRolename=document.getElementById("sysRolename").value;
      var pageNo=document.getElementById("pageNo").value;
		location.href = "/TyreProject/system/findSysRole?sysRolename="+sysRolename+"&&pageSize="+pageSize+"&&pageNo="+pageNo;
	}
</script>
<head>
<link rel="stylesheet" href="<%=path%>/jsp/css/style.css"
	type="text/css" />
<link rel="Stylesheet" href="<%=path%>/jsp/css/listtable.css"
	type="text/css">
<link rel="stylesheet" href="<%=path%>/jsp/css/style.css"
	type="text/css">
<script type="text/javascript" src="<%=path%>/jsp/js/validate.js"></script>
<link rel="StyleSheet" href="<%=path%>/jsp/css/dtree.css"
	type="text/css" />

<script type="text/javascript" charset="utf-8"
	src="<%=path%>/jsp/js/dtree_0.js"></script>
<body>
	<s:form action="addSysRole" id="menuForm" method="post" namespace="/system" theme="simple">
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig">位置：添加角色 <input type="hidden"
								id="ids" name="ids"></td>
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
															<tr class="query_two">
																<td width="20%">角色名称</td>
																<td colspan="3">
																 <input type="hidden" name="pageNo" id="pageNo" value="${pageNo }">
																 <input type="hidden" name="pageSize" id="pageSize" value="${pageSize }">
																  <input type="hidden" name="sysRolename" id="sysRolename" value="${sysRolename}">
																<input type="text" id="roleName"
																	name="sysRole.name">
																</td>
															</tr>
															<tr class="query_one">
																<td>角色描述</td>
																<td colspan="3"><input type="text" id="roleDescr"
																	name="sysRole.descr">
																</td>
															</tr>
															<tr class="query_two">
																<td>角色权限</td>
																<td colspan="3">
																	<div class="dtree"
																		style="border: 0px solid #cccccc; background-color: #f3f3f3; padding: 5px; width: 90%;">
																		<p>
																			<a href="javascript: d.openAll();">打开全部</a> | <a
																				href="javascript: d.closeAll();">关闭全部</a>
																		</p>
																		<script language="javascript" charset="utf-8">
																			d = new dTree(
																					'd',
																					'.',
																					'menuForm');
																			d
																					.add(
																							'0',
																							'-1',
																							'全部菜单');
																			<c:forEach items="${sysMenuList}" var="sysMenu">
																			d
																					.add(
																							'${sysMenu.id}',
																							'${sysMenu.parent_menu_id}',
																							'${sysMenu.name}');
																			</c:forEach>

																			document
																					.write(d);
																		</script>

																		<script type="text/javascript">
																			function submitForm() {
																				var ids = "";
																				var form = document
																						.getElementById("menuForm");
																				for ( var i = 0; i < form.elements.length; i++) {
																					var element = form.elements[i];
																					if (element.name == "id"
																							&& element.type == 'checkbox') {
																						if (element.checked == true) {
																							ids = ids
																									+ element.value
																									+ ",";
																						}
																					}
																				}
																				document
																						.getElementById("ids").value = ids;
																				document.forms[0]
																						.submit();
																			}
																		</script>
																	</div>
																</td>
															</tr>

															<tr>
																<td colspan="4" class="td_page_right"><input
																	onclick="submitForm();" type="button" value="保存"
																	class="input_submit"> <input onclick="back();"
																	type="button" value="返回" class="input_ok"></td>
															</tr>
														</table></td>
												</tr>
											</table>
										</td>
									</tr>
								</table></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</s:form>
</body>

