<%@page pageEncoding="utf-8"%>

<% String title = "用户注册"; %>
<%@include file="includeHeader.jsp" %>
<%-- <jsp:include page="includeHeader.jsp">
	<jsp:param value="title" name="用户注册"/>
</jsp:include> --%>

<body>

	<div class="container">
		<div align="center">
			<h1>用户注册</h1>		
		</div>
	
		<form class="form-horizontal" action=" method="post">
			<div class="form-group">
				<label class="control-label col-md-2 col-md-offset-4">用户名</label>
				<div class="col-md-2">
					<input type="text" name="userName" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-2 col-md-offset-4">密码</label>
				<div class="col-md-2">
					<input type="text" name="password" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-2 col-md-offset-4">确认密码</label>
				<div class="col-md-2">
					<input type="text" name="confirmPassword" class="form-control" data-toggle="tooltip" title="两次密码不一致"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-2 col-md-offset-4">用户类型</label>
				<div class="col-md-2">
					<select class="form-control userType">
						<option value="1">管理人员</option>
						<option value="2">销售人员</option>
					</select>
				</div>
			</div>
			
			<input type="button" class="btn btn-default col-md-4 col-md-offset-4" value="提交" />
		</form>
	</div>
</body>
	<%@include file="includeJS.jsp" %>
	<script src="${context}/js/register.js" type="text/javascript"></script>


