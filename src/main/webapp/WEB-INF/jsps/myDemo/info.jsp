
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
					<input type="text" disabled class="form-control myDemoInput" id="name"
						placeholder="请输入姓名" value="${returnModel.body.name}">
				</div>
			</div>
			<div class="form-group">
				<label for="age" class="col-sm-2 control-label">年龄</label>
				<div class="col-sm-10">
					<input type="text" disabled class="form-control myDemoInput" id="age"
						placeholder="请输入年龄" value="${returnModel.body.age}">
				</div>
			</div>
			<div class="form-group">
				<label for="salary" class="col-sm-2 control-label">薪水</label>
				<div class="col-sm-10">
					<input type="text" disabled class="form-control myDemoInput" id="salary"
						placeholder="请输入薪水" value="${returnModel.body.salary}">
				</div>
			</div>
		</form>
	</div>
</body>
<%@include file="../includeJS.jsp"%>

