<%@page pageEncoding="utf-8"%>

<%
	String title = "我的客户";
%>
<%@include file="includeHeader.jsp"%>
<body>

	<div class="container">
		<div align="center">
			<h1>客户列表</h1>
		</div>
		<div class="tool_div">
			<div style="float: left;">
				<input class="btn btn-warning" type="button" value="编辑" onclick="edit()" />
				<input class="btn btn-info" type="button" value="详情" onclick="info()" />
				<input class="btn btn-danger" type="button" value="删除" onclick="del()" />
			</div>
			<div style="float: right;">
				<a href="${context }/customer/add/page" class="btn btn-default addCustomer"><span class="glyphicon glyphicon-plus"></span></a>
			</div>
			<div style="clear: both;"></div>
		</div>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>客户名称</th>
					<th>联系地址</th>
					<th>邮政编码</th>
					<th>联系电话</th>
					<th>纳税号码</th>
					<th>开户银行</th>
					<th>银行账号</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${returnModel.body }" var="item">
					<tr id="${item.id }">
						<td><input type="checkbox"></td>
						<td>${item.cusName }</td>
						<td>${item.cusAddress }</td>
						<td>${item.cusZipCode }</td>
						<td>${item.cusPhone }</td>
						<td>${item.cusTaxNum }</td>
						<td>${item.cusBankAccount }</td>
						<td>${item.cusBankName }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div align="center">
		<ul class="pagination">
			<!-- <li><a href="#">&laquo;</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">&raquo;</a></li> -->
		</ul>
	</div>
	
	
</body>
<%@include file="includeJS.jsp"%>
<script type="text/javascript">
	var currentPage = ${returnModel.currentPage};
	var pageCount = ${returnModel.pageCount};
	$(function() {
		initPaginationBar()
		
	});

	function pageChange(currentPage) {
		alert("当前点击第" + currentPage + "页");
	}
	function edit() {
		alert("编辑");
	}
	function info() {
		alert("详情");
	}
	function del() {
		alert("删除");
	}
	
</script>

<script src="${context}/js/salesPage.js" type="text/javascript"></script>


