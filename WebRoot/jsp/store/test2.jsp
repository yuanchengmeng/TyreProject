<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="../commons/taglib.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/style.css" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/jsp/css/jquery-ui.min.css" type="text/css" />
<%-- <script type="text/jscript" src="<%=request.getContextPath()%>/js/jquery-1.3.2-vsdoc2.js"></script>
<script type="text/jscript" src="<%=request.getContextPath()%>/jsp/js/jquery.jqprint-0.3.js"></script> --%>
<script type="text/jscript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<style type="text/css">
    body {
        height: 100%;
        overflow: auto;
        margin: 0;
    }
    #test_Div {
        position: fixed;
        _position: absolute;
        top: 50%;
        left: 50%;
        border: 2px solid #C0C0C0;/*弹出框边框样式*/
        background-color: #FFFFFF;/*弹出框背景色*/
        display:none;
    }
    * html {
        overflow: hidden;
        position: absolute;
    }
</style>
<script type="text/javascript">
        //弹出层
        function show_Win(div_Win, tr_Title, event) {
            var s_Width = document.documentElement.scrollWidth; //滚动 宽度
            var s_Height = document.documentElement.scrollHeight; //滚动 高度
            var js_Title = $(document.getElementById(tr_Title)); //标题
            js_Title.css("cursor", "move");
            //创建遮罩层
            $("<div id=\"div_Bg\"></div>").css({ "position": "absolute", "left": "0px", "right": "0px", "width": s_Width + "px", "height": s_Height + "px", "background-color": "#ffffff", "opacity": "0.6" }).prependTo("body");
            //获取弹出层
            var msgObj = $("#" + div_Win);
            msgObj.css('display', 'block'); //必须先弹出此行，否则msgObj[0].offsetHeight为0，因为"display":"none"时，offsetHeight无法取到数据；如果弹出框为table，则为'',如果为div，则为block，否则textbox长度无法充满td
            //y轴位置
            var js_Top = -parseInt(msgObj.height()) / 2 + "px";
            //x轴位置
            var js_Left = -parseInt(msgObj.width()) / 2 + "px";
            msgObj.css({ "margin-left": js_Left, "margin-top": js_Top });
            //使弹出层可移动
            msgObj.draggable({ handle: js_Title, scroll: false });
        }
</script>
</head>
<body>
	 <input type="button" value="测试弹出框" onclick="show_Win('div_Test', 'title', event)" />
        <div id="div_Test">
            <div id="title" style="border: 1px solid red;">标题</div>
            内容
        </div>
</body>

