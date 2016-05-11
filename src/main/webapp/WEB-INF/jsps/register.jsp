<%@page pageEncoding="utf-8"%>

<%
	String title = "用户注册";
%>
<%@include file="includeHeader.jsp"%>

<style>

.container {
	padding-top: 100px;
}
.panel {
	padding: 0;
}
</style>
<body>

	<div class="container">

		<div class="panel panel-primary col-md-8 col-md-offset-2">

			<div class="panel-heading" align="center">
				<h4>用户注册</h4>
			</div>
			<div class="panel-body">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-md-2 col-md-offset-2">用户名</label>
						<div class="col-md-6">
							<input type="text" name="userName" class="form-control" placeholder="请输入用户名"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-2 col-md-offset-2">密码</label>
						<div class="col-md-6">
							<input type="password" name="password" class="form-control" placeholder="请输入密码"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-2 col-md-offset-2">确认密码</label>
						<div class="col-md-6">
							<input type="password" name="confirmPassword" class="form-control" placeholder="请输入确认密码" 
								data-toggle="tooltip" title="两次密码不一致" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-2 col-md-offset-2">用户类型</label>
						<div class="col-md-6">
							<label class="radio-inline">
							  <input type="radio" name="userType" value="1" checked> 管理员
							</label>
							<label class="radio-inline">
							  <input type="radio" name="userType" value="2"> 销售人员
							</label>
						</div>
					</div>

					<input type="button"
						class="btn btn-warning btn-lg col-md-8 col-md-offset-2" value="提交" />
				</form>
			</div>
		</div>
	</div>
</body>
<%@include file="includeJS.jsp"%>
<script src="${context}/js/register.js" type="text/javascript"></script>


