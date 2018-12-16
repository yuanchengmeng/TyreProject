function show(ele)
{
  eval(ele + ".style.display = ''");
}
function hidden(ele)
{
  eval(ele + ".style.display = 'none'");
}
function closeDIV()
{
    hidden("loginDIV");
    hidden("mbDIV");
}
function openDIV()
{
     show("loginDIV");
     show("mbDIV");
}
  var mbDIV = document.getElementById("mbDIV");;
  var loginDIV = document.getElementById("loginDIV");
  var loginTopDIV = document.getElementById("loginTopDIV");

/**
*这里写的是拖动信息
* */
    loginTopDIV.onmousedown = Down;
    var tHeight,lWidth;
    function Down(e)
    {
        var event = window.event || e;
        tHeight = event.clientY  - parseInt(loginDIV.style.top.replace(/px/,""));
        lWidth  = event.clientX - parseInt(loginDIV.style.left.replace(/px/,""));
        document.onmousemove = Move;
        document.onmouseup   = Up;
    }
    function Move(e) {
        var event = window.event || e;
        var top = event.clientY - tHeight;
        var left = event.clientX - lWidth;
        //判断 top 和 left 是否超出边界
        top = top < 0 ? 0 : top;
        top = top > document.body.offsetHeight - 150 ? document.body.offsetHeight - 150 : top;
        left = left < 0 ? 0 : left;
        left = left > document.body.offsetWidth - 300 ? document.body.offsetWidth - 300 : left;
        loginDIV.style.top  = top + "px";
        loginDIV.style.left = left +"px";
    }
    function Up() {
        document.onmousemove = null;
    }