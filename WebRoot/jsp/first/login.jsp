<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>仓储管理系统WM</title>
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/jsp/images/favicon.ico" />
<link href="<%=request.getContextPath()%>/jsp/css/login.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
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
	function KeyDown() {
		var asubmit = document.getElementById("asubmit");
		if (event.keyCode == 13) {
			event.returnValue = false;
			event.cancel = true;
			asubmit.click();
		}
	}
	function clean() {
		var name = document.getElementById("name").value = "";
		var password = document.getElementById("pwd").value = "";
	}
	function _change() {
		/*
		1. 得到img元素
		2. 修改其src为/day11_3/VerifyCodeServlet
		 */
		var imgEle = document.getElementById("img");
		imgEle.src = "/TyreProject/system/getImage?a=" + new Date().getTime();
	}
</script>

</head>
<body>
	<!--onload="getImage()"  -->
	${error}
	<form action="<%=request.getContextPath()%>/system/LoginSysUser" method="post">
		<div id="login">
			<div id="top">
				<div id="top_left">
					
				</div>
				<div id="top_center"></div>
			</div>

			<div id="center">
				<div id="center_left"></div>
 				<div id="center_middle">
					<div id="user">
						工 &nbsp;号:&nbsp;<input type="text" name="jobNo" id="jobNo"
							onkeydown="KeyDown();" />
					</div>
					<div id="password">
						密 &nbsp;码:&nbsp;<input type="password" name="password" id="pwd"
							onkeydown="KeyDown();" /><br />
					</div>
					<div id="btn">
						<a href="javascript:void(0)" id="asubmit" onclick="validate();">登录</a>
						<a href="javascript:void(0)" onClick="clean();">清空</a>
					</div>

				</div>
				<!-- <div id="center_right"></div> -->
			</div>
			<div id="down">
				<div id="down_left">
						<span>版本信息: 科迅仓储管理系统  v1.0</span>
				</div>
			</div>

		</div>
	</form>
</body>
</html>
