function trim(s) {
	return s.replace(/^\s*/, "").replace(/\s*$/, "");
}
function isEmpty(s) {
	if (trim(s).length == 0) {
		return true;
	} else {
		return false;
	}
}
function isDouble(str) {
	var doublePat = /^[-+]?d+(.d+)?$/;
	var matchArray = str.match(doublePat);
	if (matchArray != null) {
		return true;
	} else {
		return false;
	}
}// å¤æ­å½å¥æ°å¼åæ°æ®æ¯å¦æ­£ç¡®
function isFloat(fieldValue) {
	var isdot;
	isdot = 0;
	if (fieldValue == '') {
		return true;
	} else {
		tmp = fieldValue;
		for (j = 0; j < tmp.length; j++) {
			// alert(tmp.substring(j,j+1));
			if (isNaN(parseInt(tmp.substring(j, j + 1)))) {
				if (j == 0 && tmp.substring(j, j + 1) == "-") {
				} else if ((isdot == 0) && (tmp.substring(j, j + 1) == ".")) {
					isdot = 1;
				} else {
					return false;
				}
			}
		}
	}
	return true;
}
// å¤æ­å½å¥æ°å¼åæ°æ®æ¯å¦æ­£ç¡®
function isInt(fieldValue) {
	var isdot;
	isdot = 0;
	if (fieldValue == '') {
		return true;
	} else {
		tmp = fieldValue;
		for (j = 0; j < tmp.length; j++) {
			// alert(tmp.substring(j,j+1));
			if (isNaN(parseInt(tmp.substring(j, j + 1)))) {
				return false;
			}
		}
	}
	return true;
}
function validateDate(value) {
	if (isEmpty(value))
		return true;
	re = /^(0[1-9]|1[0-9]|2[0-9]|3[0-1])\/(0[1-9]|1[0-2])\/(19[0-9]{2}|20[0-9]{2})$/;
	/*æ¥ææ ¼å¼ dd/MM/YYYY å¶ä¸­å¹´ä»½å¨1900--2099å¹´ä¹é´*/
	if (value.match(re) != null)
		return true;
	else
		return false;
}
		function selectAll(checkboxName,check)
	{
			var checkrows=document.getElementsByName(checkboxName);
		
			for(var i=0;i<checkrows.length;i++)
			{
				checkrows[i].checked=check.checked;
			}
	}
	function highlightTableRows(tableId) {
    var previousClass = null;
    var table = document.getElementById(tableId); 
    var tbody = table.getElementsByTagName("tbody")[0];
    var rows;
    if (tbody == null) {
        rows = table.getElementsByTagName("tr");
    } else {
        rows = tbody.getElementsByTagName("tr");
    }
    // add event handlers so rows light up and are clickable
    for (i=0; i < rows.length; i++) {
        rows[i].onmouseover = function() { previousClass=this.className;this.className+=' over' };
        rows[i].onmouseout = function() { this.className=previousClass };

    }
}
	function selectAll(checkboxName,check)
	{
			var checkrows=document.getElementsByName(checkboxName);
		
			for(var i=0;i<checkrows.length;i++)
			{
				checkrows[i].checked=check.checked;
			}
	}
	
    function ismail(mail) 
    { 
      return(new RegExp(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/).test(mail)); 
    }
	function confirmDelete(){
		return confirm("确认删除吗？");
			
		} 
	
	function confirmListDelete(checkboxName)
	{
		var checkrows=document.getElementsByName(checkboxName);
		var candelete=false;
		for(var i=0;i<checkrows.length;i++)
		{
			if(checkrows[i].checked==true)
			{
				candelete=true;
				break;
			}
		}	
		if(!candelete)
		{
			// alert('请先选择数据，然后删除！');
			alert('Please select the data, and then delete!');
			return false;
		}
		return confirm("确认删除选择数据吗？");
	}
	
	function unselectAll(check)
	{
	        var handleEl=document.getElementById("selectall");
	        if(check.checked==false){
	            handleEl.checked=check.checked;
	        }	        
	}
	