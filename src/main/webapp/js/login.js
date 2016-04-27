$(function(){
	$("input[type=\"button\"]").click(login);
});

/**
 * 登录操作
 */
function login() {
	var userName = $("input[name=\"userName\"]").val();
	var password = $("input[name=\"password\"]").val();
	if (userName == "") {
		alert("请输入用户名");
		return;
	}
	if (password == "") {
		alert("请输入密码");
		return;
	}
	
	AjaxUtil.post("/user/login/" + userName + "/" + hex_md5(password), {}, function(data){
		debug(data);
		if (data.returnModel.code == 200) {
			var userType = data.returnModel.body.userType;
			if (userType == 1) { // 跳转到管理人员页面
				
			} else if (userType == 2) { // 跳转到销售人员页面
				window.location= context + "/user/sales/page";
			}
		} else {
			alert(data.returnModel.msg);
		}
		
	}, function(){
		alert("网络异常，请稍候重试");
		
	});
}