window.onload = function() {
	
	if(document.getElementById("regist")){
		let $regist = document.getElementById("regist");
		$regist.onclick = function() {
			location.href = "/jsp/member/regist";
		}
	}
	
	if(document.getElementById("logout")){
		let $logout = document.getElementById("logout");
		$logout.onclick = function() {
			location.href = "/jsp/member/logout";
		}
	}
	
	if(document.getElementById("update")){
		let $update = document.getElementById("update");
		$update.onclick = function() {
			location.href = "/jsp/member/update";
		}
	}
	
	if(document.getElementById("delete")){
		let $update = document.getElementById("delete");
		$update.onclick = function() {
			location.href = "/jsp/member/delete";
		}
	}
	
	if(document.getElementById("writeNotice")){
		let $update = document.getElementById("writeNotice");
		$update.onclick = function() {
			location.href = "/jsp/notice/insert";
		}
	}
	
	
}









