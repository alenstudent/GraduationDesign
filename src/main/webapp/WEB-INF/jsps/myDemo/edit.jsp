
<%@page pageEncoding="utf-8"%>

<%
	String title = "标题";
%>
<%@include file="../includeHeader.jsp"%>
<body>
	<c:choose>
		<c:when test="${returnModel.code != 200 }">
			<div class="container">
				<div align="center">
					<h1>网络繁忙，请返回重试</h1>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="container">
				<div align="center">
					<h1>标题</h1>
				</div>
		
		
				<form class="form-horizontal myDemoForm" role="form">
					<input type="hidden" class="myDemoInput" value="${returnModel.body.id }" id="id" />
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control myDemoInput" id="name"
								placeholder="请输入姓名" value="${returnModel.body.name}" />
						</div>
					</div>
					<div class="form-group">
						<label for="age" class="col-sm-2 control-label">年龄</label>
						<div class="col-sm-10">
							<input type="text" class="form-control myDemoInput" id="age"
								placeholder="请输入年龄" value="${returnModel.body.age}" />
						</div>
					</div>
					<div class="form-group">
						<label for="salary" class="col-sm-2 control-label">薪水</label>
						<div class="col-sm-10">
							<input type="text" class="form-control myDemoInput" id="salary"
								placeholder="请输入薪水" value="${returnModel.body.salary}" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="button" class="btn btn-default myDemoEditBtn" value="修改" />
						</div>
					</div>
				</form>
			</div>
		</c:otherwise>
	</c:choose>
</body>
<%@include file="../includeJS.jsp"%>
<script type="text/javascript">
$(function(){
	$("input.myDemoEditBtn").click(editMyDemo);
});

var canEdit = true;
function editMyDemo() {
	if (!canEdit) return;
	var button = $(this);
	canEdit = false;
	$(button).addClass("disabled");
	var param=$("form.myDemoForm input.myDemoInput").map(function(){
		 return ($(this).attr("id")+'='+$(this).val());
		}).get().join("&") ;
	AjaxUtil.post("/myDemo/update", param, function(data){
		debug(data);
		if (data.returnModel.code == 200) {			
			alert("修改成功");
		} else {
			alert(data.returnModel.msg);
		}
		$(button).removeClass("disabled");
		canEdit = true;
	});
}
</script>


