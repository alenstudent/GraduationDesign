<%@page pageEncoding="utf-8"%>
<%
	String title = "用户登录";
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

		<div class="panel panel-primary col-md-6 col-md-offset-3" align="center">
			<div class="panel-heading">
				<h4>用户登录</h4>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" action="${context }/demo/add"
					method="post">
					
					<div class="form-group">
						<div class="input-group col-md-8 col-md-offet-2">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span> 
							<input type="text" class="form-control" placeholder="请输入用户名" name="userName" />
						</div>
						
					</div>
					<div class="form-group">
						<div class="input-group col-md-8 col-md-offet-2">
							<span class="input-group-addon"><span class="glyphicon glyphicon-search"></span></span> 
							<input type="password" class="form-control" placeholder="请输入密码" name="password" />
						</div>
						
					</div>
					<div class="btn-group col-md-8 col-md-offset-2" role="group" aria-label="...">
					  <button type="button" class="btn btn-primary col-md-6 loginBtn">登录</button>
					  <a  class="btn btn-info col-md-6 registerBtn" href="${context }/user/register/page">注册</a>
					</div>
				</form>
			</div>
		</div>

	</div>
</body>
<%@include file="includeJS.jsp"%>
<script src="${context }/js/login.js" type="text/javascript"></script>