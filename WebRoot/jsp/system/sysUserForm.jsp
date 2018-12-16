<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ page isELIgnored="false"%>
<head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<title>用户管理</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />
<script type="text/javascript">
	function back() {
		 history.go(-1);
	}
	function gettype(n) {
		if (n == 0) {
		} else {
			document.getElementById("emp").options.length = 0;
			var ajax = new XMLHttpRequest();
			ajax.onreadystatechange = function() {
				if (ajax.readyState == 4) {
					var str = ajax.responseText;
 					var obj = eval('(' + str + ')');
					for (i = 0; i < obj.length; i++) {
						document.getElementById("emp").add(
								new Option(obj[i].name, obj[i].id));
					}
				}
			}
			ajax.open('GET', "/TyreProject/jsp/manage/empList.jsp?id=" + n,
					true);
			ajax.send("");
		}

	}
	
	function validate() {
		var jobNo = document.getElementById("jobNo").value;
		var password = document.getElementById("pwd").value;
		if (jobNo == "" || password == "") {
			alert("工号或密码为空，请重新输入");
		} else {
		    var reg=/^\d{4}$/;
		    var isMatched=reg.test(jobNo);
		    if(isMatched==true){
		      document.forms[0].submit();
		    }else{
		      alert("工号输入格式不正确！！");
		    }
			
		}
	}
</script>
</head>

<body>${success}
	<s:form id="" action="editSysUser" namespace="/system" theme="simple">
		<s:hidden id="id" name="sysUser.id"></s:hidden>
		<s:hidden id="page" name="page" value="%{page}"></s:hidden>
		<s:hidden id="queryname" name="queryname" value="%{queryname}"></s:hidden>
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig">&nbsp; 位置：<c:if
									test="${sysUser.id == 0}">
																		添加
																	</c:if> <c:if test="${sysUser.id != 0 && sysUser.id != null}">
																		修改
																	</c:if>用户</td>
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
																<td width="20%">工号</td>
																<td colspan="3">
																<c:if test="${sysUser.id == 0}"> 
																    <s:textfield name="sysUser.jobNo" id="jobNo" />
																</c:if> 
																<c:if test="${sysUser.id != 0 && sysUser.id != null}">
																<s:hidden name="sysUser.jobNo" />
																	<s:textfield name="sysUser.jobNo" id="jobNo" disabled="true"/>
																</c:if>
																</td>
															</tr>
															<tr class="query_one">
																<td width="20%">姓名</td>
																<td colspan="3"><s:textfield name="sysUser.name"
																		id="name" required="true" /></td>
															</tr>
															<tr class="query_two">
 																<td>密码</td>
																<td colspan="3"><s:password name="sysUser.password"
																		showPassword="true" id="password" required="true" />
																</td>
															</tr>
															<tr class="query_one">
																<td>用户角色</td>
																<td colspan="3"><s:select name="sysUser.sysRole.id"
																		id="role" required="true" list="sysRoleList"
																		listKey="id" listValue="name" headerKey="0"
																		headerValue="请选择"></s:select></td>
															</tr>
															<tr class="query_two">
																<td>k3用户</td>
																<td colspan="3"><s:select name="sysUser.k3User.FItemID"
																		id="empID" required="true" list="k3UserList"
																		listKey="FItemID" listValue="FName" headerKey="0"
																		headerValue="请选择"></s:select></td>
															</tr>
															<tr>
																<td colspan="4" class="td_page_right"><c:if
																		test="${sysUser.id == 0}">
																		<s:submit method="addSysUser" value="保存"
																			cssClass="input_submit"></s:submit>
																	</c:if> <c:if test="${sysUser.id != 0 && sysUser.id != null}">
																		<s:submit method="modifySysUser" value="保存"
																			cssClass="input_submit"></s:submit>
																	</c:if> <input onclick="back();" type="button" value="返回"
																	class="input_ok">
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
				</td>
			</tr>
		</table>
	</s:form>
</body>

