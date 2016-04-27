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
		<div align="center">
			<a href="${context }/customer/add/page" class="btn btn-default addCustomer">添加客户</a>
		</div>

		<table class="table table-hover customerTable">
			<thead>
				<tr>
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


			</tbody>
		</table>

	</div>
	<div align="center">
		<ul class="pagination">
			<li><a href="#">&laquo;</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">&raquo;</a></li>
		</ul>
	</div>
</body>
<%@include file="includeJS.jsp"%>
<script src="${context}/js/salesPage.js" type="text/javascript"></script>


