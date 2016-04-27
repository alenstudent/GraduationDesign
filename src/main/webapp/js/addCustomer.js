$(function(){
	$("input[type='button']").click(addCustomer);
});

function addCustomer() {
	var param=$("form input[type='text']").map(function(){
		 return ($(this).attr("id")+'='+$(this).val());
		}).get().join("&") ;
	AjaxUtil.post("/customer/add", param, function(data){
		debug(data);
		alert("添加成功");
	}, function(){
		alert("网络异常，请稍候再试");
	});
}