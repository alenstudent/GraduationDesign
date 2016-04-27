var AjaxUtil = {};

AjaxUtil.get = function(url, param, success, error) {
	$.ajax({
		url: context + url,
		type: "GET",
		data: param,
		cache: false,
		success: function(data) {
			if (data.returnModel.code == 403) {
				window.location.href=context;
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
		error: error
	});
}


AjaxUtil.post = function(url, param, success, error) {
	$.ajax({
		url: context + url,
		type: "POST",
		data: param,
		cache: false,
		success: function(data) {
			if (data.returnModel.code == 403) {
				window.location.href=context;
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
		error: error
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

function showTips(tips) {
	BootstrapDialog.show({title: "提示", message: tips});
}
