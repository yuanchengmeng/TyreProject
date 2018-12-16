<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ page isELIgnored="false"%>
<head>
<title>母胶使用记录</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function back() {
		var nameId = document.getElementById("nameId").value;
		var pageNo = document.getElementById("pageNo").value;
		var pageSize = document.getElementById("pageSize").value;
		location.href = "/TyreProject/store/queryHUser?pageNo=" + pageNo
				+ "&&pageSize=" + pageSize + "&&nameId=" + nameId;
	}
	function validate() {
		var mpdate = document.getElementById("mpdate").value;
		var record = document.getElementById("record").value;
		var barcode = document.getElementById("barcode").value;
		if (mpdate == "" || record == "" || barcode == "") {
			alert("必选项不能为空！！");
		} else {
			document.forms[0].submit();
		}
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
<style type="text/css">
font {
	font-size: 20px;
	font-family: '宋体 ';
	color: red;
}
</style>
</head>
<body>
	<s:form action="addHUser" namespace="/store" theme="simple">
		<s:hidden name="nameId" id="nameId" value="%{nameId}"></s:hidden>
		<s:hidden name="pageNo" id="pageNo" value="%{pageNo}"></s:hidden>
		<s:hidden name="pageSize" id="pageSize" value="%{pageSize}"></s:hidden>
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig"><br>位置：添加手持用户</td>
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
																<td width="20%">用户名</td>
																<td colspan="3"><s:textfield id="name" name="user1.name"/></td>
															</tr>
															<tr class="query_two">
																<td>密码</td>
																<td colspan="3"><s:textfield name="user1.password" id="password" />
																</td>
															</tr>
															<tr>
																<td colspan="4" class="td_page_right"><input
																	type="button" value="保存" onclick="checkTyreSize();" class="input_submit">
																	<input onclick="back();" type="button" value="返回"
																	class="input_ok"></td>
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

