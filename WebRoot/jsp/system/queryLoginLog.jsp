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
	function setPageSize(){
		var pageSize=document.getElementById("pageSize").value;
	    var userName=document.getElementById("userName").value;
		location.href="/TyreProject/system/queryLoginLog?page=1"+"&&pageSize="+pageSize+"&&loginLog.luser="+userName;
	}
	
	function gotopage(){
		var totalPage = document.getElementById("totalPage").value;
		var pageSize=document.getElementById("pageSize").value;
		var userName=document.getElementById("userName").value;
	    var gopage = document.getElementById("gopage").value;
	    if(gopage==""||gopage>totalPage){
           alert("请输入不大于"+totalPage+"的正整数");
        }else{
    	   location.href="/TyreProject/system/queryLoginLog?page="+gopage+"&&pageSize="+pageSize+"&&loginLog.luser="+userName;
        }
	}
</script>

</head>

<body>
	<s:form id="" action="queryLoginLog" namespace="/system" theme="simple">
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
															class="dqwz"><b>当前位置：</b>登录信息</span></td>
														<td width="20" height="42"><img
															src="<%=path%>/jsp/images/xxnr_18.jpg" width="20"
															height="42"></td>
													</tr>
													<tr>
														<td width="20"
															background="<%=path%>/jsp/images/xxnr_25.jpg"><img
															src="<%=path%>/jsp/images/xxnr_25.jpg">
														</td>
														<td><br style="line-height:3px"> &nbsp; 登陆人：<input
															type="text" name="loginLog.luser" value="${loginLog.luser }" id="userName" size="8">&nbsp; <input
															style="color:white" type="submit" value="查询"
															class="input_submit"> 
															
															<div>
																</br>
															</div>
															<table id="list" cellpadding="0" class="table"
																cellspacing="0">
																<thead>
																	<tr>
																		<th style="color:black">登录人</th>
																		<th style="color:black">登录时间</th>
																		<th style="color:black">登录IP</th>
																		<th style="color:black">登录端</th>
																	</tr>
																</thead>
																<tbody>
																	<s:iterator value="loginLogList" id="loginLog">
																		<tr class="even">
																			<td><s:property value="#loginLog.luser" /></td>
																			<td><s:property value="#loginLog.logintime" /></td>
																			<td><s:property value="#loginLog.loginip" /></td>
																			<td><s:property value="#loginLog.address" /></td>
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
																					href="queryLoginLog.action?page=1&&pageSize=<s:property value="%{pageSize}"/>"><span
																					class="input_href">首页</span> </a>
																				<a style="color:white"
																					href="queryLoginLog.action?page=<s:property value="%{currentPage-1}"/>&&pageSize=<s:property value="%{pageSize}"/>"><span
																					class="input_href">上页</span> </a>
																			</s:else> <s:if
																				test="%{currentPage != totalPage && totalPage !=0}">
																				<a style="color:white"
																					href="queryLoginLog.action?page=<s:property value="%{currentPage+1}"/>&&pageSize=<s:property value="%{pageSize}"/>"><span
																					class="input_href">下页</span> </a>
																				<a style="color:white"
																					href="queryLoginLog.action?page=<s:property value="totalPage"/>&&pageSize=<s:property value="%{pageSize}"/>"><span
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