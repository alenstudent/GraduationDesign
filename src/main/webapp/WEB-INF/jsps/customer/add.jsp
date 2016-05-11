
<%@page pageEncoding="utf-8"%>

<%
	String title = "添加客户信息";
%>
<%@include file="../includeHeader.jsp"%>
<body>

	<div class="container">
		<div align="center">
			<h1>添加客户信息</h1>
		</div>


		<form class="form-horizontal customerForm" role="form">
			<div class="form-group">
				<label for="cusName" class="col-sm-2 control-label">客户名称</label>
				<div class="col-sm-10">
					<input type="text" class="form-control customerInput" id="cusName"
						placeholder="请输入客户名称">
				</div>
			</div>
			<div class="form-group">
				<label for="cusAddress" class="col-sm-2 control-label">联系地址</label>
				<div class="col-sm-10">
					<input type="text" class="form-control customerInput" id="cusAddress"
						placeholder="请输入联系地址">
				</div>
			</div>
			<div class="form-group">
				<label for="cusZipCode" class="col-sm-2 control-label">邮编</label>
				<div class="col-sm-10">
					<input type="text" class="form-control customerInput" id="cusZipCode"
						placeholder="请输入邮编">
				</div>
			</div>
			<div class="form-group">
				<label for="cusPhone" class="col-sm-2 control-label">联系电话</label>
				<div class="col-sm-10">
					<input type="text" class="form-control customerInput" id="cusPhone"
						placeholder="请输入联系电话">
				</div>
			</div>
			<!-- <div class="form-group">
				<label for="cusBelongTo" class="col-sm-2 control-label">联系人员</label>
				<div class="col-sm-10">
					<input type="text" class="form-control customerInput" id="cusBelongTo"
						placeholder="请输入联系人员">
				</div>
			</div> -->
			<div class="form-group">
				<label for="cusTaxNum" class="col-sm-2 control-label">纳税号码</label>
				<div class="col-sm-10">
					<input type="text" class="form-control customerInput" id="cusTaxNum"
						placeholder="请输入纳税号码">
				</div>
			</div>
			<div class="form-group">
				<label for="cusBankAccount" class="col-sm-2 control-label">开户银行账号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control customerInput" id="cusBankAccount"
						placeholder="请输入开户银行账号">
				</div>
			</div>
			<div class="form-group">
				<label for="cusBankName" class="col-sm-2 control-label">开户银行名称</label>
				<div class="col-sm-10">
					<input type="text" class="form-control customerInput" id="cusBankName"
						placeholder="请输入开户银行名称">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" class="btn btn-default customerAddBtn" value="添加" />
				</div>
			</div>
		</form>
	</div>
</body>
<%@include file="../includeJS.jsp"%>
<script type="text/javascript">
$(function(){
	$("input.customerAddBtn").click(addCustomer);
});

var canAdd = true;
function addCustomer() {
	if (!canAdd) return;
	var button = $(this);
	canAdd = false;
	$(button).addClass("disabled");
	var param=$("form.customerForm input.customerInput").map(function(){
		 return ($(this).attr("id")+'='+$(this).val());
		}).get().join("&") ;
	AjaxUtil.post("/customer/insert", param, function(data){
		debug(data);
		if (data.returnModel.code == 200) {
			alert("添加成功");			
		} else {
			alert(data.returnModel.msg);
		}
		$(button).removeClass("disabled");
		canAdd = true;
	}, function() {
		$(button).removeClass("disabled");
		canEdit = true;
	});
}
</script>


