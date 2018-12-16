	function tupian(idt) {
		var nametu = "xiaotu" + idt;
		var tp = document.getElementById(nametu);
		tp.src = "/TyreProject/jsp/images/ico05.gif";//图片ico04为白色的正方形

		for ( var i = 1; i < 400; i++) {

			var nametu2 = "xiaotu" + i;
			if (i != idt * 1) {
				var tp2 = document.getElementById('xiaotu' + i);
				if (tp2 != undefined) {
					tp2.src = "/TyreProject/jsp/images/ico06.gif";
				}//图片ico06为蓝色的正方形
			}
		}
	}
 
	function list(idstr) {
		var name1 = "subtree" + idstr;
		var name2 = "img" + idstr;
		var objectobj = document.all(name1);
		var imgobj = document.all(name2);

		//alert(imgobj);

		if (objectobj.style.display == "none") {
			for (i = 1; i < 400; i++) {
				var name3 = "img" + i;
				var name = "subtree" + i;
				var o = document.all(name);
				if (o != undefined) {
					o.style.display = "none";
					var image = document.all(name3);
					//alert(image);
					image.src = "/TyreProject/jsp/images/ico04.gif";
				}
			}
			objectobj.style.display = "";
			imgobj.src = "/TyreProject/jsp/images/ico03.gif";
		} else {
			objectobj.style.display = "none";
			imgobj.src = "/TyreProject/jsp/images/ico04.gif";
		}
	}