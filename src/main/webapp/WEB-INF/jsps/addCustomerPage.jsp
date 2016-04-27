<%@page pageEncoding="utf-8"%>

<%
	String title = "添加客户";
%>
<%@include file="includeHeader.jsp"%>
<body>

	<div class="container">
		<div align="center">
			<h1>添加客户</h1>
		</div>

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

	</div>
</body>
<%@include file="includeJS.jsp"%>
<script src="${context}/js/addCustomer.js" type="text/javascript"></script>


