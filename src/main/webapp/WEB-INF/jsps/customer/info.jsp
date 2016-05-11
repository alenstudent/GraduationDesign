
<%@page pageEncoding="utf-8"%>

<%
	String title = "客户信息详情";
%>
<%@include file="../includeHeader.jsp"%>
<body>

	<div class="container">
		<div align="center">
			<h1>${returnModel.body.cusName} 详情</h1>
		</div>
		<form class="form-horizontal customerForm" role="form">
			<div class="form-group">
				<label for="cusName" class="col-sm-2 control-label">客户名称</label>
				<div class="col-sm-10">
					<input type="text" disabled class="form-control customerInput" id="cusName"
						placeholder="请输入客户名称" value="${returnModel.body.cusName}">
				</div>
			</div>
			<div class="form-group">
				<label for="cusAddress" class="col-sm-2 control-label">联系地址</label>
				<div class="col-sm-10">
					<input type="text" disabled class="form-control customerInput" id="cusAddress"
						placeholder="请输入联系地址" value="${returnModel.body.cusAddress}">
				</div>
			</div>
			<div class="form-group">
				<label for="cusZipCode" class="col-sm-2 control-label">邮编</label>
				<div class="col-sm-10">
					<input type="text" disabled class="form-control customerInput" id="cusZipCode"
						placeholder="请输入邮编" value="${returnModel.body.cusZipCode}">
				</div>
			</div>
			<div class="form-group">
				<label for="cusPhone" class="col-sm-2 control-label">联系电话</label>
				<div class="col-sm-10">
					<input type="text" disabled class="form-control customerInput" id="cusPhone"
						placeholder="请输入联系电话" value="${returnModel.body.cusPhone}">
				</div>
			</div>
			<div class="form-group hidden">
				<label for="cusBelongTo" class="col-sm-2 control-label">联系人员</label>
				<div class="col-sm-10">
					<input type="text" disabled class="form-control customerInput" id="cusBelongTo"
						placeholder="请输入联系人员" value="${returnModel.body.cusBelongTo}">
				</div>
			</div>
			<div class="form-group">
				<label for="cusTaxNum" class="col-sm-2 control-label">纳税号码</label>
				<div class="col-sm-10">
					<input type="text" disabled class="form-control customerInput" id="cusTaxNum"
						placeholder="请输入纳税号码" value="${returnModel.body.cusTaxNum}">
				</div>
			</div>
			<div class="form-group">
				<label for="cusBankAccount" class="col-sm-2 control-label">开户银行账号</label>
				<div class="col-sm-10">
					<input type="text" disabled class="form-control customerInput" id="cusBankAccount"
						placeholder="请输入开户银行账号" value="${returnModel.body.cusBankAccount}">
				</div>
			</div>
			<div class="form-group">
				<label for="cusBankName" class="col-sm-2 control-label">开户银行名称</label>
				<div class="col-sm-10">
					<input type="text" disabled class="form-control customerInput" id="cusBankName"
						placeholder="请输入开户银行名称" value="${returnModel.body.cusBankName}">
				</div>
			</div>
		</form>
	</div>
</body>
<%@include file="../includeJS.jsp"%>

