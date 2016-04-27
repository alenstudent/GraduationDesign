<%@page pageEncoding="utf-8"%>
<% String title = "用户登录"; %>
<%@include file="includeHeader.jsp" %>
<body>

	<div class="container">
		<div align="center">
			<h1>用户登录</h1>		
		</div>
	
		<form class="form-horizontal" action="${context }/demo/add" method="post">
		
			<div class="form-group">
				<label class="control-label col-md-3 col-md-offset-3">用户名</label>
				<div class="col-md-3">
					<input type="text" name="userName" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3 col-md-offset-3">密码</label>
				<div class="col-md-3">
					<input type="text" name="password" class="form-control" />
				</div>
			</div>
			<input type="button" class="btn btn-default col-md-6 col-md-offset-3" value="登录"/>
		</form>
	</div>
</body>
<%@include file="includeJS.jsp" %>
<script src="${context }/js/login.js" type="text/javascript"></script>