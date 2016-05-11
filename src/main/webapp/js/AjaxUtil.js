var AjaxUtil = {};

AjaxUtil.get = function(url, param, success, error) {
	$.ajax({
		url: context + url,
		type: "GET",
		data: param,
		cache: false,
		success: function(data) {
			debug(data);
			if (data.returnModel.code == -1) {
				alert("请先进行登录");
				window.location.href=context + "/user/login/page";
			} else if (data.returnModel.code != 200) {
				alert(data.returnModel.msg);
			} else {
				success(data);				
			}
		},
        beforeSend: function(request) {
        	var accessToken = $.cookie("accessToken");
        	if (null != accessToken && accessToken != "") {        		
        		request.setRequestHeader("accessToken", accessToken);
        	}
        },
		dataType: "json",
		error: function() {
			alert("网络繁忙，请稍候再试");
			error();
		}
	});
}


AjaxUtil.post = function(url, param, success, error) {
	$.ajax({
		url: context + url,
		type: "POST",
		data: param,
		cache: false,
		success: function(data) {
			if (data.returnModel.code == -1) {
				alert("请先进行登录");
				window.location.href=context + "/user/login/page";
			} else if (data.returnModel.code != 200) {
				alert(data.returnModel.msg);
			} else {
				success(data);				
			}
		},
        beforeSend: function(request) {
        	var accessToken = $.cookie("accessToken");
        	if (null != accessToken && accessToken != "") {        		
        		request.setRequestHeader("accessToken", accessToken);
        	}
        },
		dataType: "json",
		error: function() {
			alert("网络繁忙，请稍候再试");
			error();
		}
	});
}

function debug(param) {
	console.log(param);
}

window.alert = function(msg) {
	BootstrapDialog.show({
		message: msg,
		title: "提示",
		buttons: [{
			label: "确定",
			action: function(dialog) {
				dialog.close();
			}
		}]
	});
}

function showTips(msg) {
	BootstrapDialog.show({title: "提示", message: msg});
}

window.confirm = function(msg, okFunc) {
	BootstrapDialog.show({
		message: msg,
		title: "提示",
		buttons: [{
			label: "确定",
			action: function(dialog) {
				okFunc();
				dialog.close();
			}
		},
		{
			label: "取消",
			action: function(dialog) {
				dialog.close();
			}
		}]
	});
}


window.open = function(url, param) {
	var id = new Date().getTime();
	var form = "<form target='_blank' action='" + context + "/" + url + "' id='" + id +"' method='POST' style='display: none;'>";
	for (var field in param) {
		form += "<input type='hidden' name='" + field + "' value='" + param[field] + "' />";
	}
//	<input type="text" name="id" value="1" />
		form += "</form>";
		$("body").append(form);
		$("#" + id).submit();
		$("#" + id).remove();
}



