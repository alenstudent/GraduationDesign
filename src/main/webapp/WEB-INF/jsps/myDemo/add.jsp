
<%@page pageEncoding="utf-8"%>

<%
	String title = "标题";
%>
<%@include file="../includeHeader.jsp"%>
<body>

	<div class="container">
		<div align="center">
			<h1>标题</h1>
		</div>


		<form class="form-horizontal myDemoForm" role="form">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">姓名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control myDemoInput" id="name"
						placeholder="请输入姓名">
				</div>
			</div>
			<div class="form-group">
				<label for="age" class="col-sm-2 control-label">年龄</label>
				<div class="col-sm-10">
					<input type="text" class="form-control myDemoInput" id="age"
						placeholder="请输入年龄">
				</div>
			</div>
			<div class="form-group">
				<label for="salary" class="col-sm-2 control-label">薪水</label>
				<div class="col-sm-10">
					<input type="text" class="form-control myDemoInput" id="salary"
						placeholder="请输入薪水">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" class="btn btn-default myDemoAddBtn" value="添加" />
				</div>
			</div>
		</form>




<!-- 
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">客户名称</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="cusName"
						placeholder="请输入客户名称">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">联系地址</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="cusAddress"
						placeholder="请输入联系地址">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">邮政编码</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="cusZipCode"
						placeholder="请输入邮政编码">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">联系电话</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="cusPhone"
						placeholder="请输入联系电话">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">纳税号码</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="cusTaxNum"
						placeholder="请输入纳税号码">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">开户银行</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="cusBankAccount"
						placeholder="请输入开户银行">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">银行账号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="cusBankName"
						placeholder="请输入银行账号">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" class="btn btn-default" value="添加" />
				</div>
			</div>
		</form>
 -->
	</div>
</body>
<%@include file="../includeJS.jsp"%>
<script type="text/javascript">
$(function(){
	$("input.myDemoAddBtn").click(addMyDemo);
});

var canAdd = true;
function addMyDemo() {
	if (!canAdd) return;
	var button = $(this);
	canAdd = false;
	$(button).addClass("disabled");
	var param=$("form.myDemoForm input.myDemoInput").map(function(){
		 return ($(this).attr("id")+'='+$(this).val());
		}).get().join("&") ;
	AjaxUtil.post("/myDemo/insert", param, function(data){
		debug(data);
		if (data.returnModel.code == 200) {
			alert("添加成功");			
		} else {
			alert(data.returnModel.msg);
		}
		$(button).removeClass("disabled");
		canAdd = true;
		
	});
}
</script>


