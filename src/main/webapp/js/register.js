
$(function() {
	$("input[name=\"confirmPassword\"]").blur(confirmPasswordBlur);
	$("input[name=\"password\"]").blur(passwordBlur);
	$("input[name=\"confirmPassword\"]").focus(confirmPasswordFocus);
	$("input[name=\"password\"]").focus(passwordFocus);
	$("input[type=\"button\"").click(register);
});



/**
 * 登录
 */
function register() {
	if($("div.form-group").hasClass("has-error")) {
		return;
	}
	var userName = $("input[name='userName']").val();
	var password = $("input[name=\"password\"").val();
	var confirmPassword = $("input[name=\"confirmPassword\"").val();
	var userType = $("select").val();
	if (password != confirmPassword || password == "") {
		$("div.form-group:gt(0)").addClass("has-error");
		return;
	}
	
	
	AjaxUtil.post("/user/register/" + userName + "/" + hex_md5(password) + "/" + userType, {}, function(data) {
		debug(data);
		if (data.returnModel.code == 200) {
			alert("注册成功")
		} else {
			showTips(data.returnModel.msg);
		}
	}, function() {
		alert("网络繁忙，请重试");
	})
}


function passwordFocus() {
	confirmPasswordFocus();
}

function confirmPasswordFocus() {
	$("div.form-group:gt(0)").removeClass("has-error");
}

/**
 * 密码失焦
 */
function passwordBlur() {
	if ($("input[name=\"confirmPassword\"]").val() != "") {
		var password = $("input[name=\"password\"]").val();
		var confirmPassword = $("input[name=\"confirmPassword\"]").val();
		if (password != confirmPassword) {
			$("div.form-group:gt(0)").addClass("has-error");
		}
	}
}

/**
 * 确认密码失焦
 */
function confirmPasswordBlur() {
	if ($("input[name=\"password\"]").val() != "") {
		var password = $("input[name=\"password\"]").val();
		var confirmPassword = $("input[name=\"confirmPassword\"]").val();
		if (password != confirmPassword) {
			$("div.form-group:gt(0)").addClass("has-error")
		}
	}
}




