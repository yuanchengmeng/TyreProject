<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/showModalDialog.js" defer="defer"></script>
 <style>
div#mbDIV
{
position: absolute;
top: 0px;
left: 0px;
width:expression(document.body.scrollWidth+"px");
height:expression(document.body.scrollHeight+"px");
background-color: #AAAAAA;
z-index: 10;
filter: alpha(opacity=80);opacity:0.8;
}
div#loginDIV
{
position: absolute;
width: 500px;
height: 180px;
background-color:white;
z-index: 20;
}
div#loginTopDIV
{
width: 100%;
height: 22px;
text-align:center;
background-color: #f29149;
cursor: move;
}
</style>
<script>
function btnAnswer()
{
    if(window.confirm("能告诉我你的名字吗?谢谢!"))
        alert("欢迎你");
    else
    {
        alert("你哇假打哈!");
    }
    closeDIV();
}

	function checkTyreSize() {
		var name = document.getElementById("name").value;
		var password = document.getElementById("password").value;
 		if (name == "" || password == "") {
			alert("填写完整用户名以及用户密码");
		} else { 
			 return document.forms[0].submit();
		} 
	}
</script>
</head>
<body>
	
<div id="mbDIV" style="display: none;"></div>
<div id="loginDIV" style="display: none; left: 300px; top: 200px">
<div id="loginTopDIV"><b>添加用户</b>（此处可拖动</div>
 <table cellspacing="0" cellpadding="0" width="100%" border="0">
    <tr>
            <td align="center" colspan="2">这里就对话框中的内容，且支持拖动功能，欢迎测试！ </td>
        </tr>
        <tr>
            <td align="center"><input onclick="btnAnswer();" type="button" value="回答问题"></td>
            <td align="center"><input onclick="closeDIV()" type="button" value="关闭"> </td>
        </tr>
    </table> 
    <%-- <s:form id="" action="editSysUser" namespace="/system" theme="simple"> --%>
    <table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<!-- <table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig"><br>位置：添加手持用户</td>
						</tr>
					</table> -->
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="table_blue">
						<tr align="center" valign="top">
							<td>
								<!-- <table width="100%" cellpadding="10" cellspacing="0">
									<tr>
										<td align="center">
											<table width="100%" border="0" cellpadding="0"
												cellspacing="0" bgcolor="#FFFFFF" class="table_blue">
												<tr>
													<td> -->
														<table width="100%" border="0" cellpadding="0"
															cellspacing="1">
															<tr class="query_two">
																<td width="20%">工号</td>
																<td><input type="text" name="sysUser.jobNo" id="jobNo"></td>
															</tr>
															<tr class="query_one">
																<td width="20%">用户名</td>
																<td><input type="text" name="sysUser.name" id="name"><%-- <s:textfield id="name" name="sysUser.name"/> --%></td>
															</tr>
															<tr class="query_two">
																<td>密码</td>
																<td><input type="password" name="sysUser.password" id="password"><%-- <s:textfield name="sysUser.password" id="password" /> --%>
																</td>
															</tr>
															<tr class="query_one">
																<td>用户角色</td>
																<td>
																<select name="sysUser.sysRole.id">
																		<option value=0>请选择</option>
																		<s:iterator var="sysRole" value="sysRoleList">
																			<option value=<s:property value="#sysRole.getId()"/>>
																				<s:property value="#sysRole.getName()" />
																			</option>
																		</s:iterator>
																</select>
																<%-- <s:select name="sysUser.sysRole.id"
																		id="role" required="true" list="sysRoleList"
																		listKey="id" listValue="name" headerKey="0"
																		headerValue="请选择"></s:select> --%></td>
															</tr>
															<tr class="query_two">
																<td>k3用户</td>
																<td>
																<select name="sysUser.k3User.FItemID">
																		<option value=0>请选择</option>
																		<s:iterator var="k3User" value="k3UserList">
																			<option value=<s:property value="#k3User.getFItemID()"/>>
																				<s:property value="#k3User.getFName()" />
																			</option>
																		</s:iterator>
																</select>
																<%-- <s:select name="sysUser.k3User.FItemID"
																		id="empID" required="true" list="k3UserList"
																		listKey="FItemID" listValue="FName" headerKey="0"
																		headerValue="请选择"></s:select> --%></td>
															</tr>
															<tr>
																<!-- <td colspan="4" class="td_page_right"><input
																	type="button" value="保存" onclick="checkTyreSize();" class="input_submit">
																	<input onclick="back();" type="button" value="返回"
																	class="input_ok"></td> -->
																	<td align="center">
																	<!--<s:submit method="addSysUser" value="保存" cssClass="input_submit"></s:submit>
																	 <input method="addSysUser" class="input_submit" type="button" value="提交"></td> -->
                                                                    <td align="center"><input onclick="closeDIV()" class="input_ok" type="button" value="关闭"> </td>
															</tr>
														</table>
													</td>
												</tr>
											</table></td>
									</tr>
								</table>
						<!-- 	</td>
						</tr>
					</table></td>
			</tr>
		</table> -->
		<%-- </s:form> --%>
</div>

</body>

