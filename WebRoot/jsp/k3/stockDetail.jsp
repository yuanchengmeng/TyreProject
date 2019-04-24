<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ page isELIgnored="false"%>
<head>

<title>出库单据打印</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/jscript"
	src="<%=request.getContextPath()%>/js/jquery-1.3.2-vsdoc2.js"></script>
<script type="text/jscript"
	src="<%=request.getContextPath()%>/jsp/js/jquery.jqprint-0.3.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#print").click(function() {
			$("#first").jqprint();
		})
	});
	
	function back() {
		history.back(-1);
	}
</script>
</head>

<body>
	<s:form>
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="cTableBorder">
						<tr>
							<td align="left" class="navig">&nbsp;当前位置：出库单据打印</td>
							<td align="right" class="navig">
							<input type="button" id="print" value="打印" class="input_submit">&nbsp;
							<input type="button" value="返回" onclick="back();" class="input_ok"></td>
						</tr>
					</table>

					 <table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="table_blue">
						<tr align="center" valign="top">
							<td>
							<div id="first"> 
									<table width="100%" cellpadding="0" cellspacing="0" border="0">
										<tr>
											<td style="text-align:center;font-size:18;font-weight:900;font-family:宋体">兴鸿源轮胎成品库轮胎出库单</td>
										</tr>
									</table>
									<br>
									<table width="100%" cellpadding="0" cellspacing="0" border="0">
										<tr>
											<th style="text-align: left;color:black" width="25%">日期:</th>
											<th style="text-align: left;color:black" width="25%">保管:</th>
											<th style="text-align: left;color:black" width="25%">扫码:</th>
											<th style="text-align: left;color:black" width="25%">NO:</th>
										</tr>
									</table>
									<table width="100%" border="1px" bordercolor="#000000" cellspacing="0px" style="border-collapse:collapse;">
											<tr>
												<th style="text-align: center;color:black" width="10%">序号</th>
												<th style="text-align: center;color:black" width="30%">规格型号</th>
												<th style="text-align: center;color:black" width="20%">数量</th>
												<th style="text-align: center;color:black" width="20%">重量</th>
												<th style="text-align: center;color:black" width="20%">备注</th>
											</tr>
										<s:iterator value="detailList" var="detail" status="status">
											<tr>
												<td style="text-align: center;"><font size="2"><s:property value="#status.index+1" /></font></td>
												<td style="text-align: center;"><font size="2"><s:property value="#detail.getProduct().getFName()" /></font></td>
												<td style="text-align: center;"><font size="2"><s:property value="#detail.getFQty()" /></font></td>
												<td style="text-align: center;"></td>
												<td style="text-align: center;"></td>
											</tr>
										</s:iterator>
									</table>
								</div> </td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</s:form>
</body>

